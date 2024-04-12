package entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "HoaDon")
public class HoaDonEntity {
	@Id
	@Column(name = "MaHoaDon")
	private String maHoaDon;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaNhanVien")
	private NhanVienEntity nhanVien;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaKhachHang")
	private KhachHangEntity khachHang;
	@Column(name = "NgayLap")
	private LocalDate ngayLap;
	@Column(name = "GioLap")
	private LocalTime gioLap;
	
	@OneToMany(mappedBy = "hoaDon", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ChiTietHoaDonEntity> listChiTietHoaDon;

	public HoaDonEntity() {
		super();
	}
	


	public HoaDonEntity(NhanVienEntity nhanVien, KhachHangEntity khachHang, LocalDate ngayLap, LocalTime gioLap) {
		super();
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.ngayLap = ngayLap;
		this.gioLap = gioLap;
	}



	public NhanVienEntity getNhanVien() {
		return nhanVien;
	}



	public void setNhanVien(NhanVienEntity nhanVien) {
		this.nhanVien = nhanVien;
	}



	public KhachHangEntity getKhachHang() {
		return khachHang;
	}



	public void setKhachHang(KhachHangEntity khachHang) {
		this.khachHang = khachHang;
	}



	public List<ChiTietHoaDonEntity> getListChiTietHoaDon() {
		return listChiTietHoaDon;
	}



	public void setListChiTietHoaDon(List<ChiTietHoaDonEntity> listChiTietHoaDon) {
		this.listChiTietHoaDon = listChiTietHoaDon;
	}



	public HoaDonEntity(String maHoaDon, NhanVienEntity nhanVien, KhachHangEntity khachHang, LocalDate ngayLap,
			LocalTime gioLap) {
		super();
		this.maHoaDon = maHoaDon;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.ngayLap = ngayLap;
		this.gioLap = gioLap;
	}


	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	


	public LocalDate getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(LocalDate ngayLap) {
		this.ngayLap = ngayLap;
	}

	public LocalTime getGioLap() {
		return gioLap;
	}

	public void setGioLap(LocalTime gioLap) {
		this.gioLap = gioLap;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maHoaDon);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		HoaDonEntity other = (HoaDonEntity) obj;
		return Objects.equals(maHoaDon, other.maHoaDon);
	}


}
