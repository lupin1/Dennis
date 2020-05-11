import java.sql.SQLException;


import database.SqliteConn;


public class Main{
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
			
		SqliteConn sqlite = new SqliteConn();
		sqlite.setupTables();
			
		sqlite.close();
	}
}