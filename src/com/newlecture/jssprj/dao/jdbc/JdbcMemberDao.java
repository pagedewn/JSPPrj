package com.newlecture.jssprj.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.PageContext;

import com.newlecture.jspprj.dao.MemberDao;
import com.newlecture.jspprj.dao.NoticeDao;
import com.newlecture.jspprj.model.Member;
import com.newlecture.jspprj.model.Notice;

public class JdbcMemberDao implements MemberDao {

	@Override
	public Member getMember(String uid) {
		String sql = "SELECT * FROM MEMBERS WHERE MID=?";
		String url ="jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "sist", "newlec");
			PreparedStatement st = con.prepareStatement(sql);

			
			st.setString(1,uid);
			
			ResultSet rs = st.executeQuery();
			
			Member m = new Member();
			rs.next() ;
				
				m.setUid(rs.getString("MID"));
				m.setPwd(rs.getString("PWD"));
				m.setName(rs.getString("NAME"));
			
	
			
			rs.close();
			st.close();
			con.close();

			return m;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}




}
