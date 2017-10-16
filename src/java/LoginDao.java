
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author zhenqiang
 */
public class LoginDao {
	
	public static String strConn = "jdbc:mysql://localhost:3306/SNP?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf-8";
	public static String strSqlUserName = "root";
	public static String strSqlPassword = "Daniel321";
	
        public static boolean validate(String uname,String upass){  
	    boolean status=false;  
	    Connection con = null;
	    PreparedStatement ps = null;
	    try{  
                //connect database
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection(strConn, strSqlUserName, strSqlPassword);  
	        ps=con.prepareStatement("select * from USERINFO where username=? and password=?");
	        ps.setString(1,uname);  
	        ps.setString(2,upass);  
                //execute statement
	        ResultSet rs=ps.executeQuery();  
	        status=rs.next();  
	    }catch(Exception e){
	        System.out.println(e);
	    }finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
	    			con.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
        return status;  
        }
    
    
        public static int findMeid(String uname){  
            int iRet = -1;
            Connection con = null;
	    PreparedStatement ps = null;
                try{  
                    Class.forName("com.mysql.jdbc.Driver");  
                    con=DriverManager.getConnection(strConn, strSqlUserName, strSqlPassword);  
                    ps=con.prepareStatement("select * from USERINFO where username=?");  
                    ps.setString(1,uname);  
                    ResultSet rs=ps.executeQuery();  
                    while (rs.next()) {
	        	iRet = rs.getInt("Id");
	        	break;
                    }
                }catch(Exception e){
                    System.out.println(e);
                }finally {
                    try {
                        if (ps != null)
                            ps.close();
			if (con != null)
                            con.close(); 
			} catch (SQLException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
			}
                }
            return iRet;  
        }
    

