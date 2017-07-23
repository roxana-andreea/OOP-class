package liceu;

import java.util.List;
import java.util.Map;

import liceu.SituatieMaterieBaza.Absenta.STATUS;

public class Administrator extends Utilizator implements IAdministrator,
		IProfesor, ISecretar {

	/**
	 * 
	 */
	private List<Utilizator> users;
	private Map<Materie, Map<Clasa, Profesor>> materii;
	private List<Clasa> clase;

	private Secretar secretar = null;
	private Profesor profesor = null;

	public Administrator(String user, String parola, String nume,
			String prenume, List<Utilizator> users,
			Map<Materie, Map<Clasa, Profesor>> materii, List<Clasa> clase) {
		super(user, parola, nume, prenume);
		this.users = users;
		this.materii = materii;
		this.clase = clase;
		secretar = new Secretar(user, parola, nume, prenume, users, materii,
				clase);
		profesor = new Profesor(user, parola, nume, prenume, null, materii,
				clase);
	}

	@Override
	public Utilizator createUser(String username, String password, String nume,
			String prenume, String tip, String aux) {
		Utilizator u = null;
		switch (tip) {
		case "Administrator":
			u = new Administrator(username, password, nume, prenume,
					this.users, this.materii, clase);
			break;
		case "Elev":
			u = new Elev(username, password, nume, prenume, aux);
			break;
		case "Secretar":
			u = new Secretar(username, password, nume, prenume, users, materii,
					clase);
			break;
		case "Profesor":
			String numeMaterie = aux;
			for (Materie m : materii.keySet()) {
				if (m.getNume().equals(numeMaterie)) {
					u = new Profesor(username, password, nume, prenume, m,
							materii, clase);
					break;
				}
			}
			break;
		}
		if (u == null)
			return null;
		for (Utilizator user : users) {
			if (user.equals(u))
				return null;
		}
		users.add(u);
		return u;
	}

	@Override
	public void deleteUser(String user) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUsername().equals(user)) {
				users.remove(i);
				break;
			}
		}
	}

	@Override
	public List<Utilizator> listUsers() {
		return users;
	}

	@Override
	public Clasa modificaClasa(String id) {
		return secretar.modificaClasa(id);
	}

	@Override
	public String toString() {
		return "Administrator " + super.toString();
	}

	@Override
	public Clasa adaugaClasa(String id) {
		return secretar.adaugaClasa(id);
	}

	@Override
	public void stergeClasa(String id) {
		secretar.adaugaClasa(id);
	}

	// @Override
	// public void adaugaMaterie(String nume, int nrOre, boolean teza) {
	// secretar.adaugaMaterie(nume, nrOre, teza);
	//
	// }
	//
	// @Override
	// public void stergeMaterie(String nume) {
	// secretar.stergeMaterie(nume);
	// }
	//
	// @Override
	// public void modificaMaterie(String nume, int nrOre, boolean teza) {
	// secretar.modificaMaterie(nume, nrOre, teza);
	// }

	@Override
	public void listareStudenti(String idClasa) {
		profesor.listareStudenti(idClasa);

	}

	@Override
	public void ordonareStudenti(String idClasa, Criteriu crit) {
		profesor.ordonareStudenti(idClasa, crit);

	}

	@Override
	public void adaugaNota(Elev e, int semestru, int nota) {
		profesor.adaugaNota(e, semestru, nota);
	}

	@Override
	public void adaugaNota(Elev e, int semestru, int nota, boolean teza) {
		profesor.adaugaNota(e, semestru, nota, teza);
	}

	@Override
	public void modificareMedie(Elev e, double medie) {
		profesor.modificareMedie(e, medie);
	}

	@Override
	public void calculeazaMedie(Elev e) {
		profesor.calculeazaMedie(e);
	}

	@Override
	public void adaugaAbsenta(Elev e, String data) {
		profesor.adaugaAbsenta(e, data);
	}

	@Override
	public void modifcaAbsenta(Elev e, String data, STATUS status) {
		profesor.modifcaAbsenta(e, data, status);
	}

	@Override
	public void adaugaElev(String nume, String prenume, String idClasa) {
		secretar.adaugaElev(nume, prenume, idClasa);
	}

	@Override
	public void stergeElev(String nume, String prenume, String idClasa) {
		stergeElev(nume, prenume, idClasa);

	}

	@Override
	public Elev modificaElev(String nume, String prenume) {
		return modificaElev(nume, prenume);
	}

	@Override
	public void adaugaMaterieLaClasa(String nume, String idClasa) {
		secretar.adaugaMaterieLaClasa(nume, idClasa);

	}

	@Override
	public void stergeMaterieDeLaClasa(String nume, String idClasa) {
		secretar.stergeMaterieDeLaClasa(nume, idClasa);

	}

	@Override
	public Materie modificaMaterieDeLaClasa(String nume, String idClasa) {
		return secretar.modificaMaterieDeLaClasa(nume, idClasa);
	}

	@Override
	public void alegeClasa(String idClasa) {
		profesor.alegeClasa(idClasa);
	}

	@Override
	public Clasa afiseazaClasa(String idClasa) {
		return profesor.afiseazaClasa(idClasa);
	}

}
