package liceu;

public class SituatieMaterieCuTeza extends SituatieMaterieBaza {

	public SituatieMaterieCuTeza(Materie materie) {
		super(materie);
	}

	private int notaTeza1;
	private int notaTeza2;

	@Override
	protected double calculeazaMediaSem1() {
		return (super.calculeazaMediaSem1() * 3 + notaTeza1) / 4;
	}

	@Override
	protected double calculeazaMediaSem2() {
		return (super.calculeazaMediaSem2() * 3 + notaTeza2) / 4;
	}

	public int getNotaTeza(int semestru) {
		if (semestru == 1)
			return notaTeza1;
		else
			return notaTeza2;
	}

	public void setNotaTeza(int notaTeza, int semestru) {
		if (semestru == 1)
			this.notaTeza1 = notaTeza;
		else
			this.notaTeza2 = notaTeza;
	}

	@Override
	public void adaugaNota(int semestru, int nota, boolean teza) {
		if (teza) {
			setNotaTeza(nota, semestru);
		} else
			super.adaugaNota(semestru, nota, false);
	}

	@Override
	public String toString() {
		return "Note sem1: " + getNoteSem1().toString() + "\nTeza sem1: "
				+ notaTeza1 + "\nNote sem2:" + getNoteSem2().toString()
				+ "Teza sem2: " + notaTeza2 + "\nMedia: " + getMedie()
				+ "\nAbsente:" + getAbsente().toString() + "\n";
	}
}
