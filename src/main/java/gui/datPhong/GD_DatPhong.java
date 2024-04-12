package gui.datPhong;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Dao.DatPhongDao;
import Dao.HoaDonDao;
import Dao.KhachHangDao;
import Dao.PhieuDatPhongDao;
import Dao.PhongDao;
import Dao.Impl.DatPhongImpl;
import Dao.Impl.HoaDonImpl;
import Dao.Impl.KhachHangImpl;
import Dao.Impl.PhieuDatPhongImpl;
import Dao.Impl.PhongImpl;
import controller.DatPhongController;
//import dao.DatPhongDAO;
//import dao.QuanLyHoaDonDAO;
//import dao.QuanLyKhachHangDAO;
//import dao.QuanLyPhieuDatPhongDAO;
//import dao.QuanLyPhongDAO;
import entities.ChiTietDatPhongEntity;
import entities.ChiTietDichVuEntity;
import entities.ChiTietHoaDonEntity;
import entities.ChiTietPhieuDatPhongEntity;
import entities.KhachHangEntity;
import entities.NhanVienEntity;
import entities.PhieuDatPhongEntity;
import entities.PhongEntity;
import gui.trangChu.GD_TrangChu;
import util.DateFormatter;
import util.SendData;
import util.TimeFormatter;

public class GD_DatPhong extends JPanel {

	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */

	private JLabel lblSucChua;
	private JLabel lblImgTrangThaiPhong;
	private JLabel lblVIP;
	private JLabel lblChuThichPhongVIP;
	private JLabel lblImgChuThichPhongVIP;
	private JLabel lblChuThichPhongDangSuDung;
	private JLabel lblImgChuThichPhongDangSuDung;
	private JLabel lblChuThichPhongCho;
	private JLabel lblImgChuThichPhongCho;
	private JLabel lblChuThichPhongTrong;
	private JLabel lblImgChuThichPhongTrong;
	private JLabel lblTenKhachHang;
	private JLabel lblSDTKhachHang;
	private JLabel lblLoaiPhong;
	private JLabel lblSoPhong;
	private JLabel lblChiTietDatPhong;
	private JLabel lblTimKiemTheoSucChua;
	private JLabel lblTimKiemTheoSoPhong;
	private JLabel lblTimKiemTheoLoaiPhong;
	private JLabel lblTimKiemTheoTrangThai;
	private JLabel lblPhutTraPhong;
	private JLabel lblGioTraPhong;
	public JLabel lblGioHienTai;
	public JLabel lblNgayHienTai;

	private JPanel pnlChanTrang;
	private JPanel pnlChiTietDatPhong;
	private JPanel pnlDSPhong;
	private JPanel pnlTimKiem;
	private JPanel pnlDSTatCaPhong;
	private JPanel pnlPhongDaChon;
	private JPanel pnlGioNhanPhong;
	private JPanel pnlGioTraPhong;

	private JTextField txtTimKiemTheoSoPhong;
	private JTextField txtSoPhong;
	private JTextField txtLoaiPhong;
	private JTextField txtSucChua;
	private JTextField txtTenKhachHang;
	private JTextField txtSDTKhachHang;

	private JComboBox<String> cmbTimKiemTheoTrangThai;
	private JComboBox<String> cmbTimKiemTheoLoaiPhong;
	private JComboBox<String> cmbTimKiemTheoSucChua;
	private JComboBox<Integer> cmbGioNhanPhong;
	private JComboBox<Integer> cmbPhutNhanPhong;
	private JComboBox<Integer> cmbGioTraPhong;
	private JComboBox<Integer> cmbPhutTraPhong;
	private DefaultComboBoxModel<String> cmbmodelTrangThai;
	private DefaultComboBoxModel<String> cmbmodelLoaiPhong;
	private DefaultComboBoxModel<String> cmbmodelSucChua;
	private DefaultComboBoxModel<Integer> cmbmodelGioNhanPhong;
	private DefaultComboBoxModel<Integer> cmbmodelPhutNhanPhong;
	private DefaultComboBoxModel<Integer> cmbmodelGioTraPhong;
	private DefaultComboBoxModel<Integer> cmbmodelPhutTraPhong;

	private JDateChooser chonNgayDatTruoc;
	private ButtonGroup grpDatPhong;
	public JRadioButton radDatPhongNgay;
	public JRadioButton radDatPhongTruoc;

	private Timer ngayHT;
	private Timer gioHT;

	public JButton btnLamMoi;
	public JButton btnTimKiemPhong;
	public JButton btnTimKiemKhachHang;
	public JButton btnChonPhong;
	public JButton btnNhanPhong;
	public JButton btnXoaPhongDaChon;
	public JButton btnDoiPhong;
	public JButton btnHuyPhongDatTruoc;
	public JButton btnXemDatTruoc;
	public JButton btnDatPhong;

	private JScrollPane scrDSPhong;
	private JScrollPane scrDSPhongDaChon;

	public JTable tblPhong;
	public JTable tblPhongDaChon;
	private DefaultTableModel tblmodelPhong;
	private DefaultTableModel tblmodelPhongDaChon;

	private List<PhongEntity> listPhong;

//	private QuanLyPhongDAO quanLyPhongDAO = new QuanLyPhongDAO();
	private PhongDao quanLyPhongDAO = new PhongImpl();
//	private QuanLyKhachHangDAO quanLyKhachHangDAO = new QuanLyKhachHangDAO();
	private KhachHangDao quanLyKhachHangDAO = new KhachHangImpl();
//	private DatPhongDAO datPhongDAO = new DatPhongDAO();
	private DatPhongDao datPhongDAO = new DatPhongImpl();
//	private QuanLyHoaDonDAO quanLyHoaDonDAO = new QuanLyHoaDonDAO();
	private HoaDonDao quanLyHoaDonDAO = new HoaDonImpl();
//	private QuanLyPhieuDatPhongDAO quanLyPhieuDatPhongDAO = new QuanLyPhieuDatPhongDAO();
	private PhieuDatPhongDao quanLyPhieuDatPhongDAO = new PhieuDatPhongImpl();

	private NhanVienEntity nhanVienEntity = null;
	private KhachHangEntity khachHangEntity = null;
	public ChiTietPhieuDatPhongEntity chiTietPhieuDatPhongEntity = null;
	public ChiTietDatPhongEntity chiTietDatPhongEntity = null;

	private String maPhongMoi = null;

