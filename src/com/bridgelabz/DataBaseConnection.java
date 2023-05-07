package com.bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {

	public static Connection setup() throws ClassNotFoundException, SQLException {
		String jdbcURL = "jdbc:mysql://localhost:3306/addressbooksystem";
		String username = "root";
		String password = "Kalpana@2207";

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection(jdbcURL, username, password);
		System.out.println("Connection establish !");

		return con;
	}

	public static void retrieveEmployeePayrollData(Connection con) throws SQLException {
		String query = "select * from address_book";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			String rel = rs.getString("relationship");
			String add = rs.getString("address");
			String city = rs.getString("city");
			String state = rs.getString("state");
			String zip = rs.getString("zip");
			String phoneNumber = rs.getString("phone_number");
			String email = rs.getString("email");

			System.out.println(firstName + " " + lastName + " " + rel + " " + add + " " + city + " " + state + " " + zip
					+ " " + phoneNumber + " " + email);
		}
	}

	public static void updateContactInformation(Connection con) throws SQLException {
		String query = "update address_book Set first_name ='Milind' where id = 2 ";
		PreparedStatement ps = con.prepareStatement(query);
		int i = ps.executeUpdate();
		System.out.println("Data updated in " + i + " row affected ");
	}
	
	public static void retrieveNumberOfContactsByCity(Connection con) throws SQLException {
		String query = "select count(city) from address_book where city = 'jaipur' group by city";
		PreparedStatement ps = con.prepareStatement(query);
        int i = ps.executeUpdate();
		System.out.println("number of contacts belongs to jaipur is : " + i);
	}
	
	public static void addNewContacts(Connection con) throws SQLException {
		System.out.println("Inserting new Contact in addres_book table ");
		String query = "insert into address_book ('1','Ram charan','NA','Friend','Hyderabad','Hyderabad','TS','123446','0987654321','rc@gmail.com')";
		PreparedStatement ps = con.prepareStatement(query);
        int i = ps.executeUpdate();
        System.out.println("Data updated in " + i + " row affected ");
        
        
	}
}
