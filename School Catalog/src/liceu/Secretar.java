package liceu;

import java.util.List;
import java.util.Map;

public class Secretar extends Utilizator implements ISecretar {

	private Map<Materie, Map<Clasa, Profesor>> materii;
	private List<Clasa> clase;
	private List<Utilizator> users;

	public Secretar(String user, String parola, String nume, String prenume,
			List<Utilizator> users, Map<Materie, Map<Clasa, Profesor>> materii,
			List<Clasa> clase) {
		super(user, parola, nume, prenume);
		this.materii = materii;
		this.clase = clase;
		this.users = users;
	}

	@Override
	public Clasa adaugaClasa(String id) {
		Clasa c = new Clasa(id);
		clase.add(c);
		return c;
	}

	@Override
	public void stergeClasa(String id) {
		for (int i = 0; i < clase.size(); i++) {
			if (clase.get(i).getId().equals(id)) {
				clase.remove(id);
				return;
			}
		}
	}

	@Override
	public Clasa modificaClasa(String id) {
		for (int i = 0; i < clase.size(); i++) {
			if (clase.get(i).getId().equals(id)) {
				return clase.get(i);
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "Secretar " + super.toString();
	}

	// @Override
	// public void adaugaMaterie(String nume, int nrOre, boolean teza) {
	// Materie m = new Materie(nume, nrOre, teza);
	// if (materii.containsKey(m)) {
	// System.err.println("Materia " + nume + " exista deja");
	// return;
	// }
	// materii.put(m, new HashMap<Clasa, Profesor>());
	// }

	// @Override
	// public void stergeMaterie(String nume) {
	// for (Materie m : materii.keySet()) {
	// if (m.getNume().equals(nume)) {
	// materii.remove(m);
	// return;
	// }
	// }
	// }

	// @Override
	// public void modificaMaterie(String nume, int nrOre, boolean teza) {
	// for (Materie m : materii.keySet()) {
	// if (m.getNume().equals(nume)) {
	// m.setNrOre(nrOre);
	// m.setTeza(teza);
	// }
	// }
	// }

	@Override
	public void adaugaElev(String nume, String prenume, String idClasa) {
		Elev e = modificaElev(nume, prenume);
		Clasa c = modificaClasa(idClasa);

		if (e == null || c == null)
			return;
		c.adaugaElev(e);
	}

	@Override
	public void stergeElev(String nume, String prenume, String idClasa) {
		Elev e = modificaElev(nume, prenume);
		Clasa c = modificaClasa(idClasa);

		if (e == null || c == null)
			return;
		c.stergeElev(e);
	}

	@Override
	public Elev modificaElev(String nume, String prenume) {
		Elev e = null;
		for (int i = 0; i < users.size(); i++) {
			Utilizator u = users.get(i);
			if (u.getNume().equals(nume) && u.getPrenume().equals(prenume)
					&& u instanceof Elev) {
				e = (Elev) u;
				break;
			}
		}
		return e;
	}

	@Override
	public void adaugaMaterieLaClasa(String nume, String idClasa) {
		Materie m = modificaMaterieDeLaClasa(nume, null);
		Clasa c = modificaClasa(idClasa);
		if (m == null || c == null)
			return;
		c.adaugaMaterie(m);
	}

	@Override
	public void stergeMaterieDeLaClasa(String nume, String idClasa) {
		Materie m = modificaMaterieDeLaClasa(nume, idClasa);
		Clasa c = modificaClasa(idClasa);
		if (m == null || c == null)
			return;
		c.stergeMaterie(m);
	}

	@Override
	public Materie modificaMaterieDeLaClasa(String nume, String idClasa) {
		if (idClasa == null) {
			for (Materie m : materii.keySet()) {
				if (m.getNume().equals(nume)) {
					return m;
				}
			}
			return null;
		} else {
			Clasa c = modificaClasa(idClasa);
			return c.modificaMateria(nume);
		}

	}

}
