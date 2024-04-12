package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gui.khachHang.GD_QuanLyKhachHang;


public class QuanLyKhachHangController implements ActionListener,MouseListener{
	
	private GD_QuanLyKhachHang giaoDienQuanLyKhachHang;
	
	public QuanLyKhachHangController(GD_QuanLyKhachHang giaoDienQuanLyKhachHang) {
		this.giaoDienQuanLyKhachHang = giaoDienQuanLyKhachHang;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(giaoDienQuanLyKhachHang.btnThem)){
			giaoDienQuanLyKhachHang.chonChucNangThem();
		} else if(o.equals(giaoDienQuanLyKhachHang.btnChinhSua)) {
			giaoDienQuanLyKhachHang.chonChucNangChinhSua();
		} else if(o.equals(giaoDienQuanLyKhachHang.btnTimKiem)) {
			giaoDienQuanLyKhachHang.chonChucNangTimKiem();
		} else if(o.equals(giaoDienQuanLyKhachHang.btnLamMoi)) {
			giaoDienQuanLyKhachHang.chonChucNangLamMoi();
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		giaoDienQuanLyKhachHang.hienThiThongTin();
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
