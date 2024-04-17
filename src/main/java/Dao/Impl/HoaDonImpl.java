package Dao.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import Dao.HoaDonDao;
import entities.ChiTietDatPhongEntity;
import entities.ChiTietDichVuEntity;
import entities.ChiTietHoaDonEntity;
import entities.PhongEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class HoaDonImpl extends UnicastRemoteObject implements HoaDonDao {

	private String persistenceUnitName = "quanliKaraoke_ver2 mssql";
	private EntityManager em;

	public HoaDonImpl()throws RemoteException  {
		em = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
	}

	@Override
	public boolean themChiTietHoaDon(String maChiTietDatPhong)throws RemoteException  {
		ChiTietHoaDonEntity chiTietHoaDonEntity = new ChiTietHoaDonEntity();
		chiTietHoaDonEntity.getChiTietDatPhong().setMaChiTietDatPhong(maChiTietDatPhong);
		EntityTransaction tr = em.getTransaction();
		String query = "INSERT INTO ChiTietHoaDon (MaChiTietDatPhong)\r\n" + "VALUES (?)";
		try {
			tr.begin();
			boolean kq = em.createNativeQuery(query).setParameter(1, maChiTietDatPhong).executeUpdate() > 0;
			tr.commit();
			return kq;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean xoaChiTietHoaDon(String maChiTietDatPhong) throws RemoteException {
		String query = "DELETE FROM ChiTietHoaDonEntity c WHERE c.chiTietDatPhong.maChiTietDatPhong = :maChiTietDatPhong";
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.createQuery(query).setParameter("maChiTietDatPhong", maChiTietDatPhong).executeUpdate();
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ChiTietHoaDonEntity timChiTietHoaDonTheoChiTietDatPhong(ChiTietDatPhongEntity chiTietDatPhongEntity) throws RemoteException {
		String query = "SELECT c FROM ChiTietHoaDonEntity c WHERE c.chiTietDatPhong.maChiTietDatPhong = :maChiTietDatPhong";
		return em.createQuery(query, ChiTietHoaDonEntity.class)
				.setParameter("maChiTietDatPhong", chiTietDatPhongEntity.getMaChiTietDatPhong()).getSingleResult();
	}

	@Override
	public List<ChiTietHoaDonEntity> duyetDanhSachChiTietHoaDonTheoMaHoaDon(String maHoaDon) throws RemoteException {
		String query = "SELECT c FROM ChiTietHoaDonEntity c WHERE c.hoaDon.maHoaDon = :maHoaDon";
		return em.createQuery(query, ChiTietHoaDonEntity.class).setParameter("maHoaDon", maHoaDon).getResultList();
	}

	@Override
	public boolean themChiTietDatPhong(ChiTietDatPhongEntity chiTietDatPhongEntity)throws RemoteException  {
		EntityTransaction tr = em.getTransaction();
		String query = "INSERT INTO ChiTietDatPhong (MaPhong, NgayDatPhong, GioNhanPhong, GioTraPhong) VALUES (:maPhong, :ngayDatPhong, :gioNhanPhong, :gioTraPhong)";
		try {
//			statement.setString(1, chiTietDatPhongEntity.getPhong().getMaPhong());
//			statement.setDate(2, Date.valueOf(chiTietDatPhongEntity.getNgayNhanPhong()));
//			statement.setTime(3, Time.valueOf(chiTietDatPhongEntity.getGioNhanPhong()));
//			statement.setTime(4, Time.valueOf(chiTietDatPhongEntity.getGioTraPhong()));
			tr.begin();
			boolean result = em.createNativeQuery(query)
					.setParameter("maPhong", chiTietDatPhongEntity.getPhong().getMaPhong())
					.setParameter("ngayDatPhong", Date.valueOf(chiTietDatPhongEntity.getNgayDatPhong()))
					.setParameter("gioNhanPhong", Time.valueOf(chiTietDatPhongEntity.getGioNhanPhong()))
					.setParameter("gioTraPhong", Time.valueOf(chiTietDatPhongEntity.getGioTraPhong()))
					.executeUpdate() > 0;
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean xoaChiTietDatPhong(String maChiTietDatPhong)throws RemoteException  {
//		String query = "DELETE FROM ChiTietDatPhongEntity c WHERE c.maChiTietDatPhong = :maChiTietDatPhong";
		EntityTransaction tr = em.getTransaction();
		ChiTietDatPhongEntity chiTietDatPhongEntity = em.find(ChiTietDatPhongEntity.class, maChiTietDatPhong);
		if (chiTietDatPhongEntity == null) {
			return false;
		}
		try {
			tr.begin();
			em.remove(chiTietDatPhongEntity);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();

		}
		return false;
	}

	@Override
	public ChiTietDatPhongEntity timChiTietDatPhongTheoMa(String maChiTietDatPhong)throws RemoteException  {
		return em.find(ChiTietDatPhongEntity.class, maChiTietDatPhong);
	}

	@Override
	public List<ChiTietDatPhongEntity> timChiTietDatPhongChuaThanhToanTheoPhong(PhongEntity phongEntity)throws RemoteException  {
		String query = "SELECT c FROM ChiTietDatPhongEntity c  join c.chiTietHoaDon h WHERE c.phong.maPhong = :phong AND h.hoaDon IS NULL order by c.ngayDatPhong";
		return em.createQuery(query, ChiTietDatPhongEntity.class).setParameter("phong", phongEntity.getMaPhong())
				.getResultList();
	}

	@Override
	public List<ChiTietDatPhongEntity> timChiTietDatPhongChuaThanhToan() throws RemoteException {
		String query = "SELECT c FROM ChiTietDatPhongEntity c  join c.chiTietHoaDon h WHERE h.hoaDon IS NULL ";
		return em.createQuery(query, ChiTietDatPhongEntity.class).getResultList();
	}

	@Override
	public ChiTietDatPhongEntity timChiTietDatPhongVuaTao()throws RemoteException  {
		String query = "SELECT c FROM ChiTietDatPhongEntity c ORDER BY c.maChiTietDatPhong DESC";
		return em.createQuery(query, ChiTietDatPhongEntity.class).setMaxResults(1).getSingleResult();
	}

	@Override
	public ChiTietDatPhongEntity timChiTietDatPhongTheoMaPhongDeNhanPhong(String maPhong)throws RemoteException  {
		// tìm chiTietDatPhong có ngayNhanPhong là hôm nay. GioNhanPhong phải trước giờ
		// hiện tại 5 phút hoặc sau giờ hiện tại 10 phút => quy định nhận phòng của quán
		String query = "SELECT c FROM ChiTietDatPhongEntity c WHERE c.phong.maPhong = :maPhong AND c.ngayDatPhong = CURRENT_DATE AND c.gioNhanPhong <= CURRENT_TIME";
		return em.createQuery(query, ChiTietDatPhongEntity.class).setParameter("maPhong", maPhong).getSingleResult();
	}

	@Override
	public List<ChiTietDichVuEntity> duyetDanhSachChiTietDichVuTheoChiTietHoaDon(String maChiTietHoaDon)throws RemoteException  {
		String query = "SELECT c FROM ChiTietDichVuEntity c WHERE c.chiTietHoaDon.maChiTietHoaDon like :maChiTietHoaDon";
		return em.createQuery(query, ChiTietDichVuEntity.class).setParameter("maChiTietHoaDon","%" + maChiTietHoaDon + "%")
				.getResultList();
	}

	@Override
	public boolean xoaChiTietDichvuTheoMaHoaDon(String maChiTietHoaDon) throws RemoteException {
		String query = "DELETE FROM ChiTietDichVuEntity c WHERE c.chiTietHoaDon.maChiTietHoaDon LIKE :maChiTietHoaDon";
		return em.createQuery(query).setParameter("maChiTietHoaDon","%"+ maChiTietHoaDon + "%").executeUpdate() > 0;
	}

	@Override
	public boolean xoaChiTietDichvuTheoMaChiTietDichVu(String maChiTietDichVu)throws RemoteException  {
	    ChiTietDichVuEntity chiTietDichVuEntity = em.find(ChiTietDichVuEntity.class, maChiTietDichVu);
		if (chiTietDichVuEntity == null) {
			return false;
		}
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(chiTietDichVuEntity);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean themChiTietDichVu(ChiTietDichVuEntity chiTietDichVuEntity, ChiTietHoaDonEntity chiTietHoaDonEntity) throws RemoteException {
		chiTietDichVuEntity.setChiTietHoaDon(chiTietHoaDonEntity);
		EntityTransaction tr = em.getTransaction();
		String query = "INSERT INTO ChiTietDichVu (MaDichVu, MaChiTietHoaDon, SoLuong) VALUES (:maDichVu, :maChiTietHoaDon, :soLuong)";
		try {
			tr.begin();
			boolean result = em.createNativeQuery(query)
					.setParameter("maDichVu", chiTietDichVuEntity.getDichVu().getMaDichVu())
					.setParameter("maChiTietHoaDon", chiTietDichVuEntity.getChiTietHoaDon().getMaChiTietHoaDon())
					.setParameter("soLuong", chiTietDichVuEntity.getSoLuong()).executeUpdate() > 0;
			tr.commit();
			return result;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean chinhSuaChiTietDichVuTheoMa(String maChiTietDichVu, int soLuong)throws RemoteException  {
		ChiTietDichVuEntity chiTietDichVuEntity = em.find(ChiTietDichVuEntity.class, maChiTietDichVu);
		if (chiTietDichVuEntity == null) {
			return false;
		}
		chiTietDichVuEntity.setSoLuong(soLuong);
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(chiTietDichVuEntity);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

}
