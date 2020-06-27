package com.dxc.presentation;

import java.util.Scanner;

import com.dxc.service.AdminService;
import com.dxc.service.AdminServiceImpl;
import com.dxc.service.UserService;
import com.dxc.service.UserServiceImpl;

public class Library {
	
	public static void main(String[] args) {
		
		AdminService ias=new AdminServiceImpl();
		UserService ius=new UserServiceImpl();
		User user=new User();
		Admin admin=new Admin();
		
		
		while(true) {
			
			Scanner sc=new Scanner(System.in);
			System.out.println("1.Admin");
			System.out.println("2.User");
			System.out.println("Choose your choice");
			int choice=sc.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.println("Enter your name & password");
				String name=sc.next();
				String password=sc.next();
				boolean b1=ias.login(name, password);
				if(b1==true)
				{
					System.out.println(" "+name+" Successfully login");
					admin.adminOperation();
				}else
					System.out.println("name & password incorrect");
				break;
				
				
			case 2:
				System.out.println("Enter your name & password");
				String name2=sc.next();
				boolean b2=ius.PasswordCheck(name2, sc.next());
				if(b2==true)
				{
					System.out.println("Hi "+name2+" ");
					user.userOperation(name2);
				}else
					System.out.println("name & password incorrect");
				break;
				
				
			default:
				System.out.println("Enter Correct Choice...");
			}
		}
	}

}
