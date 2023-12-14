package com.servlet.servlet2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");


        // Hello
        PrintWriter out = response.getWriter();

        if(request.getParameter("java")==null){

            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            String status = "Please_select_one";
            request.setAttribute("status",status);
            rd.include(request,response);
        }
        else {
           RequestDispatcher rd = request.getRequestDispatcher("myServlet");
           String status = "Successfull";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("success");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                // Handle the exception (e.g., log an error or throw a runtime exception)
            }

            insertDataIntoDatabase(request.getParameter("userMail"),request.getParameter("java"));

           request.setAttribute("status",status);
           rd.forward(request,response);
        }
    }

    private void insertDataIntoDatabase(String email, String slct) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/user";
        String username = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            String sql = "INSERT INTO user (email, slct) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                System.out.println("what the hell");
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, slct);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database connection or insertion error
        }
    }
    @Override
    public void destroy() {
        super.destroy();
    }
}
