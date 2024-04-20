package Dao.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.List;

import Dao.ThongKeDao;
import entities.HoaDonEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class ThongKeImpl extends UnicastRemoteObject implements ThongKeDao {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String persistenceUnitName = "quanliKaraoke_ver2 mssql";
	private EntityManager em;
	
	public ThongKeImpl() throws RemoteException {
		em = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
	}
	@Override
	public List<HoaDonEntity> duyetDanhSachHoaDonTheoNgay(LocalDate ngay) throws RemoteException {
		String query = "SELECT hd FROM HoaDonEntity hd WHERE hd.ngayLap =:ngay";
//		return em.createQuery(query, HoaDonEntity.class).setParameter("ngay", DateFormatter.formatSql(ngay)).getResultList();
		return em.createQuery(query, HoaDonEntity.class).setParameter("ngay", ngay).getResultList();	
	}

	@Override
	public List<HoaDonEntity> duyetDanhSachHoaDonTheoNamThang(LocalDate ngay)throws RemoteException  {
//		String query = "SELECT * FROM HoaDon\r\n"
//				+ "WHERE DATEPART(MM, NgayLap) = ? AND DATEPART(yyyy, NgayLap) = ?";
		String query = "SELECT hd FROM HoaDonEntity hd WHERE MONTH(hd.ngayLap) =:thang AND YEAR(hd.ngayLap) =:nam";
		return em.createQuery(query, HoaDonEntity.class).setParameter("thang", ngay.getMonthValue()).setParameter("nam", ngay.getYear()).getResultList();
	}

	@Override
	public List<HoaDonEntity> duyetDanhSachHoaDonTheoNam(LocalDate ngay)throws RemoteException  {
		String query = "SELECT hd FROM HoaDonEntity hd WHERE YEAR(hd.ngayLap) =:nam";
		return em.createQuery(query, HoaDonEntity.class).setParameter("nam", ngay.getYear()).getResultList();
	}

	@Override
	public double tinhTongTienDichVuCuaHoaDon(HoaDonEntity hoaDonEntity)throws RemoteException  {

////		String query = "SELECT SUM(ctdv.soLuong*ctdv.gia) FROM ChiTietDichVuEntity ctdv JOIN ctdv.chiTietHoaDon cthd JOIN cthd.hoaDon hd WHERE hd.maHoaDon =:maHoaDon";
//		String query = "SELECT SUM(ctdv.soLuongtdv.gia) FROM ChiTietDichVuEntity ctdv join ctdv.chiTietHoaDon cthd join cthd.hoaDon hd WHERE hd join ctdv.dichVu dv WHERE hd.maHoaDon =:maHoaDon";
//		return em.createQuery(query, Double.class).setParameter("maHoaDon", hoaDonEntity.getMaHoaDon()).getSingleResult();
		
		String query = "SELECT SUM((SoLuong*Gia)) AS N'Tổng' FROM ChiTietDichVu CTDV\r\n"
				+ "JOIN ChiTietHoaDon CTHD ON CTHD.MaChiTietHoaDon = CTDV.MaChiTietHoaDon\r\n"
				+ "JOIN HoaDon HD ON HD.MaHoaDon = CTHD.MaHoaDon \r\n"
				+ "JOIN DichVu DV ON DV.MaDichVu = CTDV.MaDichVu\r\n" + "WHERE CTHD.MaHoaDon = ?";
		Object rs  = em.createNativeQuery(query).setParameter(1, hoaDonEntity.getMaHoaDon()).getSingleResult();
		return rs == null ? 0 : Double.parseDouble(rs.toString());
		
		
	
	}
}
