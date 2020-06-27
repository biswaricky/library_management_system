package com.dxc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dxc.pojo.Book;
import com.dxc.pojo.User;

public class AdminDaoImpl implements AdminDao{

	private static Connection conn;
	
	
	static
	{
		try
			{
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "root");
			}catch(Exception e)
			{
				System.out.println(e);
			}
	}
	
	
	@Override
	public boolean login(String name,String password) {
		boolean b=false;
		try {
			PreparedStatement pstmt=conn.prepareStatement("select * from admin");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				if(name.equals(rs.getString(2))&&password.equals(rs.getString(3)))
					b=true;
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public void closeConn()
	{
		if(conn!=null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void createUser(int id, String name, String password, double balance) {
		try {
			PreparedStatement pstmt=conn.prepareStatement("insert into user values(?,?,?,?)");
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, password);
			pstmt.setDouble(4, balance);
			pstmt.execute();
			System.out.println("Successfully One user added");
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addBook(int id, String bName, String auther, int qnt) {
		try {
			PreparedStatement pstmt=conn.prepareStatement("insert into books values(?,?,?,?)");
			pstmt.setInt(1, id);
			pstmt.setString(2, bName);
			pstmt.setString(3, auther);
			pstmt.setInt(4, qnt);
			pstmt.execute();
			System.out.println("Successfully One book added");
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Book> userBookList(int id) {
		int bookId=0;
		List<Book> bpLs=new ArrayList<Book>();
			try 
			{
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery("select * from bookdetails");
				while(rs.next())
				{
					if(id==rs.getInt(1))
					{
						bookId=rs.getInt(2);
					}
				}
				stmt.close();
				Statement stmt2=conn.createStatement();
				ResultSet rs1=stmt2.executeQuery("select * from books");
				while(rs1.next())
				{
					if(bookId==rs1.getInt(1))
					{
						Book bp=new Book(rs1.getInt(1),rs1.getString(2),rs1.getString(3),rs1.getInt(4));
						bpLs.add(bp);
					}
				}
				stmt2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return bpLs;
	}

	@Override
	public void closeConnection() 
	{
		if(conn!=null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	

	@Override
	public double userBalance(int id) {
		double balance=0;
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from user");
			while(rs.next())
			{
				if(id==rs.getInt(1))
				{
					balance=rs.getDouble(4);
				}
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return balance;
	}
	
	

	@Override
	public List<Book> TotalBook() {
		
		List<Book> ls=new ArrayList<Book>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from books");
			while(rs.next())
			{
				Book bookPojo=new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(1));
				ls.add(bookPojo);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ls;
	}

	@Override
	public void deleteUser(int id) {
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement("delete from user where id=?");
			pstmt.setInt(1, id);
			pstmt.execute();
			pstmt.close();
			System.out.println(" user deleted from database");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> getuser() {
		List<User> ls=new ArrayList<User>();
		try {
			
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from user");
			while(rs.next())
			{
				User us=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
				ls.add(us);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ls;
	}
}
