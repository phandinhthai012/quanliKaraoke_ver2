package entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "KhachHang")
public class KhachHangEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "MaKhachHang")
	private String maKhachHang;
	@Column(name = "HoTen")
	private String hoTen;
	@Column(name = "SoDienThoai")
	private String soDienThoai;
	@Column(name = "Email")
	private String email;
	@Column(name = "NamSinh")
	private int namSinh;
	@Column(name = "SoLanDatPhong")
	private int soLanDatPhong;
	
	@OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HoaDonEntity> dsHoaDon;
	@OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PhieuDatPhongEntity> dsPhieuDatPhong;

	public KhachHangEntity() {
		super();
	}

	public KhachHangEntity(String maKhachHang, String hoTen, String soDienThoai, String email, int namSinh,
			int soLanDatPhong) {
		super();
		this.maKhachHang = maKhachHang;
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.namSinh = namSinh;
		this.soLanDatPhong = soLanDatPhong;
	}

	public KhachHangEntity(String hoTen, String soDienThoai, String email, int namSinh, int soLanDatPhong) {
		super();
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.namSinh = namSinh;
		this.soLanDatPhong = soLanDatPhong;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public int getSoLanDatPhong() {
		return soLanDatPhong;
	}

	public void setSoLanDatPhong(int soLanDatPhong) {
		this.soLanDatPhong = soLanDatPhong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maKhachHang, soDienThoai);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		KhachHangEntity other = (KhachHangEntity) obj;
		return Objects.equals(maKhachHang, other.maKhachHang) || Objects.equals(soDienThoai, other.soDienThoai);
	}

	@Override
	public String toString() {
		return "KhachHangEntity [maKhachHang=" + maKhachHang + ", hoTen=" + hoTen + ", soDienThoai=" + soDienThoai
				+ ", email=" + email + ", namSinh=" + namSinh + ", soLanDatPhong=" + soLanDatPhong + "]";
	}

}
