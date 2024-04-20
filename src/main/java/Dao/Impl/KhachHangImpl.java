package Dao.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;


import Dao.KhachHangDao;
import entities.KhachHangEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class KhachHangImpl extends UnicastRemoteObject implements KhachHangDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String persistenceUnitName = "quanliKaraoke_ver2 mssql";
	private EntityManager em;

	public KhachHangImpl()throws RemoteException  {
		em = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
	}

	@Override
	public List<KhachHangEntity> duyetDanhSach()throws RemoteException  {
		String query = "SELECT kh FROM KhachHangEntity kh";
		return em.createQuery(query, KhachHangEntity.class).getResultList();
	}

	@Override
	public KhachHangEntity them(KhachHangEntity khachHangEntity) throws RemoteException {
		EntityTransaction tx = em.getTransaction();
		String query = "INSERT INTO KhachHang"
				+ "([HoTen],[SoDienThoai],[Email],[NamSinh],[SoLanDatPhong]) VALUES (:hoTen, :soDienThoai, :email, :namSinh, :soLanDatPhong)";
		try {
			tx.begin();
			@SuppressWarnings("unused")
			boolean result = em.createNativeQuery(query).setParameter("hoTen", khachHangEntity.getHoTen())
					.setParameter("soDienThoai", khachHangEntity.getSoDienThoai())
					.setParameter("email", khachHangEntity.getEmail())
					.setParameter("namSinh", khachHangEntity.getNamSinh())
					.setParameter("soLanDatPhong", khachHangEntity.getSoLanDatPhong()).executeUpdate() > 0;
			tx.commit();
			return khachHangEntity;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int chinhSua(KhachHangEntity khachHangEntity)throws RemoteException  {
		EntityTransaction tx = em.getTransaction();
		KhachHangEntity exitsKhachHang = em.find(KhachHangEntity.class, khachHangEntity.getMaKhachHang());
		if (exitsKhachHang == null)
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
	public KhachHangEntity timTheoMa(String MaKhachHang)throws RemoteException  {
		return em.find(KhachHangEntity.class, MaKhachHang);
	}

	@Override
	public KhachHangEntity timTheoSoDienThoai(String soDienThoai) throws RemoteException {
		String query = "SELECT kh FROM KhachHangEntity kh WHERE kh.soDienThoai like :soDienThoai";
//		
//		Result rs = (Result) em.createQuery(query, KhachHangEntity.class).setParameter("soDienThoai", soDienThoai);
//		if (rs == null) {
//			return null;
//		}
//		KhachHangEntity  khachHangEntity = ((TypedQuery<KhachHangEntity>) rs).getSingleResult();
//		return khachHangEntity;
		 TypedQuery<KhachHangEntity> typedQuery = em.createQuery(query, KhachHangEntity.class).setParameter("soDienThoai", "%" + soDienThoai + "%");
		    try {
		        return typedQuery.getSingleResult();
		    } catch (NoResultException e) {
		        return null;
		    }
	}

	@Override
	public List<KhachHangEntity> timKiem(String hoTen, String soDienThoai, int slTu, int slDen) throws RemoteException {
		List<KhachHangEntity> listKhachHang = new ArrayList<>();
		String query = "SELECT kh FROM KhachHangEntity kh where kh.hoTen like :hoTen and kh.soDienThoai like :soDienThoai and kh.soLanDatPhong >= :slTu and kh.soLanDatPhong <= :slDen";
		listKhachHang = em.createQuery(query, KhachHangEntity.class).setParameter("hoTen","%" + hoTen + "%")
				.setParameter("soDienThoai","%"+soDienThoai+"%").setParameter("slTu", slTu).setParameter("slDen", slDen)
				.getResultList();
		return listKhachHang;
	}
}
