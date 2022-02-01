
package practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class ProjectUnitTest {
@Test
	
	public void ProjectUnitTest() throws Throwable{
	String ProjectName = "abc";
	Connection conn = null;
	try {
		Driver driverRef = new Driver();
	    /*	step 1 : load /register *mysql* database */			
		DriverManager.registerDriver(driverRef);
		
		/* step 2 : connect to DB */
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		System.out.println("connection is done");
		
		/* step 3 : create query statement */
		Statement stat = conn.createStatement();
		String query = "select * from project"; 
		
		/* step 4 : Execute the query */
		ResultSet resultset = stat.executeQuery(query);
		boolean flag=false;
		while (resultset.next()) {
			 String actProjectName = resultset.getString(2);
			if(actProjectName.equals(actProjectName)) {
				flag=true;
			}
		}
		
	}catch (Exception e) {
}finally {
/* step 5 : close the connection */
conn.close();
System.out.println("=======close db connection======");
}
}
}

