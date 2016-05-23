package tw.idv.liang.courseDemo.others;

import java.sql.Connection;
import java.sql.DriverManager;



public class Util {
	public Connection GetMySqlConnection(){
		Connection conn=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn =	DriverManager.getConnection("jdbc:mysql://localhost:3306/coursedemo?" +
			"user=testuser&password=12345678&autoReconnect=true&useUnicode=true&characterEncoding=utf8");
		}
		catch(Exception x)
		{
		    //x.printStackTrace();
			System.out.println(x.toString());
		}
	    return conn;
	}
	
}
