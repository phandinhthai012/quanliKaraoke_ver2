package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import gui.trangChu.GD_TrangChu;

public class TrangChuController implements ActionListener {

	private GD_TrangChu giaoDienTrangChu;
	
	public TrangChuController(GD_TrangChu giaoDienTrangChu) {
		this.giaoDienTrangChu = giaoDienTrangChu;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		try {
			if(o.equals(giaoDienTrangChu.mniTrangChu)) {
				giaoDienTrangChu.chonTrangChu();
			} else if(o.equals(giaoDienTrangChu.mniPhong)) {
				giaoDienTrangChu.chonDanhMucPhong();
			} else if(o.equals(giaoDienTrangChu.mniDichVu)) {
				giaoDienTrangChu.chonDanhMucDichVu();
			} else if(o.equals(giaoDienTrangChu.mniNhanVien)) {
				giaoDienTrangChu.chonDanhMucNhanVien();
			} else if(o.equals(giaoDienTrangChu.mniKhachHang)) {
				giaoDienTrangChu.chonDanhMucKhachHang();
			}  else if(o.equals(giaoDienTrangChu.mniDatPhong)) {
				giaoDienTrangChu.chonDatPhong();
			} else if(o.equals(giaoDienTrangChu.mniDatDichVu)) {
				giaoDienTrangChu.chonDatDichVu();
			} else if(o.equals(giaoDienTrangChu.mniLapHoaDon)) {
				giaoDienTrangChu.chonLapHoaDon();
			} else if(o.equals(giaoDienTrangChu.mniThongKe)) {
				giaoDienTrangChu.chonThongKe();
			} else if(o.equals(giaoDienTrangChu.btnNguoiDung)) {
				giaoDienTrangChu.chonTaiKhoan();
			}
		} catch (RemoteException e2) {
			e2.printStackTrace();
		}
		
	}

}
