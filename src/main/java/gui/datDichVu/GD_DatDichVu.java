package gui.datDichVu;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.DatDichVuController;
import dao.QuanLyDichVuDAO;
import dao.QuanLyHoaDonDAO;
import dao.QuanLyKhachHangDAO;
import dao.QuanLyPhieuDatPhongDAO;
import entities.ChiTietDatPhongEntity;
import entities.ChiTietDichVuEntity;
import entities.ChiTietHoaDonEntity;
import entities.ChiTietPhieuDatPhongEntity;
import entities.DichVuEntity;
import entities.KhachHangEntity;
import entities.LoaiDichVu;
import entities.PhieuDatPhongEntity;
import util.MoneyFormatter;

public class GD_DatDichVu extends JPanel {

	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */

	private JPanel pnlChiTietDatDichVu;
	private JPanel pnlThongTinDichVu;
	private JPanel pnlTimKiem;
	private JPanel pnlDanhSachDichVu;

	private JTextField txtTimKiemTheoTenDichVu;
	private JTextField txtGiaDichVuToiThieu;
	private JTextField txtGiaDichVuToiDa;
	private JTextField txtTenDichVu;
	private JTextField txtGiaDichVu;
	private JTextField txtNhapSoLuong;
	private JTextField txtSoDienThoaiKhachHang;
	private JTextField txtThanhTien;

	private JLabel lblTimTheoLoaiDichVu;
	private JLabel lblThanhTien;
	private JLabel lblSoDienThoaiKhachHang;
	private JLabel lblChiTietDatDichVu;
	private JLabel lblNhapSoLuong;
	private JLabel lblGiaTien;
	private JLabel lblLoaiDichVu;
	private JLabel lblTenDichVu;
	private JLabel lblGiaDichVuDen;
	private JLabel lblTimKiemTheoGiaDichVu;
	private JLabel lblTimTheoTenDichVu;
	private JLabel lblChonPhong;

	private JScrollPane scrChiTietDatDichVu;
	private JScrollPane scrDichVu;

	private JTable tblDichVu;
	private JTable tblDichVuDaChon;
	private DefaultTableModel tblmodelDichVu;
	private DefaultTableModel tblmodelDichVuDaChon;

	public JComboBox<String> cmbChonPhong;
	private JComboBox<String> cmbTimLoaiDichVu;
	private JComboBox<String> cmbLoaiDichVu;
	private DefaultComboBoxModel<String> cmbmodelChonPhong;
	private DefaultComboBoxModel<String> cmbmodelTimLoaiDichVu;
	private DefaultComboBoxModel<String> cmbmodelLoaiDichVu;

	public JButton btnTimKiem;
	public JButton btnDat;
	public JButton btnXoaDaChon;
	public JButton btnChinhSua;
	public JButton btnXoaTatCa;
	public JButton btnThem;
	public JButton btnLamMoi;

	private List<DichVuEntity> listDichVu;
	private List<LoaiDichVu> listLoaiDichVu;
	private List<ChiTietDichVuEntity> listChiTietDichVu;
	private List<ChiTietPhieuDatPhongEntity> listChiTietPhieuDatPhong;

	private QuanLyDichVuDAO quanLyDichVuDAO = new QuanLyDichVuDAO();
	private QuanLyPhieuDatPhongDAO quanLyPhieuDatPhongDAO = new QuanLyPhieuDatPhongDAO();
	private QuanLyHoaDonDAO quanLyHoaDonDAO = new QuanLyHoaDonDAO();
	private QuanLyKhachHangDAO quanLyKhachHangDAO = new QuanLyKhachHangDAO();

	private ChiTietPhieuDatPhongEntity chiTietPhieuDatPhongEntity = null;
	private ChiTietDatPhongEntity chiTietDatPhongEntity = null;
	private PhieuDatPhongEntity phieuDatPhongEntity = null;
	private KhachHangEntity khachHangEntity = null;
	private ChiTietHoaDonEntity chiTietHoaDonEntity = null;

