package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import Dao.DatPhongDao;
import Dao.PhongDao;
import Dao.Impl.DatPhongImpl;
import Dao.Impl.PhongImpl;
import entities.ChiTietDatPhongEntity;
import entities.PhongEntity;

public class test3 {
	public static void main(String[] args) {
		DatPhongDao datPhongDao = new DatPhongImpl();
		LocalDate ngay = LocalDate.of(2021, 5, 25);
		LocalTime gioNhan = LocalTime.of(10, 0);
		LocalTime gioTra = LocalTime.of(12, 0);
//		List<PhongEntity> list = datPhongDao.timPhongTrongTheoNgayVaGio(ngay, gioNhan, gioTra);
//		for (PhongEntity phongEntity : list) {
//			System.out.println(phongEntity.getMaPhong());
//		}
		PhongDao phongDao = new PhongImpl();
		PhongEntity p = phongDao.timTheoMa("P001");
		System.out.println(p.getMaPhong());
		List<ChiTietDatPhongEntity> list = datPhongDao.duyetChiTietDatPhongChuaThanhToanTheoPhong(p);
	}
}
