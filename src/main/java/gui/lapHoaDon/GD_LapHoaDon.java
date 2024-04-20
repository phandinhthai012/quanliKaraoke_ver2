package gui.lapHoaDon;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import Dao.HoaDonDao;
import Dao.KhachHangDao;
import Dao.LapHoaDonDao;
import Dao.PhieuDatPhongDao;
import Dao.Impl.HoaDonImpl;
import Dao.Impl.KhachHangImpl;
import Dao.Impl.LapHoaDonImpl;
import Dao.Impl.PhieuDatPhongImpl;
import controller.LapHoaDonController;
//import dao.LapHoaDonDAO;
//import dao.QuanLyHoaDonDAO;
//import dao.QuanLyKhachHangDAO;
//import dao.QuanLyPhieuDatPhongDAO;
import entities.ChiTietDatPhongEntity;
import entities.ChiTietDichVuEntity;
import entities.ChiTietHoaDonEntity;
import entities.ChiTietPhieuDatPhongEntity;
import entities.HoaDonEntity;
import entities.KhachHangEntity;
import entities.NhanVienEntity;
import entities.PhieuDatPhongEntity;
import entities.PhongEntity;
import gui.hoaDon.GD_XemChiTietHoaDonLapHoaDon;
import util.DateFormatter;
import util.MoneyFormatter;
import util.TimeFormatter;

public class GD_LapHoaDon extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField txtTenKhachHang;
	private JTextField txtSoDienThoai;
	private JTextField txtTienDichVu;
	private JTextField txtTienTraKhach;
	private JTextField txtTienNhan;
	private JTextField txtSoLuongPhong;
	private JTextField txtTongTien;
	private JLabel lblNgayHienTai;
	private JLabel lblGioHienTai;
	private JPanel pnlChanTrang;
	private JLabel lblTongTien;
	private JLabel lblSoLuongPhong;
	private JLabel lblTienTraKhach;
	private JLabel lblTienNhan;
	private JLabel lblTienDichVu;
	private JLabel lblSoDienThoai;
	private JLabel lblTenKhachHang;
	private JPanel pnlChiTietLapHoaDon;
	private JScrollPane scrDSHoaDon;
	private JLabel lblChiTietLapHoaDon;

	private JPanel pnlTimKiem;
	private JLabel lblTimKiemTheoSDT;
	private JTextField textField;

	private JTable tblHoaDon;
	private DefaultTableModel tblmodelHoaDon;
	private JCheckBox chkXuatHoaDon;

	public JButton btnTimKiem;
	public JButton btnLamMoi;
	public JButton btnLapHoaDon;
	public JButton btnXemChiTiet;

	private LapHoaDonController controller;
	private List<PhieuDatPhongEntity> listPhieuDatPhong;
	private List<ChiTietPhieuDatPhongEntity> listChiTietPhieuDatPhong;
	private List<ChiTietHoaDonEntity> listChiTietHoaDon;
	private List<ChiTietDichVuEntity> listChiTietDichVu;

//	private QuanLyPhieuDatPhongDAO quanLyPhieuDatPhongDAO = new QuanLyPhieuDatPhongDAO();
	private PhieuDatPhongDao quanLyPhieuDatPhongDAO = new PhieuDatPhongImpl();
//	private QuanLyKhachHangDAO quanLyKhachHangDAO = new QuanLyKhachHangDAO();
	private KhachHangDao quanLyKhachHangDAO = new KhachHangImpl();
//	private LapHoaDonDAO lapHoaDonDAO = new LapHoaDonDAO();
	private LapHoaDonDao lapHoaDonDAO = new LapHoaDonImpl();
