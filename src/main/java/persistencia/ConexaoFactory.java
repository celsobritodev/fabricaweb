package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	public static Connection getConnection() {
		String  driver ="com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/fabricaweb?useTimeZone=true&serverTimezone=UTC";
	    String user ="root";
		String password ="admin";
	
		
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			return con;
		} catch (SQLException e) {

			System.out.println(e);
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	
}
