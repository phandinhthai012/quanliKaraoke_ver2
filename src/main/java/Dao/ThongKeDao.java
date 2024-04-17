package Dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;

import entities.HoaDonEntity;

public interface ThongKeDao extends Remote {
	public List<HoaDonEntity> duyetDanhSachHoaDonTheoNgay(LocalDate ngay)throws RemoteException;
	public List<HoaDonEntity> duyetDanhSachHoaDonTheoNamThang(LocalDate ngay)throws RemoteException;
	public List<HoaDonEntity> duyetDanhSachHoaDonTheoNam(LocalDate ngay)throws RemoteException;
	public double tinhTongTienDichVuCuaHoaDon(HoaDonEntity hoaDonEntity)throws RemoteException;
	
}