	public GD_DatDichVu() {
		setLayout(null);
		setBounds(0, 0, 1365, 694);

		JPanel panel_DatDichVu = new JPanel();
		panel_DatDichVu.setBounds(0, 0, 1365, 694);
		add(panel_DatDichVu);
		panel_DatDichVu.setLayout(null);

		JPanel panel_DichVu = new JPanel();
		panel_DichVu.setBorder(new BevelBorder(BevelBorder.LOWERED));
		panel_DichVu.setBackground(Color.WHITE);
		panel_DichVu.setBounds(0, 0, 672, 694);
		panel_DatDichVu.add(panel_DichVu);
		panel_DichVu.setLayout(null);

		pnlTimKiem = new JPanel();
		pnlTimKiem.setBorder(null);
		pnlTimKiem.setBackground(new Color(230, 230, 250));
		pnlTimKiem.setBounds(0, 0, 672, 195);
		panel_DichVu.add(pnlTimKiem);
		pnlTimKiem.setLayout(null);

		lblTimTheoTenDichVu = new JLabel("Tên dịch vụ:");
		lblTimTheoTenDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTimTheoTenDichVu.setBounds(345, 30, 87, 25);
		pnlTimKiem.add(lblTimTheoTenDichVu);

		lblTimKiemTheoGiaDichVu = new JLabel("Giá dịch vụ:");
		lblTimKiemTheoGiaDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTimKiemTheoGiaDichVu.setBounds(30, 30, 90, 25);
		pnlTimKiem.add(lblTimKiemTheoGiaDichVu);

		txtTimKiemTheoTenDichVu = new JTextField();
		txtTimKiemTheoTenDichVu.setBounds(442, 30, 200, 30);
		pnlTimKiem.add(txtTimKiemTheoTenDichVu);
		txtTimKiemTheoTenDichVu.setColumns(10);

		txtGiaDichVuToiThieu = new JTextField();
		txtGiaDichVuToiThieu.setBounds(130, 30, 200, 30);
		pnlTimKiem.add(txtGiaDichVuToiThieu);
		txtGiaDichVuToiThieu.setColumns(10);

		lblGiaDichVuDen = new JLabel("Đến:");
		lblGiaDichVuDen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGiaDichVuDen.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblGiaDichVuDen.setBounds(30, 80, 76, 25);
		pnlTimKiem.add(lblGiaDichVuDen);

		txtGiaDichVuToiDa = new JTextField();
		txtGiaDichVuToiDa.setBounds(130, 80, 200, 30);
		pnlTimKiem.add(txtGiaDichVuToiDa);
		txtGiaDichVuToiDa.setColumns(10);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/images/iconTimKiem.png")));
		btnTimKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiem.setBackground(new Color(144, 238, 144));
		btnTimKiem.setFocusable(false);
		btnTimKiem.setFont(new Font("Cambria", Font.BOLD, 14));
		btnTimKiem.setBounds(492, 130, 150, 35);
		pnlTimKiem.add(btnTimKiem);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/images/iconLamMoi.png")));
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setFocusable(false);
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setFont(new Font("Cambria", Font.BOLD, 14));
		btnLamMoi.setBounds(309, 131, 150, 35);
		pnlTimKiem.add(btnLamMoi);

		lblTimTheoLoaiDichVu = new JLabel("Loại dịch vụ:");
		lblTimTheoLoaiDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTimTheoLoaiDichVu.setBounds(345, 80, 93, 25);
		pnlTimKiem.add(lblTimTheoLoaiDichVu);

		cmbmodelTimLoaiDichVu = new DefaultComboBoxModel<String>();
		cmbTimLoaiDichVu = new JComboBox<String>(cmbmodelTimLoaiDichVu);
		cmbTimLoaiDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbTimLoaiDichVu.setBounds(442, 80, 200, 30);
		pnlTimKiem.add(cmbTimLoaiDichVu);

		pnlDanhSachDichVu = new JPanel();
		pnlDanhSachDichVu.setBorder(null);
		pnlDanhSachDichVu.setBackground(new Color(230, 230, 250));
		pnlDanhSachDichVu.setBounds(0, 195, 672, 318);
		panel_DichVu.add(pnlDanhSachDichVu);
		pnlDanhSachDichVu.setLayout(null);

		String[] cols_DichVu = { "STT", "Mã dịch vụ", "Tên dịch vụ", "Loại dịch vụ", "Giá" };
		tblmodelDichVu = new DefaultTableModel(cols_DichVu, 0);
		tblDichVu = new JTable(tblmodelDichVu);
		scrDichVu = new JScrollPane(tblDichVu);
		scrDichVu.setBounds(10, 10, 652, 292);
		pnlDanhSachDichVu.add(scrDichVu);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblDichVu.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblDichVu.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tblDichVu.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);

		pnlThongTinDichVu = new JPanel();
		pnlThongTinDichVu.setBorder(null);
		pnlThongTinDichVu.setBackground(new Color(230, 230, 250));
		pnlThongTinDichVu.setBounds(0, 513, 672, 181);
		panel_DichVu.add(pnlThongTinDichVu);
		pnlThongTinDichVu.setLayout(null);

