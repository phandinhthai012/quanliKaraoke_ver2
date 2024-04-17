package Dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entities.DichVuEntity;
import entities.LoaiDichVu;

public interface DichVuDao extends Remote {
	// Tìm theo mã loại dịch vụ
	public LoaiDichVu timTheoMaLoaiDichVu(String maLoaiDichVu) throws RemoteException;

	// TÌm theo ten loai dich vu
	public LoaiDichVu timTheoTenLoaiDichVu(String tenLoaiDichVu) throws RemoteException;

	/**
	 * duyệt toàn bộ danh sách loại dịch vu
	 */
	public List<LoaiDichVu> duyetDanhSachLoaiDichVu() throws RemoteException;

	/**
	 * thêm loại dich vu
	 */
	public boolean themLoaiDichVu(LoaiDichVu loaiDichVu) throws RemoteException;

	/**
	 * Xóa loại Dich Vụ
	 */
	public boolean xoaLoaiDichVu(String maLoaiDichVu) throws RemoteException;

	/**
	 * Chỉnh sửa loại phòng
	 */
	public boolean chinhSuaLoaiDichVu(LoaiDichVu loaiDichVu) throws RemoteException;

	// dich vu
	public List<DichVuEntity> duyetDanhSach() throws RemoteException;

	public boolean them(DichVuEntity dichVuEntity) throws RemoteException;

	public boolean xoa(String maDichVu) throws RemoteException;

	public boolean chinhSua(DichVuEntity dichVuEntity) throws RemoteException;

	/**
	 * @param loaiDV
	 * @param giaTu
	 * @param giaDen
	 * @return
	 */
	public List<DichVuEntity> timKiem(String loaiDV, Double giaTu, Double giaDen) throws RemoteException;

	public List<DichVuEntity> timKiemDichVu(String tenDV, String loaiDV, Double giaTu, Double giaDen) throws RemoteException;

	public DichVuEntity timTheoMa(String maDichVu) throws RemoteException;
}
