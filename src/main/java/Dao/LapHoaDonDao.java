package Dao;

import java.util.List;

import entities.ChiTietHoaDonEntity;
import entities.HoaDonEntity;
import entities.KhachHangEntity;
import entities.PhieuDatPhongEntity;

public interface LapHoaDonDao {
	public int demSoLuongPhong(String maPhieuDatPhong);
	public double tinhTienDichVu(String maPhieuDatPhong);
	public boolean themHoaDon(HoaDonEntity hoaDonEntity);
	public List<ChiTietHoaDonEntity> duyetDanhSachChiTietHoaDon(String maPhieuDatPhong);
	public boolean capNhatChiTietHoaDon(ChiTietHoaDonEntity chiTietHoaDonEntity, String maHoaDon);
	public HoaDonEntity timHoaDonVuaTao();
	public List<PhieuDatPhongEntity> timHoaDonTheoKhachHang(KhachHangEntity khachHangEntity);
	
}
