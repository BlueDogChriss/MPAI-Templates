package program;

import java.sql.Connection;
import java.sql.SQLException;

import clase.common.Constants;
import clase.database.DBManagerSingleton;

public class CreateTables implements Constants {

	public static void main(String[] args) {
		createTables();
	}

	private static void createTables() {
		Connection connection = null;
		try {
			connection = DBManagerSingleton.getConnection();
			connection.setAutoCommit(false);
			
			String queryProfesori = "(code INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "nume TEXT, prenume TEXT, materia INTEGER)";
			DBManagerSingleton.createTable(connection, PROFESORI_SCOALA_TABLE, queryProfesori);
			DBManagerSingleton.createTable(connection, PROFESORI_LICEU_TABLE, queryProfesori);

			String queryElevi = "(code INTEGER PRIMARY KEY AUTOINCREMENT, " + "nume TEXT, prenume TEXT, clasa TEXT)";
			DBManagerSingleton.createTable(connection, ELEVI_SCOALA_TABLE, queryElevi);
			DBManagerSingleton.createTable(connection, ELEVI_LICEU_TABLE, queryElevi);

			String queryMaterie = "(code INTEGER PRIMARY KEY, "
					+ "denumire TEXT, dificultate TEXT, semestrul INTEGER, extracurriculara SHORT, examenFinal SHORT, continut TEXT)";
			DBManagerSingleton.createTable(connection, MATERIE_TABLE, queryMaterie);

			String queryMeditatie = "(code INTEGER PRIMARY KEY AUTOINCREMENT, " + "elev INTEGER, profesor INTEGER)";
			DBManagerSingleton.createTable(connection, MEDITATIE_TABLE, queryMeditatie);

			System.out.println("Baza de date creata cu succes");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			DBManagerSingleton.closeQuietly(connection);
		}
	}

}
