package py.edu.facitec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//NOTACION QUE INDICA QUE ES UN CONTROLADOR.

@Controller

public class HomeController {
	
	//COMO ESE METODO VA RESPONDER A UNA URL UTILIZAMOS LA NOTACION "@RequestMapping"
	//QUE VA INDICAR LA RAIZ DE NUESTRA APLICACION --> ("/"), O SEA CUANDO INICIE NUESTRA
	//APLICACION VA CARGAR EL ARCHIVO "index"'
	
	@RequestMapping("/")
	
	public String index() {
		
		System.out.println("Cargando pagina de inicio..."); //VAMOS MOSTRAR UN MENSAJE
														 //AL MOMENTO QUE SE CARGUE
														 //DE LA APLICACION
		//ESO INDICA LA PAGINA QUE IRA RETORNAR
		//EN EL CASO SERIA "index"
		
		return "index"; //NO HACE FALTA PONER INDEX.HTML
						//YA QUE EN APPLICATIONPROPERTIES
						//EN LA LINEA "spring.mvc.view.suffix=.html"
						//YA ESPECIFICAMOS QUE TODO EN QUE VAMOS TRABAJAR 
						//SERA HTML Y ESO VA COMPLETAR
	}

}

