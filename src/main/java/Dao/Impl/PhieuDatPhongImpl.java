package Dao.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import Dao.PhieuDatPhongDao;
import entities.ChiTietDatPhongEntity;
import entities.ChiTietPhieuDatPhongEntity;
import entities.KhachHangEntity;
import entities.PhieuDatPhongEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PhieuDatPhongImpl extends UnicastRemoteObject implements PhieuDatPhongDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String persistenceUnitName = "quanliKaraoke_ver2 mssql";
	private EntityManager em;

	public PhieuDatPhongImpl() throws RemoteException {
		this.em = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
	}

	@Override
	public List<ChiTietPhieuDatPhongEntity> duyetChiTietPhieuDatPhongChuaThanhToan() throws RemoteException {

//		String query = "select ctpdp from ChiTietPhieuDatPhongEntity ctpdp join ctpdp.chiTietDatPhong ctdp join ctdp.chiTietHoaDon cthd where cthd.hoaDon is null";
//		return em.createQuery(query, ChiTietPhieuDatPhongEntity.class).getResultList();
//				
		String query = "SELECT CTPDP.MaChiTietPhieuDatPhong, CTPDP.MaPhieuDatPhong, CTPDP.MaChiTietDatPhong FROM ChiTietPhieuDatPhong CTPDP\r\n"
				+ "WHERE EXISTS (SELECT * FROM ChiTietDatPhong CTDP JOIN ChiTietHoaDon CTHD\r\n"
				+ "	ON CTDP.MaChiTietDatPhong = CTHD.MaChiTietDatPhong JOIN Phong P\r\n"
				+ "	ON CTDP.MaPhong = P.MaPhong\r\n"
				+ "	WHERE CTDP.MaChiTietDatPhong = CTPDP.MaChiTietDatPhong AND MaHoaDon IS NULL)";
		@SuppressWarnings("unchecked")
		List<Object[]> rs = em.createNativeQuery(query).getResultList();
		List<ChiTietPhieuDatPhongEntity> ds = new ArrayList<ChiTietPhieuDatPhongEntity>();
		for (Object[] objects : rs) {
			ChiTietPhieuDatPhongEntity ctpdp = new ChiTietPhieuDatPhongEntity();
			ctpdp.setMaChiTietPhieuDatPhong(objects[0].toString());
			String maPhieuDatPhong = objects[1].toString();
			PhieuDatPhongEntity pdp = em.find(PhieuDatPhongEntity.class, maPhieuDatPhong);
			ctpdp.setPhieuDatPhong(pdp);
			String maChiTietDatPhong = objects[2].toString();
			ChiTietDatPhongEntity ctdp = em.find(ChiTietDatPhongEntity.class, maChiTietDatPhong);
			ctpdp.setChiTietDatPhong(ctdp);
			ds.add(ctpdp);
		}
		return ds;
	}

	@Override
	public boolean themChiTietPhieuDatPhong(ChiTietPhieuDatPhongEntity chiTietPhieuDatPhongEntity)
			throws RemoteException {
		EntityTransaction tx = em.getTransaction();
		String query = "INSERT INTO ChiTietPhieuDatPhong (MaPhieuDatPhong, MaChiTietDatPhong) VALUES (?, ?)";
		try {
			tx.begin();
			boolean result = em.createNativeQuery(query)
					.setParameter(1, chiTietPhieuDatPhongEntity.getPhieuDatPhong().getMaPhieuDatPhong())
					.setParameter(2, chiTietPhieuDatPhongEntity.getChiTietDatPhong().getMaChiTietDatPhong())
					.executeUpdate() > 0;
			tx.commit();
			return result;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ChiTietPhieuDatPhongEntity timChiTietPhieuDatPhongTheoMa(String maChiTietPhieuDatPhong)
			throws RemoteException {
//		String query = "select ctpdp from ChiTietPhieuDatPhongEntity ctpdp where ctpdp.maChiTietPhieuDatPhong = :maChiTietPhieuDatPhong";
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			ChiTietPhieuDatPhongEntity ctpdp = em.find(ChiTietPhieuDatPhongEntity.class, maChiTietPhieuDatPhong);
			tx.commit();
			return ctpdp;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ChiTietPhieuDatPhongEntity> timChiTietPhieuDatPhongTheoSoPhongVaMa(int soPhong, String maPhieuDatPhong)
			throws RemoteException {
//		String query = "select ctpdp from ChiTietPhieuDatPhongEntity ctpdp join ctpdp.chiTietDatPhong ctdp join ctdp.chiTietHoaDon cthd join ctdp.phong p where ctdp.maChiTietDatPhong = ctpdp.chiTietDatPhong.maChiTietDatPhong and cthd.hoaDon is null and p.soPhong =:soPhong and ctpdp.phieuDatPhong.maPhieuDatPhong =:maPhieuDatPhong"; 
//		return em.createQuery(query, ChiTietPhieuDatPhongEntity.class).setParameter("soPhong", soPhong).setParameter("maPhieuDatPhong", maPhieuDatPhong).getResultList();

//		CTPDP.MaChiTietPhieuDatPhong, CTPDP.MaPhieuDatPhong, CTPDP.MaChiTietDatPhong
		StringBuilder query = new StringBuilder(String.format(
				"SELECT CTPDP.MaChiTietPhieuDatPhong, CTPDP.MaPhieuDatPhong, CTPDP.MaChiTietDatPhong FROM ChiTietPhieuDatPhong CTPDP\r\n"
						+ "WHERE MaPhieuDatPhong LIKE '%%%s%%' \r\n"
						+ "	AND EXISTS (SELECT * FROM ChiTietDatPhong CTDP JOIN ChiTietHoaDon CTHD\r\n"
						+ "		ON CTDP.MaChiTietDatPhong = CTHD.MaChiTietDatPhong JOIN Phong P\r\n"
						+ "		ON CTDP.MaPhong = P.MaPhong\r\n"
						+ "		WHERE CTDP.MaChiTietDatPhong = CTPDP.MaChiTietDatPhong AND MaHoaDon IS NULL AND SoPhong LIKE '%%%s%%')",
				maPhieuDatPhong, soPhong));
		@SuppressWarnings("unchecked")
		List<Object[]> rs = em.createNativeQuery(query.toString()).getResultList();
		List<ChiTietPhieuDatPhongEntity> ds = new ArrayList<ChiTietPhieuDatPhongEntity>();
		for (Object[] objects : rs) {
			ChiTietPhieuDatPhongEntity ctpdp = new ChiTietPhieuDatPhongEntity();
			ctpdp.setMaChiTietPhieuDatPhong(objects[0].toString());
			String maPhieuDatPhong2 = objects[1].toString();
			PhieuDatPhongEntity pdp = em.find(PhieuDatPhongEntity.class, maPhieuDatPhong2);
			ctpdp.setPhieuDatPhong(pdp);
			String maChiTietDatPhong = objects[2].toString();
			ChiTietDatPhongEntity ctdp = em.find(ChiTietDatPhongEntity.class, maChiTietDatPhong);
			ctpdp.setChiTietDatPhong(ctdp);
			ds.add(ctpdp);
		}
		return ds;
	}

	@Override
	public List<ChiTietPhieuDatPhongEntity> timChiTietPhieuDatPhongTheoMaPhieuDatPhong(String maPhieuDatPhong)
			throws RemoteException {
//		String query = "SELECT * FROM ChiTietPhieuDatPhong CTPDP\r\n" + "WHERE MaPhieuDatPhong LIKE ? \r\n"
//				+ "	AND EXISTS (SELECT * FROM ChiTietDatPhong CTDP JOIN ChiTietHoaDon CTHD\r\n"
//				+ "	ON CTDP.MaChiTietDatPhong = CTHD.MaChiTietDatPhong\r\n"
//				+ "	WHERE CTDP.MaChiTietDatPhong = CTPDP.MaChiTietDatPhong AND MaHoaDon IS NULL)";
		String query = "select ctpdp from ChiTietPhieuDatPhongEntity ctpdp join ctpdp.chiTietDatPhong ctdp join ctdp.chiTietHoaDon cthd where ctpdp.phieuDatPhong.maPhieuDatPhong =:maPhieuDatPhong and cthd.hoaDon is null and ctdp.maChiTietDatPhong = ctpdp.chiTietDatPhong.maChiTietDatPhong";
		return em.createQuery(query, ChiTietPhieuDatPhongEntity.class).setParameter("maPhieuDatPhong", maPhieuDatPhong)
				.getResultList();
	}

	@Override
	public boolean xoaChiTietPhieuDatPhong(String maChiTietDatPhong) throws RemoteException {
		String query = "delete from ChiTietPhieuDatPhongEntity ctpdp where ctpdp.chiTietDatPhong.maChiTietDatPhong =:maChiTietDatPhong";
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.createQuery(query).setParameter("maChiTietDatPhong", maChiTietDatPhong).executeUpdate();
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<PhieuDatPhongEntity> duyetDanhSachDatPhong() throws RemoteException {
//		String query = "SELECT * FROM PhieuDatPhong PDP\r\n"
//				+ "WHERE EXISTS (SELECT * FROM ChiTietPhieuDatPhong CTPDP JOIN ChiTietDatPhong CTDP\r\n"
//				+ "ON CTPDP.MaChiTietDatPhong = CTDP.MaChiTietDatPhong JOIN Phong P\r\n"
//				+ "ON P.MaPhong = CTDP.MaPhong JOIN ChiTietHoaDon CTHD\r\n"
//				+ "ON CTDP.MaChiTietDatPhong = CTHD.MaChiTietDatPhong\r\n"
//				+ "WHERE MaHoaDon IS NULL AND CTPDP.MaPhieuDatPhong = PDP.MaPhieuDatPhong)";
		String query = "select pdp from PhieuDatPhongEntity pdp where exists (select ctpdp from ChiTietPhieuDatPhongEntity ctpdp join ctpdp.chiTietDatPhong ctdp join ctdp.chiTietHoaDon cthd where cthd.hoaDon.maHoaDon is null and ctpdp.phieuDatPhong.maPhieuDatPhong = pdp.maPhieuDatPhong)";
		return em.createQuery(query, PhieuDatPhongEntity.class).getResultList();
	}

	@Override
	public boolean themPhieuDatPhong(String maKhachHang) throws RemoteException {
		KhachHangEntity kh = em.find(KhachHangEntity.class, maKhachHang);
		if (kh == null) {
			return false;
		}
//		String query = "insert into PhieuDatPhongEntity(khachHang) values(:khachHang)";
		String query = "INSERT INTO PhieuDatPhong (MaKhachHang) " + "VALUES (?)";
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.createNativeQuery(query).setParameter(1, maKhachHang).executeUpdate();
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public PhieuDatPhongEntity timPhieuDatPhongTheoMa(String maPhieuDatPhong) throws RemoteException {
		return em.find(PhieuDatPhongEntity.class, maPhieuDatPhong);
	}

	@Override
	public List<PhieuDatPhongEntity> timPhieuDatPhongTruocTheoSoPhongVaKhachHang(int soPhong, String khachHang)
			throws RemoteException {
		StringBuilder query = new StringBuilder(
				"SELECT PDP.MaPhieuDatPhong, PDP.MaKhachHang FROM PhieuDatPhong PDP JOIN KhachHang KH\r\n"
						+ "ON PDP.MaKhachHang = KH.MaKhachHang\r\n"
						+ "WHERE EXISTS (SELECT * FROM ChiTietPhieuDatPhong CTPDP JOIN ChiTietDatPhong CTDP\r\n"
						+ "ON CTPDP.MaChiTietDatPhong = CTDP.MaChiTietDatPhong JOIN Phong P\r\n"
						+ "ON P.MaPhong = CTDP.MaPhong JOIN ChiTietHoaDon CTHD\r\n"
						+ "ON CTDP.MaChiTietDatPhong = CTHD.MaChiTietDatPhong\r\n"
						+ "WHERE MaHoaDon IS NULL AND CTPDP.MaPhieuDatPhong = PDP.MaPhieuDatPhong");
		if (soPhong >= 0 && !khachHang.equals("")) {
			query.append(String.format(" AND SoPhong LIKE '%%%s%%') AND HoTen LIKE N'%%%s%%'", soPhong, khachHang));
		} else if (soPhong >= 0 && khachHang.equals("")) {
			query.append(String.format(" AND SoPhong LIKE '%%%s%%')", soPhong));
		} else if (soPhong < 0 && !khachHang.equals("")) {
			query.append(String.format(") AND HoTen LIKE N'%%%s%%'", khachHang));
		}
		@SuppressWarnings("unchecked")
		List<Object[]> rs = em.createNativeQuery(query.toString()).getResultList();
		List<PhieuDatPhongEntity> ds = new ArrayList<PhieuDatPhongEntity>();
		for (Object[] objects : rs) {
			PhieuDatPhongEntity pdp = new PhieuDatPhongEntity();
			pdp.setMaPhieuDatPhong(objects[0].toString());
			String maKhachHang = objects[1].toString();
			KhachHangEntity kh = em.find(KhachHangEntity.class, maKhachHang);
			pdp.setKhachHang(kh);
			ds.add(pdp);
		}
		return ds;
	}

	@Override
	public PhieuDatPhongEntity timPhieuDatPhongVuaTao() throws RemoteException {
//		String query = "select TOP 1 * from PhieuDatPhong ORDER BY MaPhieuDatPhong DESC";
		String query = "select pdp from PhieuDatPhongEntity pdp order by pdp.maPhieuDatPhong desc";
		return em.createQuery(query, PhieuDatPhongEntity.class).setMaxResults(1).getSingleResult();
	}

	@Override
	public boolean xoaPhieuDatPhong(String maPhieuDatPhong) throws RemoteException {
//		String query = "DELETE FROM PhieuDatPhong WHERE MaPhieuDatPhong LIKE ?";
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(em.find(PhieuDatPhongEntity.class, maPhieuDatPhong));
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<PhieuDatPhongEntity> duyetDanhSachPhieuDatPhongChuaThanhToan() throws RemoteException {
		
		
		String query = "select pdp.MaPhieuDatPhong, pdp.MaKhachHang  from PhieuDatPhong pdp\r\n"
				+ "where exists (select *from ChiTietPhieuDatPhong ctpdp \r\n"
				+ "join ChiTietDatPhong ctdp on ctdp.MaChiTietDatPhong = ctpdp.MaChiTietDatPhong\r\n"
				+ "join ChiTietHoaDon cthd on cthd.MaChiTietDatPhong = ctdp.MaChiTietDatPhong\r\n"
				+ "where pdp.MaPhieuDatPhong = ctpdp.MaPhieuDatPhong and cthd.MaHoaDon is null) ";
//		return em.createNativeQuery(query, PhieuDatPhongEntity.class).getResultList();
		@SuppressWarnings("unchecked")
		List<Object[]> rs = em.createNativeQuery(query).getResultList();
		List<PhieuDatPhongEntity> ds = new ArrayList<PhieuDatPhongEntity>();
		for (Object[] objects : rs) {
			PhieuDatPhongEntity pdp = new PhieuDatPhongEntity();
			pdp.setMaPhieuDatPhong(objects[0].toString());
			String maKhachHang = objects[1].toString();
			KhachHangEntity kh = em.find(KhachHangEntity.class, maKhachHang);
			pdp.setKhachHang(kh);
			ds.add(pdp);
		}
		return ds;
	}

	@Override
	public List<ChiTietPhieuDatPhongEntity> duyetDanhSachChiTietPhieuDatPhongTheoPhieuDatPhong(String maPhieuDatPhong)
			throws RemoteException {
		String query = "select ctpdp from ChiTietPhieuDatPhongEntity ctpdp where ctpdp.phieuDatPhong.maPhieuDatPhong =:maPhieuDatPhong";
		return em.createQuery(query, ChiTietPhieuDatPhongEntity.class).setParameter("maPhieuDatPhong", maPhieuDatPhong)
				.getResultList();
	}

}
