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

public class stageTwoServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Stage Two servlet";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //getting All the cookies
        Cookie[] cookies = request.getCookies();
        out.println("<html><body>");
        boolean flag = false;

        String email = "";


        if(cookies == null){
            out.println("<h1> there is no cookies saved</h1>");
        }
        else{
            for(Cookie c: cookies){
                String Cmail = c.getName();

                out.println("<h5>"+c.getValue()+"</h5>");
                if(Cmail.equals("userEmail")){
                    flag = true;
                    email = c.getValue();
                    System.out.println("success");
                }
            }
        }
        System.out.println(email+" email in  the stage two");
        connectDatabase.updateDataInDatabase(email,request.getParameter("userName"));

        if(flag){
            out.println("<h1>The user mail is :: " +email+"</h1>");

        }

        out.println("<h1>The user name is :: " +request.getParameter("userName")+ " this is passed through the update form" +"</h1>");



        // Hello
        out.println("<h1> oTay</h1>");

        out.println("</body></html>");
    }

    public void destroy() {
    }

}
