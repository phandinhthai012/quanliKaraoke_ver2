package gui.khachHang;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.QuanLyKhachHangController;
import dao.QuanLyKhachHangDAO;
import entities.KhachHangEntity;

public class GD_QuanLyKhachHang extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel pnlKhachHang;
	private JPanel pnlTimKiem;
	private JPanel pnlChucNang;

	// JTextField
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtSDT;
	private JTextField txtNamSinh;
	private JTextField txtEmail;
	private JTextField txtSoDienThoaiTim;
	private JTextField txtSoLanDatPhongToiThieu;
	private JTextField txtSoLanDatPhongToiDa;
	private JTextField txtSLDatPhong;
	private JTextField txtTenKhachHangTim;
	private DefaultTableModel tblmdelKhachHang;

	// JTable
	private JTable tblKhachHang;

	// JLabel
	private JLabel lblMaKhachHang;
	private JLabel lblTenKhachHang;
	private JLabel lblSDT;
	private JLabel lblNamSinh;
	private JLabel lblSoDienThoai;
	private JLabel lblEmail;
	private JLabel lblKhachHang;
	private JLabel lblTenKH;
	private JLabel lblSLDatPhong;
	private JLabel lblDanhSchKhch;

	// JButton
	public JButton btnChinhSua;
	public JButton btnTimKiem;
	public JButton btnThem;
	public JButton btnLamMoi;

	// JScrollPane
	private JScrollPane scrKhachHang;

	private QuanLyKhachHangController controller;
	private QuanLyKhachHangDAO quanLyKhachHangDAO = new QuanLyKhachHangDAO();
	private List<KhachHangEntity> list;

	public GD_QuanLyKhachHang() {
		setLayout(null);
		setBounds(0, 0, 1365, 694);

		pnlKhachHang = new JPanel();
		pnlKhachHang.setBackground(new Color(211, 211, 211));
		pnlKhachHang.setBounds(0, 0, 1365, 694);
		add(pnlKhachHang);
		pnlKhachHang.setLayout(null);

		pnlChucNang = new JPanel();
		pnlChucNang.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pnlChucNang.setBackground(new Color(230, 230, 250));
		pnlChucNang.setBounds(0, 370, 1365, 324);
		pnlKhachHang.add(pnlChucNang);
		pnlChucNang.setLayout(null);

		String[] cols_KhachHang = { "STT", "Mã Khách Hàng", "Tên khách hàng", "Số điện thoại", "Email", "Năm Sinh",
				"Số Lượng Đặt Phòng" };
		tblmdelKhachHang = new DefaultTableModel(cols_KhachHang, 0);
		tblKhachHang = new JTable(tblmdelKhachHang);
		scrKhachHang = new JScrollPane(tblKhachHang);
		scrKhachHang.setBounds(30, 58, 1305, 256);
		pnlChucNang.add(scrKhachHang);

		lblDanhSchKhch = new JLabel("Danh sách khách hàng");
		lblDanhSchKhch.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSchKhch.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDanhSchKhch.setBounds(0, 10, 1365, 40);
		pnlChucNang.add(lblDanhSchKhch);

		pnlTimKiem = new JPanel();
		pnlTimKiem.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		pnlTimKiem.setBounds(0, 0, 1365, 137);
		pnlKhachHang.add(pnlTimKiem);
		pnlTimKiem.setBackground(new Color(230, 230, 250));
		pnlTimKiem.setLayout(null);

		lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setBounds(380, 30, 110, 30);
		pnlTimKiem.add(lblSDT);
		lblSDT.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setIcon(new ImageIcon(GD_QuanLyKhachHang.class.getResource("/images/iconTimKiem.png")));
		btnTimKiem.setFocusable(false);
		btnTimKiem.setBackground(new Color(144, 238, 144));
		btnTimKiem.setFont(new Font("Cambria", Font.BOLD, 14));
		btnTimKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiem.setBounds(1185, 85, 150, 35);
		pnlTimKiem.add(btnTimKiem);

		txtSoDienThoaiTim = new JTextField();
		txtSoDienThoaiTim.setColumns(10);
		txtSoDienThoaiTim.setBounds(480, 30, 200, 30);
		pnlTimKiem.add(txtSoDienThoaiTim);

		lblTenKH = new JLabel("Tên khách hàng:");
		lblTenKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTenKH.setBounds(30, 30, 110, 30);
		pnlTimKiem.add(lblTenKH);

		txtTenKhachHangTim = new JTextField();
		txtTenKhachHangTim.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTenKhachHangTim.setColumns(10);
		txtTenKhachHangTim.setBounds(140, 30, 200, 30);
		pnlTimKiem.add(txtTenKhachHangTim);

		JPanel pnlTimTheoSoLanDatPhong = new JPanel();
		pnlTimTheoSoLanDatPhong.setBackground(new Color(230, 230, 250));
		pnlTimTheoSoLanDatPhong.setBorder(new TitledBorder(null, "S\u1ED1 l\u1EA7n \u0111\u1EB7t ph\u00F2ng",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlTimTheoSoLanDatPhong.setBounds(725, 15, 610, 60);
		pnlTimKiem.add(pnlTimTheoSoLanDatPhong);
		pnlTimTheoSoLanDatPhong.setLayout(null);

		JLabel lblSoLanDatPhongTu = new JLabel("Từ:");
		lblSoLanDatPhongTu.setHorizontalAlignment(SwingConstants.LEFT);
		lblSoLanDatPhongTu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSoLanDatPhongTu.setBounds(21, 20, 40, 30);
		pnlTimTheoSoLanDatPhong.add(lblSoLanDatPhongTu);

		JLabel lblSoLanDatPhongDen = new JLabel("Đến:");
		lblSoLanDatPhongDen.setHorizontalAlignment(SwingConstants.LEFT);
		lblSoLanDatPhongDen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSoLanDatPhongDen.setBounds(300, 19, 54, 30);
		pnlTimTheoSoLanDatPhong.add(lblSoLanDatPhongDen);

		txtSoLanDatPhongToiThieu = new JTextField();
		txtSoLanDatPhongToiThieu.setColumns(10);
		txtSoLanDatPhongToiThieu.setBounds(60, 20, 200, 30);
		pnlTimTheoSoLanDatPhong.add(txtSoLanDatPhongToiThieu);

		txtSoLanDatPhongToiDa = new JTextField();
		txtSoLanDatPhongToiDa.setColumns(10);
		txtSoLanDatPhongToiDa.setBounds(350, 20, 200, 30);
		pnlTimTheoSoLanDatPhong.add(txtSoLanDatPhongToiDa);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(GD_QuanLyKhachHang.class.getResource("/images/iconLamMoi.png")));
		btnLamMoi.setBounds(1000, 85, 150, 35);
		pnlTimKiem.add(btnLamMoi);
		btnLamMoi.setFont(new Font("Cambria", Font.BOLD, 14));
		btnLamMoi.setFocusable(false);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setBackground(new Color(144, 238, 144));

		JPanel pnlThongTin = new JPanel();
		pnlThongTin.setBorder(null);
		pnlThongTin.setBackground(new Color(230, 230, 250));
		pnlThongTin.setBounds(0, 137, 1365, 233);
		pnlKhachHang.add(pnlThongTin);
		pnlThongTin.setLayout(null);

		lblMaKhachHang = new JLabel("Mã Khách Hàng:");
		lblMaKhachHang.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaKhachHang.setBounds(27, 70, 112, 30);
		pnlThongTin.add(lblMaKhachHang);
		lblMaKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtMaKH = new JTextField();
		txtMaKH.setDisabledTextColor(Color.BLACK);
		txtMaKH.setForeground(Color.BLACK);
		txtMaKH.setBackground(Color.WHITE);
		txtMaKH.setBounds(150, 70, 290, 30);
		pnlThongTin.add(txtMaKH);
		txtMaKH.setEnabled(false);
		txtMaKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaKH.setColumns(10);

		lblTenKhachHang = new JLabel("Tên Khách Hàng:");
		lblTenKhachHang.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenKhachHang.setBounds(466, 70, 112, 30);
		pnlThongTin.add(lblTenKhachHang);
		lblTenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtTenKH = new JTextField();
		txtTenKH.setBounds(585, 70, 290, 30);
		pnlThongTin.add(txtTenKH);
		txtTenKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTenKH.setColumns(10);

		lblNamSinh = new JLabel("Năm Sinh:");
		lblNamSinh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNamSinh.setBounds(40, 120, 99, 30);
		pnlThongTin.add(lblNamSinh);
		lblNamSinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtSDT = new JTextField();
		txtSDT.setBounds(585, 120, 290, 30);
		pnlThongTin.add(txtSDT);
		txtSDT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtSDT.setColumns(10);

		lblSoDienThoai = new JLabel("Số Điện Thoại:");
		lblSoDienThoai.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoDienThoai.setBounds(479, 120, 99, 30);
		pnlThongTin.add(lblSoDienThoai);
		lblSoDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtNamSinh = new JTextField();
		txtNamSinh.setBounds(150, 120, 290, 30);
		pnlThongTin.add(txtNamSinh);
		txtNamSinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtNamSinh.setColumns(10);

		lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(978, 120, 59, 30);
		pnlThongTin.add(lblEmail);
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtEmail = new JTextField();
		txtEmail.setBounds(1045, 120, 290, 30);
		pnlThongTin.add(txtEmail);
		txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtEmail.setColumns(10);

		lblKhachHang = new JLabel("Thông Tin Khách Hàng");
		lblKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		lblKhachHang.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblKhachHang.setBounds(0, 0, 1365, 60);
		pnlThongTin.add(lblKhachHang);

		btnChinhSua = new JButton("Chỉnh Sửa");
		btnChinhSua.setIcon(new ImageIcon(GD_QuanLyKhachHang.class.getResource("/images/iconChinhSua1.png")));
		btnChinhSua.setBounds(1185, 170, 150, 35);
		pnlThongTin.add(btnChinhSua);
		btnChinhSua.setFocusable(false);
		btnChinhSua.setBackground(new Color(144, 238, 144));
		btnChinhSua.setFont(new Font("Cambria", Font.BOLD, 14));
		btnChinhSua.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(GD_QuanLyKhachHang.class.getResource("/images/iconThem.png")));
		btnThem.setBounds(1000, 170, 150, 35);
		pnlThongTin.add(btnThem);
		btnThem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThem.setBackground(new Color(144, 238, 144));
		btnThem.setFont(new Font("Cambria", Font.BOLD, 14));

		txtSLDatPhong = new JTextField();
		txtSLDatPhong.setBackground(Color.WHITE);
		txtSLDatPhong.setEditable(false);
		txtSLDatPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtSLDatPhong.setColumns(10);
		txtSLDatPhong.setBounds(1045, 70, 290, 30);
		pnlThongTin.add(txtSLDatPhong);

		lblSLDatPhong = new JLabel("Số lần đặt phòng:");
		lblSLDatPhong.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSLDatPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSLDatPhong.setBounds(897, 70, 140, 30);
		pnlThongTin.add(lblSLDatPhong);

		controller = new QuanLyKhachHangController(this);
		btnThem.addActionListener(controller);
		btnChinhSua.addActionListener(controller);
		btnTimKiem.addActionListener(controller);
		btnLamMoi.addActionListener(controller);
		tblKhachHang.addMouseListener(controller);
		loadData();

	}

	private void loadData() {
		tblKhachHang.removeAll();
		tblKhachHang.setRowSelectionAllowed(false);
		tblmdelKhachHang.setRowCount(0);
		list = quanLyKhachHangDAO.duyetDanhSach();

		int stt = 1;
		for (KhachHangEntity khachHangEntity : list)
			tblmdelKhachHang.addRow(new Object[] { stt++, khachHangEntity.getMaKhachHang(), khachHangEntity.getHoTen(),
					khachHangEntity.getSoDienThoai(), khachHangEntity.getEmail(), khachHangEntity.getNamSinh(),
					khachHangEntity.getSoLanDatPhong() });
	}

	public void hienThiThongTin() {
		list = quanLyKhachHangDAO.duyetDanhSach();
		int row = tblKhachHang.getSelectedRow();
		if (row >= 0) {
			txtMaKH.setText(list.get(row).getMaKhachHang());
			txtTenKH.setText(list.get(row).getHoTen());
			txtSDT.setText(list.get(row).getSoDienThoai());
			txtEmail.setText(list.get(row).getEmail());
			txtNamSinh.setText(String.valueOf(list.get(row).getNamSinh()));
			txtSLDatPhong.setText(String.valueOf(list.get(row).getSoLanDatPhong()));
		}
	}

	public void chonChucNangLamMoi() {
		txtEmail.setText("");
		txtMaKH.setText("");
		txtNamSinh.setText("");
		txtSDT.setText("");
		txtSLDatPhong.setText("");
		txtSoLanDatPhongToiThieu.setText("");
		txtSoLanDatPhongToiDa.setText("");
		txtSoDienThoaiTim.setText("");
		txtTenKH.setText("");
		txtTenKhachHangTim.setText("");
		tblKhachHang.setRowSelectionAllowed(false);
		loadData();
	}

	public void chonChucNangThem() {
		if (kiemTraDuLieuThem()) {
			String hoTen = txtTenKH.getText();
			String sdt = txtSDT.getText();
			String email = txtEmail.getText();
			int namSinh = Integer.parseInt(txtNamSinh.getText());
			int slDatPhong = 0;
			KhachHangEntity khachHangEntity = new KhachHangEntity(hoTen, sdt, email, namSinh, slDatPhong);
			khachHangEntity = quanLyKhachHangDAO.them(khachHangEntity);
			loadData();
		}
	}

	public void chonChucNangChinhSua() {
		int row = tblKhachHang.getSelectedRow();
		if (row == -1) {
			if (kiemTraDuLieuChinhSua()) {
				if (JOptionPane.showConfirmDialog(this, "Xác nhận chỉnh sửa?", "Thông báo",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					String maKH = txtMaKH.getText().trim();
					String hoTen = txtTenKH.getText().trim();
					String sdt = txtSDT.getText().trim();
					String email = txtEmail.getText().trim();
					int namSinh = Integer.parseInt(txtNamSinh.getText().trim());
					int slDatPhong = Integer.parseInt(txtSLDatPhong.getText().trim());
					KhachHangEntity khachHangEntity = new KhachHangEntity(maKH, hoTen, sdt, email, namSinh, slDatPhong);
					if (quanLyKhachHangDAO.chinhSua(khachHangEntity) != 0) {
						JOptionPane.showMessageDialog(this, "Chỉnh sửa thông tin khách hàng thành công ", "Thông Báo",
								JOptionPane.INFORMATION_MESSAGE);
						chonChucNangLamMoi();
						loadData();
					}
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Chọn Khách Hàng cần chỉnh sửa");
		}
	}

	public void chonChucNangTimKiem() {
		if (kiemTraDuLieuTim()) {
			String tenKH = txtTenKhachHangTim.getText().trim();
			String sdt = txtSoDienThoaiTim.getText().trim();
			int soluongTu = -1, soluongDen = -1;
			if (!txtSoLanDatPhongToiThieu.getText().equals(""))
				soluongTu = Integer.parseInt(txtSoLanDatPhongToiThieu.getText().trim());

			if (!txtSoLanDatPhongToiDa.getText().equals(""))
				soluongDen = Integer.parseInt(txtSoLanDatPhongToiDa.getText().trim());

			tblKhachHang.removeAll();
			tblmdelKhachHang.setRowCount(0);
			list = quanLyKhachHangDAO.timKiem(tenKH, sdt, soluongTu, soluongDen);
			int stt = 1;
			for (KhachHangEntity khachHangEntity : list)
				tblmdelKhachHang.addRow(new Object[] { stt++, khachHangEntity.getMaKhachHang(),
						khachHangEntity.getHoTen(), khachHangEntity.getSoDienThoai(), khachHangEntity.getEmail(),
						khachHangEntity.getNamSinh(), khachHangEntity.getSoLanDatPhong() });

		}
	}

	private boolean kiemTraDuLieuThem() {
		if (!kiemTraHoTen())
			return false;

		if (!kiemTraNamSinh())
			return false;

		if (!kiemTraSoDienThoaiThem())
			return false;

		if (!kiemTraEmail())
			return false;

		return true;
	}

	private boolean kiemTraHoTen() {
		if (!(txtTenKH.getText().trim().length() > 0)) {
			JOptionPane.showMessageDialog(this, "Họ tên không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtTenKH.requestFocus();
			return false;
		}
		return true;
	}

	private boolean kiemTraSoDienThoaiThem() {
		list = quanLyKhachHangDAO.duyetDanhSach();
		String sdt = txtSDT.getText().trim();
		if (sdt.length() > 0) {
			if (!(sdt.length() == 10 && sdt.matches("\\d{10}"))) {
				JOptionPane.showMessageDialog(this, "Số điện thoại phải là 10 ký số", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtSDT.requestFocus();
				return false;
			}
			if (list.contains(new KhachHangEntity("", "", sdt, "", 0, 0))) {
				JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại trong hệ thống", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtSDT.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtSDT.requestFocus();
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

	private boolean kiemTraNamSinh() {
		if (txtNamSinh.getText().trim().length() > 0) {
			try {
				int nam = Integer.parseInt(txtNamSinh.getText().trim());
				int tuoi = 2023 - nam;
				if (!(tuoi >= 18)) {
					JOptionPane.showMessageDialog(this, "Khách Hàng phải từ 18 ", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					txtNamSinh.requestFocus();
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Năm sinh nhập vào  là số nguyên", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtNamSinh.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Năm sinh không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtNamSinh.requestFocus();
			return false;
		}
		return true;
	}

	private boolean kiemTraDuLieuChinhSua() {
		if (!kiemTraSoDienThoaiChinhSua())
			return false;

		if (!kiemTraHoTen())
			return false;

		if (!kiemTraNamSinh())
			return false;

		if (!kiemTraEmail())
			return false;

		return true;
	}

	private boolean kiemTraSoDienThoaiChinhSua() {
		list = quanLyKhachHangDAO.duyetDanhSach();
		String sdt = txtSDT.getText().trim();
		int row = tblKhachHang.getSelectedRow();
		if (row >= 0) {
			if (sdt.length() > 0) {
				if (!(sdt.length() == 10 && sdt.matches("\\d{10}"))) {
					JOptionPane.showMessageDialog(this, "Số điện thoại phải là 10 ký số", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					txtSDT.requestFocus();
					return false;
				}
				if (list.contains(new KhachHangEntity("", "", sdt, "", 0, 0))
						&& !list.get(row).getSoDienThoai().equals(sdt)) {
					JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại trong hệ thống", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					txtSDT.requestFocus();
					return false;
				}
			} else {
				JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtSDT.requestFocus();
				return false;
			}
		}
		return true;
	}

	private boolean kiemTraDuLieuTim() {

		if (!kiemTraSoLanDatPhong())
			return false;

		if (!kiemTraSoDienThoaiTim())
			return false;

		return true;
	}

	private boolean kiemTraSoLanDatPhong() {
		if (txtSoLanDatPhongToiThieu.getText().trim().length() > 0) {
			String soLuongTu = txtSoLanDatPhongToiThieu.getText().trim();
			try {
				int num = Integer.parseInt(soLuongTu);
				if (num < 0) {
					JOptionPane.showMessageDialog(this, "Số lượng tổi thiểu nhập vào phải là số nguyên");
					txtSoLanDatPhongToiThieu.requestFocus();
					return false;
				}
				if (txtSoLanDatPhongToiDa.getText().trim().length() > 0) {
					String soLuongDen = txtSoLanDatPhongToiDa.getText().trim();
					try {
						int num2 = Integer.parseInt(soLuongDen);
						if (num2 < num) {
							JOptionPane.showMessageDialog(this, "Số lượng tối đa lớn hơn hoặc bằng số lương tối thiểu");
							txtSoLanDatPhongToiDa.requestFocus();
							return false;
						}
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(this, "Số lượng tối đa nhập vào phải là số");
						txtSoLanDatPhongToiDa.requestFocus();
						return false;
					}
				} else {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng tối đa");
					txtSoLanDatPhongToiDa.requestFocus();
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Số lượng tối thiểu nhập vào phải là số");
				txtSoLanDatPhongToiThieu.requestFocus();
				return false;
			}
		}
		return true;
	}

	private boolean kiemTraSoDienThoaiTim() {
		if (txtSoDienThoaiTim.getText().trim().length() > 0) {
			if (txtSoDienThoaiTim.getText().trim().length() > 10) {
				JOptionPane.showMessageDialog(this, "Số điện thoại không được nhập quá 10 số");
				txtSoDienThoaiTim.requestFocus();
				return false;
			} else {
				try {
					Integer num = Integer.parseInt(txtSoDienThoaiTim.getText().trim());
					if (num < 0) {
						JOptionPane.showMessageDialog(this, "Số điện thoại không được nhập số âm");
						txtSoDienThoaiTim.requestFocus();
						return false;
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(this, "Số điện thoại phải nhập số");
					txtSoDienThoaiTim.requestFocus();
					return false;
				}
			}
		}
		return true;
	}

}
