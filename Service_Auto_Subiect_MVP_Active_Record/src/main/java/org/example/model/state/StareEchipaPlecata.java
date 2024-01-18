package org.example.model.state;

import org.example.model.EStareSolicitare;

public class StareEchipaPlecata implements StareSolicitare{

    @Override
    public EStareSolicitare getStare() {
        return EStareSolicitare.ECHIPA_PLECATA;
    }
}
