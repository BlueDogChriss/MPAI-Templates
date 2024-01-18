package activeRecord;

import dataMapper.Angajat;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
//       try {
//            DBConnection.creareTabel();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }

        ActiveRecord activeRecord = new ActiveRecord(3,"Georgescu Ana",1,6000,DBConnection.getConnection());

        activeRecord.save();

        System.out.println(ActiveRecord.get(3));

        activeRecord.setSalariu(7000);
        activeRecord.setVechime(3);
        activeRecord.update();

        System.out.println(ActiveRecord.get(3));

        activeRecord.delete();
    }
}
