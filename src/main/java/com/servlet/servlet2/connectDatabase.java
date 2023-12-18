package com.servlet.servlet2;

import java.sql.*;
import java.util.ArrayList;
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
    public static void updateDataInDatabase(String email, String userName) {
        connectDatabase.connect();

        String jdbcUrl = connectDatabase.getJdbcUrl();
        String username = connectDatabase.getUsername();
        String password = connectDatabase.getPassword();

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println(email +"email is good?");
            String sql = "UPDATE devUser SET name = ? WHERE email = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                System.out.println("what the hell in update");
                preparedStatement.setString(1, userName);
                preparedStatement.setString(2, email);


                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database connection or insertion error
        }
    }
    public static List<String> getUsers() {
        List<String> userList = new ArrayList<>();

        // Database connection details
        String jdbcUrl = connectDatabase.getJdbcUrl();
        String username = connectDatabase.getUsername();
        String password =  connectDatabase.getPassword();

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            // SQL query to retrieve user data
            String sql = "SELECT email FROM devUser";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                // Process the result set
                while (resultSet.next()) {
                    String email = resultSet.getString("email");

                    // Create User object and add it to the ArrayList

                    userList.add(email);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database connection or query error
        }

        return userList;
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
