
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;  
/**
 *
 * @author zhenqiang
 */
public class UserBean {
    private String id;
    private String password;
    private String cpassword;
    private String email;
    private String gender;
    private String intro;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the intro
     */
    public String getIntro() {
        return intro;
    }

    /**
     * @param intro the intro to set
     */
    public void setIntro(String intro) {
        this.intro = intro;
    }
    
    /**
     * @return the cpassword
     */
    public String getCpassword() {
        return cpassword;
    }

    /**
     * @param cpassword the cpassword to set
     */
    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }
    
    public int store() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        
        String url = "jdbc:mysql://localhost:3306/SNP?zeroDateTimeBehavior=convertToNull";
        
        Connection con = DriverManager.getConnection(url,"root","Daniel321");
        
        PreparedStatement ps = con.prepareStatement("insert into USERINFO(id,password,email,gender,intro) values (?,?,?,?,?)");
        
        ps.setString(1,id);
        ps.setString(2,password);
        ps.setString(3,email);
        ps.setString(4,gender);
        ps.setString(5,intro);
        
        int a = ps.executeUpdate();
        
        if(a==1){
            return a;
        }else{
            return a;
        }
    } 

    
}
