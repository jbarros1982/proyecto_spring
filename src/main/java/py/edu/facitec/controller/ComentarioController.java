package py.edu.facitec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.edu.facitec.model.Comentario;
import py.edu.facitec.repository.ComentarioRepository;

//UTILIZANDO LA ARQUITECTURA REST
@RestController
//ATIENDE REQUISICIONES
@RequestMapping("/comentarios")
public class ComentarioController {
	
	//INICIALIZAR
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	@GetMapping
	public List<Comentario> getComentarios(){
		
		System.out.println("Listando Comentarios");
		
		return comentarioRepository.findAll();
		
	}
	
	//comentarios/3
	
	@GetMapping(value="/{codigo}")
								     //Cargar la url de arriba a codigo
	public Optional<Comentario> getComentario(@PathVariable Long codigo){
		
		System.out.println("Recuperando un Comentario");
		
		Optional<Comentario> retorno=comentarioRepository.findById(codigo);
		
		return retorno;
	}
	
	//METODO REGISTRA/GUARDA COMENTARIO
	@PostMapping   //json       -->spring     --> java
	public Comentario guardarComentario(@RequestBody Comentario comentario) {

		Comentario retorno = comentarioRepository.save(comentario);
		
		System.out.println("Registrando un Comentario"+retorno);

		return retorno;

	}
	
	
	//METODO ELIMINAR UN COMENTARIO
	//VALUE   ELIMINAR POR RequestMapping
	//URL   /comentarios/3x  MÉTODO: DELETE
	@DeleteMapping(value = "/{codigo}")
	public void eliminarComentario(@PathVariable Long codigo){
		
		System.out.println("El ID a eliminar: "+codigo);

		comentarioRepository.deleteById(codigo);


	}

}
