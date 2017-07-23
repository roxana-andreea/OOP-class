package liceu;

import java.util.ArrayList;
import java.util.List;

public abstract class Utilizator {

	private String user;
	private String parola;
	private String nume;
	private String prenume;

	@Override
	public String toString() {
		return user + " " + parola + " " + nume + " " + prenume;
	}

	@Override
	public boolean equals(Object o){
		if(o.getClass().equals(this.getClass())){
			Utilizator u=(Utilizator)o;
			return u.nume.equals(nume) && u.prenume.equals(prenume) && u.user.equals(user);
		}
		return false;
	}

	public Utilizator(String user, String parola, String nume, String prenume) {
		this.nume = nume;
		this.prenume = prenume;
		this.parola = parola;
		this.user = user;
	}

	public String getUsername() {
		return user;
	}
	
	public String getParola() {
		return parola;
	}

	public boolean hasPassword(String password) {
		return parola.equals(password);
	}

	public List<String> getUserData() {
		List<String> list = new ArrayList<>();
		list.add(user);
		list.add(parola);
		list.add(nume);
		list.add(prenume);
		return list;
	}

	public String getNume() {
		return nume;
	}

	public String getPrenume() {
		return prenume;
	}
}
