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

import com.newlecture.jspprj.dao.NoticeDao;
import com.newlecture.jspprj.model.Notice;

public class JdbcNoticeDao implements NoticeDao {

	@Override
	public Notice getNotice(String code) {
		String sql = "SELECT * FROM NOTICES WHERE CODE='"+code+"'";
		String url ="jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		Connection con = DriverManager.getConnection(url, "sist", "newlec");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		rs.next();
		Notice n= new Notice();
		n.setCode(code);
		
		n.setTitle(rs.getString("TITLE"));
		n.setWriter(rs.getString("WRITER"));
		n.setRegdate(rs.getDate("REGDATE"));
		n.setHit(rs.getInt("HIT"));
		n.setContent(rs.getString("CONTENT"));

		
		  
		rs.close();
		st.close();
		con.close();
		return n;
		
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
	public List<Notice> getNotices(int page, String query, String field) {

		int start = 1 + ((page - 1) * 20);
		int end = 20 + (page - 1) * 20;
	

	/*	String sql = "SELECT *FROM (SELECT ROWNUM NUM, NO.* FROM ( "
				+ "SELECT * FROM NOTICES WHERE "+field+" LIKE ? ORDER BY REGDATE DESC) NO) "
				+ "WHERE NUM BETWEEN ? AND ?";*/
		String sql = "SELECT N.* FROM "
				+ " ("
				+ "SELECT (ROW_NUMBER() OVER (ORDER BY REGDATE DESC)) NUM , NOTICES.* "
				+ "FROM NOTICES WHERE "+field+" LIKE ?" + ") N  " + "WHERE N.NUM BETWEEN ? AND ?";
		String url ="jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "sist", "newlec");
			PreparedStatement st = con.prepareStatement(sql);

			
			st.setString(1,"%"+query+"%");
			st.setInt(2, start);
			st.setInt(3, end);
			
			ResultSet rs = st.executeQuery();
			
			List<Notice> list = new ArrayList<Notice>();

			while (rs.next()) {
				Notice n = new Notice();
				n.setCode(rs.getString("CODE"));
				n.setTitle(rs.getString("TITLE"));
				n.setWriter(rs.getString("WRITER"));
				n.setRegdate(rs.getDate("REGDATE"));
				n.setHit(rs.getInt("HIT"));
				n.setContent(rs.getString("CONTENT"));

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
	public List<Notice> getNotices(int page, String query) {
		
		return getNotices(page,query,"TITLE");
		
	}
	

	@Override
	public List<Notice> getNotices(int page) {
		
	
		return getNotices(page,"","TITLE");
		
	}
	
	
	@Override
	public int insert(Notice notice) {
		String sql = "INSERT INTO NOTICES(CODE,TITLE,WRITER,CONTENT,REGDATE,HIT) VALUES(?,?,?,?,GETDATE(),0)";
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
			
			st.setString(1, code );
			st.setString(2, notice.getTitle());
			st.setString(3, notice.getWriter());
			st.setString(4, notice.getContent());

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

	@Override
	public int update(Notice notice) {
		String sql = "UPDATE NOTICES SET TITLE=?,CONTENT=? WHERE CODE=?";
		String url ="jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb";

	
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(url, "sist", "newlec");
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, notice.getTitle());
			st.setString(2, notice.getContent());
			st.setString(3, notice.getCode());

			int result = st.executeUpdate();
			st.close();
			con.close();
			return result;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
  
	@Override
	public int delete(String code) {
		String sql = "DELETE FROM NOTICES WHERE CODE=?";
		String url ="jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
			Connection con = DriverManager.getConnection(url, "sist", "newlec");
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, code);
			
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

	@Override
	public int getSize(String query, String field) {
		String sql="SELECT COUNT(*) CNT FROM NOTICES WHERE "+field+" LIKE ? ";
		String url ="jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	

		Connection con = DriverManager.getConnection(url, "sist", "newlec");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+query+"%");
		ResultSet rs = st.executeQuery();
		rs.next();
		int result=rs.getInt("CNT");
		
		rs.close();
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

	@Override
	public int getSize(String query) {
		return getSize(query,"TITLE");
	}

	@Override
	public String lastCode() {
		
		String sql = "SELECT ISNULL(MAX(CAST(CODE AS INT)),0) CODE FROM NOTICEFILES";
		String url ="jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "sist", "newlec");
			Statement stCode=con.createStatement();
			ResultSet rs=stCode.executeQuery(sql);
			
			rs.next();
			String code=rs.getString("CODE");
			
			rs.close();
			stCode.close();
		
        return code;
    
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
	public Notice getprevNotice(String curcode) {
		String sql = "SELECT TOP 1 * FROM NOTICES"
				+ " WHERE REGDATE > (SELECT REGDATE FROM NOTICES WHERE CODE=?)"
				+ " ORDER BY REGDATE ASC";
        String url ="jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "sist", "newlec");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, curcode);
			ResultSet rs = st.executeQuery();
			
			rs.next();
			Notice n= new Notice();
			n.setCode("code");
	        n.setTitle(rs.getString("TITLE"));
			n.setWriter(rs.getString("WRITER"));
			n.setRegdate(rs.getDate("REGDATE"));
			n.setHit(rs.getInt("HIT"));
			n.setContent(rs.getString("CONTENT"));

			
			  
			rs.close();
			st.close();
			con.close();
		
        return n;
    
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
	public Notice getnextNotice(String curcode) {
		String sql = "SELECT TOP 1 * FROM NOTICES"
				+ "WHERE REGDATE < (SELECT REGDATE FROM NOTICES WHERE CODE=?)"
				+ "ORDER BY REGDATE DESC";
		
String url ="jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "sist", "newlec");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, curcode);
			ResultSet rs = st.executeQuery();
			
			rs.next();
			Notice n= new Notice();
			n.setCode("code");
			n.setTitle(rs.getString("TITLE"));
			n.setWriter(rs.getString("WRITER"));
			n.setRegdate(rs.getDate("REGDATE"));
			n.setHit(rs.getInt("HIT"));
			n.setContent(rs.getString("CONTENT"));

			
			  
			rs.close();
			st.close();
			con.close();
		
        return n;
    
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
