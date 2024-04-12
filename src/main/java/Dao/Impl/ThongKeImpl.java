package Dao.Impl;

import java.time.LocalDate;
import java.util.List;

import Dao.ThongKeDao;
import entities.HoaDonEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class ThongKeImpl implements ThongKeDao {
	
	private String persistenceUnitName = "quanliKaraoke_ver2 mssql";
	private EntityManager em;
	
	public ThongKeImpl() {
		em = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
	}
	@Override
	public List<HoaDonEntity> duyetDanhSachHoaDonTheoNgay(LocalDate ngay) {
		String query = "SELECT hd FROM HoaDonEntity hd WHERE hd.ngayLap =:ngay";
		return em.createQuery(query, HoaDonEntity.class).setParameter("ngay", ngay).getResultList();
		
	}

	@Override
	public List<HoaDonEntity> duyetDanhSachHoaDonTheoNamThang(LocalDate ngay) {
//		String query = "SELECT * FROM HoaDon\r\n"
//				+ "WHERE DATEPART(MM, NgayLap) = ? AND DATEPART(yyyy, NgayLap) = ?";
		String query = "SELECT hd FROM HoaDonEntity hd WHERE MONTH(hd.ngayLap) =:thang AND YEAR(hd.ngayLap) =:nam";
		return em.createQuery(query, HoaDonEntity.class).setParameter("thang", ngay.getMonthValue()).setParameter("nam", ngay.getYear()).getResultList();
	}

	@Override
	public List<HoaDonEntity> duyetDanhSachHoaDonTheoNam(LocalDate ngay) {
		String query = "SELECT hd FROM HoaDonEntity hd WHERE YEAR(hd.ngayLap) =:nam";
		return em.createQuery(query, HoaDonEntity.class).setParameter("nam", ngay.getYear()).getResultList();
	}

	@Override
	public double tinhTongTienDichVuCuaHoaDon(HoaDonEntity hoaDonEntity) {
//		String query = "SELECT SUM((SoLuong*Gia)) AS N'Tổng' FROM ChiTietDichVu CTDV\r\n"
//				+ "JOIN ChiTietHoaDon CTHD ON CTHD.MaChiTietHoaDon = CTDV.MaChiTietHoaDon\r\n"
//				+ "JOIN HoaDon HD ON HD.MaHoaDon = CTHD.MaHoaDon \r\n"
//				+ "JOIN DichVu DV ON DV.MaDichVu = CTDV.MaDichVu\r\n" + "WHERE CTHD.MaHoaDon = ?";
		String query = "SELECT SUM(ctdv.soLuong*ctdv.gia) FROM ChiTietDichVuEntity ctdv JOIN ctdv.chiTietHoaDon cthd JOIN cthd.hoaDon hd WHERE hd.maHoaDon =:maHoaDon";
		return em.createQuery(query, Double.class).setParameter("maHoaDon", hoaDonEntity.getMaHoaDon()).getSingleResult();
	}

}
