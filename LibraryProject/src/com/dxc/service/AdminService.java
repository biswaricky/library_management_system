package com.dxc.service;

import java.util.List;

import com.dxc.pojo.Book;
import com.dxc.pojo.User;

public interface AdminService {
	public boolean login(String name,String password);

	public void createUser(int id, String name, String password, double balance);
	public void addBook(int id,String bName,String auther,int qnt);

	public List<Book> userBookList(int id);

	public double userBalance(int id);

	public List<Book> TotalBook();

	public void closeConnection();

	public void deleteUser(int id);

	public List<User> getuser();

}
