package com.dxc.pojo;

public class Book {

	private int id;
	private String bookname;
	private String auther;
	private int quantity;
	
	public Book() {
	}

	public Book(int id, String bookname, String auther, int quantity) {
		this.id = id;
		this.bookname = bookname;
		this.auther = auther;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getbookname() {
		return bookname;
	}

	public void setbookname(String bookname) {
		this.bookname = bookname;
	}

	public String getauther() {
		return auther;
	}

	public void setauther(String auther) {
		this.auther = auther;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void display()
	{
		System.out.println(id+" "+bookname+" "+ auther+" "+ quantity);
	}

	public void displayBook() {
		System.out.println("\n"+id+" "+bookname+" "+auther+" \n");
	}
	
	
	
	
}
