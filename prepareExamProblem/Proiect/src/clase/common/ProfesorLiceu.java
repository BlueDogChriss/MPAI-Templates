package clase.common;

import clase.builder.Materie;
import clase.visitor.Visitor;

public class ProfesorLiceu extends Profesor {

	public ProfesorLiceu(String nume, String prenume, Materie materie) {
		super(nume, prenume, materie);
	}
	
	public ProfesorLiceu(String nume, String prenume) {
		super(nume, prenume);
	}

	public ProfesorLiceu() {
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitProfesorLiceu();
	}

}
