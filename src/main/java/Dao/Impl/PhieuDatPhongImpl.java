package Dao.Impl;

import java.util.List;

import Dao.PhieuDatPhongDao;
import entities.ChiTietPhieuDatPhongEntity;
import entities.PhieuDatPhongEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PhieuDatPhongImpl implements PhieuDatPhongDao {
	
	private String persistenceUnitName="quanliKaraoke_ver2 mssql";
	private EntityManager em;
	
	public PhieuDatPhongImpl() {
		this.em = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
	}

	@Override
	public List<ChiTietPhieuDatPhongEntity> duyetChiTietPhieuDatPhongChuaThanhToan() {
//		String query = "SELECT * FROM ChiTietPhieuDatPhong CTPDP\r\n"
//				+ "WHERE EXISTS (SELECT * FROM ChiTietDatPhong CTDP JOIN ChiTietHoaDon CTHD\r\n"
//				+ "	ON CTDP.MaChiTietDatPhong = CTHD.MaChiTietDatPhong JOIN Phong P\r\n"
//				+ "	ON CTDP.MaPhong = P.MaPhong\r\n"
//				+ "	WHERE CTDP.MaChiTietDatPhong = CTPDP.MaChiTietDatPhong AND MaHoaDon IS NULL)";
//		String query = "SELECT ct FROM ChiTietPhieuDatPhongEntity ct join ct.chiTietDatPhongEntity ctdp join ctdp.phongEntity p WHERE ctdp.maChiTietDatPhong = ct.chiTietDatPhong AND
//		                                                                                                          CTDP.MaChiTietDatPhong = CTPDP.MaChiTietDatPhong
		String query = "select ctpdp from ChiTietPhieuDatPhongEntity ctpdp join ctpdp.chiTietDatPhong ctdp join ctdp.chiTietHoaDon cthd where cthd.hoaDon is null";
//		String query = "Select ctpdp from ChiTietPhieuDatPhongEntity ctpdp join ctpdp.chiTietDatPhong ctdp join ctdp.chiTietHoaDon cthd where cthd.hoaDon is null";
		return em.createQuery(query, ChiTietPhieuDatPhongEntity.class).getResultList();
	}
	
	@Override
	public boolean themChiTietPhieuDatPhong(ChiTietPhieuDatPhongEntity chiTietPhieuDatPhongEntity) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(chiTietPhieuDatPhongEntity);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ChiTietPhieuDatPhongEntity timChiTietPhieuDatPhongTheoMa(String maChiTietPhieuDatPhong) {
//		String query = "select ctpdp from ChiTietPhieuDatPhongEntity ctpdp where ctpdp.maChiTietPhieuDatPhong = :maChiTietPhieuDatPhong";
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			ChiTietPhieuDatPhongEntity ctpdp = em.find(ChiTietPhieuDatPhongEntity.class, maChiTietPhieuDatPhong);
			tx.commit();
			return ctpdp;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ChiTietPhieuDatPhongEntity> timChiTietPhieuDatPhongTheoSoPhongVaMa(int soPhong,
			String maPhieuDatPhong) {
//		"SELECT * FROM ChiTietPhieuDatPhong CTPDP\r\n"
//				+ "WHERE MaPhieuDatPhong LIKE '%%%s%%' \r\n"
//				+ "	AND EXISTS (SELECT * FROM ChiTietDatPhong CTDP JOIN ChiTietHoaDon CTHD\r\n"
//				+ "		ON CTDP.MaChiTietDatPhong = CTHD.MaChiTietDatPhong JOIN Phong P\r\n"
//				+ "		ON CTDP.MaPhong = P.MaPhong\r\n"
//				+ "		WHERE CTDP.MaChiTietDatPhong = CTPDP.MaChiTietDatPhong AND MaHoaDon IS NULL AND SoPhong LIKE '%%%s%%')",
		String query = "select ctpdp from ChiTietPhieuDatPhongEntity ctpdp join ctpdp.chiTietDatPhong ctdp join ctdp.chiTietHoaDon cthd join ctdp.phong p where ctdp.maChiTietDatPhong = ctpdp.chiTietDatPhong.maChiTietDatPhong and cthd.hoaDon is null and p.soPhong =:soPhong and ctpdp.phieuDatPhong.maPhieuDatPhong =:maPhieuDatPhong"; 
		return em.createQuery(query, ChiTietPhieuDatPhongEntity.class).setParameter("soPhong", soPhong).setParameter("maPhieuDatPhong", maPhieuDatPhong).getResultList();
	}

	@Override
	public List<ChiTietPhieuDatPhongEntity> timChiTietPhieuDatPhongTheoMaPhieuDatPhong(String maPhieuDatPhong) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean xoaChiTietPhieuDatPhong(String maChiTietDatPhong) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PhieuDatPhongEntity> duyetDanhSachDatPhong() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean themPhieuDatPhong(String maKhachHang) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PhieuDatPhongEntity timPhieuDatPhongTheoMa(String maPhieuDatPhong) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PhieuDatPhongEntity> timPhieuDatPhongTruocTheoSoPhongVaKhachHang(int soPhong, String khachHang) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PhieuDatPhongEntity timPhieuDatPhongVuaTao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean xoaPhieuDatPhong(String maPhieuDatPhong) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PhieuDatPhongEntity> duyetDanhSachPhieuDatPhongChuaThanhToan() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChiTietPhieuDatPhongEntity> duyetDanhSachChiTietPhieuDatPhongTheoPhieuDatPhong(String maPhieuDatPhong) {
		// TODO Auto-generated method stub
		return null;
	}

}
