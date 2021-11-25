package pe.edu.upc.iTeston.models.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity 
@Table(name = "Virtual_Wallets")

public class VirtualWallet {
	
	@NotNull
	@NotBlank
	@Size(max = 10)
	@Id
	@Column(name = "id_virtual_wallet", length = 10, nullable = false)
	private String id;
	

	@Column(name = "saldo", nullable = false)
	private Float saldo;
	
	@OneToOne(mappedBy= "virtualWallet" )
	private Teacher teacher;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Float getSaldo() {
		return saldo;
	}

	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, saldo, teacher);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VirtualWallet other = (VirtualWallet) obj;
		return Objects.equals(id, other.id) && Objects.equals(saldo, other.saldo)
				&& Objects.equals(teacher, other.teacher);
	}

	public VirtualWallet(@NotNull @NotBlank @Size(max = 10) String id, @NotNull @NotBlank @Size(max = 10) Float saldo,
			Teacher teacher) {
		super();
		this.id = id;
		this.saldo = saldo;
		this.teacher = teacher;
	}

	public VirtualWallet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
