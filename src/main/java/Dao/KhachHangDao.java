package Dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entities.KhachHangEntity;

public interface KhachHangDao extends Remote {

	public List<KhachHangEntity> duyetDanhSach() throws RemoteException;
	public KhachHangEntity them(KhachHangEntity khachHangEntity)throws RemoteException;
	public int chinhSua(KhachHangEntity khachHangEntity)throws RemoteException;
	public KhachHangEntity timTheoMa(String MaKhachHang)throws RemoteException;
	public KhachHangEntity timTheoSoDienThoai(String soDienThoai)throws RemoteException;
	public List<KhachHangEntity> timKiem(String hoTen, String soDienThoai, int slTu, int slDen)throws RemoteException;
}
