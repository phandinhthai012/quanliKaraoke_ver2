package Dao;

import java.util.List;

import entities.NhanVienEntity;

public interface NhanVienDao {
	public List<NhanVienEntity> duyetDanhSach();

	public List<NhanVienEntity> duyetDanhSachNhanVienDangLamViec();

	public NhanVienEntity timTheoMa(String maNhanvien);

	public NhanVienEntity timTheoTenVaSoDienThoai(String hoTen, String soDienThoai);

	public boolean them(NhanVienEntity nhanVienEntity);

	public NhanVienEntity timTheoSoDienThoaiVaPassword(String soDienThoai, String password);

	public boolean chinhSua(NhanVienEntity nhanVienEntity);

	public List<NhanVienEntity> timKiem(String hoTen, String soDienThoai, String chucVu, String trangThai);

	public boolean doiMatKhau(String matKhauMoi, String soDienThoai);
//	public List<NhanVienEntity> getTheoTen(String ten);
}
