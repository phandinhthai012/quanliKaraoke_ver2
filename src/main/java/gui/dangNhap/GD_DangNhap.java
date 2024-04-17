package gui.dangNhap;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import com.formdev.flatlaf.FlatIntelliJLaf;

import Dao.NhanVienDao;
import Dao.Impl.NhanVienImpl;
import controller.DangNhapController;
import entities.NhanVienEntity;
import gui.timKiem.GD_TimKiemPhong;
//import gui.timKiem.GD_TimKiemPhong;
//import gui.trangChu.GD_TrangChu;
import gui.trangChu.GD_TrangChu;

public class GD_DangNhap extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_DangNhap frame = new GD_DangNhap();
					UIManager.setLookAndFeel(new FlatIntelliJLaf());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// JPanel
	private JPanel contentPane;

	// JTextField
	private JTextField txtSoDienThoai;

	// JPassswordField
	private JPasswordField pwd;

	// JButton
	public JButton btnDangNhap;
	public JButton btnThoat;
	public JButton btnDanhChoKhachHang;
	public JButton btnNhinMatKhau;

	// JLabel
	private JLabel lblSĐT;
	private JLabel lblMatKhau;
	private JLabel lblDangNhap;

	// Controller
	private DangNhapController controller;
//	private QuanLyNhanVienDAO quanLyNhanVienDAO = new QuanLyNhanVienDAO();
	
	private NhanVienDao quanLyNhanVienDAO = new NhanVienImpl();

	private NhanVienEntity nhanVienEntity;

	public GD_DangNhap() throws RemoteException {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(GD_DangNhap.class.getResource("/images/iconLogo.png")));
		setResizable(false);
		setTitle("Đăng Nhập");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(544, 483);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setForeground(new Color(70, 130, 180));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblDangNhap = new JLabel("Đăng Nhập ");
		lblDangNhap.setHorizontalAlignment(SwingConstants.CENTER);
		lblDangNhap.setForeground(SystemColor.desktop);
		lblDangNhap.setFont(new Font("Cambria", Font.BOLD, 40));
		lblDangNhap.setBounds(226, 74, 235, 47);
		contentPane.add(lblDangNhap);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setText("0333411964");
		txtSoDienThoai.setBorder(null);
		txtSoDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtSoDienThoai.setForeground(Color.BLACK);
		txtSoDienThoai.setBounds(164, 194, 258, 35);
		contentPane.add(txtSoDienThoai);
		txtSoDienThoai.setColumns(10);

		btnDangNhap = new JButton("Đăng Nhập\r\n");
		btnDangNhap.setIcon(new ImageIcon(GD_DangNhap.class.getResource("/images/iconDangNhap.png")));
		btnDangNhap.setMnemonic(KeyEvent.VK_ENTER);
		btnDangNhap.setFocusable(false);
		btnDangNhap.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDangNhap.setBackground(new Color(255, 128, 128));
		btnDangNhap.setForeground(new Color(0, 0, 0));
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDangNhap.setBounds(55, 313, 181, 40);
		contentPane.add(btnDangNhap);

		btnThoat = new JButton("Thoát\r\n");
		btnThoat.setIcon(new ImageIcon(GD_DangNhap.class.getResource("/images/iconDangXuat.png")));
		btnThoat.setFocusable(false);
		btnThoat.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThoat.setBackground(new Color(255, 128, 128));
		btnThoat.setBounds(293, 313, 181, 40);
		contentPane.add(btnThoat);

		btnDanhChoKhachHang = new JButton("Dành cho Khách Hàng");
		btnDanhChoKhachHang.setIcon(new ImageIcon(GD_DangNhap.class.getResource("/images/iconNguoi.png")));
		btnDanhChoKhachHang.setFocusable(false);
		btnDanhChoKhachHang.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDanhChoKhachHang.setBackground(new Color(152, 251, 152));
		btnDanhChoKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDanhChoKhachHang.setBounds(179, 374, 181, 30);
		contentPane.add(btnDanhChoKhachHang);

		lblSĐT = new JLabel("Số điện thoại:\r\n");
		lblSĐT.setFont(new Font("Cambria", Font.PLAIN, 17));
		lblSĐT.setBounds(55, 194, 107, 34);
		contentPane.add(lblSĐT);

		lblMatKhau = new JLabel("Mật khẩu:");
		lblMatKhau.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblMatKhau.setBounds(55, 253, 87, 34);
		contentPane.add(lblMatKhau);

		pwd = new JPasswordField();
		pwd.setBounds(164, 253, 258, 35);
		pwd.requestFocus();
		contentPane.add(pwd);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(GD_DangNhap.class.getResource("/images/iconLogo1.png")));
		lblLogo.setBounds(66, 46, 150, 100);
		contentPane.add(lblLogo);

		btnNhinMatKhau = new JButton("");
		btnNhinMatKhau.setBackground(new Color(230, 230, 250));
		btnNhinMatKhau.setBorder(null);
		btnNhinMatKhau.setFocusable(false);
		btnNhinMatKhau.setIcon(new ImageIcon(GD_DangNhap.class.getResource("/images/iconMatNham.png")));
		btnNhinMatKhau.setBounds(421, 253, 40, 35);
		contentPane.add(btnNhinMatKhau);
		
		controller = new DangNhapController(this);
		btnDangNhap.addActionListener(controller);
		btnDanhChoKhachHang.addActionListener(controller);
		btnThoat.addActionListener(controller);
		btnNhinMatKhau.addActionListener(controller);
	}

	/************ ĐĂNG NHẬP 
	 * @throws RemoteException ****************/
	public void chonDangNhap() throws RemoteException {
		if (kiemTraDuLieuNhap()) {
			@SuppressWarnings("deprecation")
			String password = pwd.getText().trim();
			System.out.println(password);
			String soDienThoai = txtSoDienThoai.getText().trim();
			System.out.println(soDienThoai);
			nhanVienEntity = quanLyNhanVienDAO.timTheoSoDienThoaiVaPassword(soDienThoai, password);
			System.out.println(nhanVienEntity);
			if (nhanVienEntity != null) {
				new GD_TrangChu(nhanVienEntity).setVisible(true);
				this.dispose();
				return;
			}
			JOptionPane.showMessageDialog(this, "Mật khẩu hoặc số điện thoại không hợp lệ");
			return;
		}
	}

	/************ THOÁT ****************/
	public void chonThoat() {
		if (JOptionPane.showConfirmDialog(null, "Xác nhận tắt màn hình?", "Thông báo",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			this.dispose();
		}
	}

	/*********** DÀNH CHO KHÁCH HÀNG 
	 * @throws RemoteException ****************/
	public void chonDanhChoKhachHang() throws RemoteException {
		new GD_TimKiemPhong().setVisible(true);
		this.dispose();
	}

	/*********** CHỌN NHÌN MẬT KHẨU ****************/

	public void chonNhinMatKhau() {
		String urlIcon = btnNhinMatKhau.getIcon().toString();
		if (urlIcon.contains("iconMatNham")) {
			btnNhinMatKhau.setIcon(new ImageIcon(GD_DangNhap.class.getResource("/images/iconMatMo.png")));
			pwd.setEchoChar((char) 0);
		} else if (urlIcon.contains("iconMatMo")) {
			btnNhinMatKhau.setIcon(new ImageIcon(GD_DangNhap.class.getResource("/images/iconMatNham.png")));
			pwd.setEchoChar('•');
		}
	}

	/************ KIỂM TRA DỮ LIỆU NHẬP ****************/
	@SuppressWarnings("deprecation")
	private boolean kiemTraDuLieuNhap() {
		if (!(txtSoDienThoai.getText().trim().length() > 0 && pwd.getText().trim().length() > 0)) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ dữ liệu");
			return false;
		} else {
			String sdt = txtSoDienThoai.getText().trim();
			if (!sdt.matches("\\d{10}")) {
				JOptionPane.showMessageDialog(this, "Số điện thoại phải là 10 ký số");
				txtSoDienThoai.requestFocus();
				return false;
			}
		}
		return true;
	}
}
