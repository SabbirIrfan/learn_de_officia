package com.servlet.servlet2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class loginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

//        String userName = "";
//        String userAddress = "";
        System.out.println(request.getParameter("userEmail")+"where is the userEmail>");

        HashMap<String,String> user =  connectDatabase.getUser(request.getParameter("userEmail"));

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Registration Form</title>");
        // Compiled and minified CSS
        out.println("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css\">");

        // Compiled and minified JavaScript
        out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js\"></script>");

        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        out.println("<div class=\"row\">");
        out.println("<div class=\"col m6 offset-m3\">");
        out.println("<div class=\"card\">");
        out.println("<div class=\"card-content\">");
        out.println("<h3>"+"Hello "+ user.get("name")+ "</h3>");

        out.println("<form action=\"update\" method=\"post\">");
        out.println("<input type=\"text\" name=\"userName\" value=\" "+ user.get("name") + " \" required/><br/>");
        out.println("<input type=\"text\" name=\"userEmail\" value=\" "+ request.getParameter("userEmail") + "  \" readonly/><br/>");
        out.println("<input type=\"text\" name=\"userAddress\" value=\" "+ user.get("address") + " \" /><br/>");
        out.println("<input type=\"password\" name=\"userPassword\" placeholder=\"Password\" required/><br/>");

        Cookie c = new Cookie("password", request.getParameter("userPassword"));
        response.addCookie(c);
        out.println("<button type=\"submit\" class=\"btn blue lighten-2\">Update</button>");
        out.println("</form>");

        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");


    }
    @Override
    public void destroy( ){
        super.destroy();
    }
}
