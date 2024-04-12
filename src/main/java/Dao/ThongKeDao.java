package Dao;

import java.time.LocalDate;
import java.util.List;

import entities.HoaDonEntity;

public interface ThongKeDao {
	public List<HoaDonEntity> duyetDanhSachHoaDonTheoNgay(LocalDate ngay);
	public List<HoaDonEntity> duyetDanhSachHoaDonTheoNamThang(LocalDate ngay);
	public List<HoaDonEntity> duyetDanhSachHoaDonTheoNam(LocalDate ngay);
	public double tinhTongTienDichVuCuaHoaDon(HoaDonEntity hoaDonEntity);
	
}
