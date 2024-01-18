package clase.abstractfactory;

import clase.common.ElevScoala;
import clase.common.Profesor;
import clase.common.ProfesorScoala;

public class ScoalaFactory implements AbstractFactory {

	@Override
	public Elev createElev() {
		return new ElevScoala();
	}

	@Override
	public Profesor createProfesor() {
		return new ProfesorScoala();
	}

}
