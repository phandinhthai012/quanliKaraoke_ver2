package Dao.Impl;

import java.util.List;

import Dao.PhieuDatPhongDao;
import entities.ChiTietPhieuDatPhongEntity;
import entities.KhachHangEntity;
import entities.PhieuDatPhongEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PhieuDatPhongImpl implements PhieuDatPhongDao {
	
	private String persistenceUnitName="quanliKaraoke_ver2 mssql";
	private EntityManager em;
	
	public PhieuDatPhongImpl() {
		this.em = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
	}

	@Override
	public List<ChiTietPhieuDatPhongEntity> duyetChiTietPhieuDatPhongChuaThanhToan() {
//		String query = "SELECT * FROM ChiTietPhieuDatPhong CTPDP\r\n"
//				+ "WHERE EXISTS (SELECT * FROM ChiTietDatPhong CTDP JOIN ChiTietHoaDon CTHD\r\n"
//				+ "	ON CTDP.MaChiTietDatPhong = CTHD.MaChiTietDatPhong JOIN Phong P\r\n"
//				+ "	ON CTDP.MaPhong = P.MaPhong\r\n"
//				+ "	WHERE CTDP.MaChiTietDatPhong = CTPDP.MaChiTietDatPhong AND MaHoaDon IS NULL)";
//		String query = "SELECT ct FROM ChiTietPhieuDatPhongEntity ct join ct.chiTietDatPhongEntity ctdp join ctdp.phongEntity p WHERE ctdp.maChiTietDatPhong = ct.chiTietDatPhong AND
//		                                                                                                          CTDP.MaChiTietDatPhong = CTPDP.MaChiTietDatPhong
		String query = "select ctpdp from ChiTietPhieuDatPhongEntity ctpdp join ctpdp.chiTietDatPhong ctdp join ctdp.chiTietHoaDon cthd where cthd.hoaDon is null";
//		String query = "Select ctpdp from ChiTietPhieuDatPhongEntity ctpdp join ctpdp.chiTietDatPhong ctdp join ctdp.chiTietHoaDon cthd where cthd.hoaDon is null";
		return em.createQuery(query, ChiTietPhieuDatPhongEntity.class).getResultList();
	}
	
	@Override
	public boolean themChiTietPhieuDatPhong(ChiTietPhieuDatPhongEntity chiTietPhieuDatPhongEntity) {
		EntityTransaction tx = em.getTransaction();
		String query = "INSERT INTO ChiTietPhieuDatPhong (MaPhieuDatPhong, MaChiTietDatPhong) VALUES (?, ?)";
		try {
			tx.begin();
		 	boolean result = em.createNativeQuery(query)
					.setParameter(1, chiTietPhieuDatPhongEntity.getPhieuDatPhong().getMaPhieuDatPhong())
					.setParameter(2, chiTietPhieuDatPhongEntity.getChiTietDatPhong().getMaChiTietDatPhong())
					.executeUpdate()>0;
			tx.commit();
			return result;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ChiTietPhieuDatPhongEntity timChiTietPhieuDatPhongTheoMa(String maChiTietPhieuDatPhong) {
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
	public List<ChiTietPhieuDatPhongEntity> timChiTietPhieuDatPhongTheoSoPhongVaMa(int soPhong,
			String maPhieuDatPhong) {
//		"SELECT * FROM ChiTietPhieuDatPhong CTPDP\r\n"
//				+ "WHERE MaPhieuDatPhong LIKE '%%%s%%' \r\n"
//				+ "	AND EXISTS (SELECT * FROM ChiTietDatPhong CTDP JOIN ChiTietHoaDon CTHD\r\n"
//				+ "		ON CTDP.MaChiTietDatPhong = CTHD.MaChiTietDatPhong JOIN Phong P\r\n"
//				+ "		ON CTDP.MaPhong = P.MaPhong\r\n"
//				+ "		WHERE CTDP.MaChiTietDatPhong = CTPDP.MaChiTietDatPhong AND MaHoaDon IS NULL AND SoPhong LIKE '%%%s%%')",
		String query = "select ctpdp from ChiTietPhieuDatPhongEntity ctpdp join ctpdp.chiTietDatPhong ctdp join ctdp.chiTietHoaDon cthd join ctdp.phong p where ctdp.maChiTietDatPhong = ctpdp.chiTietDatPhong.maChiTietDatPhong and cthd.hoaDon is null and p.soPhong =:soPhong and ctpdp.phieuDatPhong.maPhieuDatPhong =:maPhieuDatPhong"; 
		return em.createQuery(query, ChiTietPhieuDatPhongEntity.class).setParameter("soPhong", soPhong).setParameter("maPhieuDatPhong", maPhieuDatPhong).getResultList();
	}

	@Override
	public List<ChiTietPhieuDatPhongEntity> timChiTietPhieuDatPhongTheoMaPhieuDatPhong(String maPhieuDatPhong) {
//		String query = "SELECT * FROM ChiTietPhieuDatPhong CTPDP\r\n" + "WHERE MaPhieuDatPhong LIKE ? \r\n"
//				+ "	AND EXISTS (SELECT * FROM ChiTietDatPhong CTDP JOIN ChiTietHoaDon CTHD\r\n"
//				+ "	ON CTDP.MaChiTietDatPhong = CTHD.MaChiTietDatPhong\r\n"
//				+ "	WHERE CTDP.MaChiTietDatPhong = CTPDP.MaChiTietDatPhong AND MaHoaDon IS NULL)";
		String query = "select ctpdp from ChiTietPhieuDatPhongEntity ctpdp join ctpdp.chiTietDatPhong ctdp join ctdp.chiTietHoaDon cthd where ctpdp.phieuDatPhong.maPhieuDatPhong =:maPhieuDatPhong and cthd.hoaDon is null and ctdp.maChiTietDatPhong = ctpdp.chiTietDatPhong.maChiTietDatPhong";
		return em.createQuery(query, ChiTietPhieuDatPhongEntity.class).setParameter("maPhieuDatPhong", maPhieuDatPhong).getResultList();
	}


	@Override
	public boolean xoaChiTietPhieuDatPhong(String maChiTietDatPhong) {
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
	public List<PhieuDatPhongEntity> duyetDanhSachDatPhong() {
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
	public boolean themPhieuDatPhong(String maKhachHang) {
		KhachHangEntity kh = em.find(KhachHangEntity.class, maKhachHang);
		if (kh == null) {
			return false;
		}
		String query = "insert into PhieuDatPhongEntity(khachHang) values(:khachHang)";
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.createQuery(query).setParameter("khachHang", kh).executeUpdate();
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public PhieuDatPhongEntity timPhieuDatPhongTheoMa(String maPhieuDatPhong) {
		return em.find(PhieuDatPhongEntity.class, maPhieuDatPhong);
	}

	@Override
	public List<PhieuDatPhongEntity> timPhieuDatPhongTruocTheoSoPhongVaKhachHang(int soPhong, String khachHang) {
		StringBuilder query = new StringBuilder(
				"SELECT PDP.MaPhieuDatPhong, PDP.MaKhachHang FROM PhieuDatPhong PDP JOIN KhachHang KH\r\n"
						+ "ON PDP.MaKhachHang = KH.MaKhachHang\r\n"
						+ "WHERE EXISTS (SELECT * FROM ChiTietPhieuDatPhong CTPDP JOIN ChiTietDatPhong CTDP\r\n"
						+ "ON CTPDP.MaChiTietDatPhong = CTDP.MaChiTietDatPhong JOIN Phong P\r\n"
						+ "ON P.MaPhong = CTDP.MaPhong JOIN ChiTietHoaDon CTHD\r\n"
						+ "ON CTDP.MaChiTietDatPhong = CTHD.MaChiTietDatPhong\r\n"
						+ "WHERE MaHoaDon IS NULL AND CTPDP.MaPhieuDatPhong = PDP.MaPhieuDatPhong");
		if (soPhong >= 0 && !khachHang.equals("")) {
			query.append(
					String.format(" AND SoPhong LIKE '%%%s%%') AND HoTen LIKE N'%%%s%%'", soPhong, khachHang));
		} else if (soPhong >= 0 && khachHang.equals("")) {
			query.append(String.format(" AND SoPhong LIKE '%%%s%%')", soPhong));
		} else if (soPhong < 0 && !khachHang.equals("")) {
			query.append(String.format(") AND HoTen LIKE N'%%%s%%'", khachHang));
		}
		return em.createNativeQuery(query.toString(), PhieuDatPhongEntity.class).getResultList();
	}

	@Override
	public PhieuDatPhongEntity timPhieuDatPhongVuaTao() {
//		String query = "select TOP 1 * from PhieuDatPhong ORDER BY MaPhieuDatPhong DESC";
		String query = "select pdp from PhieuDatPhongEntity pdp order by pdp.maPhieuDatPhong desc";
		return em.createQuery(query, PhieuDatPhongEntity.class).setMaxResults(1).getSingleResult();
	}

	@Override
	public boolean xoaPhieuDatPhong(String maPhieuDatPhong) {
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
	public List<PhieuDatPhongEntity> duyetDanhSachPhieuDatPhongChuaThanhToan() {
		String query = "select *from PhieuDatPhong pdp\r\n"
				+ "where exists (select *from ChiTietPhieuDatPhong ctpdp \r\n"
				+ "join ChiTietDatPhong ctdp on ctdp.MaChiTietDatPhong = ctpdp.MaChiTietDatPhong\r\n"
				+ "join ChiTietHoaDon cthd on cthd.MaChiTietDatPhong = ctdp.MaChiTietDatPhong\r\n"
				+ "where pdp.MaPhieuDatPhong = ctpdp.MaPhieuDatPhong and cthd.MaHoaDon is null) ";
		return em.createNativeQuery(query, PhieuDatPhongEntity.class).getResultList();
	}

	@Override
	public List<ChiTietPhieuDatPhongEntity> duyetDanhSachChiTietPhieuDatPhongTheoPhieuDatPhong(String maPhieuDatPhong) {
		String query = "select ctpdp from ChiTietPhieuDatPhongEntity ctpdp where ctpdp.phieuDatPhong.maPhieuDatPhong =:maPhieuDatPhong";
		return em.createQuery(query, ChiTietPhieuDatPhongEntity.class).setParameter("maPhieuDatPhong", maPhieuDatPhong).getResultList();
	}

}
