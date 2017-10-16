<%-- 
    Document   : join
    Created on : Nov 29, 2016, 7:40:19 PM
    Author     : zhenqiang
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
        body {background-image: url(Image/signin.jpg);}
        form {position: absolute; top: 10%;left: 40%;width:300px;font-size:15px;color: #999999;}   
        </style>
        <title>JOIN US</title>
    </head>
    <body>
        <form action="joinus" method="post" >
        <h1>SIGN IN</h1>
        USER NAME:<input type="text" name="username" maxlength="10" required/><br/><br/>
        PASSWORD:<input type="password" name="password" maxlength="15" required/><br/><br/>
        CONFIRM PASSWORD:<input type="password" name="cpass" maxlength="15" required/><br/><br/>
		NAME:<input type="text" name="name" required/><br/><br/>
        E-MAIL:<input type="email" name="email" required/><br/><br/>
        GENDER:<br/>
        <input type="radio" name="gender" value="male" checked/> Male
        <input type="radio" name="gender" value="female"/> Female<br/><br/>
        PERSONAL INTRODUCTION:<input type="text" maxlength="100" name="intro" style="width: 300px; height: 100px;"/><br/><br/>
        <input type="submit" value="SIGN IN" style="width: 100px; height: 30px;color: white;background-color: #555555;">
        </form>

    </body>
</html>
