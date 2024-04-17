package gui.dichVu;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.rmi.RemoteException;
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

import Dao.DichVuDao;
import Dao.Impl.DichVuImpl;
import controller.QuanLyDichVuController;
import entities.DichVuEntity;
import entities.LoaiDichVu;
import entities.NhanVienEntity;
import util.MoneyFormatter;

import javax.swing.border.TitledBorder;

public class GD_QuanLyDichVu extends JPanel {

	private static final long serialVersionUID = 1L;
	// JPanel
	private JPanel pnlThongTin;
	private JPanel pnlChucNang;
	private JPanel pnlTimKiem;
	// JTable
	private JTable tblDichVu;

	// JTextField
	private JTextField txtMaDV;
	private JTextField txtTenDV;
	private JTextField txtGia;
	private JTextField txtGiaDen;
	private JTextField txtGiaDichVuTu;

	// JLabel
	private JLabel lblQuanLiDichVu;
	private JLabel lblMaDichVu;
	private JLabel lblLoaiDichVu;
	private JLabel lblLoaiDV;
	private JLabel lblGia;
	private JLabel lblGiaDen;
	private JLabel lblGiaDichVu;
	private JLabel lblLoaiDVTimKiem;

	// JComboBox
	public JComboBox<String> cmbLoaiDV;
	private JComboBox<String> cmbLoaiDVTimKiem;
	private DefaultComboBoxModel<String> cmbmodelLoaiDV;
	private DefaultComboBoxModel<String> cmbmodelLoaiDVTimKiem;
	public JComboBox<String> cmbMaLoaiDichVu;
	public DefaultComboBoxModel<String> cmbmodelMaLoaiDichVu;

	// JScrollPane
	private JScrollPane scrQLDV;

	// DefaultTableModel
	private DefaultTableModel tblmodelDichVu;
	private NhanVienEntity nhanVienEntity;
	private JPanel pnlDichVu;
	private JPanel pnlLoaiDichVu;
	private JTextField txtTenLoaiDichVu;
	private JLabel lblTnLoiDch;
	private JLabel lblLoaiDichVu_2;
	private JPanel panel;

	public JButton btnThemLoaiDichVu;
	public JButton btnXemLoaiDichVu;
	public JButton btnThemDichVu;
	public JButton btnTimKiem;
	public JButton btnLamMoi;
	public JButton btnXoaDichVu;
	public JButton btnChinhSuaDichVu;

	private List<DichVuEntity> listDichVu;
	private List<LoaiDichVu> listLoaiDichVu;
	private QuanLyDichVuController controller;
//	private QuanLyDichVuDAO quanLyDichVuDAO = new QuanLyDichVuDAO();
	private DichVuDao quanLyDichVuDAO = new DichVuImpl();

	public GD_QuanLyDichVu(NhanVienEntity nhanVienEntity) throws RemoteException {
		this.nhanVienEntity = nhanVienEntity;
		setBounds(0, 0, 1365, 694);
		setLayout(null);

		pnlThongTin = new JPanel();
		pnlThongTin.setBackground(new Color(230, 230, 250));
		pnlThongTin.setBounds(0, 142, 1365, 251);
		add(pnlThongTin);
		pnlThongTin.setLayout(null);

		lblQuanLiDichVu = new JLabel("Thông tin Dịch vụ");
		lblQuanLiDichVu.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuanLiDichVu.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblQuanLiDichVu.setBounds(0, 11, 1356, 40);
		pnlThongTin.add(lblQuanLiDichVu);

		String[] cols_loaiDv = { "" };
		cmbmodelLoaiDV = new DefaultComboBoxModel<>(cols_loaiDv);

		pnlChucNang = new JPanel();
		pnlChucNang.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pnlChucNang.setBackground(new Color(230, 230, 250));
		pnlChucNang.setBounds(0, 393, 1365, 301);
		add(pnlChucNang);
		pnlChucNang.setLayout(null);

		String[] cols_QLDV = { "STT", "Mã Dịch Vụ", "Tên Dịch Vụ", "Loại Dịch Vụ", "Giá" };
		tblmodelDichVu = new DefaultTableModel(cols_QLDV, 0);
		tblDichVu = new JTable(tblmodelDichVu);
		tblDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrQLDV = new JScrollPane(tblDichVu);
		scrQLDV.setBounds(30, 65, 1305, 225);
		pnlChucNang.add(scrQLDV);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblDichVu.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblDichVu.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tblDichVu.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);

