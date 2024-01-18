package clase.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JComboBox;

import clase.abstractfactory.Elev;
import clase.builder.DenumireMaterie;
import clase.builder.Materie;
import clase.builder.NivelDificultate;
import clase.common.Constants;
import clase.common.ElevLiceu;
import clase.common.Profesor;
import clase.common.ProfesorLiceu;
import clase.common.ProfesorScoala;
import gui.ProfesorInregistrareDialog;

public class DBManagerSingleton implements Constants {

	private static DBManagerSingleton connection;

	private DBManagerSingleton() {

	}

	public static synchronized DBManagerSingleton getInstance() {
		if (connection == null) {
			connection = new DBManagerSingleton();
		}
		return connection;
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Class.forName("org.sqlite.JDBC");
		connection = DriverManager.getConnection("jdbc:sqlite:database.db");
		return connection;
	}

	public static void closeQuietly(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void closeQuietly(PreparedStatement pStatement) {
		try {
			pStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void closeQuietly(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void createTable(Connection connection, String tableName, String query) throws SQLException {
		String sqlDrop = "DROP TABLE IF EXISTS  " + tableName;
		String sqlCreate = "CREATE TABLE " + tableName + query;

		Statement statement = connection.createStatement();
		statement.executeUpdate(sqlDrop);
		statement.executeUpdate(sqlCreate);
		statement.close();
		connection.commit();
	}

	public static void insertElev(String tableName, Elev elev) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			String sql = "INSERT INTO " + tableName + "(nume, prenume, clasa) VALUES(?,?,?)";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, elev.getNume());
			pStatement.setString(2, elev.getPrenume());
			pStatement.setString(3, elev.getClasa());

			pStatement.executeUpdate();
			connection.commit();

			if (elev instanceof ElevLiceu) {
				System.out.println("Elev Liceu inserat cu succes in baza de date!");
			} else {
				System.out.println("Elev scoala inserat cu succes in baza de date!");
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeQuietly(connection);
			closeQuietly(pStatement);
		}
	}

	private static Materie getMaterie(int code) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection connection = null;
		Materie materie = null;
		try {
			connection = getConnection();
			String sql = "SELECT * FROM " + MATERIE_TABLE + " where code = " + code;
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				DenumireMaterie denumireMaterie = DenumireMaterie.valueOf(rs.getString("denumire"));
				NivelDificultate nivelDificultate = NivelDificultate.valueOf(rs.getString("dificultate"));
				int semestru = rs.getInt("semestrul");
				boolean isExtracurriculara = rs.getBoolean("extracurriculara");
				boolean isMaterieExamen = rs.getBoolean("examenFinal");
				String continut = rs.getString("continut");
				materie = ProfesorInregistrareDialog.createMaterie(denumireMaterie, nivelDificultate, semestru,
						isExtracurriculara, isMaterieExamen, continut);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			closeQuietly(connection);
			closeQuietly(ps);
			closeQuietly(rs);
		}
		return materie;
	}

	public static Vector<Profesor> getProfesori(boolean isElevLiceu) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection connection = null;
		Vector<Profesor> profesoriList = new Vector<>();
		try {
			connection = getConnection();
			String sql = "SELECT * FROM " + (isElevLiceu ? PROFESORI_LICEU_TABLE : PROFESORI_SCOALA_TABLE);
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String numeProfesorLiceu = rs.getString("nume");
				String prenumeProfesorLiceu = rs.getString("prenume");

				int code = rs.getInt("code");
				Materie materie = getMaterie(code);

				Profesor profesor = null;
				if (isElevLiceu) {
					profesor = new ProfesorLiceu(numeProfesorLiceu, prenumeProfesorLiceu, materie);
				} else {
					profesor = new ProfesorScoala(numeProfesorLiceu, prenumeProfesorLiceu, materie);
				}
				profesoriList.add(profesor);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			closeQuietly(connection);
			closeQuietly(ps);
			closeQuietly(rs);
		}
		return profesoriList;
	}

