package model;

import model.Observer;

import java.util.ArrayList;

public abstract class ManagerDeNotificari {
private ArrayList<Observer> clients = new ArrayList<Observer>();

    public ManagerDeNotificari() {
        super();
        this.clients = new ArrayList<Observer>();
    }

    public ArrayList<Observer> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Observer> clients) {
        this.clients = clients;
    }

    public void adaugaAbonat(Observer abonatNou){

        clients.add(abonatNou);
    }

    public void trimiteNotificare(String notificate) {
        for (Observer client : clients) {
            client.vaPrimiNotificare(notificate);
        }
    }
}
