package gui.datPhong;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Dao.HoaDonDao;
import Dao.KhachHangDao;
import Dao.PhieuDatPhongDao;
import Dao.Impl.HoaDonImpl;
import Dao.Impl.KhachHangImpl;
import Dao.Impl.PhieuDatPhongImpl;
import controller.XemDanhSachDatTruocController;

import entities.ChiTietDatPhongEntity;
import entities.ChiTietPhieuDatPhongEntity;
import entities.KhachHangEntity;
import entities.PhieuDatPhongEntity;
import util.DateFormatter;
import util.SendData;
import util.TimeFormatter;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Rectangle;
import java.rmi.RemoteException;
import java.util.List;
import java.awt.Dimension;
import java.awt.Insets;

public class GD_XemChiTietDatPhongTruoc extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tblDanhSachDatPhong;
	private DefaultTableModel tblmodelDanhSachDatPhong;
	private JTextField txtSoPhong;
	private JTextField txtKhachHang;
	public JButton btnTimKiem;
	public JButton btnThoat;
	public JButton btnChon;
	public JButton btnLamMoi;

	private List<ChiTietPhieuDatPhongEntity> listChiTietPhieuDatPhong;
	private List<KhachHangEntity> listKhachHang;
	private List<ChiTietDatPhongEntity> listChiTietDatPhong;
	private List<PhieuDatPhongEntity> listPhieuDatPhong;

//	private QuanLyKhachHangDAO quanLyKhachHangDAO = new QuanLyKhachHangDAO();
	private KhachHangDao quanLyKhachHangDAO = new KhachHangImpl();
//	private QuanLyHoaDonDAO quanLyHoaDonDAO = new QuanLyHoaDonDAO();
	private HoaDonDao quanLyHoaDonDAO = new HoaDonImpl();
