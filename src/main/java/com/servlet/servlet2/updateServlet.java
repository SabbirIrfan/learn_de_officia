package com.servlet.servlet2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class updateServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        // do the update call to the database

        Cookie[] cookies = request.getCookies();
        String pass = "";
        boolean flag = false;
        for(Cookie c: cookies){
            if(c.getName().equals("password") ){
                pass = c.getValue();
                flag = true;
            }
        }
        PrintWriter out = response.getWriter();
        if(flag)
            if(request.getParameter("userPassword").equals(pass)){


                String s = request.getParameter("userEmail");
                String[] st = s.split(" ");



                System.out.println(s+" " + request.getParameter("userName")+" "+ request.getParameter("userAddress"));
                if(connectDatabase.updateDataInDatabase(s, request.getParameter("userName"), request.getParameter("userAddress"))){
                    out.println("<h1> update of the user profile is complete</h1>");
                    request.setAttribute("userName", request.getParameter("userName"));
                    request.setAttribute("userEmail", request.getParameter("userEmail"));
                    request.setAttribute("userAddress", request.getParameter("userAddress"));
                    Cookie c = new Cookie("password",request.getParameter("userPassword") );
                    RequestDispatcher dispatcher = request.getRequestDispatcher("updateUser.jsp");
                    request.setAttribute("status","success");
                    dispatcher.forward(request, response);

                }else{
                    request.setAttribute("status","Unsuccessfull");
                    out.println("<h1> no row effected .. please check for bugs in the update</h1>");

                }
            }else{
                out.println("<h1> wrong credentials</h1>");
                out.println(request.getParameter("userPassword")+">> this is the user password provided without the hashing");
                out.println(request.getParameter("userAddress")+">> this is the user Address");


            }

    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
