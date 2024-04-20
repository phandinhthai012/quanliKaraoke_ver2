package entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ChiTietDichVu")
public class ChiTietDichVuEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "MaChiTietDichVu")
	private String maChiTietDatDichVu;

	@ManyToOne()
	@JoinColumn(name = "MaDichVu")
	private DichVuEntity dichVu;
	@Column(name = "SoLuong")
	private int soLuong;

	@ManyToOne()
	@JoinColumn(name = "MaChiTietHoaDon")
	private ChiTietHoaDonEntity chiTietHoaDon;

	public ChiTietDichVuEntity() {
		super();
	}

	public ChiTietDichVuEntity(String maChiTietDatDichVu, DichVuEntity dichVu, int soLuong,
			ChiTietHoaDonEntity chiTietHoaDon) {
		super();
		this.maChiTietDatDichVu = maChiTietDatDichVu;
		this.dichVu = dichVu;
		this.soLuong = soLuong;
		this.chiTietHoaDon = chiTietHoaDon;
	}

	public ChiTietDichVuEntity(String maChiTietDatDichVu, DichVuEntity dichVu, int soLuong) {
		super();
		this.maChiTietDatDichVu = maChiTietDatDichVu;
		this.dichVu = dichVu;
		this.soLuong = soLuong;
	}


	public ChiTietDichVuEntity(DichVuEntity dichVu, int soLuong) {
		super();
		this.dichVu = dichVu;
		this.soLuong = soLuong;
	}

	public String getMaChiTietDatDichVu() {
		return maChiTietDatDichVu;
	}

	public void setMaChiTietDatDichVu(String maChiTietDatDichVu) {
		this.maChiTietDatDichVu = maChiTietDatDichVu;
	}

	public DichVuEntity getDichVu() {
		return dichVu;
	}

	public void setDichVu(DichVuEntity dichVu) {
		this.dichVu = dichVu;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public ChiTietHoaDonEntity getChiTietHoaDon() {
		return chiTietHoaDon;
	}

	public void setChiTietHoaDon(ChiTietHoaDonEntity chiTietHoaDon) {
		this.chiTietHoaDon = chiTietHoaDon;
	}

	public double tinhThanhTien() {
		return dichVu.getGia() * soLuong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maChiTietDatDichVu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		ChiTietDichVuEntity other = (ChiTietDichVuEntity) obj;
		return Objects.equals(maChiTietDatDichVu, other.maChiTietDatDichVu);
	}

	@Override
	public String toString() {
		return "ChiTietDatDichVuEntity [maChiTietDatDichVu=" + maChiTietDatDichVu + ", dichVu=" + dichVu + ", soLuong="
				+ soLuong + "]";
	}

}
