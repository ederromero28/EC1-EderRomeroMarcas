package pe.idat.EC1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.idat.EC1.model.Profesor;
import pe.idat.EC1.service.ProfesorService;

@RestController
@RequestMapping("/profesor/ec1")
public class ProfesorController {
	
	@Autowired
	private ProfesorService profesorService;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Profesor>> listar(){
		return new ResponseEntity<List<Profesor>>(profesorService.listar(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Profesor profesor){
		profesorService.guardar(profesor);
		return new ResponseEntity<Void> (HttpStatus.CREATED) ;
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> obtenerPorId(@PathVariable Integer id){
		
		Profesor profesor = profesorService.obtener(id);
		
		if (profesor != null) {
			return new ResponseEntity<Profesor>(profesor , HttpStatus.OK);
		} else {
			return new ResponseEntity<>("¡PROFESOR NO ENCONTRADO!", HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<?> editar(@RequestBody Profesor profesor){
		
		Profesor p = profesorService.obtener(profesor.getIdProfesor());
		
		if (p != null) {
			profesorService.actualizar(profesor);
			return new ResponseEntity<>("PROFESOR ACTUALIZADO CORRECTAMENTE", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("¡PROFESOR NO ACTUALIZADO!", HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> eliminar(@PathVariable Integer id){
		
		Profesor profesor = profesorService.obtener(id);
		
		if (profesor != null) {
			profesorService.eliminar(id);
			return new ResponseEntity<>("PROFESOR ELIMINADO CORRECTAMENTE", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("¡PROFESOR NO ENCONTRADO PARA ELIMINAR!", HttpStatus.NOT_FOUND);
		}
	}
}
