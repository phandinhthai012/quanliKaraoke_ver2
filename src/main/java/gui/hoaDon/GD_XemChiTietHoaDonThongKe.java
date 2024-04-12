package gui.hoaDon;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Dao.HoaDonDao;
import Dao.Impl.HoaDonImpl;
import controller.XemChiTietHoaDonController;
import entities.ChiTietDatPhongEntity;
import entities.ChiTietDichVuEntity;
import entities.ChiTietHoaDonEntity;
import entities.HoaDonEntity;
import util.MoneyFormatter;
import util.TimeFormatter;

public class GD_XemChiTietHoaDonThongKe extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel pnlContent;
	private JTable tblPhong;
	private JTable tblDichVu;

	private DefaultTableModel tblmodelPhong;
	private DefaultTableModel tblmodelDichVu;

	public JButton btnThoat;
	public JButton btnLamMoi;

	private HoaDonEntity hoaDonEntity;
	private JTextField txtSoPhong;

	private List<ChiTietHoaDonEntity> listChiTietHoaDon;
	private List<ChiTietDichVuEntity> listChiTietDichVu;

//	private QuanLyHoaDonDAO quanLyHoaDonDAO = new QuanLyHoaDonDAO();
	private HoaDonDao quanLyHoaDonDAO = new HoaDonImpl();

	/**
	 * Create the frame.
	 */
	public GD_XemChiTietHoaDonThongKe(HoaDonEntity hoaDonEntity) {
		setBackground(new Color(230, 230, 250));
		this.hoaDonEntity = hoaDonEntity;
		setTitle("Xem chi tiết hóa đơn");
		pnlContent = new JPanel();
		pnlContent.setBackground(new Color(230, 230, 250));
		pnlContent.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(pnlContent);
		pnlContent.setLayout(null);
		setSize(903, 476);
		setLocationRelativeTo(null);

		JPanel pnlChiTietPhong = new JPanel();
		pnlChiTietPhong.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh sách phòng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlChiTietPhong.setBackground(new Color(230, 230, 250));
		pnlChiTietPhong.setBounds(10, 11, 873, 180);
		pnlContent.add(pnlChiTietPhong);
		pnlChiTietPhong.setLayout(null);

		String[] col_Phong = { "STT", "Số phòng", "Loại phòng", "Sức chứa", "Giờ nhận phòng", "Giờ trả phòng" };
		tblmodelPhong = new DefaultTableModel(col_Phong, 0);
		tblPhong = new JTable(tblmodelPhong);

		JScrollPane scrPhong = new JScrollPane(tblPhong);
		scrPhong.setBounds(20, 20, 827, 149);
		pnlChiTietPhong.add(scrPhong);

		JPanel pnlChiTietDichVu = new JPanel();
		pnlChiTietDichVu.setBorder(
				new TitledBorder(null, "Danh sách dịch vụ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlChiTietDichVu.setBackground(new Color(230, 230, 250));
		pnlChiTietDichVu.setBounds(10, 202, 873, 224);
		pnlContent.add(pnlChiTietDichVu);
		pnlChiTietDichVu.setLayout(null);

		String[] col_DichVu = { "STT", "Tên dịch vụ", "Loại dịch vụ", "Giá tiền", "Số lượng", "Thành tiền" };
		tblmodelDichVu = new DefaultTableModel(col_DichVu, 0);
		tblDichVu = new JTable(tblmodelDichVu);

		JScrollPane scrDichVu = new JScrollPane(tblDichVu);
		scrDichVu.setBounds(20, 56, 827, 157);
		pnlChiTietDichVu.add(scrDichVu);

		JLabel lblSoPhong = new JLabel("Số phòng:");
		lblSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblSoPhong.setBounds(20, 22, 70, 20);
		pnlChiTietDichVu.add(lblSoPhong);

		txtSoPhong = new JTextField();
		txtSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtSoPhong.setForeground(Color.BLACK);
		txtSoPhong.setEditable(false);
		txtSoPhong.setBounds(89, 20, 86, 25);
		pnlChiTietDichVu.add(txtSoPhong);
		txtSoPhong.setColumns(10);

		btnThoat = new JButton("Thoát");
		btnThoat.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThoat.setBackground(new Color(144, 238, 144));
		btnThoat.setFocusable(false);
		btnThoat.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnThoat.setBounds(750, 456, 120, 35);
		pnlContent.add(btnThoat);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setFocusable(false);
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnLamMoi.setBounds(610, 456, 120, 35);
		pnlContent.add(btnLamMoi);

		XemChiTietHoaDonController controller = new XemChiTietHoaDonController(this);
		btnLamMoi.addActionListener(controller);
		btnThoat.addActionListener(controller);
		tblPhong.addMouseListener(controller);
		loadPhong();
	}

	private void loadPhong() {
		listChiTietHoaDon = quanLyHoaDonDAO.duyetDanhSachChiTietHoaDonTheoMaHoaDon(hoaDonEntity.getMaHoaDon());
		tblPhong.removeAll();
		tblPhong.setRowSelectionAllowed(false);
		tblmodelPhong.setRowCount(0);

		int stt = 1;
		for (ChiTietHoaDonEntity chiTietHoaDonEntity : listChiTietHoaDon) {
			ChiTietDatPhongEntity chiTietDatPhongEntity = chiTietHoaDonEntity.getChiTietDatPhong();
			tblmodelPhong.addRow(new Object[] { stt++, chiTietDatPhongEntity.getPhong().getSoPhong(),
					chiTietDatPhongEntity.getPhong().getLoaiPhong().getTenLoaiPhong(),
					chiTietDatPhongEntity.getPhong().getSucChua(),
					TimeFormatter.format(chiTietDatPhongEntity.getGioNhanPhong()),
					TimeFormatter.format(chiTietDatPhongEntity.getGioTraPhong()) });
		}
	}

	public void chonPhong() {
		int row = tblPhong.getSelectedRow();
		listChiTietHoaDon = quanLyHoaDonDAO.duyetDanhSachChiTietHoaDonTheoMaHoaDon(hoaDonEntity.getMaHoaDon());
		if (row >= 0) {
			txtSoPhong.setText(tblPhong.getValueAt(row, 1).toString());
			listChiTietDichVu = quanLyHoaDonDAO
					.duyetDanhSachChiTietDichVuTheoChiTietHoaDon(listChiTietHoaDon.get(row).getMaChiTietHoaDon());
			tblDichVu.removeAll();
			tblDichVu.setRowSelectionAllowed(false);
			tblmodelDichVu.setRowCount(0);
			int stt = 1;
			for (ChiTietDichVuEntity chiTietDichVuEntity : listChiTietDichVu) {
				tblmodelDichVu.addRow(new Object[] { stt++, chiTietDichVuEntity.getDichVu().getTenDichVu(),
						chiTietDichVuEntity.getDichVu().getLoaiDichVu().getTenLoaiDichVu(),
						MoneyFormatter.format(chiTietDichVuEntity.getDichVu().getGia()),
						chiTietDichVuEntity.getSoLuong(), MoneyFormatter.format(chiTietDichVuEntity.tinhThanhTien()) });
			}
		}
	}

	public void chonLamMoi() {
		txtSoPhong.setText("");
		tblDichVu.removeAll();
		tblDichVu.setRowSelectionAllowed(false);
		tblmodelDichVu.setRowCount(0);
	}

	public void chonThoat() {
		this.dispose();
	}
}
