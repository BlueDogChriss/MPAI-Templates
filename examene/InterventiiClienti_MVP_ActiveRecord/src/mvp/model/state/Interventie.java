package mvp.model.state;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Interventie implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private Stare stare;
	private static final String fileName = "interventii.dat";
	
	public Interventie(int id) {
		super();
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setStare(Stare stare) {
		this.stare = stare;
	}
	
	@Override
	public String toString() {
		return "Interventie [id=" + id + ", stare=" + stare + "]";
	}

	public void acceptaSolicitare() {
		SolicitareAcceptata solicitareAcceptata = new SolicitareAcceptata();
		solicitareAcceptata.schimbaStare(this);
		this.updateInterventie();
	}
	
	public void transmiteSolicitare() {
		SolicitareTransmisa solicitareAcceptata = new SolicitareTransmisa();
		solicitareAcceptata.schimbaStare(this);
		this.updateInterventie();
	}
	
	public void trimiteEchipaSpreClient() {
		EchipaPlecataSpreClient solicitareAcceptata = new EchipaPlecataSpreClient();
		solicitareAcceptata.schimbaStare(this);
		this.updateInterventie();
	}
	
	public void addInterventie() {
		List<Interventie> comenzi = getInterventii();
		if(comenzi != null ) {
			comenzi.add(this);
		} else {
			comenzi = new ArrayList<>();
			comenzi.add(this);
		}
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
			out.writeObject(comenzi);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Interventie> getInterventii() {
		List<Interventie> comenzi = new ArrayList<>();
		try {
			File file = new File(fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
				comenzi.addAll((List<Interventie>) in.readObject());
				return comenzi;
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Interventie getInterventie(int id) {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
			@SuppressWarnings("unchecked")
			List<Interventie> comenzi = (List<Interventie>) in.readObject();
			for (Interventie comanda : comenzi) {
				if (comanda.getId() == id) {
					return comanda;
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateInterventie() {
		List<Interventie> comenzi = getInterventii();
		if (comenzi.size() != 0) {
			for (int i = 0; i < comenzi.size(); i++) {
				if (comenzi.get(i).getId() == this.getId()) {
					comenzi.set(i, this);
					break;
				}
			}
		} else {
			getInterventii();
		}
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
			out.writeObject(comenzi);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
