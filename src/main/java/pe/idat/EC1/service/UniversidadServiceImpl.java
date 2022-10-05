package pe.idat.EC1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.idat.EC1.model.Universidad;
import pe.idat.EC1.repository.UniversidadRepository;

@Service
public class UniversidadServiceImpl implements UniversidadService {
	
	@Autowired
	private UniversidadRepository universidadRepository;

	@Override
	public void guardar(Universidad universidad) {
		// TODO Auto-generated method stub
		universidadRepository.save(universidad);
	}

	@Override
	public void actualizar(Universidad universidad) {
		// TODO Auto-generated method stub
		universidadRepository.saveAndFlush(universidad);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		universidadRepository.deleteById(id);
	}

	@Override
	public List<Universidad> listar() {
		// TODO Auto-generated method stub
		return universidadRepository.findAll();
	}

	@Override
	public Universidad obtener(Integer id) {
		// TODO Auto-generated method stub
		return universidadRepository.findById(id).orElse(null);
	}

}
