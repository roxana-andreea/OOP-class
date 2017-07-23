package liceu;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import liceu.SituatieMaterieBaza.Absenta.STATUS;

public class Profesor extends Utilizator implements IProfesor {

	private List<Clasa> clase;
	private Map<Materie, Map<Clasa, Profesor>> materii;

	public Profesor(String user, String parola, String nume, String prenume,
			Materie materie, Map<Materie, Map<Clasa, Profesor>> materii,
			List<Clasa> clase) {
		super(user, parola, nume, prenume);
		this.materie = materie;
		this.clase = clase;
		this.materii = materii;
	}

	private Materie materie;

	@Override
	public String toString() {
		return "Profesor " + super.toString() + " " + materie.getNume();
	}

	public void setMaterie(Materie m) {
		materie = m;

	}

	@Override
	public void adaugaNota(Elev e, int semestru, int nota, boolean teza) {
		e.situatieScolara().get(materie).adaugaNota(semestru, nota, teza);
	}

	@Override
	public void adaugaNota(Elev e, int semestru, int nota) {
		e.situatieScolara().get(materie).adaugaNota(semestru, nota, false);
	}

	@Override
	public void modificareMedie(Elev e, double medie) {
		e.situatieScolara().get(materie).setMedie(medie);
	}

	@Override
	public void calculeazaMedie(Elev e) {
		e.situatieScolara().get(materie).calculeazaMedia();

	}

	@Override
	public void listareStudenti(String idClasa) {
		Clasa c = null;
		for (int i = 0; i < clase.size(); i++)
			if (clase.get(i).getId().equals(idClasa)) {
				c = clase.get(i);
				break;
			}
		if (c == null)
			return;

		for (Elev e : c.getElevi()) {
			System.out.println(e.toString());
		}

	}

	@Override
	public void ordonareStudenti(String idClasa, Criteriu crit) {
		Clasa c = null;
		for (int i = 0; i < clase.size(); i++)
			if (clase.get(i).getId().equals(idClasa)) {
				c = clase.get(i);
				break;
			}
		if (c == null)
			return;

		List<Elev> elevi = c.getElevi();

		switch (crit) {
		case ALFABETIC:
			Collections.sort(elevi, new Comparator<Elev>() {

				@Override
				public int compare(Elev o1, Elev o2) {
					int cmp = o1.getNume().compareTo(o2.getNume());
					if (cmp == 0)
						return o1.getPrenume().compareTo(o2.getPrenume());
					return cmp;
				}
			});
			break;
		case DUPA_MEDIE:
			Collections.sort(elevi, new Comparator<Elev>() {

				@Override
				public int compare(Elev o1, Elev o2) {
					if (o1.situatieScolara().get(materie).getMedie() < o2
							.situatieScolara().get(materie).getMedie())
						return -1;
					return 1;
				}
			});
			break;
		case DUPA_MEDIE_GENERALA:
			Collections.sort(elevi, new Comparator<Elev>() {

				@Override
				public int compare(Elev o1, Elev o2) {
					if (o1.getMedieGenerala() < o2.getMedieGenerala())
						return -1;
					return 1;
				}
			});
			break;
		case NR_ABSENTE:
			Collections.sort(elevi, new Comparator<Elev>() {

				@Override
				public int compare(Elev o1, Elev o2) {
					return -Integer.compare(o1.nrAbsente(), o2.nrAbsente());
				}
			});
			break;
		default:
			break;
		}
		return;
	}

	@Override
	public void adaugaAbsenta(Elev e, String data) {
		SituatieMaterieBaza sit = e.situatieScolara().get(materie);
		sit.adaugaAbsenta(Utils.parseDate(data));
	}

	@Override
	public void modifcaAbsenta(Elev e, String data, STATUS status) {
		SituatieMaterieBaza sit = e.situatieScolara().get(materie);
		sit.modificaAbsenta(Utils.parseDate(data), status);

	}

	@Override
	public void alegeClasa(String idClasa) {
		Clasa c = afiseazaClasa(idClasa);
		if (c == null)
			return;
		materii.get(materie).put(c, this);
	}

	@Override
	public Clasa afiseazaClasa(String idClasa) {
		for (Clasa c : clase)
			if (c.getId().equals(idClasa))
				return c;
		return null;

	}

}
