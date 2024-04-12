package gui.nhanVien;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.QuanLyTaiKhoanController;
import dao.QuanLyNhanVienDAO;
import entities.NhanVienEntity;
import gui.dangNhap.GD_DangNhap;
import gui.dangNhap.GD_DoiMatKhau;

public class GD_QuanLyTaiKhoan extends JPanel {
	private static final long serialVersionUID = 1L;
	// JPanel
	private JPanel pnlTaiKhoan;
	// JLable
	private JLabel lblNamSinh;
	private JLabel lblMaNV;
	private JLabel lblHoVaTen;
	private JLabel lblChucVu;
	private JLabel lblSoDienThoai;
	private JLabel lblCCCD;
	private JLabel lblEmail;
	private JLabel lblThongTinCaNhan;
	// JTextField
	private JTextField txtMaNV;
	private JTextField txtHoVaTen;
	private JTextField txtChucVu;
	private JTextField txtSoDienThoai;
	private JTextField txtCCCD;
	private JTextField txtEmail;
	private JTextField txtNamSinh;
	private DefaultTableModel tblmodelLichLamViec;
	
	// JButton
	public JButton btnDangXuat;
	public JButton btnDoiMatKhau;
	public JButton btnChinhSua;

	private List<NhanVienEntity> listNhanVien;
	
	private NhanVienEntity nhanVienEntity = new NhanVienEntity();
	private QuanLyNhanVienDAO quanLyNhanVienDAO = new QuanLyNhanVienDAO();

	private QuanLyTaiKhoanController controller;
	

