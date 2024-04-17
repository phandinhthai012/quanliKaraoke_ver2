package Dao.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import Dao.LapHoaDonDao;
import entities.ChiTietHoaDonEntity;
import entities.HoaDonEntity;
import entities.KhachHangEntity;
import entities.PhieuDatPhongEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class LapHoaDonImpl extends UnicastRemoteObject implements LapHoaDonDao {
	
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
		String query = "SELECT SUM(c.dichVu.gia*c.soLuong) FROM ChiTietDichVuEntity c join c.chiTietHoaDon h join h.chiTietDatPhong d Join d.chiTietPhieuDatPhong p WHERE p.phieuDatPhong.maPhieuDatPhong = :maPhieuDatPhong";
		double tienDichVu = em.createQuery(query, Double.class).setParameter("maPhieuDatPhong", maPhieuDatPhong).getSingleResult();
		return tienDichVu;
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
		String query = "SELECT c FROM ChiTietHoaDonEntity c join c.chiTietDatPhong d join d.chiTietPhieuDatPhong p WHERE p.phieuDatPhong.maPhieuDatPhong = :maPhieuDatPhong";
		return em.createQuery(query, ChiTietHoaDonEntity.class).setParameter("maPhieuDatPhong", maPhieuDatPhong).getResultList();
	}

	@Override
	public boolean capNhatChiTietHoaDon(ChiTietHoaDonEntity chiTietHoaDonEntity, String maHoaDon)throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		chiTietHoaDonEntity.setHoaDon(em.find(HoaDonEntity.class, maHoaDon));
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
		String query = "select *from PhieuDatPhong pdp\r\n"
				+ "where exists (select *from ChiTietPhieuDatPhong ctpdp \r\n"
				+ "join ChiTietDatPhong ctdp on ctdp.MaChiTietDatPhong = ctpdp.MaChiTietDatPhong\r\n"
				+ "join ChiTietHoaDon cthd on cthd.MaChiTietDatPhong = ctdp.MaChiTietDatPhong\r\n"
				+ "join ChiTietDichVu ctdv on cthd.MaChiTietHoaDon = ctdv.MaChiTietHoaDon\r\n"
				+ "join DichVu dv on dv.MaDichVu = ctdv.MaDichVu\r\n"
				+ "where pdp.MaPhieuDatPhong = ctpdp.MaPhieuDatPhong and cthd.MaHoaDon is null) \r\n"
				+ "and MaKhachHang = ?";
		return em.createNativeQuery(query, PhieuDatPhongEntity.class).setParameter(1, khachHangEntity.getMaKhachHang()).getResultList();
	}

}