        public static boolean joinUs(String username, String password, String name, String email, String gender, String intro){  
	    boolean status=false;  
	    Connection con = null;
	    PreparedStatement ps = null;
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection(strConn, strSqlUserName, strSqlPassword);  
	        String sql = "insert into userinfo (username,password, name, email, gender, intro) values(?,?,?,?,?,?)";
	        ps=con.prepareStatement(sql);  
	        ps.setString(1,username);  
	        ps.setString(2,password);
		ps.setString(3,name);
		ps.setString(4,email);
		ps.setString(5,gender);
		ps.setString(6,intro);
	        int i = ps.executeUpdate();
	        if (1 == i ) {
	        	return true; 
	        }
	    }catch(Exception e){
	        System.out.println(e);
	    }finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
	    			con.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
        return status;  
        }
     
        public static boolean forgot(String username, String email, String password){  
	    boolean status=false;  
	    Connection con = null;
	    PreparedStatement ps = null;
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection(strConn, strSqlUserName, strSqlPassword);  
	        String sql = "update userinfo set password='" + password + "' where username='" + username + "' and email='" + email + "'";
	        ps=con.prepareStatement(sql);
	        int i = ps.executeUpdate();
	        if (0 < i ) {
	        	return true; 
	        }
	    }catch(Exception e){
	        System.out.println(e);
	    }finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
	    			con.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
        return status;  
        }
    
    
        public static List<Map<String, Object>> friends(String meid){
            Connection con = null;
	    PreparedStatement ps = null;
	    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection(strConn, strSqlUserName, strSqlPassword);  
	        String sql = "select * from friend a, userinfo b where a.friendid=b.id and meid=" + meid;
	        ps=con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery(sql); 
	        ResultSetMetaData md = rs.getMetaData();
	        int columnCount = md.getColumnCount();
	        while (rs.next()) {
	            Map<String, Object> rowData = new HashMap<String, Object>();
	            for (int i = 1; i <= columnCount; i++) {
	                rowData.put(md.getColumnName(i), rs.getObject(i));
	            }
	            list.add(rowData);
	        }
	    }catch(Exception e){
	        System.out.println(e);
	    }finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
	    			con.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
        return list;  
        }
    
    
        public static boolean addFriend(String meid, String friendid){  
	    boolean status=false;  
	    Connection con = null;
	    PreparedStatement ps = null;
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection(strConn, strSqlUserName, strSqlPassword);  
	        String sql = "insert into friend (meid,friendid) values(?,?)";
	        ps=con.prepareStatement(sql);  
	        ps.setString(1,meid);  
	        ps.setString(2,friendid);
	        int i = ps.executeUpdate();
	        if (1 == i ) {
	        	return true; 
	        }
	    }catch(Exception e){
	        System.out.println(e);
	    }finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
	    			con.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
        return status;  
        }
    
    
        public static boolean addQuotations(String meid, String content){  
	    boolean status=false;  
	    Connection con = null;
	    PreparedStatement ps = null;
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection(strConn, strSqlUserName, strSqlPassword);  
	        String sql = "insert into quotations (meid,info) values(?,?)";
	        ps=con.prepareStatement(sql);  
	        ps.setString(1,meid);  
	        ps.setString(2,content);
	        int i = ps.executeUpdate();
	        if (1 == i ) {
	        	return true; 
	        }
	    }catch(Exception e){
	        System.out.println(e);
	    }finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
	    			con.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
        return status;  
        }
    
    
        public static List<Map<String, Object>> getQueotations(String meid){
            Connection con = null;
	    PreparedStatement ps = null;
	    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection(strConn, strSqlUserName, strSqlPassword);  
                //get all information that related with user
	        String sql = "select * from friend a, quotations b, userinfo c where a.friendid=b.meid and a.friendid=c.id and a.meid=" + meid;
	        ps=con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery(sql); 
                //get how many columns
	        ResultSetMetaData md = rs.getMetaData();
	        int columnCount = md.getColumnCount();
	        while (rs.next()) {
	            Map<String, Object> rowData = new HashMap<String, Object>();
	            for (int i = 1; i <= columnCount; i++) {
	                rowData.put(md.getColumnName(i), rs.getObject(i));
	            }
	            list.add(rowData);
	        }
	    }catch(Exception e){
	        System.out.println(e);
	    }finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
	    			con.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
        return list;  
        }
    
    
        public static boolean delFriend(String meid,String friendid){  
	    boolean status=false;  
	    Connection con = null;
	    PreparedStatement ps = null;
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection(strConn, strSqlUserName, strSqlPassword);  
	        String sql = "delete from friend where meid=" + meid + " and friendid=" + friendid;
	        ps=con.prepareStatement(sql);
	        int i = ps.executeUpdate();
	        if (0 < i ) {
	        	return true; 
	        }
	    }catch(Exception e){
	        System.out.println(e);
	    }finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
	    			con.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
        return status;  
        }
    
        public static List<Map<String, Object>> getUserInfo(String meid){
            Connection con = null;
	    PreparedStatement ps = null;
	    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection(strConn, strSqlUserName, strSqlPassword);  
	        String sql = "select * from userinfo where id=" + meid;
	        ps=con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery(sql);  
	        ResultSetMetaData md = rs.getMetaData();
	        int columnCount = md.getColumnCount();
	        while (rs.next()) {
	            Map<String, Object> rowData = new HashMap<String, Object>();
	            for (int i = 1; i <= columnCount; i++) {
	                rowData.put(md.getColumnName(i), rs.getObject(i));
	            }
	            list.add(rowData);
	        }
	    }catch(Exception e){
	        System.out.println(e);
	    }finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
	    			con.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
        return list;  
        }
    
        public static boolean updProfile(String meid, String username, String password, String name, String email, String gender, String intro){  
	    boolean status=false;  
	    Connection con = null;
	    PreparedStatement ps = null;
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection(strConn, strSqlUserName, strSqlPassword);  
	        String sql = "update userinfo set name='" + name + "',email='" + email + "',gender='" + gender + "',intro='" + intro + "' where id=" + meid;
	        System.out.println(sql);
	        ps=con.prepareStatement(sql);
	        int i = ps.executeUpdate();
	        if (0 < i ) {
	        	return true; 
	        }
	    }catch(Exception e){
	        System.out.println(e);
	    }finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
	    			con.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
        return status;  
        }
}
