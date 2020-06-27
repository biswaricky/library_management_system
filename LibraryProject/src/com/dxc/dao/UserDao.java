package com.dxc.dao;

import java.util.List;
import com.dxc.pojo.Book;

public interface UserDao {

	boolean passwordCheck(String name, String password);
	public void closeConnection();
	public List<Book> getBook();
	public List<Book> getAuther(String autherName);
	void issueBook(int uId, int bId, int day,double balance);
	double getBalance(int userId);
	int getUserId(String name);
	void returnBook(int uId, int bId);
	List<Book> issuedBook(int uId);

}
