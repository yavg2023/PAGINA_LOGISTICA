package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClassConex {

    private static ClassConex conOracle;
    private static Connection conn;

    private ClassConex() {
    }

    public static ClassConex getInstance() {
        if (conOracle == null) {
            conOracle = new ClassConex();
        }
        return conOracle;
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (conn == null || conn.isClosed()) {
            Class.forName("oracle.jdbc.OracleDriver");
            String url = "jdbc:oracle:thin:@MAXIMO-PC:1521:xe"; // Ajusta según tu configuración de Oracle
            conn = DriverManager.getConnection(url, "system", "villamil2002"); // Cambia usuario y contraseña según tu configuración
        }
        return conn;
    }

    public static void closeConnection() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    public static boolean testConnection() {
        try {
            getConnection().close();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
