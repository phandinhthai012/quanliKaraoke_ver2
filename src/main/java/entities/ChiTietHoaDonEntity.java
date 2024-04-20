package entities;

import java.io.Serializable;
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
@Table(name = "ChiTietHoaDon")
public class ChiTietHoaDonEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "MaChiTietHoaDon")
	private String maChiTietHoaDon;

	@ManyToOne()
	@JoinColumn(name = "MaHoaDon")
	private HoaDonEntity hoaDon;

	@OneToOne()
	@JoinColumn(name = "MaChiTietDatPhong")
	private ChiTietDatPhongEntity chiTietDatPhong;

	@OneToMany(mappedBy = "chiTietHoaDon", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ChiTietDichVuEntity> listChiTietDatDichVu;

	public ChiTietHoaDonEntity() {
		super();
	}

	// public ChiTietHoaDonEntity(String maChiTietHoaDon, String maHoaDon,
	// ChiTietDatPhongEntity chiTietDatPhong,
//			List<ChiTietDichVuEntity> listChiTietDatDichVu) {
//		super();
//		this.maChiTietHoaDon = maChiTietHoaDon;
//		this.maHoaDon = maHoaDon;
//		this.chiTietDatPhong = chiTietDatPhong;
//		this.listChiTietDatDichVu = listChiTietDatDichVu;
//	}

//
//	public ChiTietHoaDonEntity(String maHoaDon, ChiTietDatPhongEntity chiTietDatPhong,
//			List<ChiTietDichVuEntity> listChiTietDatDichVu) {
//		super();
//		this.maHoaDon = maHoaDon;
//		this.chiTietDatPhong = chiTietDatPhong;
//		this.listChiTietDatDichVu = listChiTietDatDichVu;
//	}
	public ChiTietHoaDonEntity(HoaDonEntity hoaDon, ChiTietDatPhongEntity chiTietDatPhong,
			List<ChiTietDichVuEntity> listChiTietDatDichVu) {
		super();
		this.hoaDon = hoaDon;
		this.chiTietDatPhong = chiTietDatPhong;
		this.listChiTietDatDichVu = listChiTietDatDichVu;
	}

	public ChiTietHoaDonEntity(String maChiTietHoaDon, HoaDonEntity hoaDon, ChiTietDatPhongEntity chiTietDatPhong,
			List<ChiTietDichVuEntity> listChiTietDatDichVu) {
		super();
		this.maChiTietHoaDon = maChiTietHoaDon;
		this.hoaDon = hoaDon;
		this.chiTietDatPhong = chiTietDatPhong;
		this.listChiTietDatDichVu = listChiTietDatDichVu;
	}

	public ChiTietHoaDonEntity(ChiTietDatPhongEntity chiTietDatPhong, List<ChiTietDichVuEntity> listChiTietDatDichVu) {

		this.chiTietDatPhong = chiTietDatPhong;
		this.listChiTietDatDichVu = listChiTietDatDichVu;
	}

	public ChiTietHoaDonEntity(String maChiTietHoaDon, ChiTietDatPhongEntity chiTietDatPhong) {

		this.maChiTietHoaDon = maChiTietHoaDon;
		this.chiTietDatPhong = chiTietDatPhong;
	}

//	public ChiTietHoaDonEntity(String maChiTietHoaDon, String maHoaDon, ChiTietDatPhongEntity chiTietDatPhong) {
//		super();
//		this.maChiTietHoaDon = maChiTietHoaDon;
//		this.maHoaDon = maHoaDon;
//		this.chiTietDatPhong = chiTietDatPhong;
//	}
	public ChiTietHoaDonEntity(String maChiTietHoaDon, HoaDonEntity hoaDon, ChiTietDatPhongEntity chiTietDatPhong) {
		super();
		this.maChiTietHoaDon = maChiTietHoaDon;
		this.hoaDon = hoaDon;
		this.chiTietDatPhong = chiTietDatPhong;
	}

	public HoaDonEntity getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDonEntity hoaDon) {
		this.hoaDon = hoaDon;
	}

	public String getMaChiTietHoaDon() {
		return maChiTietHoaDon;
	}

	public void setMaChiTietHoaDon(String maChiTietHoaDon) {
		this.maChiTietHoaDon = maChiTietHoaDon;
	}

	public ChiTietDatPhongEntity getChiTietDatPhong() {
		return chiTietDatPhong;
	}

	public void setChiTietDatPhong(ChiTietDatPhongEntity chiTietDatPhong) {
		this.chiTietDatPhong = chiTietDatPhong;
	}

	public List<ChiTietDichVuEntity> getListChiTietDatDichVu() {
		return listChiTietDatDichVu;
	}

	public void setListChiTietDatDichVu(List<ChiTietDichVuEntity> listChiTietDatDichVu) {
		this.listChiTietDatDichVu = listChiTietDatDichVu;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maChiTietHoaDon);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		ChiTietHoaDonEntity other = (ChiTietHoaDonEntity) obj;
		return Objects.equals(maChiTietHoaDon, other.maChiTietHoaDon);
	}

	@Override
	public String toString() {
		return "ChiTietHoaDonEntity [maChiTietHoaDon=" + maChiTietHoaDon + ", hoaDon=" + hoaDon + ", chiTietDatPhong="
				+ chiTietDatPhong + ", listChiTietDatDichVu=" + listChiTietDatDichVu + "]";
	}
	
	

}
