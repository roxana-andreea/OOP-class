package liceu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Centralizator {

	
	
	private static final String USER_FILE = "Utilizatori";
	private static final String SUBJECTS_FILE = "Materii";

	private List<Utilizator> utilizatori;
	private List<Clasa> clase;

	private Map<Materie, Map<Clasa, Profesor>> materii;

	private Utilizator loggedInUser = null;

	public static Centralizator getInstance() {
		return instance;
	}

	private static final Centralizator instance = new Centralizator();

	public Utilizator getLoggedInUser() {
		return loggedInUser;
	}

	private Centralizator() {
		utilizatori = new ArrayList<>();
		clase = new ArrayList<>();
		materii = new HashMap<>();
		readSubjects();
		readUsers();
		// for (int i = 0; i < utilizatori.size(); i++) {
		// Utilizator u = utilizatori.get(i);
		// if (u instanceof Elev)
		// System.out.println(((Elev) u).getDataNasterii());
		// }
	}

	public List<Utilizator> getUtilizatori() {
		return utilizatori;
	}

	public List<Clasa> getClase() {
		return clase;
	}

	public Map<Materie, Map<Clasa, Profesor>> getMaterii() {
		return materii;
	}

	@Override
	public String toString() {
		return "Centralizator: " + clase.toString();
	}

	private void readSubjects() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(SUBJECTS_FILE));
			String s = null;
			while ((s = br.readLine()) != null) {
				String[] params = s.split(" ");
				if (params.length == 3)
					materii.put(
							new Materie(params[0], Integer.parseInt(params[1]),
									Boolean.parseBoolean(params[2])),
							new HashMap<Clasa, Profesor>());
				else if (params.length == 2) {
					materii.put(
							new Materie(params[0], Integer.parseInt(params[1])),
							new HashMap<Clasa, Profesor>());
				} else {
					System.err.println("Materie invalida");
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("Fisier inexistent");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Eroare citire din fisier");
			e.printStackTrace();
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					System.err.println("Eroare inchidere fisier");
					e.printStackTrace();
				}
		}

	}

	private void readUsers() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(USER_FILE));
			String s = null;
			while ((s = br.readLine()) != null) {
				String[] params = s.split(" ");
				if (params.length < 5) {
					System.err.println("Invalid user line");
					continue;
				}
				Utilizator u = null;
				switch (params[0]) {
				case "Administrator":
					u = new Administrator(params[1], params[2], params[3],
							params[4], utilizatori, materii, clase);
					break;
				case "Elev":
					u = new Elev(params[1], params[2], params[3], params[4],
							params[5]);
					break;
				case "Secretar":
					u = new Secretar(params[1], params[2], params[3],
							params[4], utilizatori, materii, clase);
					break;
				case "Profesor":
					String numeMaterie = params[5];
					for (Materie m : materii.keySet()) {
						if (m.getNume().equals(numeMaterie)) {
							u = new Profesor(params[1], params[2], params[3],
									params[4], m, materii, clase);
							break;
						}
					}
					break;
				default:
					System.err.println("Invalid user line");
					continue;
				}
				utilizatori.add(u);
			}

		} catch (FileNotFoundException e) {
			System.err.println("Fisier inexistent");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Eroare citire din fisier");
			e.printStackTrace();
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					System.err.println("Eroare inchidere fisier");
					e.printStackTrace();
				}
		}
	}

	public void writeUsers() {
		FileWriter fw = null;
		try {
			fw = new FileWriter(USER_FILE);
			for (Utilizator u : utilizatori) {
				fw.write(u.toString() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fw != null)
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}

	public void writeSubjects() {
		FileWriter fw = null;
		try {
			fw = new FileWriter(SUBJECTS_FILE);
			for (Materie m : materii.keySet()) {
				fw.write(m.toString() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fw != null)
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	public Utilizator login(String username, String password) {
		loggedInUser = null;
		for (Utilizator u : utilizatori)
			if (u.getUsername().equals(username) && u.hasPassword(password)) {
				loggedInUser = u;
				break;
			}
		if (loggedInUser == null) {
			System.err.println("Username/parola invalide");
		}
		return loggedInUser;
	}

	public Map<Materie, Map<Clasa, Profesor>> getSubjects() {
		return materii;
	}

	public List<Utilizator> getUsers() {
		return utilizatori;
	}
}
