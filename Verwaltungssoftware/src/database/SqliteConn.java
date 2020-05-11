package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqliteConn{
	
public Connection conn ;
	
public void setupTables() throws SQLException, ClassNotFoundException {
		
		String[] tables = {
				
				"DROP TABLE IF EXISTS address",
				"DROP TABLE IF EXISTS contact",
				"DROP TABLE IF EXISTS customer",
				
				"DROP TABLE IF EXISTS company",				
				"DROP TABLE IF EXISTS company_contacts",
				"DROP TABLE IF EXISTS company_customers",
				

				
				"CREATE TABLE IF NOT EXISTS address( id INTEGER PRIMARY KEY, street TEXT, zip INTEGER )",
				"CREATE TABLE IF NOT EXISTS contact ( id INTEGER PRIMARY KEY, name TEXT, addressId INTEGER, phone TEXT, mail TEXT )",
				
				"CREATE TABLE IF NOT EXISTS customer( id INTEGER PRIMARY KEY, contactId INTEGER, customerNumber TEXT)",
				
				
				"CREATE TABLE IF NOT EXISTS company( id INTEGER PRIMARY KEY, contactId INTEGER )",
				"CREATE TABLE IF NOT EXISTS company_contacts( id INTEGER PRIMARY KEY, companyId INTEGER, contactId INTEGER )",
				"CREATE TABLE IF NOT EXISTS company_customers( id INTEGER PRIMARY KEY, companyId INTEGER, customerId INTEGER )"
				
				
		}; 
		

		this.connect();
		Statement stmt = conn.createStatement();
		
		
		for( String query : tables) {
			stmt.execute(query);
		}
		
		stmt.close();
		
		
		
	}
	
	
	public void connect()  throws ClassNotFoundException, SQLException{
		

		Class.forName( "org.sqlite.JDBC");

		conn = DriverManager.getConnection("jdbc:sqlite:adressen.db");
		
		System.out.println("Die Verbindung mit der Datenbank wurde erfolgreich hergestellt");
		
		
		
		
		
		
		
	}


	public void close() throws SQLException {
		this.conn.close();
		
	}
}