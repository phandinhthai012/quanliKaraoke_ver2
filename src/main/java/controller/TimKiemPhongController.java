package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;

import gui.timKiem.GD_TimKiemPhong;

public class TimKiemPhongController implements ActionListener, MouseListener {

	private GD_TimKiemPhong giaoDienTimKiemPhong;

	public TimKiemPhongController(GD_TimKiemPhong giaoDienTimKiemPhong) {
		this.giaoDienTimKiemPhong = giaoDienTimKiemPhong;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		giaoDienTimKiemPhong.hienthiThongTin();
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
			if (o.equals(giaoDienTimKiemPhong.btnLamMoi)) {
				giaoDienTimKiemPhong.chonLamMoi();
			} else if (o.equals(giaoDienTimKiemPhong.btnTimKiem)) {
				giaoDienTimKiemPhong.chonTimKiem();
			}
		} catch (RemoteException e2) {
			e2.printStackTrace();
		}
		
	}

}
