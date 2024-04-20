package entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "PhieuDatPhong")
public class PhieuDatPhongEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "MaPhieuDatPhong")
	private String maPhieuDatPhong;
	@ManyToOne()
	@JoinColumn(name = "MaKhachHang")
	private KhachHangEntity khachHang;
	
	@OneToMany(mappedBy = "phieuDatPhong")
	private List<ChiTietPhieuDatPhongEntity> listPhong;

	public PhieuDatPhongEntity() {
		super();
	}

//	public PhieuDatPhongEntity(String maPhieuDatPhong, String maKhachHang, List<ChiTietPhieuDatPhongEntity> listPhong) {
//		super();
//		this.maPhieuDatPhong = maPhieuDatPhong;
//		this.maKhachHang = maKhachHang;
//		this.listPhong = listPhong;
//	}
	public PhieuDatPhongEntity(String maPhieuDatPhong, KhachHangEntity khachHang,
			List<ChiTietPhieuDatPhongEntity> listPhong) {
		super();
		this.maPhieuDatPhong = maPhieuDatPhong;
		this.khachHang = khachHang;
		this.listPhong = listPhong;
	}
//
	public PhieuDatPhongEntity(String maPhieuDatPhong, KhachHangEntity khachHang) {
		super();
		this.maPhieuDatPhong = maPhieuDatPhong;
		this.khachHang = khachHang;
	}
	
//
	
	public PhieuDatPhongEntity(KhachHangEntity khachHang, List<ChiTietPhieuDatPhongEntity> listPhong) {
		super();
		this.khachHang = khachHang;
		this.listPhong = listPhong;
	}
	

	public String getMaPhieuDatPhong() {
		return maPhieuDatPhong;
	}

	public void setMaPhieuDatPhong(String maPhieuDatPhong) {
		this.maPhieuDatPhong = maPhieuDatPhong;
	}

	public KhachHangEntity getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHangEntity khachHang) {
		this.khachHang = khachHang;
	}

	public List<ChiTietPhieuDatPhongEntity> getListPhong() {
		return listPhong;
	}

	public void setListPhong(List<ChiTietPhieuDatPhongEntity> listPhong) {
		this.listPhong = listPhong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPhieuDatPhong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		PhieuDatPhongEntity other = (PhieuDatPhongEntity) obj;
		return Objects.equals(maPhieuDatPhong, other.maPhieuDatPhong);
	}

	@Override
	public String toString() {
		return "PhieuDatPhongEntity [maPhieuDatPhong=" + maPhieuDatPhong + ", khachHang=" + khachHang + "]";
	}
	

}
