package org.example.model;

import org.example.model.observer.Observer;
import org.example.model.observer.Subject;
import org.example.model.state.StareEchipaPlecata;
import org.example.model.state.StareSolicitare;
import org.example.model.state.StareSolicitareAcceptata;
import org.example.model.state.StareSolicitareTransmisa;

import java.util.ArrayList;
import java.util.List;

public class Solicitare implements Subject {

    private int id;
    private List<Observer> observers;
    private StareSolicitare stareSolicitare;
    private String locatieDesfasurare;

    public Solicitare() {
        observers = new ArrayList<>();
    }

    public Solicitare(int id, List<Observer> observers, StareSolicitare stareSolicitare, String locatieDesfasurare) {
        this.id = id;
        this.observers = observers;
        this.stareSolicitare = stareSolicitare;
        this.locatieDesfasurare = locatieDesfasurare;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    public StareSolicitare getStareSolicitare() {
        return stareSolicitare;
    }

    public void setStareSolicitare(EStareSolicitare eStareSolicitare) {
        switch (eStareSolicitare) {
            case SOLICITARE_ACCEPTATA:
                this.stareSolicitare = new StareSolicitareAcceptata();
                break;
            case SOLICITARE_TRANSMISA:
                this.stareSolicitare = new StareSolicitareTransmisa();
                break;
            case ECHIPA_PLECATA:
                this.stareSolicitare = new StareEchipaPlecata();
                break;
        }

        this.trimiteNotificare("Starea solicitarii s-a updatat in " + this.getStareSolicitare().getStare().getTip());
    }

    public String getLocatieDesfasurare() {
        return locatieDesfasurare;
    }

    public void setLocatieDesfasurare(String locatieDesfasurare) {
        this.locatieDesfasurare = locatieDesfasurare;
    }


    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void trimiteNotificare(String mesaj) {
        for (Observer observer : observers) {
            observer.primesteNotificare(mesaj);
        }
    }
}
