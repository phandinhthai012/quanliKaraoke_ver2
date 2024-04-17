package gui.dangNhap;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import Dao.NhanVienDao;
import Dao.Impl.NhanVienImpl;
import controller.DoiMatKhauController;
//import dao.QuanLyNhanVienDAO;
import entities.NhanVienEntity;

public class GD_DoiMatKhau extends JDialog {

	private static final long serialVersionUID = 1L;

	private final JPanel pnlDoiMatKhau = new JPanel();

	// JPanel
	private JPanel pnlTacVu;
	// JLable
	private JLabel lblMatKhauCu;
	private JLabel lblMatKhauMoi;
	private JLabel lblNhapLaiMK;
	private JLabel lblDoiMatKhau;
	// JPasswordField
	private JPasswordField txtMatKhauCu;
	private JPasswordField txtMatKhauMoi;
	private JPasswordField txtNhapLaiMK;
	// JButton
	public JButton btnMatKhauCu;
	public JButton btnMatKhauMoi;
	public JButton btnNhapLaiMK;
	public JButton btnDoiMatKhau;
	public JButton btnThoat;

	private boolean xemMKCu = false;
	private boolean xemMKMoi = false;
	private boolean xemLaiMK = false;

	private NhanVienEntity nhanVienEntity = new NhanVienEntity();
//	private QuanLyNhanVienDAO quanLyNhanVienDAO = new QuanLyNhanVienDAO();
	private NhanVienDao quanLyNhanVienDAO= new NhanVienImpl();

	public GD_DoiMatKhau(NhanVienEntity nhanVienEntity) throws RemoteException {
		this.nhanVienEntity = nhanVienEntity;
		setIconImage(Toolkit.getDefaultToolkit().getImage(GD_DoiMatKhau.class.getResource("/images/iconLogo1.png")));
		setTitle("Đổi mật khẩu");
		setSize(450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		pnlDoiMatKhau.setBounds(0, 0, 434, 212);
		pnlDoiMatKhau.setBackground(new Color(230, 230, 250));
		pnlDoiMatKhau.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlDoiMatKhau);
		pnlDoiMatKhau.setLayout(null);

		lblMatKhauCu = new JLabel("Mật khẩu cũ:");
		lblMatKhauCu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMatKhauCu.setBounds(70, 66, 100, 30);
		pnlDoiMatKhau.add(lblMatKhauCu);

		txtMatKhauCu = new JPasswordField();
		txtMatKhauCu.setBorder(null);
		txtMatKhauCu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMatKhauCu.setBounds(184, 66, 154, 30);
		pnlDoiMatKhau.add(txtMatKhauCu);

		btnMatKhauCu = new JButton("");
		btnMatKhauCu.setIcon(new ImageIcon(GD_DoiMatKhau.class.getResource("/images/iconMatNham.png")));
		btnMatKhauCu.setBorder(null);
		btnMatKhauCu.setFocusPainted(false);
		btnMatKhauCu.setBackground(new Color(230, 230, 250));
		btnMatKhauCu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnMatKhauCu.setBounds(336, 66, 30, 30);
		pnlDoiMatKhau.add(btnMatKhauCu);

		lblMatKhauMoi = new JLabel("Mật khẩu mới:");
		lblMatKhauMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMatKhauMoi.setBounds(70, 116, 100, 30);
		pnlDoiMatKhau.add(lblMatKhauMoi);

		txtMatKhauMoi = new JPasswordField();
		txtMatKhauMoi.setBorder(null);
		txtMatKhauMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMatKhauMoi.setBounds(184, 116, 154, 30);
		pnlDoiMatKhau.add(txtMatKhauMoi);

		btnMatKhauMoi = new JButton("");
		btnMatKhauMoi.setIcon(new ImageIcon(GD_DoiMatKhau.class.getResource("/images/iconMatNham.png")));
		btnMatKhauMoi.setFocusPainted(false);
		btnMatKhauMoi.setBackground(new Color(230, 230, 250));
		btnMatKhauMoi.setBorder(null);
		btnMatKhauMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnMatKhauMoi.setBounds(336, 116, 30, 30);
		pnlDoiMatKhau.add(btnMatKhauMoi);

		lblNhapLaiMK = new JLabel("Nhập lại MK mới:");
		lblNhapLaiMK.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNhapLaiMK.setBounds(70, 166, 118, 30);
		pnlDoiMatKhau.add(lblNhapLaiMK);

		txtNhapLaiMK = new JPasswordField();
		txtNhapLaiMK.setBorder(null);
		txtNhapLaiMK.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtNhapLaiMK.setBounds(184, 166, 154, 30);
		pnlDoiMatKhau.add(txtNhapLaiMK);

		btnNhapLaiMK = new JButton("");
		btnNhapLaiMK.setIcon(new ImageIcon(GD_DoiMatKhau.class.getResource("/images/iconMatNham.png")));
		btnNhapLaiMK.setFocusPainted(false);
		btnNhapLaiMK.setBackground(new Color(230, 230, 250));
		btnNhapLaiMK.setBorder(null);
		btnNhapLaiMK.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnNhapLaiMK.setBounds(336, 166, 30, 30);
		pnlDoiMatKhau.add(btnNhapLaiMK);

		lblDoiMatKhau = new JLabel("Đổi mật khẩu");
		lblDoiMatKhau.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoiMatKhau.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblDoiMatKhau.setBounds(0, 11, 436, 40);
		pnlDoiMatKhau.add(lblDoiMatKhau);
		pnlTacVu = new JPanel();
		pnlTacVu.setBounds(0, 210, 434, 51);
		pnlTacVu.setBackground(new Color(230, 230, 250));
		getContentPane().add(pnlTacVu);
		pnlTacVu.setLayout(null);

		btnDoiMatKhau = new JButton("Đổi mật khẩu");
		btnDoiMatKhau.setBounds(140, 5, 120, 35);
		btnDoiMatKhau.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDoiMatKhau.setBackground(new Color(144, 238, 144));
		btnDoiMatKhau.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnDoiMatKhau.setFocusPainted(false);
		btnDoiMatKhau.setActionCommand("OK");
		pnlTacVu.add(btnDoiMatKhau);
		getRootPane().setDefaultButton(btnDoiMatKhau);

		btnThoat = new JButton("Thoát");
		btnThoat.setBounds(284, 5, 120, 35);
		btnThoat.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThoat.setBackground(new Color(144, 238, 144));
		btnThoat.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnThoat.setFocusPainted(false);
		btnThoat.setActionCommand("Cancel");
		pnlTacVu.add(btnThoat);

		DoiMatKhauController controller = new DoiMatKhauController(this);
		btnDoiMatKhau.addActionListener(controller);
		btnThoat.addActionListener(controller);
		btnMatKhauCu.addActionListener(controller);
		btnMatKhauMoi.addActionListener(controller);
		btnNhapLaiMK.addActionListener(controller);

	}

