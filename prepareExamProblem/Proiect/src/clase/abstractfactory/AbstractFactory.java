package clase.abstractfactory;

import clase.common.Profesor;

public interface AbstractFactory {
	Elev createElev();
	Profesor createProfesor();
}
