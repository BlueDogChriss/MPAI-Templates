package clase.common;

import clase.builder.Materie;
import clase.visitor.Visitor;

public class ProfesorScoala extends Profesor {

	public ProfesorScoala(String nume, String prenume, Materie materie) {
		super(nume, prenume, materie);
	}
	
	public ProfesorScoala(String nume, String prenume) {
		super(nume, prenume);
	}

	public ProfesorScoala() {
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitProfesorScoala();
	}

}