	public void chonThoat() {
		this.dispose();
	}

	public void chonDoiMatKhau() throws RemoteException {
		if (kiemTraMatKhau()) {
			String matKhauMoi = new String(txtMatKhauMoi.getPassword());
			if (JOptionPane.showConfirmDialog(this, "Xác nhận đổi mật khẩu?", "Thông báo",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				if (quanLyNhanVienDAO.doiMatKhau(matKhauMoi, nhanVienEntity.getSoDienThoai())) {
					JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					chonThoat();
				} else {
					JOptionPane.showMessageDialog(this, "Đổi mật khẩu không thành công", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			}
		}
	}

	public void chonXemMatKhauCu() {
		xemMKCu = !xemMKCu;
		if (xemMKCu) {
			btnMatKhauCu.setIcon(new ImageIcon(GD_DoiMatKhau.class.getResource("/images/iconMatMo.png")));
			txtMatKhauCu.setEchoChar((char) 0);
		} else {
			btnMatKhauCu.setIcon(new ImageIcon(GD_DoiMatKhau.class.getResource("/images/iconMatNham.png")));
			txtMatKhauCu.setEchoChar('•');
		}
	}

	public void chonXemMatKhauMoi() {
		xemMKMoi = !xemMKMoi;
		if (xemMKMoi) {
			btnMatKhauMoi.setIcon(new ImageIcon(GD_DoiMatKhau.class.getResource("/images/iconMatMo.png")));
			txtMatKhauMoi.setEchoChar((char) 0);
		} else {
			btnMatKhauMoi.setIcon(new ImageIcon(GD_DoiMatKhau.class.getResource("/images/iconMatNham.png")));
			txtMatKhauMoi.setEchoChar('•');
		}
	}

	public void chonXemLaiMatKhau() {
		xemLaiMK = !xemLaiMK;
		if (xemLaiMK) {
			btnNhapLaiMK.setIcon(new ImageIcon(GD_DoiMatKhau.class.getResource("/images/iconMatMo.png")));
			txtNhapLaiMK.setEchoChar((char) 0);
		} else {
			btnNhapLaiMK.setIcon(new ImageIcon(GD_DoiMatKhau.class.getResource("/images/iconMatNham.png")));
			txtNhapLaiMK.setEchoChar('•');
		}
	}

	private boolean kiemTraMatKhau() {
		String matKhauCu = new String(txtMatKhauCu.getPassword());
		String matKhauMoi = new String(txtMatKhauMoi.getPassword());
		String nhapLaiMatKhauMoi = new String(txtNhapLaiMK.getPassword());

		if (matKhauCu.isEmpty() || matKhauMoi.isEmpty() || matKhauMoi.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Mật khẩu không được để trống");
			return false;
		} else if (matKhauMoi.equals(matKhauCu) == true) {
			JOptionPane.showMessageDialog(this, "Mật khẩu mới phải khác mật khẩu hiện tại");
			return false;
		} else if (nhapLaiMatKhauMoi.equals(matKhauMoi) == false) {
			JOptionPane.showMessageDialog(this, "Mật khẩu không giống nhau!");
			return false;
		} else if (!matKhauMoi.matches("^[a-zA-Z][0-9a-zA-Z]{7}$")) {
			JOptionPane.showMessageDialog(this, "Mật khẩu mới phải có ít nhất 8 kí tự và bắt đầu bằng chữ!");
			return false;
		}
		return true;
	}

}
