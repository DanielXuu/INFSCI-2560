<%-- 
    Document   : hm
    Created on : Dec 2, 2016, 5:31:17 PM
    Author     : zhenqiang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" href="menu.css" rel="stylesheet"/>
        <script type="text/javascript">
        </script>
        <title>Home Page</title>
    </head>
    <body>
        <div class="menu">
        <ul>
            <li><a href="home">Home Page</a></li>
            <li><a href="profile">Profile</a></li>
            <li><a href="friend">Friend</a></li>
            <li><a href="index.jsp">Log Out</a></li>
        </ul>
        </div>

        <div>
            </br></br></br></br></br></br>
            <form action="addquotations" method="post" style="margin-left:auto;margin-right:auto; width:300px;">
		<h1>POST CONTENT</h1>
		<input type="text" name="content" maxlength="50" style="width:300px;height:50px;" required/><br/><br/>
		<input type="submit" value="SUBMIT" style="width: 100px; height: 25px;color: white;background-color: steelblue;">
            </form>
            </br></br>
            <table border="1" style="margin: 0px auto;">
                <col width="80">
                <col width="150">
                <tr>
                    <th>Friend</th>
                    <th>Content</th>
		</tr>
                    <%
			List<Map<String, Object>> listQueotations = (List<Map<String, Object>>)request.getAttribute("queotations");
			int fNum = listQueotations.size();
			for(int i=0;i<fNum;i++){
                            Map<String, Object> map = listQueotations.get(i);
                    %>
                        <tr>
                            <td><%=map.get("name") %></td>
                            <td><%=map.get("info") %></td>
                        </tr>
                    <%
			}
                    %>
            </table>
        </div>    </br></br></br></br></br></br></br></br></br></br></br></br></br></br>

        <div class="menu">
        <ul>
            <li><a href="#top">Back to top</a></li>
            <li><a href="contact.jsp">Contact Us</a></li>
        </ul>
        </div>
        
    </body>
</html>
