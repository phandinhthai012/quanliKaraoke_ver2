package gui.dichVu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Dao.DichVuDao;
import Dao.Impl.DichVuImpl;
import controller.QuanLyLoaiDichVuController;
import entities.LoaiDichVu;
import entities.NhanVienEntity;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;

public class GD_QuanLyLoaiDichVu extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTenLoaiDichVu;
	private JTextField txtMaLoaiDichVu;
	private JTable tblLoaiDichVu;
	private DefaultTableModel tblmodelLoaiDichVu;
	private JScrollPane scrDanhSachLoaiDichVu;
	private JLabel lblLoaiDichVu;
	private JLabel lblMaLoaiDichVu;
	private JLabel lblDanhSachLoaiDichVu;
	private JLabel lblTenLoaiDichVu;
	public JButton btnChinhSua;
	public JButton btnXoa;
	public JButton btnLamMoi;
	public JButton btnThoat;

	private List<LoaiDichVu> listLoaiDichVu;
	private QuanLyLoaiDichVuController controller;
//	private QuanLyDichVuDAO quanLyDichVuDAO = new QuanLyDichVuDAO();
	private DichVuDao quanLyDichVuDAO = new DichVuImpl();
	private NhanVienEntity nhanVienEntity;

	/**
	 * Create the frame.
	 * @throws RemoteException 
	 */
	public GD_QuanLyLoaiDichVu(NhanVienEntity nhanVienEntity) throws RemoteException {
		this.nhanVienEntity = nhanVienEntity;
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(GD_QuanLyLoaiDichVu.class.getResource("/images/iconLogo.png")));
		setTitle("Quản lý loại Dịch vụ");
		setSize(700, 450);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblLoaiDichVu = new JLabel("Thông tin loại Dịch Vụ");
		lblLoaiDichVu.setBounds(0, 0, 686, 60);
		lblLoaiDichVu.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoaiDichVu.setFont(new Font("Segoe UI", Font.BOLD, 22));
		contentPane.add(lblLoaiDichVu);

		lblMaLoaiDichVu = new JLabel("Mã loại dịch vụ:");
		lblMaLoaiDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaLoaiDichVu.setBounds(11, 60, 110, 30);
		contentPane.add(lblMaLoaiDichVu);

		lblTenLoaiDichVu = new JLabel("Tên loại dịch vụ:");
		lblTenLoaiDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTenLoaiDichVu.setBounds(343, 60, 119, 30);
		contentPane.add(lblTenLoaiDichVu);

		txtTenLoaiDichVu = new JTextField();
		txtTenLoaiDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTenLoaiDichVu.setColumns(10);
		txtTenLoaiDichVu.setBounds(473, 60, 200, 30);
		contentPane.add(txtTenLoaiDichVu);

		txtMaLoaiDichVu = new JTextField();
		txtMaLoaiDichVu.setDisabledTextColor(Color.BLACK);
		txtMaLoaiDichVu.setBackground(Color.WHITE);
		txtMaLoaiDichVu.setEditable(false);
		txtMaLoaiDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaLoaiDichVu.setColumns(10);
		txtMaLoaiDichVu.setBounds(132, 60, 200, 30);
		contentPane.add(txtMaLoaiDichVu);

		lblDanhSachLoaiDichVu = new JLabel("Danh sách loại dịch vụ");
		lblDanhSachLoaiDichVu.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSachLoaiDichVu.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDanhSachLoaiDichVu.setBounds(0, 167, 686, 40);
		contentPane.add(lblDanhSachLoaiDichVu);

		btnChinhSua = new JButton("Chỉnh sửa");
		btnChinhSua.setIcon(new ImageIcon(GD_QuanLyLoaiDichVu.class.getResource("/images/iconChinhSua1.png")));
		btnChinhSua.setForeground(Color.BLACK);
		btnChinhSua.setFont(new Font("Cambria", Font.BOLD, 14));
		btnChinhSua.setFocusPainted(false);
		btnChinhSua.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnChinhSua.setBackground(new Color(152, 251, 152));
		btnChinhSua.setBounds(208, 110, 110, 30);
		contentPane.add(btnChinhSua);

		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(GD_QuanLyLoaiDichVu.class.getResource("/images/iconXoa.png")));
		btnXoa.setForeground(Color.BLACK);
		btnXoa.setFont(new Font("Cambria", Font.BOLD, 14));
		btnXoa.setFocusPainted(false);
		btnXoa.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXoa.setBackground(new Color(152, 251, 152));
		btnXoa.setBounds(49, 110, 110, 30);
		contentPane.add(btnXoa);

		String[] colsPhong = { "STT", "Mã loại dịch vụ", "Tên loại dịch vụ" };
		tblmodelLoaiDichVu = new DefaultTableModel(colsPhong, 0);
		tblLoaiDichVu = new JTable(tblmodelLoaiDichVu);
		scrDanhSachLoaiDichVu = new JScrollPane(tblLoaiDichVu);
		scrDanhSachLoaiDichVu.setBounds(10, 210, 666, 193);
		contentPane.add(scrDanhSachLoaiDichVu);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblLoaiDichVu.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblLoaiDichVu.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tblLoaiDichVu.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(GD_QuanLyLoaiDichVu.class.getResource("/images/iconLamMoi.png")));
		btnLamMoi.setForeground(Color.BLACK);
		btnLamMoi.setFont(new Font("Cambria", Font.BOLD, 14));
		btnLamMoi.setFocusPainted(false);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setBackground(new Color(152, 251, 152));
		btnLamMoi.setBounds(367, 110, 110, 30);
		contentPane.add(btnLamMoi);

		btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon(GD_QuanLyLoaiDichVu.class.getResource("/images/iconDangXuat.png")));
		btnThoat.setForeground(Color.BLACK);
		btnThoat.setFont(new Font("Cambria", Font.BOLD, 14));
		btnThoat.setFocusPainted(false);
		btnThoat.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThoat.setBackground(new Color(152, 251, 152));
		btnThoat.setBounds(526, 110, 110, 30);
		contentPane.add(btnThoat);

		controller = new QuanLyLoaiDichVuController(this);
		tblLoaiDichVu.addMouseListener(controller);
		btnChinhSua.addActionListener(controller);
		btnLamMoi.addActionListener(controller);
		btnXoa.addActionListener(controller);
		btnThoat.addActionListener(controller);
		loadData();
		kiemTraQuyen();
	}

	private void loadData() throws RemoteException {
		tblLoaiDichVu.removeAll();
		tblLoaiDichVu.setRowSelectionAllowed(false);
		tblmodelLoaiDichVu.setRowCount(0);
		listLoaiDichVu = quanLyDichVuDAO.duyetDanhSachLoaiDichVu();

		int stt = 1;
		for (LoaiDichVu loaiDichVu : listLoaiDichVu)
			tblmodelLoaiDichVu
					.addRow(new Object[] { stt++, loaiDichVu.getMaLoaiDichVu(), loaiDichVu.getTenLoaiDichVu() });

	}

	public void hienThiThongTin() throws RemoteException {
		listLoaiDichVu = quanLyDichVuDAO.duyetDanhSachLoaiDichVu();
		int row = tblLoaiDichVu.getSelectedRow();
		if (row >= 0) {
			txtMaLoaiDichVu.setText(listLoaiDichVu.get(row).getMaLoaiDichVu());
			txtTenLoaiDichVu.setText(listLoaiDichVu.get(row).getTenLoaiDichVu());
		}
	}

	public void chonChinhSua() throws  RemoteException {
		int row = tblLoaiDichVu.getSelectedRow();
		if (row >= 0) {
			if (kiemTraDuLieuChinhSua()) {
				if (JOptionPane.showConfirmDialog(this, "Xác nhận chỉnh sửa?", "Thông báo",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					String maLoaiDichVu = txtMaLoaiDichVu.getText();
					String tenLoaiDichVu = txtTenLoaiDichVu.getText();
					LoaiDichVu loaiDichVu = new LoaiDichVu(maLoaiDichVu, tenLoaiDichVu);
					if (quanLyDichVuDAO.chinhSuaLoaiDichVu(loaiDichVu)) {
						JOptionPane.showMessageDialog(this, "Chỉnh sửa thông tin thành công");
						chonLamMoi();
					} else {
						JOptionPane.showMessageDialog(this, "Chỉnh sửa thông tin thất bại");
						return;
					}
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Hãy chọn loại dịch vụ cần chỉnh sửa");
			return;
		}
	}

	public void chonXoa() throws HeadlessException, RemoteException {
		int row = tblLoaiDichVu.getSelectedRow();
		if (row >= 0) {
			if (JOptionPane.showConfirmDialog(this, "Xác nhận xóa?", "Thông báo",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				if (quanLyDichVuDAO.xoaLoaiDichVu(txtMaLoaiDichVu.getText())) {
					tblmodelLoaiDichVu.removeRow(row);
					JOptionPane.showMessageDialog(this, "Xóa loại dịch vụ thành công", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					chonLamMoi();
					loadData();
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Hãy chọn loại dịch vụ cần xóa");
			return;
		}
	}

	public void chonLamMoi() throws RemoteException {
		txtMaLoaiDichVu.setText("");
		txtTenLoaiDichVu.setText("");
		loadData();
	}

	public void chonThoat() {
		this.dispose();
	}

	private boolean kiemTraDuLieuChinhSua() throws RemoteException {
		listLoaiDichVu = quanLyDichVuDAO.duyetDanhSachLoaiDichVu();
		if (txtTenLoaiDichVu.getText().trim().length() > 0) {
			if (listLoaiDichVu.contains(new LoaiDichVu("", txtTenLoaiDichVu.getText()))) {
				JOptionPane.showMessageDialog(this, "Tên loại dịch vụ đã có trong hệ thống", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtTenLoaiDichVu.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Tên loại dịch vụ không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtTenLoaiDichVu.requestFocus();
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
