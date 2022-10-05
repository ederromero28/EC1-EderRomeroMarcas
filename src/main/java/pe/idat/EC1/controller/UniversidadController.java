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


import pe.idat.EC1.model.Universidad;
import pe.idat.EC1.service.UniversidadService;

@RestController
@RequestMapping("/universidad/ec1")
public class UniversidadController {
	
	@Autowired
	private UniversidadService universidadService;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Universidad>> listar(){
		return new ResponseEntity<List<Universidad>>(universidadService.listar(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Universidad universidad){
		universidadService.guardar(universidad);
		return new ResponseEntity<Void> (HttpStatus.CREATED) ;
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> obtenerPorId(@PathVariable Integer id){
		
		Universidad universidad = universidadService.obtener(id);
		
		if (universidad != null) {
			return new ResponseEntity<Universidad>(universidad , HttpStatus.OK);
		} else {
			return new ResponseEntity<>("¡UNIVERSIDAD NO ENCONTRADA!", HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<?> editar(@RequestBody Universidad universidad){
		
		Universidad u = universidadService.obtener(universidad.getIdUniversidad());
		
		if (u != null) {
			universidadService.actualizar(universidad);
			return new ResponseEntity<>("UNIVERSIDAD ACTUALIZADA CORRECTAMENTE", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("¡UNIVERSIDAD NO ACTUALIZADA!", HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> eliminar(@PathVariable Integer id){
		
		Universidad universidad = universidadService.obtener(id);
		
		if (universidad != null) {
			universidadService.eliminar(id);
			return new ResponseEntity<>("UNIVERSIDAD ELIMINADA CORRECTAMENTE", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("¡UNIVERSIDAD NO ENCONTRADA PARA ELIMINAR!", HttpStatus.NOT_FOUND);
		}
	}

}
