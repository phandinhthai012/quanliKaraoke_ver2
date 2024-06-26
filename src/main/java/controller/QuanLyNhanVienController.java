package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;

import gui.nhanVien.GD_QuanLyNhanVien;

public class QuanLyNhanVienController implements ActionListener, MouseListener {

	private GD_QuanLyNhanVien giaoDienQuanLyNhanVien;

	public QuanLyNhanVienController(GD_QuanLyNhanVien giaoDienQuanLyNhanVien) {
		this.giaoDienQuanLyNhanVien = giaoDienQuanLyNhanVien;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		try {
			giaoDienQuanLyNhanVien.hienThiThongTin();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
		try {
			if (o.equals(giaoDienQuanLyNhanVien.btnLamMoi)) {
				giaoDienQuanLyNhanVien.chonLamMoi();
			} else if (o.equals(giaoDienQuanLyNhanVien.btnTimKiem)) {
				giaoDienQuanLyNhanVien.chonTimKiem();
			} else if (o.equals(giaoDienQuanLyNhanVien.btnThem)) {
				giaoDienQuanLyNhanVien.chonThem();
			} else if (o.equals(giaoDienQuanLyNhanVien.btnChinhSua)) {
				giaoDienQuanLyNhanVien.chonChinhSua();
			}
		} catch (RemoteException e2) {
			e2.printStackTrace();
		}
		
	}

}
