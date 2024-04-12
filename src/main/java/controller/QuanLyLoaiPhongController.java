package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gui.phong.GD_QuanLyLoaiPhong;

public class QuanLyLoaiPhongController implements ActionListener, MouseListener {
	private GD_QuanLyLoaiPhong giaoDienQuanLyLoaiPhong;

	public QuanLyLoaiPhongController(GD_QuanLyLoaiPhong giaoDienQuanLyLoaiPhong) {
		this.giaoDienQuanLyLoaiPhong = giaoDienQuanLyLoaiPhong;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(giaoDienQuanLyLoaiPhong.btnChinhSua)) {
			giaoDienQuanLyLoaiPhong.chonChinhSua();
		} else if (o.equals(giaoDienQuanLyLoaiPhong.btnLamMoi)) {
			giaoDienQuanLyLoaiPhong.chonLamMoi();
		} else if (o.equals(giaoDienQuanLyLoaiPhong.btnXoa)) {
			giaoDienQuanLyLoaiPhong.chonXoa();
		} else if (o.equals(giaoDienQuanLyLoaiPhong.btnThoat)) {
			giaoDienQuanLyLoaiPhong.chonThoat();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		giaoDienQuanLyLoaiPhong.hienThiThongTin();

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

}
