import java.sql.SQLException;

import Utilidades.DBUtilidades;



public class MainJDBC1 {

	public static void main(String[] args) {
		String dbName = "docendia";
		try {
			DBUtilidades.createMSAccessConnection(dbName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
