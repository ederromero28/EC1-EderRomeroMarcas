package pe.idat.EC1.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "malla_curricular")
public class Malla {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMalla;
	private Integer anio;
	
	@OneToOne
	private Universidad universidad;
	
	@OneToMany(mappedBy = "malla")
	private List<Curso> cursos = new ArrayList<>();
	
	
	
	public Malla() {
	}

	public Malla(Integer idMalla, Integer anio) {
		this.idMalla = idMalla;
		this.anio = anio;
	}

	public Integer getIdMalla() {
		return idMalla;
	}

	public void setIdMalla(Integer idMalla) {
		this.idMalla = idMalla;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	
	

}
