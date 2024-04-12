package Dao.Impl;

import java.util.List;

import Dao.PhongDao;
import entities.LoaiPhong;
import entities.PhongEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PhongImpl implements PhongDao {
	private String persistenceUnitName = "quanliKaraoke_ver2 mssql";
	private EntityManager em;

	public PhongImpl() {
		em = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
	}

	@Override
	public LoaiPhong timTheoMaLoaiPhong(String maLoaiPhong) {
		return em.find(LoaiPhong.class, maLoaiPhong);
	}

	@Override
	public LoaiPhong timTheoTenLoaiPhong(String tenLoaiPhong) {
		String query = "SELECT l FROM LoaiPhong l WHERE l.tenLoaiPhong = :tenLoai";
		return em.createQuery(query, LoaiPhong.class).setParameter("tenLoai", tenLoaiPhong).getSingleResult();
	}

	@Override
	public List<LoaiPhong> duyetDanhSachLoaiPhong() {
		String query = "SELECT l FROM LoaiPhong l";
		return em.createQuery(query, LoaiPhong.class).getResultList();
	}

	@Override
	public boolean themLoaiPhong(LoaiPhong loaiPhong) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(loaiPhong);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean xoaLoaiPhong(String maLoaiPhong) {
		EntityTransaction tr = em.getTransaction();
		LoaiPhong loaiPhong = em.find(LoaiPhong.class, maLoaiPhong);
		if (loaiPhong == null) {
			return false;
		}
		try {
			tr.begin();
			em.remove(loaiPhong);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean chinhSuaLoaiPhong(LoaiPhong loaiPhong) {
		// UPDATE LoaiPhong\r\n" + "SET TenLoai = ?\r\n" + "WHERE MaLoaiPhong LIKE ?";
		EntityTransaction tr = em.getTransaction();
		LoaiPhong lp = em.find(LoaiPhong.class, loaiPhong.getMaLoai());
		if (lp == null) {
			return false;
		}
		try {
			tr.begin();
			em.merge(loaiPhong);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<PhongEntity> duyetDanhSach() {
		// SELECT MaPhong, SoPhong, LP.MaLoaiPhong, TenLoai, SucChua, TrangThai\r\n"
//				+ "FROM [dbo].[Phong] P JOIN [dbo].[LoaiPhong] LP ON P.MaLoaiPhong = LP.MaLoaiPhong
		String query = "SELECT p FROM PhongEntity p";
		return em.createQuery(query, PhongEntity.class).getResultList();
	}

	@Override
	public boolean themPhong(PhongEntity phongEntity) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(phongEntity);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean chinhSuaPhong(PhongEntity phongEntity) {
		EntityTransaction tr = em.getTransaction();
		PhongEntity pe = em.find(PhongEntity.class, phongEntity.getMaPhong());
		if (pe == null) {
			return false;
		}
		try {
			tr.begin();
			em.merge(phongEntity);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean xoaPhong(String maPhong) {
		EntityTransaction tr = em.getTransaction();
		PhongEntity pe = em.find(PhongEntity.class, maPhong);
		if (pe == null) {
			return false;
		}
		try {
			tr.begin();
			em.remove(pe);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<PhongEntity> timKiemPhong(int soPhong, int sucChua, String trangThai, String loaiPhong) {
		String query = "SELECT p FROM PhongEntity p WHERE p.soPhong LIKE :soPhong AND p.sucChua LIKE :sucChua AND p.trangThai LIKE :trangThai AND p.loaiPhong.tenLoaiPhong LIKE :loaiPhong";

		return em.createQuery(query, PhongEntity.class).setParameter("soPhong", soPhong)
				.setParameter("sucChua", sucChua).setParameter("trangThai", trangThai)
				.setParameter("loaiPhong", loaiPhong).getResultList();
	}

	@Override
	public boolean capNhatTrangThaiPhong(PhongEntity phongEntity, String trangThai) {
//		"UPDATE Phong\r\n" + "SET TrangThai = ?\r\n" + "WHERE MaPhong LIKE ?";
		String query = "UPDATE PhongEntity p SET p.trangThai = :trangThai WHERE p.maPhong LIKE :maPhong";
		EntityTransaction tr = em.getTransaction();
		return false;
	}

	@Override
	public PhongEntity timTheoMa(String maPhong) {
		
		return em.find(PhongEntity.class, maPhong);
	}

}
