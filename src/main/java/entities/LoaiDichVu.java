package entities;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "LoaiDichVu")
public class LoaiDichVu {
	@Id
	@Column(name = "MaLoaiDichVu")
	private String maLoaiDichVu;
	@Column(name = "TenLoaiDichVu")
	private String tenLoaiDichVu;
	
	@OneToMany(mappedBy = "loaiDichVu",fetch = FetchType.LAZY)
	private List<DichVuEntity> listDichVu;

	public LoaiDichVu() {
		super();
	}

	public LoaiDichVu(String maLoaiDichVu, String tenLoaiDichVu) {
		super();
		this.maLoaiDichVu = maLoaiDichVu;
		this.tenLoaiDichVu = tenLoaiDichVu;
	}

	public LoaiDichVu(String tenLoaiDichVu) {
		super();
		this.tenLoaiDichVu = tenLoaiDichVu;
	}

	public String getMaLoaiDichVu() {
		return maLoaiDichVu;
	}

	public void setMaLoaiDichVu(String maLoaiDichVu) {
		this.maLoaiDichVu = maLoaiDichVu;
	}

	public String getTenLoaiDichVu() {
		return tenLoaiDichVu;
	}

	public void setTenLoaiDichVu(String tenLoaiDichVu) {
		this.tenLoaiDichVu = tenLoaiDichVu;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maLoaiDichVu, tenLoaiDichVu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		LoaiDichVu other = (LoaiDichVu) obj;
		return Objects.equals(maLoaiDichVu, other.maLoaiDichVu) || Objects.equals(tenLoaiDichVu, other.tenLoaiDichVu);
	}

	@Override
	public String toString() {
		return "LoaiDichVu [maLoaiDichVu=" + maLoaiDichVu + ", tenLoaiDichVu=" + tenLoaiDichVu + "]";
	}
}
