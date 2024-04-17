package Dao;

import java.rmi.RemoteException;
import java.util.List;

import entities.ChiTietPhieuDatPhongEntity;
import entities.PhieuDatPhongEntity;

public interface PhieuDatPhongDao extends java.rmi.Remote {
	public List<ChiTietPhieuDatPhongEntity> duyetChiTietPhieuDatPhongChuaThanhToan()throws RemoteException;

	public boolean themChiTietPhieuDatPhong(ChiTietPhieuDatPhongEntity chiTietPhieuDatPhongEntity)throws RemoteException;

	public ChiTietPhieuDatPhongEntity timChiTietPhieuDatPhongTheoMa(String maChiTietPhieuDatPhong)throws RemoteException;

	public List<ChiTietPhieuDatPhongEntity> timChiTietPhieuDatPhongTheoSoPhongVaMa(int soPhong, String maPhieuDatPhong)throws RemoteException;

	public List<ChiTietPhieuDatPhongEntity> timChiTietPhieuDatPhongTheoMaPhieuDatPhong(String maPhieuDatPhong)throws RemoteException;

	public boolean xoaChiTietPhieuDatPhong(String maChiTietDatPhong)throws RemoteException;

	public List<PhieuDatPhongEntity> duyetDanhSachDatPhong()throws RemoteException;

	public boolean themPhieuDatPhong(String maKhachHang)throws RemoteException;

	public PhieuDatPhongEntity timPhieuDatPhongTheoMa(String maPhieuDatPhong)throws RemoteException;
	public List<PhieuDatPhongEntity> timPhieuDatPhongTruocTheoSoPhongVaKhachHang(int soPhong, String khachHang)throws RemoteException;
	public PhieuDatPhongEntity timPhieuDatPhongVuaTao()throws RemoteException;
	public boolean xoaPhieuDatPhong(String maPhieuDatPhong)throws RemoteException;
	public List<PhieuDatPhongEntity> duyetDanhSachPhieuDatPhongChuaThanhToan()throws RemoteException;
	public List<ChiTietPhieuDatPhongEntity> duyetDanhSachChiTietPhieuDatPhongTheoPhieuDatPhong(String maPhieuDatPhong)throws RemoteException;
}
