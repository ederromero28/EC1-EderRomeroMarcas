package pe.idat.EC1.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "profesores")
public class Profesor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProfesor;
	private String nombreProfesor;
	
	// Relacion de muchos a muchos
	@ManyToMany(mappedBy = "profesores" , cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Curso> cursos = new ArrayList<>();
	
	public Profesor() {
	}

	public Profesor(Integer idProfesor, String nombreProfesor) {
		this.idProfesor = idProfesor;
		this.nombreProfesor = nombreProfesor;
	}

	public Integer getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
	}

	public String getNombreProfesor() {
		return nombreProfesor;
	}

	public void setNombreProfesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}
	
	

}
