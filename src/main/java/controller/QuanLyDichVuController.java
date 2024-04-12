package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gui.dichVu.GD_QuanLyDichVu;

public class QuanLyDichVuController implements ActionListener, MouseListener {

	private GD_QuanLyDichVu giaoDienQuanLyDichVu;

	public QuanLyDichVuController(GD_QuanLyDichVu giaoDienQuanLyDichVu) {
		this.giaoDienQuanLyDichVu = giaoDienQuanLyDichVu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(giaoDienQuanLyDichVu.btnThemDichVu)) {
			giaoDienQuanLyDichVu.chonThemDichVu();
		} else if (o.equals(giaoDienQuanLyDichVu.btnThemLoaiDichVu)) {
			giaoDienQuanLyDichVu.chonThemLoaiDichVu();
		} else if (o.equals(giaoDienQuanLyDichVu.btnXoaDichVu)) {
			giaoDienQuanLyDichVu.chonXoaDichVu();
		} else if (o.equals(giaoDienQuanLyDichVu.btnChinhSuaDichVu)) {
			giaoDienQuanLyDichVu.chonChinhSuaDichVu();
		} else if (o.equals(giaoDienQuanLyDichVu.btnLamMoi)) {
			giaoDienQuanLyDichVu.chonLamMoi();
		} else if (o.equals(giaoDienQuanLyDichVu.btnTimKiem)) {
			giaoDienQuanLyDichVu.chonTimKiem();
		} else if (o.equals(giaoDienQuanLyDichVu.btnXemLoaiDichVu)) {
			giaoDienQuanLyDichVu.chonXemLoaiDichVu();
		} else if (o.equals(giaoDienQuanLyDichVu.cmbMaLoaiDichVu)) {
			giaoDienQuanLyDichVu.hienThiTenLoaiDichVu();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		giaoDienQuanLyDichVu.hienThiThongTin();

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