	public GD_QuanLyTaiKhoan(NhanVienEntity nhanVienEntity) {
		this.nhanVienEntity = nhanVienEntity;
		setLayout(null);
		setBounds(0, 0, 1365, 694);

		pnlTaiKhoan = new JPanel();
		pnlTaiKhoan.setBackground(new Color(230, 230, 250));
		pnlTaiKhoan.setBounds(0, 0, 1365, 694);
		add(pnlTaiKhoan);
		pnlTaiKhoan.setLayout(null);

		lblMaNV = new JLabel("Mã nhân viên:");
		lblMaNV.setBounds(435, 306, 110, 30);
		lblMaNV.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(lblMaNV);

		txtMaNV = new JTextField();
		txtMaNV.setSelectionColor(Color.BLACK);
		txtMaNV.setSelectedTextColor(Color.BLACK);
		txtMaNV.setDisabledTextColor(Color.BLACK);
		txtMaNV.setBorder(null);
		txtMaNV.setEnabled(false);
		txtMaNV.setBounds(546, 306, 389, 30);
		txtMaNV.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(txtMaNV);
		txtMaNV.setColumns(10);

		lblHoVaTen = new JLabel("Họ và tên:");
		lblHoVaTen.setBounds(435, 356, 110, 30);
		lblHoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(lblHoVaTen);

		txtHoVaTen = new JTextField();
		txtHoVaTen.setDisabledTextColor(Color.BLACK);
		txtHoVaTen.setSelectedTextColor(Color.BLACK);
		txtHoVaTen.setSelectionColor(Color.BLACK);
		txtHoVaTen.setBorder(null);
		txtHoVaTen.setEnabled(false);
		txtHoVaTen.setBounds(546, 356, 389, 30);
		txtHoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(txtHoVaTen);
		txtHoVaTen.setColumns(10);

		lblChucVu = new JLabel("Chức vụ:");
		lblChucVu.setBounds(435, 406, 110, 30);
		lblChucVu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(lblChucVu);

		txtChucVu = new JTextField();
		txtChucVu.setSelectionColor(Color.BLACK);
		txtChucVu.setSelectedTextColor(Color.BLACK);
		txtChucVu.setDisabledTextColor(Color.BLACK);
		txtChucVu.setBorder(null);
		txtChucVu.setEnabled(false);
		txtChucVu.setBounds(546, 406, 145, 30);
		txtChucVu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(txtChucVu);
		txtChucVu.setColumns(10);

		lblSoDienThoai = new JLabel("Số điện thoại:");
		lblSoDienThoai.setBounds(435, 456, 110, 30);
		lblSoDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(lblSoDienThoai);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setSelectionColor(SystemColor.textHighlight);
		txtSoDienThoai.setSelectedTextColor(SystemColor.text);
		txtSoDienThoai.setDisabledTextColor(Color.BLACK);
		txtSoDienThoai.setBounds(546, 456, 389, 30);
		txtSoDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(txtSoDienThoai);
		txtSoDienThoai.setColumns(10);

		lblCCCD = new JLabel("CCCD/CMND:");
		lblCCCD.setBounds(435, 506, 110, 30);
		lblCCCD.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(lblCCCD);

		txtCCCD = new JTextField();
		txtCCCD.setDisabledTextColor(Color.BLACK);
		txtCCCD.setSelectionColor(Color.BLACK);
		txtCCCD.setSelectedTextColor(Color.BLACK);
		txtCCCD.setBorder(null);
		txtCCCD.setEnabled(false);
		txtCCCD.setBounds(546, 506, 389, 30);
		txtCCCD.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(txtCCCD);
		txtCCCD.setColumns(10);

		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(435, 556, 110, 30);
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setSelectionColor(SystemColor.textHighlight);
		txtEmail.setSelectedTextColor(SystemColor.text);
		txtEmail.setDisabledTextColor(Color.BLACK);
		txtEmail.setBounds(546, 556, 389, 30);
		txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(txtEmail);
		txtEmail.setColumns(10);

		lblThongTinCaNhan = new JLabel("THÔNG TIN CÁ NHÂN");
		lblThongTinCaNhan.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblThongTinCaNhan.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongTinCaNhan.setBounds(0, 40, 1365, 40);
		pnlTaiKhoan.add(lblThongTinCaNhan);

		btnDoiMatKhau = new JButton("Đổi mật khẩu");
		btnDoiMatKhau.setIcon(new ImageIcon(GD_QuanLyTaiKhoan.class.getResource("/images/iconLamMoi.png")));
		btnDoiMatKhau.setFont(new Font("Cambria", Font.BOLD, 14));
		btnDoiMatKhau.setForeground(new Color(0, 0, 0));
		btnDoiMatKhau.setBackground(new Color(144, 238, 144));
		btnDoiMatKhau.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDoiMatKhau.setFocusPainted(false);
		btnDoiMatKhau.setBounds(610, 607, 150, 35);
		pnlTaiKhoan.add(btnDoiMatKhau);

		btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setIcon(new ImageIcon(GD_QuanLyTaiKhoan.class.getResource("/images/iconDangXuat.png")));
		btnDangXuat.setFont(new Font("Cambria", Font.BOLD, 14));
		btnDangXuat.setForeground(new Color(0, 0, 0));
		btnDangXuat.setBackground(new Color(144, 238, 144));
		btnDangXuat.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDangXuat.setFocusPainted(false);
		btnDangXuat.setBounds(785, 607, 150, 35);
		pnlTaiKhoan.add(btnDangXuat);

		btnChinhSua = new JButton("Chỉnh sửa");
		btnChinhSua.setIcon(new ImageIcon(GD_QuanLyTaiKhoan.class.getResource("/images/iconChinhSua1.png")));
		btnChinhSua.setForeground(new Color(0, 0, 0));
		btnChinhSua.setFont(new Font("Cambria", Font.BOLD, 14));
		btnChinhSua.setFocusPainted(false);
		btnChinhSua.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnChinhSua.setBackground(new Color(144, 238, 144));
		btnChinhSua.setBounds(435, 607, 150, 35);
		pnlTaiKhoan.add(btnChinhSua);

		lblNamSinh = new JLabel("Năm sinh:");
		lblNamSinh.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNamSinh.setBounds(708, 406, 80, 30);
		pnlTaiKhoan.add(lblNamSinh);

		txtNamSinh = new JTextField();
		txtNamSinh.setDisabledTextColor(Color.BLACK);
		txtNamSinh.setEnabled(false);
		txtNamSinh.setSelectionColor(Color.BLACK);
		txtNamSinh.setSelectedTextColor(Color.BLACK);
		txtNamSinh.setBorder(null);
		txtNamSinh.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtNamSinh.setColumns(10);
		txtNamSinh.setBounds(790, 406, 145, 30);
		pnlTaiKhoan.add(txtNamSinh);

		String[] cols = { "STT", "Ngày", "Ca trực", "Giờ bắt đầu", "Giờ kết thúc" };
		tblmodelLichLamViec = new DefaultTableModel(cols, 0);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		DefaultTableCellRenderer rigtRenderer = new DefaultTableCellRenderer();
		rigtRenderer.setHorizontalAlignment(JLabel.RIGHT);

		JLabel lblAnhDaiDien = new JLabel("");
		lblAnhDaiDien.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnhDaiDien.setIcon(new ImageIcon(GD_QuanLyTaiKhoan.class.getResource("/images/iconAvatar.png")));
		lblAnhDaiDien.setBounds(607, 112, 150, 150);
		pnlTaiKhoan.add(lblAnhDaiDien);

		controller = new QuanLyTaiKhoanController(this);
		btnDangXuat.addActionListener(controller);
		btnChinhSua.addActionListener(controller);
		btnDoiMatKhau.addActionListener(controller);
		loadData();
	}

