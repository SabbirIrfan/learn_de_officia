<%--
  Created by IntelliJ IDEA.
  User: john_doe
  Date: ১৯/১২/২৩
  Time: ১১:৪৪ AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CSS flexbox</title>

    <style>
        .container{
            border: 2px solid black;
            display: flex;
            /*flex: 10 1 100px;*/
            height: 80vh;
            justify-content: center;
            align-items: center; /* used when there is only one line*/
            /*align-content: center; !* used when there is multiple line *!*/
            flex-direction: row;
            flex-wrap: wrap;
            gap: 10px 20px;

            flex-grow: 1;



        }
        .item{
            /*order: 1; !* if order is smaller then it shows first*!*/
            height: 50px;
            width: 50px;
            border: 2px solid black;
            margin: 4px;
            background-color: antiquewhite;


        }
        .order-1{
            order: 1;
        }
        .order-2{
            order: 2;
        }

    </style>
</head>
<body>
<div class="container">
    <div class="item order-1" >ORDER Used1</div>
    <div class="item">3</div>
    <div class="item">4</div>
    <div class="item">5</div>
    <div class="item">6</div>
    <div class="item">7</div>
    <div class="item">2</div>
    <div class="item">3</div>
    <div class="item">3</div>
    <div class="item order-1" >ORDER Used</div>
    <div class="item">5</div>
    <div class="item">6</div>
    <div class="item order-2">after order</div>

</div>

</body>
</html>