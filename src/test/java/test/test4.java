package test;

import java.rmi.RemoteException;

import Dao.LapHoaDonDao;
import Dao.Impl.LapHoaDonImpl;

public class test4 {
	public static void main(String[] args) throws RemoteException {
		LapHoaDonDao lapHoaDonDao = new LapHoaDonImpl();
//		System.out.println(lapHoaDonDao.demSoLuongPhong("PDP001"));
				System.out.println(lapHoaDonDao.tinhTienDichVu("PDP001"));
	}
}
