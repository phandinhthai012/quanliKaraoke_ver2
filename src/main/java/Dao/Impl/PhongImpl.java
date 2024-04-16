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
		String query = "INSERT LoaiPhong (TenLoai)\r\n" + "VALUES (?)";
		try {
			tr.begin();
			boolean result = em.createNativeQuery(query).setParameter(1, loaiPhong.getTenLoaiPhong()).executeUpdate() > 0;
			tr.commit();
			return result;
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
		String query = "SELECT p FROM PhongEntity p join p.loaiPhong lp";
		return em.createQuery(query, PhongEntity.class).getResultList();
	}

	@Override
	public boolean themPhong(PhongEntity phongEntity) {
		EntityTransaction tr = em.getTransaction();
		String query = "INSERT Phong (SoPhong, MaLoaiPhong, SucChua, TrangThai)\r\n" + "VALUES(?, ?, ?, ?)";
		try {
			tr.begin();
			boolean result = em.createNativeQuery(query).setParameter(1, phongEntity.getSoPhong())
					.setParameter(2, phongEntity.getLoaiPhong().getMaLoai()).setParameter(3, phongEntity.getSucChua())
					.setParameter(4, phongEntity.getTrangThai()).executeUpdate() > 0;
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
//		String query = "SELECT p FROM PhongEntity p WHERE p.soPhong LIKE :soPhong AND p.sucChua LIKE :sucChua AND p.trangThai LIKE :trangThai AND p.loaiPhong.tenLoaiPhong LIKE :loaiPhong";
//
//		return em.createQuery(query, PhongEntity.class).setParameter("soPhong", soPhong)
//				.setParameter("sucChua", sucChua).setParameter("trangThai", trangThai)
//				.setParameter("loaiPhong", loaiPhong).getResultList();
		StringBuilder query = new StringBuilder(
				"SELECT MaPhong, SoPhong, LP.MaLoaiPhong, TenLoai, SucChua, TrangThai\r\n"
						+ " FROM [dbo].[Phong] P JOIN [dbo].[LoaiPhong] LP ON P.MaLoaiPhong = LP.MaLoaiPhong ");
		if (soPhong >= 0 && sucChua >= 0 && !trangThai.equals("") && !loaiPhong.equals("Tất cả")) {
			// soPhong + sucChua + trangThai + loaiPhong
			query.append(String.format(
					"WHERE SoPhong = %d AND SucChua = %d AND TrangThai LIKE N'%%%s%%' AND TenLoai LIKE N'%%%s%%'",
					soPhong, sucChua, trangThai, loaiPhong));
		} else if (soPhong >= 0 && sucChua == -1 && trangThai.equals("") && loaiPhong.equals("Tất cả")) {
			// soPhong
			query.append(String.format("WHERE SoPhong = %d", soPhong));
		} else if (soPhong >= 0 && sucChua >= 0 && trangThai.equals("") && loaiPhong.equals("Tất cả")) {
			// soPhong + sucChua
			query.append(String.format("WHERE SoPhong = %d AND SucChua = %d", soPhong, sucChua));
		} else if (soPhong >= 0 && sucChua >= 0 && !trangThai.equals("") && loaiPhong.equals("Tất cả")) {
			// soPhong + sucChua + trangThai
			query.append(String.format("WHERE SoPhong = %d AND SucChua = %d AND TrangThai LIKE N'%%%s%%'",
					soPhong, sucChua, trangThai));
		} else if (soPhong >= 0 && sucChua >= 0 && trangThai.equals("") && !loaiPhong.equals("Tất cả")) {
			// soPhong + sucChua + loaiPhong
			query.append(String.format("WHERE SoPhong = %d AND SucChua = %d AND TenLoai LIKE N'%%%s%%'",
					soPhong, sucChua, loaiPhong));
		} else if (soPhong == -1 && sucChua >= 0 && trangThai.equals("") && loaiPhong.equals("Tất cả")) {
			// sucChua
			query.append(String.format("WHERE SucChua = %d", sucChua));
		} else if (soPhong == -1 && sucChua >= 0 && !trangThai.equals("") && loaiPhong.equals("Tất cả")) {
			// sucChua + trangThai
			query.append(String.format("WHERE SucChua = %d AND TrangThai LIKE N'%%%s%%'", sucChua, trangThai));
		} else if (soPhong == -1 && sucChua >= 0 && trangThai.equals("") && !loaiPhong.equals("Tất cả")) {
			// sucChua + loaiPhong
			query.append(String.format("WHERE SucChua = %d AND TenLoai LIKE N'%%%s%%'", soPhong, sucChua,
					trangThai, loaiPhong));
		} else if (soPhong == -1 && sucChua >= 0 && !trangThai.equals("") && !loaiPhong.equals("Tất cả")) {
			// sucChua + trangThai + loaiPhong
			query.append(
					String.format("WHERE SucChua = %d AND TrangThai LIKE N'%%%s%%' AND TenLoai LIKE N'%%%s%%'",
							sucChua, trangThai, loaiPhong));

		} else if (soPhong == -1 && sucChua == -1 && !trangThai.equals("") && loaiPhong.equals("Tất cả")) {
			// trangThai
			query.append(String.format("WHERE TrangThai LIKE N'%%%s%%'", trangThai));
		} else if (soPhong == -1 && sucChua == -1 && !trangThai.equals("") && !loaiPhong.equals("Tất cả")) {
			// trangThai + loaiPhong
			query.append(String.format("WHERE TrangThai LIKE N'%%%s%%' AND TenLoai LIKE N'%%%s%%'", trangThai,
					loaiPhong));
		} else if (soPhong == -1 && sucChua == -1 && trangThai.equals("") && !loaiPhong.equals("Tất cả")) {
			// loaiPhong
			query.append(String.format("WHERE TenLoai LIKE N'%%%s%%'", loaiPhong));
		}
		return em.createNativeQuery(query.toString(), PhongEntity.class).getResultList();
		
	}

	@Override
	public boolean capNhatTrangThaiPhong(PhongEntity phongEntity, String trangThai) {
//		"UPDATE Phong\r\n" + "SET TrangThai = ?\r\n" + "WHERE MaPhong LIKE ?";
		String query = "UPDATE PhongEntity p SET p.trangThai = :trangThai WHERE p.maPhong LIKE :maPhong";
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.createQuery(query).setParameter("trangThai", trangThai).setParameter("maPhong", phongEntity.getMaPhong())
					.executeUpdate();
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public PhongEntity timTheoMa(String maPhong) {
		
		return em.find(PhongEntity.class, maPhong);
	}

}
