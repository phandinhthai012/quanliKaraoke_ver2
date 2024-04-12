package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.datPhong.GD_XemChiTietDatPhongTruoc;

public class XemDanhSachDatTruocController implements ActionListener {

	private GD_XemChiTietDatPhongTruoc giaoDien;

	public XemDanhSachDatTruocController(GD_XemChiTietDatPhongTruoc giaoDien) {
		this.giaoDien = giaoDien;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(giaoDien.btnTimKiem)) {
			giaoDien.chonTimKiem();
		} else if (o.equals(giaoDien.btnThoat)) {
			giaoDien.chonThoat();
		} else if (o.equals(giaoDien.btnChon)) {
			giaoDien.chonPhieu();
		} else if (o.equals(giaoDien.btnLamMoi)) {
			giaoDien.chonLamMoi();
		}
	}

}
