import java.sql.*; 
import java.sql.Date.*;
import java.time.LocalTime; 
 
class post{  
public static void main(String args[]){  
try{  
	Class.forName("com.mysql.jdbc.Driver");
    //local host is good
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login?characterEncoding=latin1","root","admin");  
	//here sonoo is database name,  is username and password  
	
	Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery("select * from pc");  
	System.out.println(rs.getInt(1));
	String sql = "insert into students(endTime) values(?)  where pc=(?)";
	PreparedStatement spst = con.prepareStatement(sql);
	
	LocalTime now = LocalTime.now();
	Time time = Time.valueOf( now );
	
	spst.setTime(1,time);
	spst.setInt(2,rs.getInt(1));
	spst.executeUpdate();
	con.close();
	
	
	
}catch(Exception e){ System.out.println(e);}  
	}  
}


//set classpath = C:\Program Files\Java\folder\mysql-connector.jar;