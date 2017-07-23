package liceu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SituatieMaterieBaza {

	private Materie materie;

	private List<Integer> noteSem1;
	private List<Integer> noteSem2;

	private double medie;

	private List<Absenta> absente;

	public List<Absenta> getAbsente() {
		return absente;
	}

	public List<Integer> getNoteSem1() {
		return noteSem1;
	}

	public List<Integer> getNoteSem2() {
		return noteSem2;
	}

	public SituatieMaterieBaza(Materie materie) {
		this.materie = materie;
		noteSem1 = new ArrayList<>();
		noteSem2 = new ArrayList<>();
		absente = new ArrayList<>();
		medie = 0;
	}

	@Override
	public String toString() {
		return "Note sem1: " + noteSem1.toString() + "\nNote sem2:"
				+ noteSem2.toString() + "\nMedia: " + medie + "\nAbsente:"
				+ absente.toString() + "\n";
	}

	public double calculeazaMedia() {
		medie = (calculeazaMediaSem1() + calculeazaMediaSem2()) / 2;
		return medie;
	}

	protected double calculeazaMediaSem1() {
		double medieSem1 = 0;
		for (int i : noteSem1) {
			medieSem1 += i;
		}
		if (noteSem1.size() != 0)
			medieSem1 /= noteSem1.size();
		return medieSem1;
	}

	protected double calculeazaMediaSem2() {
		double medieSem2 = 0;
		for (int i : noteSem2) {
			medieSem2 += i;
		}
		if (noteSem2.size() != 0)
			medieSem2 /= noteSem2.size();
		return medieSem2;
	}

	public void adaugaNota(int semestru, int nota) {
		if (semestru == 1) {
			noteSem1.add(nota);
		} else {
			noteSem2.add(nota);
		}
	}

	public void adaugaNota(int semestru, int nota, boolean teza) {
		if (teza)
			return;
		adaugaNota(semestru, nota);
	}

	public void adaugaAbsenta(Date data) {
		absente.add(new Absenta(data));
	}

	public void modificaAbsenta(Date data, Absenta.STATUS status) {
		for (Absenta a : absente) {
			if (a.data.equals(data)) {
				a.setStatus(status);
				break;
			}
		}
	}

	public double getMedie() {
		return medie;
	}

	public int nrAbsente() {
		return absente.size();
	}

	static class Absenta {

		private static final STATUS DEFAULT_STATUS = STATUS.NEDETERMINAT;

		public Absenta(Date data) {
			this.data = data;
			status = DEFAULT_STATUS;
		}

		public Absenta(String data) {
			this.data = Utils.parseDate(data);
			status = DEFAULT_STATUS;
		}

		private void setStatus(STATUS status2) {
			status = status2;
		}

		enum STATUS {
			MOTIVATA, NEMOTIVATA, NEDETERMINAT
		};

		private STATUS status;
		private Date data;

		@Override
		public String toString() {
			return Utils.dateToString(data) + " " + status;
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof Absenta) {
				Absenta abs = (Absenta) o;
				return abs.data.equals(data);
			}
			return false;
		}
	}

	public void setMedie(double medie) {
		this.medie = medie;

	}
}
