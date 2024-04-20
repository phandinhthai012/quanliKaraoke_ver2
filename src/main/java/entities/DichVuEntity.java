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
@Table(name = "DichVu")
public class DichVuEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "MaDichVu")
	private String maDichVu;
	@Column(name = "TenDichVu")
	private String tenDichVu;
	@ManyToOne
	@JoinColumn(name = "MaLoaiDichVu")
	private LoaiDichVu loaiDichVu;
	@Column(name = "Gia")
	private double gia;
	
	@OneToMany(mappedBy = "dichVu", cascade = CascadeType.ALL)
	private List<ChiTietDichVuEntity> listChiTietDichVu;

	public DichVuEntity() {
		super();
	}

	public DichVuEntity(String maDichVu, String tenDichVu, LoaiDichVu loaiDichVu, double gia) {
		super();
		this.maDichVu = maDichVu;
		this.tenDichVu = tenDichVu;
		this.loaiDichVu = loaiDichVu;
		this.gia = gia;
	}

	public DichVuEntity(String tenDichVu, LoaiDichVu loaiDichVu, double gia) {
		super();
		this.tenDichVu = tenDichVu;
		this.loaiDichVu = loaiDichVu;
		this.gia = gia;
	}

	public String getMaDichVu() {
		return maDichVu;
	}

	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}

	public String getTenDichVu() {
		return tenDichVu;
	}

	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}

	public LoaiDichVu getLoaiDichVu() {
		return loaiDichVu;
	}

	public void setLoaiDichVu(LoaiDichVu loaiDichVu) {
		this.loaiDichVu = loaiDichVu;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maDichVu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		DichVuEntity other = (DichVuEntity) obj;
		return Objects.equals(maDichVu, other.maDichVu);
	}

	@Override
	public String toString() {
		return "DichVuEntity [maDichVu=" + maDichVu + ", tenDichVu=" + tenDichVu + ", loaiDichVu=" + loaiDichVu
				+ ", gia=" + gia + "]";
	}
}
