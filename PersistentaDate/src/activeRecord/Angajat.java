package activeRecord;

public class Angajat {
    int id;
    String nume;
    int vechime;
    double salariu;

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

    public int getVechime() {
        return vechime;
    }

    public void setVechime(int vechime) {
        this.vechime = vechime;
    }

    public double getSalariu() {
        return salariu;
    }

    public void setSalariu(double salariu) {
        this.salariu = salariu;
    }

    public Angajat(int id, String nume, int vechime, double salariu) {
        this.id = id;
        this.nume = nume;
        this.vechime = vechime;
        this.salariu = salariu;
    }

    public Angajat() {
    }

    @Override
    public String toString() {
        return "Angajat{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", vechime=" + vechime +
                ", salariu=" + salariu +
                '}';
    }
}
