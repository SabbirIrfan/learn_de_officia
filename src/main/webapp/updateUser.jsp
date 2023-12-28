<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<html>
<head>
    <title>Update User</title>
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col m6 offset-m3">
            <div class="card">
                <div class="card-content">
                    <h3>Hello <%= request.getAttribute("userName") %></h3>
                    <%
                        try {

                            if (request.getAttribute("status").equals("success")){
                                out.println("<h2> successfully updated </h2>");

                            } else if  (request.getAttribute("status").equals("success")){
                                out.println("<h2> updating failed </h2>");

                            }

                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    %>
                    <form action="update" method="post">
                        <input type="text" name="userName" value="<%= request.getAttribute("userName") %>" required/><br/>
                        <input type="text" name="userEmail" value="<%= request.getAttribute("userEmail") %>" readonly/><br/>
                        <input type="text" name="userAddress" value="<%= request.getAttribute("userAddress") %>" /><br/>
                        <input type="password" name="userPassword" placeholder="Password" required/><br/>

                        <button type="submit" class="btn blue lighten-2">Update</button>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
