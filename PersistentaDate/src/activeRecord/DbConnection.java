package activeRecord;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class DBConnection {

    private static String url = "jdbc:sqlite:mpai;create=true";

    private static Connection connection;
    private static Statement statement;

    static {
        try {
            Class.forName("org.sqlite.JDBC");
            connection= DriverManager.getConnection(url);
            statement = connection.createStatement();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return connection;
    }

    public static void creareTabel() throws SQLException {
        statement.executeUpdate("CREATE TABLE angajati(id int primary key, nume varchar(50), vechime int, salariu double)");
        System.out.println("Tabela angajati a fost creata");
    }

    public static void stergeTabel() throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS angajati");
        System.out.println("Tabela angajati a fost stearsa");
    }


    public static void close() throws SQLException {
        statement.close();
        connection.close();
        System.out.println("Conexiunea la baza de date s-a inchis");
    }

}
