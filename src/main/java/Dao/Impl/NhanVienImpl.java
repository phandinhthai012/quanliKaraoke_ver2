package Dao.Impl;

import java.util.List;

import Dao.NhanVienDao;
import entities.NhanVienEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import util.PasswordHasher;

public class NhanVienImpl implements NhanVienDao {
	
	private String persistenceUnitName = "quanliKaraoke_ver2 mssql";
	private EntityManager em;
	
	public NhanVienImpl() {
		em = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
	}

	@Override
	public List<NhanVienEntity> duyetDanhSach() {
	    String quey = "select nv from NhanVienEntity nv";
	    return em.createQuery(quey, NhanVienEntity.class).getResultList();
	}

	@Override
	public List<NhanVienEntity> duyetDanhSachNhanVienDangLamViec() {
		// 1 dang lam viec 0 nghi viec
		String query = "select nv from NhanVienEntity nv where nv.trangThai = 1";
		return em.createQuery(query, NhanVienEntity.class).getResultList();
	}

	@Override
	public NhanVienEntity timTheoMa(String maNhanvien) {
		return em.find(NhanVienEntity.class, maNhanvien);
	}

	@Override
	public NhanVienEntity timTheoTenVaSoDienThoai(String hoTen, String soDienThoai) {
		String query = "select nv from NhanVienEntity nv where nv.hoTen = :hoTen and nv.soDienThoai = :soDienThoai";
		return em.createQuery(query, NhanVienEntity.class).setParameter("hoTen", hoTen)
				.setParameter("soDienThoai", soDienThoai).getSingleResult();
	}

	@Override
	public boolean them(NhanVienEntity nhanVienEntity) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(nhanVienEntity);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public NhanVienEntity timTheoSoDienThoaiVaPassword(String soDienThoai, String password) {
//		statement.setString(2, PasswordHasher.hashPassword(password));
		String password2 = PasswordHasher.hashPassword(password);
		String query = "select nv from NhanVienEntity nv where nv.soDienThoai = :soDienThoai and nv.password = :password";

		return em.createQuery(query, NhanVienEntity.class).setParameter("soDienThoai", soDienThoai)
				.setParameter("password", password2).getSingleResult();
	}

	@Override
	public boolean chinhSua(NhanVienEntity nhanVienEntity) {
		EntityTransaction tx = em.getTransaction();
		NhanVienEntity exitsNhanVien = em.find(NhanVienEntity.class, nhanVienEntity.getMaNhanVien());
		if (exitsNhanVien == null)
			return false;
		try {
			tx.begin();
			em.merge(nhanVienEntity);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<NhanVienEntity> timKiem(String hoTen, String soDienThoai, String chucVu, String trangThai) {
		String query = "select nv from NhanVienEntity nv where nv.hoTen like :hoTen and nv.soDienThoai like :soDienThoai and nv.chucVu like :chucVu and nv.trangThai like :trangThai";
		if(hoTen.equals("")) {
			hoTen = "%";
		}
		if (soDienThoai.equals("")) {
			soDienThoai = "%";
		}
		if (chucVu.equals("")) {
			chucVu = "%";
		}
		if (trangThai.equals("Tất cả")) {
			trangThai = "%";
		}
		return em.createQuery(query, NhanVienEntity.class).setParameter("hoTen", hoTen)
				.setParameter("soDienThoai", soDienThoai).setParameter("chucVu", chucVu)
				.setParameter("trangThai", trangThai).getResultList();
	}

	@Override
	public boolean doiMatKhau(String matKhauMoi, String soDienThoai) {
		String query = "update NhanVienEntity nv set nv.matKhau = :matKhauMoi where nv.soDienThoai = :soDienThoai";
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.createQuery(query).setParameter("matKhauMoi", matKhauMoi).setParameter("soDienThoai", soDienThoai)
					.executeUpdate();
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	

}
