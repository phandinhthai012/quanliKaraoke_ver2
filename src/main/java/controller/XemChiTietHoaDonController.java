package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gui.hoaDon.GD_XemChiTietHoaDonThongKe;

public class XemChiTietHoaDonController implements ActionListener, MouseListener {

	private GD_XemChiTietHoaDonThongKe giaoDienXemChiTietHoaDon;

	public XemChiTietHoaDonController(GD_XemChiTietHoaDonThongKe giaoDienXemChiTietHoaDon) {
		this.giaoDienXemChiTietHoaDon = giaoDienXemChiTietHoaDon;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		giaoDienXemChiTietHoaDon.chonPhong();
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
		if (o.equals(giaoDienXemChiTietHoaDon.btnLamMoi)) {
			giaoDienXemChiTietHoaDon.chonLamMoi();
		} else if (o.equals(giaoDienXemChiTietHoaDon.btnThoat)) {
			giaoDienXemChiTietHoaDon.chonThoat();
		}
	}

}
