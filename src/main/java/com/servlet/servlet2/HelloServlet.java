package com.servlet.servlet2;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;



//@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    List<String> users = new ArrayList<>();

    public void init() {
        message = "Hello servlet!!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        showDataFromDatabase();
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        for (int i = 0; i < users.size(); i++) {
            out.println("<h1>" + users.get(i) + "</h1>");
        }

        out.println("</body></html>");
    }


    private void showDataFromDatabase() {
        connectDatabase.connect();

//       users =  getUsers();


    }

    public void destroy() {
    }
}