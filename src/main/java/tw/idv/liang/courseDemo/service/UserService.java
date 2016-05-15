package tw.idv.liang.courseDemo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tw.idv.liang.courseDemo.entity.User;
import tw.idv.liang.courseDemo.others.Util;

public class UserService {
	
	public UserService(){
		
	}
	
	public int insert(User user){
		Connection conn = null;
		int id=-1;
		try {
			Util util = new Util();
			conn = util.GetMySqlConnection();
			conn.setAutoCommit(false);
			String  sql="insert into user (userId,password,realName,email,pictureUrl) values (?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, user.getUserName());
	        pstmt.setString(2, user.getPassword());
	        pstmt.setString(3, user.getRealName());
	        pstmt.setString(4, user.getEmail());        
	        pstmt.setString(5, user.getPictureSource());
	        pstmt.executeUpdate();	
	        sql="select * from user where userId=?";
	        PreparedStatement pstmt2 = conn.prepareStatement(sql);
	        pstmt2.setString(1, user.getUserName());
	        ResultSet rs=pstmt2.executeQuery();
	        if(rs.next()){
	        	id=rs.getInt("id");
	        }
	        conn.commit();
	        pstmt.close();
	        pstmt2.close();
		}
		catch(Exception x)
		{
			if (conn != null) {
	            try {
	                System.err.print("Transaction is being rolled back"+x.toString());
	                conn.rollback();
	            } catch(SQLException excep) {
	            	System.err.print("rolled back fail");
	            }
	        }
		}
		finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					System.out.println("Problem closing connection");
				}
		}
		return id;
	}
	
	public void update(User user){
		Connection conn = null;
		try {
			Util util = new Util();
			conn = util.GetMySqlConnection();
			String  sql="update user set password=?,realName=?,email=?,pictureUrl=? where userId=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, user.getPassword());
	        pstmt.setString(2, user.getRealName());
	        pstmt.setString(3, user.getEmail());  
	        pstmt.setString(4, user.getPictureSource());  
	        pstmt.setString(5, user.getUserName());
	        pstmt.executeUpdate();	
	        pstmt.close();
		}
		catch(Exception x)
		{
			System.err.print(x.toString());
		}
		finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					System.out.println("Problem closing connection");
				}
		}
	}
	
	public void delete(String id){
		Connection conn = null;
		try {
			Util util = new Util();
			conn = util.GetMySqlConnection();
			String  sql="delete from user where userId=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);     
	        pstmt.setString(1, id);
	        pstmt.executeUpdate();	
	        pstmt.close();
		}
		catch(Exception x)
		{
			System.err.print(x.toString());
		}
		finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					System.out.println("Problem closing connection");
				}
		}
	}
	
	public List<User> getUsers(){
		Connection conn = null;
		List<User> result = new ArrayList<User>();
		User user=null;
		int id=-1;
		try {
			Util util = new Util();
			conn = util.GetMySqlConnection();
	        String sql="select * from user";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        ResultSet rs=pstmt.executeQuery();
	        while(rs.next()){
	        	user = new User();
	        	user.setId(rs.getInt("id"));
	        	user.setUserName(rs.getString("userId"));
	        	user.setPassword(rs.getString("password"));
	        	user.setRealName(rs.getString("realName"));
	        	user.setEmail(rs.getString("email"));
	        	user.setPictureSource(rs.getString("pictureUrl"));
	        	result.add(user);
	        }
	        pstmt.close();
	        
		}
		catch(Exception x)
		{
			System.err.print(x.toString());
		}
		finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					System.out.println("Problem closing connection");
				}
		}
		return result;
	}
	
}
