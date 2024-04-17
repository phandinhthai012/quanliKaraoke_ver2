package Dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entities.ChiTietHoaDonEntity;
import entities.HoaDonEntity;
import entities.KhachHangEntity;
import entities.PhieuDatPhongEntity;

public interface LapHoaDonDao extends Remote {
	public int demSoLuongPhong(String maPhieuDatPhong)throws RemoteException;
	public double tinhTienDichVu(String maPhieuDatPhong)throws RemoteException;
	public boolean themHoaDon(HoaDonEntity hoaDonEntity)throws RemoteException;
	public List<ChiTietHoaDonEntity> duyetDanhSachChiTietHoaDon(String maPhieuDatPhong)throws RemoteException;
	public boolean capNhatChiTietHoaDon(ChiTietHoaDonEntity chiTietHoaDonEntity, String maHoaDon)throws RemoteException;
	public HoaDonEntity timHoaDonVuaTao()throws RemoteException;
	public List<PhieuDatPhongEntity> timHoaDonTheoKhachHang(KhachHangEntity khachHangEntity)throws RemoteException;
	
}
