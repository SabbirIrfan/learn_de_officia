package com.servlet.servlet2;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class connectDatabase {
    final static String jdbcUrl = "jdbc:mysql://localhost:3306/regiForm";
    final static String username = "root";

    public static void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("success in connecting database");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Handle the exception (e.g., log an error or throw a runtime exception)
        }

    }
    public static void insertDataIntoDatabase(String name, String email, String pass, String address) {
        connectDatabase.connect();

        String jdbcUrl = connectDatabase.getJdbcUrl();
        String username = connectDatabase.getUsername();
        String password = connectDatabase.getPassword();

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            String sql = "INSERT INTO devUser (name,email,password,address) VALUES (?,?,?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                System.out.println("what the hell insert");
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, email);
                preparedStatement.setString(3, pass);
                preparedStatement.setString(4, address);


                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database connection or insertion error
        }
    }
    public static boolean updateDataInDatabase(String email, String userName,String address) {
        connectDatabase.connect();

        String jdbcUrl = connectDatabase.getJdbcUrl();
        String username = connectDatabase.getUsername();
        String password = connectDatabase.getPassword();

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println(email +"email is good?");
            String sql = "UPDATE devUser SET name = ? , address = ? WHERE email = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                System.out.println("what the hell in update");
                preparedStatement.setString(1, userName);
                preparedStatement.setString(2, address);
                preparedStatement.setString(3, email );


               int rowsAffected =  preparedStatement.executeUpdate();
               if(rowsAffected>0){
                   System.out.println("update success");
                   return true;
               }
               else {
                   System.out.println("update failed");
                   return  false;
               }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database connection or insertion error
        }

        return false;
    }
    public static HashMap<String,String> getUser(String email) {
        connect();
        HashMap<String,String> user = new HashMap<>();

        // Database connection details
        String jdbcUrl = connectDatabase.getJdbcUrl();
        String username = connectDatabase.getUsername();
        String password =  connectDatabase.getPassword();


            try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
                String sql = "SELECT * FROM devUser where email = ?";

                System.out.println(email);
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                    // Set the parameter for the username you want to retrieve
                    preparedStatement.setString(1, email);

                    // Execute the query
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            // Retrieve user data from the result set
                            String name = resultSet.getString("name");
                            String address = resultSet.getString("address");
                            // Add more fields as needed
                            user.put("name",name);
                            user.put("address", address);
                            // Process the user data as needed
                            System.out.println("Username: " + name);
                            System.out.println("address: " + address);
                            // Print or process other fields
                        } else {
                            System.out.println("User not found");
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("in here1");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        return user;
    }



    public static String getJdbcUrl() {
        return jdbcUrl;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        String password = "";
        return password;
    }
}
