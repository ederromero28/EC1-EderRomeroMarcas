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

import pe.idat.EC1.model.Malla;
import pe.idat.EC1.service.MallaService;

@RestController
@RequestMapping("/malla/ec1")
public class MallaController {
	
	@Autowired
	private MallaService mallaService;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Malla>> listar(){
		return new ResponseEntity<List<Malla>>(mallaService.listar(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Malla malla){
		mallaService.guardar(malla);
		return new ResponseEntity<Void> (HttpStatus.CREATED) ;
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> obtenerPorId(@PathVariable Integer id){
		
		Malla malla = mallaService.obtener(id);
		
		if (malla != null) {
			return new ResponseEntity<Malla>(malla , HttpStatus.OK);
		} else {
			return new ResponseEntity<>("¡MALLA CURRICULAR NO ENCONTRADA!", HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<?> editar(@RequestBody Malla malla){
		
		Malla m = mallaService.obtener(malla.getIdMalla());
		
		if (m != null) {
			mallaService.actualizar(malla);
			return new ResponseEntity<>("MALLA CURRICULAR ACTUALIZADA CORRECTAMENTE", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("¡MALLA CURRICULAR NO ACTUALIZADA!", HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> eliminar(@PathVariable Integer id){
		
		Malla malla = mallaService.obtener(id);
		
		if (malla != null) {
			mallaService.eliminar(id);
			return new ResponseEntity<>("MALLA CURRICULAR ELIMINADA CORRECTAMENTE", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("¡MALLA CURRICULAR NO ENCONTRADA PARA ELIMINAR!", HttpStatus.NOT_FOUND);
		}
	}

}
