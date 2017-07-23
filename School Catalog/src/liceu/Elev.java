package liceu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Elev extends Utilizator implements IElev {

	public Elev(String user, String parola, String nume, String prenume,
			String CNP) {
		super(user, parola, nume, prenume);
		this.CNP = CNP;
		materii = new HashMap<>();
	}

	private String CNP;
	private Map<Materie, SituatieMaterieBaza> materii;

	@Override
	public String toString() {
		return "Elev " + super.toString() + " " + CNP;
	}

	public String getCnp() {
		return CNP;
	}
	
	public String getDataNasterii() {
		return CNP.substring(5, 7) + "/" + CNP.substring(3, 5) + "/"
				+ CNP.substring(1, 3);
	}

	@Override
	public List<String> getUserData() {
		List<String> userData = super.getUserData();
		userData.add(CNP);
		userData.add(getDataNasterii());
		return userData;
	}

	public Map<Materie, SituatieMaterieBaza> situatieScolara() {
		return materii;
	}

	public Map<Materie, SituatieMaterieBaza> adaugaMaterii(List<Materie> materii) {
		for (Materie m : materii) {
			if (m.areTeza())
				this.materii.put(m, new SituatieMaterieCuTeza(m));
			else
				this.materii.put(m, new SituatieMaterieBaza(m));
		}
		return this.materii;
	}

	public SituatieMaterieBaza adaugaMaterie(Materie m) {
		SituatieMaterieBaza sit = null;
		if (m.areTeza())
			sit = new SituatieMaterieCuTeza(m);
		else
			sit = new SituatieMaterieCuTeza(m);
		materii.put(m, sit);
		return sit;
	}

	public void stergeMaterie(Materie m) {
		materii.remove(m);
	}

	public double getMedieGenerala() {

		double medie = 0;
		for (SituatieMaterieBaza sit : materii.values()) {
			medie += sit.getMedie();
		}
		if (materii.size() != 0)
			medie = medie / materii.size();

		return medie;
	}

	public int nrAbsente() {
		int nr = 0;
		for (SituatieMaterieBaza sit : materii.values()) {
			nr += sit.nrAbsente();
		}
		return nr;
	}

}
