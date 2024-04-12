package Dao;

import java.util.List;

import entities.DichVuEntity;
import entities.LoaiDichVu;

public interface DichVuDao {
	// Tìm theo mã loại dịch vụ
		public LoaiDichVu timTheoMaLoaiDichVu(String maLoaiDichVu);
		// TÌm theo ten loai dich vu
		public LoaiDichVu timTheoTenLoaiDichVu(String tenLoaiDichVu);
		/**
		 * duyệt toàn bộ danh sách loại dịch vu
		 */
		public List<LoaiDichVu> duyetDanhSachLoaiDichVu();
		/**
		 * thêm loại dich vu
		 */
		public boolean themLoaiDichVu(LoaiDichVu loaiDichVu);
		/**
		 * Xóa loại Dich Vụ
		 */
		public boolean xoaLoaiDichVu(String maLoaiDichVu);
		/**
		 * Chỉnh sửa loại phòng
		 */
		public boolean chinhSuaLoaiDichVu(LoaiDichVu loaiDichVu);
		// dich vu
		public List<DichVuEntity> duyetDanhSach();
		public boolean them(DichVuEntity dichVuEntity) ;
		public boolean xoa(String maDichVu) ;
		public boolean chinhSua(DichVuEntity dichVuEntity) ;
		/**
		 * @param loaiDV
		 * @param giaTu
		 * @param giaDen
		 * @return
		 */
		public List<DichVuEntity> timKiem(String loaiDV, Double giaTu, Double giaDen);
		public List<DichVuEntity> timKiemDichVu(String tenDV, String loaiDV, Double giaTu, Double giaDen);
		public DichVuEntity timTheoMa(String maDichVu);
}
