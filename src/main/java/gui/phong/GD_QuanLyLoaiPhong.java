package gui.phong;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Dao.PhongDao;
import Dao.Impl.PhongImpl;
import controller.QuanLyLoaiPhongController;
import entities.LoaiPhong;
import entities.NhanVienEntity;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;

public class GD_QuanLyLoaiPhong extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTenLoai;
	private JTextField txtMaLoaiPhong;

	private JTable tblLoaiPhong;
	private DefaultTableModel tblmodelLoaiPhong;
	private JScrollPane scrDanhSachLoaiPhong;

	private JLabel lblLoaiPhong;
	private JLabel lblMaLoaiPhong;
	private JLabel lblDanhSachLoaiPhong;
	private JLabel lblTenLoaiPhong;

	public JButton btnChinhSua;
	public JButton btnXoa;
	public JButton btnLamMoi;
	public JButton btnThoat;

	private List<LoaiPhong> listLoaiPhong;
	private QuanLyLoaiPhongController controller;
//	private QuanLyPhongDAO quanLyPhongDAO = new QuanLyPhongDAO();
	private PhongDao quanLyPhongDAO = new PhongImpl();
	private NhanVienEntity nhanVienEntity;

	/**
	 * Create the frame.
	 */
	public GD_QuanLyLoaiPhong(NhanVienEntity nhanVienEntity) {
		this.nhanVienEntity = nhanVienEntity;
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(GD_QuanLyLoaiPhong.class.getResource("/images/iconLogo.png")));
		setTitle("Quản lý loại phòng");
		setSize(700, 450);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblLoaiPhong = new JLabel("Thông tin loại phòng");
		lblLoaiPhong.setBounds(0, 0, 686, 60);
		lblLoaiPhong.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoaiPhong.setFont(new Font("Segoe UI", Font.BOLD, 22));
		contentPane.add(lblLoaiPhong);

		lblMaLoaiPhong = new JLabel("Mã loại phòng:");
		lblMaLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaLoaiPhong.setBounds(11, 60, 110, 30);
		contentPane.add(lblMaLoaiPhong);

		lblTenLoaiPhong = new JLabel("Tên loại phòng:");
		lblTenLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTenLoaiPhong.setBounds(343, 60, 119, 30);
		contentPane.add(lblTenLoaiPhong);

		txtTenLoai = new JTextField();
		txtTenLoai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTenLoai.setColumns(10);
		txtTenLoai.setBounds(473, 60, 200, 30);
		contentPane.add(txtTenLoai);

		txtMaLoaiPhong = new JTextField();
		txtMaLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaLoaiPhong.setColumns(10);
		txtMaLoaiPhong.setBounds(132, 60, 200, 30);
		contentPane.add(txtMaLoaiPhong);

		lblDanhSachLoaiPhong = new JLabel("Danh sách loại phòng");
		lblDanhSachLoaiPhong.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSachLoaiPhong.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDanhSachLoaiPhong.setBounds(0, 167, 686, 40);
		contentPane.add(lblDanhSachLoaiPhong);

		btnChinhSua = new JButton("Chỉnh sửa");
		btnChinhSua.setIcon(new ImageIcon(GD_QuanLyLoaiPhong.class.getResource("/images/iconChinhSua1.png")));
		btnChinhSua.setForeground(Color.BLACK);
		btnChinhSua.setFont(new Font("Cambria", Font.BOLD, 14));
		btnChinhSua.setFocusPainted(false);
		btnChinhSua.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnChinhSua.setBackground(new Color(152, 251, 152));
		btnChinhSua.setBounds(208, 110, 110, 30);
		contentPane.add(btnChinhSua);

		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(GD_QuanLyLoaiPhong.class.getResource("/images/iconXoa.png")));
		btnXoa.setForeground(Color.BLACK);
		btnXoa.setFont(new Font("Cambria", Font.BOLD, 14));
		btnXoa.setFocusPainted(false);
		btnXoa.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXoa.setBackground(new Color(152, 251, 152));
		btnXoa.setBounds(49, 110, 110, 30);
		contentPane.add(btnXoa);

		String[] colsPhong = { "STT", "Mã loại phòng", "Tên loại" };
		tblmodelLoaiPhong = new DefaultTableModel(colsPhong, 0);
		tblLoaiPhong = new JTable(tblmodelLoaiPhong);
		scrDanhSachLoaiPhong = new JScrollPane(tblLoaiPhong);
		scrDanhSachLoaiPhong.setBounds(10, 210, 666, 193);
		contentPane.add(scrDanhSachLoaiPhong);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblLoaiPhong.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblLoaiPhong.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tblLoaiPhong.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(GD_QuanLyLoaiPhong.class.getResource("/images/iconLamMoi.png")));
		btnLamMoi.setForeground(Color.BLACK);
		btnLamMoi.setFont(new Font("Cambria", Font.BOLD, 14));
		btnLamMoi.setFocusPainted(false);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setBackground(new Color(152, 251, 152));
		btnLamMoi.setBounds(367, 110, 110, 30);
		contentPane.add(btnLamMoi);

		btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon(GD_QuanLyLoaiPhong.class.getResource("/images/iconDangXuat.png")));
		btnThoat.setForeground(Color.BLACK);
		btnThoat.setFont(new Font("Cambria", Font.BOLD, 14));
		btnThoat.setFocusPainted(false);
		btnThoat.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThoat.setBackground(new Color(152, 251, 152));
		btnThoat.setBounds(526, 110, 110, 30);
		contentPane.add(btnThoat);

		controller = new QuanLyLoaiPhongController(this);
		tblLoaiPhong.addMouseListener(controller);
		btnChinhSua.addActionListener(controller);
		btnLamMoi.addActionListener(controller);
		btnXoa.addActionListener(controller);
		btnThoat.addActionListener(controller);
		loadData();
		kiemTraQuyen();
	}

	private void loadData() {
		tblLoaiPhong.removeAll();
		tblLoaiPhong.setRowSelectionAllowed(false);
		tblmodelLoaiPhong.setRowCount(0);
		listLoaiPhong = quanLyPhongDAO.duyetDanhSachLoaiPhong();

		int stt = 1;
		for (LoaiPhong loaiPhong : listLoaiPhong) {
			tblmodelLoaiPhong.addRow(new Object[] { stt++, loaiPhong.getMaLoai(), loaiPhong.getTenLoaiPhong() });
		}
	}

	public void hienThiThongTin() {
		listLoaiPhong = quanLyPhongDAO.duyetDanhSachLoaiPhong();
		int row = tblLoaiPhong.getSelectedRow();
		if (row >= 0) {
			txtMaLoaiPhong.setText(listLoaiPhong.get(row).getMaLoai());
			txtTenLoai.setText(listLoaiPhong.get(row).getTenLoaiPhong());
		}
	}

	public void chonChinhSua() {
		int row = tblLoaiPhong.getSelectedRow();
		if (row >= 0) {
			if (kiemTraDuLieuChinhSua()) {
				String maLoaiPhong = txtMaLoaiPhong.getText();
				String tenLoai = txtTenLoai.getText();
				LoaiPhong loaiPhong = new LoaiPhong(maLoaiPhong, tenLoai);
				if (quanLyPhongDAO.chinhSuaLoaiPhong(loaiPhong)) {
					JOptionPane.showMessageDialog(this, "Chỉnh sửa thông tin thành công");
					chonLamMoi();
				} else {
					JOptionPane.showMessageDialog(this, "Chỉnh sửa thông tin thất bại");
					return;
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Hãy chọn phòng cần chỉnh sửa");
			return;
		}
	}

	public void chonXoa() {
		int row = tblLoaiPhong.getSelectedRow();
		if (row >= 0) {
			if (quanLyPhongDAO.xoaLoaiPhong(txtMaLoaiPhong.getText())) {
				tblmodelLoaiPhong.removeRow(row);
				JOptionPane.showMessageDialog(this, "Xóa phòng thành công", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				chonLamMoi();
				loadData();
			}
		} else {
			JOptionPane.showMessageDialog(this, "Hãy chọn phòng cần xóa");
			return;
		}
	}

	public void chonLamMoi() {
		txtMaLoaiPhong.setText("");
		txtTenLoai.setText("");
		loadData();
	}

	public void chonThoat() {
		this.dispose();
	}

	private boolean kiemTraDuLieuChinhSua() {
		listLoaiPhong = quanLyPhongDAO.duyetDanhSachLoaiPhong();
		if (txtTenLoai.getText().trim().length() > 0) {
			if (listLoaiPhong.contains(new LoaiPhong("", txtTenLoai.getText()))) {
				JOptionPane.showMessageDialog(this, "Tên loại phòng đã có trong hệ thống", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtTenLoai.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Tên loại phòng không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtTenLoai.requestFocus();
			return false;
		}
		return true;
	}

	private void kiemTraQuyen() {
		if (nhanVienEntity.getChucVu().equalsIgnoreCase("Quản lí")) {
			btnChinhSua.setEnabled(true);
			btnXoa.setEnabled(true);
		} else {
			btnChinhSua.setEnabled(false);
			btnXoa.setEnabled(false);
		}
	}
}
