package com.servlet.servlet2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;

public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        HashMap<String, String> user = connectDatabase.getUser(request.getParameter("userEmail"));

        request.setAttribute("userName", user.get("name"));
        request.setAttribute("userEmail", request.getParameter("userEmail"));
        request.setAttribute("userAddress", user.get("address"));
        Cookie c = new Cookie("password",request.getParameter("userPassword") );
        response.addCookie(c);
        RequestDispatcher dispatcher = request.getRequestDispatcher("updateUser.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
