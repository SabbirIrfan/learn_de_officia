<%--<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>--%>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <style>
      .body{
        background: whitesmoke;
      }
      .formContainer{

        background: antiquewhite;
        width: fit-content;
        height: max-content;
        border: 1px ridge darkcyan;
        margin: auto;
        padding: 20px;
        border-bottom-left-radius: 20px;
        border-top-right-radius: 20px;
        border-bottom-right-radius: 5px;
        font-size: 18px;
        align-content: center;

      }
     #myForm table tr td input{
       font-size: 16px ;
     }
  </style>
</head>
<body class="body">
<%--    <sql:setDataSource var = "db" driver="com.mysql.jdbc.Driver" url= "jdbc:mysql://localhost:3306/regiForm" user="root" password="" />--%>
<%--    <sql:query var="resiltSet" dataSource="${db}">select * from devUser</sql:query>--%>
<%--     <c:forEach items="${resiltSet.rows}" var="user">--%>
<%--       <br>--%>
<%--       <c:out value="${user.name}"></c:out>--%>
<%--     </c:forEach>--%>

    <a href="register.jsp">Click here to goto Register</a>

<br/>
  <div class="formContainer">
    <form id="myForm" action="registerServlet" method="post">
      <h1><%= "Hello user from index!" %></h1>


      <table>
        <tr>
          <td>Enter your Email</td>
          <td> <input type="email" name="userMail" placeholder="Enterhere@mail.com"></td>
        </tr>
        <tr>
          <td>Enter your Password</td>
          <td> <input type="password" name="userPass" placeholder="Password"></td>
        </tr>
        <tr>
         <td>Select one</td>
          <td> <input type="radio" name="java" value="java">java? &nbsp;&nbsp; <input type="radio" name="java" value="java nah">java nah!</td>
        </tr>

        <tr>
          <td></td>
          <td >
            <button type="submit" > SUBMIT</button>
            <button type="reset" > Reset</button>
          </td>
        </tr>
      </table>
    </form>
  </div>
<a href="hello-servlet">Show users</a>
</body>
</html>