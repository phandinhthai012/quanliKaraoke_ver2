package gui.trangChu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import controller.TrangChuController;
import entities.NhanVienEntity;
import gui.datDichVu.GD_DatDichVu;
import gui.datPhong.GD_DatPhong;
import gui.dichVu.GD_QuanLyDichVu;
import gui.khachHang.GD_QuanLyKhachHang;
import gui.lapHoaDon.GD_LapHoaDon;
import gui.nhanVien.GD_QuanLyNhanVien;
import gui.nhanVien.GD_QuanLyTaiKhoan;
import gui.phong.GD_QuanLyPhong;
import gui.thongKe.GD_ThongKe;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.ComponentOrientation;
import java.awt.Insets;
import java.awt.Cursor;

public class GD_TrangChu extends JFrame {

	private static final long serialVersionUID = 1L;
	/**
	 * Create the frame.
	 */

	private JPanel pnlChinh;
	private JPanel pnlBannner;
	private JPanel pnlNguoiDung;
	private JMenuBar mnuMucLuc;
	private JMenu mnDanhMuc;
	private JMenu mnXuLy;
	public JMenuItem mniPhong;
	public JMenuItem mniDichVu;
	public JMenuItem mniNhanVien;
	public JMenuItem mniKhachHang;
	public JMenuItem mniTrangChu;
	public JMenuItem mniDatPhong;
	public JMenuItem mniDatDichVu;
	public JMenuItem mniLapHoaDon;
	public JMenuItem mniThongKe;
	public JButton btnNguoiDung;
	private JLabel lblTenNhanVien;
	private JLabel lblChucVu;
	private NhanVienEntity nhanVienEntity;
	private JPanel contentPane;
	private JPanel pnlThongTinNhanVien;

