package Dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entities.NhanVienEntity;

public interface NhanVienDao extends Remote {
	public List<NhanVienEntity> duyetDanhSach()throws RemoteException;

	public List<NhanVienEntity> duyetDanhSachNhanVienDangLamViec()throws RemoteException;

	public NhanVienEntity timTheoMa(String maNhanvien)throws RemoteException;

	public NhanVienEntity timTheoTenVaSoDienThoai(String hoTen, String soDienThoai)throws RemoteException;

	public boolean them(NhanVienEntity nhanVienEntity)throws RemoteException;

	public NhanVienEntity timTheoSoDienThoaiVaPassword(String soDienThoai, String password)throws RemoteException;

	public boolean chinhSua(NhanVienEntity nhanVienEntity)throws RemoteException;

	public List<NhanVienEntity> timKiem(String hoTen, String soDienThoai, String chucVu, String trangThai)throws RemoteException;

	public boolean doiMatKhau(String matKhauMoi, String soDienThoai)throws RemoteException;
//	public List<NhanVienEntity> getTheoTen(String ten);
}
