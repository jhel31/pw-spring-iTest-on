package pe.edu.upc.iTeston.models.entities;

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
	
	@NotNull
	@NotBlank
	@Size(max = 10)
	@Column(name = "saldo", length = 10, nullable = false)
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
	
	
}
