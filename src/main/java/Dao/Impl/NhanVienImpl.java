package Dao.Impl;

import java.util.List;

import Dao.NhanVienDao;
import entities.NhanVienEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
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
		String query = "INSERT INTO [dbo].[NhanVien] "
				+ "([HoTen], [SoDienThoai], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai])"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			boolean i = em.createNativeQuery(query).setParameter(1, nhanVienEntity.getHoTen())
					.setParameter(2, nhanVienEntity.getSoDienThoai()).setParameter(3, nhanVienEntity.getEmail())
					.setParameter(4, nhanVienEntity.getcCCD())
					.setParameter(5, PasswordHasher.hashPassword(nhanVienEntity.getPassword()))
					.setParameter(6, nhanVienEntity.getNamSinh()).setParameter(7, nhanVienEntity.getMucLuong())
					.setParameter(8, nhanVienEntity.getChucVu()).setParameter(9, nhanVienEntity.isTrangThai())
					.executeUpdate() > 0;
			tx.commit();
			return i;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}
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

		StringBuilder query = new StringBuilder("SELECT n FROM NhanVienEntity n WHERE 1=1 ");

		if (!hoTen.equals("")) {
		    query.append("AND n.hoTen LIKE :hoTen ");
		}
		if (!soDienThoai.equals("")) {
		    query.append("AND n.soDienThoai LIKE :soDienThoai ");
		}
		if (!chucVu.equals("Tất cả")) {
		    query.append("AND n.chucVu LIKE :chucVu ");
		}
		if (!trangThai.equals("Tất cả")) {
		    query.append("AND n.trangThai =:trangThai ");
		}
		TypedQuery<NhanVienEntity> typedQuery = em.createQuery(query.toString(), NhanVienEntity.class);
		boolean trangThai2 = false;
		if (!hoTen.equals("")) {
		    typedQuery.setParameter("hoTen", "%" + hoTen + "%");
		}
		if (!soDienThoai.equals("")) {
		    typedQuery.setParameter("soDienThoai", soDienThoai);
		}
		if (!chucVu.equals("Tất cả")) {
		    typedQuery.setParameter("chucVu", "%" + chucVu + "%");
		}
		if(trangThai.equals("Đang làm việc")){
			trangThai2 = true;
		}
		else if(trangThai.equals("Nghỉ việc")){
            trangThai2 = false;
        }
		if (!trangThai.equals("Tất cả")) {
		    typedQuery.setParameter("trangThai",trangThai2);
		}

		return typedQuery.getResultList();
	}
	/***** ĐỔI MẬT KHẨU *****/
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
