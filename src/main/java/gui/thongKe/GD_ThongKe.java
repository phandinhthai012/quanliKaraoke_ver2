package gui.thongKe;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;

import controller.ThongKeController;
import dao.QuanLyHoaDonDAO;
import dao.QuanLyKhachHangDAO;
import dao.QuanLyNhanVienDAO;
import dao.ThongKeDAO;
import entities.ChiTietHoaDonEntity;
import entities.HoaDonEntity;
import entities.KhachHangEntity;
import entities.NhanVienEntity;
import entities.PhongEntity;
import gui.hoaDon.GD_XemChiTietHoaDonThongKe;
import util.DateFormatter;
import util.MoneyFormatter;
import util.TimeFormatter;

public class GD_ThongKe extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTabbedPane tabThongKe;
	private JPanel pnlThongKe;

	/**
	 * Doanh thu
	 */
	private JPanel pnlThongKeDoanhThu;
	private JPanel pnlThongKeDoanhThuCon;
	private JPanel pnlThongTinDoanhThu;
	private JPanel pnlChiTietDoanhThu;
	private JPanel pnlDSDoanhThu;
	private JPanel pnlTimKiemDoanhThu;

	private JLabel lblTieuDeDoanhThu;
	private JLabel lblTongDoanhThu;
	private JLabel lblTongDoanhThuKetQua;
	private JLabel lblTongSoHDKetQua;
	private JLabel lblTongSoHD;
	private JLabel lblTongTienHat;
	private JLabel lblTongTienHatKetQua;
	private JLabel lblTongTienDichVu;
	private JLabel lblTongTienDichVuKetQua;
	private JLabel lblchonNgayDoanhThu;
	private JLabel lblchonThangDoanhThu;
	private JLabel lblchonNamDoanhThuThang;
	private JLabel lblchonNamDoanhThuNam;
	private JLabel lblDoanhThuTrungBinh;
	private JLabel lblDoanhThuTrungBinhKetQua;
	private JLabel lblChuThichDoanhThu;

	private JYearChooser cmbNamDoanhThuThang; // combobox chọn năm trong tìm kiếm doanh thu theo tháng
	private JYearChooser cmbNamDoanhThuNam;

	private JDateChooser chonNgayDoanhThu;

	private JComboBox<String> cmbThangDoanhThu;
	private DefaultComboBoxModel<String> cmbmodelThangDoanhThu;
	private DefaultComboBoxModel<String> cmbmodelThangLuong; // model của combobox chọn tháng trong thống kê lương nhân

	public JTable tblHoaDon;
	private DefaultTableModel tblmodelHoaDon;
	private DefaultTableModel tblmodelNhanVien;
	private JScrollPane scrHoaDon;

	private ButtonGroup grpDoanhThu;
	public JRadioButton radTheoNgay;
	public JRadioButton radTheoThang;
	public JRadioButton radTheoNam;
	public JButton btnTimKiemDoanhThuNgay;
	public JButton btnTimKiemDoanhThuThang; // button chọn tìm kiếm doanh thu thao tháng
	public JButton btnTimKiemDoanhThuNam;
	public JButton btnXemChiTietHoaDonDoanhThu;

	private List<NhanVienEntity> listNhanVien = new ArrayList<>();
	private List<HoaDonEntity> listHoaDon = new ArrayList<>();
	private List<ChiTietHoaDonEntity> listChiTietHoaDon = new ArrayList<>();
	private NhanVienEntity nhanVienEntity = null;

	private QuanLyHoaDonDAO quanLyHoaDonDAO = new QuanLyHoaDonDAO();
	private QuanLyKhachHangDAO quanLyKhachHangDAO = new QuanLyKhachHangDAO();

	private QuanLyNhanVienDAO quanLyNhanVienDAO = new QuanLyNhanVienDAO();
	private ThongKeDAO thongKeDAO = new ThongKeDAO();

	/**
	 * 
	 */

	public GD_ThongKe() {
		setBackground(new Color(230, 230, 250));
		setLayout(null);
		setBounds(0, 0, 1365, 695);
		/**
		 * Thong ke doanh thu
		 */
		pnlThongKe = new JPanel();
		pnlThongKe.setBounds(0, 0, 1365, 695);
		add(pnlThongKe);
		pnlThongKe.setLayout(null);

		tabThongKe = new JTabbedPane(JTabbedPane.TOP);
		tabThongKe.setBackground(new Color(230, 230, 250));
		tabThongKe.setBorder(null);
		tabThongKe.setBounds(0, 0, 1365, 695);
		pnlThongKe.add(tabThongKe);

		pnlThongKeDoanhThu = new JPanel();
		pnlThongKeDoanhThu.setBackground(new Color(230, 230, 250));
		pnlThongKeDoanhThu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabThongKe.addTab("Doanh Thu", null, pnlThongKeDoanhThu, null);
		tabThongKe.setForegroundAt(0, SystemColor.desktop);
		pnlThongKeDoanhThu.setLayout(null);

		lblTieuDeDoanhThu = new JLabel("Thống kê doanh thu");
		lblTieuDeDoanhThu.setBorder(null);
		lblTieuDeDoanhThu.setForeground(SystemColor.desktop);
		lblTieuDeDoanhThu.setBackground(new Color(230, 230, 250));
		lblTieuDeDoanhThu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDeDoanhThu.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTieuDeDoanhThu.setBounds(0, 0, 1365, 50);
		pnlThongKeDoanhThu.add(lblTieuDeDoanhThu);

		pnlThongKeDoanhThuCon = new JPanel();
		pnlThongKeDoanhThuCon.setBackground(new Color(230, 230, 250));
		pnlThongKeDoanhThuCon.setBorder(null);
		pnlThongKeDoanhThuCon.setBounds(0, 50, 1365, 617);
		pnlThongKeDoanhThu.add(pnlThongKeDoanhThuCon);
		pnlThongKeDoanhThuCon.setLayout(null);

		radTheoNgay = new JRadioButton("Theo ngày");
		radTheoNgay.setBackground(new Color(230, 230, 250));
		radTheoNgay.setFocusable(false);
		radTheoNgay.setSelected(true);
		radTheoNgay.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		radTheoNgay.setBounds(20, 15, 100, 23);
		pnlThongKeDoanhThuCon.add(radTheoNgay);

		radTheoThang = new JRadioButton("Theo tháng");
		radTheoThang.setBackground(new Color(230, 230, 250));
		radTheoThang.setFocusable(false);
		radTheoThang.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		radTheoThang.setBounds(130, 15, 110, 23);
		pnlThongKeDoanhThuCon.add(radTheoThang);

		radTheoNam = new JRadioButton("Theo năm");
		radTheoNam.setBackground(new Color(230, 230, 250));
		radTheoNam.setFocusable(false);
		radTheoNam.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		radTheoNam.setBounds(250, 15, 110, 23);
		pnlThongKeDoanhThuCon.add(radTheoNam);

		grpDoanhThu = new ButtonGroup();
		grpDoanhThu.add(radTheoNgay);
		grpDoanhThu.add(radTheoThang);
		grpDoanhThu.add(radTheoNam);

		pnlThongTinDoanhThu = new JPanel();
		pnlThongTinDoanhThu.setBounds(0, 53, 1365, 564);
		pnlThongKeDoanhThuCon.add(pnlThongTinDoanhThu);
		pnlThongTinDoanhThu.setLayout(null);

		pnlChiTietDoanhThu = new JPanel();
		pnlChiTietDoanhThu.setBorder(null);
		pnlChiTietDoanhThu.setBackground(SystemColor.menu);
		pnlChiTietDoanhThu.setBounds(0, 0, 672, 564);
		pnlThongTinDoanhThu.add(pnlChiTietDoanhThu);
		pnlChiTietDoanhThu.setLayout(null);

		pnlTimKiemDoanhThu = new JPanel();
		pnlTimKiemDoanhThu.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		pnlTimKiemDoanhThu.setBackground(new Color(230, 230, 250));
		pnlTimKiemDoanhThu.setBounds(0, 0, 671, 56);
		pnlChiTietDoanhThu.add(pnlTimKiemDoanhThu);
		pnlTimKiemDoanhThu.setLayout(null);

		/**
		 * Tim kiem doanh thu
		 */
		lblchonNgayDoanhThu = new JLabel("Chọn ngày");
		lblchonNgayDoanhThu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblchonNgayDoanhThu.setBounds(30, 11, 88, 30);
		pnlTimKiemDoanhThu.add(lblchonNgayDoanhThu);

		chonNgayDoanhThu = new JDateChooser();
		chonNgayDoanhThu.setDateFormatString("dd/MM/yyyy");
		chonNgayDoanhThu.setDate(new Date());
		chonNgayDoanhThu.setBounds(125, 11, 133, 30);
		pnlTimKiemDoanhThu.add(chonNgayDoanhThu);

		btnTimKiemDoanhThuNgay = new JButton("Tìm kiếm");
		btnTimKiemDoanhThuNgay.setIcon(new ImageIcon(GD_ThongKe.class.getResource("/images/iconTimKiem.png")));
		btnTimKiemDoanhThuNgay.setFont(new Font("Cambria", Font.BOLD, 14));
		btnTimKiemDoanhThuNgay.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiemDoanhThuNgay.setFocusable(false);
		btnTimKiemDoanhThuNgay.setBackground(new Color(144, 238, 144));
		btnTimKiemDoanhThuNgay.setBounds(511, 10, 150, 35);
		pnlTimKiemDoanhThu.add(btnTimKiemDoanhThuNgay);

		btnTimKiemDoanhThuThang = new JButton("Tìm kiếm");
		btnTimKiemDoanhThuThang.setIcon(new ImageIcon(GD_ThongKe.class.getResource("/images/iconTimKiem.png")));
		btnTimKiemDoanhThuThang.setFont(new Font("Cambria", Font.BOLD, 14));
		btnTimKiemDoanhThuThang.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiemDoanhThuThang.setFocusable(false);
		btnTimKiemDoanhThuThang.setBackground(new Color(144, 238, 144));
		btnTimKiemDoanhThuThang.setBounds(511, 10, 150, 35);

		btnTimKiemDoanhThuNam = new JButton("Tìm kiếm");
		btnTimKiemDoanhThuNam.setIcon(new ImageIcon(GD_ThongKe.class.getResource("/images/iconTimKiem.png")));
		btnTimKiemDoanhThuNam.setFont(new Font("Cambria", Font.BOLD, 14));
		btnTimKiemDoanhThuNam.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiemDoanhThuNam.setFocusable(false);
		btnTimKiemDoanhThuNam.setBackground(new Color(144, 238, 144));
		btnTimKiemDoanhThuNam.setBounds(511, 10, 150, 35);

		lblchonThangDoanhThu = new JLabel("Chọn tháng:");
		lblchonThangDoanhThu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblchonThangDoanhThu.setBounds(30, 11, 110, 30);

		String[] cols_Thang = { "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8",
				"Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12" };
		cmbmodelThangDoanhThu = new DefaultComboBoxModel<>(cols_Thang);
		cmbThangDoanhThu = new JComboBox<String>(cmbmodelThangDoanhThu);
		cmbThangDoanhThu.setSelectedIndex(LocalDate.now().getMonthValue() - 1);
		cmbThangDoanhThu.setBounds(125, 11, 100, 30);

		lblchonNamDoanhThuThang = new JLabel("Chọn năm:");
		lblchonNamDoanhThuThang.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblchonNamDoanhThuThang.setBounds(254, 11, 88, 30);

		cmbNamDoanhThuThang = new JYearChooser();
		cmbNamDoanhThuThang.setYear(LocalDate.now().getYear());
		cmbNamDoanhThuThang.setBounds(333, 11, 100, 30);

		lblchonNamDoanhThuNam = new JLabel("Chọn năm:");
		lblchonNamDoanhThuNam.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblchonNamDoanhThuNam.setBounds(30, 11, 110, 30);

		cmbNamDoanhThuNam = new JYearChooser();
		cmbNamDoanhThuNam.setYear(LocalDate.now().getYear());
		cmbNamDoanhThuNam.setBounds(125, 11, 100, 30);

		lblTongDoanhThu = new JLabel("Tổng doanh thu:");
		lblTongDoanhThu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTongDoanhThu.setBackground(SystemColor.menu);
		lblTongDoanhThu.setBounds(44, 122, 250, 25);
		pnlChiTietDoanhThu.add(lblTongDoanhThu);

		lblTongDoanhThuKetQua = new JLabel("0 VNĐ");
		lblTongDoanhThuKetQua.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTongDoanhThuKetQua.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTongDoanhThuKetQua.setBounds(429, 120, 200, 25);
		pnlChiTietDoanhThu.add(lblTongDoanhThuKetQua);

		lblTongSoHDKetQua = new JLabel("0");
		lblTongSoHDKetQua.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTongSoHDKetQua.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTongSoHDKetQua.setBounds(429, 181, 200, 25);
		pnlChiTietDoanhThu.add(lblTongSoHDKetQua);

		lblTongSoHD = new JLabel("Tổng số hóa đơn:");
		lblTongSoHD.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTongSoHD.setBackground(SystemColor.menu);
		lblTongSoHD.setBounds(44, 183, 150, 25);
		pnlChiTietDoanhThu.add(lblTongSoHD);

		lblTongTienHat = new JLabel("Tổng tiền hát:");
		lblTongTienHat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTongTienHat.setBackground(SystemColor.menu);
		lblTongTienHat.setBounds(44, 244, 250, 25);
		pnlChiTietDoanhThu.add(lblTongTienHat);

		lblTongTienHatKetQua = new JLabel("0 VNĐ");
		lblTongTienHatKetQua.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTongTienHatKetQua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTongTienHatKetQua.setBounds(429, 242, 200, 25);
		pnlChiTietDoanhThu.add(lblTongTienHatKetQua);

		lblTongTienDichVu = new JLabel("Tổng tiền dịch vụ:");
		lblTongTienDichVu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTongTienDichVu.setBackground(SystemColor.menu);
		lblTongTienDichVu.setBounds(44, 304, 250, 25);
		pnlChiTietDoanhThu.add(lblTongTienDichVu);

		lblTongTienDichVuKetQua = new JLabel("0 VNĐ");
		lblTongTienDichVuKetQua.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTongTienDichVuKetQua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTongTienDichVuKetQua.setBounds(429, 302, 200, 25);
		pnlChiTietDoanhThu.add(lblTongTienDichVuKetQua);

		lblDoanhThuTrungBinh = new JLabel("Doanh thu trung bình:");
		lblDoanhThuTrungBinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDoanhThuTrungBinh.setBackground(SystemColor.menu);
		lblDoanhThuTrungBinh.setBounds(44, 365, 250, 25);
		pnlChiTietDoanhThu.add(lblDoanhThuTrungBinh);

		lblDoanhThuTrungBinhKetQua = new JLabel("0 VNĐ");
		lblDoanhThuTrungBinhKetQua.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDoanhThuTrungBinhKetQua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDoanhThuTrungBinhKetQua.setBounds(429, 363, 200, 25);
		pnlChiTietDoanhThu.add(lblDoanhThuTrungBinhKetQua);

		lblChuThichDoanhThu = new JLabel("(Tổng doanh thu hóa đơn/Tổng số hóa đơn");
		lblChuThichDoanhThu.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		lblChuThichDoanhThu.setBounds(44, 387, 269, 18);
		pnlChiTietDoanhThu.add(lblChuThichDoanhThu);

		pnlDSDoanhThu = new JPanel();
		pnlDSDoanhThu.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pnlDSDoanhThu.setBackground(new Color(230, 230, 250));
		pnlDSDoanhThu.setBounds(672, 0, 694, 564);
		pnlThongTinDoanhThu.add(pnlDSDoanhThu);
		pnlDSDoanhThu.setLayout(null);

		String[] cols_HoaDon = { "STT", "Mã hóa đơn", "Tên khách hàng", "Tên nhân viên", "Ngày lập", "Giờ lập",
				"Tổng tiền" };
		tblmodelHoaDon = new DefaultTableModel(cols_HoaDon, 0);
		tblHoaDon = new JTable(tblmodelHoaDon);
		scrHoaDon = new JScrollPane(tblHoaDon);
		scrHoaDon.setBounds(10, 11, 674, 485);
		pnlDSDoanhThu.add(scrHoaDon);

		btnXemChiTietHoaDonDoanhThu = new JButton("Xem chi tiết hóa đơn");
		btnXemChiTietHoaDonDoanhThu.setIcon(new ImageIcon(GD_ThongKe.class.getResource("/images/iconMatMo.png")));
		btnXemChiTietHoaDonDoanhThu.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		btnXemChiTietHoaDonDoanhThu.setForeground(new Color(0, 0, 0));
		btnXemChiTietHoaDonDoanhThu.setBackground(new Color(144, 238, 144));
		btnXemChiTietHoaDonDoanhThu.setFocusable(false);
		btnXemChiTietHoaDonDoanhThu.setFont(new Font("Cambria", Font.BOLD, 14));
		btnXemChiTietHoaDonDoanhThu.setBounds(468, 507, 216, 35);
		pnlDSDoanhThu.add(btnXemChiTietHoaDonDoanhThu);

		cmbmodelThangLuong = new DefaultComboBoxModel<>(cols_Thang);

		String[] cols_NhanVien = { "STT", "Mã nhân viên", "Họ tên", "Số diện thoại", "Số giờ làm việc", "Số ca vắng",
				"Tiền lương" };
		tblmodelNhanVien = new DefaultTableModel(cols_NhanVien, 0);

		/**
		 * Table DS KhachHang
		 */

		// can chinh cac table
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblHoaDon.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblHoaDon.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tblHoaDon.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
		tblHoaDon.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
		tblHoaDon.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);

		ThongKeController controller = new ThongKeController(this);
		radTheoNgay.addActionListener(controller);
		radTheoThang.addActionListener(controller);
		radTheoNam.addActionListener(controller);
		btnTimKiemDoanhThuNgay.addActionListener(controller);
		btnTimKiemDoanhThuThang.addActionListener(controller);
		btnTimKiemDoanhThuNam.addActionListener(controller);
		btnXemChiTietHoaDonDoanhThu.addActionListener(controller);
		tblHoaDon.addMouseListener(controller);

		loadDataHoaDon();
	}

	private void loadDataHoaDon() {
		chonTimKiemDoanhThuNgay();
	}

	public void chonTheoNgay() {
		this.pnlTimKiemDoanhThu.removeAll();
		this.pnlTimKiemDoanhThu.repaint();
		this.pnlTimKiemDoanhThu.revalidate();

		this.pnlTimKiemDoanhThu.add(lblchonNgayDoanhThu);
		this.pnlTimKiemDoanhThu.add(chonNgayDoanhThu);
		this.pnlTimKiemDoanhThu.add(btnTimKiemDoanhThuNgay);
		this.pnlTimKiemDoanhThu.repaint();
		this.pnlTimKiemDoanhThu.revalidate();
		chonTimKiemDoanhThuNgay();
	}

	public void chonTheoThang() {
		this.pnlTimKiemDoanhThu.removeAll();
		this.pnlTimKiemDoanhThu.repaint();
		this.pnlTimKiemDoanhThu.revalidate();

		this.pnlTimKiemDoanhThu.add(lblchonThangDoanhThu);
		this.pnlTimKiemDoanhThu.add(cmbThangDoanhThu);
		this.pnlTimKiemDoanhThu.add(lblchonNamDoanhThuThang);
		this.pnlTimKiemDoanhThu.add(cmbNamDoanhThuThang);
		this.pnlTimKiemDoanhThu.add(btnTimKiemDoanhThuThang);
		this.pnlTimKiemDoanhThu.repaint();
		this.pnlTimKiemDoanhThu.revalidate();
		chonTimKiemDoanhThuThang();
	}

	public void chonTheoNam() {
		this.pnlTimKiemDoanhThu.removeAll();
		this.pnlTimKiemDoanhThu.repaint();
		this.pnlTimKiemDoanhThu.revalidate();

		this.pnlTimKiemDoanhThu.add(lblchonNamDoanhThuNam);
		this.pnlTimKiemDoanhThu.add(cmbNamDoanhThuNam);
		this.pnlTimKiemDoanhThu.add(btnTimKiemDoanhThuNam);
		this.pnlTimKiemDoanhThu.repaint();
		this.pnlTimKiemDoanhThu.revalidate();
		chonTimKiemDoanhThuNam();
	}

	private void hienThiThongTinDoanhThu() {
		if (tblHoaDon.getRowCount() != 0) {
			lblTongDoanhThuKetQua.setText(MoneyFormatter.format(tinhTongTienTatCaHoaDon()));
			lblTongSoHDKetQua.setText(tblHoaDon.getRowCount() + "");
			lblTongTienDichVuKetQua.setText(MoneyFormatter.format(tinhTongTienDichVu()));
			lblTongTienHatKetQua.setText(MoneyFormatter.format(tinhTongTienHatTatCaHoaDon()));
			lblDoanhThuTrungBinhKetQua
					.setText(MoneyFormatter.format(tinhTongTienTatCaHoaDon() / tblHoaDon.getRowCount()));
		} else {
			lamMoi();
		}
	}

	private void lamMoi() {
		lblTongDoanhThuKetQua.setText(MoneyFormatter.format(0));
		lblTongSoHDKetQua.setText("0");
		lblTongTienDichVuKetQua.setText(MoneyFormatter.format(0));
		lblTongTienHatKetQua.setText(MoneyFormatter.format(0));
		lblDoanhThuTrungBinhKetQua.setText(MoneyFormatter.format(0));
	}

	public void chonTimKiemDoanhThuNgay() {
		LocalDate ngay = DateFormatter.toLocalDate(chonNgayDoanhThu);
		tblHoaDon.removeAll();
		tblHoaDon.setRowSelectionAllowed(false);
		tblmodelHoaDon.setRowCount(0);
		listHoaDon = thongKeDAO.duyetDanhSachHoaDonTheoNgay(ngay);

		int stt = 1;
		for (HoaDonEntity hoaDonEntity : listHoaDon) {
			KhachHangEntity khachHangEntity = quanLyKhachHangDAO.timTheoMa(hoaDonEntity.getMaKhachHang());
			NhanVienEntity nhanVienEntity = quanLyNhanVienDAO.timTheoMa(hoaDonEntity.getMaNhanVien());
			tblmodelHoaDon.addRow(new Object[] { stt++, hoaDonEntity.getMaHoaDon(), khachHangEntity.getHoTen(),
					nhanVienEntity.getHoTen(), hoaDonEntity.getNgayLap(), hoaDonEntity.getGioLap(),
					MoneyFormatter.format1(tinhTongTienCuaHoaDon(hoaDonEntity)) });
		}
		hienThiThongTinDoanhThu();
	}

	public void chonTimKiemDoanhThuThang() {
		int thang = cmbThangDoanhThu.getSelectedIndex() + 1;
		int nam = cmbNamDoanhThuThang.getYear();
		LocalDate ngay = LocalDate.of(nam, thang, 1);

		tblHoaDon.removeAll();
		tblHoaDon.setRowSelectionAllowed(false);
		tblmodelHoaDon.setRowCount(0);
		listHoaDon = thongKeDAO.duyetDanhSachHoaDonTheoNamThang(ngay);

		int stt = 1;
		for (HoaDonEntity hoaDonEntity : listHoaDon) {
			KhachHangEntity khachHangEntity = quanLyKhachHangDAO.timTheoMa(hoaDonEntity.getMaKhachHang());
			NhanVienEntity nhanVienEntity = quanLyNhanVienDAO.timTheoMa(hoaDonEntity.getMaNhanVien());
			tblmodelHoaDon.addRow(new Object[] { stt++, hoaDonEntity.getMaHoaDon(), khachHangEntity.getHoTen(),
					nhanVienEntity.getHoTen(), hoaDonEntity.getNgayLap(), hoaDonEntity.getGioLap(),
					MoneyFormatter.format1(tinhTongTienCuaHoaDon(hoaDonEntity)) });
		}
		hienThiThongTinDoanhThu();
	}

	public void chonTimKiemDoanhThuNam() {
		int nam = cmbNamDoanhThuNam.getYear();
		LocalDate ngay = LocalDate.of(nam, 1, 1);
		tblmodelHoaDon.setRowCount(0);
		tblHoaDon.removeAll();
		tblHoaDon.setRowSelectionAllowed(false);
		listHoaDon = thongKeDAO.duyetDanhSachHoaDonTheoNam(ngay);

		int stt = 1;
		for (HoaDonEntity hoaDonEntity : listHoaDon) {
			KhachHangEntity khachHangEntity = quanLyKhachHangDAO.timTheoMa(hoaDonEntity.getMaKhachHang());
			NhanVienEntity nhanVienEntity = quanLyNhanVienDAO.timTheoMa(hoaDonEntity.getMaNhanVien());
			tblmodelHoaDon.addRow(new Object[] { stt++, hoaDonEntity.getMaHoaDon(), khachHangEntity.getHoTen(),
					nhanVienEntity.getHoTen(), hoaDonEntity.getNgayLap(), hoaDonEntity.getGioLap(),
					MoneyFormatter.format1(tinhTongTienCuaHoaDon(hoaDonEntity)) });
		}
		hienThiThongTinDoanhThu();
	}

	public void chonXemChiTietDoanhThu() {
		int row = tblHoaDon.getSelectedRow();
		if (row >= 0) {
			new GD_XemChiTietHoaDonThongKe(listHoaDon.get(row)).setVisible(true);
		}
	}

	private double tinhTongTienDichVu() {
		double tong = 0;
		for (HoaDonEntity hoaDonEntity : listHoaDon)
			tong += thongKeDAO.tinhTongTienDichVuCuaHoaDon(hoaDonEntity);
		return tong;
	}

	private double tinhTienHatMotPhong(PhongEntity phongEntity, double gioHat) {
		double tien = 0;
		if (phongEntity.getLoaiPhong().getTenLoaiPhong().equals("VIP"))
			tien = gioHat * 200000.0;
		else
			tien = gioHat * 150000.0;
		return tien;
	}

	/***** TÍNH TỔNG TIỀN HÁT *****/
	private double tinhTongTienHatHoaDon(HoaDonEntity hoaDonEntity) {
		double tienHat = 0;
		listChiTietHoaDon = quanLyHoaDonDAO.duyetDanhSachChiTietHoaDonTheoMaHoaDon(hoaDonEntity.getMaHoaDon());
		for (ChiTietHoaDonEntity chiTietHoaDonEntity : listChiTietHoaDon) {
			double gioHat = TimeFormatter.tinhSoPhut(chiTietHoaDonEntity.getChiTietDatPhong().getGioNhanPhong(),
					chiTietHoaDonEntity.getChiTietDatPhong().getGioTraPhong()) / 60.0;
			tienHat += tinhTienHatMotPhong(chiTietHoaDonEntity.getChiTietDatPhong().getPhong(), gioHat);
		}
		return tienHat;
	}

	private double tinhTongTienHatTatCaHoaDon() {
		double tong = 0;
		for (HoaDonEntity hoaDonEntity : listHoaDon)
			tong += tinhTongTienHatHoaDon(hoaDonEntity);
		return tong;
	}

	private double tinhTongTienCuaHoaDon(HoaDonEntity hoaDonEntity) {
		return thongKeDAO.tinhTongTienDichVuCuaHoaDon(hoaDonEntity) + tinhTongTienHatHoaDon(hoaDonEntity);
	}

	private double tinhTongTienTatCaHoaDon() {
		double tong = 0;
		for (HoaDonEntity hoaDonEntity : listHoaDon)
			tong += tinhTongTienCuaHoaDon(hoaDonEntity);
		return tong;
	}

}
