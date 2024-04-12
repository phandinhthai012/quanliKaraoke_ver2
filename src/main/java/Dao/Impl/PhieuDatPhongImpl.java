package Dao.Impl;

import java.util.List;

import Dao.PhieuDatPhongDao;
import entities.ChiTietPhieuDatPhongEntity;
import entities.PhieuDatPhongEntity;

public class PhieuDatPhongImpl implements PhieuDatPhongDao {

	@Override
	public List<ChiTietPhieuDatPhongEntity> duyetChiTietPhieuDatPhongChuaThanhToan() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean themChiTietPhieuDatPhong(ChiTietPhieuDatPhongEntity chiTietPhieuDatPhongEntity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ChiTietPhieuDatPhongEntity timChiTietPhieuDatPhongTheoMa(String maChiTietPhieuDatPhong) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChiTietPhieuDatPhongEntity> timChiTietPhieuDatPhongTheoSoPhongVaMa(int soPhong,
			String maPhieuDatPhong) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChiTietPhieuDatPhongEntity> timChiTietPhieuDatPhongTheoMaPhieuDatPhong(String maPhieuDatPhong) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean xoaChiTietPhieuDatPhong(String maChiTietDatPhong) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PhieuDatPhongEntity> duyetDanhSachDatPhong() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean themPhieuDatPhong(String maKhachHang) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PhieuDatPhongEntity timPhieuDatPhongTheoMa(String maPhieuDatPhong) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PhieuDatPhongEntity> timPhieuDatPhongTruocTheoSoPhongVaKhachHang(int soPhong, String khachHang) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PhieuDatPhongEntity timPhieuDatPhongVuaTao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean xoaPhieuDatPhong(String maPhieuDatPhong) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PhieuDatPhongEntity> duyetDanhSachPhieuDatPhongChuaThanhToan() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChiTietPhieuDatPhongEntity> duyetDanhSachChiTietPhieuDatPhongTheoPhieuDatPhong(String maPhieuDatPhong) {
		// TODO Auto-generated method stub
		return null;
	}

}
