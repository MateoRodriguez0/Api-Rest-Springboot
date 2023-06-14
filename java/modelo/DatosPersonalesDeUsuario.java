package modelo;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/**
 * Se utiliza para obtener la informacion personal de un usuario sin su contraseña.
 * permite manipular los datos de un objeto de tipo UsuarioRegistrado. Principalmente es utilizado para obtener las propiedades de 
 * un nuevo UsuarioRegrtrado y cargar los datos necesarios en una interfaz, como lo pueden ser: nombre, apellido,email,nacimiento etc.
 * A diferencia de la clase UsuarioRegistrado la propiedad de nacimiento en esta clase de tipo Localdate ya que permite mostrar la 
 * fecha en formato 0000-00-00. 
 * @author Mateo rodriguez
 *19 may. 2023
 *
 *
 */
@Setter
@Getter
@AllArgsConstructor
public class DatosPersonalesDeUsuario {
	/**
	 *Crea un nuevo instancia de tipo DatosPersonalesDeUsuario
	 */
	public DatosPersonalesDeUsuario() {
		
	}
	@Field("nombre")
	private String nombre;
	@Field("apellido")
	private String apellido;
	@Field("email")
	private String email;
	@Field("telefono")
	private String telefono;
	@Field("fecha de nacimiento")
	private LocalDate nacimiento;
	@Field("genero")
	private String genero;
	@Field("energia")
	private int nivelenergia;
	
	
}
