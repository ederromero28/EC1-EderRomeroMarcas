package pe.idat.EC1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.idat.EC1.model.Curso;
import pe.idat.EC1.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;

	@Override
	public void guardar(Curso curso) {
		// TODO Auto-generated method stub
		cursoRepository.save(curso);
	}

	@Override
	public void actualizar(Curso curso) {
		// TODO Auto-generated method stub
		cursoRepository.saveAndFlush(curso);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		cursoRepository.deleteById(id);
	}

	@Override
	public List<Curso> listar() {
		// TODO Auto-generated method stub
		return cursoRepository.findAll();
	}

	@Override
	public Curso obtener(Integer id) {
		// TODO Auto-generated method stub
		return cursoRepository.findById(id).orElse(null);
	}

}
