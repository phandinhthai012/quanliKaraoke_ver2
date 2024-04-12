package Dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import entities.ChiTietDatPhongEntity;
import entities.PhongEntity;

public interface DatPhongDao {
	public List<PhongEntity> timPhong(String trangThai, String loaiPhong, int soPhong, int sucChua);
	public boolean doiPhong(ChiTietDatPhongEntity chiTietDatPhongEntity, String maPhong);
	public List<PhongEntity> timPhongTrongTheoNgayVaGio(LocalDate ngay, LocalTime gioNhan, LocalTime gioTra);
	public List<ChiTietDatPhongEntity> duyetChiTietDatPhongChuaThanhToanTheoPhong(PhongEntity phongEntity);
}