	public static int getCode(String sql) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection connection = null;
		int elevCode = 0;
		try {
			connection = getConnection();
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				elevCode = rs.getInt("code");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			closeQuietly(connection);
			closeQuietly(ps);
			closeQuietly(rs);
		}
		return elevCode;
	}

	public static void insertMeditatie(boolean isElevLiceu, Elev elev, JComboBox<Profesor> combobox) {
		PreparedStatement pStatement = null;
		Connection connection = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			String sql = "INSERT INTO " + MEDITATIE_TABLE + "(elev, profesor) VALUES(?,?)";
			pStatement = connection.prepareStatement(sql);

			String sqlElev = "SELECT code FROM " + (isElevLiceu ? ELEVI_LICEU_TABLE : ELEVI_SCOALA_TABLE)
					+ " where nume = '" + elev.getNume() + "' and prenume = '" + elev.getPrenume() + "' and clasa = '"
					+ elev.getClasa() + "'";
			int elevCode = getCode(sqlElev);
			Profesor profesor = combobox.getItemAt(combobox.getSelectedIndex());
			String sqlProfesor = "SELECT code FROM " + (isElevLiceu ? PROFESORI_LICEU_TABLE : PROFESORI_SCOALA_TABLE)
					+ " where nume = '" + profesor.getNume() + "' and prenume = '" + profesor.getPrenume() + "'";
			int profesorCode = getCode(sqlProfesor);

			pStatement.setInt(1, elevCode);
			pStatement.setInt(2, profesorCode);

			pStatement.executeUpdate();
			connection.commit();

			System.out.println("Meditatie inserata cu succes in baza de date!");

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			closeQuietly(connection);
			closeQuietly(pStatement);
		}
	}

	public static void insertProfesor(Profesor profesor, int primaryKey, String table) {
		PreparedStatement pStatement = null;
		Connection connection = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			String sql = "INSERT INTO " + table + "(nume, prenume, materia) VALUES(?,?,?)";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, profesor.getNume());
			pStatement.setString(2, profesor.getPrenume());
			pStatement.setInt(3, primaryKey);

			pStatement.executeUpdate();
			connection.commit();

			if (profesor instanceof ProfesorLiceu) {
				System.out.println("Profesor liceu inserat cu succes in baza de date!");
			} else {
				System.out.println("Profesor Scoala inserat cu succes in baza de date!");
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			closeQuietly(connection);
			closeQuietly(pStatement);
		}
	}

	public static void insertMaterie(Materie materie, int primaryKey) {
		PreparedStatement pStatement = null;
		Connection connection = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			String sql = "INSERT INTO " + MATERIE_TABLE
					+ "(code, denumire, dificultate, semestrul, extracurriculara, examenFinal, continut) VALUES(?,?,?,?,?,?,?)";
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, primaryKey);
			pStatement.setString(2, materie.getDenumireMaterie().name());
			pStatement.setString(3, materie.getNiveldificultate().name());
			pStatement.setInt(4, materie.getSemestrul());
			pStatement.setShort(5, (short) (materie.isEsteMaterieExtracurriculara() ? 1 : 0));
			pStatement.setShort(6, (short) (materie.isEsteMaterieExamenFinal() ? 1 : 0));
			pStatement.setString(7, materie.getContinut().toString());

			pStatement.executeUpdate();
			connection.commit();

			System.out.println("Materie inserata cu succes in baza de date!");

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			closeQuietly(connection);
			closeQuietly(pStatement);
		}
	}
	
	public static int getPrimaryKey() {
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection connection = null;
		try {
			connection = getConnection();
			ps = connection.prepareStatement("SELECT count(*) number FROM " + MATERIE_TABLE);
			rs = ps.executeQuery();

			while (rs.next()) {
				return rs.getInt("number") + 1;
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			closeQuietly(rs);
			closeQuietly(ps);
			closeQuietly(connection);
		}
		return 0;
	}

}
