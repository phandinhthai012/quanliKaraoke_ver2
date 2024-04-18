package entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "ChiTietPhieuDatPhong")
public class ChiTietPhieuDatPhongEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "MaChiTietPhieuDatPhong")
	private String maChiTietPhieuDatPhong;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaPhieuDatPhong")
	private PhieuDatPhongEntity phieuDatPhong;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaChiTietDatPhong")
	private ChiTietDatPhongEntity chiTietDatPhong;

	public ChiTietPhieuDatPhongEntity() {
		super();
	}

//	public ChiTietPhieuDatPhongEntity(String maChiTietPhieuDatPhong, String maPhieuDatPhong, String maChiTietDatPhong) {
//		super();
//		this.maChiTietPhieuDatPhong = maChiTietPhieuDatPhong;
//		this.maPhieuDatPhong = maPhieuDatPhong;
//		this.maChiTietDatPhong = maChiTietDatPhong;
//	}
	
	public ChiTietPhieuDatPhongEntity(String maChiTietPhieuDatPhong, PhieuDatPhongEntity phieuDatPhong,
			ChiTietDatPhongEntity chiTietDatPhong) {
		super();
		this.maChiTietPhieuDatPhong = maChiTietPhieuDatPhong;
		this.phieuDatPhong = phieuDatPhong;
		this.chiTietDatPhong = chiTietDatPhong;
	}
//
//	public ChiTietPhieuDatPhongEntity(String maPhieuDatPhong, String maChiTietDatPhong) {
//		super();
//		this.maPhieuDatPhong = maPhieuDatPhong;
//		this.maChiTietDatPhong = maChiTietDatPhong;
//	}
	public ChiTietPhieuDatPhongEntity(PhieuDatPhongEntity phieuDatPhong, ChiTietDatPhongEntity chiTietDatPhong) {
		super();
		this.phieuDatPhong = phieuDatPhong;
		this.chiTietDatPhong = chiTietDatPhong;
	}

	
	public PhieuDatPhongEntity getPhieuDatPhong() {
		return phieuDatPhong;
	}

	public void setPhieuDatPhong(PhieuDatPhongEntity phieuDatPhong) {
		this.phieuDatPhong = phieuDatPhong;
	}

	public ChiTietDatPhongEntity getChiTietDatPhong() {
		return chiTietDatPhong;
	}

	public void setChiTietDatPhong(ChiTietDatPhongEntity chiTietDatPhong) {
		this.chiTietDatPhong = chiTietDatPhong;
	}

	public String getMaChiTietPhieuDatPhong() {
		return maChiTietPhieuDatPhong;
	}

	public void setMaChiTietPhieuDatPhong(String maChiTietPhieuDatPhong) {
		this.maChiTietPhieuDatPhong = maChiTietPhieuDatPhong;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(maChiTietPhieuDatPhong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		ChiTietPhieuDatPhongEntity other = (ChiTietPhieuDatPhongEntity) obj;
		return Objects.equals(maChiTietPhieuDatPhong, other.maChiTietPhieuDatPhong);
	}
	
	@Override
	public String toString() {
		return "ChiTietPhieuDatPhongEntity [maChiTietPhieuDatPhong=" + maChiTietPhieuDatPhong + ", phieuDatPhong="
				+ phieuDatPhong + "]";
	}




}
