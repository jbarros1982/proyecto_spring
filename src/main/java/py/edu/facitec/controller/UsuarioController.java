package py.edu.facitec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuarioController {

	@RequestMapping("/form_usuario")
	public String metodo() {

		System.out.println("Cargando pagina de usuario...");
		
		return "usuario/index";  //usuario --> PASTA
								 //index --> PAGINA

	}
}
