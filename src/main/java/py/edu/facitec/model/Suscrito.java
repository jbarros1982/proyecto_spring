package py.edu.facitec.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

//PARA PODER CREAR UNA TABLA PERSISTENTE UTILIZAMOS
//LA NOTACION "@Entity"

@Entity //IDENTIFICAR LA TABLA

public class Suscrito {

	@Id //INDICA QUE "codigo" SERIA LA CLAVE PRIMARIA
	
	//OBS: LAS TABLAS DEBEN TENER AL MENOS ESOS 2, @Entity y @Id
	
	//@GeneratedValue NÃO É OBRIGATORIO, PERO ES RESPONSABLE
	//POR GENERAR DE FORMA AUTOMATICA LOS NUEVOS ID
	
	@GeneratedValue

	private Long codigo;

	private String nombre;

	private String correo;
	
	//SOLUCIONAR ERROR RECURSIVIDAD INFINITA
	//@JsonManagedReference(value= "variableRelacionCS") //caso se dice que la lista es mas importante se utiliza eso en dos partes ( EN EL EXAMEN)
	@JsonIgnore //Se ignorara la lista (caso se dice que el objeto es mas importante se utiliza eso solo aca ( EN EL EXAMEN ) 
	
	//UNO A MUCHOS        //RELACION DE ASOCIACION BIDIRECIONAL
	     //PARA CREAR EFECTIVAMENTE DOS TABLAS
	@OneToMany(mappedBy = "suscrito")
	private List<Comentario> comentarios;

	//GETTER AND SETTERS
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	//TO STRING
	
	@Override
	public String toString() {
		return "Suscrito [codigo=" + codigo + ", nombre=" + nombre + ", correo=" + correo + ", comentarios="
				+ comentarios + "]";
	}
	
	
	
	



	


	





}
