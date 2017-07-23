package liceu;

import liceu.SituatieMaterieBaza.Absenta;

/**
 * 
 * @author Roxana Cazacu
 * @grupa 324CC
 * 
 */
public interface IProfesor {

	public enum Criteriu {
		ALFABETIC, DUPA_MEDIE, DUPA_MEDIE_GENERALA, NR_ABSENTE
	}

	/**
	 * Afiseaza toti studentii de la o clasa
	 * 
	 * @param idClasa
	 */
	void listareStudenti(String idClasa);

	/**
	 * Ordoneaza studentii dupa un criteriu
	 * 
	 * @param idClasa
	 * @param crit
	 */
	void ordonareStudenti(String idClasa, Criteriu crit);

	/**
	 * Modifica media unui elev
	 * 
	 * @param e
	 * @param medie
	 */
	void modificareMedie(Elev e, double medie);

	/**
	 * Calculeaza media unui elev
	 * 
	 * @param e
	 */
	void calculeazaMedie(Elev e);

	/**
	 * Adauga o absenta
	 * 
	 * @param e
	 * @param data
	 */
	void adaugaAbsenta(Elev e, String data);

	/**
	 * modifica o absenta
	 * 
	 * @param e
	 * @param data
	 * @param status
	 */
	void modifcaAbsenta(Elev e, String data, Absenta.STATUS status);

	/**
	 * Adauga o nota
	 * 
	 * @param e
	 * @param semestru
	 * @param nota
	 */
	void adaugaNota(Elev e, int semestru, int nota);

	/**
	 * Adauga o nota pentru materiile cu teza
	 * 
	 * @param e
	 * @param semestru
	 * @param nota
	 * @param teza
	 */
	void adaugaNota(Elev e, int semestru, int nota, boolean teza);

	/**
	 * Alege o clasa la care sa predea
	 * 
	 * @param idClasa
	 */
	void alegeClasa(String idClasa);

	/**
	 * Intoarce o instanta a clasei pentru a fi modificata
	 * 
	 * @param idClasa
	 * @return
	 */
	Clasa afiseazaClasa(String idClasa);

}
