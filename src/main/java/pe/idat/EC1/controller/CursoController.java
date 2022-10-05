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

import pe.idat.EC1.model.Curso;
import pe.idat.EC1.service.CursoService;

@RestController
@RequestMapping("/curso/ec1")
public class CursoController {
	
	@Autowired
	private CursoService cursoService;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Curso>> listar(){
		return new ResponseEntity<List<Curso>>(cursoService.listar(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Curso curso){
		cursoService.guardar(curso);
		return new ResponseEntity<Void> (HttpStatus.CREATED) ;
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> obtenerPorId(@PathVariable Integer id){
		
		Curso curso = cursoService.obtener(id);
		
		if (curso != null) {
			return new ResponseEntity<Curso>(curso , HttpStatus.OK);
		} else {
			return new ResponseEntity<>("¡CURSO NO ENCONTRADO!", HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<?> editar(@RequestBody Curso curso){
		
		Curso c = cursoService.obtener(curso.getIdCurso());
		
		if (c != null) {
			cursoService.actualizar(curso);
			return new ResponseEntity<>("CURSO ACTUALIZADO CORRECTAMENTE", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("¡CURSO NO ACTUALIZADO!", HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> eliminar(@PathVariable Integer id){
		
		Curso curso = cursoService.obtener(id);
		
		if (curso != null) {
			cursoService.eliminar(id);
			return new ResponseEntity<>("CURSO ELIMINADO CORRECTAMENTE", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("¡CURSO NO ENCONTRADO PARA ELIMINAR!", HttpStatus.NOT_FOUND);
		}
	}

}
