package org.example;

import org.example.model.Client;
import org.example.model.EStareSolicitare;
import org.example.model.Solicitare;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        client.setId(1);
        client.setNume("Nume1");

        Solicitare solicitare = new Solicitare();
        solicitare.setId(1);
        solicitare.setLocatieDesfasurare("Bucuresti");
        solicitare.addObserver(client);

        solicitare.setStareSolicitare(EStareSolicitare.SOLICITARE_TRANSMISA);

        Client client2 = new Client();
        client2.setId(2);
        client2.setNume("Nume2");

        solicitare.addObserver(client2);

        solicitare.setStareSolicitare(EStareSolicitare.SOLICITARE_ACCEPTATA);

        solicitare.removeObserver(client);

        solicitare.setStareSolicitare(EStareSolicitare.ECHIPA_PLECATA);

        client.scriereClienti(Arrays.asList(client, client2));

        List<Client> clientiFromFisier = client.citireClienti();

        System.out.println(clientiFromFisier);
    }
}