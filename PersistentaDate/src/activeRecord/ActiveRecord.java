package activeRecord;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ActiveRecord extends Angajat {

    Connection connection;

    public ActiveRecord(Connection connection) {
        super();
        this.connection = connection;
    }

    public ActiveRecord(int id, String nume, int vechime, double salariu, Connection connection) {
        super(id, nume, vechime, salariu);
        this.connection = connection;
    }

    public void save(){
        try {
            Statement statement = connection.createStatement();
            StringBuilder stringBuilder = new StringBuilder("INSERT INTO angajati VALUES(");
            stringBuilder.append(getId()).append(",")
                    .append("'").append(getNume()).append("',")
                    .append(getVechime()).append(",")
                    .append(getSalariu()).append(")");

            statement.executeUpdate(stringBuilder.toString());
            System.out.println("Datale au fost adaugate in tabela clienti");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(){
        try {
            Statement statement = connection.createStatement();
            StringBuilder stringBuilder = new StringBuilder("UPDATE ANGAJATI SET ");
            stringBuilder.append("nume = '").append(getNume()).append("',")
                         .append("vechime =").append(getVechime()).append(",")
                         .append("salariu = ").append(getSalariu()).append(" WHERE ID = ").append(getId());
            statement.executeUpdate(stringBuilder.toString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Angajatul a fost updatat");

    }

    public void delete(){
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM ANGAJATI WHERE ID = " + getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Angajatul a fost sters");
    }

    public static Angajat get(int id){
        Angajat angajat = null;
        try {
            Statement statement = DBConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ANGAJATI WHERE ID = " + id);

            while (resultSet.next()){
                angajat = new Angajat(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getDouble(4));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return angajat;
    }
}
