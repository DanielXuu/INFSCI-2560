<%-- 
    Document   : forgot
    Created on : Nov 29, 2016, 7:14:29 PM
    Author     : zhenqiang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FORGOT PASSWORD</title>
        <style>
        body {background-image: url(Image/forgot.jpg);}
        </style>
    </head>
    <body>
        <br/><br/><br/><br/>
        <form action="forgot" method="post" style="color:white;margin-left:auto;margin-right:auto; width:500px;">
        <h1>FORGOT PASSWORD</h1>
        USER NAME:<input type="text" name="username" maxlength="10" required/><br/><br/>
        E-MAIL:<input type="text" name="email" maxlength="15" required/><br/><br/>
        NEW PASSWORD:<input type="password" name="password" maxlength="15" required/><br/><br/>
	<input type="submit" value="SUBMIT" style="width: 100px; height: 30px;color: white;background-color:lightskyblue;">
        </form>
    </body>
</html>
