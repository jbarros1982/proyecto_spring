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

import py.edu.facitec.model.Suscrito;
import py.edu.facitec.repository.SuscritoRepository;


//URL A LA CUAL VA RESPONDER
//CONTROLADOR ES UN INTERMEDIARIO ENTRE EL SERVIDOR Y EL CLIENTE
@RequestMapping("/suscritos")
@RestController
public class SuscritoController {


	//DAO
	@Autowired //INICIAR O CREAR EL OBJETO
	//ES UNA INJECCION DE DEPENDENCIA
	//SPRING BOOT GESTIONARIA EL OBJETO
	private SuscritoRepository suscritoRepository;

	//METODO RETORNA LA LISTA DE SUSCRITOS EN FORMATO JSON
	//URL /suscritos  VERBO: GET
	@GetMapping
	public List<Suscrito> getSuscritos(){

		System.out.println("Listando todos los suscritos");

		List<Suscrito> retorno=suscritoRepository.findAll();

		return retorno;
	}

	//METODO RETORNA UN UNICO SUCRITO, INFORMANDO EL CODIGO EN LA BUSQUEDA
	//VALUE   AGREGAR UNA URL AL ESTABLECIDO MÁS ARRIBA POR RequestMapping
	//URL   /suscritos/3x  MÉTODO: GET
	@GetMapping(value = "/{codigo}")
	public Optional<Suscrito> getSuscrito(@PathVariable Long codigo){

		Optional<Suscrito> retorno=suscritoRepository.findById(codigo);

		System.out.println("Esta presente? "+retorno.isPresent());

		return retorno;

	}


	//METODO REGISTRA/GUARDA UN SUSCRITO
	@PostMapping   //json       -->spring     --> java
	public Suscrito guardarSuscrito(@RequestBody Suscrito suscrito) {

		Suscrito retorno = suscritoRepository.save(suscrito);
		
		System.out.println("Registrando un Suscrito"+retorno);

		return retorno;

	}
	
	
	//METODO ELIMINAR UN SUCRITO
	//VALUE   ELIMINAR POR RequestMapping
	//URL   /suscritos/3x  MÉTODO: DELETE
	@DeleteMapping(value = "/{codigo}")
	public void eliminarSuscrito(@PathVariable Long codigo){
		
		System.out.println("El ID a eliminar: "+codigo);

		suscritoRepository.deleteById(codigo);


	}
	
	//RESUMO DE LOS METODOS IMPLEMENTADOS DE ACUERDO A LA URL Y EL VERBO UTILIZADO
	
	// suscritos     			GET
	// suscritos/3   			GET
	// suscritos	 			POST
	// suscritos/eliminar/3     DELETE




}


