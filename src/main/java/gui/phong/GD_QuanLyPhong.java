package gui.phong;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
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
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.QuanLyPhongController;
import dao.QuanLyPhongDAO;
import entities.LoaiPhong;
import entities.NhanVienEntity;
import entities.PhongEntity;

import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;

public class GD_QuanLyPhong extends JPanel {

	private static final long serialVersionUID = 1L;
	// JPanel
	private JPanel pnlQuanLiPhong;
	private JPanel pnlThongTinPhong;
	private JPanel pnlDsPhong;
	private JPanel pnlTimKiem;
	private JPanel pnlTK;

	private JLabel lblPhongHat;
	private JLabel lblMaPhong;
	private JLabel lblSoPhong;
	private JLabel lblSucChua;
	private JLabel lblTrangThai;
	private JLabel lblLoaiPhong;
	private JLabel lblTimKiemBangSoPhong;
	private JLabel lblTimKiemBangTrangThai;
	private JLabel lblTimKiemBangSucChua;
	private JLabel lblTimKiemBangLoaiPhong;
	private JLabel lblDanhSachPhong;
	// JTextField
	private JTextField txtMaPhong;
	private JTextField txtSoPhong;
	private JTextField txtSucChua;
	private JTextField txtTimKiemBangSoPhong;
	private JTextField txtTimKiemBangSucChua;
	private JTextField txtTimBangTrangThai;
	private JTextField txtTenLoaiPhong;
	// JTable
	private JTable tblPhong;
	private DefaultTableModel tblmodelPhong;
	// JScrollPane
	private JScrollPane scrDanhSachPhong;
	// JComboBox
	private JComboBox<String> cmbLoaiPhong;
	private JComboBox<String> cmbTrangThai;
	public JComboBox<String> cmbLoaiPhongTimKiem;
	public JComboBox<String> cmbMaLoaiPhong;
	private DefaultComboBoxModel<String> cmbmodelLoaiPhong;
	private DefaultComboBoxModel<String> cmbmodelTrangThai;
	public DefaultComboBoxModel<String> cmbmodelMaLoaiPhong;
	public DefaultComboBoxModel<String> cmbmodelLoaiPhongTimKiem;

	// JButton
	public JButton btnLamMoi;
	public JButton btnTimKiem;
	public JButton btnThemLoaiPhong;
	public JButton btnXemLoaiPhong;
	public JButton btnThem;
	public JButton btnXoaPhong;
	public JButton btnChinhSuaPhong;

	private List<PhongEntity> listPhong;
	private List<LoaiPhong> listLoaiPhong;
	private QuanLyPhongController controller;
	private QuanLyPhongDAO quanLyPhongDAO = new QuanLyPhongDAO();
	private NhanVienEntity nhanVienEntity;

