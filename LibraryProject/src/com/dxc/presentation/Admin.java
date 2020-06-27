package com.dxc.presentation;

import java.util.List;
import java.util.Scanner;

import com.dxc.pojo.Book;
import com.dxc.pojo.User;
import com.dxc.service.AdminService;
import com.dxc.service.AdminServiceImpl;

public class Admin {

	public void adminOperation()
	{
		Scanner sc=new Scanner(System.in);
		
		AdminService is=new AdminServiceImpl();
		
		
		while(true) 
		{
			System.out.println("1.create user");
			System.out.println("2.Add books");
			System.out.println("3.get books list  by unique user");
			System.out.println("4.get balance  of unique user");
			System.out.println("5.get total books");
			System.out.println("6.get total users");
			System.out.println("7.Delete user from library");
			System.out.println("8.exit page");
			
			System.out.println("Select your choice... :)");
			int choice=sc.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.println("Enter user id,name & password ");
				double balance=5000.0;
				is.createUser(sc.nextInt(),sc.next(),sc.next(),balance);
				break;
			case 2:
				System.out.println("Enter book id,book name,auther name & quantity");
				is.addBook(sc.nextInt(), sc.next(), sc.next(), sc.nextInt());
				break;
			case 3:
				System.out.println("Enter user id");
				List<Book> ls=is.userBookList(sc.nextInt());
				System.out.println();
				for(Book bp:ls)
				{
					bp.display();
				}
				System.out.println();
				break;
			case 4:
				System.out.println("Enter user id");
				double balance1=is.userBalance(sc.nextInt());
				System.out.println("balance : "+balance1+" ");
				break;
			case 5:
				List<Book> ls2=is.TotalBook();
				System.out.println();
				for(Book bp:ls2)
				{
					bp.display();
				}
				System.out.println();
				break;
			case 6:
				List<User> userLs=is.getuser();
				System.out.println();
				for(User up:userLs)
				{
					up.display();
				}
				System.out.println();
				break;
			case 7:
				System.out.println("Enter user id");
				is.deleteUser(sc.nextInt());
				break;
			case 8:
				is.closeConnection();
				System.out.println("bye bye boss..");
				System.exit(0);
				break;
			default:
				System.out.println("Wrong give correct one");
				break;
			}
		}
	}

}