		lblTenDichVu = new JLabel("Tên dịch vụ:");
		lblTenDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTenDichVu.setBounds(30, 30, 86, 30);
		pnlThongTinDichVu.add(lblTenDichVu);

		txtTenDichVu = new JTextField();
		txtTenDichVu.setBackground(new Color(255, 255, 255));
		txtTenDichVu.setBorder(null);
		txtTenDichVu.setEditable(false);
		txtTenDichVu.setBounds(116, 30, 200, 30);
		pnlThongTinDichVu.add(txtTenDichVu);
		txtTenDichVu.setColumns(10);

		lblLoaiDichVu = new JLabel("Loại dịch vụ:");
		lblLoaiDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLoaiDichVu.setBounds(357, 30, 86, 30);
		pnlThongTinDichVu.add(lblLoaiDichVu);

		lblGiaTien = new JLabel("Giá dịch vụ:");
		lblGiaTien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblGiaTien.setBounds(30, 80, 80, 30);
		pnlThongTinDichVu.add(lblGiaTien);

		txtGiaDichVu = new JTextField();
		txtGiaDichVu.setBackground(new Color(255, 255, 255));
		txtGiaDichVu.setBorder(null);
		txtGiaDichVu.setEditable(false);
		txtGiaDichVu.setBounds(116, 80, 200, 30);
		pnlThongTinDichVu.add(txtGiaDichVu);
		txtGiaDichVu.setColumns(10);

		lblNhapSoLuong = new JLabel("Nhập số lượng:");
		lblNhapSoLuong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNhapSoLuong.setBounds(357, 80, 110, 30);
		pnlThongTinDichVu.add(lblNhapSoLuong);

		txtNhapSoLuong = new JTextField();
		txtNhapSoLuong.setBounds(466, 80, 175, 30);
		pnlThongTinDichVu.add(txtNhapSoLuong);
		txtNhapSoLuong.setColumns(10);

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/images/iconThem.png")));
		btnThem.setFocusable(false);
		btnThem.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThem.setBackground(new Color(255, 128, 128));
		btnThem.setFont(new Font("Cambria", Font.BOLD, 14));
		btnThem.setBounds(491, 130, 150, 35);
		pnlThongTinDichVu.add(btnThem);

		cmbmodelLoaiDichVu = new DefaultComboBoxModel<>();
		cmbLoaiDichVu = new JComboBox<String>(cmbmodelLoaiDichVu);
		cmbLoaiDichVu.setBounds(442, 30, 200, 30);
		pnlThongTinDichVu.add(cmbLoaiDichVu);

		pnlChiTietDatDichVu = new JPanel();
		pnlChiTietDatDichVu.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pnlChiTietDatDichVu.setBackground(new Color(230, 230, 250));
		pnlChiTietDatDichVu.setBounds(672, 0, 694, 694);
		panel_DatDichVu.add(pnlChiTietDatDichVu);
		pnlChiTietDatDichVu.setLayout(null);

		lblChiTietDatDichVu = new JLabel("Chi Tiết Đặt Dịch Vụ");
		lblChiTietDatDichVu.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietDatDichVu.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblChiTietDatDichVu.setBounds(0, 40, 694, 50);
		pnlChiTietDatDichVu.add(lblChiTietDatDichVu);

		lblSoDienThoaiKhachHang = new JLabel("Số điện thoại:");
		lblSoDienThoaiKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSoDienThoaiKhachHang.setBounds(344, 101, 120, 30);
		pnlChiTietDatDichVu.add(lblSoDienThoaiKhachHang);

		txtSoDienThoaiKhachHang = new JTextField();
		txtSoDienThoaiKhachHang.setDisabledTextColor(Color.BLACK);
		txtSoDienThoaiKhachHang.setEnabled(false);
		txtSoDienThoaiKhachHang.setBorder(null);
		txtSoDienThoaiKhachHang.setBounds(464, 101, 200, 30);
		pnlChiTietDatDichVu.add(txtSoDienThoaiKhachHang);
		txtSoDienThoaiKhachHang.setColumns(10);

		lblThanhTien = new JLabel("Thành tiền:");
		lblThanhTien.setHorizontalAlignment(SwingConstants.LEFT);
		lblThanhTien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblThanhTien.setBounds(30, 155, 105, 30);
		pnlChiTietDatDichVu.add(lblThanhTien);

