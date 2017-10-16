<%-- 
    Document   : forgot
    Created on : Nov 29, 2016, 7:14:29 PM
    Author     : zhenqiang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
        <style>
        body {background-image: url(Image/profile.jpg);}
        </style>
    </head>
    <body>
		<%
			List<Map<String, Object>> listFriends = (List<Map<String, Object>>)request.getAttribute("userInfo");
			Map<String, Object> map = listFriends.get(0);
		%>

        <form action="updprofile" method="post" style="margin-left:auto;margin-right:auto; width:300px;">
        <h1>User Information</h1>
            USER ID:<input type="text" name="meid" maxlength="10" readonly="readonly" value="<%=map.get("Id") %>" required/><br/><br/>
            USER ACCOUNT:<input type="text" name="username" maxlength="10" readonly="readonly" value="<%=map.get("username") %>" required/><br/><br/>
            NAME:<input type="text" name="name" maxlength="10" value="<%=map.get("name") %>" required/><br/><br/>
            E-MAIL:<input type="text" name="email" maxlength="10" value="<%=map.get("email") %>" required/><br/><br/>
            GENDER:<input type="radio" name="gender" value="male" checked/> Male
            <input type="radio" name="gender" value="female"/> Female<br/><br/>
            PERSONAL INTRODUCTION:<input type="text" name="intro" maxlength="10" value="<%=map.get("intro") %>" required/><br/><br/>
            <input type="submit" value="Modify" style="width: 100px; height: 30px;color: white;background-color: #555555;">
        </form>
        </br></br>
		<p style="text-align:center"><a href="home">Back to Home Page</a>
    </body>
</html>