	public GD_TrangChu(NhanVienEntity nhanVien) {
		this.nhanVienEntity = nhanVien;
		setIconImage(Toolkit.getDefaultToolkit().getImage(GD_TrangChu.class.getResource("/images/iconLogo.png")));
		setResizable(false);
		setSize(1365, 746);
		setTitle("Quản lý hệ thống karaoke NNice");
		setBackground(Color.WHITE);

		setLocationRelativeTo(null);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.getContentPane().setSize(1365, 746);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				if (JOptionPane.showConfirmDialog(null, "Xác nhận đóng ứng dụng?", "Cảnh báo",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnlMucLuc = new JPanel();
		pnlMucLuc.setBackground(SystemColor.window);
		pnlMucLuc.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.menuText));
		pnlMucLuc.setBounds(0, 0, 1365, 52);
		contentPane.add(pnlMucLuc);
		pnlMucLuc.setLayout(new GridLayout(0, 2, 0, 0));

		mnuMucLuc = new JMenuBar();
		mnuMucLuc.setMargin(new Insets(0, 20, 0, 0));
		mnuMucLuc.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		mnuMucLuc.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		mnuMucLuc.setBackground(SystemColor.inactiveCaption);
		pnlMucLuc.add(mnuMucLuc);

		mniTrangChu = new JMenuItem("Trang chủ");
		mniTrangChu.setHorizontalTextPosition(SwingConstants.RIGHT);
		mniTrangChu.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/images/iconTrangChu.png")));
		mniTrangChu.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		mniTrangChu.setMargin(new Insets(2, 10, 2, 10));
		mniTrangChu.setMinimumSize(new Dimension(115, 0));
		mniTrangChu.setFocusable(true);
		mniTrangChu.setBackground(SystemColor.inactiveCaption);
		mniTrangChu.setForeground(SystemColor.desktop);
		mniTrangChu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mniTrangChu.setMaximumSize(new Dimension(140, 120));
		mnuMucLuc.add(mniTrangChu);

		mnDanhMuc = new JMenu("Danh mục");
		mnDanhMuc.setMaximumSize(new Dimension(150, 150));
		mnDanhMuc.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/images/iconDanhMuc.png")));
		mnDanhMuc.setHorizontalTextPosition(SwingConstants.RIGHT);
		mnDanhMuc.setMinimumSize(new Dimension(130, 130));
		mnDanhMuc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnDanhMuc.setForeground(Color.BLACK);
		mnuMucLuc.add(mnDanhMuc);

		mniPhong = new JMenuItem("Phòng");
		mniPhong.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/images/iconPhong.png")));
		mniPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnDanhMuc.add(mniPhong);

		mniDichVu = new JMenuItem("Dịch vụ");
		mniDichVu.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/images/iconDichVu.png")));
		mniDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnDanhMuc.add(mniDichVu);

		mniNhanVien = new JMenuItem("Nhân viên");
		mniNhanVien.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/images/iconNhanVien.png")));
		mniNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnDanhMuc.add(mniNhanVien);

		mniKhachHang = new JMenuItem("Khách hàng");
		mniKhachHang.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/images/iconKhachHang.png")));
		mniKhachHang.setForeground(SystemColor.textText);
		mniKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnDanhMuc.add(mniKhachHang);

		mnXuLy = new JMenu("Xử lý");
		mnXuLy.setHorizontalAlignment(SwingConstants.CENTER);
		mnXuLy.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/images/iconXuLy.png")));
		mnXuLy.setPreferredSize(new Dimension(130, 26));
		mnXuLy.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnXuLy.setMaximumSize(new Dimension(130, 100));
		mnXuLy.setMinimumSize(new Dimension(150, 200));
		mnXuLy.setForeground(Color.BLACK);
		mnuMucLuc.add(mnXuLy);

		mniDatPhong = new JMenuItem("Đặt phòng");
		mniDatPhong.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/images/iconDatPhong.png")));
		mnXuLy.add(mniDatPhong);
		mniDatPhong.setMinimumSize(new Dimension(115, 0));
		mniDatPhong.setBackground(new Color(240, 240, 240));
		mniDatPhong.setMaximumSize(new Dimension(130, 130));
		mniDatPhong.setForeground(SystemColor.desktop);
		mniDatPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		mniDatDichVu = new JMenuItem("Đặt dịch vụ");
		mniDatDichVu.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/images/iconDichVu.png")));
		mnXuLy.add(mniDatDichVu);
		mniDatDichVu.setMinimumSize(new Dimension(115, 0));
		mniDatDichVu.setBackground(new Color(240, 240, 240));
		mniDatDichVu.setForeground(Color.BLACK);
		mniDatDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		mniLapHoaDon = new JMenuItem("Lập hóa đơn");
		mniLapHoaDon.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/images/iconLapHoaDon.png")));
		mnXuLy.add(mniLapHoaDon);
		mniLapHoaDon.setMinimumSize(new Dimension(115, 0));
		mniLapHoaDon.setBackground(new Color(240, 240, 240));
		mniLapHoaDon.setMaximumSize(new Dimension(140, 140));
		mniLapHoaDon.setForeground(SystemColor.desktop);
		mniLapHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		mniThongKe = new JMenuItem("Thống kê");
		mniThongKe.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/images/iconThongKe.png")));
		mniThongKe.setMaximumSize(new Dimension(170, 170));
		mniThongKe.setMinimumSize(new Dimension(115, 0));
		mniThongKe.setForeground(SystemColor.desktop);
		mniThongKe.setBackground(SystemColor.inactiveCaption);
		mniThongKe.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnuMucLuc.add(mniThongKe);

		pnlNguoiDung = new JPanel();
		pnlNguoiDung.setSize(new Dimension(200, 70));
		pnlNguoiDung.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.inactiveCaptionText));
		pnlNguoiDung.setBackground(SystemColor.inactiveCaption);
		pnlMucLuc.add(pnlNguoiDung);
		FlowLayout fl_pnlNguoiDung = new FlowLayout(FlowLayout.RIGHT, 20, 5);
		pnlNguoiDung.setLayout(fl_pnlNguoiDung);

		pnlThongTinNhanVien = new JPanel();
		pnlThongTinNhanVien.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		pnlThongTinNhanVien.setFont(new Font("Cambria Math", Font.PLAIN, 11));
		pnlThongTinNhanVien.setBackground(SystemColor.inactiveCaption);
		pnlNguoiDung.add(pnlThongTinNhanVien);
		pnlThongTinNhanVien.setLayout(new BoxLayout(pnlThongTinNhanVien, BoxLayout.PAGE_AXIS));

		lblTenNhanVien = new JLabel(nhanVienEntity.getHoTen());
		pnlThongTinNhanVien.add(lblTenNhanVien);
		lblTenNhanVien.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 15));

		lblChucVu = new JLabel(nhanVien.getChucVu());
		lblChucVu.setHorizontalTextPosition(SwingConstants.RIGHT);
		pnlThongTinNhanVien.add(lblChucVu);
		lblChucVu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChucVu.setFont(new Font("Segoe UI", Font.ITALIC, 12));

		btnNguoiDung = new JButton("");
		btnNguoiDung.setBorder(null);
		btnNguoiDung.setBackground(SystemColor.inactiveCaption);
		btnNguoiDung.setFocusable(false);
		btnNguoiDung.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/images/iconNguoi2.png")));
		pnlNguoiDung.add(btnNguoiDung);

		pnlChinh = new JPanel();
		pnlChinh.setBounds(0, 52, 1365, 694);
		contentPane.add(pnlChinh);
		pnlChinh.setLayout(new BorderLayout(0, 0));

		pnlBannner = new JPanel();
		pnlChinh.add(pnlBannner);
		pnlBannner.setLayout(null);

		JLabel lblSlogan2 = new JLabel("Khi đến với NNice");
		lblSlogan2.setForeground(Color.WHITE);
		lblSlogan2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblSlogan2.setBounds(44, 544, 279, 35);
		pnlBannner.add(lblSlogan2);

		JLabel lblSlogan1 = new JLabel("Hát hay hơn");
		lblSlogan1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblSlogan1.setForeground(Color.WHITE);
		lblSlogan1.setBounds(44, 498, 202, 35);
		pnlBannner.add(lblSlogan1);

		JLabel lblBanner = new JLabel("");
		lblBanner.setBounds(0, 0, 1365, 694);
		lblBanner.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/images/Banner1.jpg")));
		pnlBannner.add(lblBanner);

		TrangChuController controller = new TrangChuController(this);
		mniTrangChu.addActionListener(controller);
		mniThongKe.addActionListener(controller);
		btnNguoiDung.addActionListener(controller);

		mniLapHoaDon.addActionListener(controller);
		mniDatDichVu.addActionListener(controller);
		mniDatPhong.addActionListener(controller);

		mniPhong.addActionListener(controller);
		mniDichVu.addActionListener(controller);
		mniNhanVien.addActionListener(controller);
		mniKhachHang.addActionListener(controller);
		kiemTraQuyen();
	}

	private void kiemTraQuyen() {
		if (nhanVienEntity.getChucVu().equalsIgnoreCase("Quản lí")) {
			mniThongKe.setEnabled(true);
			btnNguoiDung.setEnabled(true);

			mniLapHoaDon.setEnabled(true);
			mniDatDichVu.setEnabled(true);
			mniDatPhong.setEnabled(true);

			mniPhong.setEnabled(true);
			mniDichVu.setEnabled(true);
			mniNhanVien.setEnabled(true);
			mniKhachHang.setEnabled(true);
		} else {
			mniThongKe.setEnabled(false);
			btnNguoiDung.setEnabled(true);

			mniLapHoaDon.setEnabled(true);
			mniDatDichVu.setEnabled(true);
			mniDatPhong.setEnabled(true);

			mniPhong.setEnabled(true);
			mniDichVu.setEnabled(true);
			mniNhanVien.setEnabled(false);
			mniKhachHang.setEnabled(true);
		}
	}

	private void clearSelectedMenu() {
		mniTrangChu.setSelected(false);
		mniThongKe.setSelected(false);
	}

	public void thayDoiPanelChinh(JComponent component, JMenuItem menu) {
		clearSelectedMenu();
		menu.setSelected(true);
		this.pnlChinh.removeAll();
		this.pnlChinh.repaint();
		this.pnlChinh.revalidate();

		this.pnlChinh.add(component);
		this.pnlChinh.repaint();
		this.pnlChinh.revalidate();
	}

	public void chonTrangChu() {
		this.thayDoiPanelChinh(pnlBannner, mniTrangChu);
	}

	public void chonDanhMucPhong() throws RemoteException {
		this.thayDoiPanelChinh(new GD_QuanLyPhong(nhanVienEntity), mniPhong);
	}

	public void chonDanhMucDichVu() throws RemoteException {
		this.thayDoiPanelChinh(new GD_QuanLyDichVu(nhanVienEntity), mniDichVu);
	}

	public void chonDanhMucNhanVien()  throws RemoteException{
		this.thayDoiPanelChinh(new GD_QuanLyNhanVien(), mniNhanVien);
	}

	public void chonDanhMucKhachHang() throws RemoteException {
		this.thayDoiPanelChinh(new GD_QuanLyKhachHang(), mniKhachHang);
	}

	public void chonDatPhong()  throws RemoteException{
		this.thayDoiPanelChinh(new GD_DatPhong(nhanVienEntity), mniDatPhong);
	}

	public void chonDatDichVu()  throws RemoteException{
		this.thayDoiPanelChinh(new GD_DatDichVu(), mniDatDichVu);
	}

	public void chonLapHoaDon() throws RemoteException {
		this.thayDoiPanelChinh(new GD_LapHoaDon(nhanVienEntity), mniLapHoaDon);
	}

	public void chonThongKe()  throws RemoteException{
		this.thayDoiPanelChinh(new GD_ThongKe(), mniThongKe);
	}

	public void chonTaiKhoan() throws RemoteException {
		this.thayDoiPanelChinh(new GD_QuanLyTaiKhoan(nhanVienEntity), new JMenuItem());
	}
}
