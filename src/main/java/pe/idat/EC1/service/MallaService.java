package pe.idat.EC1.service;

import java.util.List;

import pe.idat.EC1.model.Malla;


public interface MallaService {
	
	void guardar(Malla malla);
	void actualizar(Malla malla);
	void eliminar(Integer id);
	List<Malla> listar();
	Malla obtener(Integer id);

}
