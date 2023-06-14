package emosocial.controller;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mongodb.MongoException;
import emosocial.document.EstadoEmocional;
import emosocial.document.UsuarioRegistrado;
import emosocial.respository.EstadoEmocionalRepositorio;
import emosocial.respository.UsuarioRegistradoRespositorio;
import modelo.Emocion;

/**
 *Especifica la ruta en el que se encontraran los mcicroservicios rest. Para manipular los documentos de la coleccion Estados 
 *esta clase contiene dos repositorios privados, permite acceso a la URL desde cualquier cliente que se encuentre en la red.
 *
 *Es un controlador que permite recibir peticiones htttp y cumple con formato de peticiones JSON.
 *
 *@author Mateo rodriguez
 *19 may. 2023
 *
 *
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Service
@RequestMapping("/emosocial")
public class EstadoEmocionalControlador {

	@Autowired
	private EstadoEmocionalRepositorio Emoreopositorio ;
	@Autowired
	private UsuarioRegistradoRespositorio usuariorepositorio;
	
	
	/**
	 * Obtiene una lista de tipo EstadoEmocional. A traves del metodo findbyemail de la clase EstadoEmocionalRepositorio busca todos los documentos con el email
	 * y devuelve un lista que contiene todos los documentos en formato json. En caso de que el email sea invalido el ResponseEntity sera null.
	 *  
	 * @param email especifica el email con el que se va a buscar los estados.
	 * @return esponseEntity<?>.
	 */
	@PostMapping("/usuarios/listar/estados")
	public ResponseEntity<?> CargarEstadosPorEmail(@RequestBody String email){
		try {
			if(email!=null) {
				List<EstadoEmocional> estados=Emoreopositorio.findByEmail(email);
				return new ResponseEntity<List <EstadoEmocional>>(estados,HttpStatus.OK);
			}
			else
				return null;
			
		
		}catch(MongoException m) {
			return null;
		}
	
	}
	
	/**
	 * Crea un nuevo documento de tipo estadoEmocional, lo agrega a la coleccion, actualiza el nivel de energia del usuario al que 
	 * corresponda el email  y devuelve el nivel de energia del usuario.
	 * 
	 * @param e es un estado solo con nombre y descripcion.
	 * @param codigo es el codigo con el que se representara a la emocion del estado
	 * @return int 
	 */
	@PutMapping("/usuarios/estados/nuevo")
	public int AlmacenarEstado(@RequestBody ObjectNode estado){
		try {

			 String email = estado.get("email").asText();
			 String descripcion = estado.get("descripcion").asText();
			 String codigo= estado.get("codigo").asText();
			 
			List <UsuarioRegistrado> usuarios=usuariorepositorio.findByEmail(email);
			
			if(usuarios.size()!=0) {
				Emocion emotion= new Emocion(codigo);
				EstadoEmocional emocionals= new EstadoEmocional(null, email,emotion.getNombre(),descripcion,LocalDateTime.now(), emotion.getValor());
				Emoreopositorio.save(emocionals);
				
				List <UsuarioRegistrado> usuarioregistrado=usuariorepositorio.findByEmail(email);
				for(UsuarioRegistrado r:usuarioregistrado) {
					
					if(r.getNivelenergia()+emotion.getValor()<=0){
							r.setNivelenergia(0);
						}
					else if(r.getNivelenergia()+emotion.getValor()>=100){
							r.setNivelenergia(100);
						}
						
					else{
						r.setNivelenergia(r.getNivelenergia()+emotion.getValor());
					}
					usuariorepositorio.save(r);
					return r.getNivelenergia();
				}

			}
			
		}
		catch(Exception ex){
			
		}
			
		return 0;
	
	}

	
}
