package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import gui.dangNhap.GD_DangNhap;


public class DangNhapController implements ActionListener{
	private GD_DangNhap giaoDienDangNhap;

	public DangNhapController(GD_DangNhap giaoDienDangNhap) {
		this.giaoDienDangNhap = giaoDienDangNhap;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		try {
			if (o.equals(giaoDienDangNhap.btnThoat)) {
				giaoDienDangNhap.chonThoat();
			} else if (o.equals(giaoDienDangNhap.btnDangNhap)) {
				giaoDienDangNhap.chonDangNhap();
			} else if (o.equals(giaoDienDangNhap.btnDanhChoKhachHang)) {
				giaoDienDangNhap.chonDanhChoKhachHang();
			} else if(o.equals(giaoDienDangNhap.btnNhinMatKhau)) {
				giaoDienDangNhap.chonNhinMatKhau();
			}
		} catch (RemoteException e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
		
	}

	
}