	public GD_DatPhong(NhanVienEntity nhanVienEntity) {
		this.nhanVienEntity = nhanVienEntity;
		setLayout(null);
		setBounds(0, 0, 1365, 694);

		JPanel pnlDatPhong = new JPanel();
		pnlDatPhong.setBounds(0, 0, 1365, 694);
		add(pnlDatPhong);
		pnlDatPhong.setLayout(null);

		JPanel pnlChinh = new JPanel();
		pnlChinh.setBounds(0, 0, 672, 618);
		pnlDatPhong.add(pnlChinh);
		pnlChinh.setLayout(null);

		JPanel panel_NoiDung = new JPanel();
		panel_NoiDung.setBorder(new BevelBorder(BevelBorder.LOWERED));
		panel_NoiDung.setBackground(Color.WHITE);
		panel_NoiDung.setBounds(0, 0, 672, 618);
		pnlChinh.add(panel_NoiDung);
		panel_NoiDung.setLayout(null);

		pnlTimKiem = new JPanel();
		pnlTimKiem.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		pnlTimKiem.setBackground(new Color(230, 230, 250));
		pnlTimKiem.setBounds(0, 0, 672, 163);
		panel_NoiDung.add(pnlTimKiem);
		pnlTimKiem.setLayout(null);

		lblTimKiemTheoTrangThai = new JLabel("Trạng thái:");
		lblTimKiemTheoTrangThai.setSize(new Dimension(0, 35));
		lblTimKiemTheoTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblTimKiemTheoTrangThai.setBounds(363, 20, 80, 30);
		pnlTimKiem.add(lblTimKiemTheoTrangThai);

		String[] itemTrangThai = { "Tất cả", "Trống", "Đặt trước", "Đang sử dụng" };
		cmbmodelTrangThai = new DefaultComboBoxModel<String>(itemTrangThai);
		cmbTimKiemTheoTrangThai = new JComboBox<String>(cmbmodelTrangThai);
		cmbTimKiemTheoTrangThai.setSize(new Dimension(0, 35));
		cmbTimKiemTheoTrangThai.setBackground(new Color(255, 250, 250));
		cmbTimKiemTheoTrangThai.setBounds(442, 21, 200, 30);
		pnlTimKiem.add(cmbTimKiemTheoTrangThai);

		lblTimKiemTheoLoaiPhong = new JLabel("Loại phòng:");
		lblTimKiemTheoLoaiPhong.setSize(new Dimension(0, 35));
		lblTimKiemTheoLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblTimKiemTheoLoaiPhong.setBounds(30, 60, 80, 35);
		pnlTimKiem.add(lblTimKiemTheoLoaiPhong);

		String[] itemLoaiPhong = { "Tất cả", "Thường", "VIP" };
		cmbmodelLoaiPhong = new DefaultComboBoxModel<>(itemLoaiPhong);
		cmbTimKiemTheoLoaiPhong = new JComboBox<String>(cmbmodelLoaiPhong);
		cmbTimKiemTheoLoaiPhong.setBackground(new Color(255, 250, 250));
		cmbTimKiemTheoLoaiPhong.setSize(new Dimension(0, 35));
		cmbTimKiemTheoLoaiPhong.setBounds(110, 60, 200, 30);
		pnlTimKiem.add(cmbTimKiemTheoLoaiPhong);

		lblTimKiemTheoSoPhong = new JLabel("Số phòng:");
		lblTimKiemTheoSoPhong.setSize(new Dimension(0, 35));
		lblTimKiemTheoSoPhong.setForeground(Color.BLACK);
		lblTimKiemTheoSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblTimKiemTheoSoPhong.setBounds(30, 20, 80, 30);
		pnlTimKiem.add(lblTimKiemTheoSoPhong);

		txtTimKiemTheoSoPhong = new JTextField();
		txtTimKiemTheoSoPhong.setSize(new Dimension(0, 35));
		txtTimKiemTheoSoPhong.setBounds(110, 20, 200, 30);
		pnlTimKiem.add(txtTimKiemTheoSoPhong);
		txtTimKiemTheoSoPhong.setColumns(10);

		btnTimKiemPhong = new JButton("Tìm kiếm");
		btnTimKiemPhong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconTimKiem.png")));
		btnTimKiemPhong.setFont(new Font("Cambria", Font.BOLD, 14));
		btnTimKiemPhong.setBackground(new Color(144, 238, 144));
		btnTimKiemPhong.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiemPhong.setFocusable(false);
		btnTimKiemPhong.setBounds(492, 110, 150, 35);
		pnlTimKiem.add(btnTimKiemPhong);

		lblTimKiemTheoSucChua = new JLabel("Sức chứa:");
		lblTimKiemTheoSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblTimKiemTheoSucChua.setBounds(363, 61, 80, 30);
		pnlTimKiem.add(lblTimKiemTheoSucChua);

		String[] itemSucChua = { "Tất cả", "10 người", "20 người" };
		cmbmodelSucChua = new DefaultComboBoxModel<>(itemSucChua);
		cmbTimKiemTheoSucChua = new JComboBox<String>(cmbmodelSucChua);
		cmbTimKiemTheoSucChua.setBackground(new Color(255, 250, 250));
		cmbTimKiemTheoSucChua.setBounds(442, 61, 200, 30);
		pnlTimKiem.add(cmbTimKiemTheoSucChua);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconLamMoi.png")));
		btnLamMoi.setMnemonic(KeyEvent.VK_R);
		btnLamMoi.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setFocusable(false);
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setFont(new Font("Cambria", Font.BOLD, 14));
		btnLamMoi.setBounds(293, 110, 150, 35);
		pnlTimKiem.add(btnLamMoi);

		pnlDSPhong = new JPanel();
		pnlDSPhong.setBorder(null);
		pnlDSPhong.setBackground(new Color(230, 230, 250));
		pnlDSPhong.setBounds(0, 163, 672, 455);
		panel_NoiDung.add(pnlDSPhong);
		pnlDSPhong.setLayout(null);

		pnlDSTatCaPhong = new JPanel();
		pnlDSTatCaPhong.setBorder(new TitledBorder(null, "Danh S\u00E1ch Ph\u00F2ng", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlDSTatCaPhong.setBackground(new Color(230, 230, 250));
		pnlDSTatCaPhong.setBounds(167, 11, 495, 184);
		pnlDSPhong.add(pnlDSTatCaPhong);

		String[] cols = { "STT", "Mã phòng", "Số phòng", "Loại phòng", "Sức chứa", "Trạng thái" };
		tblmodelPhong = new DefaultTableModel(cols, 0);
		pnlDSTatCaPhong.setLayout(new BorderLayout(0, 0));
		tblPhong = new JTable(tblmodelPhong);
		tblPhong.setBorder(new CompoundBorder());
		scrDSPhong = new JScrollPane(tblPhong);
		scrDSPhong.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		scrDSPhong.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pnlDSTatCaPhong.add(scrDSPhong);
		scrDSPhong.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblPhong.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblPhong.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tblPhong.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tblPhong.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

		pnlPhongDaChon = new JPanel();
		pnlPhongDaChon.setBackground(new Color(230, 230, 250));
		pnlPhongDaChon.setBorder(new TitledBorder(null, "Ph\u00F2ng \u0111\u00E3 ch\u1ECDn", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlPhongDaChon.setBounds(167, 204, 495, 184);
		pnlDSPhong.add(pnlPhongDaChon);

		tblmodelPhongDaChon = new DefaultTableModel(cols, 0);
		pnlPhongDaChon.setLayout(new BorderLayout(0, 0));
		tblPhongDaChon = new JTable(tblmodelPhongDaChon);
		scrDSPhongDaChon = new JScrollPane(tblPhongDaChon);
		scrDSPhongDaChon.setAlignmentX(Component.RIGHT_ALIGNMENT);
		scrDSPhongDaChon.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		pnlPhongDaChon.add(scrDSPhongDaChon);

		tblPhongDaChon.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblPhongDaChon.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tblPhongDaChon.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tblPhongDaChon.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

		JPanel pnlButtonChucNang = new JPanel();
		pnlButtonChucNang.setBorder(null);
		pnlButtonChucNang.setBackground(new Color(230, 230, 250));
		pnlButtonChucNang.setFocusable(false);
		pnlButtonChucNang.setBounds(10, 26, 147, 356);
		pnlDSPhong.add(pnlButtonChucNang);
		pnlButtonChucNang.setLayout(new GridLayout(7, 1, 10, 10));

		btnChonPhong = new JButton("Chọn phòng");
		btnChonPhong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconThem2.png")));
		pnlButtonChucNang.add(btnChonPhong);
		btnChonPhong.setFont(new Font("Cambria", Font.BOLD, 14));
		btnChonPhong.setFocusable(false);
		btnChonPhong.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnChonPhong.setBackground(new Color(255, 128, 128));

		btnXoaPhongDaChon = new JButton("Xóa đã chọn");
		btnXoaPhongDaChon.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconXoa1.png")));
		pnlButtonChucNang.add(btnXoaPhongDaChon);
		btnXoaPhongDaChon.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnXoaPhongDaChon.setFocusable(false);
		btnXoaPhongDaChon.setBackground(new Color(255, 128, 128));
		btnXoaPhongDaChon.setFont(new Font("Cambria", Font.BOLD, 14));

		btnNhanPhong = new JButton("Nhận phòng");
		btnNhanPhong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconChon.png")));
		btnNhanPhong.setFont(new Font("Cambria", Font.BOLD, 14));
		btnNhanPhong.setFocusable(false);
		btnNhanPhong.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnNhanPhong.setBackground(new Color(255, 128, 128));
		pnlButtonChucNang.add(btnNhanPhong);

		btnDoiPhong = new JButton("Đổi phòng");
		btnDoiPhong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconChinhSua2.png")));
		pnlButtonChucNang.add(btnDoiPhong);
		btnDoiPhong.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnDoiPhong.setFocusable(false);
		btnDoiPhong.setBackground(new Color(255, 128, 128));
		btnDoiPhong.setFont(new Font("Cambria", Font.BOLD, 14));

		btnHuyPhongDatTruoc = new JButton("Hủy đặt trước");
		btnHuyPhongDatTruoc.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconHuy.png")));
		pnlButtonChucNang.add(btnHuyPhongDatTruoc);
		btnHuyPhongDatTruoc.setFont(new Font("Cambria", Font.BOLD, 14));
		btnHuyPhongDatTruoc.setFocusable(false);
		btnHuyPhongDatTruoc.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnHuyPhongDatTruoc.setBackground(new Color(255, 128, 128));

		btnXemDatTruoc = new JButton("Xem đặt trước");
		btnXemDatTruoc.setBackground(new Color(255, 128, 128));
		btnXemDatTruoc.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXemDatTruoc.setFocusable(false);
		btnXemDatTruoc.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconMatMo.png")));
		btnXemDatTruoc.setFont(new Font("Cambria", Font.BOLD, 14));
		pnlButtonChucNang.add(btnXemDatTruoc);

		Integer[] gioNhanPhong = new Integer[15];
		for (int i = 0; i <= 14; i++) {
			gioNhanPhong[i] = i + 8;
		}

		Integer[] phutNhanPhong = new Integer[60];
		for (int i = 0; i < 60; i++) {
			phutNhanPhong[i] = i;
		}

		Integer[] gioTraPhong = new Integer[15];
		for (int i = 0; i <= 14; i++) {
			gioTraPhong[i] = i + 9;
		}

		Integer[] phutTraPhong = new Integer[60];
		for (int i = 0; i < 60; i++) {
			phutTraPhong[i] = i;
		}

		pnlChiTietDatPhong = new JPanel();
		pnlChiTietDatPhong.setBounds(672, 0, 694, 618);
		pnlDatPhong.add(pnlChiTietDatPhong);
		pnlChiTietDatPhong.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pnlChiTietDatPhong.setBackground(new Color(230, 230, 250));
		pnlChiTietDatPhong.setLayout(null);

		pnlGioNhanPhong = new JPanel();
		pnlGioNhanPhong.setBackground(new Color(230, 230, 250));
		pnlGioNhanPhong.setBorder(new TitledBorder(null, "Gi\u1EDD nh\u1EADn ph\u00F2ng", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pnlGioNhanPhong.setBounds(87, 423, 220, 96);
		pnlGioNhanPhong.setLayout(null);
		pnlChiTietDatPhong.add(pnlGioNhanPhong);

		cmbmodelGioNhanPhong = new DefaultComboBoxModel<>(gioNhanPhong);
		cmbGioNhanPhong = new JComboBox<Integer>(cmbmodelGioNhanPhong);
		cmbGioNhanPhong.setMaximumRowCount(4);
		cmbGioNhanPhong.setEnabled(false);
		cmbGioNhanPhong.setBounds(21, 18, 132, 25);
		pnlGioNhanPhong.add(cmbGioNhanPhong);

		cmbmodelPhutNhanPhong = new DefaultComboBoxModel<>(phutNhanPhong);
		cmbPhutNhanPhong = new JComboBox<Integer>(cmbmodelPhutNhanPhong);
		cmbPhutNhanPhong.setMaximumRowCount(4);
		cmbPhutNhanPhong.setEnabled(false);
		cmbPhutNhanPhong.setBounds(21, 60, 132, 25);
		pnlGioNhanPhong.add(cmbPhutNhanPhong);

		JLabel lblPhutNhanPhong = new JLabel("Phút");
		lblPhutNhanPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblPhutNhanPhong.setBounds(165, 60, 40, 25);
		pnlGioNhanPhong.add(lblPhutNhanPhong);

		JLabel lblGioNhanPhong = new JLabel("Giờ");
		lblGioNhanPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblGioNhanPhong.setBounds(165, 18, 40, 25);
		pnlGioNhanPhong.add(lblGioNhanPhong);

		pnlGioTraPhong = new JPanel();
		pnlGioTraPhong.setLayout(null);
		pnlGioTraPhong.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Giờ trả phòng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlGioTraPhong.setBackground(new Color(230, 230, 250));
		pnlGioTraPhong.setBounds(369, 423, 220, 97);
		pnlChiTietDatPhong.add(pnlGioTraPhong);

		cmbmodelGioTraPhong = new DefaultComboBoxModel<>(gioTraPhong);
		cmbGioTraPhong = new JComboBox<Integer>(cmbmodelGioTraPhong);
		cmbGioTraPhong.setMaximumRowCount(4);
		cmbGioTraPhong.setBounds(23, 18, 132, 25);
		pnlGioTraPhong.add(cmbGioTraPhong);

		cmbmodelPhutTraPhong = new DefaultComboBoxModel<>(phutTraPhong);
		cmbPhutTraPhong = new JComboBox<Integer>(cmbmodelPhutTraPhong);
		cmbPhutTraPhong.setMaximumRowCount(4);
		cmbPhutTraPhong.setBounds(23, 60, 132, 25);
		pnlGioTraPhong.add(cmbPhutTraPhong);

		lblPhutTraPhong = new JLabel("Phút");
		lblPhutTraPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblPhutTraPhong.setBounds(165, 60, 40, 25);
		pnlGioTraPhong.add(lblPhutTraPhong);

		lblGioTraPhong = new JLabel("Giờ");
		lblGioTraPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblGioTraPhong.setBounds(165, 18, 40, 25);
		pnlGioTraPhong.add(lblGioTraPhong);

		pnlChanTrang = new JPanel();
		pnlChanTrang.setBackground(SystemColor.inactiveCaptionBorder);
		pnlChanTrang.setBounds(0, 616, 1365, 78);
		pnlDatPhong.add(pnlChanTrang);
		pnlChanTrang.setLayout(null);

		lblImgChuThichPhongTrong = new JLabel("");
		lblImgChuThichPhongTrong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconPhongTrong.png")));
		lblImgChuThichPhongTrong.setBounds(70, 7, 40, 40);
		pnlChanTrang.add(lblImgChuThichPhongTrong);

		lblChuThichPhongTrong = new JLabel("Phòng trống");
		lblChuThichPhongTrong.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblChuThichPhongTrong.setBounds(57, 48, 67, 18);
		pnlChanTrang.add(lblChuThichPhongTrong);

		lblImgChuThichPhongCho = new JLabel("");
		lblImgChuThichPhongCho.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconPhongDatTruoc.png")));
		lblImgChuThichPhongCho.setBounds(198, 7, 40, 40);
		pnlChanTrang.add(lblImgChuThichPhongCho);

		lblChuThichPhongCho = new JLabel("Phòng đặt trước");
		lblChuThichPhongCho.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblChuThichPhongCho.setBounds(173, 47, 86, 20);
		pnlChanTrang.add(lblChuThichPhongCho);

		lblImgChuThichPhongDangSuDung = new JLabel("");
		lblImgChuThichPhongDangSuDung
				.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconPhongDangSuDung.png")));
		lblImgChuThichPhongDangSuDung.setBounds(326, 7, 40, 40);
		pnlChanTrang.add(lblImgChuThichPhongDangSuDung);

		lblChuThichPhongDangSuDung = new JLabel("Phòng đang sử dụng");
		lblChuThichPhongDangSuDung.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblChuThichPhongDangSuDung.setBounds(296, 48, 111, 18);
		pnlChanTrang.add(lblChuThichPhongDangSuDung);

		lblImgChuThichPhongVIP = new JLabel("");
		lblImgChuThichPhongVIP.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconVIP.png")));
		lblImgChuThichPhongVIP.setBounds(454, 7, 40, 40);
		pnlChanTrang.add(lblImgChuThichPhongVIP);

		lblChuThichPhongVIP = new JLabel("VIP");
		lblChuThichPhongVIP.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblChuThichPhongVIP.setBounds(466, 48, 17, 18);
		pnlChanTrang.add(lblChuThichPhongVIP);

		lblNgayHienTai = new JLabel("28/06/2023");
		lblNgayHienTai.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNgayHienTai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgayHienTai.setBounds(1243, 36, 94, 30);
		ngayHT = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblNgayHienTai.setText(DateFormatter.format(LocalDate.now()));
			}
		});
		ngayHT.start();
		pnlChanTrang.add(lblNgayHienTai);

		lblGioHienTai = new JLabel("16:06");
		lblGioHienTai.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGioHienTai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGioHienTai.setBounds(1284, 16, 53, 30);
		gioHT = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblGioHienTai.setText(TimeFormatter.format(LocalTime.now()));
			}
		});
		gioHT.start();
		pnlChanTrang.add(lblGioHienTai);

		lblVIP = new JLabel("");
		lblVIP.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconVIP1.png")));
		lblVIP.setBounds(506, 113, 60, 53);
		lblVIP.setVisible(false);
		pnlChiTietDatPhong.add(lblVIP);

		lblChiTietDatPhong = new JLabel("Chi tiết đặt phòng");
		lblChiTietDatPhong.setBackground(new Color(230, 230, 250));
		lblChiTietDatPhong.setBounds(0, 57, 694, 50);
		lblChiTietDatPhong.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietDatPhong.setFont(new Font("Segoe UI", Font.BOLD, 22));
		pnlChiTietDatPhong.add(lblChiTietDatPhong);

		txtSoPhong = new JTextField();
		txtSoPhong.setBorder(null);
		txtSoPhong.setEditable(false);
		txtSoPhong.setBounds(200, 120, 200, 25);
		pnlChiTietDatPhong.add(txtSoPhong);
		txtSoPhong.setColumns(10);

		lblSoPhong = new JLabel("Số phòng:");
		lblSoPhong.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSoPhong.setBounds(50, 120, 110, 25);
		pnlChiTietDatPhong.add(lblSoPhong);

		lblLoaiPhong = new JLabel("Loại phòng:");
		lblLoaiPhong.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblLoaiPhong.setBounds(50, 170, 111, 25);
		pnlChiTietDatPhong.add(lblLoaiPhong);

		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setBorder(null);
		txtLoaiPhong.setEditable(false);
		txtLoaiPhong.setBounds(200, 170, 200, 25);
		pnlChiTietDatPhong.add(txtLoaiPhong);
		txtLoaiPhong.setColumns(10);

		lblSucChua = new JLabel("Sức chứa:");
		lblSucChua.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSucChua.setBounds(51, 220, 110, 25);
		pnlChiTietDatPhong.add(lblSucChua);

		txtSucChua = new JTextField();
		txtSucChua.setBorder(null);
		txtSucChua.setEditable(false);
		txtSucChua.setBounds(200, 220, 200, 25);
		pnlChiTietDatPhong.add(txtSucChua);
		txtSucChua.setColumns(10);

		lblImgTrangThaiPhong = new JLabel("");
		lblImgTrangThaiPhong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconPhong2.png")));
		lblImgTrangThaiPhong.setBounds(458, 124, 180, 180);
		pnlChiTietDatPhong.add(lblImgTrangThaiPhong);

		lblSDTKhachHang = new JLabel("SĐT khách hàng:");
		lblSDTKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSDTKhachHang.setBounds(50, 320, 120, 25);
		pnlChiTietDatPhong.add(lblSDTKhachHang);

		lblTenKhachHang = new JLabel("Tên khách hàng:");
		lblTenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTenKhachHang.setBounds(51, 270, 120, 25);
		pnlChiTietDatPhong.add(lblTenKhachHang);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setBorder(null);
		txtTenKhachHang.setEditable(false);
		txtTenKhachHang.setBounds(200, 270, 200, 25);
		pnlChiTietDatPhong.add(txtTenKhachHang);
		txtTenKhachHang.setColumns(10);

		txtSDTKhachHang = new JTextField();
		txtSDTKhachHang.setToolTipText("Nhập SĐT khách hàng cần tìm");
		txtSDTKhachHang.setBounds(200, 320, 200, 25);
		pnlChiTietDatPhong.add(txtSDTKhachHang);
		txtSDTKhachHang.setColumns(10);

		btnTimKiemKhachHang = new JButton("Tìm kiếm");
		btnTimKiemKhachHang.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiemKhachHang.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconTimKiem.png")));
		btnTimKiemKhachHang.setMnemonic(KeyEvent.VK_F);
		btnTimKiemKhachHang.setFocusable(false);
		btnTimKiemKhachHang.setBackground(new Color(144, 238, 144));
		btnTimKiemKhachHang.setFont(new Font("Cambria", Font.BOLD, 14));
		btnTimKiemKhachHang.setBounds(488, 317, 150, 35);
		pnlChiTietDatPhong.add(btnTimKiemKhachHang);

		radDatPhongNgay = new JRadioButton("Đặt phòng ngay");
		radDatPhongNgay.setBackground(new Color(230, 230, 250));
		radDatPhongNgay.setSelected(true);
		radDatPhongNgay.setName("");
		radDatPhongNgay.setFocusable(false);
		radDatPhongNgay.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		radDatPhongNgay.setBounds(87, 555, 140, 30);
		pnlChiTietDatPhong.add(radDatPhongNgay);

		radDatPhongTruoc = new JRadioButton("Đặt phòng trước");
		radDatPhongTruoc.setBackground(new Color(230, 230, 250));
		radDatPhongTruoc.setName("");
		radDatPhongTruoc.setFocusable(false);
		radDatPhongTruoc.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		radDatPhongTruoc.setBounds(245, 555, 150, 30);
		pnlChiTietDatPhong.add(radDatPhongTruoc);

		grpDatPhong = new ButtonGroup();
		grpDatPhong.add(radDatPhongNgay);
		grpDatPhong.add(radDatPhongTruoc);

		btnDatPhong = new JButton("Đặt phòng");
		btnDatPhong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconTick.png")));
		btnDatPhong.setMnemonic(KeyEvent.VK_ENTER);
		btnDatPhong.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnDatPhong.setFocusable(false);
		btnDatPhong.setBackground(new Color(144, 238, 144));
		btnDatPhong.setFont(new Font("Cambria", Font.BOLD, 14));
		btnDatPhong.setBounds(437, 550, 150, 40);
		pnlChiTietDatPhong.add(btnDatPhong);

		JLabel lblNewLabel = new JLabel("Chọn ngày:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(87, 370, 73, 25);
		pnlChiTietDatPhong.add(lblNewLabel);

		chonNgayDatTruoc = new JDateChooser();
		chonNgayDatTruoc.setDateFormatString("dd-MM-yyyy");
		chonNgayDatTruoc.setDate(Date.valueOf(LocalDate.now()));
		chonNgayDatTruoc.setEnabled(false);
		chonNgayDatTruoc.setBounds(200, 370, 200, 25);
		pnlChiTietDatPhong.add(chonNgayDatTruoc);

		DatPhongController controller = new DatPhongController(this);
		radDatPhongNgay.addActionListener(controller);
		radDatPhongTruoc.addActionListener(controller);
		btnLamMoi.addActionListener(controller);
		btnTimKiemPhong.addActionListener(controller);
		btnTimKiemKhachHang.addActionListener(controller);
		btnChonPhong.addActionListener(controller);
		btnXoaPhongDaChon.addActionListener(controller);
		btnNhanPhong.addActionListener(controller);
		btnDoiPhong.addActionListener(controller);
		btnHuyPhongDatTruoc.addActionListener(controller);
		btnXemDatTruoc.addActionListener(controller);
		btnDatPhong.addActionListener(controller);
		tblPhong.addMouseListener(controller);
		tblPhongDaChon.addMouseListener(controller);

		loadData();
	}

	private void loadData() {
		tblPhong.removeAll();
		tblPhong.setRowSelectionAllowed(false);
		tblmodelPhong.setRowCount(0);
		listPhong = quanLyPhongDAO.duyetDanhSach();
		capNhatTrangThaiPhong(listPhong);

		int stt = 1;
		for (PhongEntity phongEntity : listPhong) {
			boolean kiemTra = true;
			for (int i = 0; i < tblPhongDaChon.getRowCount(); i++) {
				if (phongEntity.getMaPhong().equalsIgnoreCase(tblmodelPhongDaChon.getValueAt(i, 1).toString())) {
					kiemTra = false;
					break;
				}
			}
			if (kiemTra) {
				tblmodelPhong.addRow(new Object[] { stt++, phongEntity.getMaPhong(), phongEntity.getSoPhong(),
						phongEntity.getLoaiPhong().getTenLoaiPhong(), phongEntity.getSucChua(),
						phongEntity.getTrangThai() });
			}
		}
	}

	private void capNhatTrangThaiPhong(List<PhongEntity> listPhong) {
		List<ChiTietDatPhongEntity> listChiTietDatPhong = new ArrayList<>();
		for (PhongEntity phongEntity : listPhong) {
			String trangThai = "Trống";
			listChiTietDatPhong = datPhongDAO.duyetChiTietDatPhongChuaThanhToanTheoPhong(phongEntity);
			if (listChiTietDatPhong.size() > 0) {
				for (ChiTietDatPhongEntity chiTietDatPhongEntity : listChiTietDatPhong) {
					LocalTime gioHienTai = LocalTime.now();
					if (gioHienTai.isAfter(chiTietDatPhongEntity.getGioNhanPhong())
							&& gioHienTai.isBefore(chiTietDatPhongEntity.getGioTraPhong())) {
						trangThai = "Đang sử dụng";
						quanLyPhongDAO.capNhatTrangThaiPhong(phongEntity, trangThai);
						return;
					}
				}
				trangThai = "Đặt trước";
				quanLyPhongDAO.capNhatTrangThaiPhong(phongEntity, trangThai);
			} else {
				quanLyPhongDAO.capNhatTrangThaiPhong(phongEntity, trangThai);
			}
		}
	}

	/****************** CHỌN ĐẶT PHÒNG NGAY ******************/
	public void chonDatPhongNgay() {
		cmbGioNhanPhong.setEnabled(true);
		cmbPhutNhanPhong.setEnabled(true);

		for (int i = 0; i < tblPhongDaChon.getRowCount(); i++) {
			PhongEntity phongEntity = quanLyPhongDAO.timTheoMa(tblPhongDaChon.getValueAt(i, 1).toString());
			if (phongEntity.getTrangThai().equals("Đang sử dụng")) {
				JOptionPane.showMessageDialog(this, "Danh sách chọn có phòng đang sử dụng.\nKhông thể đặt phòng ngay");
				radDatPhongTruoc.setSelected(true);
				return;
			}
		}
		String gio = lblGioHienTai.getText().substring(0, 2);
		String phut = lblGioHienTai.getText().substring(3, 5);
		cmbGioNhanPhong.setSelectedItem(gio);
		cmbPhutNhanPhong.setSelectedItem(phut);
		cmbGioNhanPhong.setEnabled(false);
		cmbPhutNhanPhong.setEnabled(false);
		chonNgayDatTruoc.setEnabled(false);

	}

	/****************** CHỌN ĐẶT PHÒNG TRƯỚC ******************/
	public void chonDatPhongTruoc() {
		cmbGioNhanPhong.setEnabled(true);
		cmbPhutNhanPhong.setEnabled(true);
		chonNgayDatTruoc.setEnabled(true);
	}

	/****************** HIỂN THỊ THÔNG TIN PHÒNG ******************/
	public void hienThiThongTinPhong() {
		int row = tblPhong.getSelectedRow();
		if (row >= 0) {
			String loaiPhong = tblPhong.getValueAt(row, 3).toString();
			String trangThai = tblPhong.getValueAt(row, 5).toString();
			txtSoPhong.setText(tblPhong.getValueAt(row, 2).toString());
			txtLoaiPhong.setText(loaiPhong);
			txtSucChua.setText(tblPhong.getValueAt(row, 4).toString());
			lblImgTrangThaiPhong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconPhongTrong1.png")));
			if (trangThai.equalsIgnoreCase("Đang sử dụng")) {
				lblImgTrangThaiPhong
						.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconPhongDangSuDung1.png")));
			} else if (trangThai.equalsIgnoreCase("Đặt trước")) {
				lblImgTrangThaiPhong
						.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconPhongDatTruoc1.png")));
			}
			if (loaiPhong.equalsIgnoreCase("VIP")) {
				lblVIP.setVisible(true);
			} else {
				lblVIP.setVisible(false);
			}
		}
	}

	/****************** HIỂN THỊ THÔNG TIN PHÒNG ĐÃ CHỌN ******************/
	public void hienThiThongTinPhongDaChon() {
		int row = tblPhongDaChon.getSelectedRow();
		if (row >= 0) {
			String loaiPhong = tblPhongDaChon.getValueAt(row, 3).toString();
			txtSoPhong.setText(tblPhongDaChon.getValueAt(row, 2).toString());
			txtLoaiPhong.setText(loaiPhong);
			txtSucChua.setText(tblPhongDaChon.getValueAt(row, 4).toString());
			lblImgTrangThaiPhong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconPhong2.png")));
			if (loaiPhong.equalsIgnoreCase("VIP")) {
				lblVIP.setVisible(true);
			} else {
				lblVIP.setVisible(false);
			}
		}
	}

	/****************** LÀM MỚI ******************/
	public void chonLamMoi() {
		txtSoPhong.setText("");
		txtLoaiPhong.setText("");
		txtSucChua.setText("");
		txtTenKhachHang.setText("");
		txtTimKiemTheoSoPhong.setText("");
		txtSDTKhachHang.setText("");
		radDatPhongNgay.setSelected(true);
		chonDatPhongNgay();
		chonNgayDatTruoc.setDate(Date.valueOf(LocalDate.now()));
		cmbGioNhanPhong.setSelectedIndex(0);
		cmbGioTraPhong.setSelectedIndex(0);
		cmbTimKiemTheoLoaiPhong.setSelectedIndex(0);
		cmbTimKiemTheoSucChua.setSelectedIndex(0);
		cmbTimKiemTheoTrangThai.setSelectedIndex(0);
		lblImgTrangThaiPhong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconPhong2.png")));
		loadData();
	}

	/************************************
	 * TÌM KIẾM PHÒNG
	 ************************************/
	public void chonTimKiemPhong() {
		if (kiemTraSoPhong()) {
			String trangThai = cmbTimKiemTheoTrangThai.getSelectedItem().toString();
			String loaiPhong = cmbTimKiemTheoLoaiPhong.getSelectedItem().toString();
			int soPhong = -1;
			int sucChua = -1;
			if (txtTimKiemTheoSoPhong.getText().trim().length() > 0)
				soPhong = Integer.parseInt(txtTimKiemTheoSoPhong.getText().trim());

			if (cmbTimKiemTheoSucChua.getSelectedIndex() == 1)
				sucChua = 10;
			else if (cmbTimKiemTheoSucChua.getSelectedIndex() == 2)
				sucChua = 20;

			tblPhong.removeAll();
			tblmodelPhong.setRowCount(0);
			listPhong = datPhongDAO.timPhong(trangThai, loaiPhong, soPhong, sucChua);

			int stt = 1;
			for (PhongEntity phongEntity : listPhong) {
				tblmodelPhong.addRow(new Object[] { stt++, phongEntity.getMaPhong(), phongEntity.getSoPhong(),
						phongEntity.getLoaiPhong().getTenLoaiPhong(), phongEntity.getSucChua(),
						phongEntity.getTrangThai() });
			}

		}
	}

	/************************************
	 * TÌM KIẾM KHÁCH HÀNG
	 ************************************/
	public void chonTimKiemKhachHang() {
		if (kiemTraSoDienThoai()) {
			String soDienThoai = txtSDTKhachHang.getText().trim();
			khachHangEntity = quanLyKhachHangDAO.timTheoSoDienThoai(soDienThoai);
			if (khachHangEntity != null) {
				txtTenKhachHang.setText(khachHangEntity.getHoTen());
			} else {
				if (JOptionPane.showConfirmDialog(this, "Không có khách hàng này. Có muốn thêm khách hàng?",
						"Thống báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					GD_TrangChu manHinhCha = (GD_TrangChu) this.getTopLevelAncestor();
					manHinhCha.chonDanhMucKhachHang();
				}
			}
		}
	}

	/************************************
	 * CHỌN PHÒNG
	 ************************************/
	public void chonChonPhong() {
		int row = tblPhong.getSelectedRow();
		if (row >= 0) {
			String trangThai = tblPhong.getValueAt(row, 5).toString();
			if (radDatPhongNgay.isSelected()) {
				if (trangThai.equalsIgnoreCase("Đang sử dụng")) {
					if (JOptionPane.showConfirmDialog(this,
							"Phòng này đang được sử dụng.\nHãy chọn phòng khác hoặc chọn đặt trước\n(Chọn Yes để đặt trước)",
							"Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						radDatPhongTruoc.setSelected(true);
						chonDatPhongTruoc();
					} else {
						return;
					}
				}
			}
			if (trangThai.equalsIgnoreCase("Đặt trước")) {
				if (JOptionPane.showConfirmDialog(this,
						"Phòng này đã được đặt trước. Không được đặt trùng thời gian \n với các khách hàng đã đặt trước. Có muốn tiếp tục chọn?",
						"Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
					return;
				}
			}
			String maPhong = tblPhong.getValueAt(row, 1).toString();
			String loaiPhong = tblPhong.getValueAt(row, 3).toString();
			int soPhong = Integer.parseInt(tblPhong.getValueAt(row, 2).toString());
			int sucChua = Integer.parseInt(tblPhong.getValueAt(row, 4).toString());
			int stt = tblPhongDaChon.getRowCount();
			tblmodelPhongDaChon.addRow(new Object[] { ++stt, maPhong, soPhong, loaiPhong, sucChua, "Tạm giữ" });
			loadData();
		} else {
			JOptionPane.showMessageDialog(this, "Hãy chọn phòng");
			return;
		}
	}

	/****************** XÓA PHÒNG ĐÃ CHỌN ******************/
	public void chonXoaPhongDaChon() {
		int row = tblPhongDaChon.getSelectedRow();
		if (row >= 0) {
			for (int i = row + 1; i < tblPhongDaChon.getRowCount(); i++) {
				tblPhongDaChon.setValueAt(i, i, 0);
			}
			tblmodelPhongDaChon.removeRow(row);
			loadData();
		} else {
			JOptionPane.showMessageDialog(this, "Hãy chọn phòng cần xóa");
			return;
		}
	}

	/************************************
	 * NHẬN PHÒNG
	 ************************************/
	public void chonNhanPhong() {
		new GD_XemChiTietDatPhongTruoc(new SendData<ChiTietPhieuDatPhongEntity>() {
			@Override
			public void send(ChiTietPhieuDatPhongEntity e) {
				chiTietPhieuDatPhongEntity = e;
				if (chiTietPhieuDatPhongEntity == null) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng");
					return;
				} else {
//					chiTietDatPhongEntity = quanLyHoaDonDAO
//							.timChiTietDatPhongTheoMa(chiTietPhieuDatPhongEntity.getMaChiTietDatPhong());
					chiTietDatPhongEntity = quanLyHoaDonDAO.timChiTietDatPhongTheoMa(
							chiTietPhieuDatPhongEntity.getChiTietDatPhong().getMaChiTietDatPhong());
					// kiem tra neu ngay nhan phong cua phieu dat do la hom nay + gio nhan phong
					// trước gio hien tai 5 phut hoac sau gio hien tai 15 phut
					if (chiTietDatPhongEntity.getNgayNhanPhong().equals(LocalDate.now())
							&& chiTietDatPhongEntity.getGioNhanPhong().isAfter(LocalTime.now().minusMinutes(5))
							&& chiTietDatPhongEntity.getGioNhanPhong().isBefore(LocalTime.now().plusMinutes(15))) {
						String trangThai = "Đang sử dụng";
						if (quanLyPhongDAO.capNhatTrangThaiPhong(chiTietDatPhongEntity.getPhong(), trangThai)) {
							JOptionPane.showMessageDialog(null, "Nhận phòng thành công");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Hiện tại không được phép nhận phòng");
						return;
					}
				}
			}
		}).setVisible(true);
	}

	/************************************
	 * ĐỔI PHÒNG
	 ************************************/
	public void chonDoiPhong() {
		new GD_XemChiTietDatPhongTruoc(new SendData<ChiTietPhieuDatPhongEntity>() {
			@Override
			public void send(ChiTietPhieuDatPhongEntity e) {
				chiTietPhieuDatPhongEntity = e;
				if (chiTietPhieuDatPhongEntity == null) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng");
					return;
				} else {
//					chiTietDatPhongEntity = quanLyHoaDonDAO
//							.timChiTietDatPhongTheoMa(chiTietPhieuDatPhongEntity.getMaChiTietDatPhong());
					chiTietDatPhongEntity = quanLyHoaDonDAO.timChiTietDatPhongTheoMa(
							chiTietPhieuDatPhongEntity.getChiTietDatPhong().getMaChiTietDatPhong());
					btnDoiPhong.setText("Kiểm tra");
					btnDoiPhong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconDanhMuc1.png")));
				}
			}
		}).setVisible(true);
	}

	public void chonKiemTra() {
		btnDoiPhong.setText("Xác nhận đổi");
		btnDoiPhong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconChon1.png")));
		tblPhong.removeAll();
		tblPhong.setRowSelectionAllowed(false);
		tblmodelPhong.setRowCount(0);
		listPhong = datPhongDAO.timPhongTrongTheoNgayVaGio(chiTietDatPhongEntity.getNgayNhanPhong(),
				chiTietDatPhongEntity.getGioNhanPhong(), chiTietDatPhongEntity.getGioTraPhong());
		int stt = 1;
		for (PhongEntity phongEntity : listPhong) {
			tblmodelPhong.addRow(new Object[] { stt++, phongEntity.getMaPhong(), phongEntity.getSoPhong(),
					phongEntity.getLoaiPhong().getTenLoaiPhong(), phongEntity.getSucChua(),
					phongEntity.getTrangThai() });

		}
	}

	public void chonXacNhanDoiPhong() {
		int row = tblPhong.getSelectedRow();
		if (row >= 0) {
			maPhongMoi = tblPhong.getValueAt(row, 1).toString();
			if (datPhongDAO.doiPhong(chiTietDatPhongEntity, maPhongMoi)) {
				btnDoiPhong.setText("Đổi phòng");
				btnDoiPhong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconChinhSua2.png")));
				JOptionPane.showMessageDialog(this, "Đổi phòng thành công");
				loadData();
			} else {
				System.out.println(1);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng để đổi");
		}
	}

	/************************************
	 * HỦY PHÒNG ĐẶT TRƯỚC
	 ************************************/
	public void chonHuyPhongDatTruoc() {
		new GD_XemChiTietDatPhongTruoc(new SendData<ChiTietPhieuDatPhongEntity>() {
			@Override
			public void send(ChiTietPhieuDatPhongEntity e) {
				chiTietPhieuDatPhongEntity = e;
				if (chiTietPhieuDatPhongEntity != null) {
					ChiTietDatPhongEntity chiTietDatPhongEntity = quanLyHoaDonDAO.timChiTietDatPhongTheoMa(
							chiTietPhieuDatPhongEntity.getChiTietDatPhong().getMaChiTietDatPhong());
//					
					PhieuDatPhongEntity phieuDatPhongEntity = quanLyPhieuDatPhongDAO
							.timPhieuDatPhongTheoMa(chiTietPhieuDatPhongEntity.getPhieuDatPhong().getMaPhieuDatPhong());
					// neu gio nhan phong sau gio hien tai 1 gio nua thi duoc phep huy phong
					if (chiTietDatPhongEntity.getNgayNhanPhong().isAfter(LocalDate.now()) || (chiTietDatPhongEntity
							.getNgayNhanPhong().equals(LocalDate.now())
							&& chiTietDatPhongEntity.getGioNhanPhong().isAfter(LocalTime.now().minusHours(1)))) {
						String maChiTietDatPhong = chiTietDatPhongEntity.getMaChiTietDatPhong();
						ChiTietHoaDonEntity chiTietHoaDonEntity = quanLyHoaDonDAO
								.timChiTietHoaDonTheoChiTietDatPhong(chiTietDatPhongEntity);
						// neu phong do co dat dich vu thi xoa cac don dat dich vu truoc
						// thu tu xoa: chiTietDichVu -> chiTietHoaDon -> chiTietPhieuDatPhong ->
						// phieuDatPhong + chiTietDatPhong -> cap nhat trang thai phong
						List<ChiTietDichVuEntity> listChiTietDichVu = quanLyHoaDonDAO
								.duyetDanhSachChiTietDichVuTheoChiTietHoaDon(chiTietHoaDonEntity.getMaChiTietHoaDon());
						if (listChiTietDichVu.size() > 0)
							if (!quanLyHoaDonDAO.xoaChiTietDichvuTheoMaHoaDon(chiTietHoaDonEntity.getMaChiTietHoaDon()))
								return;

						if (quanLyHoaDonDAO.xoaChiTietHoaDon(maChiTietDatPhong)) {
							if (quanLyPhieuDatPhongDAO.xoaChiTietPhieuDatPhong(maChiTietDatPhong)) {
								// neu phieu dat phong do khong con phong nao thi xoa phieu dat phong
								List<ChiTietPhieuDatPhongEntity> listChiTietPhieuDatPhong = quanLyPhieuDatPhongDAO
										.duyetDanhSachChiTietPhieuDatPhongTheoPhieuDatPhong(
												phieuDatPhongEntity.getMaPhieuDatPhong());
								if (listChiTietPhieuDatPhong.size() == 0) {
									if (!quanLyPhieuDatPhongDAO
											.xoaPhieuDatPhong(phieuDatPhongEntity.getMaPhieuDatPhong())) {
										return;
									}
								}
								if (quanLyHoaDonDAO.xoaChiTietDatPhong(maChiTietDatPhong)) {
									JOptionPane.showMessageDialog(null, "Hủy phòng thành công");
									chonLamMoi();
								}

							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "Chỉ được phép hủy trước giờ hiện tại 2 giờ");
						return;
					}
				} else {
					JOptionPane.showMessageDialog(null, "Hãy chọn phòng");
					return;
				}
			}
		}).setVisible(true);
	}

	/************************************
	 * XEM PHÒNG ĐẶT TRƯỚC
	 ************************************/
	public void chonXemDatTruoc() {
		new GD_XemChiTietDatPhongTruoc(new SendData<ChiTietPhieuDatPhongEntity>() {

			@Override
			public void send(ChiTietPhieuDatPhongEntity e) {
				// TODO Auto-generated method stub
			}
		}).setVisible(true);
	}

	/************************************
	 * ĐẶT PHÒNG
	 ************************************/
	public void chonDatPhong() {
		if (kiemTraDuLieuDatPhong()) {
			List<PhongEntity> listPhongDuocChon = new ArrayList<>();
			List<ChiTietDatPhongEntity> listChiTietDatPhong = new ArrayList<>();

			LocalTime gioNhanPhong = LocalTime.now();
			LocalTime gioTraPhong = gioNhanPhong.plusHours(1);
			LocalDate ngayNhanPhong = LocalDate.now();
			int gioNhan = Integer.parseInt(cmbGioNhanPhong.getSelectedItem().toString());
			int gioTra = Integer.parseInt(cmbGioTraPhong.getSelectedItem().toString());
			int phutNhan = Integer.parseInt(cmbPhutNhanPhong.getSelectedItem().toString());
			int phutTra = Integer.parseInt(cmbPhutTraPhong.getSelectedItem().toString());
			String trangThaiPhong = "Đang sử dụng";
			// tạo listPhong với tblPhongDaChon
			for (int i = 0; i < tblPhongDaChon.getRowCount(); i++) {
				String maPhong = tblPhongDaChon.getValueAt(i, 1).toString();
				PhongEntity phongEntity = quanLyPhongDAO.timTheoMa(maPhong);
				listPhongDuocChon.add(phongEntity);
			}

			/********************************************/
			if (radDatPhongTruoc.isSelected()) {
				trangThaiPhong = "Đặt trước";
				// neu chua chon ngay
				if (chonNgayDatTruoc.getDate() == null) {
					JOptionPane.showMessageDialog(this, "Hãy chọn ngày nhận phòng");
					return;
				} else {
					LocalDate ngayNhanPhong1 = DateFormatter.toLocalDate(chonNgayDatTruoc);
					// neu chon ngay truoc hom nay thi thong bao
					if (ngayNhanPhong1.isBefore(LocalDate.now())) {
						JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày nhận phòng gần nhất là hôm nay");
						return;
					}
					ngayNhanPhong = ngayNhanPhong1;
					LocalTime gioNhanPhong1 = LocalTime.of(gioNhan, phutNhan);
					if (ngayNhanPhong.isEqual(LocalDate.now())
							&& gioNhanPhong1.isBefore(LocalTime.now().plusHours(2))) {
						JOptionPane.showMessageDialog(this,
								"Giờ nhận phòng đặt trước phải sau giờ hiện tại ít nhất 2 giờ");
						return;
					} else {
						for (PhongEntity phongEntity : listPhongDuocChon) {
							listChiTietDatPhong = quanLyHoaDonDAO.timChiTietDatPhongChuaThanhToanTheoPhong(phongEntity);
							for (ChiTietDatPhongEntity chiTietDatPhongEntity : listChiTietDatPhong) {
								// kiem tra trong danh sach chi tiet dat phong co phong nao da duoc dat trong
								// khoang thoi gian duoc chon hay khong. Neu co thi thong bao.
								// Quy dinh la khong duoc dat truoc 30 va sau 30 mot chi tiet dat phong khac
								if (ngayNhanPhong.equals(chiTietDatPhongEntity.getNgayNhanPhong())
										&& (gioNhanPhong1
												.isAfter(chiTietDatPhongEntity.getGioNhanPhong().minusMinutes(30)))
										&& gioNhanPhong1
												.isBefore(chiTietDatPhongEntity.getGioTraPhong().plusMinutes(30))) {
									JOptionPane.showMessageDialog(this, "Phòng " + phongEntity.getSoPhong()
											+ " đã được đặt trong khoảng thời gian này.\n Vui lòng chọn khung giờ khác");
									return;
								}
							}
						}
						gioNhanPhong = gioNhanPhong1;
					}
				}
			}

			if (gioNhanPhong.isBefore(LocalTime.of(8, 0))) {
				JOptionPane.showMessageDialog(this, "Không được đặt phòng trước 08:00");
				return;
			}

			// Kiểm tra giờ trả phòng phải sau giờ nhận phòng ít nhất 1 giờ
			LocalTime gioTraPhong1 = LocalTime.of(gioTra, phutTra);
			if (gioTraPhong1.isBefore(gioNhanPhong.plusHours(1))) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn giờ trả phòng sau giờ nhận phòng ít nhất 1 giờ");
				return;
			} else {
				for (ChiTietDatPhongEntity chiTietDatPhongEntity : listChiTietDatPhong) {
					if (ngayNhanPhong.equals(chiTietDatPhongEntity.getNgayNhanPhong())
							&& (gioTraPhong1.isAfter(chiTietDatPhongEntity.getGioNhanPhong().minusMinutes(30))
									&& gioTraPhong1.isBefore(chiTietDatPhongEntity.getGioTraPhong()))) {
						PhongEntity phongEntity = chiTietDatPhongEntity.getPhong();
						JOptionPane.showMessageDialog(this, "Phòng " + phongEntity.getSoPhong()
								+ " được đặt trong khoảng thời gian này.\n Vui lòng chọn giờ trả phòng sớm hơn");
						return;
					}
				}
				gioTraPhong = gioTraPhong1;
			}
			// nếu tạo PhieuDatPhong thất bại thì ngừng
			if (!quanLyPhieuDatPhongDAO.themPhieuDatPhong(khachHangEntity.getMaKhachHang()))
				return;

			PhieuDatPhongEntity phieuDatPhongEntity = quanLyPhieuDatPhongDAO.timPhieuDatPhongVuaTao();
			// nếu phiếu dặt phòng null thì return
			if (phieuDatPhongEntity == null)
				return;

			// thêm các ChiTietPhieuDatPhong vào CSDL
			for (PhongEntity phongEntity : listPhongDuocChon) {
				ChiTietDatPhongEntity chiTietDatPhongEntity = new ChiTietDatPhongEntity(phongEntity, gioNhanPhong,
						gioTraPhong, ngayNhanPhong);
				// neu them chi tiet dat phong thanh cong thi them chiTietPhieuDatPhong va
				// chiTietHoaDon
				if (quanLyHoaDonDAO.themChiTietDatPhong(chiTietDatPhongEntity)) {
					chiTietDatPhongEntity = quanLyHoaDonDAO.timChiTietDatPhongVuaTao();
//					ChiTietPhieuDatPhongEntity chiTietPhieuDatPhongEntity = new ChiTietPhieuDatPhongEntity(
//							phieuDatPhongEntity.getMaPhieuDatPhong(), chiTietDatPhongEntity.getMaChiTietDatPhong());
					ChiTietPhieuDatPhongEntity chiTietPhieuDatPhongEntity = new ChiTietPhieuDatPhongEntity(
							phieuDatPhongEntity, chiTietDatPhongEntity);

					if (!quanLyPhieuDatPhongDAO.themChiTietPhieuDatPhong(chiTietPhieuDatPhongEntity)) {
						return;
					}
					if (!quanLyHoaDonDAO.themChiTietHoaDon(chiTietDatPhongEntity.getMaChiTietDatPhong())) {
						return;
					} else {
						if (!phongEntity.getTrangThai().equals("Đang sử dụng")) {
							if (!quanLyPhongDAO.capNhatTrangThaiPhong(phongEntity, trangThaiPhong)) {
								return;
							}
						}
					}
				}
			}
			JOptionPane.showMessageDialog(this, "Đặt phòng thành công");
			tblPhongDaChon.removeAll();
			tblmodelPhongDaChon.setRowCount(0);
			chonLamMoi();
		}

	}

	/****************** KIỂM TRA DỮ LIỆU TÌM ******************/
	private boolean kiemTraSoPhong() {
		String soPhong = txtTimKiemTheoSoPhong.getText().trim();
		if (soPhong.length() > 0) {
			try {
				int so = Integer.parseInt(soPhong);
				if (so < 0) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập số phòng là số dương");
					txtTimKiemTheoSoPhong.requestFocus();
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Số phòng  phải nhập là số");
				txtTimKiemTheoSoPhong.requestFocus();
				return false;
			}
		}
		return true;
	}

	private boolean kiemTraSoDienThoai() {
		if (!txtSDTKhachHang.getText().trim().matches("\\d{10}")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại phải nhập 10 số");
			txtSDTKhachHang.requestFocus();
			return false;
		}
		return true;
	}

	private boolean kiemTraDuLieuDatPhong() {
		if (nhanVienEntity == null) {
			JOptionPane.showMessageDialog(this, "Vui lòng đăng nhập");
			return false;
		}
		if (khachHangEntity == null) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng");
			return false;
		}
		if (tblPhongDaChon.getRowCount() == 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn ít nhất một phòng");
			return false;
		}
		return true;
	}
}
