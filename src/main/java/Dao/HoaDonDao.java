package Dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entities.ChiTietDatPhongEntity;
import entities.ChiTietDichVuEntity;
import entities.ChiTietHoaDonEntity;
import entities.PhongEntity;

public interface HoaDonDao extends Remote {
	public boolean themChiTietHoaDon(String maChiTietDatPhong) throws RemoteException;
	public boolean xoaChiTietHoaDon(String maChiTietDatPhong)throws RemoteException;
	public ChiTietHoaDonEntity timChiTietHoaDonTheoChiTietDatPhong(ChiTietDatPhongEntity chiTietDatPhongEntity)throws RemoteException;
	public List<ChiTietHoaDonEntity> duyetDanhSachChiTietHoaDonTheoMaHoaDon(String maHoaDon)throws RemoteException;
	public boolean themChiTietDatPhong(ChiTietDatPhongEntity chiTietDatPhongEntity)throws RemoteException;
	public boolean xoaChiTietDatPhong(String maChiTietDatPhong)throws RemoteException;
	public ChiTietDatPhongEntity timChiTietDatPhongTheoMa(String maChiTietDatPhong)throws RemoteException;
	public List<ChiTietDatPhongEntity> timChiTietDatPhongChuaThanhToanTheoPhong(PhongEntity phongEntity)throws RemoteException;
	public List<ChiTietDatPhongEntity> timChiTietDatPhongChuaThanhToan()throws RemoteException;
	public ChiTietDatPhongEntity timChiTietDatPhongVuaTao()throws RemoteException;
	public ChiTietDatPhongEntity timChiTietDatPhongTheoMaPhongDeNhanPhong(String maPhong)throws RemoteException;
	public List<ChiTietDichVuEntity> duyetDanhSachChiTietDichVuTheoChiTietHoaDon(String maChiTietHoaDon)throws RemoteException;
	public boolean xoaChiTietDichvuTheoMaHoaDon(String maChiTietHoaDon)throws RemoteException;
	public boolean xoaChiTietDichvuTheoMaChiTietDichVu(String maChiTietDichVu)throws RemoteException;
	public boolean themChiTietDichVu(ChiTietDichVuEntity chiTietDichVuEntity, ChiTietHoaDonEntity chiTietHoaDonEntity)throws RemoteException;
	public boolean chinhSuaChiTietDichVuTheoMa(String maChiTietDichVu, int soLuong)throws RemoteException;
}
