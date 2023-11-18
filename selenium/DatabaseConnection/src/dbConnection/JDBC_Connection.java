package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBC_Connection {

	public static void main(String[] args) throws SQLException {
		
		//Connecting to mysql server
		String host = "localhost";
		String port = "3306";
		String databaseName = "QADBT";
		Connection connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + databaseName, "root", "Kanya@9134");
		//We are creating way to execute queries
		Statement st = connection.createStatement();
		
		ResultSet resultSet = st.executeQuery("select * from EmployeeInfo where name=\"sam\"");
		
		//This is mandatory as it will point out to the base index but this requires to move and come to the starting index
		resultSet.next();
		String name = resultSet.getString("name");
		System.out.println("name: " + name);
		
		System.out.println("age: " + resultSet.getInt("age"));
		
	}

}
