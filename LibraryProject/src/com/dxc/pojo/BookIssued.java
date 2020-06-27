package com.dxc.pojo;

public class BookIssued {

	private int uid;
	private int bid;
	private int noofdays;
	private int bookTaken;
	
	
	public BookIssued() {
	}
	public BookIssued(int uid, int bid, int noofdays, int bookTaken) {
		this.uid = uid;
		this.bid = bid;
		this.noofdays = noofdays;
		this.bookTaken = bookTaken;
	}
	public int getuid() {
		return uid;
	}
	public void setuid(int uid) {
		this.uid = uid;
	}
	public int getbid() {
		return bid;
	}
	public void setbid(int bid) {
		this.bid = bid;
	}
	public int getnoofdays() {
		return noofdays;
	}
	public void setnoofdays(int noofdays) {
		this.noofdays = noofdays;
	}
	public int getbookTaken() {
		return bookTaken;
	}
	public void setbookTaken(int bookTaken) {
		this.bookTaken = bookTaken;
	}
	
	
}
