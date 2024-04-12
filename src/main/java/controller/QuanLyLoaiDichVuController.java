package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gui.dichVu.GD_QuanLyLoaiDichVu;

public class QuanLyLoaiDichVuController implements ActionListener, MouseListener {
	private GD_QuanLyLoaiDichVu giaoDienQuanLyLoaiDichVu;

	public QuanLyLoaiDichVuController(GD_QuanLyLoaiDichVu giaoDienQuanLyLoaiDichVu) {
		this.giaoDienQuanLyLoaiDichVu = giaoDienQuanLyLoaiDichVu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(giaoDienQuanLyLoaiDichVu.btnChinhSua)) {
			giaoDienQuanLyLoaiDichVu.chonChinhSua();
		} else if (o.equals(giaoDienQuanLyLoaiDichVu.btnLamMoi)) {
			giaoDienQuanLyLoaiDichVu.chonLamMoi();
		} else if (o.equals(giaoDienQuanLyLoaiDichVu.btnXoa)) {
			giaoDienQuanLyLoaiDichVu.chonXoa();
		} else if (o.equals(giaoDienQuanLyLoaiDichVu.btnThoat)) {
			giaoDienQuanLyLoaiDichVu.chonThoat();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		giaoDienQuanLyLoaiDichVu.hienThiThongTin();

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
