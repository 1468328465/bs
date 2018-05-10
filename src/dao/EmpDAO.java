package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.DBUtil;
import entiy.Emp;

public class EmpDAO {
	public void save(Emp emp) throws Exception{
		Connection conn=null;
		PreparedStatement prep=null;
		try {
			conn=DBUtil.getConnection();
			prep=conn.prepareStatement("insert into  bs_employee(id,name,gender,age,tel,id_card,address,other)values(?,?,?,?,?,?,?,?)");
			prep.setString(1,emp.getId());
			prep.setString(2,emp.getName());
			prep.setString(3,emp.getGender());
			prep.setString(4,emp.getAge());
			prep.setString(5,emp.getTel());
			prep.setString(6,emp.getId_card());
			prep.setString(7,emp.getAddress());
			prep.setString(8,emp.getOther());
			prep.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.closeConnection(conn);
		}
	}
	
}
