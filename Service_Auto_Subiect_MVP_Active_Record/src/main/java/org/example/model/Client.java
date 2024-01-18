package org.example.model;

import org.example.model.observer.Observer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client implements Observer {
    private int id;
    private String nume;

    public Client() {
    }

    public Client(int id, String nume) {
        this.id = id;
        this.nume = nume;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("id=").append(id);
        sb.append(", nume='").append(nume).append('\'');
        sb.append('}');
        return sb.toString();
    }


    @Override
    public void primesteNotificare(String mesaj) {
        System.out.println("Clientul " + this.nume + " a fost notificat ca: " + mesaj);
    }

    public List<Client> citireClienti() {
        List<Client> clients = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("clienti.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            while (Objects.nonNull(line)) {
                String[] lineElements = line.split(";");
                if (lineElements.length == 2) {
                    int id = Integer.parseInt(lineElements[0]);
                    String nume = lineElements[1];
                    Client client = new Client(id, nume);
                    clients.add(client);
                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return clients;
    }

    public void scriereClienti(List<Client> clienti){

        File file = new File("clienti.txt");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Client client : clienti){
                bufferedWriter.write(client.getId()+";"+client.getNume()+"\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
