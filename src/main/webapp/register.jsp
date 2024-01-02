

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="sql" uri="jakarta.tags.sql" %>


<html>
<head>
    <title>Title</title>


    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</head>
<body>
<%--&lt;%&ndash;<div>&ndash;%&gt;--%>
<c:out value="Its the core taglib"> hellow</c:out>

<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/regiForm"
                   user="root" password=""
/>
    <sql:query var="resultSet" dataSource="${db}">select * from devUser</sql:query>
    <c:forEach items="${resultSet.rows}" var="user">
        <br>
        <c:out value="in for loop">jstl</c:out>
        <c:out value="${user.name}"></c:out>
    </c:forEach>
    <br/>
<%--</div>--%>
      <div class="container">
          <div class="row" >
              <div class="col m6 offset-m3">
                  <div class="card">
                      <div class="card-content">
                          <h3>Register here</h3>

                          <form action="registerServlet" method="post">
                              <input type="text" name="userName" placeholder="Enter your name" />
                              <input type="text" name="userEmail" placeholder="Enter your mail" />
                              <input type="text" name="userAddress" placeholder="Enter your address" />
                              <input type="password" name="userPassword" placeholder="password" />

<%--                              <label for="tech" style=" color: black"> what do you prefer</label>--%>

<%--                              <select id="tech" name="userTech">--%>
<%--                                  <option value="spring">springBoot</option>--%>
<%--                                  <option value="node">Node</option>--%>
<%--                                  <option value="ruby">Ruby</option>--%>
<%--                              </select>--%>




                              <button type="submit" class="btn  blue lighten-2">Submit</button>
                          </form>
                      </div>
<%--                      <h5 style="align-content: center">Please wait...</h5>--%>
<%--                      <div class="progress" >--%>

<%--                          <div class="indeterminate"></div>--%>
<%--                      </div>--%>

                      <div class="card-content">
                          <h3>Login here</h3>

                          <form action="login" method="post">
                              <input type="text" name="userEmail" placeholder="Enter your mail" />
                              <input type="password" name="userPassword" placeholder="password" />

                              <%--                              <label for="tech" style=" color: black"> what do you prefer</label>--%>

                              <%--                              <select id="tech" name="userTech">--%>
                              <%--                                  <option value="spring">springBoot</option>--%>
                              <%--                                  <option value="node">Node</option>--%>
                              <%--                                  <option value="ruby">Ruby</option>--%>
                              <%--                              </select>--%>




                              <button type="submit" class="btn  blue lighten-2">Submit</button>
                          </form>
                      </div>
                  </div>

              </div>
          </div>


      </div>

      <script
              src="https://code.jquery.com/jquery-3.7.1.min.js"
              integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
              crossorigin="anonymous"></script>
 <script>
     $(document).ready( () =>{
         console.log("jQuery is working properly");
     })
 </script>
</body>
</html>
