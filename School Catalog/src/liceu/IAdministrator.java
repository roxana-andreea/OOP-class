package liceu;

import java.util.List;

/**
 * 
 * @author Roxana Cazacu
 * @grupa 324CC
 *
 */
public interface IAdministrator {

	
	/**
	 * Sterge un utilizator din sistem
	 * @param username
	 */
	public void deleteUser(String username);

	/**
	 * intoarce o lista cu toti utilizatorii
	 * @return
	 */
	public List<Utilizator> listUsers();

	/**
	 * Creeaza un utilizator nou
	 * @param username
	 * @param password
	 * @param nume
	 * @param prenume
	 * @param tip Elev, Profesor, Secretar sau Administrator
	 * @param aux CNP in cazul Elevului, Materia in cazul Profesorului, null in rest 
	 * @return
	 */
	Utilizator createUser(String username, String password, String nume,
			String prenume, String tip, String aux);
}
