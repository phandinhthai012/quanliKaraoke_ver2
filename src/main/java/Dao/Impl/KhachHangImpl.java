package Dao.Impl;

import java.util.ArrayList;
import java.util.List;

import Dao.KhachHangDao;
import entities.KhachHangEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class KhachHangImpl implements KhachHangDao {
	
	private String persistenceUnitName ="quanliKaraoke_ver2 mssql";
	private EntityManager em;
	
	public KhachHangImpl() {
		em = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
	}

	@Override
	public List<KhachHangEntity> duyetDanhSach() {
		String query = "SELECT kh FROM KhachHangEntity kh";
		return em.createQuery(query, KhachHangEntity.class).getResultList();
	}

	@Override
	public KhachHangEntity them(KhachHangEntity khachHangEntity) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(khachHangEntity);
			tx.commit();
			return khachHangEntity;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int chinhSua(KhachHangEntity khachHangEntity) {
		EntityTransaction tx = em.getTransaction();
		KhachHangEntity exitsKhachHang = em.find(KhachHangEntity.class, khachHangEntity.getMaKhachHang());
		if(exitsKhachHang == null)
			return 0;
		try {
			tx.begin();
			em.merge(khachHangEntity);
			tx.commit();
			return 1;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public KhachHangEntity timTheoMa(String MaKhachHang) {
		return em.find(KhachHangEntity.class, MaKhachHang);
	}

	@Override
	public KhachHangEntity timTheoSoDienThoai(String soDienThoai) {
		String query = "SELECT kh FROM KhachHangEntity kh WHERE kh.soDienThoai = :soDienThoai";
		KhachHangEntity kh = em.createQuery(query, KhachHangEntity.class).setParameter("soDienThoai", soDienThoai).getSingleResult();
		return kh;
	}

	@Override
	public List<KhachHangEntity> timKiem(String hoTen, String soDienThoai, int slTu, int slDen) {
		List<KhachHangEntity> listKhachHang = new ArrayList<>();
		String query = "SELECT kh FROM KhachHangEntity kh where kh.hoTen like :hoTen and kh.soDienThoai like :soDienThoai and kh.soLanDatPhong >= :slTu and kh.soLanDatPhong <= :slDen";
		listKhachHang = em.createQuery(query, KhachHangEntity.class).setParameter("hoTen", hoTen).setParameter("soDienThoai", soDienThoai).setParameter("slTu", slTu).setParameter("slDen", slDen).getResultList();
		return listKhachHang;
	}	
}
