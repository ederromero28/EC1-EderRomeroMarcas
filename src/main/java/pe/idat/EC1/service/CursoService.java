package pe.idat.EC1.service;

import java.util.List;

import pe.idat.EC1.model.Curso;

public interface CursoService {
	
	void guardar(Curso curso);
	void actualizar(Curso curso);
	void eliminar(Integer id);
	List<Curso> listar();
	Curso obtener(Integer id);

}
