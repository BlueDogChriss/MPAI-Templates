package Model.ComandaActiveRecord;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Model.Comanda;

public class ComandaActiveRecord extends Comanda {

	private static final long serialVersionUID = 8512226770714132386L;

	public Comanda get(int idComanda) {
		try {
			Comanda comanda = new Comanda();
			List<Comanda> comenzi = ComandaActiveRecord.citireFisier();

			for (Comanda c : comenzi) {
				if (c.getIdComanda() == idComanda) {
					comanda.setIdComanda(c.getIdComanda());
					comanda.setClient(c.getClient());
					comanda.setProduse(c.getProduse());
					comanda.setStare(c.getStare());
				}
			}
			if (comanda.getIdComanda() != idComanda) {
				System.out.println("Comanda nu a fost gasita in lista...");
			} else {
				System.out.println("Comanda este " + comanda.toString());
				return comanda;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<Comanda> getAll() {
		try {
			List<Comanda> comenzi = ComandaActiveRecord.citireFisier();
			int count = comenzi.size();
			System.out.println("Numarul de comenzi inregistrate este: " + count);
			System.out.println("Comenzile sunt: " + comenzi.toString());
			return comenzi;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void save(Comanda comanda) {
		try {
			List<Comanda> comenziFisier = new ArrayList<>();
			File fisierComenzi = new File(System.getProperty("user.dir"), "comenzi.txt");
			boolean exists = fisierComenzi.exists();

			if (exists == true) {
				comenziFisier = ComandaActiveRecord.citireFisier();
			} else {
				System.out.println("Nu exista fisierul. Fisierul este creat.");
			}
			int contor = 0;
			for (int i = 0; i < comenziFisier.size(); i++) {
				if (comenziFisier.get(i).getIdComanda() == comanda.getIdComanda()) {
					contor++;
				}
			}
			if (contor == 0) {
				comenziFisier.add(comanda);
				ComandaActiveRecord.scriereFisier(comenziFisier);
				System.out.println("Comanda cu id-ul " + comanda.getIdComanda() + " a fost salvata...");
			} else {
				System.out.println("Comanda cu id-ul " + comanda.getIdComanda() + " este deja existenta");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(int idComanda) {
		try {
			List<Comanda> comenzi ;
			File file = new File(System.getProperty("user.dir"), "comenzi.txt");
			boolean exists = file.exists();

			if (exists == true) {
				comenzi = ComandaActiveRecord.citireFisier();
				boolean verificare = false;
				for (Comanda comanda : comenzi) {
					if (comanda.getIdComanda() == idComanda) {
						comenzi.remove(comanda);
						verificare = true;
					}
				}
				if (verificare == true) {
					System.out.println("Comanda cu id-ul " + idComanda + " a fost stearsa");
				} else {
					System.out.println("Comanda cu id-ul " + idComanda + " nu exista...");
				}

				ComandaActiveRecord.scriereFisier(comenzi);
			} else {
				System.out.println("Fisierul nu exista...");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Comanda c) {
		try {
			List<Comanda> comenziFisier;
			File tempFile = new File(System.getProperty("user.dir"), "comenzi.txt");
			boolean exists = tempFile.exists();
			int contor = 0;
			if (exists == true) {
				comenziFisier = ComandaActiveRecord.citireFisier();

				for (Comanda comanda : comenziFisier) {
					if (comanda.getIdComanda() == c.getIdComanda()) {
						comanda.setIdComanda(c.getIdComanda());
						comanda.setClient(c.getClient());
						comanda.setProduse(c.getProduse());
						comanda.setStare(c.getStare());
						contor++;
					}
				}
				if (contor != 0) {
					System.out.println("Comanda a fost actualizata...");
				} else {
					System.out.println("Comanda nu exista...");
				}
				ComandaActiveRecord.scriereFisier(comenziFisier);
			} else {
				System.out.println("Fisierul nu exista...");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static List<Comanda> citireFisier() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("comenzi.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);

		@SuppressWarnings("unchecked")
		List<Comanda> clientiFisier = (List<Comanda>) ois.readObject();
		ois.close();
		return clientiFisier;
	}

	public static List<Comanda> scriereFisier(List<Comanda> clientiFisier) throws IOException {
		FileOutputStream fos = new FileOutputStream("comenzi.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(clientiFisier);
		oos.flush();
		oos.close();
		return clientiFisier;
	}
}
