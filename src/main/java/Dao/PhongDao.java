package Dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entities.LoaiPhong;
import entities.PhongEntity;

public interface PhongDao extends Remote {
	public LoaiPhong timTheoMaLoaiPhong(String maLoaiPhong)throws RemoteException;
	public LoaiPhong timTheoTenLoaiPhong(String tenLoaiPhong)throws RemoteException;
	/**
	 * duyệt toàn bộ danh sách loại phòng
	 */
	public List<LoaiPhong> duyetDanhSachLoaiPhong()throws RemoteException;
	/**
	 * thêm loại phòng
	 */
	public boolean themLoaiPhong(LoaiPhong loaiPhong)throws RemoteException;
	/**
	 * Xóa loại phòng
	 */
	public boolean xoaLoaiPhong(String maLoaiPhong) throws RemoteException;
	/**
	 * Chỉnh sửa loại phòng
	 */
	public boolean chinhSuaLoaiPhong(LoaiPhong loaiPhong)throws RemoteException;
	/***** PHÒNG *****/

	/**
	 * duyệt toàn bộ danh sách phòng
	 */
	public List<PhongEntity> duyetDanhSach()throws RemoteException;
	/**
	 * Thêm phòng
	 */
	public boolean themPhong(PhongEntity phongEntity)throws RemoteException;
	/**
	 * Chỉnh sửa phòng
	 */
	public boolean chinhSuaPhong(PhongEntity phongEntity)throws RemoteException;
	/**
	 * Xóa phòng
	 */
	public boolean xoaPhong(String maPhong)throws RemoteException;
	/**
	 * Tìm kiếm phòng
	 */
	public List<PhongEntity> timKiemPhong(int soPhong, int sucChua, String trangThai, String loaiPhong)throws RemoteException;
	
	public boolean capNhatTrangThaiPhong(PhongEntity phongEntity, String trangThai) throws RemoteException;
	public PhongEntity timTheoMa(String maPhong)throws RemoteException;
	
}
