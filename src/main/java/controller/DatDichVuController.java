package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gui.datDichVu.GD_DatDichVu;

public class DatDichVuController implements ActionListener, MouseListener, ItemListener {

	private GD_DatDichVu giaoDienDatDichVu;

	public DatDichVuController(GD_DatDichVu giaoDienDatDichVu) {
		this.giaoDienDatDichVu = giaoDienDatDichVu;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		giaoDienDatDichVu.chonPhong();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		giaoDienDatDichVu.hienThiThongTin();

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
		if (o.equals(giaoDienDatDichVu.btnLamMoi)) {
			giaoDienDatDichVu.chonLamMoi();
		} else if (o.equals(giaoDienDatDichVu.btnTimKiem)) {
			giaoDienDatDichVu.chonTimKiem();
		} else if (o.equals(giaoDienDatDichVu.btnThem)) {
			giaoDienDatDichVu.chonThem();
		} else if (o.equals(giaoDienDatDichVu.btnXoaDaChon)) {
			giaoDienDatDichVu.chonXoaDaChon();
		} else if (o.equals(giaoDienDatDichVu.btnXoaTatCa)) {
			giaoDienDatDichVu.chonXoaTatCa();
		} else if (o.equals(giaoDienDatDichVu.btnChinhSua)) {
			giaoDienDatDichVu.chonChinhSua();
		} else if (o.equals(giaoDienDatDichVu.btnDat)) {
			giaoDienDatDichVu.chonDat();
		}
	}

}
