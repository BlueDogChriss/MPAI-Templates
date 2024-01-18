package model;

import model.StariSolicitare.EchipajPlecatSpreClient;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Angajat extends ManagerDeNotificari{

    private int idAngajat;
    private String numeAmgajat;
    ArrayList<Client> clients ;
   ArrayList<Solicitare> solicitari;

    public Angajat(int idAngajat, String numeAmgajat, ArrayList<Client> clients, ArrayList<Solicitare> solicitari) {
        this.idAngajat = idAngajat;
        this.numeAmgajat = numeAmgajat;
        this.clients = clients;
        this.solicitari = solicitari;
    }

    public int getIdAngajat() {
        return idAngajat;
    }

    public void setIdAngajat(int idAngajat) {
        this.idAngajat = idAngajat;
    }

    public String getNumeAmgajat() {
        return numeAmgajat;
    }

    public void setNumeAmgajat(String numeAmgajat) {
        this.numeAmgajat = numeAmgajat;
    }



    public ArrayList<Solicitare> getSolicitari() {
        return solicitari;
    }

    public void setSolicitari(ArrayList<Solicitare> solicitari) {
        this.solicitari = solicitari;
    }

    public Angajat() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Angajat{");
        sb.append("idAngajat=").append(idAngajat);
        sb.append(", numeAmgajat='").append(numeAmgajat).append('\'');
        sb.append(", clients=").append(clients);
        sb.append(", solicitari=").append(solicitari);
        sb.append('}');
        return sb.toString();
    }

    public void incepeDeplasarea(){
        for(Solicitare solicitare : solicitari){
        if(solicitare.getEsteUrgenta()) {
            solicitare.setStare(new EchipajPlecatSpreClient());

        }
    }

//        public void scriereInTxt(BufferedWriter out) throws IOException {
//            out.write("Numar reclamatie - ");
//            out.write(Integer.toString(this.numar));
//            out.write("----------------------------");
//            out.write(stare.schimbaStare());
//            out.newLine();
//            out.write("Descriere - ");
//            out.write(this.descriere);
//            out.newLine();
//            out.write("Comanda - ");
//            out.write(Integer.toString(this.comanda.getNumar()));
//            out.write(" - ");
//            out.write(this.comanda.getNumeClient());
//            out.newLine();
//            out.newLine();
//        }

    }




}
