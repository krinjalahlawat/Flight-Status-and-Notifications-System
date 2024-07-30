package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Flight;

public class FlightDAO {
	 private static final String URL = "jdbc:mysql://localhost:3306/flight_status_db";
	    private static final String USER = "root";
	    private static final String PASSWORD = "12345";

    public List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<>();

        try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			String query = "SELECT flight_number, status, gate FROM flights";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String flightNumber = resultSet.getString("flight_number");
				String status = resultSet.getString("status");
				String gate = resultSet.getString("gate");
				flights.add(new Flight(flightNumber, status, gate));
			}
		} 
        catch (ClassNotFoundException e) {
	        e.printStackTrace();
	       // System.out.println("JDBC Driver not found.");
	    } 
		catch (SQLException e) {
			e.printStackTrace();
			//System.out.println("SQL error: " + e.getMessage());
		}

		return flights;
    }
}
