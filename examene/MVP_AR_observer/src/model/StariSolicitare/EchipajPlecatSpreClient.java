package model.StariSolicitare;

import model.IStare;

public class EchipajPlecatSpreClient implements IStare {
    public int durata=10;

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    @Override
    public String schimbaStarea() {
        return "Echipajul a plecat spre solicitare si va ajunge la client in "+this.getDurata()+"minute";
    }
}
