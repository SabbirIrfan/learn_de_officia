package com.servlet.servlet2;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "myServlet", value = "/my-servlet")
public class myServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "my servlet!!";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + " Status -> " + request.getAttribute("status") + "</h1> </br>");

        out.println("<h1>" + "User Main -> " + request.getParameter("userMail") + "</h1> </br>");
        out.println("<h1>" + "User selected -> " + request.getParameter("java") + "</h1> </br>");

        out.println("</body></html>");
    }

    public void destroy() {
    }
}
