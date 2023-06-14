package emosocial.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
/**
 * Representa un documento de la coleccion user.
 * Las colecciones en MongoDB son como tablas en una base de datos SQL, pero son grupos de documentos en lugar de grupos de registros.
 * 
 * @author Mateo rodriguez
 *19 may. 2023
 */

@Document(collection = "user")
public class UsuarioRegistrado {
	
	
	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	@Id
	private String id;
	@Field("nombre")
	private String nombre;
	@Field("apellido")
	private String apellido;
	@Field("correo")
	private String email;
	@Field("clave")
	private String clave;
	@Field("celular")
	private String telefono;
	@Field("fechaNacimiento")
	private Date nacimiento;
	@Field("nivelEnergia")
	private int nivelenergia;
	@Field("genero")
	private String Genero;
	/**
	 * Obtiene una icadena que representa el id del usuario registrado.
	 * un id es una cadena de caracteres que pude contenere numeros y letras. Permite identificar a un ursuario en la coleccion.
	 * @return El ID.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Obtiene una cadena que representa el nombre del usuario registrado.
	 * 
	 * @return el nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Obtiene una cadena que representa el apellido del usuario registrado.
	 * 
	 * @return El apellido 
	 */
	public String getApellido() {
		return apellido;
	}
	
	/**Obtiene una cadena que representa el email del usuario registrado.
	 * 
	 * @return el email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Obtiene una cadena que representa la clave del usuario registrado.
	 * 
	 * @return obtiene la clave del usuario.
	 */
	public String getclave() {
		return clave;
	}
	
	
	/**
	 * Obtiene el numero telefonico. El tipo de dato es cadena, ya que no se realizara ningun tipo de operaciones con el numero.
	 * 
	 * @return el telefono.
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * obtene la fecha de nacimiento en formato de fecha y hora.
	 * 
	 * @return la fecha de nacimiento 
	 */
	public Date getNacimiento() {
		return nacimiento;
	}
	
	/**
	 *Obtiene el valor del nivel de energia.
	 * 
	 * @return el nivel de energia-
	 */
	public int getNivelenergia() {
		return nivelenergia;
	}
	
	public void setNivelenergia(int nivelenergia) {
		this.nivelenergia = nivelenergia;
	}
	/**
	 * 
	 * @return la clave del usuario registrado.
	 */
	public String getClave() {
		return clave;
	}

	public String getGenero() {
		return Genero;
	}



}
/**
 * 
 * @author Mateo rodriguez
 *19 may. 2023
 */