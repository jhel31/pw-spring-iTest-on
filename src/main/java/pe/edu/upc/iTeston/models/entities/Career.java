package pe.edu.upc.iTeston.models.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Careers", indexes = { @Index(columnList = "name_career", name = "careers_index_name_career") })

public class Career {
	@NotNull
	@NotBlank
	@Size(max = 10)
	@Id
	@Column(name = "id_career", length = 10, nullable = false)
	private String id;
	@NotNull
	@NotBlank
	@Size(max = 60)
	@Column(name = "name_career", length = 60)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "id_university", nullable=false)
	private University university;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, university);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Career other = (Career) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(university, other.university);
	}

	public Career(@NotNull @NotBlank @Size(max = 10) String id, @NotNull @NotBlank @Size(max = 60) String name,
			University university) {
		super();
		this.id = id;
		this.name = name;
		this.university = university;
	}

	public Career() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