	public GD_QuanLyPhong(NhanVienEntity nhanVienEntity) {
		this.nhanVienEntity = nhanVienEntity;
		setLayout(null);
		setBounds(0, 0, 1365, 694);

		pnlQuanLiPhong = new JPanel();
		pnlQuanLiPhong.setBounds(0, 0, 1365, 694);
		add(pnlQuanLiPhong);
		pnlQuanLiPhong.setLayout(null);

		String[] colsTrangThai = { "", "Trống", "Chờ", "Đang sử dụng" };
		cmbmodelTrangThai = new DefaultComboBoxModel<>(colsTrangThai);

		cmbmodelLoaiPhong = new DefaultComboBoxModel<>();

		pnlDsPhong = new JPanel();
		pnlDsPhong.setBackground(new Color(230, 230, 250));
		pnlDsPhong.setBounds(0, 395, 1365, 299);
		pnlQuanLiPhong.add(pnlDsPhong);
		pnlDsPhong.setLayout(null);

		lblDanhSachPhong = new JLabel("Danh sách phòng");
		lblDanhSachPhong.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSachPhong.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDanhSachPhong.setBounds(0, 11, 1364, 40);
		pnlDsPhong.add(lblDanhSachPhong);

		String[] colsPhong = { "STT", "Mã phòng", "Số phòng", "Loại phòng", "Sức chứa", "Trạng thái" };
		tblmodelPhong = new DefaultTableModel(colsPhong, 0);
		tblPhong = new JTable(tblmodelPhong);
		tblPhong.setAutoCreateRowSorter(true);
		tblPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrDanhSachPhong = new JScrollPane(tblPhong);
		scrDanhSachPhong.setBounds(35, 65, 1300, 223);
		pnlDsPhong.add(scrDanhSachPhong);

		pnlThongTinPhong = new JPanel();
		pnlThongTinPhong.setBounds(0, 142, 1365, 251);
		pnlQuanLiPhong.add(pnlThongTinPhong);
		pnlThongTinPhong.setBorder(null);
		pnlThongTinPhong.setBackground(new Color(230, 230, 250));
		pnlThongTinPhong.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBorder(new TitledBorder(null, "Phòng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(35, 61, 780, 179);
		pnlThongTinPhong.add(panel);
		panel.setLayout(null);

		lblMaPhong = new JLabel("Mã phòng:");
		lblMaPhong.setBounds(12, 22, 80, 30);
		panel.add(lblMaPhong);
		lblMaPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtMaPhong = new JTextField();
		txtMaPhong.setBounds(104, 22, 150, 30);
		panel.add(txtMaPhong);
		txtMaPhong.setBackground(Color.WHITE);
		txtMaPhong.setEnabled(false);
		txtMaPhong.setDisabledTextColor(Color.BLACK);
		txtMaPhong.setSelectedTextColor(Color.BLACK);
		txtMaPhong.setSelectionColor(Color.BLACK);
		txtMaPhong.setForeground(SystemColor.BLACK);
		txtMaPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaPhong.setColumns(10);

		txtSoPhong = new JTextField();
		txtSoPhong.setBounds(358, 22, 150, 30);
		panel.add(txtSoPhong);
		txtSoPhong.setBackground(Color.WHITE);
		txtSoPhong.setDisabledTextColor(Color.BLACK);
		txtSoPhong.setSelectionColor(Color.BLACK);
		txtSoPhong.setSelectedTextColor(Color.BLACK);
		txtSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtSoPhong.setColumns(10);

		lblSoPhong = new JLabel("Số phòng:");
		lblSoPhong.setBounds(266, 22, 80, 30);
		panel.add(lblSoPhong);
		lblSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		lblLoaiPhong = new JLabel("Loại phòng: ");
		lblLoaiPhong.setBounds(10, 74, 100, 30);
		panel.add(lblLoaiPhong);
		lblLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbLoaiPhong = new JComboBox<String>(cmbmodelLoaiPhong);
		cmbLoaiPhong.setBounds(104, 74, 150, 30);
		panel.add(cmbLoaiPhong);
		cmbLoaiPhong.setBackground(Color.WHITE);
		cmbLoaiPhong.setForeground(Color.BLACK);
		cmbLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtSucChua = new JTextField();
		txtSucChua.setToolTipText("Sức chứa của một phòng là 10 hoặc 20 người");
		txtSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtSucChua.setBounds(612, 22, 150, 30);
		panel.add(txtSucChua);
		txtSucChua.setBackground(Color.WHITE);
		txtSucChua.setColumns(10);

		lblSucChua = new JLabel("Sức chứa:");
		lblSucChua.setBounds(520, 22, 80, 30);
		panel.add(lblSucChua);
		lblSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		lblTrangThai = new JLabel("Trạng thái:");
		lblTrangThai.setBounds(266, 74, 80, 30);
		panel.add(lblTrangThai);
		lblTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbTrangThai = new JComboBox<String>(cmbmodelTrangThai);
		cmbTrangThai.setBounds(358, 74, 150, 30);
		panel.add(cmbTrangThai);
		cmbTrangThai.setForeground(new Color(0, 0, 0));
		cmbTrangThai.setBackground(new Color(255, 255, 255));
		cmbTrangThai.setEnabled(false);
		cmbTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		btnThem = new JButton("Thêm phòng");
		btnThem.setBounds(82, 122, 150, 35);
		panel.add(btnThem);
		btnThem.setIcon(new ImageIcon(GD_QuanLyPhong.class.getResource("/images/iconThem.png")));
		btnThem.setForeground(Color.BLACK);
		btnThem.setFont(new Font("Cambria", Font.BOLD, 14));
		btnThem.setFocusPainted(false);
		btnThem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThem.setBackground(new Color(152, 251, 152));

		btnXoaPhong = new JButton("Xóa phòng");
		btnXoaPhong.setBounds(314, 122, 150, 35);
		panel.add(btnXoaPhong);
		btnXoaPhong.setIcon(new ImageIcon(GD_QuanLyPhong.class.getResource("/images/iconXoa.png")));
		btnXoaPhong.setForeground(Color.BLACK);
		btnXoaPhong.setFont(new Font("Cambria", Font.BOLD, 14));
		btnXoaPhong.setFocusPainted(false);
		btnXoaPhong.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXoaPhong.setBackground(new Color(152, 251, 152));

		btnChinhSuaPhong = new JButton("Chỉnh sửa phòng");
		btnChinhSuaPhong.setBounds(546, 122, 150, 35);
		panel.add(btnChinhSuaPhong);
		btnChinhSuaPhong.setIcon(new ImageIcon(GD_QuanLyPhong.class.getResource("/images/iconChinhSua1.png")));
		btnChinhSuaPhong.setForeground(Color.BLACK);
		btnChinhSuaPhong.setFont(new Font("Cambria", Font.BOLD, 14));
		btnChinhSuaPhong.setFocusPainted(false);
		btnChinhSuaPhong.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnChinhSuaPhong.setBackground(new Color(152, 251, 152));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Loại phòng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBounds(843, 61, 472, 179);
		pnlThongTinPhong.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblMaLoaiPhong = new JLabel("Mã loại phòng:");
		lblMaLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaLoaiPhong.setBounds(30, 35, 110, 30);
		panel_1.add(lblMaLoaiPhong);

		JLabel lblTenLoaiPhong = new JLabel("Tên loại phòng;");
		lblTenLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTenLoaiPhong.setBounds(30, 76, 119, 30);
		panel_1.add(lblTenLoaiPhong);

		txtTenLoaiPhong = new JTextField();
		txtTenLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTenLoaiPhong.setBounds(151, 76, 275, 30);
		panel_1.add(txtTenLoaiPhong);
		txtTenLoaiPhong.setColumns(10);

		btnThemLoaiPhong = new JButton("Thêm");
		btnThemLoaiPhong.setIcon(new ImageIcon(GD_QuanLyPhong.class.getResource("/images/iconThem2.png")));
		btnThemLoaiPhong.setForeground(Color.BLACK);
		btnThemLoaiPhong.setFont(new Font("Cambria", Font.BOLD, 13));
		btnThemLoaiPhong.setFocusPainted(false);
		btnThemLoaiPhong.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThemLoaiPhong.setBackground(new Color(255, 128, 128));
		btnThemLoaiPhong.setBounds(140, 133, 110, 30);
		panel_1.add(btnThemLoaiPhong);

		btnXemLoaiPhong = new JButton("Xem loại phòng");
		btnXemLoaiPhong.setIcon(new ImageIcon(GD_QuanLyPhong.class.getResource("/images/iconMatMo.png")));
		btnXemLoaiPhong.setForeground(Color.BLACK);
		btnXemLoaiPhong.setFont(new Font("Cambria", Font.BOLD, 13));
		btnXemLoaiPhong.setFocusPainted(false);
		btnXemLoaiPhong.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXemLoaiPhong.setBackground(new Color(255, 128, 128));
		btnXemLoaiPhong.setBounds(274, 133, 160, 30);
		panel_1.add(btnXemLoaiPhong);

		cmbmodelMaLoaiPhong = new DefaultComboBoxModel<String>();
		cmbMaLoaiPhong = new JComboBox<String>(cmbmodelMaLoaiPhong);
		cmbMaLoaiPhong.setBackground(Color.WHITE);
		cmbMaLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbMaLoaiPhong.setBounds(151, 35, 275, 30);
		panel_1.add(cmbMaLoaiPhong);

		lblPhongHat = new JLabel("Thông tin phòng");
		lblPhongHat.setBounds(0, 10, 1365, 50);
		pnlThongTinPhong.add(lblPhongHat);
		lblPhongHat.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhongHat.setFont(new Font("Segoe UI", Font.BOLD, 22));

		pnlTimKiem = new JPanel();
		pnlTimKiem.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		pnlTimKiem.setBounds(0, 0, 1365, 142);
		pnlQuanLiPhong.add(pnlTimKiem);
		pnlTimKiem.setBackground(new Color(230, 230, 250));
		pnlTimKiem.setLayout(null);

		pnlTK = new JPanel();
		pnlTK.setBackground(new Color(230, 230, 250));
		pnlTK.setBorder(new TitledBorder(null, "Tìm kiếm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlTK.setBounds(35, 11, 1278, 69);
		pnlTimKiem.add(pnlTK);
		pnlTK.setLayout(null);

		lblTimKiemBangLoaiPhong = new JLabel("Loại phòng:");
		lblTimKiemBangLoaiPhong.setBounds(961, 22, 90, 30);
		pnlTK.add(lblTimKiemBangLoaiPhong);
		lblTimKiemBangLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtTimKiemBangSucChua = new JTextField();
		txtTimKiemBangSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTimKiemBangSucChua.setBounds(432, 25, 200, 30);
		pnlTK.add(txtTimKiemBangSucChua);
		txtTimKiemBangSucChua.setColumns(10);

		lblTimKiemBangSucChua = new JLabel("Sức chứa:");
		lblTimKiemBangSucChua.setBounds(329, 25, 90, 30);
		pnlTK.add(lblTimKiemBangSucChua);
		lblTimKiemBangSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtTimKiemBangSoPhong = new JTextField();
		txtTimKiemBangSoPhong.setBounds(116, 25, 200, 30);
		pnlTK.add(txtTimKiemBangSoPhong);
		txtTimKiemBangSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTimKiemBangSoPhong.setColumns(10);

		txtTimBangTrangThai = new JTextField();
		txtTimBangTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTimBangTrangThai.setBounds(748, 25, 200, 30);
		pnlTK.add(txtTimBangTrangThai);
		txtTimBangTrangThai.setColumns(10);

		lblTimKiemBangTrangThai = new JLabel("Trạng thái: ");
		lblTimKiemBangTrangThai.setBounds(645, 22, 90, 30);
		pnlTK.add(lblTimKiemBangTrangThai);
		lblTimKiemBangTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		lblTimKiemBangSoPhong = new JLabel("Số phòng:");
		lblTimKiemBangSoPhong.setBounds(13, 25, 90, 30);
		pnlTK.add(lblTimKiemBangSoPhong);
		lblTimKiemBangSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		cmbmodelLoaiPhongTimKiem = new DefaultComboBoxModel<String>();
		cmbLoaiPhongTimKiem = new JComboBox<String>(cmbmodelLoaiPhongTimKiem);
		cmbLoaiPhongTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbLoaiPhongTimKiem.setBackground(Color.WHITE);
		cmbLoaiPhongTimKiem.setBounds(1043, 22, 200, 30);
		pnlTK.add(cmbLoaiPhongTimKiem);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBounds(974, 90, 150, 35);
		pnlTimKiem.add(btnLamMoi);
		btnLamMoi.setIcon(new ImageIcon(GD_QuanLyPhong.class.getResource("/images/iconLamMoi.png")));
		btnLamMoi.setForeground(Color.BLACK);
		btnLamMoi.setBackground(new Color(152, 251, 152));
		btnLamMoi.setFocusPainted(false);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setFont(new Font("Cambria", Font.BOLD, 14));

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBounds(1163, 90, 150, 35);
		pnlTimKiem.add(btnTimKiem);
		btnTimKiem.setIcon(new ImageIcon(GD_QuanLyPhong.class.getResource("/images/iconTimKiem.png")));
		btnTimKiem.setForeground(Color.BLACK);
		btnTimKiem.setFont(new Font("Cambria", Font.BOLD, 14));
		btnTimKiem.setFocusPainted(false);
		btnTimKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiem.setBackground(new Color(152, 251, 152));

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblPhong.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblPhong.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tblPhong.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tblPhong.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tblPhong.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		tblPhong.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		tblPhong.getColumnModel().getColumn(0).setPreferredWidth(40);

		loadCmbLoaiPhong();
		loadCmbMaLoaiPhong();
		loadCmbLoaiPhongTimKiem();
		controller = new QuanLyPhongController(this);
		tblPhong.addMouseListener(controller);
		btnChinhSuaPhong.addActionListener(controller);
		btnLamMoi.addActionListener(controller);
		btnXemLoaiPhong.addActionListener(controller);
		btnThem.addActionListener(controller);
		btnThemLoaiPhong.addActionListener(controller);
		btnTimKiem.addActionListener(controller);
		btnXoaPhong.addActionListener(controller);
		cmbMaLoaiPhong.addActionListener(controller);
		kiemTraQuyen();
		loadData();
	}

	/***** loadData *****/
	private void loadData() {
		tblPhong.removeAll();
		tblPhong.setRowSelectionAllowed(false);
		tblmodelPhong.setRowCount(0);
		listPhong = quanLyPhongDAO.duyetDanhSach();

		int stt = 1;
		for (PhongEntity phongEntity : listPhong)
			tblmodelPhong.addRow(new Object[] { stt++, phongEntity.getMaPhong(), phongEntity.getSoPhong(),
					phongEntity.getLoaiPhong().getTenLoaiPhong(), phongEntity.getSucChua(),
					phongEntity.getTrangThai() });

	}

	/***** HIỂN THỊ THÔNG TIN *****/
	public void hienThiThongTin() {
		listPhong = quanLyPhongDAO.duyetDanhSach();
		int row = tblPhong.getSelectedRow();
		if (row >= 0) {
			txtMaPhong.setText(listPhong.get(row).getMaPhong());
			txtSoPhong.setText(String.valueOf(listPhong.get(row).getSoPhong()));
			cmbLoaiPhong.setSelectedItem(tblPhong.getValueAt(row, 3));
			txtSucChua.setText(String.valueOf(listPhong.get(row).getSucChua()));
			if (listPhong.get(row).getTrangThai().equals("Trống"))
				cmbTrangThai.setSelectedIndex(1);
			else if (listPhong.get(row).getTrangThai().equals("Chờ"))
				cmbTrangThai.setSelectedIndex(2);
			else if (listPhong.get(row).getTrangThai().equals("Đang sử dụng"))
				cmbTrangThai.setSelectedIndex(3);
			else
				cmbTrangThai.setSelectedIndex(0);
			cmbMaLoaiPhong.setSelectedItem(listPhong.get(row).getLoaiPhong().getMaLoai());
			txtTenLoaiPhong.setText(listPhong.get(row).getLoaiPhong().getTenLoaiPhong());
		}
	}

	/***** LÀM MỚI *****/
	public void chonLamMoi() {
		txtMaPhong.setText("");
		txtSoPhong.setText("");
		txtSucChua.setText("");
		txtTenLoaiPhong.setText("");
		cmbLoaiPhong.setSelectedIndex(0);
		cmbTrangThai.setSelectedIndex(0);
		cmbMaLoaiPhong.setSelectedIndex(0);
		txtTimBangTrangThai.setText("");
		txtTimKiemBangSoPhong.setText("");
		txtTimKiemBangSucChua.setText("");
		cmbLoaiPhongTimKiem.setSelectedIndex(0);
		loadCmbLoaiPhongTimKiem();
		loadCmbLoaiPhong();
		loadCmbMaLoaiPhong();
		loadData();
	}

	/***** THÊM LOẠI PHÒNG *****/
	public void chonThemLoaiPhong() {
		if (kiemTraTenLoaiPhong()) {
			String tenLoaiPhong = txtTenLoaiPhong.getText();
			LoaiPhong loaiPhong = new LoaiPhong(tenLoaiPhong);
			if (quanLyPhongDAO.themLoaiPhong(loaiPhong)) {
				JOptionPane.showMessageDialog(this, "Thêm thành công");
				chonLamMoi();
			} else {
				JOptionPane.showMessageDialog(this, "Thêm thất bại");
				return;
			}
		}
	}

	/***** THÊM PHÒNG *****/
	public void chonThemPhong() {
		if (kiemTraDuLieuThemPhong()) {
			int soPhong = Integer.parseInt(txtSoPhong.getText().trim());
			int sucChua = Integer.parseInt(txtSucChua.getText().trim());
			String loaiPhong = cmbLoaiPhong.getSelectedItem().toString();

			PhongEntity phongEntity = new PhongEntity(soPhong, quanLyPhongDAO.timTheoTenLoaiPhong(loaiPhong), "Trống",
					sucChua);
			if (quanLyPhongDAO.themPhong(phongEntity)) {
				JOptionPane.showMessageDialog(this, "Thêm thành công");
				chonLamMoi();
			} else {
				JOptionPane.showMessageDialog(this, "Thêm thất bại");
				return;
			}
		}
		return;
	}

	/***** XÓA PHÒNG *****/
	public void chonXoaPhong() {
		int row = tblPhong.getSelectedRow();
		if (row >= 0) {
			if (JOptionPane.showConfirmDialog(this, "Xác nhận xóa?", "Thông báo",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				if (quanLyPhongDAO.xoaPhong(txtMaPhong.getText())) {
					tblmodelPhong.removeRow(row);
					JOptionPane.showMessageDialog(this, "Xóa phòng thành công");
					chonLamMoi();
					loadData();
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Hãy chọn phòng cần xóa");
			return;
		}
	}

	/***** CHỈNH SỬA PHÒNG *****/
	public void chonSuaPhong() {
		int row = tblPhong.getSelectedRow();
		if (row >= 0) {
			if (kiemTraDuLieuChinhSua()) {
				if (JOptionPane.showConfirmDialog(this, "Xác nhận chỉnh sửa?", "Thông báo",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					String maPhong = txtMaPhong.getText();
					int soPhong = Integer.parseInt(txtSoPhong.getText().trim());
					int sucChua = Integer.parseInt(txtSucChua.getText().trim());
					String loaiPhong = cmbLoaiPhong.getSelectedItem().toString();
					PhongEntity phongEntity = new PhongEntity(maPhong, soPhong,
							quanLyPhongDAO.timTheoTenLoaiPhong(loaiPhong), "", sucChua);
					if (quanLyPhongDAO.chinhSuaPhong(phongEntity)) {
						JOptionPane.showMessageDialog(this, "Chỉnh sửa thông tin thành công");
						chonLamMoi();
					} else {
						JOptionPane.showMessageDialog(this, "Chỉnh sửa thông tin thất bại");
						return;
					}
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Hãy chọn phòng cần chỉnh sửa");
			return;
		}

	}

	/***** TÌM KIẾM *****/
	public void chonTimKiem() {
		if (kiemTraDuLieuTimKiem()) {
			String tenLoai = cmbmodelLoaiPhongTimKiem.getSelectedItem().toString();
			String trangThai = txtTimBangTrangThai.getText().trim();
			int sucChua = -1, soPhong = -1;

			if (txtTimKiemBangSucChua.getText().trim().matches("[0-9]+"))
				sucChua = Integer.parseInt(txtTimKiemBangSucChua.getText().trim());

			if (txtTimKiemBangSoPhong.getText().trim().matches("[0-9]+"))
				soPhong = Integer.parseInt(txtTimKiemBangSoPhong.getText().trim());

			tblPhong.removeAll();
			tblmodelPhong.setRowCount(0);
			listPhong = quanLyPhongDAO.timKiemPhong(soPhong, sucChua, trangThai, tenLoai);

			int stt = 1;
			for (PhongEntity phongEntity : listPhong)
				tblmodelPhong.addRow(new Object[] { stt++, phongEntity.getMaPhong(), phongEntity.getSoPhong(),
						phongEntity.getLoaiPhong().getTenLoaiPhong(), phongEntity.getSucChua(),
						phongEntity.getTrangThai() });

		}
	}

	/***** XEM LOẠI PHÒNG *****/
	public void chonXemLoaiPhong() {
		new GD_QuanLyLoaiPhong(nhanVienEntity).setVisible(true);
	}

	/***** loadCmbLoaiPhong *****/
	private void loadCmbLoaiPhong() {
		listLoaiPhong = quanLyPhongDAO.duyetDanhSachLoaiPhong();
		cmbmodelLoaiPhong.removeAllElements();
		cmbmodelLoaiPhong.addElement("");
		for (LoaiPhong loaiPhong : listLoaiPhong)
			cmbmodelLoaiPhong.addElement(loaiPhong.getTenLoaiPhong());
	}

	/***** loadCmbMaLoaiPhong *****/
	private void loadCmbMaLoaiPhong() {
		listLoaiPhong = quanLyPhongDAO.duyetDanhSachLoaiPhong();
		cmbmodelMaLoaiPhong.removeAllElements();
		cmbmodelMaLoaiPhong.addElement("");
		for (LoaiPhong loaiPhong : listLoaiPhong)
			cmbmodelMaLoaiPhong.addElement(loaiPhong.getMaLoai());

	}

	/***** loadCmbLoaiPhongTimKiem *****/
	private void loadCmbLoaiPhongTimKiem() {
		listLoaiPhong = quanLyPhongDAO.duyetDanhSachLoaiPhong();
		cmbmodelLoaiPhongTimKiem.removeAllElements();
		cmbmodelLoaiPhongTimKiem.addElement("Tất cả");
		for (LoaiPhong loaiPhong : listLoaiPhong)
			cmbmodelLoaiPhongTimKiem.addElement(loaiPhong.getTenLoaiPhong());

	}

	/***** KIỂM TRA DỮ LIỆU THÊM *****/
	private boolean kiemTraDuLieuThemPhong() {
		if (!kiemTraSoPhongThem())
			return false;

		if (!kiemTraSucChua())
			return false;

		if (!kiemTraLoaiPhong())
			return false;

		return true;
	}

	/**
	 * soPhong
	 */
	private boolean kiemTraSoPhongThem() {
		listPhong = quanLyPhongDAO.duyetDanhSach();
		if (txtSoPhong.getText().trim().length() > 0) {
			try {
				int soPhong = Integer.parseInt(txtSoPhong.getText().trim());
				if (soPhong > 0) {
					if (listPhong.contains(new PhongEntity("", soPhong, null, "", 0))) {
						JOptionPane.showMessageDialog(this, "Số phòng đã tồn tại trong hệ thống", "Thông báo",
								JOptionPane.INFORMATION_MESSAGE);
						txtSoPhong.requestFocus();
						return false;
					}
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Số phòng nhập vào  là số nguyên", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtSoPhong.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Số phòng không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtSoPhong.requestFocus();
			return false;
		}
		return true;
	}

	/**
	 * sucChua
	 */
	private boolean kiemTraSucChua() {
		if (txtSucChua.getText().trim().length() > 0) {
			try {
				int sucChua = Integer.parseInt(txtSucChua.getText().trim());
				if (!(sucChua == 10 || sucChua == 20)) {
					JOptionPane.showMessageDialog(this, "Sức chứa của một phòng là 10 hoặc 20 người");
					txtSucChua.requestFocus();
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Sức chứa nhập vào  là số nguyên");
				txtSucChua.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Sức chứa không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtSucChua.requestFocus();
			return false;
		}
		return true;
	}

	/**
	 * loaiPhong
	 */
	private boolean kiemTraLoaiPhong() {
		if (cmbLoaiPhong.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Hãy chọn loại phòng cho phòng mới", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			cmbLoaiPhong.requestFocus();
			return false;
		}
		return true;
	}

	/**
	 * tenLoai
	 */
	private boolean kiemTraTenLoaiPhong() {
		listLoaiPhong = quanLyPhongDAO.duyetDanhSachLoaiPhong();
		if (txtTenLoaiPhong.getText().trim().length() > 0) {
			if (listLoaiPhong.contains(new LoaiPhong("", txtTenLoaiPhong.getText().trim()))) {
				JOptionPane.showMessageDialog(this, "Tên loại phòng đã có trong hệ thống", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtTenLoaiPhong.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Tên loại phòng không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtTenLoaiPhong.requestFocus();
			return false;
		}
		return true;
	}

	/***** KIỂM TRA DỮ LIỆU CẦN CHỈNH SỬA *****/
	private boolean kiemTraDuLieuChinhSua() {
		if (!kiemTraSoPhongChinhSua())
			return false;

		if (!kiemTraSucChua())
			return false;

		if (!kiemTraLoaiPhong())
			return false;

		return true;
	}

	/**
	 * soPhong
	 */
	private boolean kiemTraSoPhongChinhSua() {
		listPhong = quanLyPhongDAO.duyetDanhSach();
		if (txtSoPhong.getText().trim().length() > 0) {
			try {
				int soPhong = Integer.parseInt(txtSoPhong.getText().trim());
				if (soPhong > 0) {
					if (!(soPhong == (listPhong.get(tblPhong.getSelectedRow()).getSoPhong()))
							&& listPhong.contains(new PhongEntity("", soPhong, null, "", 0))) {
						JOptionPane.showMessageDialog(this, "Số phòng đã tồn tại trong hệ thống", "Thông báo",
								JOptionPane.INFORMATION_MESSAGE);
						txtSoPhong.requestFocus();
						return false;
					}
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Số phòng nhập vào  là số nguyên", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtSoPhong.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Số phòng không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtSoPhong.requestFocus();
			return false;
		}
		return true;
	}

	/***** KIẾM TRA DỮ LIỆU TÌM KIẾM *****/
	private boolean kiemTraDuLieuTimKiem() {
		if (!kiemTraSoPhongTimKiem())
			return false;

		if (!kiemTraSucChuaTimKiem())
			return false;

		if (!kiemTraTrangThaiTimKiem())
			return false;

		return true;
	}

	private boolean kiemTraSoPhongTimKiem() {
		if (txtTimKiemBangSoPhong.getText().trim().length() > 0) {
			try {
				int soPhong = Integer.parseInt(txtTimKiemBangSoPhong.getText().trim());
				if (soPhong < 0 && soPhong < 1000) {
					JOptionPane.showMessageDialog(this, "Không có số phòng " + soPhong, "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					txtTimKiemBangSoPhong.requestFocus();
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Số phòng nhập vào là số nguyên", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtTimKiemBangSoPhong.requestFocus();
				return false;
			}
		}
		return true;
	}

	private boolean kiemTraSucChuaTimKiem() {
		if (txtTimKiemBangSucChua.getText().trim().length() > 0) {
			try {
				int sc = Integer.parseInt(txtTimKiemBangSucChua.getText().trim());
				if (!(sc == 10 || sc == 20)) {
					JOptionPane.showMessageDialog(this, "Sức chứa của 1 phòng là 10 hoặc 20 người", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					txtTimKiemBangSucChua.requestFocus();
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Sức chứa nhập vào  là số nguyên", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtTimKiemBangSucChua.requestFocus();
				return false;
			}
		}
		return true;
	}

	private boolean kiemTraTrangThaiTimKiem() {
		if (txtTimBangTrangThai.getText().trim().length() > 0
				&& !(txtTimBangTrangThai.getText().trim().equalsIgnoreCase("Chờ")
						|| txtTimBangTrangThai.getText().trim().equalsIgnoreCase("Trống")
						|| txtTimBangTrangThai.getText().trim().equalsIgnoreCase("Đang sử dụng"))) {
			JOptionPane.showMessageDialog(this, "Không có trạng thái phòng " + txtTimBangTrangThai.getText().trim());
			txtTimBangTrangThai.requestFocus();
			return false;
		}
		return true;
	}

	/***** HIỆN THỊ TEN LOẠI PHÒNG *****/
	public void hienThiTenLoaiPhong() {
		if (cmbMaLoaiPhong.getSelectedIndex() > 0) {
			String maLoaiPhong = cmbMaLoaiPhong.getSelectedItem().toString();
			String tenLoai = quanLyPhongDAO.timTheoMaLoaiPhong(maLoaiPhong).getTenLoaiPhong();
			txtTenLoaiPhong.setText(tenLoai);
		}
	}

	/***** KIỂM TRA CHỨC VU *****/
	private void kiemTraQuyen() {
		if (nhanVienEntity.getChucVu().equalsIgnoreCase("Quản lí")) {
			btnThem.setEnabled(true);
			btnChinhSuaPhong.setEnabled(true);
			btnXoaPhong.setEnabled(true);
			btnThemLoaiPhong.setEnabled(true);
		} else {
			btnThem.setEnabled(false);
			btnChinhSuaPhong.setEnabled(false);
			btnXoaPhong.setEnabled(false);
			btnThemLoaiPhong.setEnabled(false);
		}
	}
}
