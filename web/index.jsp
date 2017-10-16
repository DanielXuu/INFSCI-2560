<%-- 
    Document   : index
    Created on : Nov 29, 2016, 6:07:32 PM
    Author     : zhenqiang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            body {background-image: url(Image/login.jpg);}
            form {position: absolute; top: 20%;left: 44%;width:300px;font-size:20px;color: white;}   
        </style>
        <title>Social Network</title>
    </head>
    <body>
        <form action="login" method="post" >
            USERNAME:  <input type="text" name="uname"/><br/><br/>
            PASSWORD:  <input type="password" name="upass"/><br/><br/>
            <a href="forgot.jsp" style="color:whitesmoke">Forgot Password?</a><br/><br/>
            <input type="submit" value="LOGIN IN" style="background-color: #333333;color: white;width:200px; height:30px;"><br/><br/>
            <a href="join.jsp" style="color: white">JOIN US</a>
        </form>
    </body>
</html>
