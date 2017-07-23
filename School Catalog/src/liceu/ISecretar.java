package liceu;

/**
 * 
 * @author Roxana Cazacu
 * @grupa 324CC
 * 
 */
public interface ISecretar {

	/**
	 * adauga o clasa noua
	 * @param id
	 * @return
	 */
	Clasa adaugaClasa(String id);

	/**
	 * sterge o clasa
	 * @param id
	 */
	void stergeClasa(String id);

	/**
	 * Intoarce o instanta a clasei pentru  a fi modificata
	 * @param id
	 * @return
	 */
	Clasa modificaClasa(String id);

	/**
	 * adauga un elev la o clasa
	 * @param nume
	 * @param prenume
	 * @param idClasa
	 */
	void adaugaElev(String nume, String prenume, String idClasa);
	

	/**
	 * sterge un elev de la o clasa
	 * @param nume
	 * @param prenume
	 * @param idClasa
	 */
	void stergeElev(String nume, String prenume, String idClasa);

	/**
	 * intoarce o instanta a elevului pentru a fi modificat
	 * @param nume
	 * @param prenume
	 * @return
	 */
	Elev modificaElev(String nume, String prenume);

	/**
	 * adauga o materie la o clasa
	 * @param nume
	 * @param idClasa
	 */
	void adaugaMaterieLaClasa(String nume, String idClasa);

	/**
	 * sterge o materie de la o clasa
	 * @param nume
	 * @param idClasa
	 */
	void stergeMaterieDeLaClasa(String nume, String idClasa);

	/**
	 * intoarce o instanta a materiei pentru a fi modificata
	 * @param nume
	 * @param idClasa
	 * @return
	 */
	Materie modificaMaterieDeLaClasa(String nume,String idClasa);
	
	

}
