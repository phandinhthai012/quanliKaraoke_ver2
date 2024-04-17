package Dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import entities.ChiTietDatPhongEntity;
import entities.PhongEntity;

public interface DatPhongDao extends Remote {
	public List<PhongEntity> timPhong(String trangThai, String loaiPhong, int soPhong, int sucChua) throws RemoteException;
	public boolean doiPhong(ChiTietDatPhongEntity chiTietDatPhongEntity, String maPhong) throws RemoteException;
	public List<PhongEntity> timPhongTrongTheoNgayVaGio(LocalDate ngay, LocalTime gioNhan, LocalTime gioTra) throws RemoteException;
	public List<ChiTietDatPhongEntity> duyetChiTietDatPhongChuaThanhToanTheoPhong(PhongEntity phongEntity) throws RemoteException;
}
