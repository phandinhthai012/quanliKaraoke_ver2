package gui.timKiem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Dao.PhongDao;
import Dao.Impl.PhongImpl;
import controller.TimKiemPhongController;
import entities.LoaiPhong;
import entities.PhongEntity;
import gui.dangNhap.GD_DangNhap;

public class GD_TimKiemPhong extends JFrame {

	private static final long serialVersionUID = 1L;
	// JPanel
	private JPanel pnlTimKiemPhong;
	private JPanel pnlTimKiem;
	private JPanel pnlBangThongTin;
	private JPanel pnlChiTietThongTin;
	private JLabel lblSoPhong;
	private JLabel lblSucChua;
	private JLabel lblTimBangSucChua;
	private JLabel lblTimBangLoaiPhong;
	private JLabel lblDsPhong;
	private JTextField txtSoPhong;
	private JTextField txtSucChua;
	private JTextField txtLoaiPhong;
	// JTable
	private JTable tblPhong;
	private DefaultTableModel tblmodelPhong;
	// JCrollPane
	private JScrollPane scrBangThongTin;
	// JButton
	public JButton btnTimKiem;
	public JButton btnLamMoi;

	private JComboBox<String> cmbSucChua;
	private JComboBox<String> cmbLoaiPhong;
	private DefaultComboBoxModel<String> cmbmodelSucChua;
	private DefaultComboBoxModel<String> cmbmodelLoaiPhong;

	private List<PhongEntity> listPhong;
//	private QuanLyPhongDAO quanLyPhongDAO = new QuanLyPhongDAO();
	private PhongDao quanLyPhongDAO = new PhongImpl();

