package clase.strategy;

import clase.abstractfactory.Elev;

public class StrategieBonusTemeRezolvate implements InterfataStrategie {

	@Override
	public void aplicaStrategie(Elev elev) {
		if (elev.getTotalTemeRezolvate() > 7) {
			elev.setNotaTemeRezolvate(elev.getTotalTemeRezolvate() + 1);
			System.out.println("S-a aplicat strategia pentru bonusul temelor rezolvate");
		} else {
			elev.setNotaTemeRezolvate(elev.getTotalTemeRezolvate());
		}
	}

}
