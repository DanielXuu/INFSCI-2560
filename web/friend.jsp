<%-- 

    Author     : zhenqiang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Friend</title>
        <style>
        body {background-image: url(Image/friend.jpg);}
        </style>
    </head>
    <body>
        <h1 style="text-align:center">Friend List</h1>
            <table border="1" style="margin: 0px auto;">
                <col width="80">
                <col width="150">
		<tr>
			<th>ACCOUNT</th>
			<th>NAME</th>
		</tr>
		<%
			List<Map<String, Object>> listFriends = (List<Map<String, Object>>)request.getAttribute("friends");
			int fNum = listFriends.size();
			for(int i=0;i<fNum;i++){
				Map<String, Object> map = listFriends.get(i);
		%>
		  <tr>
			<td><%=map.get("username") %></td>
			<td><%=map.get("name") %></td>
			<td><a href="./delfriend?meid=<%=map.get("meid") %>&friendid=<%=map.get("friendid") %>">delete friend</a></td>
		  </tr>
		<%
			}
		%>
            </table>
        </br></br>
        <form action="addfriend" method="post" style="margin-left:auto;margin-right:auto; width:300px;">
        <h1>ADD FRIEND</h1>
        USER ACCOUNT:<input type="text" name="username" maxlength="10" required/><br/><br/>
		<input type="submit" value="SUBMIT" style="width: 100px; height: 30px;color: white;background-color: #555555;">
        </form>
        </br></br>
        <p style="text-align: center"><a href="home">Back to Home Page</a></p>
    </body>
</html>
