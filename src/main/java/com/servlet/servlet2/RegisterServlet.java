package com.servlet.servlet2;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        out.println("<h1>"+"User Main -> "+request.getParameter("userMail") +"</h1> </br>");
        out.println("<h1>"+"User selected -> "+request.getParameter("java") +"</h1> </br>");

        out.println("</body></html>");
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
