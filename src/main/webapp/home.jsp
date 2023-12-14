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
<br/>
<div class="formContainer">
    <form id="myForm" action="registerServlet" method="post">
        <h1><%= "Hello User from home!" %></h1>

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
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>