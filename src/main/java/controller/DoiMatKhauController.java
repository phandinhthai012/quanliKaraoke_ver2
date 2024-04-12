package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.dangNhap.GD_DoiMatKhau;

public class DoiMatKhauController implements ActionListener {

	private GD_DoiMatKhau giaoDienDoiMatKhau;

	public DoiMatKhauController(GD_DoiMatKhau giaoDienDoiMatKhau) {
		this.giaoDienDoiMatKhau = giaoDienDoiMatKhau;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(giaoDienDoiMatKhau.btnDoiMatKhau)) {
			giaoDienDoiMatKhau.chonDoiMatKhau();
		} else if (o.equals(giaoDienDoiMatKhau.btnThoat)) {
			giaoDienDoiMatKhau.chonThoat();
		} else if (o.equals(giaoDienDoiMatKhau.btnMatKhauCu)) {
			giaoDienDoiMatKhau.chonXemMatKhauCu();
		} else if (o.equals(giaoDienDoiMatKhau.btnMatKhauMoi)) {
			giaoDienDoiMatKhau.chonXemMatKhauMoi();
		} else if (o.equals(giaoDienDoiMatKhau.btnNhapLaiMK)) {
			giaoDienDoiMatKhau.chonXemLaiMatKhau();
		}
	}

}
