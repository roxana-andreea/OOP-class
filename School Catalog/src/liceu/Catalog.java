package liceu;

import java.util.HashMap;
import java.util.Map;

public class Catalog {

	private Map<Elev, Map<Materie, SituatieMaterieBaza>> note;

	public Map<Elev, Map<Materie, SituatieMaterieBaza>> getNote() {
		return note;
	}

	public Catalog() {
		note = new HashMap<Elev, Map<Materie, SituatieMaterieBaza>>();
	}

	@Override
	public String toString() {
		return note.toString();
	}

	public void adaugaElev(Elev e, Map<Materie, SituatieMaterieBaza> note) {
		this.note.put(e, note);
	}

	public void stergeElev(Elev e) {
		note.remove(e);
	}

	public void adaugaSituatie(Elev e, Materie m, SituatieMaterieBaza sit) {
		note.get(e).put(m, sit);
	}

	public void stergeMaterie(Elev e, Materie m) {
		note.get(e).remove(m);

	}

}
