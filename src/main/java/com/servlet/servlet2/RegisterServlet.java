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


public class RegisterServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");


        // Hello
        PrintWriter out = response.getWriter();

        if(request.getParameter("userEmail")==null || request.getParameter("userName")==null || request.getParameter("userPassword")==null){


            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            String status = "Fillup the form fully";
            request.setAttribute("status",status);
            rd.include(request,response);
        }
        else {
           RequestDispatcher rd = request.getRequestDispatcher("updateUser.jsp");
                String status = "Successfull";
                response.setContentType("text/html");

                HashMap<String, String> user = connectDatabase.getUser(request.getParameter("userEmail"));

                request.setAttribute("userName", request.getParameter("userName"));
                request.setAttribute("userEmail", request.getParameter("userEmail"));
                request.setAttribute("userAddress", request.getParameter("userAddress"));
                Cookie c = new Cookie("password",request.getParameter("userPassword") );
//        c.set
                response.addCookie(c);



           connectDatabase.insertDataIntoDatabase(request.getParameter("userName"),request.getParameter("userEmail"),request.getParameter("userPassword"),request.getParameter("userAddress") );

           request.setAttribute("status",status);
           rd.forward(request,response);
        }
    }


    @Override
    public void destroy() {
        super.destroy();
    }
}