//	private QuanLyPhieuDatPhongDAO quanLyPhieuDatPhongDAO = new QuanLyPhieuDatPhongDAO();
	private PhieuDatPhongDao quanLyPhieuDatPhongDAO = new PhieuDatPhongImpl();
	private SendData<ChiTietPhieuDatPhongEntity> send;

	/**
	 * Create the dialog.
	 * @throws RemoteException 
	 */
	public GD_XemChiTietDatPhongTruoc(SendData<ChiTietPhieuDatPhongEntity> e) throws RemoteException {
		this.send = e;
		setTitle("Xem danh sách đặt trước");
		setBounds(100, 100, 673, 467);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));

		JPanel pnlDanhSach = new JPanel();
		contentPanel.add(pnlDanhSach);
		pnlDanhSach.setLayout(new BorderLayout(0, 0));

		String[] cols = { "STT", "Mã đặt phòng", "Số phòng", "Khách hàng", "Ngày nhận phòng", "Giờ nhận phòng",
				"Giờ trả phòng" };
		tblmodelDanhSachDatPhong = new DefaultTableModel(cols, 0);
		tblDanhSachDatPhong = new JTable(tblmodelDanhSachDatPhong);
		tblDanhSachDatPhong.setAutoCreateRowSorter(true);
		JScrollPane scrDanhSach = new JScrollPane(tblDanhSachDatPhong);
		pnlDanhSach.add(scrDanhSach, BorderLayout.CENTER);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblDanhSachDatPhong.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblDanhSachDatPhong.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tblDanhSachDatPhong.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tblDanhSachDatPhong.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
		tblDanhSachDatPhong.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
		tblDanhSachDatPhong.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);

		JPanel panel = new JPanel();
		contentPanel.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lblTimTheoSoPhong = new JLabel("Tìm theo số phòng:");
		lblTimTheoSoPhong.setFont(new Font("Cambria", Font.PLAIN, 14));
		panel.add(lblTimTheoSoPhong);

		txtSoPhong = new JTextField();
		txtSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel.add(txtSoPhong);
		txtSoPhong.setColumns(10);

		JLabel lblTimTheoKhachHang = new JLabel("Tìm theo khách hàng:");
		lblTimTheoKhachHang.setFont(new Font("Cambria", Font.PLAIN, 14));
		panel.add(lblTimTheoKhachHang);

		txtKhachHang = new JTextField();
		txtKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel.add(txtKhachHang);
		txtKhachHang.setColumns(10);

		btnTimKiem = new JButton("");
		btnTimKiem.setSize(new Dimension(50, 9));
		btnTimKiem.setMargin(new Insets(2, 20, 2, 20));
		btnTimKiem.setMinimumSize(new Dimension(50, 9));
		btnTimKiem.setMaximumSize(new Dimension(50, 9));
		btnTimKiem.setBounds(new Rectangle(0, 0, 50, 0));
		btnTimKiem.setBackground(new Color(255, 128, 128));
		btnTimKiem.setFocusable(false);
		btnTimKiem.setIcon(new ImageIcon(GD_XemChiTietDatPhongTruoc.class.getResource("/images/iconTimKiem.png")));
		panel.add(btnTimKiem);

		btnLamMoi = new JButton("");
		btnLamMoi.setBackground(new Color(255, 128, 128));
		btnLamMoi.setIcon(new ImageIcon(GD_XemChiTietDatPhongTruoc.class.getResource("/images/iconLamMoi.png")));
		panel.add(btnLamMoi);

		JPanel buttonPane = new JPanel();
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		btnChon = new JButton("Chọn phòng");
		btnChon.setFont(new Font("Cambria", Font.PLAIN, 11));
		btnChon.setBackground(new Color(152, 251, 152));
		btnChon.setActionCommand("Cancel");
		buttonPane.add(btnChon);

		btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Cambria", Font.PLAIN, 11));
		btnThoat.setBackground(new Color(152, 251, 152));
		btnThoat.setActionCommand("Cancel");
		buttonPane.add(btnThoat);

		XemDanhSachDatTruocController controller = new XemDanhSachDatTruocController(this);
		btnThoat.addActionListener(controller);
		btnTimKiem.addActionListener(controller);
		btnChon.addActionListener(controller);
		btnLamMoi.addActionListener(controller);

		loadData();
	}

	private void loadData() throws RemoteException {
		tblDanhSachDatPhong.removeAll();
		tblDanhSachDatPhong.setRowSelectionAllowed(false);
		tblmodelDanhSachDatPhong.setRowCount(0);
		listChiTietPhieuDatPhong = quanLyPhieuDatPhongDAO.duyetChiTietPhieuDatPhongChuaThanhToan();
		listKhachHang = quanLyKhachHangDAO.duyetDanhSach();
		listChiTietDatPhong = quanLyHoaDonDAO.timChiTietDatPhongChuaThanhToan();
		listPhieuDatPhong = quanLyPhieuDatPhongDAO.duyetDanhSachPhieuDatPhongChuaThanhToan();

		int stt = 1;
		for (ChiTietPhieuDatPhongEntity chiTietPhieuDatPhongEntity : listChiTietPhieuDatPhong) {
//			PhieuDatPhongEntity phieuDatPhongEntity = timPhieuDatPhongTheoMa(listPhieuDatPhong,
//					chiTietPhieuDatPhongEntity.getMaPhieuDatPhong());
//			sửa
			PhieuDatPhongEntity phieuDatPhongEntity = timPhieuDatPhongTheoMa(listPhieuDatPhong,
					chiTietPhieuDatPhongEntity.getPhieuDatPhong().getMaPhieuDatPhong());
//			KhachHangEntity khachHangEntity = timKhachHangTheoMa(listKhachHang, phieuDatPhongEntity.getMaKhachHang());
			KhachHangEntity khachHangEntity = timKhachHangTheoMa(listKhachHang, phieuDatPhongEntity.getKhachHang().getMaKhachHang());
//			ChiTietDatPhongEntity chiTietDatPhongEntity = timChiTietDatPhongTheoMa(listChiTietDatPhong,
//					chiTietPhieuDatPhongEntity.getMaChiTietDatPhong());
//			sửa
			ChiTietDatPhongEntity chiTietDatPhongEntity = timChiTietDatPhongTheoMa(listChiTietDatPhong,
					chiTietPhieuDatPhongEntity.getChiTietDatPhong().getMaChiTietDatPhong());

			tblmodelDanhSachDatPhong
					.addRow(new Object[] { stt++, chiTietPhieuDatPhongEntity.getMaChiTietPhieuDatPhong(),
							chiTietDatPhongEntity.getPhong().getSoPhong(), khachHangEntity.getHoTen(),
							DateFormatter.format(chiTietDatPhongEntity.getNgayNhanPhong()),
							TimeFormatter.format(chiTietDatPhongEntity.getGioNhanPhong()),
							TimeFormatter.format(chiTietDatPhongEntity.getGioTraPhong()) });
		}
	}

	public void chonTimKiem() {
		if (kiemTraDuLieuTim()) {
			String soPhong = txtSoPhong.getText().trim();
			String tenKhachHang = txtKhachHang.getText().trim();

			tblDanhSachDatPhong.removeAll();
			tblDanhSachDatPhong.setRowSelectionAllowed(false);
			tblmodelDanhSachDatPhong.setRowCount(0);

			int stt = 1;
			for (ChiTietPhieuDatPhongEntity chiTietPhieuDatPhongEntity : listChiTietPhieuDatPhong) {
//				PhieuDatPhongEntity phieuDatPhongEntity = timPhieuDatPhongTheoMa(listPhieuDatPhong,
//						chiTietPhieuDatPhongEntity.getMaPhieuDatPhong());
//				sửa
				PhieuDatPhongEntity phieuDatPhongEntity = timPhieuDatPhongTheoMa(listPhieuDatPhong,
						chiTietPhieuDatPhongEntity.getPhieuDatPhong().getMaPhieuDatPhong());
//				KhachHangEntity khachHangEntity = timKhachHangTheoMa(listKhachHang,
//						phieuDatPhongEntity.getMaKhachHang());
//				sửa
				KhachHangEntity khachHangEntity = timKhachHangTheoMa(listKhachHang,
						phieuDatPhongEntity.getKhachHang().getMaKhachHang());
//				ChiTietDatPhongEntity chiTietDatPhongEntity = timChiTietDatPhongTheoMa(listChiTietDatPhong,
//						chiTietPhieuDatPhongEntity.getMaChiTietDatPhong());
//				sửa
				ChiTietDatPhongEntity chiTietDatPhongEntity = timChiTietDatPhongTheoMa(listChiTietDatPhong,
						chiTietPhieuDatPhongEntity.getChiTietDatPhong().getMaChiTietDatPhong());

				if (String.valueOf(chiTietDatPhongEntity.getPhong().getSoPhong()).contains(soPhong)
						&& khachHangEntity.getHoTen().toLowerCase().contains(tenKhachHang.toLowerCase())) {
					tblmodelDanhSachDatPhong
							.addRow(new Object[] { stt++, chiTietPhieuDatPhongEntity.getMaChiTietPhieuDatPhong(),
									chiTietDatPhongEntity.getPhong().getSoPhong(), khachHangEntity.getHoTen(),
									DateFormatter.format(chiTietDatPhongEntity.getNgayNhanPhong()),
									TimeFormatter.format(chiTietDatPhongEntity.getGioNhanPhong()),
									TimeFormatter.format(chiTietDatPhongEntity.getGioTraPhong()) });
				}
			}
		}
	}

	public void chonLamMoi() throws RemoteException {
		txtSoPhong.setText("");
		txtKhachHang.setText("");
		loadData();
	}

	public void chonThoat() {
		if (JOptionPane.showConfirmDialog(this, "Xác nhận thoát?", "Thông báo",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			this.dispose();
		}
	}

	public void chonPhieu() {
		int row = tblDanhSachDatPhong.getSelectedRow();
		if (row >= 0) {
			ChiTietPhieuDatPhongEntity chiTietPhieuDatPhongEntity = timChiTietPhieuDatPhongTheoMa(
					listChiTietPhieuDatPhong, tblDanhSachDatPhong.getValueAt(row, 1).toString());
			send.send(chiTietPhieuDatPhongEntity);
			this.dispose();
		}
	}

	private boolean kiemTraDuLieuTim() {
		if (txtSoPhong.getText().trim().length() > 0) {
			try {
				int soPhong = Integer.parseInt(txtSoPhong.getText().trim());
				if (soPhong < 0) {
					JOptionPane.showMessageDialog(this, "Số phòng không được âm");
					txtSoPhong.requestFocus();
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Số phòng phải nhập số");
				txtSoPhong.requestFocus();
				return false;
			}
		}
		if (txtSoPhong.getText().trim().length() <= 0 && txtKhachHang.getText().trim().length() <= 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin cần tìm");
			return false;
		}
		return true;
	}

	private KhachHangEntity timKhachHangTheoMa(List<KhachHangEntity> list, String maKhachHang) {
		return list.stream().filter(khachHang -> khachHang.getMaKhachHang().equals(maKhachHang)).findFirst().get();
	}

	private PhieuDatPhongEntity timPhieuDatPhongTheoMa(List<PhieuDatPhongEntity> list, String maPhieuDatPhong) {
		return list.stream().filter(phieuDatPhong -> phieuDatPhong.getMaPhieuDatPhong().equals(maPhieuDatPhong))
				.findFirst().get();
	}

	private ChiTietDatPhongEntity timChiTietDatPhongTheoMa(List<ChiTietDatPhongEntity> list, String maChiTietDatPhong) {
		return list.stream().filter(chiTietDatPhong -> chiTietDatPhong.getMaChiTietDatPhong().equals(maChiTietDatPhong))
				.findFirst().get();
	}

	private ChiTietPhieuDatPhongEntity timChiTietPhieuDatPhongTheoMa(List<ChiTietPhieuDatPhongEntity> list,
			String maChiTietPhieuDatPhong) {
		return list.stream().filter(
				chiTietPhieuDatPhong -> chiTietPhieuDatPhong.getMaChiTietPhieuDatPhong().equals(maChiTietPhieuDatPhong))
				.findFirst().get();
	}
}
