package org.example.model.state;

import org.example.model.EStareSolicitare;

public class StareSolicitareAcceptata implements StareSolicitare{

    @Override
    public EStareSolicitare getStare() {
        return EStareSolicitare.SOLICITARE_ACCEPTATA;
    }
}
