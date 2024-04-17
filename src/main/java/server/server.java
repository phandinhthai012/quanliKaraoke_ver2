package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Dao.DatPhongDao;
import Dao.DichVuDao;
import Dao.HoaDonDao;
import Dao.KhachHangDao;
import Dao.LapHoaDonDao;
import Dao.NhanVienDao;
import Dao.PhieuDatPhongDao;
import Dao.PhongDao;
import Dao.ThongKeDao;
import Dao.Impl.DatPhongImpl;
import Dao.Impl.DichVuImpl;
import Dao.Impl.HoaDonImpl;
import Dao.Impl.KhachHangImpl;
import Dao.Impl.LapHoaDonImpl;
import Dao.Impl.NhanVienImpl;
import Dao.Impl.PhieuDatPhongImpl;
import Dao.Impl.PhongImpl;
import Dao.Impl.ThongKeImpl;

public class server {
	public static void main(String[] args) throws NamingException, RemoteException {
		Context context = new InitialContext();
		DatPhongDao datPhongDao = new DatPhongImpl();
		DichVuDao dichVuDao = new DichVuImpl();
		HoaDonDao hoaDonDao = new HoaDonImpl();
		KhachHangDao khachHangDao = new KhachHangImpl();
		LapHoaDonDao lapHoaDonDao = new LapHoaDonImpl();
		NhanVienDao nhanVienDao = new NhanVienImpl();
		PhieuDatPhongDao phieuDatPhongDao = new PhieuDatPhongImpl();
		PhongDao phongDao = new PhongImpl();
		ThongKeDao  thongKeDao = new ThongKeImpl();
		
		LocateRegistry.createRegistry(1099);
		context.bind("rmi://HP-PAVILION-PC:1099/DatPhongDao", datPhongDao);
		context.bind("rmi://HP-PAVILION-PC:1099/DichVuDao", dichVuDao);
		context.bind("rmi://HP-PAVILION-PC:1099/HoaDonDao", hoaDonDao);
		context.bind("rmi://HP-PAVILION-PC:1099/KhachHangDao", khachHangDao);
		context.bind("rmi://HP-PAVILION-PC:1099/LapHoaDonDao", lapHoaDonDao);
		context.bind("rmi://HP-PAVILION-PC:1099/NhanVienDao", nhanVienDao);
		context.bind("rmi://HP-PAVILION-PC:1099/PhieuDatPhongDao", phieuDatPhongDao);
		context.bind("rmi://HP-PAVILION-PC:1099/PhongDao", phongDao);
		context.bind("rmi://HP-PAVILION-PC:1099/ThongKeDao", thongKeDao);
		System.out.println("Server is running...");
	}
}
