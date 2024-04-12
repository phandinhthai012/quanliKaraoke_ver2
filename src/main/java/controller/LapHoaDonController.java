package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gui.lapHoaDon.GD_LapHoaDon;

public class LapHoaDonController implements ActionListener, MouseListener {

	private GD_LapHoaDon giaoDienLapHoaDon;

	public LapHoaDonController(GD_LapHoaDon giaoDienLapHoaDon) {
		this.giaoDienLapHoaDon = giaoDienLapHoaDon;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		giaoDienLapHoaDon.hienThiThongTin();

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
		if (o.equals(giaoDienLapHoaDon.btnLamMoi)) {
			giaoDienLapHoaDon.chonLamMoi();
		} else if (o.equals(giaoDienLapHoaDon.btnTimKiem)) {
			giaoDienLapHoaDon.chonTimKiem();
		} else if (o.equals(giaoDienLapHoaDon.btnXemChiTiet)) {
			giaoDienLapHoaDon.chonXemChiTiet();
		} else if (o.equals(giaoDienLapHoaDon.btnLapHoaDon)) {
			giaoDienLapHoaDon.chonLapHoaDon();
		}

	}

}
