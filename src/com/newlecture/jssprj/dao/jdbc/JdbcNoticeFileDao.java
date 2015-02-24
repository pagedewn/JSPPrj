package com.newlecture.jssprj.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.jspprj.dao.NoticeFileDao;
import com.newlecture.jspprj.model.Notice;
import com.newlecture.jspprj.model.NoticeFile;

public class JdbcNoticeFileDao implements NoticeFileDao {

	@Override
	public List<NoticeFile> getNoticeFiles(String noticeCode) {
	

		String sql="SELECT * FROM NOTICEFILES WHERE NOTICECODE = ?";
		String url ="jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "sist", "newlec");
			PreparedStatement st = con.prepareStatement(sql);

			
			ResultSet rs = st.executeQuery();
			
			List<NoticeFile> list = new ArrayList<NoticeFile>();

			while (rs.next()) {
				NoticeFile n = new NoticeFile();
				n.setCode(rs.getString("CODE"));
				n.setSrc(rs.getString("SRC"));
				n.setDescription(rs.getString("DESCRIPTION"));
				n.setRegdate(rs.getDate("REGDATE"));
				n.setNoticeCode(rs.getString("NOTICECODE"));

				list.add(n);
			}
			
			rs.close();
			st.close();
			con.close();

			return list;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insert(NoticeFile file) {
		String sql = "INSERT INTO NOTICEFILES(CODE,SRC,REGDATE,DESCRIPTION,NOTICECODE) VALUES(?,?,GETDATE(),?,?)";
		String url ="jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb";
		
		String codeSql= "SELECT ISNULL(MAX(CAST(CODE AS INT)),0)+1 CODE FROM NOTICES";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "sist", "newlec");
			Statement stCode=con.createStatement();
			ResultSet rs=stCode.executeQuery(codeSql);
			
			rs.next();
			String code=rs.getString("CODE");
			
			rs.close();
			stCode.close();
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, code);
			st.setString(2, file.getSrc());
			st.setString(3, file.getDescription());
			st.setString(4, file.getNoticeCode());

			int result = st.executeUpdate();

			st.close();
			con.close();

			return result;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

}
