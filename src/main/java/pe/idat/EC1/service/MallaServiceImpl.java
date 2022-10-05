package pe.idat.EC1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.idat.EC1.model.Malla;
import pe.idat.EC1.repository.MallaRepository;

@Service
public class MallaServiceImpl implements MallaService {
	
	@Autowired
	private MallaRepository mallaRepository;

	@Override
	public void guardar(Malla malla) {
		// TODO Auto-generated method stub
		mallaRepository.save(malla);
	}

	@Override
	public void actualizar(Malla malla) {
		// TODO Auto-generated method stub
		mallaRepository.saveAndFlush(malla);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		mallaRepository.deleteById(id);
	}

	@Override
	public List<Malla> listar() {
		// TODO Auto-generated method stub
		return mallaRepository.findAll();
	}

	@Override
	public Malla obtener(Integer id) {
		// TODO Auto-generated method stub
		return mallaRepository.findById(id).orElse(null);
	}

}
