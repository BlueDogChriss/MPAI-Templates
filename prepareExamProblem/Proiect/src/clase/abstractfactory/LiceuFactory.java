package clase.abstractfactory;

import clase.common.ElevLiceu;
import clase.common.Profesor;
import clase.common.ProfesorLiceu;

public class LiceuFactory implements AbstractFactory {

	@Override
	public Elev createElev() {
		return new ElevLiceu();
	}

	@Override
	public Profesor createProfesor() {
		return new ProfesorLiceu();
	}

}
