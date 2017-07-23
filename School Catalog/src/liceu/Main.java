package liceu;

import liceu.IProfesor.Criteriu;
import liceu.SituatieMaterieBaza.Absenta.STATUS;

public class Main {

	public static void main(String[] args) {
		Centralizator c = Centralizator.getInstance();
		System.out.println(c.getLoggedInUser());
		Utilizator u = c.login("admin", "admin");
		Administrator a = (Administrator) u;
		System.out.println(c.getLoggedInUser());
		a.createUser("ppop", "stud", "Popescu", "Ion", "Elev", "1921111123456");
		a.createUser("proxana", "stud", "Popescu", "Roxana", "Elev",
				"2931111123456");

		System.out.println(c.getUsers());

		Secretar s = (Secretar) c.login("iion", "sec2");

		Clasa clasa = s.adaugaClasa("12A");

		s.adaugaElev("Popescu", "Roxana", "12A");
		s.adaugaElev("Marin", "Daniel", "12A");
		s.adaugaElev("Ionescu", "Andreea", "12A");
		s.adaugaMaterieLaClasa("Matematica", "12A");
		Profesor p = (Profesor) c.login("rconstantin", "1234");

		Elev elev = clasa.getElevi().get(0);
		p.alegeClasa("12A");
		p.adaugaNota(elev, 1, 10);
		p.adaugaNota(elev, 1, 8);
		p.adaugaNota(elev, 1, 7);
		p.adaugaNota(elev, 2, 10);
		p.adaugaNota(elev, 1, 5, true);
		p.adaugaNota(elev, 2, 10, true);
		p.adaugaAbsenta(elev, "11/12/2004");
		p.adaugaAbsenta(elev, "14/12/2004");
		p.modifcaAbsenta(elev, "11/12/2004", STATUS.NEMOTIVATA);
		p.calculeazaMedie(elev);
		
		
		elev = clasa.getElevi().get(1);
		p.adaugaNota(elev, 1, 10);
		p.adaugaNota(elev, 2, 8);
		p.calculeazaMedie(elev);


		

		System.out.println(elev.situatieScolara());
		System.out.println(s.modificaClasa("12A").toString());

		elev = clasa.getElevi().get(2);
		p.adaugaAbsenta(elev, "1/1/2003");
		
		p.ordonareStudenti("12A", Criteriu.ALFABETIC);
		p.listareStudenti("12A");
		
		
		c.writeUsers();
	}
}
