package dbSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnectSample02 {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// Read the class of driver in java.
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Connection with DB
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/world?useSSL=false&allowPublicKeyRetrieval=true",
	                "root",
	                "sqabara789@Quark"
	        );
			
			// Create the window to connect with DB
			stmt = con.createStatement();
			
			// SQL execution
			String sql = "SELECT * FROM country LIMIT 50";
			rs = stmt.executeQuery(sql);
			
			// Display the result
            while( rs.next() ){
                // Get name
                String name = rs.getString("Name");
                int population = rs.getInt("Population");
                // Display name
                System.out.println(name+" Population : "+population);
            }
            
            // Update data
            sql = "update country set Population = 105000 where Code = 'ABW'";
            int count = stmt.executeUpdate(sql);
            System.out.println(count);
			
		} catch (ClassNotFoundException e) {
			System.err.println("JDBCドライバーのロードに失敗しました。");
			e.printStackTrace();
			
		} catch (SQLException e) {
			System.err.println("データベースに異常があります");
			e.printStackTrace();
		} finally {
			// close resultSet
            if( rs != null ){
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.err.println("ResultSetを閉じるときにエラーが発生しました。");
                    e.printStackTrace();
                }
            }
			// close statement
			if( stmt != null ){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("Statementを閉じるときにエラーが発生しました。");
                    e.printStackTrace();
            	}
			}
						
			//close connection
			if(con != null) {
				try {
	                con.close();
	            } catch (SQLException e) {
	                System.err.println("データベース切断時にエラーが発生しました。");
	                e.printStackTrace();
	            }
			}
			
			
		}
	}

}
