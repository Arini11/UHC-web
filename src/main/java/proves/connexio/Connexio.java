package proves.connexio;

import java.sql.*;

public class Connexio {
	
	public Connection connecta() {
        try {
        	String driver = "com.mysql.cj.jdbc.Driver";
   		 	String myUrl = "jdbc:mysql://localhost:3306/uhc";
   		 	String user = "arnau";
   		 	String passwd = "arnau";
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(myUrl,user,passwd);
        	return connection;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    return null;
	}
	
}
