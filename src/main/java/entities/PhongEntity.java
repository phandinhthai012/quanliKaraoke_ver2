package entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Phong")

public class PhongEntity  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "MaPhong")
	private String maPhong;
	@Column(name = "SoPhong")
	private int soPhong;
	@ManyToOne
	@JoinColumn(name = "MaLoaiPhong")
	private LoaiPhong loaiPhong;
	@Column(name = "TrangThai")
	private String trangThai;
	@Column(name = "SucChua")
	private int sucChua;
	
	@OneToMany(mappedBy = "phong")
	private List<ChiTietDatPhongEntity> listChiTietDatPhong;

	public PhongEntity() {
	}

	public PhongEntity(String maPhong, int soPhong, LoaiPhong loaiPhong, String trangThai, int sucChua) {
		this.maPhong = maPhong;
		this.soPhong = soPhong;
		this.loaiPhong = loaiPhong;
		this.trangThai = trangThai;
		this.sucChua = sucChua;
	}

	public PhongEntity(int soPhong, LoaiPhong loaiPhong, String trangThai, int sucChua) {
		super();
		this.soPhong = soPhong;
		this.loaiPhong = loaiPhong;
		this.trangThai = trangThai;
		this.sucChua = sucChua;
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public int getSoPhong() {
		return soPhong;
	}

	public void setSoPhong(int soPhong) {
		this.soPhong = soPhong;
	}

	public LoaiPhong getLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(LoaiPhong loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	public List<ChiTietDatPhongEntity> getListChiTietDatPhong() {
		return listChiTietDatPhong;
	}

	public void setListChiTietDatPhong(List<ChiTietDatPhongEntity> listChiTietDatPhong) {
		this.listChiTietDatPhong = listChiTietDatPhong;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public int getSucChua() {
		return sucChua;
	}

	public void setSucChua(int sucChua) {
		this.sucChua = sucChua;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPhong, soPhong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		PhongEntity other = (PhongEntity) obj;
		return Objects.equals(maPhong, other.maPhong) || soPhong == other.soPhong;
	}

	@Override
	public String toString() {
		return "PhongEntity [maPhong=" + maPhong + ", soPhong=" + soPhong + ", loaiPhong=" + loaiPhong + ", trangThai="
				+ trangThai + ", sucChua=" + sucChua + "]";
	}
}
