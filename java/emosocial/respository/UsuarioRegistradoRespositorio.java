package emosocial.respository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import emosocial.document.UsuarioRegistrado;
/**
 *Representa un repositorio, contiene metodos de la super clase que permiten manipular los documentos  de la coleccion user.
 *
 *@author Mateo rodriguez
 *
 *19 may. 2023
 */

@Repository(value = "RegisteredUserRepository ")
public interface UsuarioRegistradoRespositorio extends MongoRepository<UsuarioRegistrado, Integer> {

	/**
	 * Realiza una busqueda en la coleccion user  y devuelve todos los documentos que contengan el email, solo si el email es valido.
	 * 
	 * @param email el correo electronico del estado.
	 * @return List<UsuarioRegistrado>
	 */
	public List<UsuarioRegistrado> findByEmail(String email);
	
}