	public void loadData() {
		txtMaNV.setText(nhanVienEntity.getMaNhanVien());
		txtHoVaTen.setText(nhanVienEntity.getHoTen());
		txtEmail.setText(nhanVienEntity.getEmail());
		txtChucVu.setText(nhanVienEntity.getChucVu());
		txtCCCD.setText(nhanVienEntity.getcCCD());
		txtNamSinh.setText(String.valueOf(nhanVienEntity.getNamSinh()));
		txtSoDienThoai.setText(nhanVienEntity.getSoDienThoai());

	}

	public void chonDoiMatKhau() {
		new GD_DoiMatKhau(nhanVienEntity).setVisible(true);
	}

	public void chonDangXuat() {
		if (JOptionPane.showConfirmDialog(this, "Thông báo", "Xác nhận đăng xuất?",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			new GD_DangNhap().setVisible(true);
			JFrame manHinhCha = (JFrame) this.getTopLevelAncestor();
			manHinhCha.dispose();
		}
	}

	public void chonChinhSua() {
		if (kiemTraDuLieuChinhSua()) {
			if (JOptionPane.showConfirmDialog(this, "Xác nhận chỉnh sửa?", "Thông báo",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				String maNV = txtMaNV.getText().trim();
				String sdt = txtSoDienThoai.getText().trim();
				String email = txtEmail.getText().trim();

				nhanVienEntity = new NhanVienEntity(maNV, nhanVienEntity.getHoTen(), sdt, email,
						nhanVienEntity.getcCCD(), "", nhanVienEntity.getNamSinh(), nhanVienEntity.getMucLuong(),
						nhanVienEntity.getChucVu(), nhanVienEntity.isTrangThai());
				if (quanLyNhanVienDAO.chinhSua(nhanVienEntity)) {
					JOptionPane.showMessageDialog(this, "Chỉnh sửa thông tin nhân viên thành công");
					txtEmail.setText("");
					txtSoDienThoai.setText("");
					loadData();
				} else {
					JOptionPane.showMessageDialog(this, "Chỉnh sửa thông tin cá nhân KHÔNG thành công", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin cần chỉnh sửa", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
	}

	private boolean kiemTraDuLieuChinhSua() {
		if (!kiemTraSoDienThoaiChinhSua())
			return false;

		if (!kiemTraEmail())
			return false;

		return true;
	}

	private boolean kiemTraSoDienThoaiChinhSua() {
		listNhanVien = new ArrayList<>();
		listNhanVien = quanLyNhanVienDAO.duyetDanhSach();
		String soDienThoai = txtSoDienThoai.getText().trim();
		if (soDienThoai.length() > 0) {
			if (!(soDienThoai.length() == 10 && soDienThoai.matches("\\d{10}"))) {
				JOptionPane.showMessageDialog(this, "Số điện thoại phải là 10 ký số", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtSoDienThoai.requestFocus();
				return false;
			}
			if (!soDienThoai.equals(nhanVienEntity.getSoDienThoai())
					&& listNhanVien.contains(new NhanVienEntity("", soDienThoai, "", "", "", 0, 0, "", true))) {
				JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại trong hệ thống", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtSoDienThoai.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtSoDienThoai.requestFocus();
			return false;
		}
		return true;
	}

	private boolean kiemTraEmail() {
		String email = txtEmail.getText().trim();
		if (email.length() > 0) {
			if (!(email.matches("\\w+@gmail\\.com") || email.matches("\\w+@email\\.com"))) {
				JOptionPane.showMessageDialog(this, "Email phải nhập dạng username@domain.com", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtEmail.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Email không được để trống");
			txtEmail.requestFocus();
			return false;
		}
		return true;
	}
}
