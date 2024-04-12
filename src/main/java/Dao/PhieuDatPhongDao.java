package Dao;

import java.util.List;

import entities.ChiTietPhieuDatPhongEntity;
import entities.PhieuDatPhongEntity;

public interface PhieuDatPhongDao {
	public List<ChiTietPhieuDatPhongEntity> duyetChiTietPhieuDatPhongChuaThanhToan();

	public boolean themChiTietPhieuDatPhong(ChiTietPhieuDatPhongEntity chiTietPhieuDatPhongEntity);

	public ChiTietPhieuDatPhongEntity timChiTietPhieuDatPhongTheoMa(String maChiTietPhieuDatPhong);

	public List<ChiTietPhieuDatPhongEntity> timChiTietPhieuDatPhongTheoSoPhongVaMa(int soPhong, String maPhieuDatPhong);

	public List<ChiTietPhieuDatPhongEntity> timChiTietPhieuDatPhongTheoMaPhieuDatPhong(String maPhieuDatPhong);

	public boolean xoaChiTietPhieuDatPhong(String maChiTietDatPhong);

	public List<PhieuDatPhongEntity> duyetDanhSachDatPhong();

	public boolean themPhieuDatPhong(String maKhachHang);

	public PhieuDatPhongEntity timPhieuDatPhongTheoMa(String maPhieuDatPhong);
	public List<PhieuDatPhongEntity> timPhieuDatPhongTruocTheoSoPhongVaKhachHang(int soPhong, String khachHang);
	public PhieuDatPhongEntity timPhieuDatPhongVuaTao();
	public boolean xoaPhieuDatPhong(String maPhieuDatPhong);
	public List<PhieuDatPhongEntity> duyetDanhSachPhieuDatPhongChuaThanhToan();
	public List<ChiTietPhieuDatPhongEntity> duyetDanhSachChiTietPhieuDatPhongTheoPhieuDatPhong(String maPhieuDatPhong);
}
