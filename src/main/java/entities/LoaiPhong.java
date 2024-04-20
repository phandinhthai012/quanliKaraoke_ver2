package entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "LoaiPhong")
public class LoaiPhong implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "MaLoaiPhong")
	private String maLoai;
	@Column(name = "TenLoai", columnDefinition = "NVARCHAR(50)")
	private String tenLoaiPhong;
	
	@OneToMany(mappedBy = "loaiPhong")
	private List<PhongEntity> listPhong;
	
	public LoaiPhong() {
	}

	public LoaiPhong(String maLoai, String tenLoaiPhong) {
		this.maLoai = maLoai;
		this.tenLoaiPhong = tenLoaiPhong;
	}

	public LoaiPhong(String tenLoaiPhong) {
		this.tenLoaiPhong = tenLoaiPhong;
	}

	public String getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}

	public String getTenLoaiPhong() {
		return tenLoaiPhong;
	}

	public void setTenLoaiPhong(String tenLoaiPhong) {
		this.tenLoaiPhong = tenLoaiPhong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maLoai, tenLoaiPhong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		LoaiPhong other = (LoaiPhong) obj;
		return Objects.equals(maLoai, other.maLoai) || Objects.equals(tenLoaiPhong, other.tenLoaiPhong);
	}

	@Override
	public String toString() {
		return "LoaiPhongEntity [maLoai=" + maLoai + ", tenLoaiPhong=" + tenLoaiPhong + "]";
	}
}
