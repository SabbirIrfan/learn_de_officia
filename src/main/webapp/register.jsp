<%--
  Created by IntelliJ IDEA.
  User: john_doe
  Date: ১৪/১২/২৩
  Time: ৩:৩২ PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</head>
<body>
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
