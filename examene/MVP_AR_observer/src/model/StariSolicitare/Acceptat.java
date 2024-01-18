package model.StariSolicitare;

import model.IStare;

public class Acceptat implements IStare {
    @Override
    public String schimbaStarea() {
        return "Acceptata";
    }
}
