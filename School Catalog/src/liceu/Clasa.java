package liceu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Clasa {

	private String idClasa;
	private List<Elev> elevi;
	private List<Materie> materii;
	private Catalog catalog;

	public Clasa(String idClasa) {
		this.idClasa = idClasa;
		elevi = new ArrayList<>();
		materii = new ArrayList<>();
		catalog = new Catalog();
	}

	public void adaugaElev(Elev e) {
		elevi.add(e);
		catalog.adaugaElev(e, e.adaugaMaterii(materii));
	}

	public void stergeElev(Elev e) {
		elevi.remove(e);
		catalog.stergeElev(e);
	}

	public Catalog getCatalog() {
		return catalog;
	}

	@Override
	public String toString() {
		String s = idClasa + "\nElevi:" + elevi.toString() + "\nMaterii:";
		Map<Materie, Map<Clasa, Profesor>> map = Centralizator.getInstance()
				.getSubjects();
		Map<Materie,Profesor> m2 = new HashMap<>();
		for (Materie m : materii) {
			Profesor prof = map.get(m).get(this);
			m2.put(m,prof);
		}
		s+=m2.toString();

		return s;
	}

	public String getId() {
		return idClasa;
	}

	public List<Elev> getElevi() {
		return elevi;
	}

	public void adaugaMaterie(Materie m) {
		materii.add(m);
		for (Elev e : elevi)
			catalog.adaugaSituatie(e, m, e.adaugaMaterie(m));
	}

	public void stergeMaterie(Materie m) {
		materii.remove(m);
		for (Elev e : elevi) {
			e.stergeMaterie(m);
			catalog.stergeMaterie(e, m);
		}

	}

	public Materie modificaMateria(String nume) {
		for (Materie m : materii) {
			if (m.getNume().equals(nume))
				return m;
		}
		return null;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Clasa) {
			Clasa c = (Clasa) o;
			return idClasa.equals(c.idClasa);
		}
		return false;

	}

	@Override
	public int hashCode() {
		return idClasa.hashCode();
	}

}
