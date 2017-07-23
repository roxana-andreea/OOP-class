package liceu;

public class Materie {

	private String nume;
	private int nrOreSaptamana;
	private boolean teza;

	public Materie(String nume, int nrOreSaptamana, boolean areTeza) {
		this.nume = nume;
		this.nrOreSaptamana = nrOreSaptamana;
		this.teza = areTeza;
	}

	public Materie(String nume, int nrOreSaptamana) {
		this(nume, nrOreSaptamana, false);
	}

	public String getNume() {
		return nume;
	}

	@Override
	public String toString() {
		return "[" +nume + " " + nrOreSaptamana + " "
				+ (teza ? "are teza" : "nu are teza") + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Materie)) {
			return false;
		}
		Materie other = (Materie) o;
		if (other.nume.equals(nume) && other.nrOreSaptamana == nrOreSaptamana
				&& other.teza == teza)
			return true;
		return false;
	}

	@Override
	public int hashCode() {
		return (nume + nrOreSaptamana + teza).hashCode();
	}

	public void setTeza(boolean teza) {
		this.teza = teza;
	}

	public void setNrOre(int nrOre) {
		this.nrOreSaptamana = nrOre;
	}

	public boolean areTeza() {
		return teza;
	}
}
