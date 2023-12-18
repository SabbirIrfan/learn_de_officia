package com.servlet.servlet2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "myServlet", value = "/my-servlet")
public class stageOneServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "my servlet!!";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        // Hello
        // Cookie creation
        Cookie c1 = new Cookie("userEmail",request.getParameter("userEmail"));
        Cookie c2 = new Cookie("userName",request.getParameter("userName"));

        Cookie c3 = new Cookie("userPassword",request.getParameter("userPassword"));

        response.addCookie(c1);
        response.addCookie(c2);
        response.addCookie(c3);

        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        out.println("<form action='stageTwo' method='post'>"); // Opening form tag

// Input field for status
        out.println("<label>Status:</label>");
        out.println("<input type='text' name='status' value='" + request.getAttribute("status") + "' readonly/><br/>");

// Input field for user name
        out.println("<label>User name:</label>");
        out.println("<input type='text' name='userName' value='" + request.getParameter("userName") + "' /><br/>");

// Input field for user email
        out.println("<label>User Mail:</label>");
        out.println("<input type='text' name='userEmail' value='" + request.getParameter("userEmail") + "' readonly/><br/>");

        out.println("<input type='submit' value='Update'/>"); // Submit button

        out.println("</form>"); // Closing form tag

//        out.println("<a href='stageTwo'>" + "Cookie testing" + "</a>");

        out.println("</body></html>");

    }

    public void destroy() {
    }
}
