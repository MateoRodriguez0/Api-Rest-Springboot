package emosocial.respository;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import emosocial.document.EstadoEmocional;

/**
 * Representa un repositorio, contiene metodos de la super clase que permiten manipular los documentos de la coleccion Estados.
 * 
 * @author Mateo rodriguez
 * 
 * 19 may. 2023
 */
@Repository(value = "EmotionalStateRepository")
public interface EstadoEmocionalRepositorio extends MongoRepository<EstadoEmocional, String> {

	/**
	 * Realiza una busqueda en la coleccion Estados  y devuelve todos los documentos que contengan el email. Solo si el email es valido.
	 * 
	 * @param email el correo electronico del estado.
	 * @return List<EstadoEmocional>
	 */
	public List<EstadoEmocional> findByEmail(String email);
	
}
