package pgrdevelopers.strutscrud.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	public static Connection getDBConnection() {
		
	      Connection conn = null;

	      try {
	         String URL = "jdbc:mysql://127.0.0.1:****/usersdata";
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         conn = DriverManager.getConnection(URL, "root", "*****");
	      } catch (Exception e) {
	         System.out.println("Failed to connect to DB!");
	      }
	      return conn;
	}
	
	public static void closeDBConnection(Connection conn) {

		try {
            conn.close();
         } catch (Exception e) {
        	 System.out.println("Failed to close DB Connection!");
         	e.printStackTrace();
         }
	}

}
