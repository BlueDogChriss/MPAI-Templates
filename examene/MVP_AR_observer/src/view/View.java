package view;

import model.Angajat;
import model.Client;
import model.Solicitare;
import model.StariSolicitare.Acceptat;
import model.StariSolicitare.InAnaliza;
import model.StariSolicitare.Respins;

import java.util.ArrayList;

public class View {
    public String optiuni;
    public String stareComanda;
    public ArrayList<Solicitare> Solicitari = new ArrayList<Solicitare>();
    public Client client = new Client();

    public View(){
        optiuni =" Bine ati venit !";
        optiuni += "\n";
        optiuni += "1 - Vezi solicitari";
        optiuni += "\n";
        optiuni += "2 - Filtreaza solicitare dupa ID";
        optiuni += "\n";
        optiuni += "3 - Schimba starea solicitarii ";
        optiuni += "\n";
        optiuni +=" 4 - Inchidere";
        optiuni += "\n";
        stareComanda = " Starile cpmeziilor sunt:";
        stareComanda+="\n";
        stareComanda +="1- Acceptata";
        stareComanda+="\n";
        stareComanda+="2- In Analiza";
        stareComanda+="\n";
        stareComanda+="3- Respinsa";
        stareComanda+="\n";
        stareComanda+="4- Echipaj ce a plecat spre client";
        stareComanda+="\n";

        Solicitare solicitare1 = new Solicitare(1, "Bucuresti", new Acceptat(), "Animal lovit de masina",true );
        Solicitare solicitare2 = new Solicitare(2, "Bucuresti", new Respins(), "Animal bolnav",false );
        Solicitare solicitare3 = new Solicitare(3, "Bucuresti", new InAnaliza(), "Animal bolnav",false );


        Client client1 = new Client(1, "Roberta", "Pisica");
        Client client2 = new Client(2, "Andreea", "Caine");
        Client client3 = new Client(3, "Mihaela", "Caine");

        ArrayList<Client> clients = new ArrayList<Client>();
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        ArrayList<Solicitare> solicitari = new ArrayList<Solicitare>();
        Solicitari.add(solicitare1);
        Solicitari.add(solicitare2);
        Solicitari.add(solicitare3);

        Angajat angajat = new Angajat(1, "Marian", clients, solicitari);

    }
}
