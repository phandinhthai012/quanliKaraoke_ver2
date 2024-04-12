package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gui.datPhong.GD_DatPhong;

public class DatPhongController implements ActionListener, MouseListener {

	private GD_DatPhong giaoDienDatPhong;

	public DatPhongController(GD_DatPhong giaoDienDatPhong) {
		this.giaoDienDatPhong = giaoDienDatPhong;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(giaoDienDatPhong.tblPhong)) {
			giaoDienDatPhong.hienThiThongTinPhong();
		} else if (o.equals(giaoDienDatPhong.tblPhongDaChon)) {
			giaoDienDatPhong.hienThiThongTinPhongDaChon();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		String action = e.getActionCommand();

		if (o.equals(giaoDienDatPhong.btnLamMoi)) {
			giaoDienDatPhong.chonLamMoi();
		} else if (o.equals(giaoDienDatPhong.btnTimKiemPhong)) {
			giaoDienDatPhong.chonTimKiemPhong();
		} else if (o.equals(giaoDienDatPhong.btnTimKiemKhachHang)) {
			giaoDienDatPhong.chonTimKiemKhachHang();
		} else if (o.equals(giaoDienDatPhong.btnChonPhong)) {
			giaoDienDatPhong.chonChonPhong();
		} else if (o.equals(giaoDienDatPhong.btnXoaPhongDaChon)) {
			giaoDienDatPhong.chonXoaPhongDaChon();
		} else if (o.equals(giaoDienDatPhong.btnNhanPhong)) {
			giaoDienDatPhong.chonNhanPhong();
		} else if (action.equals("Đổi phòng")) {
			giaoDienDatPhong.chonDoiPhong();
		} else if (action.equals("Kiểm tra")) {
			giaoDienDatPhong.chonKiemTra();
		} else if (action.equals("Xác nhận đổi")) {
			giaoDienDatPhong.chonXacNhanDoiPhong();
		} else if (o.equals(giaoDienDatPhong.btnHuyPhongDatTruoc)) {
			giaoDienDatPhong.chonHuyPhongDatTruoc();
		} else if (o.equals(giaoDienDatPhong.btnXemDatTruoc)) {
			giaoDienDatPhong.chonXemDatTruoc();
		} else if (o.equals(giaoDienDatPhong.btnDatPhong)) {
			giaoDienDatPhong.chonDatPhong();
		} else if (o.equals(giaoDienDatPhong.radDatPhongNgay)) {
			giaoDienDatPhong.chonDatPhongNgay();
		} else if (o.equals(giaoDienDatPhong.radDatPhongTruoc)) {
			giaoDienDatPhong.chonDatPhongTruoc();
		}
	}

}
