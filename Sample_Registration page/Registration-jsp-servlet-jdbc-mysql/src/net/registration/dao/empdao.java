package net.registration.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.registration.model.emp;;

public class empdao {

 public int registerEmployee(emp employee) throws ClassNotFoundException {
	        String INSERT_USERS_SQL = "INSERT INTO employee" +
	            "  (id, first_name, last_name, user_name, pswd, address, contact) VALUES " +
	            " (?, ?, ?, ?, ?,?,?);";

	        int result = 0;

	Class.forName("com.mysql.jdbc.Driver");
try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?useSSL=false", "root", "Best@123");
//try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?autoReconnect=true&useSSL=false", "root", "Best@123");
	         
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	            preparedStatement.setInt(1, 1);
	            preparedStatement.setString(2, employee.getFirstName());
	            preparedStatement.setString(3, employee.getLastName());
	            preparedStatement.setString(4, employee.getUsername());
	            preparedStatement.setString(5, employee.getPassword());
	            preparedStatement.setString(6, employee.getAddress());
	            preparedStatement.setString(7, employee.getContact());

	            System.out.println(preparedStatement);
	           
	            result = preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	        
	            e.printStackTrace();
	        }
	        return result;
	    }

	    
	            
	        }
	    
	


