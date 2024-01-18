package model;

import model.StariSolicitare.Acceptat;
import model.StariSolicitare.EchipajPlecatSpreClient;
import model.StariSolicitare.InAnaliza;
import model.StariSolicitare.Respins;

import java.io.BufferedWriter;
import java.io.IOException;

public class Solicitare {
    private int id;
    private String adresa;
    private IStare stare;
    private String descriere;
    private boolean esteUrgenta;

    public Solicitare(int id, String adresa, IStare stare, String descriere, boolean esteUrgenta) {
        this.id = id;
        this.adresa = adresa;
        this.stare = stare;
        this.descriere = descriere;
        this.esteUrgenta = esteUrgenta;
    }

    public Solicitare() {
    }

    public IStare getStare() {
        return stare;
    }

    public void setStare(IStare stare) {
        this.stare = stare;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public boolean getEsteUrgenta() {
        return esteUrgenta;
    }

    public void setEsteUrgenta(boolean esteUrgenta) {
        this.esteUrgenta = esteUrgenta;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Solicitare{");
        sb.append("id=").append(id);
        sb.append(", adresa='").append(adresa).append('\'');
        sb.append(", stare=").append(stare.schimbaStarea());
        sb.append(", descriere='").append(descriere).append('\'');
        sb.append(", esteUrgenta=").append(esteUrgenta);
        sb.append('}');
        return sb.toString();
    }

    public void solicitareAcceptata() {
        stare = new Acceptat();
        stare.schimbaStarea();

    }

    public void solicitareRespinsa() {

            stare = new Respins();
            stare.schimbaStarea();


    }

    public void solicitareInAnaliza() {

            stare = new InAnaliza();
            stare.schimbaStarea();

    }

    public void solicitareVineEchipaj() {

        stare = new EchipajPlecatSpreClient();
        stare.schimbaStarea();

    }
    public void saveObiect(BufferedWriter bw) throws IOException {
        bw.write("Numar solicitare - ");
        bw.write(Integer.toString(this.id));
        bw.write("----------------------------");
        bw.write(stare.schimbaStarea());
        bw.newLine();
        bw.write("Descriere - ");
        bw.write(this.descriere);
        bw.newLine();

        bw.newLine();
    }

}
