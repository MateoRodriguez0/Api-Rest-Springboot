package emosocial.controller;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mongodb.MongoException;
import emosocial.document.UsuarioRegistrado;
import emosocial.respository.UsuarioRegistradoRespositorio;
import modelo.DatosPersonalesDeUsuario;

/**
*Especifica la ruta en el que se encontraran los mcicroservicios rest. Para manipular los documentos de la coleccion user
 *esta clase contiene un repositorio privado, permite acceso a los microserivicios desde cualquier cliente que se encuentre en la red.
 *
 *Es un controlador que permite recibir peticiones htttp y cumple con formato de peticiones JSON.
 *  
 * @author Mateo rodriguez
 *19 may. 2023
 *
 *
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Service
@RequestMapping("/emosocial")
public class UsuarioRegistradoControlador {


	@Autowired
	private UsuarioRegistradoRespositorio repositorio;
	
	
	/**
	 * Utiliza el metodo finbyemail del repositorio ya que el email es unico solo debera devolver un documento.
	 * A partir la lista que devuelve el metodo finbyemail, se recorre la lista con bucles o sentencias  de control de flujo, se crea y devuelve un 
	 * objeto de tipo DatosPersonalesDeUsuario. Solo en caso de que no se encuentre el documento u ocurra algun error inesperado
	 * el ResponseEntity sera null.
	 * 
	 * @param email especifica el correo electronico 
	 * @return ResponseEntity<?> 
	 */
	@PostMapping("/usuarios/cargar/informacion")
	public ResponseEntity<?>CargarInformacionPersonal(@RequestBody() String email) {
		
		if (email!=null) {
			try {
				DatosPersonalesDeUsuario infouser=new DatosPersonalesDeUsuario();
					List <UsuarioRegistrado> usuarioregistrado=repositorio.findByEmail(email);
					for(UsuarioRegistrado R:usuarioregistrado) {
						LocalDate fechanacimiento = R.getNacimiento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
						LocalDate fechaexacta= LocalDate.of(fechanacimiento.getYear(),fechanacimiento.getMonth(), fechanacimiento.getDayOfMonth()+1);
						infouser=new DatosPersonalesDeUsuario(R.getNombre(), R.getApellido(), R.getEmail(),R.getTelefono(),fechaexacta,R.getGenero(),R.getNivelenergia());
						return new ResponseEntity<DatosPersonalesDeUsuario>(infouser,HttpStatus.OK);
					}	
			}catch(MongoException m) {
				return null;
			}
		}	
		return null;
	}
	
	
	
	
	
	
	/**
	 * Obtiene el nivel de energia del documento. solo si el email es valido devolvera un response de tipo
	 * Integer, de lo contrario sera null el response.
	 * 
	 * @param email especifica el correo electronico 
	 * @return ResponseEntity<Integer> 
	 */
	@PostMapping("/usuarios/energia")
	public ResponseEntity<Integer> getNiveldeEnergia(@RequestBody  String email) {
		try {
			List <UsuarioRegistrado> usuarioregistrado=repositorio.findByEmail(email);
			
			for(UsuarioRegistrado r:usuarioregistrado) {
				return new ResponseEntity<Integer>(r.getNivelenergia(),HttpStatus.OK);
			}
			
			usuarioregistrado=null;
		}catch(MongoException m) {
			return new ResponseEntity<Integer>(0,HttpStatus.BAD_REQUEST);
		}
		return null;
		
	}
	
	
	/**
	 * Obtiene el email de un Usuario registrado siempre y cuando el email este registrado y la contraseña sea correcta.
	 * Si la contraseña no es correcta y/o si ambos datos son invalido esl ResponseEnity sera null.
	 * 
	 * @param email especifica el email 
	 * @param clave especifica la clave pertenciente al email
	 * @return ResponseEntity<String> 
	 */
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/inicio")
	public ResponseEntity<String> autenticacionDeUsuario( @RequestBody ObjectNode userinicio) {
		try {
			String email = userinicio.get("email").asText();
			String clave = userinicio.get("clave").asText();
			List <UsuarioRegistrado> usuarioregistrado=repositorio.findByEmail(email);
			
			for(UsuarioRegistrado r:usuarioregistrado) {
				if(clave.equals(r.getclave())) {
					return new ResponseEntity<String>(r.getEmail(),HttpStatus.OK);
				}	
			}
			usuarioregistrado=null;
		}catch(MongoException m) {
			return new ResponseEntity<>("",HttpStatus.BAD_REQUEST);
		}
		return null;
		
	}
	
	
}
/**
 * 
 * @author Mateo rodriguez
 *19 may. 2023
 */