package Dao;

import java.util.List;

import entities.KhachHangEntity;

public interface KhachHangDao {

	public List<KhachHangEntity> duyetDanhSach();
	public KhachHangEntity them(KhachHangEntity khachHangEntity);
	public int chinhSua(KhachHangEntity khachHangEntity);
	public KhachHangEntity timTheoMa(String MaKhachHang);
	public KhachHangEntity timTheoSoDienThoai(String soDienThoai);
	public List<KhachHangEntity> timKiem(String hoTen, String soDienThoai, int slTu, int slDen);
}
