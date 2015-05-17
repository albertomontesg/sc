package Utilidades;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtilidades {

	public static Connection createMSAccessConnection(String dbName) throws SQLException  {
        String myDB = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};"
                + "DBQ=" + dbName;
        Connection conn = DriverManager.getConnection(myDB, "", "");
        return conn;
    }
}