		JLabel lblDanhSchDch = new JLabel("Danh sách dịch vụ");
		lblDanhSchDch.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSchDch.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDanhSchDch.setBounds(0, 10, 1356, 40);
		pnlChucNang.add(lblDanhSchDch);

		pnlTimKiem = new JPanel();
		pnlTimKiem.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		pnlTimKiem.setBackground(new Color(230, 230, 250));
		pnlTimKiem.setBounds(0, 0, 1365, 142);
		add(pnlTimKiem);
		pnlTimKiem.setLayout(null);

		lblLoaiDVTimKiem = new JLabel("Loại Dịch Vụ :");
		lblLoaiDVTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLoaiDVTimKiem.setBounds(66, 34, 114, 30);
		pnlTimKiem.add(lblLoaiDVTimKiem);

		String[] cols_LoaiDVTimKiem = { "" };
		cmbmodelLoaiDVTimKiem = new DefaultComboBoxModel<>(cols_LoaiDVTimKiem);

		panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(38, 11, 1299, 71);
		pnlTimKiem.add(panel);
		panel.setLayout(null);

		lblGia = new JLabel("Giá dịch vụ từ:");
		lblGia.setBounds(480, 23, 114, 30);
		panel.add(lblGia);
		lblGia.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtGiaDichVuTu = new JTextField();
		txtGiaDichVuTu.setBounds(588, 22, 290, 33);
		panel.add(txtGiaDichVuTu);
		txtGiaDichVuTu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGiaDichVuTu.setColumns(10);

