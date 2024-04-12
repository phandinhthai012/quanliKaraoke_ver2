package Dao;

import java.util.List;

import entities.ChiTietDatPhongEntity;
import entities.ChiTietDichVuEntity;
import entities.ChiTietHoaDonEntity;
import entities.PhongEntity;

public interface HoaDonDao {
	public boolean themChiTietHoaDon(String maChiTietDatPhong);
	public boolean xoaChiTietHoaDon(String maChiTietDatPhong);
	public ChiTietHoaDonEntity timChiTietHoaDonTheoChiTietDatPhong(ChiTietDatPhongEntity chiTietDatPhongEntity);
	public List<ChiTietHoaDonEntity> duyetDanhSachChiTietHoaDonTheoMaHoaDon(String maHoaDon);
	public boolean themChiTietDatPhong(ChiTietDatPhongEntity chiTietDatPhongEntity);
	public boolean xoaChiTietDatPhong(String maChiTietDatPhong);
	public ChiTietDatPhongEntity timChiTietDatPhongTheoMa(String maChiTietDatPhong);
	public List<ChiTietDatPhongEntity> timChiTietDatPhongChuaThanhToanTheoPhong(PhongEntity phongEntity);
	public List<ChiTietDatPhongEntity> timChiTietDatPhongChuaThanhToan();
	public ChiTietDatPhongEntity timChiTietDatPhongVuaTao();
	public ChiTietDatPhongEntity timChiTietDatPhongTheoMaPhongDeNhanPhong(String maPhong);
	public List<ChiTietDichVuEntity> duyetDanhSachChiTietDichVuTheoChiTietHoaDon(String maChiTietHoaDon);
	public boolean xoaChiTietDichvuTheoMaHoaDon(String maChiTietHoaDon);
	public boolean xoaChiTietDichvuTheoMaChiTietDichVu(String maChiTietDichVu);
	public boolean themChiTietDichVu(ChiTietDichVuEntity chiTietDichVuEntity, ChiTietHoaDonEntity chiTietHoaDonEntity);
	public boolean chinhSuaChiTietDichVuTheoMa(String maChiTietDichVu, int soLuong);
}