		txtThanhTien = new JTextField();
		txtThanhTien.setDisabledTextColor(Color.BLACK);
		txtThanhTien.setEnabled(false);
		txtThanhTien.setBorder(null);
		txtThanhTien.setBounds(134, 155, 200, 30);
		pnlChiTietDatDichVu.add(txtThanhTien);
		txtThanhTien.setColumns(10);

		String[] cols_ChiTietDat = { "STT", "Mã dịch vụ", "Tên dịch vụ", "Loại dịch vụ", "Số lượng", "Thành tiền" };
		tblmodelDichVuDaChon = new DefaultTableModel(cols_ChiTietDat, 0);
		tblDichVuDaChon = new JTable(tblmodelDichVuDaChon);
		scrChiTietDatDichVu = new JScrollPane(tblDichVuDaChon);
		scrChiTietDatDichVu.setBounds(10, 210, 674, 373);
		pnlChiTietDatDichVu.add(scrChiTietDatDichVu);

		tblDichVuDaChon.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblDichVuDaChon.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

		tblDichVuDaChon.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);

		btnXoaTatCa = new JButton("Xóa toàn bộ");
		btnXoaTatCa.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/images/iconHuy.png")));
		btnXoaTatCa.setFocusable(false);
		btnXoaTatCa.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXoaTatCa.setBackground(new Color(144, 238, 144));
		btnXoaTatCa.setFont(new Font("Cambria", Font.BOLD, 14));
		btnXoaTatCa.setBounds(354, 621, 150, 35);
		pnlChiTietDatDichVu.add(btnXoaTatCa);

		btnChinhSua = new JButton("Chỉnh sửa");
		btnChinhSua.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/images/iconChinhSua1.png")));
		btnChinhSua.setFocusable(false);
		btnChinhSua.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnChinhSua.setBackground(new Color(144, 238, 144));
		btnChinhSua.setFont(new Font("Cambria", Font.BOLD, 14));
		btnChinhSua.setBounds(18, 621, 150, 35);
		pnlChiTietDatDichVu.add(btnChinhSua);

		btnXoaDaChon = new JButton("Xóa đã chọn");
		btnXoaDaChon.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/images/iconXoa1.png")));
		btnXoaDaChon.setFocusable(false);
		btnXoaDaChon.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXoaDaChon.setBackground(new Color(144, 238, 144));
		btnXoaDaChon.setFont(new Font("Cambria", Font.BOLD, 14));
		btnXoaDaChon.setBounds(186, 621, 150, 35);
		pnlChiTietDatDichVu.add(btnXoaDaChon);

		btnDat = new JButton("Đặt dịch vụ");
		btnDat.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/images/iconChon.png")));
		btnDat.setFocusable(false);
		btnDat.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDat.setBackground(new Color(144, 238, 144));
		btnDat.setFont(new Font("Cambria", Font.BOLD, 14));
		btnDat.setBounds(522, 621, 150, 35);
		pnlChiTietDatDichVu.add(btnDat);

		lblChonPhong = new JLabel("Chọn phòng:");
		lblChonPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblChonPhong.setBounds(30, 101, 93, 30);
		pnlChiTietDatDichVu.add(lblChonPhong);

		cmbmodelChonPhong = new DefaultComboBoxModel<>();
		cmbChonPhong = new JComboBox<String>(cmbmodelChonPhong);
		cmbChonPhong.setBounds(134, 101, 200, 30);
		pnlChiTietDatDichVu.add(cmbChonPhong);

		DatDichVuController controller = new DatDichVuController(this);
		btnTimKiem.addActionListener(controller);
		btnThem.addActionListener(controller);
		btnXoaTatCa.addActionListener(controller);
		btnXoaDaChon.addActionListener(controller);
		btnChinhSua.addActionListener(controller);
		btnDat.addActionListener(controller);
		btnLamMoi.addActionListener(controller);
		tblDichVuDaChon.addMouseListener(controller);
		tblDichVu.addMouseListener(controller);
		cmbChonPhong.addItemListener(controller);

		loadData();
		loadDataPhong();
		loadDataCmbDichVu();
		loadDataCmbDichVuTim();
	}

	/*********************************
	 * LOAD DATA
	 *********************************/
	private void loadData() {
		tblDichVu.removeAll();
		tblmodelDichVu.setRowCount(0);
		listDichVu = quanLyDichVuDAO.duyetDanhSach();

		int stt = 1;
		for (DichVuEntity dichVuEntity : listDichVu) {
			tblmodelDichVu.addRow(new Object[] { stt++, dichVuEntity.getMaDichVu(), dichVuEntity.getTenDichVu(),
					dichVuEntity.getLoaiDichVu().getTenLoaiDichVu(), MoneyFormatter.format(dichVuEntity.getGia()) });
		}
	}

	private void loadDataPhong() {
		cmbmodelChonPhong.removeAllElements();
		listChiTietPhieuDatPhong = quanLyPhieuDatPhongDAO.duyetChiTietPhieuDatPhongChuaThanhToan();

		cmbmodelChonPhong.addElement("");
		for (ChiTietPhieuDatPhongEntity chiTietPhieuDatPhongEntity : listChiTietPhieuDatPhong) {
			chiTietDatPhongEntity = quanLyHoaDonDAO
					.timChiTietDatPhongTheoMa(chiTietPhieuDatPhongEntity.getMaChiTietDatPhong());
			phieuDatPhongEntity = quanLyPhieuDatPhongDAO
					.timPhieuDatPhongTheoMa(chiTietPhieuDatPhongEntity.getMaPhieuDatPhong());
			khachHangEntity = quanLyKhachHangDAO.timTheoMa(phieuDatPhongEntity.getMaKhachHang());
			cmbmodelChonPhong
					.addElement(chiTietDatPhongEntity.getPhong().getSoPhong() + " - " + khachHangEntity.getHoTen());
		}
	}

	private void loadDataCmbDichVuTim() {
		cmbmodelTimLoaiDichVu.removeAllElements();
		listLoaiDichVu = quanLyDichVuDAO.duyetDanhSachLoaiDichVu();

		cmbmodelTimLoaiDichVu.addElement("Tất cả");
		for (LoaiDichVu loaiDichVu : listLoaiDichVu) {
			cmbmodelTimLoaiDichVu.addElement(loaiDichVu.getTenLoaiDichVu());
		}
	}

	private void loadDataCmbDichVu() {
		cmbmodelLoaiDichVu.removeAllElements();
		listLoaiDichVu = quanLyDichVuDAO.duyetDanhSachLoaiDichVu();

		cmbmodelLoaiDichVu.addElement("");
		for (LoaiDichVu loaiDichVu : listLoaiDichVu) {
			cmbmodelLoaiDichVu.addElement(loaiDichVu.getTenLoaiDichVu());
		}
	}

	/*********************************
	 * HIỂN THỊ THÔNG TIN
	 *********************************/
	public void hienThiThongTin() {
		listDichVu = quanLyDichVuDAO.duyetDanhSach();
		int row = tblDichVu.getSelectedRow();
		if (row >= 0) {
			txtTenDichVu.setText(listDichVu.get(row).getTenDichVu());
			txtGiaDichVu.setText(String.valueOf(listDichVu.get(row).getGia()));
			cmbLoaiDichVu.setSelectedItem(listDichVu.get(row).getLoaiDichVu().getTenLoaiDichVu());
		}
	}

	/*********************************
	 * LÀM MỚI
	 *********************************/
	public void chonLamMoi() {
		txtGiaDichVuToiDa.setText("");
		txtGiaDichVu.setText("");
		txtGiaDichVuToiThieu.setText("");
		txtNhapSoLuong.setText("");
		txtTenDichVu.setText("");
		txtTimKiemTheoTenDichVu.setText("");
		cmbTimLoaiDichVu.setSelectedIndex(0);
		cmbLoaiDichVu.setSelectedIndex(0);
		loadData();
	}

	/*********************************
	 * TÌM KIẾM
	 *********************************/
	public void chonTimKiem() {
		if (kiemTraDuLieuTim()) {
			String tenDV = txtTimKiemTheoTenDichVu.getText().trim();
			String loaiDV = cmbmodelTimLoaiDichVu.getSelectedItem().toString().trim();
			Double giaTu = null;
			Double giaDen = null;
			if (!txtGiaDichVuToiThieu.getText().trim().equals("")) {
				giaTu = Double.valueOf(txtGiaDichVuToiThieu.getText().trim());
			}
			if (!txtGiaDichVuToiDa.getText().trim().equals("")) {
				giaDen = Double.valueOf(txtGiaDichVuToiDa.getText().trim());
			}

			tblDichVuDaChon.removeAll();
			tblDichVuDaChon.setRowSelectionAllowed(false);
			tblmodelDichVu.setRowCount(0);
			listDichVu = quanLyDichVuDAO.timKiemDichVu(tenDV, loaiDV, giaTu, giaDen);
			int stt = 1;
			for (DichVuEntity dichVuEntity : listDichVu) {
				tblmodelDichVu.addRow(new Object[] { stt++, dichVuEntity.getMaDichVu(), dichVuEntity.getTenDichVu(),
						dichVuEntity.getLoaiDichVu().getTenLoaiDichVu(),
						MoneyFormatter.format(dichVuEntity.getGia()) });
			}

		}
	}

	/*********************************
	 * CHỌN PHIẾU ĐẶT
	 *********************************/
	public void chonPhong() {
		int row = cmbChonPhong.getSelectedIndex();
		if (row > 0) {
			listChiTietPhieuDatPhong = quanLyPhieuDatPhongDAO.duyetChiTietPhieuDatPhongChuaThanhToan();
			chiTietPhieuDatPhongEntity = listChiTietPhieuDatPhong.get(row - 1);
			chiTietDatPhongEntity = quanLyHoaDonDAO
					.timChiTietDatPhongTheoMa(chiTietPhieuDatPhongEntity.getMaChiTietDatPhong());
			phieuDatPhongEntity = quanLyPhieuDatPhongDAO
					.timPhieuDatPhongTheoMa(chiTietPhieuDatPhongEntity.getMaPhieuDatPhong());
			chiTietHoaDonEntity = quanLyHoaDonDAO.timChiTietHoaDonTheoChiTietDatPhong(chiTietDatPhongEntity);
			khachHangEntity = quanLyKhachHangDAO.timTheoMa(phieuDatPhongEntity.getMaKhachHang());
			txtSoDienThoaiKhachHang.setText(khachHangEntity.getSoDienThoai());

			tblDichVuDaChon.removeAll();
			tblDichVuDaChon.setRowSelectionAllowed(false);
			tblmodelDichVuDaChon.setRowCount(0);
			listChiTietDichVu = new ArrayList<>();
			listChiTietDichVu = quanLyHoaDonDAO
					.duyetDanhSachChiTietDichVuTheoChiTietHoaDon(chiTietHoaDonEntity.getMaChiTietHoaDon());
			int stt = 1;
			for (ChiTietDichVuEntity chiTietDichVuEntity : listChiTietDichVu) {
				tblmodelDichVuDaChon.addRow(new Object[] { stt++, chiTietDichVuEntity.getDichVu().getMaDichVu(),
						chiTietDichVuEntity.getDichVu().getTenDichVu(),
						chiTietDichVuEntity.getDichVu().getLoaiDichVu().getTenLoaiDichVu(),
						chiTietDichVuEntity.getSoLuong(), MoneyFormatter.format(
								tinhThanhTien(chiTietDichVuEntity.getSoLuong(), chiTietDichVuEntity.getDichVu())) });
			}
			tinhTongThanhTien();
		}
	}

	/*********************************
	 * THÊM
	 *********************************/
	public void chonThem() {
		if (kiemTraDuLieuThem()) {
			int row = tblDichVu.getSelectedRow();
			listDichVu = quanLyDichVuDAO.duyetDanhSach();
			if (row >= 0) {
				DichVuEntity dichVuEntity = listDichVu.get(row);
				String maDichVu = dichVuEntity.getMaDichVu();
				String tenDV = dichVuEntity.getTenDichVu();
				String loaiDV = dichVuEntity.getLoaiDichVu().getTenLoaiDichVu();
				int soLuong = Integer.parseInt(txtNhapSoLuong.getText().trim());
				double thanhTien = tinhThanhTien(soLuong, dichVuEntity);

				int stt = tblDichVuDaChon.getRowCount();
				tblmodelDichVuDaChon.addRow(
						new Object[] { ++stt, maDichVu, tenDV, loaiDV, soLuong, MoneyFormatter.format(thanhTien) });

				txtTenDichVu.setText("");
				txtGiaDichVu.setText("");
				cmbLoaiDichVu.setSelectedIndex(0);
				txtNhapSoLuong.setText("");
				tinhTongThanhTien();
				loadData();
			}
		}
	}

	private double tinhThanhTien(int soLuong, DichVuEntity dichVuEntity) {
		return soLuong * dichVuEntity.getGia();
	}

	// duyet danh sach dich vu dat va tinh tong thanh tien
	private void tinhTongThanhTien() {
		double tongThanhTien = 0;
		int row = tblDichVuDaChon.getRowCount();
		if (row > 0) {
			for (int i = 0; i < tblDichVuDaChon.getRowCount(); i++) {
				String maDichVu = tblDichVuDaChon.getValueAt(i, 1).toString();
				DichVuEntity dichVuEntity = quanLyDichVuDAO.timTheoMa(maDichVu);
				int soLuong = Integer.parseInt(tblDichVuDaChon.getValueAt(i, 4).toString().trim());
				tongThanhTien += tinhThanhTien(soLuong, dichVuEntity);
			}
		}
		txtThanhTien.setText(MoneyFormatter.format(tongThanhTien));
	}

	/*********************************
	 * XÓA ĐÃ CHỌN
	 *********************************/
	public void chonXoaDaChon() {
		int row = tblDichVuDaChon.getSelectedRow();
		if (row >= 0) {
			if (JOptionPane.showConfirmDialog(this, "Xác nhận xóa ?", "Thông báo",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				listChiTietDichVu = quanLyHoaDonDAO
						.duyetDanhSachChiTietDichVuTheoChiTietHoaDon(chiTietHoaDonEntity.getMaChiTietHoaDon());
				for (int i = row + 1; i < tblDichVuDaChon.getRowCount(); i++)
					tblDichVuDaChon.setValueAt(i, i, 0);

				if (row < listChiTietDichVu.size())
					quanLyHoaDonDAO
							.xoaChiTietDichvuTheoMaChiTietDichVu(listChiTietDichVu.get(row).getMaChiTietDatDichVu());

				tblmodelDichVuDaChon.removeRow(row);
				tinhTongThanhTien();
				loadData();
			}
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một dịch vụ để xóa");
			return;
		}
	}

	/*********************************
	 * XÓA TẤT CẢ
	 *********************************/
	public void chonXoaTatCa() {
		if (JOptionPane.showConfirmDialog(this, "Xác nhận xóa tất cả?", "Thông báo",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			tblDichVuDaChon.removeAll();
			tblDichVuDaChon.setRowSelectionAllowed(false);
			tblmodelDichVuDaChon.setRowCount(0);
			tinhTongThanhTien();
		}
	}

	/*********************************
	 * CHỈNH SỬA SỐ LƯỢNG
	 *********************************/
	public void chonChinhSua() {
		int row = tblDichVuDaChon.getSelectedRow();
		if (row >= 0) {
			int soLuongCu = Integer.parseInt(tblDichVuDaChon.getValueAt(row, 4).toString().trim());
			String tenDichVuDangChon = tblDichVuDaChon.getValueAt(row, 2).toString();
			String soLuongMoi = JOptionPane.showInputDialog(this, "Nhập số lượng:", tenDichVuDangChon,
					JOptionPane.INFORMATION_MESSAGE);
			try {
				int soLuong = Integer.parseInt(soLuongMoi);
				if (soLuong <= 0) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập lớn hơn 0");
					return;
				} else if (soLuong == soLuongCu) {
					JOptionPane.showMessageDialog(this, "Số lượng nhập phải khác ban đầu");
					return;
				} else {
					listChiTietDichVu = quanLyHoaDonDAO
							.duyetDanhSachChiTietDichVuTheoChiTietHoaDon(chiTietHoaDonEntity.getMaChiTietHoaDon());
					DichVuEntity dichVuEntity = null;
					if (row < listChiTietDichVu.size()) {
						String maChiTietDichVu = listChiTietDichVu.get(row).getMaChiTietDatDichVu();
						quanLyHoaDonDAO.chinhSuaChiTietDichVuTheoMa(maChiTietDichVu, soLuong);
						dichVuEntity = listChiTietDichVu.get(row).getDichVu();
					} else {
						String maDichVu = tblDichVuDaChon.getValueAt(row, 1).toString();
						dichVuEntity = quanLyDichVuDAO.timTheoMa(maDichVu);
					}
					double thanhTien = tinhThanhTien(soLuong, dichVuEntity);
					tblDichVuDaChon.setValueAt(soLuongMoi, row, 4);
					tblDichVuDaChon.setValueAt(MoneyFormatter.format(thanhTien), row, 5);
					tinhTongThanhTien();
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập số");
				return;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn dịch vụ để chỉnh sửa số lượng");
			return;
		}
	}

	/*********************************
	 * ĐẶT DỊCH VỤ
	 *********************************/
	public void chonDat() {
		if (kiemTraDuLieuDat()) {
			chiTietDatPhongEntity = quanLyHoaDonDAO
					.timChiTietDatPhongTheoMa(chiTietPhieuDatPhongEntity.getMaChiTietDatPhong());
			chiTietHoaDonEntity = quanLyHoaDonDAO.timChiTietHoaDonTheoChiTietDatPhong(chiTietDatPhongEntity);
			listChiTietDichVu = quanLyHoaDonDAO
					.duyetDanhSachChiTietDichVuTheoChiTietHoaDon(chiTietHoaDonEntity.getMaChiTietHoaDon());

			for (int i = listChiTietDichVu.size(); i < tblDichVuDaChon.getRowCount(); i++) {
				String maDichVu = tblDichVuDaChon.getValueAt(i, 1).toString();
				DichVuEntity dichVuEntity = quanLyDichVuDAO.timTheoMa(maDichVu);
				int soLuong = Integer.parseInt(tblDichVuDaChon.getValueAt(i, 4).toString().trim());
				ChiTietDichVuEntity chiTietDichVuEntity = new ChiTietDichVuEntity(dichVuEntity, soLuong);
				if (!quanLyHoaDonDAO.themChiTietDichVu(chiTietDichVuEntity, chiTietHoaDonEntity)) {
					JOptionPane.showMessageDialog(this, "Lỗi");
					return;
				}
			}
			JOptionPane.showMessageDialog(this, "Đặt thành công");
			loadSauKhiDat();
		}
	}

	private void loadSauKhiDat() {
		cmbChonPhong.setSelectedIndex(0);
		txtSoDienThoaiKhachHang.setText("");
		txtThanhTien.setText("");
		tblDichVuDaChon.removeAll();
		tblDichVuDaChon.setRowSelectionAllowed(false);
		tblmodelDichVuDaChon.setRowCount(0);
		chonLamMoi();
	}

	private boolean kiemTraDuLieuTim() {
		if (txtGiaDichVuToiThieu.getText().trim().length() > 0) {
			try {
				double giaToiThieu = Double.parseDouble(txtGiaDichVuToiThieu.getText().trim());
				if (giaToiThieu < 0) {
					JOptionPane.showMessageDialog(this, "Giá tổi thiểu nhập vào phải là số dương");
					txtGiaDichVuToiThieu.requestFocus();
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Giá tối thiểu nhập vào phải là số");
				txtGiaDichVuToiThieu.requestFocus();
				return false;
			}
			if (txtGiaDichVuToiDa.getText().trim().length() > 0) {
				try {
					double giaToiDa = Double.parseDouble(txtGiaDichVuToiDa.getText().trim());
					if (giaToiDa < Double.parseDouble(txtGiaDichVuToiThieu.getText().trim())) {
						JOptionPane.showMessageDialog(this, "Giá tổi đa phải lớn hơn hoặc bằng giá tối thiểu");
						txtGiaDichVuToiDa.requestFocus();
						return false;
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(this, "Giá tối đa nhập vào phải là số");
					txtGiaDichVuToiDa.requestFocus();
					return false;
				}
			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập giá tối đa");
				txtGiaDichVuToiDa.requestFocus();
				return false;
			}
		}

		return true;
	}

	private boolean kiemTraDuLieuThem() {
		listDichVu = quanLyDichVuDAO.duyetDanhSach();
		int row = tblDichVu.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn dịch vụ");
			return false;
		} else {
			for (int i = 0; i < tblDichVuDaChon.getRowCount(); i++) {
				String maDichVu = listDichVu.get(row).getMaDichVu();
				if (maDichVu.equals(tblDichVuDaChon.getValueAt(i, 1).toString())) {
					JOptionPane.showMessageDialog(this, "Dịch vụ này đã được chọn. Hãy chọn dịch vụ khác");
					return false;
				}
			}

			if (txtNhapSoLuong.getText().trim().length() > 0) {
				try {
					int soLuong = Integer.parseInt(txtNhapSoLuong.getText().trim());
					if (soLuong <= 0) {
						JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0");
						txtNhapSoLuong.requestFocus();
						return false;
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(this, "Số lượng nhập vào phải là số");
					txtNhapSoLuong.requestFocus();
					return false;
				}
			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng dịch vụ");
				txtNhapSoLuong.requestFocus();
				return false;
			}
		}
		return true;
	}

	private boolean kiemTraDuLieuDat() {
		if (chiTietPhieuDatPhongEntity == null) {
			JOptionPane.showMessageDialog(this, "Hãy chọn phòng");
			return false;
		}

		if (tblDichVuDaChon.getRowCount() <= 0) {
			JOptionPane.showMessageDialog(this, "Hãy chọn dịch vụ");
			return false;
		}
		return true;
	}
}
