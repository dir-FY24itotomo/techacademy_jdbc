package dbSample.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
	public static Connection con;
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		// 1. Read driver of class in Java
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2. DBと接続する
        con = DriverManager.getConnection(
            "jdbc:mysql://localhost/world?useSSL=false&allowPublicKeyRetrieval=true",
            "root",
            "sqabara789@Quark"
        );
		return con;
	}
	
	public static void close() {
		if(con!=null) {
			try {
				con.close();
;			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
