package test;

import java.rmi.RemoteException;
import java.util.List;

import Dao.DatPhongDao;
import Dao.HoaDonDao;
import Dao.KhachHangDao;
import Dao.LapHoaDonDao;
import Dao.NhanVienDao;
import Dao.PhieuDatPhongDao;
import Dao.PhongDao;
import Dao.Impl.DatPhongImpl;
import Dao.Impl.HoaDonImpl;
import Dao.Impl.KhachHangImpl;
import Dao.Impl.LapHoaDonImpl;
import Dao.Impl.NhanVienImpl;
import Dao.Impl.PhieuDatPhongImpl;
import Dao.Impl.PhongImpl;
import entities.ChiTietDatPhongEntity;
import entities.ChiTietPhieuDatPhongEntity;
import entities.KhachHangEntity;
import entities.LoaiPhong;
import entities.NhanVienEntity;
import entities.PhieuDatPhongEntity;
import entities.PhongEntity;

public class test2 {
	public static void main(String[] args) throws RemoteException {
//		KhachHangDao khachHangDao = new KhachHangImpl();
//		System.out.println(khachHangDao.timTheoMa("KH001"));
//		NhanVienDao nhanVienDao = new NhanVienImpl();
//		List<NhanVienEntity> list = nhanVienDao.getTheoTen("Phan Thị Huỳnh Thư");
		
//		NhanVienEntity nv = nhanVienDao.timTheoMa("NV001");
//		System.out.println(nv);
//		PhongDao phongDao = new PhongImpl();
//		LoaiPhong loaiPhong = phongDao.timTheoTenLoaiPhong("VIP");
//		System.out.println(loaiPhong);
//		DatPhongDao datPhongDao = new DatPhongImpl();
//		List<PhongEntity> list = datPhongDao.timPhong("Trống", "VIP", 101, 10);
//		for (PhongEntity phongEntity : list) {
//			System.out.println(phongEntity);
//		}
//		PhongEntity p = phongDao.timTheoMa("P001");
//		System.out.println(p);
//		List<ChiTietDatPhongEntity> list = datPhongDao.duyetChiTietDatPhongChuaThanhToanTheoPhong(p);
//		for (ChiTietDatPhongEntity chiTietDatPhongEntity : list) {
//			System.out.println(chiTietDatPhongEntity);
//		}
//		HoaDonDao hoaDonDao = new HoaDonImpl();
//		ChiTietDatPhongEntity chiTietDatPhongEntity = hoaDonDao.timChiTietDatPhongTheoMaPhongDeNhanPhong("P001");
//		System.out.println(chiTietDatPhongEntity);
//	}
//		LapHoaDonDao lapHoaDonDao = new LapHoaDonImpl();
//		KhachHangDao khachHangDao = new KhachHangImpl();
//		KhachHangEntity khachHangEntity = khachHangDao.timTheoMa("KH001");
//		System.out.println(khachHangEntity);
//		List<PhieuDatPhongEntity> l = lapHoaDonDao.timHoaDonTheoKhachHang(khachHangEntity);
		PhieuDatPhongDao phieuDatPhongDao = new PhieuDatPhongImpl();
//		List<ChiTietPhieuDatPhongEntity> list = phieuDatPhongDao.duyetChiTietPhieuDatPhongChuaThanhToan();
//		List<ChiTietPhieuDatPhongEntity> list = phieuDatPhongDao.timChiTietPhieuDatPhongTheoSoPhongVaMa(101, "PDP001");
//		for (ChiTietPhieuDatPhongEntity chiTietPhieuDatPhongEntity : list) {
//			System.out.println(chiTietPhieuDatPhongEntity);
//		}
//		List<ChiTietPhieuDatPhongEntity> list = phieuDatPhongDao.timChiTietPhieuDatPhongTheoMaPhieuDatPhong("PDP001");
//		for (ChiTietPhieuDatPhongEntity chiTietPhieuDatPhongEntity : list) {
//			System.out.println(chiTietPhieuDatPhongEntity);
//		}
//		
		List<PhieuDatPhongEntity> list = phieuDatPhongDao.timPhieuDatPhongTruocTheoSoPhongVaKhachHang(101, "Nguyen Van A");
	}
}