	public GD_TimKiemPhong() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GD_TimKiemPhong.class.getResource("/images/iconLogo1.png")));
		setTitle("Quản lý kệ thống Karaoke NNice");
		setBounds(100, 100, 905, 487);
		setLocationRelativeTo(null);
		pnlTimKiemPhong = new JPanel();
		pnlTimKiemPhong.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlTimKiemPhong);
		pnlTimKiemPhong.setLayout(null);
		JFrame myframe = this;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				if (JOptionPane.showConfirmDialog(null, "Quay về màn hình đăng nhập", "Thông báo",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					new GD_DangNhap().setVisible(true);
					myframe.dispose();
				}
			}
		});

		pnlBangThongTin = new JPanel();
		pnlBangThongTin.setBorder(null);
		pnlBangThongTin.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		pnlBangThongTin.setBackground(new Color(230, 230, 250));
		pnlBangThongTin.setBounds(330, 132, 559, 305);
		pnlTimKiemPhong.add(pnlBangThongTin);
		pnlBangThongTin.setLayout(null);

		String[] cols = { "STT", "Số phòng", "Loại phòng", "Sức chứa" };
		tblmodelPhong = new DefaultTableModel(cols, 0);
		tblPhong = new JTable(tblmodelPhong);
		tblPhong.setAutoCreateRowSorter(true);
		scrBangThongTin = new JScrollPane(tblPhong);
		scrBangThongTin.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		scrBangThongTin.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrBangThongTin.setBounds(10, 50, 539, 244);
		pnlBangThongTin.add(scrBangThongTin);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblPhong.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblPhong.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tblPhong.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

		tblPhong.getColumnModel().getColumn(0).setPreferredWidth(40);

		lblDsPhong = new JLabel("Danh sách phòng");
		lblDsPhong.setHorizontalAlignment(SwingConstants.CENTER);
		lblDsPhong.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDsPhong.setBounds(0, 10, 559, 35);
		pnlBangThongTin.add(lblDsPhong);

		pnlTimKiem = new JPanel();
		pnlTimKiem.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		pnlTimKiem.setBounds(0, 0, 889, 132);
		pnlTimKiemPhong.add(pnlTimKiem);
		pnlTimKiem.setBackground(new Color(230, 230, 250));
		pnlTimKiem.setLayout(null);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setIcon(new ImageIcon(GD_TimKiemPhong.class.getResource("/images/iconTimKiem.png")));
		btnTimKiem.setFont(new Font("Cambria", Font.BOLD, 14));
		btnTimKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		btnTimKiem.setBackground(new Color(144, 238, 144));
		btnTimKiem.setFocusable(false);
		btnTimKiem.setBounds(634, 80, 150, 35);
		pnlTimKiem.add(btnTimKiem);

		lblTimBangLoaiPhong = new JLabel("Loại phòng:");
		lblTimBangLoaiPhong.setHorizontalAlignment(SwingConstants.LEFT);
		lblTimBangLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTimBangLoaiPhong.setBounds(30, 30, 88, 30);
		pnlTimKiem.add(lblTimBangLoaiPhong);

		lblTimBangSucChua = new JLabel("Sức chứa:");
		lblTimBangSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTimBangSucChua.setHorizontalAlignment(SwingConstants.LEFT);
		lblTimBangSucChua.setBounds(460, 33, 88, 25);
		pnlTimKiem.add(lblTimBangSucChua);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(GD_TimKiemPhong.class.getResource("/images/iconLamMoi.png")));
		btnLamMoi.setFocusPainted(false);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setBounds(444, 80, 150, 35);
		pnlTimKiem.add(btnLamMoi);
		btnLamMoi.setFont(new Font("Cambria", Font.BOLD, 14));

		cmbmodelLoaiPhong = new DefaultComboBoxModel<>();
		cmbLoaiPhong = new JComboBox<String>(cmbmodelLoaiPhong);
		cmbLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbLoaiPhong.setBounds(120, 30, 254, 30);
		pnlTimKiem.add(cmbLoaiPhong);

		String[] colsSucChua = { "Tất cả", "10 người", "20 người" };
		cmbmodelSucChua = new DefaultComboBoxModel<>(colsSucChua);
		cmbSucChua = new JComboBox<String>(cmbmodelSucChua);
		cmbSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbSucChua.setBounds(530, 30, 254, 30);
		pnlTimKiem.add(cmbSucChua);

		pnlChiTietThongTin = new JPanel();
		pnlChiTietThongTin.setBounds(0, 132, 330, 316);
		pnlTimKiemPhong.add(pnlChiTietThongTin);
		pnlChiTietThongTin.setBackground(new Color(230, 230, 250));
		pnlChiTietThongTin.setLayout(null);

		lblSoPhong = new JLabel("Số phòng:");
		lblSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblSoPhong.setBounds(33, 85, 110, 30);
		pnlChiTietThongTin.add(lblSoPhong);

		txtSoPhong = new JTextField();
		txtSoPhong.setBorder(null);
		txtSoPhong.setBackground(new Color(230, 230, 250));
		txtSoPhong.setFont(new Font("Segoe UI", Font.BOLD, 17));
		txtSoPhong.setEditable(false);
		txtSoPhong.setBounds(153, 85, 150, 30);
		pnlChiTietThongTin.add(txtSoPhong);
		txtSoPhong.setColumns(10);

		lblSucChua = new JLabel("Sức chứa:");
		lblSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblSucChua.setBounds(33, 207, 110, 30);
		pnlChiTietThongTin.add(lblSucChua);

		txtSucChua = new JTextField();
		txtSucChua.setBorder(null);
		txtSucChua.setBackground(new Color(230, 230, 250));
		txtSucChua.setFont(new Font("Segoe UI", Font.BOLD, 17));
		txtSucChua.setEditable(false);
		txtSucChua.setBounds(153, 207, 150, 30);
		pnlChiTietThongTin.add(txtSucChua);
		txtSucChua.setColumns(10);

		JLabel lblLoaiPhong = new JLabel("Loại phòng:");
		lblLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblLoaiPhong.setBounds(33, 146, 110, 30);
		pnlChiTietThongTin.add(lblLoaiPhong);

		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setFont(new Font("Segoe UI", Font.BOLD, 17));
		txtLoaiPhong.setEditable(false);
		txtLoaiPhong.setColumns(10);
		txtLoaiPhong.setBorder(null);
		txtLoaiPhong.setBackground(new Color(230, 230, 250));
		txtLoaiPhong.setBounds(153, 146, 150, 30);
		pnlChiTietThongTin.add(txtLoaiPhong);

		TimKiemPhongController controller = new TimKiemPhongController(this);
		btnTimKiem.addActionListener(controller);
		btnLamMoi.addActionListener(controller);
		tblPhong.addMouseListener(controller);
		loadData();
		loadLoaiPhong();
	}

	private void loadData() {
		listPhong = quanLyPhongDAO.duyetDanhSach();
		tblPhong.removeAll();
		tblPhong.setRowSelectionAllowed(false);
		tblmodelPhong.setRowCount(0);

		int stt = 1;
		for (PhongEntity phongEntity : listPhong)
			tblmodelPhong.addRow(new Object[] { stt++, phongEntity.getSoPhong(),
					phongEntity.getLoaiPhong().getTenLoaiPhong(), phongEntity.getSucChua() });
	}

	private void loadLoaiPhong() {
		List<LoaiPhong> listLoaiPhong = quanLyPhongDAO.duyetDanhSachLoaiPhong();
		cmbmodelLoaiPhong.addElement("Tất cả");
		for (LoaiPhong loaiPhong : listLoaiPhong)
			cmbmodelLoaiPhong.addElement(loaiPhong.getTenLoaiPhong());
	}

	public void hienthiThongTin() {
		int row = tblPhong.getSelectedRow();
		if (row >= 0) {
			txtSoPhong.setText(tblPhong.getValueAt(row, 1).toString());
			txtLoaiPhong.setText(tblPhong.getValueAt(row, 2).toString());
			txtLoaiPhong.setText(tblPhong.getValueAt(row, 3).toString());
		}
	}

	public void chonLamMoi() {
		cmbLoaiPhong.setSelectedIndex(0);
		cmbSucChua.setSelectedIndex(0);
		txtSoPhong.setText("");
		txtLoaiPhong.setText("");
		txtSucChua.setText("");
		loadData();
	}

	public void chonTimKiem() {
		int sucChua = -1;
		String loaiPhong = cmbLoaiPhong.getSelectedItem().toString();
		if (cmbSucChua.getSelectedIndex() == 1)
			sucChua = 10;
		else if (cmbSucChua.getSelectedIndex() == 2)
			sucChua = 20;
		listPhong = quanLyPhongDAO.timKiemPhong(-1, sucChua, "", loaiPhong);
		tblPhong.removeAll();
		tblPhong.setRowSelectionAllowed(false);
		tblmodelPhong.setRowCount(0);

		int stt = 1;
		for (PhongEntity phongEntity : listPhong)
			tblmodelPhong.addRow(new Object[] { stt++, phongEntity.getSoPhong(),
					phongEntity.getLoaiPhong().getTenLoaiPhong(), phongEntity.getSucChua() });
	}
}
