package tw.idv.liang.courseDemo.others;

import java.sql.Connection;
import java.sql.DriverManager;



public class Util {
	public Connection GetMySqlConnection(){
		Connection conn=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn =	DriverManager.getConnection("jdbc:mysql://140.115.158.242:3306/coursedemo?" +
			"user=firstuser&password=lee1960&autoReconnect=true&useUnicode=true&characterEncoding=utf8");
		}
		catch(Exception x)
		{
		    //x.printStackTrace();
			System.out.println(x.toString());
		}
	    return conn;
	}
	
}