//	private QuanLyHoaDonDAO quanLyHoaDonDAO = new QuanLyHoaDonDAO();
	private HoaDonDao quanLyHoaDonDAO = new HoaDonImpl();

	private NhanVienEntity nhanVienEntity;
	private KhachHangEntity khachHangEntity;
	private PhieuDatPhongEntity phieuDatPhongEntity;
	private HoaDonEntity hoaDonEntity;

	private double tienTra = 0;
	private double tienDichVu = 0;

	public GD_LapHoaDon(NhanVienEntity nhanVienEntity) throws RemoteException {
		this.nhanVienEntity = nhanVienEntity;
		setLayout(null);
		setBounds(0, 0, 1365, 694);

		JPanel pnlLapHoaDon = new JPanel();
		pnlLapHoaDon.setBounds(0, 0, 1365, 694);
		add(pnlLapHoaDon);
		pnlLapHoaDon.setLayout(null);

		JPanel pnlChinh = new JPanel();
		pnlChinh.setBackground(new Color(230, 230, 250));
		pnlChinh.setBounds(0, 0, 1365, 616);
		pnlLapHoaDon.add(pnlChinh);
		pnlChinh.setLayout(null);

		JPanel pnlDSHoaDon = new JPanel();
		pnlDSHoaDon.setBorder(null);
		pnlDSHoaDon.setBackground(new Color(230, 230, 250));
		pnlDSHoaDon.setBounds(0, 144, 672, 472);
		pnlChinh.add(pnlDSHoaDon);
		pnlDSHoaDon.setLayout(null);

		String[] cols_DSHoaDon = { "STT", "Tên khách hàng", "Số điện thoại khách hàng", "Số lượng phòng", "Tổng tiền" };
		tblmodelHoaDon = new DefaultTableModel(cols_DSHoaDon, 0);
		tblHoaDon = new JTable(tblmodelHoaDon);
		tblHoaDon.setAutoCreateRowSorter(true);
		scrDSHoaDon = new JScrollPane(tblHoaDon);
		scrDSHoaDon.setBounds(10, 10, 652, 451);
		pnlDSHoaDon.add(scrDSHoaDon);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblHoaDon.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblHoaDon.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tblHoaDon.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);

		pnlChiTietLapHoaDon = new JPanel();
		pnlChiTietLapHoaDon.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pnlChiTietLapHoaDon.setBackground(new Color(230, 230, 250));
		pnlChiTietLapHoaDon.setBounds(672, 0, 694, 616);
		pnlChinh.add(pnlChiTietLapHoaDon);
		pnlChiTietLapHoaDon.setLayout(null);

		lblTenKhachHang = new JLabel("Tên khách hàng:");
		lblTenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTenKhachHang.setBounds(116, 129, 120, 25);
		pnlChiTietLapHoaDon.add(lblTenKhachHang);

		lblSoDienThoai = new JLabel("Số điện thoại:");
		lblSoDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSoDienThoai.setBounds(116, 179, 120, 25);
		pnlChiTietLapHoaDon.add(lblSoDienThoai);

		lblTienDichVu = new JLabel("Tiền dịch vụ:");
		lblTienDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTienDichVu.setBounds(116, 279, 120, 25);
		pnlChiTietLapHoaDon.add(lblTienDichVu);

		lblTienNhan = new JLabel("Tiền nhận:");
		lblTienNhan.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTienNhan.setBounds(116, 379, 120, 25);
		pnlChiTietLapHoaDon.add(lblTienNhan);

		lblTienTraKhach = new JLabel("Tiền trả khách:");
		lblTienTraKhach.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTienTraKhach.setBounds(116, 429, 120, 25);
		pnlChiTietLapHoaDon.add(lblTienTraKhach);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setBackground(Color.WHITE);
		txtTenKhachHang.setDisabledTextColor(Color.BLACK);
		txtTenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtTenKhachHang.setBorder(null);
		txtTenKhachHang.setEditable(false);
		txtTenKhachHang.setBounds(236, 129, 340, 25);
		pnlChiTietLapHoaDon.add(txtTenKhachHang);
		txtTenKhachHang.setColumns(10);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setBackground(Color.WHITE);
		txtSoDienThoai.setDisabledTextColor(Color.BLACK);
		txtSoDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtSoDienThoai.setBorder(null);
		txtSoDienThoai.setEditable(false);
		txtSoDienThoai.setBounds(236, 179, 340, 25);
		pnlChiTietLapHoaDon.add(txtSoDienThoai);
		txtSoDienThoai.setColumns(10);

		txtTienDichVu = new JTextField();
		txtTienDichVu.setBackground(Color.WHITE);
		txtTienDichVu.setDisabledTextColor(Color.BLACK);
		txtTienDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtTienDichVu.setBorder(null);
		txtTienDichVu.setEditable(false);
		txtTienDichVu.setBounds(236, 279, 340, 25);
		pnlChiTietLapHoaDon.add(txtTienDichVu);
		txtTienDichVu.setColumns(10);

		txtTienTraKhach = new JTextField();
		txtTienTraKhach.setBackground(Color.WHITE);
		txtTienTraKhach.setDisabledTextColor(Color.BLACK);
		txtTienTraKhach.setEnabled(false);
		txtTienTraKhach.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtTienTraKhach.setBorder(null);
		txtTienTraKhach.setBounds(236, 429, 340, 25);
		pnlChiTietLapHoaDon.add(txtTienTraKhach);
		txtTienTraKhach.setColumns(10);

		txtTienNhan = new JTextField();
		txtTienNhan.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtTienNhan.setBounds(236, 379, 340, 25);
		pnlChiTietLapHoaDon.add(txtTienNhan);
		txtTienNhan.setColumns(10);

		lblSoLuongPhong = new JLabel("Số lượng phòng:");
		lblSoLuongPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSoLuongPhong.setBounds(116, 229, 120, 25);
		pnlChiTietLapHoaDon.add(lblSoLuongPhong);

		txtSoLuongPhong = new JTextField();
		txtSoLuongPhong.setBackground(Color.WHITE);
		txtSoLuongPhong.setDisabledTextColor(Color.BLACK);
		txtSoLuongPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtSoLuongPhong.setBorder(null);
		txtSoLuongPhong.setEditable(false);
		txtSoLuongPhong.setBounds(236, 229, 340, 25);
		pnlChiTietLapHoaDon.add(txtSoLuongPhong);
		txtSoLuongPhong.setColumns(10);

		lblTongTien = new JLabel("Tổng tiền:");
		lblTongTien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTongTien.setBounds(116, 329, 120, 25);
		pnlChiTietLapHoaDon.add(lblTongTien);

		txtTongTien = new JTextField();
		txtTongTien.setBackground(Color.WHITE);
		txtTongTien.setDisabledTextColor(Color.BLACK);
		txtTongTien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtTongTien.setBorder(null);
		txtTongTien.setEditable(false);
		txtTongTien.setBounds(236, 329, 340, 25);
		pnlChiTietLapHoaDon.add(txtTongTien);
		txtTongTien.setColumns(10);

		btnLapHoaDon = new JButton("Lập hóa đơn");
		btnLapHoaDon.setIcon(new ImageIcon(GD_LapHoaDon.class.getResource("/images/iconTick.png")));
		btnLapHoaDon.setMnemonic(KeyEvent.VK_ENTER);
		btnLapHoaDon.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLapHoaDon.setBackground(new Color(255, 128, 128));
		btnLapHoaDon.setFocusable(false);
		btnLapHoaDon.setFont(new Font("Cambria", Font.BOLD, 14));
		btnLapHoaDon.setBounds(450, 550, 195, 39);
		pnlChiTietLapHoaDon.add(btnLapHoaDon);

		chkXuatHoaDon = new JCheckBox("Xuất hóa đơn");
		chkXuatHoaDon.setBackground(new Color(230, 230, 250));
		chkXuatHoaDon.setFocusable(false);
		chkXuatHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		chkXuatHoaDon.setBounds(330, 559, 97, 25);
		pnlChiTietLapHoaDon.add(chkXuatHoaDon);

		lblChiTietLapHoaDon = new JLabel("Chi tiết Lập Hóa Đơn");
		lblChiTietLapHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietLapHoaDon.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblChiTietLapHoaDon.setBounds(0, 40, 694, 50);
		pnlChiTietLapHoaDon.add(lblChiTietLapHoaDon);

		btnXemChiTiet = new JButton("Xem chi tiết hóa đơn");
		btnXemChiTiet.setIcon(new ImageIcon(GD_LapHoaDon.class.getResource("/images/iconMatMo.png")));
		btnXemChiTiet.setFont(new Font("Cambria", Font.BOLD, 14));
		btnXemChiTiet.setFocusable(false);
		btnXemChiTiet.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXemChiTiet.setBackground(new Color(144, 238, 144));
		btnXemChiTiet.setBounds(450, 482, 195, 39);
		pnlChiTietLapHoaDon.add(btnXemChiTiet);

		pnlTimKiem = new JPanel();
		pnlTimKiem.setLayout(null);
		pnlTimKiem.setBorder(null);
		pnlTimKiem.setBackground(new Color(230, 230, 250));
		pnlTimKiem.setBounds(0, 0, 672, 144);
		pnlChinh.add(pnlTimKiem);

		lblTimKiemTheoSDT = new JLabel("SĐT Khách hàng:");
		lblTimKiemTheoSDT.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTimKiemTheoSDT.setBounds(80, 30, 120, 30);
		pnlTimKiem.add(lblTimKiemTheoSDT);

		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(210, 30, 382, 30);
		pnlTimKiem.add(textField);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setIcon(new ImageIcon(GD_LapHoaDon.class.getResource("/images/iconTimKiem.png")));
		btnTimKiem.setFont(new Font("Cambria", Font.BOLD, 14));
		btnTimKiem.setFocusable(false);
		btnTimKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiem.setBackground(new Color(144, 238, 144));
		btnTimKiem.setBounds(442, 80, 150, 35);
		pnlTimKiem.add(btnTimKiem);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(GD_LapHoaDon.class.getResource("/images/iconLamMoi.png")));
		btnLamMoi.setFont(new Font("Cambria", Font.BOLD, 14));
		btnLamMoi.setFocusable(false);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setBounds(249, 80, 150, 35);
		pnlTimKiem.add(btnLamMoi);

		pnlChanTrang = new JPanel();
		pnlChanTrang.setBorder(null);
		pnlChanTrang.setBackground(new Color(230, 230, 250));
		pnlChanTrang.setBounds(0, 616, 1365, 78);
		pnlLapHoaDon.add(pnlChanTrang);
		pnlChanTrang.setLayout(null);

		lblGioHienTai = new JLabel("16:06");
		lblGioHienTai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGioHienTai.setBounds(1282, 17, 53, 30);
		Timer gioHT = new Timer(1, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lblGioHienTai.setText(TimeFormatter.format(LocalTime.now()));
			}
		});
		gioHT.start();
		pnlChanTrang.add(lblGioHienTai);

		lblNgayHienTai = new JLabel("28/06/2023");
		lblNgayHienTai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgayHienTai.setBounds(1241, 37, 94, 30);
		Timer ngayHT = new Timer(1, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lblNgayHienTai.setText(DateFormatter.format(LocalDate.now()));
			}
		});
		ngayHT.start();
		pnlChanTrang.add(lblNgayHienTai);
		txtTienNhan.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				try {
					tinhTienTraKhach();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {

			}
		});

		controller = new LapHoaDonController(this);
		btnLamMoi.addActionListener(controller);
		btnTimKiem.addActionListener(controller);
		btnXemChiTiet.addActionListener(controller);
		btnLapHoaDon.addActionListener(controller);
		tblHoaDon.addMouseListener(controller);
		loadData();
	}

	/***** loadData 
	 * @throws RemoteException *****/
	private void loadData() throws RemoteException {
		tblHoaDon.removeAll();
		tblHoaDon.setRowSelectionAllowed(false);
		tblmodelHoaDon.setRowCount(0);
		listPhieuDatPhong = quanLyPhieuDatPhongDAO.duyetDanhSachPhieuDatPhongChuaThanhToan();

		int stt = 1;
		for (PhieuDatPhongEntity phieuDatPhongEntity : listPhieuDatPhong) {
//			KhachHangEntity khachHangEntity = quanLyKhachHangDAO.timTheoMa(phieuDatPhongEntity.getMaKhachHang());
			KhachHangEntity khachHangEntity = quanLyKhachHangDAO.timTheoMa(phieuDatPhongEntity.getKhachHang().getMaKhachHang());
			tblmodelHoaDon.addRow(new Object[] { stt++, khachHangEntity.getHoTen(), khachHangEntity.getSoDienThoai(),
					lapHoaDonDAO.demSoLuongPhong(phieuDatPhongEntity.getMaPhieuDatPhong()),
					MoneyFormatter.format1(tinhTongTienThanhToan(phieuDatPhongEntity.getMaPhieuDatPhong())) });
		}
	}

	/***** HIỂN THỊ THÔNG TIN 
	 * @throws RemoteException *****/
	public void hienThiThongTin() throws RemoteException {
		listPhieuDatPhong = quanLyPhieuDatPhongDAO.duyetDanhSachPhieuDatPhongChuaThanhToan();
		int row = tblHoaDon.getSelectedRow();
		if (row >= 0) {
//			khachHangEntity = quanLyKhachHangDAO.timTheoMa(listPhieuDatPhong.get(row).getMaKhachHang());
			khachHangEntity = quanLyKhachHangDAO.timTheoMa(listPhieuDatPhong.get(row).getKhachHang().getMaKhachHang());
			txtTenKhachHang.setText(khachHangEntity.getHoTen());
			txtSoDienThoai.setText(khachHangEntity.getSoDienThoai());
			txtSoLuongPhong.setText(
					String.valueOf(lapHoaDonDAO.demSoLuongPhong(listPhieuDatPhong.get(row).getMaPhieuDatPhong())));
			txtTienDichVu.setText(MoneyFormatter
					.format(lapHoaDonDAO.tinhTienDichVu(listPhieuDatPhong.get(row).getMaPhieuDatPhong())));
			txtTongTien.setText(
					MoneyFormatter.format(tinhTongTienThanhToan(listPhieuDatPhong.get(row).getMaPhieuDatPhong())));
			phieuDatPhongEntity = quanLyPhieuDatPhongDAO
					.timPhieuDatPhongTheoMa(listPhieuDatPhong.get(row).getMaPhieuDatPhong());
		}
	}

	/***** LÀM MỚI 
	 * @throws RemoteException *****/
	public void chonLamMoi() throws RemoteException {
		txtTienDichVu.setText("");
		txtSoDienThoai.setText("");
		txtTenKhachHang.setText("");
		txtSoLuongPhong.setText("");
		txtTienNhan.setText("");
		txtTienTraKhach.setText("");
		textField.setText("");
		txtTongTien.setText("");
		loadData();
	}

	/***** TÌM KIẾM 
	 * @throws RemoteException *****/
	public void chonTimKiem() throws RemoteException {
		if (kiemTraDuLieuTim()) {
			String sdt = textField.getText().trim();
			tblHoaDon.removeAll();
			tblmodelHoaDon.setRowCount(0);
			KhachHangEntity khachHangEntity = quanLyKhachHangDAO.timTheoSoDienThoai(sdt);
			System.out.println(khachHangEntity);
			listPhieuDatPhong = lapHoaDonDAO.timHoaDonTheoKhachHang(khachHangEntity);
			int stt = 1;
			for (PhieuDatPhongEntity phieuDatPhongEntity : listPhieuDatPhong)
				tblmodelHoaDon
						.addRow(new Object[] { stt++, khachHangEntity.getHoTen(), khachHangEntity.getSoDienThoai(),
								lapHoaDonDAO.demSoLuongPhong(phieuDatPhongEntity.getMaPhieuDatPhong()),
								tinhTongTienThanhToan(phieuDatPhongEntity.getMaPhieuDatPhong()) });

		}
	}

	/***** XEM CHI TIẾT 
	 * @throws RemoteException *****/
	public void chonXemChiTiet() throws RemoteException {
		int row = tblHoaDon.getSelectedRow();
		if (row >= 0) {
			listPhieuDatPhong = quanLyPhieuDatPhongDAO.duyetDanhSachPhieuDatPhongChuaThanhToan();
			new GD_XemChiTietHoaDonLapHoaDon(listPhieuDatPhong.get(row)).setVisible(true);
			;
		}
	}

	/***** LẬP HÓA ĐƠN 
	 * @throws RemoteException 
	 * @throws HeadlessException *****/
	public void chonLapHoaDon() throws  RemoteException {
		if (kiemTraTienNhan()) {
//			hoaDonEntity = new HoaDonEntity(nhanVienEntity.getMaNhanVien(), khachHangEntity.getMaKhachHang(),
//					LocalDate.now(), LocalTime.now());
			hoaDonEntity = new HoaDonEntity(nhanVienEntity, khachHangEntity,LocalDate.now(), LocalTime.now());
			if (lapHoaDonDAO.themHoaDon(hoaDonEntity)) {
				hoaDonEntity = lapHoaDonDAO.timHoaDonVuaTao();
				listChiTietHoaDon = lapHoaDonDAO.duyetDanhSachChiTietHoaDon(phieuDatPhongEntity.getMaPhieuDatPhong());
				for (ChiTietHoaDonEntity chiTietHoaDonEntity : listChiTietHoaDon)
					if (!lapHoaDonDAO.capNhatChiTietHoaDon(chiTietHoaDonEntity, hoaDonEntity.getMaHoaDon()))
						return;

				if (chkXuatHoaDon.isSelected()) {
					xuatFile(hoaDonEntity.getMaHoaDon());
					moFile(hoaDonEntity.getMaHoaDon());
				} else {
					JOptionPane.showMessageDialog(null, "Lập hóa đơn thành công");
				}
				chonLamMoi();
				return;
			}

		}
	}

	/**** KIỂM TRA TIỀN NHẬN *****/
	private boolean kiemTraTienNhan() {
		String tienNhan = txtTienNhan.getText();
		if (tienNhan.length() > 0) {
			if (!(tienNhan.length() > 0 && tienNhan.matches("[0-9]+"))) {
				JOptionPane.showMessageDialog(this, "Tiền nhận của khách là số", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtTienNhan.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Tiền nhận không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtTienNhan.requestFocus();
			return false;
		}
		return true;
	}

	/***** TÍNH TIỀN HÁT MỘT PHÒNG THEO GIỜ *****/
	private double tinhTienHatMotPhong(PhongEntity phongEntity, double gioHat) {
		if (phongEntity.getLoaiPhong().getTenLoaiPhong().equals("VIP")) {
			return gioHat * 200000.0;
		}
		return gioHat * 150000.0;
	}

	/***** TÍNH TỔNG TIỀN HÁT 
	 * @throws RemoteException *****/
	private double tinhTongTienHat(String maPhieuDatPhong) throws RemoteException {
		double tienHat = 0;
		listChiTietPhieuDatPhong = quanLyPhieuDatPhongDAO
				.duyetDanhSachChiTietPhieuDatPhongTheoPhieuDatPhong(maPhieuDatPhong);
		for (ChiTietPhieuDatPhongEntity chiTietPhieuDatPhongEntity : listChiTietPhieuDatPhong) {
//			ChiTietDatPhongEntity chiTietDatPhongEntity = quanLyHoaDonDAO
//					.timChiTietDatPhongTheoMa(chiTietPhieuDatPhongEntity.getMaChiTietDatPhong());
			ChiTietDatPhongEntity chiTietDatPhongEntity = quanLyHoaDonDAO
					.timChiTietDatPhongTheoMa(chiTietPhieuDatPhongEntity.getChiTietDatPhong().getMaChiTietDatPhong());

			double gioHat = TimeFormatter.tinhSoPhut(chiTietDatPhongEntity.getGioNhanPhong(),
					chiTietDatPhongEntity.getGioTraPhong()) / 60.0;
			tienHat += tinhTienHatMotPhong(chiTietDatPhongEntity.getPhong(), gioHat);
		}
		return tienHat;
	}

	/***** TÍNH TỔNG TIỀN CẦN THANH TOÁN 
	 * @throws RemoteException *****/
	private double tinhTongTienThanhToan(String maPhieuDatPhong) throws RemoteException {
		double tienDichVu = lapHoaDonDAO.tinhTienDichVu(maPhieuDatPhong);
		double tienHat = tinhTongTienHat(maPhieuDatPhong);
		return tienDichVu + tienHat;
	}

	/**** TÍNH TIỀN TRẢ KHÁCH 
	 * @throws RemoteException *****/
	private void tinhTienTraKhach() throws RemoteException {
		listPhieuDatPhong = quanLyPhieuDatPhongDAO.duyetDanhSachPhieuDatPhongChuaThanhToan();
		int row = tblHoaDon.getSelectedRow();
		if (row >= 0) {
			txtTienTraKhach.setText("");
			double tienNhan = 0;
			String tienTraKhach;
			if (!txtTienNhan.getText().equals(""))
				tienNhan = Double.parseDouble(txtTienNhan.getText().trim());

			double tongTien = tinhTongTienThanhToan(listPhieuDatPhong.get(row).getMaPhieuDatPhong());
			if (tienNhan >= tongTien) {
				tienTra = tienNhan - tongTien;
				tienTraKhach = MoneyFormatter.format(tienTra);
				txtTienTraKhach.setText(tienTraKhach);
			}
		}
	}

	/***** KIỂM TRA DỮ LIỆU TÌM *****/
	private boolean kiemTraDuLieuTim() {
		String sdt = textField.getText();
		if (sdt.length() > 0) {
			if (!(sdt.length() == 10 && sdt.matches("^0[0-9]{9}$"))) {
				JOptionPane.showMessageDialog(this, "Số điện thoại phải là 10 ký số và bắt đầu bằng số 0", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				textField.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Nhập số điện thoại khách hàng cần tìm", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			textField.requestFocus();
			return false;
		}
		return true;
	}

	/***** MỞ FILE *****/
	public void moFile(String maHoaDon) {
		String url = "";
		url = System.getProperty("user.dir") + "/HoaDon.pdf";
		File file = new File(url);
		if (Desktop.isDesktopSupported()) {
			Desktop desktop = Desktop.getDesktop();
			try {
				desktop.open(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Desktop is not supported on your system.");
		}

	}

	/***** XUẤT FILE *****/
	public void xuatFile(String maHoaDon) {
		Document hoaDon = new Document(PageSize.LETTER);
		hoaDon.setMargins(50, 50, 10, 0);
		try {
			// Tạo font với Unicode
			BaseFont unicodeFont = BaseFont.createFont("Arial Unicode MS.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			com.itextpdf.text.Font unicodeFontObj = new com.itextpdf.text.Font(unicodeFont, 12);
			// Tạo file
			PdfWriter.getInstance(hoaDon, new FileOutputStream("HoaDon.pdf"));
			hoaDon.open();

			String imagePath = "src/main/java/images/iconLogo1.png";
			Image image = Image.getInstance(imagePath);
			Paragraph loGo = new Paragraph();
			loGo.add(image);
			image.setAlignment(Image.MIDDLE);
			hoaDon.add(loGo);

			Paragraph diaChi = new Paragraph("524 Đ. Phan Văn Trị, Phường 7, Gò Vấp, Thành phố Hồ Chí Minh, Việt Nam",
					new com.itextpdf.text.Font(unicodeFont, 10, com.itextpdf.text.Font.NORMAL));
			diaChi.setAlignment(Element.ALIGN_CENTER);
			hoaDon.add(diaChi);
			hoaDon.add(Chunk.NEWLINE);

			Paragraph hoaDonThanhToan = new Paragraph("HÓA ĐƠN",
					new com.itextpdf.text.Font(unicodeFont, 20, com.itextpdf.text.Font.BOLD));
			hoaDonThanhToan.setAlignment(Element.ALIGN_CENTER);
			hoaDon.add(hoaDonThanhToan);
			Paragraph tmp = new Paragraph("********************", unicodeFontObj);
			tmp.setAlignment(Element.ALIGN_CENTER);
			hoaDon.add(tmp);

			Paragraph ngayVaGioLapHoaDon = new Paragraph("Ngày/ Giờ thanh toán: "
					+ DateFormatter.format(LocalDate.now()) + "  " + TimeFormatter.format(LocalTime.now()),
					unicodeFontObj);
			ngayVaGioLapHoaDon.setAlignment(Element.ALIGN_LEFT);
			hoaDon.add(ngayVaGioLapHoaDon);

			Paragraph tenNhanVien = new Paragraph("Nhân viên: " + nhanVienEntity.getHoTen(), unicodeFontObj);
			hoaDon.add(tenNhanVien);

			Paragraph tenKhachHang = new Paragraph("Khách hàng: " + khachHangEntity.getHoTen(), unicodeFontObj);
			hoaDon.add(tenKhachHang);
			hoaDon.add(Chunk.NEWLINE);
			PdfPTable pdftblThongTinPhong = new PdfPTable(5);
			pdftblThongTinPhong.setTotalWidth(new float[] { 20f, 40f, 160f, 40f, 50f });
			pdftblThongTinPhong.setWidthPercentage(100);

			PdfPTable pdftblThongTinDichVu = new PdfPTable(4);
			pdftblThongTinDichVu.setTotalWidth(new float[] { 60f, 20f, 40f, 40f });
			pdftblThongTinDichVu.setWidthPercentage(100);
			pdftblThongTinDichVu.getDefaultCell().setBorder(Rectangle.NO_BORDER);

			PdfPTable pdftblThongTinThanhToan = new PdfPTable(8);
			pdftblThongTinThanhToan.setTotalWidth(new float[] { 20f, 40f, 60f, 20f, 40f, 50f, 30f, 50f });
			pdftblThongTinThanhToan.setWidthPercentage(100);
			pdftblThongTinThanhToan.getDefaultCell().setBorder(Rectangle.NO_BORDER);

			// Thông tin phòng
			Paragraph stt = new Paragraph("STT", unicodeFontObj);
			Paragraph soPhong = new Paragraph("Số phòng", unicodeFontObj);
			Paragraph cacDichVu = new Paragraph("Các dịch vụ", unicodeFontObj);
			Paragraph giaMotGio = new Paragraph("Giá/Giờ", unicodeFontObj);
			Paragraph tienHat = new Paragraph("Tiền hát", unicodeFontObj);

			// Bảng dịch vụ
			pdftblThongTinDichVu.addCell(new PdfPCell(new Paragraph("Tên dịch vụ", unicodeFontObj)));
			pdftblThongTinDichVu.addCell(new PdfPCell(new Paragraph("SL")));
			pdftblThongTinDichVu.addCell(new PdfPCell(new Paragraph("Đơn giá", unicodeFontObj)));
			pdftblThongTinDichVu.addCell(new PdfPCell(new Paragraph("Tiền DV", unicodeFontObj)));

			PdfPCell cellStt = new PdfPCell();
			PdfPCell cellSoPhong = new PdfPCell();
			PdfPCell cellDichVu = new PdfPCell();
			PdfPCell cellGiaMotGio = new PdfPCell();
			PdfPCell cellTienHat = new PdfPCell();

			cacDichVu.setAlignment(Element.ALIGN_CENTER);
			cellStt.addElement(stt);
			cellSoPhong.addElement(soPhong);
			cellGiaMotGio.addElement(giaMotGio);
			cellTienHat.addElement(tienHat);
			cellDichVu.addElement(cacDichVu);
			cellDichVu.addElement(pdftblThongTinDichVu);
			for (PdfPRow row : pdftblThongTinDichVu.getRows()) {
				for (PdfPCell cell : row.getCells()) {
					cell.setBorder(Rectangle.NO_BORDER);
				}
			}

			pdftblThongTinPhong.addCell(cellStt);
			pdftblThongTinPhong.addCell(cellSoPhong);
			pdftblThongTinPhong.addCell(cellDichVu);
			pdftblThongTinPhong.addCell(cellGiaMotGio);
			pdftblThongTinPhong.addCell(cellTienHat);

			int soThuTu = 1;
			listChiTietHoaDon = new ArrayList<ChiTietHoaDonEntity>();
			listChiTietHoaDon = quanLyHoaDonDAO.duyetDanhSachChiTietHoaDonTheoMaHoaDon(hoaDonEntity.getMaHoaDon());

			for (ChiTietHoaDonEntity chiTietHoaDonEntity : listChiTietHoaDon) {
				// 1
				pdftblThongTinPhong.addCell(new PdfPCell(new Paragraph(String.valueOf(soThuTu++))));

				// 2
				pdftblThongTinPhong.addCell(new PdfPCell(new Paragraph(
						String.valueOf(chiTietHoaDonEntity.getChiTietDatPhong().getPhong().getSoPhong()))));

				// 3
				listChiTietDichVu = new ArrayList<ChiTietDichVuEntity>();
				listChiTietDichVu = quanLyHoaDonDAO
						.duyetDanhSachChiTietDichVuTheoChiTietHoaDon(chiTietHoaDonEntity.getMaChiTietHoaDon());
				pdftblThongTinDichVu.deleteBodyRows();
				for (ChiTietDichVuEntity chiTietDichVuEntity : listChiTietDichVu) {
					pdftblThongTinDichVu.addCell(new PdfPCell(new Paragraph(
							String.valueOf(chiTietDichVuEntity.getDichVu().getTenDichVu()), unicodeFontObj)));
					pdftblThongTinDichVu
							.addCell(new PdfPCell(new Paragraph(String.valueOf(chiTietDichVuEntity.getSoLuong()))));
					pdftblThongTinDichVu.addCell(new PdfPCell(new Paragraph(
							String.valueOf(MoneyFormatter.format1(chiTietDichVuEntity.getDichVu().getGia())))));
					double dv = chiTietDichVuEntity.getDichVu().getGia() * chiTietDichVuEntity.getSoLuong();
					pdftblThongTinDichVu
							.addCell(new PdfPCell(new Paragraph(String.valueOf(MoneyFormatter.format1(dv)))));
					tienDichVu += dv;

				}
				PdfPCell cot3 = new PdfPCell(pdftblThongTinDichVu);
				for (PdfPRow row : pdftblThongTinDichVu.getRows()) {
					for (PdfPCell cell : row.getCells()) {
						cell.setBorder(Rectangle.NO_BORDER);
					}
				}
				pdftblThongTinPhong.addCell(cot3);

				// 4
				if (chiTietHoaDonEntity.getChiTietDatPhong().getPhong().getLoaiPhong().getTenLoaiPhong()
						.equals("VIP")) {
					pdftblThongTinPhong.addCell(new PdfPCell(new Paragraph(MoneyFormatter.format1(200000))));
				} else {
					pdftblThongTinPhong.addCell(new PdfPCell(new Paragraph(MoneyFormatter.format1(150000))));
				}

				double gioHat = TimeFormatter.tinhSoPhut(chiTietHoaDonEntity.getChiTietDatPhong().getGioNhanPhong(),
						chiTietHoaDonEntity.getChiTietDatPhong().getGioTraPhong()) / 60.0;
				pdftblThongTinPhong.addCell(new PdfPCell(new Paragraph(MoneyFormatter
						.format1(tinhTienHatMotPhong(chiTietHoaDonEntity.getChiTietDatPhong().getPhong(), gioHat)))));

				for (PdfPRow row : pdftblThongTinPhong.getRows()) {
					for (PdfPCell cell : row.getCells()) {
						cell.setBorder(Rectangle.BOTTOM);
					}
				}
			}
			hoaDon.add(pdftblThongTinPhong);

			pdftblThongTinThanhToan.addCell(new PdfPCell(new Paragraph(String.valueOf("Tổng"), unicodeFontObj)));
			pdftblThongTinThanhToan.addCell(new PdfPCell(new Paragraph(
					String.valueOf(lapHoaDonDAO.demSoLuongPhong(phieuDatPhongEntity.getMaPhieuDatPhong())))));
			pdftblThongTinThanhToan.addCell(new PdfPCell(new Paragraph(String.valueOf(""))));
			pdftblThongTinThanhToan.addCell(new PdfPCell(new Paragraph(String.valueOf(""))));
			pdftblThongTinThanhToan.addCell(new PdfPCell(new Paragraph(String.valueOf(""))));
			pdftblThongTinThanhToan
					.addCell(new PdfPCell(new Paragraph(String.valueOf(MoneyFormatter.format1(tienDichVu)))));
			pdftblThongTinThanhToan.addCell(new PdfPCell(new Paragraph(String.valueOf(""))));
			pdftblThongTinThanhToan.addCell(new PdfPCell(new Paragraph(String
					.valueOf(MoneyFormatter.format1(tinhTongTienHat(phieuDatPhongEntity.getMaPhieuDatPhong()))))));
			for (PdfPRow row : pdftblThongTinThanhToan.getRows()) {
				for (PdfPCell cell : row.getCells()) {
					cell.setBorder(Rectangle.NO_BORDER);
				}
			}
			hoaDon.add(pdftblThongTinThanhToan);

			// Tổng thanh toán
			hoaDon.add(Chunk.NEWLINE);
			Paragraph tongThanhToan = new Paragraph(
					"Tổng thanh toán: " + MoneyFormatter
							.format1(tienDichVu + tinhTongTienHat(phieuDatPhongEntity.getMaPhieuDatPhong())),
					unicodeFontObj);
			tongThanhToan.setAlignment(Element.ALIGN_RIGHT);
			hoaDon.add(tongThanhToan);

			// tiền nhận
			Paragraph tienNhan = new Paragraph(
					"Tiền nhận: " + MoneyFormatter.format1(Double.parseDouble(txtTienNhan.getText().trim())),
					unicodeFontObj);
			tienNhan.setAlignment(Element.ALIGN_RIGHT);
			hoaDon.add(tienNhan);

			// tiền trả khách
			Paragraph tienTraKhach = new Paragraph("Tiền trả khách: " + MoneyFormatter.format1(tienTra),
					unicodeFontObj);
			tienTraKhach.setAlignment(Element.ALIGN_RIGHT);
			hoaDon.add(tienTraKhach);

			// lời cảm ơn
			hoaDon.add(Chunk.NEWLINE);
			Paragraph camOn = new Paragraph("Karaoke NNice xin cảm ơn - Hẹn gặp lại Quý Khách",
					new com.itextpdf.text.Font(unicodeFont, 10, com.itextpdf.text.Font.BOLD));
			camOn.setAlignment(Element.ALIGN_CENTER);
			hoaDon.add(camOn);

			hoaDon.close();
		} catch (DocumentException | FileNotFoundException | MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
