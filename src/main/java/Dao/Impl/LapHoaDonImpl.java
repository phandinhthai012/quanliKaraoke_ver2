package Dao.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import Dao.LapHoaDonDao;
import entities.ChiTietDatPhongEntity;
import entities.ChiTietHoaDonEntity;
import entities.HoaDonEntity;
import entities.KhachHangEntity;
import entities.PhieuDatPhongEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class LapHoaDonImpl extends UnicastRemoteObject implements LapHoaDonDao {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String persistenceUnitName = "quanliKaraoke_ver2 mssql";
	private EntityManager em;
	
	public LapHoaDonImpl()throws RemoteException  {
		this.em = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
	}

	@Override
	public int demSoLuongPhong(String maPhieuDatPhong)throws RemoteException  {
		String query = "SELECT COUNT(c) FROM ChiTietPhieuDatPhongEntity c WHERE c.phieuDatPhong.maPhieuDatPhong = :maPhieuDatPhong";
		int soLuong = em.createQuery(query, Long.class).setParameter("maPhieuDatPhong", maPhieuDatPhong).getSingleResult().intValue();
		return soLuong;
	}

	@Override
	public double tinhTienDichVu(String maPhieuDatPhong) throws RemoteException {
//		String query = "SELECT SUM(c.dichVu.gia*c.soLuong) FROM ChiTietDichVuEntity c join c.chiTietHoaDon h join h.chiTietDatPhong d Join d.chiTietPhieuDatPhong p WHERE p.phieuDatPhong.maPhieuDatPhong = :maPhieuDatPhong";
//		double tienDichVu = em.createQuery(query, Double.class).setParameter("maPhieuDatPhong", maPhieuDatPhong).getSingleResult();
//		return tienDichVu;
		String query = "select SUM(ctdv.SoLuong * Gia) as N'Tổng tiền dịch vụ'\r\n"
				+ "from ChiTietDichVu ctdv join DichVu dv on dv.MaDichVu = ctdv.MaDichVu\r\n"
				+ "join ChiTietHoaDon cthd on ctdv.MaChiTietHoaDon = cthd.MaChiTietHoaDon\r\n"
				+ "join ChiTietDatPhong ctdp on ctdp.MaChiTietDatPhong = cthd.MaChiTietDatPhong\r\n"
				+ "join ChiTietPhieuDatPhong ctpdp on ctpdp.MaChiTietDatPhong = ctdp.MaChiTietDatPhong\r\n"
				+ "join PhieuDatPhong pdp on pdp.MaPhieuDatPhong = ctpdp.MaPhieuDatPhong\r\n";
//		return (double) em.createNativeQuery(query, Double.class).getSingleResult();
		Object result = em.createNativeQuery(query).getSingleResult();
		return result != null ? ((Number) result).doubleValue() : 0.0;
	}

	@Override
	public boolean themHoaDon(HoaDonEntity hoaDonEntity)throws RemoteException  {
		EntityTransaction tr = em.getTransaction();
		String query = "insert HoaDon (MaNhanVien, MaKhachHang, NgayLap, GioLap)"
				+ " values (:maNhanVien, :maKhachHang, :ngayLap, :gioLap)";
		try {
			tr.begin();
			boolean i = em.createNativeQuery(query).setParameter("maNhanVien", hoaDonEntity.getNhanVien().getMaNhanVien()).setParameter("maKhachHang", hoaDonEntity.getKhachHang().getMaKhachHang()).setParameter("ngayLap", hoaDonEntity.getNgayLap()).setParameter("gioLap", hoaDonEntity.getGioLap()).executeUpdate()>0;
			tr.commit();
			return i;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<ChiTietHoaDonEntity> duyetDanhSachChiTietHoaDon(String maPhieuDatPhong)throws RemoteException  {
		String query = "SELECT c FROM ChiTietHoaDonEntity c join c.chiTietDatPhong d join d.listChiTietPhieuDatPhong p WHERE p.phieuDatPhong.maPhieuDatPhong = :maPhieuDatPhong";
		return em.createQuery(query, ChiTietHoaDonEntity.class).setParameter("maPhieuDatPhong", maPhieuDatPhong).getResultList();
	}

	@Override
	public boolean capNhatChiTietHoaDon(ChiTietHoaDonEntity chiTietHoaDonEntity, String maHoaDon)throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		HoaDonEntity hoaDonEntity = em.find(HoaDonEntity.class, maHoaDon);
		if (hoaDonEntity == null)
			return false;
		
		chiTietHoaDonEntity.setHoaDon(hoaDonEntity);
		try {
			tr.begin();
			em.merge(chiTietHoaDonEntity);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public HoaDonEntity timHoaDonVuaTao()throws RemoteException  {
//		 "select top 1 *from HoaDon order by MaHoaDon desc";
		String query = "SELECT h FROM HoaDonEntity h order by h.maHoaDon desc";
		return em.createQuery(query, HoaDonEntity.class).setMaxResults(1).getSingleResult();
	}

	@Override
	public List<PhieuDatPhongEntity> timHoaDonTheoKhachHang(KhachHangEntity khachHangEntity)throws RemoteException  {
		String query2 = "select pdp from PhieuDatPhongEntity pdp join pdp.listPhong ctpdp join ctpdp.chiTietDatPhong ctdp join ctdp.chiTietHoaDon cthd where cthd.hoaDon.maHoaDon is null and pdp.khachHang.maKhachHang = :maKhachHang";
		return em.createQuery(query2, PhieuDatPhongEntity.class).setParameter("maKhachHang", khachHangEntity.getMaKhachHang()).getResultList();
//		
	}

}
