package Dao.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import Dao.DatPhongDao;
import entities.ChiTietDatPhongEntity;
import entities.LoaiPhong;
import entities.PhongEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import util.DateFormatter;
import util.TimeFormatter;

public class DatPhongImpl extends UnicastRemoteObject implements DatPhongDao {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String persistenceUnitName = "quanliKaraoke_ver2 mssql";
	private EntityManager em;

	public DatPhongImpl() throws RemoteException {
		em = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
	}

	@Override
	public List<PhongEntity> timPhong(String trangThai, String loaiPhong, int soPhong, int sucChua)
			throws RemoteException {
		String query = "SELECT p FROM PhongEntity p WHERE p.trangThai LIKE :trangThai AND p.loaiPhong.tenLoaiPhong LIKE :loaiPhong AND CAST(p.soPhong AS STRING) like :soPhong AND (p.sucChuaCAST AS STRING) like :sucChua";
		if (trangThai.equals("Tất cả"))
			trangThai = "";
		if (loaiPhong.equals("Tất cả"))
			loaiPhong = "";
		if (soPhong <= 0)
			soPhong = 0;
		if (sucChua <= 0)
			sucChua = 0;
		@SuppressWarnings("unchecked")
		List<PhongEntity>  list = em.createNativeQuery(query, PhongEntity.class).setParameter("trangThai", "%" + trangThai + "%")
				.setParameter("loaiPhong", "%" + loaiPhong + "%")
				.setParameter("soPhong", "%" + String.valueOf(soPhong) + "%")
				.setParameter("sucChua", String.valueOf(sucChua)).getResultList();
		 return list;
	}

	@Override
	public boolean doiPhong(ChiTietDatPhongEntity chiTietDatPhongEntity, String maPhong) throws RemoteException {
		chiTietDatPhongEntity.getPhong().setMaPhong(maPhong);
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(chiTietDatPhongEntity);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<PhongEntity> timPhongTrongTheoNgayVaGio(LocalDate ngay, LocalTime gioNhan, LocalTime gioTra)
			throws RemoteException {
	  
//		String query = "SELECT p.MaPhong, p.SoPhong, p.MaLoaiPhong, p.TrangThai, p.SucChua, FROM Phong P\r\n"
//				+ "WHERE NOT EXISTS (SELECT MaPhong FROM ChiTietDatPhong CTDP JOIN ChiTietHoaDon CTHD\r\n"
//				+ "	ON CTDP.MaChiTietDatPhong = CTHD.MaChiTietDatPhong \r\n"
//				+ "	WHERE CTDP.MaPhong = P.MaPhong AND MaHoaDon IS NULL\r\n"
//				+ "	AND NgayDatPhong = ? AND (GioNhanPhong >= ? AND GioNhanPhong <= ?) AND (GioTraPhong >= ? AND GioTraPhong <= ?))\r\n";
//		@SuppressWarnings("unchecked")
//		List<Object[]> rs =  em.createNativeQuery(query, PhongEntity.class).setParameter(1, DateFormatter.formatSql(ngay))
//				.setParameter(2, TimeFormatter.formatSql(gioNhan.minusMinutes(30)))
//				.setParameter(3, TimeFormatter.formatSql(gioTra.plusMinutes(30)))
//				.setParameter(4, TimeFormatter.formatSql(gioNhan.minusMinutes(30)))
//				.setParameter(5, TimeFormatter.formatSql(gioTra.plusMinutes(30))).getResultList();
//		List<PhongEntity> ds = new ArrayList<PhongEntity>();
//		for (Object[] o : rs) {
//			PhongEntity p = new PhongEntity();
//			p.setMaPhong((String) o[0]);
//			p.setSoPhong((int) o[1]);
//			LoaiPhong loaiPhong = em.find(LoaiPhong.class, (String) o[2]);
//			p.setLoaiPhong(loaiPhong);
//			p.setTrangThai((String) o[3]);
//			p.setSucChua((int) o[4]);
//			ds.add(p);
//		}
//		return ds;
//		
		 String query = "SELECT p FROM PhongEntity p WHERE p.maPhong NOT IN (SELECT c.phong.maPhong FROM ChiTietDatPhongEntity c WHERE c.ngayDatPhong = :ngay AND (c.gioNhanPhong < :gioTra AND c.gioTraPhong > :gioNhan))";
		return em.createQuery(query, PhongEntity.class).setParameter("ngay", ngay).setParameter("gioNhan", gioNhan).setParameter("gioTra", gioTra).getResultList();
	}

	@Override
	public List<ChiTietDatPhongEntity> duyetChiTietDatPhongChuaThanhToanTheoPhong(PhongEntity phongEntity)
			throws RemoteException {
		String query = "SELECT c FROM ChiTietDatPhongEntity c join c.chiTietHoaDon h WHERE h.hoaDon.maHoaDon IS NULL AND c.phong.maPhong = :phong ORDER BY c.ngayNhanPhong ASC, c.gioNhanPhong ASC";
		return em.createQuery(query, ChiTietDatPhongEntity.class).setParameter("phong", phongEntity.getMaPhong())
				.getResultList();

	}
	

}
