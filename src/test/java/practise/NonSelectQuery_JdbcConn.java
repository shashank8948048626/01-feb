package practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class NonSelectQuery_JdbcConn {	
	public static void main(String[] args) throws Throwable {
		Connection conn=null;
		int result=0;
		try {
			Driver driverRef = new Driver();
			/*	step 1 : load /register *mysql* database */			
			DriverManager.registerDriver(driverRef);

			/* step 2 : connect to DB */
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			System.out.println("connection is done");

			/* step 3 : create query statement */
			Statement stat = conn.createStatement();
			String query= "insert into project values ('TY_PRO_004','shashankss','13/01/2022','sbi','On_Going',10)"; 

			/* step 4 : Execute the query */
			result=stat.executeUpdate(query);
		}
		catch (Exception e) {
		}
		finally {
			// to : handle exception
			if(result==1) {
				System.out.println("Project inserted succesfully");
			}else {
				System.out.println("Project is not inserted");
			}
			/* step 5 : close the connection */
			conn.close();
			System.out.println("=======close db connection======");
		}
	}

}
