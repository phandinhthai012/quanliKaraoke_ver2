package entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ChiTietDatPhong")
public class ChiTietDatPhongEntity {
	@Id
	@Column(name = "MaChiTietDatPhong")
	private String maChiTietDatPhong;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaPhong")
	private PhongEntity phong;
	@Column(name = "GioNhanPhong")
	private LocalTime gioNhanPhong;
	@Column(name = "GioTraPhong")
	private LocalTime gioTraPhong;
	@Column(name = "NgayNhanPhong")
	private LocalDate ngayNhanPhong;
	@Column(name = "NgayDatPhong")
	private LocalDate ngayDatPhong;
	
	@OneToOne(mappedBy = "chiTietDatPhong",fetch = FetchType.LAZY)
	private ChiTietHoaDonEntity chiTietHoaDon;
	@OneToOne(mappedBy = "chiTietDatPhong",fetch = FetchType.LAZY)
	private ChiTietPhieuDatPhongEntity chiTietPhieuDatPhong;

	public ChiTietDatPhongEntity() {
	}

	public ChiTietDatPhongEntity(String maChiTietDatPhong, PhongEntity phong, LocalTime gioNhanPhong,
			LocalTime gioTraPhong, LocalDate ngayNhanPhong) {
		super();
		this.maChiTietDatPhong = maChiTietDatPhong;
		this.phong = phong;
		this.gioNhanPhong = gioNhanPhong;
		this.gioTraPhong = gioTraPhong;
		this.ngayNhanPhong = ngayNhanPhong;
	}

	public ChiTietDatPhongEntity(PhongEntity phong, LocalTime gioNhanPhong, LocalTime gioTraPhong,
			LocalDate ngayNhanPhong) {
		super();
		this.phong = phong;
		this.gioNhanPhong = gioNhanPhong;
		this.gioTraPhong = gioTraPhong;
		this.ngayNhanPhong = ngayNhanPhong;
	}

	public String getMaChiTietDatPhong() {
		return maChiTietDatPhong;
	}

	public void setMaChiTietDatPhong(String maChiTietDatPhong) {
		this.maChiTietDatPhong = maChiTietDatPhong;
	}

	public PhongEntity getPhong() {
		return phong;
	}

	public void setPhong(PhongEntity phong) {
		this.phong = phong;
	}

	public LocalTime getGioNhanPhong() {
		return gioNhanPhong;
	}

	public void setGioNhanPhong(LocalTime gioNhanPhong) {
		this.gioNhanPhong = gioNhanPhong;
	}

	public LocalTime getGioTraPhong() {
		return gioTraPhong;
	}

	public void setGioTraPhong(LocalTime gioTraPhong) {
		this.gioTraPhong = gioTraPhong;
	}

	public LocalDate getNgayNhanPhong() {
		return ngayNhanPhong;
	}

	public LocalDate getNgayDatPhong() {
		return ngayDatPhong;
	}

	public void setNgayDatPhong(LocalDate ngayDatPhong) {
		this.ngayDatPhong = ngayDatPhong;
	}

	public ChiTietHoaDonEntity getChiTietHoaDon() {
		return chiTietHoaDon;
	}

	public void setChiTietHoaDon(ChiTietHoaDonEntity chiTietHoaDon) {
		this.chiTietHoaDon = chiTietHoaDon;
	}

	public ChiTietPhieuDatPhongEntity getChiTietPhieuDatPhong() {
		return chiTietPhieuDatPhong;
	}

	public void setChiTietPhieuDatPhong(ChiTietPhieuDatPhongEntity chiTietPhieuDatPhong) {
		this.chiTietPhieuDatPhong = chiTietPhieuDatPhong;
	}

	public void setNgayNhanPhong(LocalDate ngayNhanPhong) {
		this.ngayNhanPhong = ngayNhanPhong;
	}

	public double tinhTienHat() {
		double tienHat = 0;
		return tienHat;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maChiTietDatPhong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		ChiTietDatPhongEntity other = (ChiTietDatPhongEntity) obj;
		return Objects.equals(maChiTietDatPhong, other.maChiTietDatPhong);
	}

	@Override
	public String toString() {
		return "ChiTietDatPhongEntity [maChiTietDatPhong=" + maChiTietDatPhong + ", phong=" + phong + ", gioNhanPhong="
				+ gioNhanPhong + ", gioTraPhong=" + gioTraPhong + ", ngayNhanPhong=" + ngayNhanPhong + "]";
	}

}
