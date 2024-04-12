package Dao.Impl;

import java.util.List;

import javax.swing.JOptionPane;

import Dao.DichVuDao;
import entities.DichVuEntity;
import entities.LoaiDichVu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DichVuImpl implements DichVuDao {

	private String persistenceUnitName = "quanliKaraoke_ver2 mssql";
	private EntityManager em;

	public DichVuImpl() {
		em = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
	}

	@Override
	public LoaiDichVu timTheoMaLoaiDichVu(String maLoaiDichVu) {
		return em.find(LoaiDichVu.class, maLoaiDichVu);
	}

	@Override
	public LoaiDichVu timTheoTenLoaiDichVu(String tenLoaiDichVu) {
		String query = "SELECT l FROM LoaiDichVu l WHERE l.tenLoaiDichVu like :tenLoaiDichVu";
		return em.createQuery(query, LoaiDichVu.class).setParameter("tenLoaiDichVu", "%"+tenLoaiDichVu+"%").getSingleResult();
	}

	@Override
	public List<LoaiDichVu> duyetDanhSachLoaiDichVu() {
		String query = "SELECT l FROM LoaiDichVu l";
		return em.createQuery(query, LoaiDichVu.class).getResultList();
	}

	@Override
	public boolean themLoaiDichVu(LoaiDichVu loaiDichVu) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(loaiDichVu);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return false;
		}
	}

	@Override
	public boolean xoaLoaiDichVu(String maLoaiDichVu) {
		EntityTransaction tr = em.getTransaction();
		LoaiDichVu loaiDichVu = timTheoMaLoaiDichVu(maLoaiDichVu);
		if (loaiDichVu == null)
			return false;
		try {
			tr.begin();
			em.remove(loaiDichVu);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return false;
		}
	}

	@Override
	public boolean chinhSuaLoaiDichVu(LoaiDichVu loaiDichVu) {
		EntityTransaction tr = em.getTransaction();
		LoaiDichVu loaiDichVu2 = timTheoMaLoaiDichVu(loaiDichVu.getMaLoaiDichVu());
		if (loaiDichVu2 == null)
			return false;
		try {
			tr.begin();
			loaiDichVu2.setTenLoaiDichVu(loaiDichVu.getTenLoaiDichVu());
			em.merge(loaiDichVu2);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public List<DichVuEntity> duyetDanhSach() {
		String query = "SELECT d FROM DichVuEntity d";
		return em.createQuery(query, DichVuEntity.class).getResultList();
	}

	@Override
	public boolean them(DichVuEntity dichVuEntity) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(dichVuEntity);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return false;
		}
	}

	@Override
	public boolean xoa(String maDichVu) {
		EntityTransaction tr = em.getTransaction();
		DichVuEntity dichVuEntity = timTheoMa(maDichVu);
		if (dichVuEntity == null)
			return false;
		try {
			tr.begin();
			em.remove(dichVuEntity);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return false;
		}
	}

	@Override
	public boolean chinhSua(DichVuEntity dichVuEntity) {
		EntityTransaction tr = em.getTransaction();
		DichVuEntity dichVuEntity2 = timTheoMa(dichVuEntity.getMaDichVu());
		if (dichVuEntity2 == null)
			return false;
		try {
			tr.begin();
			em.merge(dichVuEntity);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public List<DichVuEntity> timKiem(String loaiDV, Double giaTu, Double giaDen) {
//		StringBuilder query = new StringBuilder(
//				"SELECT MaDichVu, TenDichVu, LD.MaLoaiDichVu, TenLoaiDichVu, Gia\r\n"
//						+ "FROM [dbo].[DichVu] D JOIN [dbo].[LoaiDichVu] LD ON D.MaLoaiDichVu = LD.MaLoaiDichVu ");
//
//		if (!loaiDV.equalsIgnoreCase("Tất cả") && (giaTu != null && giaDen != null)) {
//			// loáº¡iDV + gia
//			query.append(String.format("WHERE TenLoaiDichVu LIKE N'%%%s%%' AND Gia >= %s AND Gia <= %s", loaiDV,
//					giaTu.floatValue(), giaDen.floatValue()));
//
//		} else if (!loaiDV.equalsIgnoreCase("Tất cả") && (giaTu == null && giaDen == null)) {
//			// loaiDV
//			query.append(String.format("WHERE TenLoaiDichVu LIKE N'%%%s%%'", loaiDV));
//		} else if (loaiDV.equalsIgnoreCase("Tất cả") && (giaTu != null && giaDen != null)) {
//			// gia
//			query.append(
//					String.format("WHERE Gia >= %s AND Gia <= %s", giaTu.floatValue(), giaDen.floatValue()));
//		}
		String query = "SELECT d FROM DichVuEntity d WHERE d.loaiDichVu.tenLoaiDichVu like :loaiDV AND d.gia >= :giaTu AND d.gia <= :giaDen";
		if (loaiDV.equalsIgnoreCase("Tất cả")) {
			loaiDV = "";
		}
		if (giaTu == null || giaDen == null) {
			String query2 = "SELECT d FROM DichVuEntity d WHERE d.loaiDichVu.tenLoaiDichVu like :loaiDV";
			return em.createQuery(query2, DichVuEntity.class).setParameter("loaiDV","%"+loaiDV+"%").getResultList();
		}
		return em.createQuery(query, DichVuEntity.class).setParameter("loaiDV","%"+loaiDV+"%").setParameter("giaTu", giaTu)
				.setParameter("giaDen", giaDen).getResultList();
	}

	@Override
	public List<DichVuEntity> timKiemDichVu(String tenDV, String loaiDV, Double giaTu, Double giaDen) {
		StringBuilder query = new StringBuilder(
				"SELECT MaDichVu, TenDichVu, LD.MaLoaiDichVu, TenLoaiDichVu, Gia\r\n"
						+ "FROM [dbo].[DichVu] D JOIN [dbo].[LoaiDichVu] LD ON D.MaLoaiDichVu = LD.MaLoaiDichVu ");
		if (!tenDV.equals("") && !loaiDV.equalsIgnoreCase("Tất cả") && (giaTu != null && giaDen != null)) {
			// TenDV + loaiDV + gia
			query.append(String.format(
					"WHERE TenDichVu LIKE N'%%%s%%' AND TenLoaiDichVu LIKE N'%%%s%%' AND (Gia >= %s AND Gia <= %s)",
					tenDV, loaiDV, giaTu.doubleValue(), giaDen.doubleValue()));
		} else if (!tenDV.equals("") && !loaiDV.equalsIgnoreCase("Tất cả")
				&& (giaTu == null && giaDen == null)) {
			query.append(String.format("WHERE TenDichVu LIKE N'%%%s%%' AND TenLoaiDichVu LIKE N'%%%s%%'", tenDV,
					loaiDV));
			// TenDV + LoaiDV
		} else if (!tenDV.equals("") && loaiDV.equalsIgnoreCase("Tất cả")
				&& (giaTu != null && giaDen != null)) {
			query.append(String.format("WHERE TenDichVu LIKE N'%%%s%%' AND (Gia >= %s AND Gia <= %s)", tenDV,
					giaTu.doubleValue(), giaDen.doubleValue()));
			// TenDv + Gia
		} else if (tenDV.equals("") && !loaiDV.equalsIgnoreCase("Tất cả")
				&& (giaTu != null && giaDen != null)) {
			query.append(String.format("WHERE TenLoaiDichVu LIKE N'%%%s%%' AND (Gia >= %s AND Gia <= %s)",
					loaiDV, giaTu.doubleValue(), giaDen.doubleValue()));
			// loaidv + gia
		} else if (tenDV.equals("") && !loaiDV.equalsIgnoreCase("Tất cả")
				&& (giaTu == null && giaDen == null)) {
			query.append(String.format("WHERE TenLoaiDichVu LIKE N'%%%s%%'", loaiDV));
			// loaiDV
		} else if (tenDV.equals("") && loaiDV.equalsIgnoreCase("Tất cả") && (giaTu != null && giaDen != null)) {
			query.append(
					String.format("WHERE Gia >= %s AND Gia <= %s", giaTu.doubleValue(), giaDen.doubleValue()));
			// gia
		} else if (!tenDV.equals("") && loaiDV.equalsIgnoreCase("Tất cả")
				&& (giaTu == null && giaDen == null)) {
			// ten
			query.append(String.format("WHERE TenDichVu LIKE N'%%%s%%'", tenDV));
		}
		return em.createNativeQuery(query.toString(), DichVuEntity.class).getResultList();
//		String query = "SELECT d FROM DichVuEntity d WHERE d.tenDichVu like :tenDV AND d.loaiDichVu.tenLoaiDichVu like :loaiDV AND d.gia >= :giaTu AND d.gia <= :giaDen";
//		if (tenDV.equals("")) {
//			query = "SELECT d FROM DichVuEntity d WHERE d.loaiDichVu.tenLoaiDichVu like :loaiDV AND d.gia >= :giaTu AND d.gia <= :giaDen";
//		}
//		if (loaiDV.equalsIgnoreCase("Tất cả")) {
//			query = "SELECT d FROM DichVuEntity d WHERE d.tenDichVu like :tenDV AND d.gia >= :giaTu AND d.gia <= :giaDen";
//		}
//		if (tenDV.equals("") && loaiDV.equalsIgnoreCase("Tất cả")) {
//			query = "SELECT d FROM DichVuEntity d WHERE d.gia >= :giaTu AND d.gia <= :giaDen";
//		}
//		return em.createQuery(query, DichVuEntity.class).setParameter("tenDV","%"+tenDV+"%").setParameter("loaiDV", loaiDV)
//				.setParameter("giaTu", giaTu).setParameter("giaDen", giaDen).getResultList();
	}

	@Override
	public DichVuEntity timTheoMa(String maDichVu) {
		return em.find(DichVuEntity.class, maDichVu);
	}

}
