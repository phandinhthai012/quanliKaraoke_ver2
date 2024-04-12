package Dao.Impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import Dao.DatPhongDao;
import entities.ChiTietDatPhongEntity;
import entities.PhongEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DatPhongImpl implements DatPhongDao{
	private String persistenceUnitName = "quanliKaraoke_ver2 mssql";
	private EntityManager em;
	
	public DatPhongImpl() {
		em = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
	}

	@Override
	public List<PhongEntity> timPhong(String trangThai, String loaiPhong, int soPhong, int sucChua) {
//	    String query = "SELECT p FROM PhongEntity p WHERE p.trangThai LIKE :trangThai AND p.loaiPhong.tenLoaiPhong LIKE :loaiPhong AND p.soPhong like :soPhong AND p.sucChua like :sucChua";
		String query = "SELECT p FROM PhongEntity p WHERE p.trangThai LIKE :trangThai AND p.loaiPhong.tenLoaiPhong LIKE :loaiPhong AND p.soPhong = :soPhong AND p.sucChua = :sucChua";
		List<PhongEntity> list = new ArrayList<PhongEntity>()	;
		return em.createQuery(query, PhongEntity.class).setParameter("trangThai", trangThai).setParameter("loaiPhong", loaiPhong).setParameter("soPhong", soPhong).setParameter("sucChua", sucChua).getResultList();
	}

	@Override
	public boolean doiPhong(ChiTietDatPhongEntity chiTietDatPhongEntity, String maPhong) {
		chiTietDatPhongEntity.getPhong().setMaPhong(maPhong);
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(chiTietDatPhongEntity);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<PhongEntity> timPhongTrongTheoNgayVaGio(LocalDate ngay, LocalTime gioNhan, LocalTime gioTra) {
		String query = "SELECT p FROM PhongEntity p WHERE p.maPhong NOT IN (SELECT c.phong.maPhong FROM ChiTietDatPhongEntity c WHERE c.ngayDat = :ngay AND c.gioNhan < :gioTra AND c.gioTra > :gioNhan)";
		return em.createQuery(query, PhongEntity.class).setParameter("ngay", ngay).setParameter("gioNhan", gioNhan).setParameter("gioTra", gioTra).getResultList();
	}

	@Override
	public List<ChiTietDatPhongEntity> duyetChiTietDatPhongChuaThanhToanTheoPhong(PhongEntity phongEntity) {
        String query = "SELECT c FROM ChiTietDatPhongEntity c  join c.chiTietHoaDon h WHERE c.phong.maPhong = :phong AND h.hoaDon IS NULL order by c.ngayDatPhong";
        return em.createQuery(query, ChiTietDatPhongEntity.class).setParameter("phong", phongEntity.getMaPhong()).getResultList();
		
	}

}
