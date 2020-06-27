package com.dxc.presentation;

import java.util.List;
import java.util.Scanner;

import com.dxc.pojo.Book;
import com.dxc.service.UserService;
import com.dxc.service.UserServiceImpl;

public class User {

	
	public void userOperation(String name)
	{
		String uName=name;
		Scanner sc=new Scanner(System.in);
		Library lb=new Library();
		UserService ius=new UserServiceImpl();
		int uId=ius.getUserId(uName);
		while(true)
		{
			System.out.println("1.Issue books <-->lib");
			System.out.println("2. books list <-->lib");
			System.out.println("3. list of books<-->unique author");
			System.out.println("4. available balance <-->lib account");
			System.out.println("5.Returned<--->books");
			System.out.println("6.Issued <---->books");
			System.out.println("7.Exit page");
			
			System.out.println("Enter<!!!!!!!!!!>choice");
			int choice=sc.nextInt();
			switch (choice)
			{
			case 1:	
				
				
				System.out.println("Enter book id");
				int bId=sc.nextInt();
				System.out.println("Enter no of day for books you want sir");
				int day=sc.nextInt();
				if(day<=15)
				{
					double balance=day*5;
					ius.issueBook(uId,bId,day,balance);
				}
				else
				{
					System.out.println("Only 15 days allowed");
				}
				
				break;
				
			case 2:
				List<Book> ls=ius.getBook();
				System.out.println();
				for(Book bj:ls)
				{
					bj.display();
				}
				System.out.println();
				break;
				
			case 3:
				System.out.println("Auther name");
				List<Book> ls1=ius.getAuther(sc.next());
				System.out.println();
				for(Book bj:ls1)
				{
					bj.display();
				}
				System.out.println();
				break;
				
			case 4:
				double balance=ius.getBalance(uId);
				System.out.println("balance: "+balance+" ");
				break;
			case 5:
				System.out.println("Enter book id");
				ius.returnBook(uId,sc.nextInt());
				break;
			case 6:
				List<Book> lst=ius.issuedBook(uId);
				for(Book bp1:lst)
				{
					bp1.displayBook();
				}
				break;
			case 7:
				ius.closeConnection();
				System.out.println("see you soon.........!!!!");
				System.exit(0);
				break;
				
			default:
				System.out.println("give correct one");
				break;
			}
		}
	}
}
