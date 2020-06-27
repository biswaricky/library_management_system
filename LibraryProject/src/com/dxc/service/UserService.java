package com.dxc.service;

import java.util.List;
import com.dxc.pojo.Book;

public interface UserService {

	boolean PasswordCheck(String name, String password);

	public List<Book> getBook();

	public List<Book> getAuther(String autherName);

	public void issueBook(int uId, int bId, int day,double balance);

	public double getBalance(int userId);

	public void closeConnection();

	public int getUserId(String name);

	void returnBook(int uId, int bId);

	List<Book> issuedBook(int uId);

}
