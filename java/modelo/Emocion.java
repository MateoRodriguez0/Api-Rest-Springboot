package modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Permite crear una nueva emocion que sera utilizada para registrar un estado emocional.
 * 
 * @author Mateo rodriguez
 * 
 *19 may. 2023
 *
 *
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class Emocion {

	/**
	 * solo si el constructor recibe un codigo valido las propiedades de el objeto se congiguraran correctamente.
	 * @param Recibe el codigo de la emocion. 
	 */
	public Emocion(String codigo) {
		super();
		this.codigo = codigo;
		configuraremocion(codigo);
	}
	private String codigo;
	private String nombre;
	private int valor;
	
	
	private void configuraremocion(String codigo) {
		switch(codigo){
		case "H1":{
			this.setNombre("Tranquilidad");
			this.setValor(4);
			break;
			
		}
		case "H2":{
			this.setNombre("Felicidad");
			this.setValor(8);
			break;
			
		}
		case "H3":{
			this.setNombre("Mucha felicidad");
			this.setValor(12);
			break;
			
		}
		case "H4":{
			this.setNombre("aliviado");
			this.setValor(16);
			break;
			
		}
		case "M1":{
			this.setNombre("Aburrido");
			this.setValor(-4);
			break;
			
		}
		case "M2":{
			this.setNombre("Mal humor");
			this.setValor(-8);
			break;
			
		}
		case "M3":{
			this.setNombre("Molesto");
			this.setValor(-12);
			break;
			
		}
		case "M4":{
			this.setNombre("Enfadado ");
			this.setValor(-16);
			break;
			
		}
	
		case "S1":{
			this.setNombre("Confundido");
			this.setValor(-4);
			break;
			
		}
		case "S2":{
			this.setNombre("Incertidumbre");
			this.setValor(-8);
			break;
			
		}
		case "S3":{
			this.setNombre("Triste");
			this.setValor(-12);
			break;
			
		}case "S4":{
			this.setNombre("Muy triste");
			this.setValor(-16);
			break;
			
		}
		}
		
	}
	
	
}