		lblGiaDen = new JLabel("Đến:");
		lblGiaDen.setBounds(936, 23, 34, 30);
		panel.add(lblGiaDen);
		lblGiaDen.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtGiaDen = new JTextField();
		txtGiaDen.setBounds(980, 22, 290, 33);
		panel.add(txtGiaDen);
		txtGiaDen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGiaDen.setColumns(10);
		cmbLoaiDVTimKiem = new JComboBox<String>(cmbmodelLoaiDVTimKiem);
		cmbLoaiDVTimKiem.setBounds(142, 22, 290, 33);
		panel.add(cmbLoaiDVTimKiem);
		cmbLoaiDVTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setIcon(new ImageIcon(GD_QuanLyDichVu.class.getResource("/images/iconTimKiem.png")));
		btnTimKiem.setForeground(Color.BLACK);
		btnTimKiem.setFont(new Font("Cambria", Font.BOLD, 14));
		btnTimKiem.setFocusPainted(false);
		btnTimKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiem.setBackground(new Color(152, 251, 152));
		btnTimKiem.setBounds(1187, 92, 150, 35);
		pnlTimKiem.add(btnTimKiem);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(GD_QuanLyDichVu.class.getResource("/images/iconLamMoi.png")));
		btnLamMoi.setForeground(Color.BLACK);
		btnLamMoi.setFont(new Font("Cambria", Font.BOLD, 14));
		btnLamMoi.setFocusPainted(false);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setBackground(new Color(152, 251, 152));
		btnLamMoi.setBounds(976, 92, 150, 35);
		pnlTimKiem.add(btnLamMoi);

		pnlDichVu = new JPanel();
		pnlDichVu.setBorder(
				new TitledBorder(null, "D\u1ECBch v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDichVu.setBackground(new Color(230, 230, 250));
		pnlDichVu.setBounds(35, 61, 764, 179);
		pnlThongTin.add(pnlDichVu);
		pnlDichVu.setLayout(null);

		lblMaDichVu = new JLabel("Mã Dịch Vụ : ");
		lblMaDichVu.setBounds(28, 35, 104, 30);
		pnlDichVu.add(lblMaDichVu);
		lblMaDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtMaDV = new JTextField();
		txtMaDV.setBounds(130, 34, 230, 33);
		pnlDichVu.add(txtMaDV);
		txtMaDV.setDisabledTextColor(Color.BLACK);
		txtMaDV.setForeground(Color.BLACK);
		txtMaDV.setBackground(Color.WHITE);
		txtMaDV.setEnabled(false);
		txtMaDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaDV.setColumns(10);

		lblLoaiDV = new JLabel("Loại Dịch Vụ :");
		lblLoaiDV.setBounds(28, 91, 104, 30);
		pnlDichVu.add(lblLoaiDV);
		lblLoaiDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbLoaiDV = new JComboBox<String>(cmbmodelLoaiDV);
		cmbLoaiDV.setBounds(130, 90, 233, 33);
		pnlDichVu.add(cmbLoaiDV);
		cmbLoaiDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		lblLoaiDichVu = new JLabel("Tên Dịch Vụ :");
		lblLoaiDichVu.setBounds(390, 35, 104, 30);
		pnlDichVu.add(lblLoaiDichVu);
		lblLoaiDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtGia = new JTextField();
		txtGia.setBounds(500, 90, 230, 33);
		pnlDichVu.add(txtGia);
		txtGia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGia.setColumns(10);

		txtTenDV = new JTextField();
		txtTenDV.setBounds(500, 34, 230, 33);
		pnlDichVu.add(txtTenDV);
		txtTenDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTenDV.setColumns(10);

		lblGiaDichVu = new JLabel("Giá Dịch vụ:");
		lblGiaDichVu.setBounds(390, 91, 104, 30);
		pnlDichVu.add(lblGiaDichVu);
		lblGiaDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		btnThemDichVu = new JButton("Thêm dịch vụ");
		btnThemDichVu.setBounds(73, 134, 150, 35);
		pnlDichVu.add(btnThemDichVu);
		btnThemDichVu.setIcon(new ImageIcon(GD_QuanLyDichVu.class.getResource("/images/iconThem.png")));
		btnThemDichVu.setForeground(Color.BLACK);
		btnThemDichVu.setFont(new Font("Cambria", Font.BOLD, 14));
		btnThemDichVu.setFocusPainted(false);
		btnThemDichVu.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThemDichVu.setBackground(new Color(152, 251, 152));

		btnXoaDichVu = new JButton("Xóa dịch vụ");
		btnXoaDichVu.setBounds(296, 133, 150, 35);
		pnlDichVu.add(btnXoaDichVu);
		btnXoaDichVu.setIcon(new ImageIcon(GD_QuanLyDichVu.class.getResource("/images/iconXoa.png")));
		btnXoaDichVu.setForeground(Color.BLACK);
		btnXoaDichVu.setFont(new Font("Cambria", Font.BOLD, 14));
		btnXoaDichVu.setFocusPainted(false);
		btnXoaDichVu.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXoaDichVu.setBackground(new Color(152, 251, 152));

		btnChinhSuaDichVu = new JButton("Chỉnh sửa dịch vụ");
		btnChinhSuaDichVu.setBounds(519, 134, 170, 35);
		pnlDichVu.add(btnChinhSuaDichVu);
		btnChinhSuaDichVu.setIcon(new ImageIcon(GD_QuanLyDichVu.class.getResource("/images/iconChinhSua1.png")));
		btnChinhSuaDichVu.setForeground(Color.BLACK);
		btnChinhSuaDichVu.setFont(new Font("Cambria", Font.BOLD, 14));
		btnChinhSuaDichVu.setFocusPainted(false);
		btnChinhSuaDichVu.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnChinhSuaDichVu.setBackground(new Color(152, 251, 152));

		pnlLoaiDichVu = new JPanel();
		pnlLoaiDichVu.setBorder(new TitledBorder(null, "Lo\u1EA1i d\u1ECBch v\u1EE5", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pnlLoaiDichVu.setBackground(new Color(230, 230, 250));
		pnlLoaiDichVu.setBounds(830, 62, 509, 179);
		pnlThongTin.add(pnlLoaiDichVu);
		pnlLoaiDichVu.setLayout(null);

		txtTenLoaiDichVu = new JTextField();
		txtTenLoaiDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTenLoaiDichVu.setColumns(10);
		txtTenLoaiDichVu.setBounds(163, 88, 295, 33);
		pnlLoaiDichVu.add(txtTenLoaiDichVu);

		lblTnLoiDch = new JLabel("Tên loại dịch vụ:");
		lblTnLoiDch.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTnLoiDch.setBounds(28, 89, 115, 30);
		pnlLoaiDichVu.add(lblTnLoiDch);

		lblLoaiDichVu_2 = new JLabel("Mã loại dịch vụ:");
		lblLoaiDichVu_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLoaiDichVu_2.setBounds(28, 35, 110, 30);
		pnlLoaiDichVu.add(lblLoaiDichVu_2);

		btnThemLoaiDichVu = new JButton("Thêm");
		btnThemLoaiDichVu.setIcon(new ImageIcon(GD_QuanLyDichVu.class.getResource("/images/iconThem2.png")));
		btnThemLoaiDichVu.setForeground(Color.BLACK);
		btnThemLoaiDichVu.setFont(new Font("Cambria", Font.BOLD, 13));
		btnThemLoaiDichVu.setFocusPainted(false);
		btnThemLoaiDichVu.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThemLoaiDichVu.setBackground(new Color(255, 128, 128));
		btnThemLoaiDichVu.setBounds(150, 132, 110, 30);
		pnlLoaiDichVu.add(btnThemLoaiDichVu);

		btnXemLoaiDichVu = new JButton("Xem loại dịch vụ");
		btnXemLoaiDichVu.setIcon(new ImageIcon(GD_QuanLyDichVu.class.getResource("/images/iconMatMo.png")));
		btnXemLoaiDichVu.setForeground(Color.BLACK);
		btnXemLoaiDichVu.setFont(new Font("Cambria", Font.BOLD, 13));
		btnXemLoaiDichVu.setFocusPainted(false);
		btnXemLoaiDichVu.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXemLoaiDichVu.setBackground(new Color(255, 128, 128));
		btnXemLoaiDichVu.setBounds(298, 132, 160, 30);
		pnlLoaiDichVu.add(btnXemLoaiDichVu);

		cmbmodelMaLoaiDichVu = new DefaultComboBoxModel<String>();
		cmbMaLoaiDichVu = new JComboBox<String>(cmbmodelMaLoaiDichVu);
		cmbMaLoaiDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbMaLoaiDichVu.setBounds(163, 35, 295, 33);
		pnlLoaiDichVu.add(cmbMaLoaiDichVu);

		controller = new QuanLyDichVuController(this);
		tblDichVu.addMouseListener(controller);
		btnLamMoi.addActionListener(controller);
		btnTimKiem.addActionListener(controller);
		btnThemDichVu.addActionListener(controller);
		btnXoaDichVu.addActionListener(controller);
		btnThemLoaiDichVu.addActionListener(controller);
		btnXemLoaiDichVu.addActionListener(controller);
		cmbMaLoaiDichVu.addActionListener(controller);
		btnChinhSuaDichVu.addActionListener(controller);
		loadCmbLoaiDichVu();
		loadCmbMaLoaiDichVu();
		loadCmbLoaiDichVuTimKiem();
		loadData();
//		kiemTraQuyen();
	}

	/***** loadData 
	 * @throws RemoteException *****/
	private void loadData() throws RemoteException {
		tblDichVu.removeAll();
		tblDichVu.setRowSelectionAllowed(false);
		tblmodelDichVu.setRowCount(0);
		listDichVu = quanLyDichVuDAO.duyetDanhSach();

		int stt = 1;
		for (DichVuEntity dichVuEntity : listDichVu) {
			tblmodelDichVu.addRow(new Object[] { stt++, dichVuEntity.getMaDichVu(), dichVuEntity.getTenDichVu(),
					dichVuEntity.getLoaiDichVu().getTenLoaiDichVu(), dichVuEntity.getGia() });
		}
	}

	/***** HIỂN THỊ THÔNG TIN 
	 * @throws RemoteException *****/
	public void hienThiThongTin() throws RemoteException {
		listDichVu = quanLyDichVuDAO.duyetDanhSach();
		int row = tblDichVu.getSelectedRow();
		if (row >= 0) {
			txtMaDV.setText(listDichVu.get(row).getMaDichVu());
			txtTenDV.setText(listDichVu.get(row).getTenDichVu());
			cmbLoaiDV.setSelectedItem(tblDichVu.getValueAt(row, 3));
			txtGia.setText(String.valueOf(tblDichVu.getValueAt(row, 4)));
			cmbMaLoaiDichVu.setSelectedItem(listDichVu.get(row).getLoaiDichVu().getMaLoaiDichVu());
			txtTenLoaiDichVu.setText(listDichVu.get(row).getLoaiDichVu().getTenLoaiDichVu());
		}
	}

	/***** THÊM DỊCH VỤ 
	 * @throws RemoteException *****/
	public void chonThemDichVu() throws RemoteException {
		if (kiemTraDuLieuThem()) {
			String tenDV = txtTenDV.getText().trim();
			String loaiDV = cmbLoaiDV.getSelectedItem().toString();
			double gia = Double.parseDouble(txtGia.getText());
			DichVuEntity dichVuEntity = new DichVuEntity(tenDV, quanLyDichVuDAO.timTheoTenLoaiDichVu(loaiDV), gia);
			if (quanLyDichVuDAO.them(dichVuEntity)) {
				JOptionPane.showMessageDialog(this, "Thêm dịch vụ thành công", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				chonLamMoi();
			} else {
				JOptionPane.showMessageDialog(this, "Thêm thất bại");
				return;
			}
		}
	}

	/***** THÊM LOẠI DỊCH VỤ 
	 * @throws RemoteException 
	 * @throws HeadlessException *****/
	public void chonThemLoaiDichVu() throws HeadlessException, RemoteException {
		if (kiemTraTenLoaiDichVu()) {
			String tenLoai = txtTenLoaiDichVu.getText();
			LoaiDichVu loaiDichVu = new LoaiDichVu(tenLoai);
			if (quanLyDichVuDAO.themLoaiDichVu(loaiDichVu)) {
				JOptionPane.showMessageDialog(this, "Thêm thành công");
				chonLamMoi();
			} else {
				JOptionPane.showMessageDialog(this, "Thêm thất bại");
				return;
			}
		}
	}

	/**** XÓA 
	 * @throws RemoteException 
	 * @throws HeadlessException *****/
	public void chonXoaDichVu() throws HeadlessException, RemoteException {
		int row = tblDichVu.getSelectedRow();
		if (row >= 0) {
			if (JOptionPane.showConfirmDialog(this, "Xác nhận xóa dịch vụ", "Thông báo",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				if (quanLyDichVuDAO.xoa(txtMaDV.getText())) {
					tblmodelDichVu.removeRow(row);
					JOptionPane.showMessageDialog(this, "Xóa dịch vụ thành công", "Thông Báo",
							JOptionPane.INFORMATION_MESSAGE);
					chonLamMoi();
					loadData();
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Chọn dịch vụ cần xóa");
		}
	}

	/**** CHỈNH SỬA 
	 * @throws RemoteException *****/
	public void chonChinhSuaDichVu() throws RemoteException {
		int row = tblDichVu.getSelectedRow();
		if (row >= 0) {
			if (kiemTraDuLieuChinhSua()) {
				if (JOptionPane.showConfirmDialog(this, "Xác nhận chỉnh sửa?", "Thông báo",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					String maDV = txtMaDV.getText().trim();
					String tenDV = txtTenDV.getText().trim();
					String loaiDV = cmbLoaiDV.getSelectedItem().toString();
					double gia = Double.parseDouble(txtGia.getText().trim());

					LoaiDichVu loaiDichVu = quanLyDichVuDAO.timTheoTenLoaiDichVu(loaiDV);
					DichVuEntity dichVuEntity = new DichVuEntity(maDV, tenDV, loaiDichVu, gia);
					if (quanLyDichVuDAO.chinhSua(dichVuEntity)) {
						JOptionPane.showMessageDialog(this, "Chỉnh sửa thông tin dịch vụ thành công", "Thông báo",
								JOptionPane.INFORMATION_MESSAGE);
						chonLamMoi();
					} else {
						JOptionPane.showMessageDialog(this, "Chỉnh sửa thông tin thất bại");
						return;
					}
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Chọn dịch vụ cần chỉnh sửa");
			return;
		}
	}

	/***** LÀM MỚI 
	 * @throws RemoteException *****/
	public void chonLamMoi() throws RemoteException {
		txtGia.setText("");
		txtGiaDen.setText("");
		txtGiaDichVuTu.setText("");
		txtMaDV.setText("");
		txtTenDV.setText("");
		txtTenLoaiDichVu.setText("");
		cmbLoaiDV.setSelectedIndex(0);
		cmbLoaiDVTimKiem.setSelectedIndex(0);
		cmbMaLoaiDichVu.setSelectedIndex(0);
		loadCmbLoaiDichVu();
		loadCmbMaLoaiDichVu();
		loadCmbLoaiDichVuTimKiem();
		loadData();
	}

	/**** XEM LOẠI DỊCH VỤ 
	 * @throws RemoteException *****/
	public void chonXemLoaiDichVu() throws RemoteException {
		new GD_QuanLyLoaiDichVu(nhanVienEntity).setVisible(true);
	}

	/**** TÌM KIẾM 
	 * @throws RemoteException *****/
	public void chonTimKiem() throws RemoteException {
		if (kiemTraDuLieuTim()) {
			String loaiDV = cmbLoaiDVTimKiem.getSelectedItem().toString().trim();
			Double giaTu = null;
			Double giaDen = null;
			if (!txtGiaDichVuTu.getText().trim().equals(""))
				giaTu = Double.valueOf(txtGiaDichVuTu.getText().trim());

			if (!txtGiaDen.getText().trim().equals(""))
				giaDen = Double.valueOf(txtGiaDen.getText().trim());

			tblDichVu.removeAll();
			tblmodelDichVu.setRowCount(0);
			listDichVu = quanLyDichVuDAO.timKiem(loaiDV, giaTu, giaDen);
			int stt = 1;
			for (DichVuEntity dichVuEntity : listDichVu) {
				tblmodelDichVu.addRow(new Object[] { stt++, dichVuEntity.getMaDichVu(), dichVuEntity.getTenDichVu(),
						dichVuEntity.getLoaiDichVu().getTenLoaiDichVu(),
						MoneyFormatter.format(dichVuEntity.getGia()) });
			}
		}
	}

	/**** HIỂN THỊ TÊN LOẠI DỊCH VỤ KHI CHỌN TRONG cmbMaLoaiDichVu 
	 * @throws RemoteException *****/
	public void hienThiTenLoaiDichVu() throws RemoteException {
		if (cmbMaLoaiDichVu.getSelectedIndex() > 0) {
			String maLoaiDichVu = cmbMaLoaiDichVu.getSelectedItem().toString();
			String tenLoai = quanLyDichVuDAO.timTheoMaLoaiDichVu(maLoaiDichVu).getTenLoaiDichVu();
			txtTenLoaiDichVu.setText(tenLoai);
		}
	}

	/**** loadCmbLoaiDichVu 
	 * @throws RemoteException *****/
	private void loadCmbLoaiDichVu() throws RemoteException {
		listLoaiDichVu = quanLyDichVuDAO.duyetDanhSachLoaiDichVu();
		cmbmodelLoaiDV.removeAllElements();
		cmbmodelLoaiDV.addElement("");
		for (LoaiDichVu loaiDichVu : listLoaiDichVu) {
			cmbmodelLoaiDV.addElement(loaiDichVu.getTenLoaiDichVu());
		}
	}

	/**** loadCmbMaLoaiDichVu 
	 * @throws RemoteException *****/
	private void loadCmbMaLoaiDichVu() throws RemoteException {
		listLoaiDichVu = quanLyDichVuDAO.duyetDanhSachLoaiDichVu();
		cmbmodelMaLoaiDichVu.removeAllElements();
		cmbmodelMaLoaiDichVu.addElement("");
		for (LoaiDichVu loaiDichVu : listLoaiDichVu) {
			cmbmodelMaLoaiDichVu.addElement(loaiDichVu.getMaLoaiDichVu());
		}
	}

	/**** loadCmbLoaiDichVuTimKiem 
	 * @throws RemoteException *****/
	private void loadCmbLoaiDichVuTimKiem() throws RemoteException {
		listLoaiDichVu = quanLyDichVuDAO.duyetDanhSachLoaiDichVu();
		cmbmodelLoaiDVTimKiem.removeAllElements();
		cmbmodelLoaiDVTimKiem.addElement("Tất cả");
		for (LoaiDichVu loaiDichVu : listLoaiDichVu) {
			cmbmodelLoaiDVTimKiem.addElement(loaiDichVu.getTenLoaiDichVu());
		}
	}

	/**
	 * KIỂM TRA DỮ LIỆU THÊM
	 * @throws RemoteException 
	 */
	private boolean kiemTraDuLieuThem() throws RemoteException {
		if (!kiemTraTenDichVuThem()) {
			return false;
		}
		if (!kiemTraLoaiDichVu()) {
			return false;
		}
		if (!kiemTraGiaDichVu()) {
			return false;
		}
		return true;
	}

	// kiểm tra tên loại dịch vu
	private boolean kiemTraTenLoaiDichVu() throws RemoteException {
		listLoaiDichVu = quanLyDichVuDAO.duyetDanhSachLoaiDichVu();
		if (txtTenLoaiDichVu.getText().trim().length() > 0) {
			if (listLoaiDichVu.contains(new LoaiDichVu("", txtTenLoaiDichVu.getText().trim()))) {
				JOptionPane.showMessageDialog(this, "Tên loại phòng đã có trong hệ thống", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtTenLoaiDichVu.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Tên loại phòng không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtTenLoaiDichVu.requestFocus();
			return false;
		}
		return true;
	}

	// kiểm tra giá dịch vụ
	private boolean kiemTraGiaDichVu() {
		if (txtGia.getText().trim().length() > 0) {
			try {
				Double giadv = Double.parseDouble(txtGia.getText().trim());
				if (!(giadv > 0)) {
					JOptionPane.showMessageDialog(this, "Giá dịch vụ phải lớn hơn 0", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					txtGia.requestFocus();
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Giá dịch vụ nhập vào là số", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtGia.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Giá dịch vụ không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtGia.requestFocus();
			return false;
		}
		return true;
	}

	// kiểm tra loại dịch vụ
	private boolean kiemTraLoaiDichVu() throws RemoteException {
		listDichVu = quanLyDichVuDAO.duyetDanhSach();
		if (cmbLoaiDV.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Hãy chọn loại dịch vụ ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			cmbLoaiDV.requestFocus();
			return false;
		}
		return true;
	}

	// kiểm tra tên dịch vụ
	private boolean kiemTraTenDichVuThem() throws RemoteException {
		String tenDV = txtTenDV.getText();
		listDichVu = quanLyDichVuDAO.duyetDanhSach();
		if (txtTenDV.getText().trim().length() > 0) {
			if (listDichVu.contains(new DichVuEntity("", tenDV, null, 0))) {
				JOptionPane.showMessageDialog(this, "Tên dịch vụ đã tồn tại trong hệ thống", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtTenDV.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Tên dịch vụ không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtTenDV.requestFocus();
			return false;
		}
		return true;
	}

	/**
	 * Kiểm tra dữ liệu chỉnh sửa
	 * @throws RemoteException 
	 */
	private boolean kiemTraDuLieuChinhSua() throws RemoteException {
		if (!kiemTraTenDichVuChinhSua()) {
			return false;
		}
		if (!kiemTraGiaDichVu()) {
			return false;
		}
		if (!kiemTraLoaiDichVu()) {
			return false;
		}
		return true;
	}

	// Kiểm tra tên dịch vụ
	private boolean kiemTraTenDichVuChinhSua() throws RemoteException {
		String tenDV = txtTenDV.getText();
		listDichVu = quanLyDichVuDAO.duyetDanhSach();
		if (txtTenDV.getText().trim().length() > 0) {
			if (!(tenDV == (listDichVu.get(tblDichVu.getSelectedRow()).getTenDichVu()))
					&& listDichVu.contains(new DichVuEntity("", tenDV, null, 0))) {
				JOptionPane.showMessageDialog(this, "Tên dịch vụ đã tồn tại trong hệ thống", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtTenDV.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Tên dịch vụ không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtTenDV.requestFocus();
			return false;
		}
		return true;
	}

	/**
	 * KIỂM TRA DỮ LIỆU TÌM
	 */
	private boolean kiemTraDuLieuTim() {
		if (txtGiaDichVuTu.getText().trim().length() > 0) {
			String giaTu = txtGiaDichVuTu.getText().trim();
			if (!giaTu.matches("[0-9]+")) {
				JOptionPane.showMessageDialog(this, "Giá tối thiểu nhập vào phải là số");
				txtGiaDichVuTu.requestFocus();
				return false;
			}

			if (Double.parseDouble(giaTu) <= 0) {
				JOptionPane.showMessageDialog(this, "Giá tổi thiểu nhập vào phải là số nguyên");
				txtGiaDichVuTu.requestFocus();
				return false;
			}

			if (txtGiaDen.getText().trim().length() > 0) {
				String giaDen = txtGiaDen.getText().trim();
				if (!giaDen.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(this, "Giá tối đa nhập vào phải là số");
					txtGiaDen.requestFocus();
					return false;
				}

				if (Double.parseDouble(giaDen) <= 0) {
					JOptionPane.showMessageDialog(this, "Giá tối đa  nhập vào phải là số nguyên");
					txtGiaDen.requestFocus();
					return false;
				}

				if (Double.parseDouble(giaDen) < Double.parseDouble(giaTu)) {
					JOptionPane.showMessageDialog(this, "Giá tối đa phải lớn hơn giá tối thiểu");
					txtGiaDen.requestFocus();
					return false;
				}
			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập giá tối đa");
				txtGiaDen.requestFocus();
				return false;
			}
		}
		return true;
	}

	/***** KIỂM TRA CHỨC VU *****/
//	private void kiemTraQuyen() {
//		if (nhanVienEntity.getChucVu().equalsIgnoreCase("Quản lí")) {
//			btnThemDichVu.setEnabled(true);
//			btnChinhSuaDichVu.setEnabled(true);
//			btnXoaDichVu.setEnabled(true);
//			btnThemLoaiDichVu.setEnabled(true);
//		} else {
//			btnThemDichVu.setEnabled(false);
//			btnChinhSuaDichVu.setEnabled(false);
//			btnXoaDichVu.setEnabled(false);
//			btnThemLoaiDichVu.setEnabled(false);
//		}
//	}
}
