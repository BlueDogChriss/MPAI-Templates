package model;

import java.sql.SQLOutput;

public class Client implements Observer{

    private int idClient;
    private String numeClient;
    private String numeAnimal;

    public Client(int idClient, String numeClient, String numeAnimal) {
        this.idClient = idClient;
        this.numeClient = numeClient;
        this.numeAnimal = numeAnimal;
    }

    public Client() {
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNumeClient() {
        return numeClient;
    }

    public void setNumeClient(String numeClient) {
        this.numeClient = numeClient;
    }

    public String getNumeAnimal() {
        return numeAnimal;
    }

    public void setNumeAnimal(String numeAnimal) {
        this.numeAnimal = numeAnimal;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("idClient=").append(idClient);
        sb.append(", numeClient='").append(numeClient).append('\'');
        sb.append(", numeAnimal='").append(numeAnimal).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void vaPrimiNotificare(String notificare) {
        System.out.println("Clientul" + numeClient+ "a primit notificare!");
    }
}
