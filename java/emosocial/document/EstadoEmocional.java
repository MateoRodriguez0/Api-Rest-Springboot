package emosocial.document;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representa un documento de la coleccion Estados. Contiene unas propiedades privadas que permiten diferenciar el objeto de los demas.
 * Cada objeto de tipo EstadoEmocional debe tener un Id null, ya que, el valor de esta propiedad sera establecido desde mongoDB.
 * Las colecciones en MongoDB son como tablas en una base de datos SQL, pero son grupos de documentos en lugar de grupos de registros.
 * 
 *@author Mateo rodriguez
 * 
 *19 may. 2023
 *
 *
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Document(collection = "Estados")
public class EstadoEmocional {
	@Id
	private String id;
	@Field("email")
	private String email;
	@Field("emocion")
	private String emocion;
	@Field("descripcion")
	private String descripcion;
	@Field("fecha")
	private LocalDateTime fecha;
	@Field("valor")
	private int valor;
}
