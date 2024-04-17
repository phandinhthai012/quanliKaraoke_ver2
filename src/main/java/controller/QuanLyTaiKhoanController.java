package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import gui.nhanVien.GD_QuanLyTaiKhoan;

public class QuanLyTaiKhoanController implements ActionListener {
	private GD_QuanLyTaiKhoan giaoDienQuanLyTaiKhoan;

	public QuanLyTaiKhoanController(GD_QuanLyTaiKhoan giaoDienQuanLyTaiKhoan) {
		this.giaoDienQuanLyTaiKhoan = giaoDienQuanLyTaiKhoan;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		try {
			if (o.equals(giaoDienQuanLyTaiKhoan.btnDangXuat)) {
				giaoDienQuanLyTaiKhoan.chonDangXuat();
			} else if (o.equals(giaoDienQuanLyTaiKhoan.btnDoiMatKhau)) {
				giaoDienQuanLyTaiKhoan.chonDoiMatKhau();
			} else if (o.equals(giaoDienQuanLyTaiKhoan.btnChinhSua)) {
				giaoDienQuanLyTaiKhoan.chonChinhSua();
			}
		} catch (RemoteException e2) {
			e2.printStackTrace();
			
		}
	
	}
}
