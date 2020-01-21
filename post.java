import java.sql.*; 
import java.sql.Date.*;
import java.time.LocalTime; 
 
class post{  
public static void main(String args[]){  
try{  
	int t=0;
	Class.forName("com.mysql.jdbc.Driver");
    //local host is good
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login?characterEncoding=latin1","root","admin");  
	//here sonoo is database name,  is username and password  
	
	
	PreparedStatement stmt=con.prepareStatement("select * from pc");  
	ResultSet rs=stmt.executeQuery(); 
	while(rs.next()){  
		t=rs.getInt(1);  
	}  
	System.out.println(t);
	
	String sql = "UPDATE students SET endTime=? WHERE pc = ? and endTime is Null";
	PreparedStatement spst = con.prepareStatement(sql);
	
	LocalTime now = LocalTime.now();
	Time time = Time.valueOf( now );
	
	spst.setTime(1,time);
	spst.setInt(2,t);
	spst.executeUpdate();
	
	con.close();
	
	
	
}catch(Exception e){ System.out.println(e);}  
	}  
}


//set classpath = C:\Program Files\Java\folder\mysql-connector.jar;