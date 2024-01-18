package org.example.model;

import java.util.Arrays;

public enum EStareSolicitare {

    SOLICITARE_TRANSMISA("solicitare_transmisa"),
    SOLICITARE_ACCEPTATA("solicitare_acceptata"),
    ECHIPA_PLECATA("echipa_plecata");

    private String tip;

    EStareSolicitare(String tip) {
        this.tip = tip;
    }

    public String getTip() {
        return tip;
    }

    public EStareSolicitare getSolicitareFromTip(String tip) {
        return Arrays.stream(EStareSolicitare.values()).filter(value -> value.getTip().equalsIgnoreCase(tip)).findFirst().orElse(null);
    }
}
