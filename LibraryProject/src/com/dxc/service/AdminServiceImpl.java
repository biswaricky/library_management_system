package com.dxc.service;

import java.util.List;

import com.dxc.dao.*;
import com.dxc.pojo.Book;
import com.dxc.pojo.User;

public class AdminServiceImpl implements AdminService {
	
	AdminDao aDao=new AdminDaoImpl();
	
	@Override
	public boolean login(String name,String password) {
		return aDao.login(name,password);
	}

	@Override
	public void createUser(int id, String name, String password, double balance) {
		aDao.createUser(id,name,password,balance);
	}

	@Override
	public void addBook(int id, String bName, String auther, int qnt) {
		aDao.addBook(id,bName,auther,qnt);
	}

	@Override
	public List<Book> userBookList(int id) {
	
		return aDao.userBookList(id);
	}

	@Override
	public double userBalance(int id) {
		return aDao.userBalance(id);
	}

	@Override
	public List<Book> TotalBook() {
		return aDao.TotalBook();
	}

	@Override
	public void closeConnection() {
		aDao.closeConnection();
	}

	@Override
	public void deleteUser(int id) {
		aDao.deleteUser(id);
	}

	@Override
	public List<User> getuser() {
		return aDao.getuser();
	}

}
