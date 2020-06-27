package com.dxc.service;

import java.util.List;

import com.dxc.dao.UserDao;
import com.dxc.dao.UserDaoImpl;
import com.dxc.pojo.Book;

public class UserServiceImpl implements UserService {

	UserDao dao=new UserDaoImpl();
	@Override
	public boolean PasswordCheck(String name, String password) {
		return dao.passwordCheck(name,password);
	}
	@Override
	public List<Book> getBook() {
		return dao.getBook();
	}
	@Override
	public List<Book> getAuther(String autherName) {
		return dao.getAuther(autherName);
	}
	@Override
	public void issueBook(int uId, int bId, int day,double balance) {

		dao.issueBook(uId,bId,day,balance);
	}
	@Override
	public double getBalance(int userId) {
		return dao.getBalance(userId);
	}
	@Override
	public void closeConnection() {
		dao.closeConnection();
	}
	@Override
	public int getUserId(String name) {
		return dao.getUserId(name);
	}
	@Override
	public void returnBook(int uId, int bId) {
		dao.returnBook(uId,bId);
	}
	@Override
	public List<Book> issuedBook(int uId) {
		return dao.issuedBook(uId);
	}
}
