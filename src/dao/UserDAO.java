package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBUtil;

import entiy.Emp;
import entiy.User;

public class UserDAO {
	public User findByUsername(String username) throws Exception{
		User user=null;
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rst=null;
		try {
			conn=DBUtil.getConnection();
			prep=conn.prepareStatement("select * from bs_user where username=?");
			prep.setString(1,username);
			rst=prep.executeQuery();
			while(rst.next()){
				user=new User(rst.getInt("id"),rst.getString("username"),rst.getString("pwd"),rst.getString("name"),rst.getString("tel"),rst.getString("gender"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.closeConnection(conn);
		}
		return user;
	}
	public void save(User user) throws Exception{
		Connection conn=null;
		PreparedStatement prep=null;
		try {
			conn=DBUtil.getConnection();
			prep=conn.prepareStatement("insert into bs_user(username,pwd,name,tel,gender)values(?,?,?,?,?)");
			prep.setString(1,user.getUsername());
			prep.setString(2,user.getPwd());
			prep.setString(3,user.getName());
			prep.setString(4,user.getTel());
			prep.setString(5,user.getGender());
			prep.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.closeConnection(conn);
		}
	}
	
}
