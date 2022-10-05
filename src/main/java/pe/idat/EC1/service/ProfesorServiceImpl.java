package pe.idat.EC1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.idat.EC1.model.Profesor;
import pe.idat.EC1.repository.ProfesorRepository;

@Service
public class ProfesorServiceImpl implements ProfesorService {
	
	@Autowired
	private ProfesorRepository profesorRepository;

	@Override
	public void guardar(Profesor profesor) {
		// TODO Auto-generated method stub
		profesorRepository.save(profesor);
	}

	@Override
	public void actualizar(Profesor profesor) {
		// TODO Auto-generated method stub
		profesorRepository.saveAndFlush(profesor);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		profesorRepository.deleteById(id);
	}

	@Override
	public List<Profesor> listar() {
		// TODO Auto-generated method stub
		return profesorRepository.findAll();
	}

	@Override
	public Profesor obtener(Integer id) {
		// TODO Auto-generated method stub
		return profesorRepository.findById(id).orElse(null);
	}

}
