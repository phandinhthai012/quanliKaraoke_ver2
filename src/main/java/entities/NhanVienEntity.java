package entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "NhanVien")
public class NhanVienEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MaNhanVien",nullable = true)
	private String maNhanVien;
	@Column(name = "HoTen")
	private String hoTen;
	@Column(name = "SoDienThoai")
	private String soDienThoai;
	@Column(name = "Email")
	private String email;
	@Column(name = "CCCD")
	private String cCCD;
	@Column(name = "Password")
	private String password;
	@Column(name = "NamSinh")
	private int namSinh;
	@Column(name = "MucLuong")
	private double mucLuong;
	@Column(name = "ChucVu")
	private String chucVu;
	@Column(name = "TrangThai")
	private boolean trangThai;
	@OneToMany(mappedBy = "nhanVien",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<HoaDonEntity> dsHoaDon;

	public NhanVienEntity() {
	}

	public NhanVienEntity(String maNhanVien, String hoTen, String soDienThoai, String email, String cCCD,
			String password, int namSinh, double mucLuong, String chucVu, boolean trangThai) {
		this.maNhanVien = maNhanVien;
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.cCCD = cCCD;
		this.password = password;
		this.namSinh = namSinh;
		this.mucLuong = mucLuong;
		this.chucVu = chucVu;
		this.trangThai = trangThai;
	}

	public NhanVienEntity(String hoTen, String soDienThoai, String email, String cCCD, String password, int namSinh,
			double mucLuong, String chucVu, boolean trangThai) {
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.cCCD = cCCD;
		this.password = password;
		this.namSinh = namSinh;
		this.mucLuong = mucLuong;
		this.chucVu = chucVu;
		this.trangThai = trangThai;
	}

	public NhanVienEntity(String maNhanVien, String hoTen, String soDienThoai) {
		super();
		this.maNhanVien = maNhanVien;
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
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

	public String getcCCD() {
		return cCCD;
	}

	public void setcCCD(String cCCD) {
		this.cCCD = cCCD;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public double getMucLuong() {
		return mucLuong;
	}

	public void setMucLuong(double mucLuong) {
		this.mucLuong = mucLuong;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cCCD, maNhanVien, soDienThoai);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		NhanVienEntity other = (NhanVienEntity) obj;
		return Objects.equals(cCCD, other.cCCD) || Objects.equals(maNhanVien, other.maNhanVien)
				|| Objects.equals(soDienThoai, other.soDienThoai);
	}

	@Override
	public String toString() {
		return "NhanVienEntity [maNhanVien=" + maNhanVien + ", hoTen=" + hoTen + ", soDienThoai=" + soDienThoai
				+ ", email=" + email + ", cCCD=" + cCCD + ", password=" + password + ", namSinh=" + namSinh
				+ ", mucLuong=" + mucLuong + ", chucVu=" + chucVu + ", trangThai=" + trangThai + "]";
	}
}
