package com.jspiders.demobankingapp;

import java.util.Scanner;

import com.jspiders.demobankingapp.bussiness.UserBusiness;

public class App {

	public static void main(String[] args) {
		
		UserBusiness userBusiness = new UserBusiness();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 1 to create an account : ");
		System.out.println("Enter 2 to login : ");
		System.out.println("Enter your choice");
		
		int choice = scanner.nextInt();
		boolean run = true;
		
		while(run)
		{
			switch(choice) {
			case 1: {
				userBusiness.createAccount();
				
				break;
			}
			case 2:{
				userBusiness.logIn();
				
				break;
			}
			case 3:{
				run = false;
				System.out.println("Thank You");
				break; 
			}
			default:{
				System.out.println("invalid choice ");
				
			}
			}
		}
		
		
	}
}
