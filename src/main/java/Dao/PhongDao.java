package Dao;

import java.util.List;

import entities.LoaiPhong;
import entities.PhongEntity;

public interface PhongDao {
	public LoaiPhong timTheoMaLoaiPhong(String maLoaiPhong);
	public LoaiPhong timTheoTenLoaiPhong(String tenLoaiPhong);
	/**
	 * duyệt toàn bộ danh sách loại phòng
	 */
	public List<LoaiPhong> duyetDanhSachLoaiPhong();
	/**
	 * thêm loại phòng
	 */
	public boolean themLoaiPhong(LoaiPhong loaiPhong);
	/**
	 * Xóa loại phòng
	 */
	public boolean xoaLoaiPhong(String maLoaiPhong) ;
	/**
	 * Chỉnh sửa loại phòng
	 */
	public boolean chinhSuaLoaiPhong(LoaiPhong loaiPhong);
	/***** PHÒNG *****/

	/**
	 * duyệt toàn bộ danh sách phòng
	 */
	public List<PhongEntity> duyetDanhSach();
	/**
	 * Thêm phòng
	 */
	public boolean themPhong(PhongEntity phongEntity);
	/**
	 * Chỉnh sửa phòng
	 */
	public boolean chinhSuaPhong(PhongEntity phongEntity);
	/**
	 * Xóa phòng
	 */
	public boolean xoaPhong(String maPhong);
	/**
	 * Tìm kiếm phòng
	 */
	public List<PhongEntity> timKiemPhong(int soPhong, int sucChua, String trangThai, String loaiPhong);
	
	public boolean capNhatTrangThaiPhong(PhongEntity phongEntity, String trangThai);
	public PhongEntity timTheoMa(String maPhong);
	
}
