package com.servlet.servlet2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


import static com.servlet.servlet2.connectDatabase.insertDataIntoDatabase;

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
           RequestDispatcher rd = request.getRequestDispatcher("myServlet");
           String status = "Successfull";



           connectDatabase.insertDataIntoDatabase(request.getParameter("userName"),request.getParameter("userEmail"),request.getParameter("userPassword"));

           request.setAttribute("status",status);
           rd.forward(request,response);
        }
    }


    @Override
    public void destroy() {
        super.destroy();
    }
}
