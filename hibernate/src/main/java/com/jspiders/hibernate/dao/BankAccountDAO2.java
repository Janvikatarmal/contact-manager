package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.BankAccount;
import com.jspiders.hibernate.dto.BankAccountHolder;

public class BankAccountDAO2 {
	private static EntityManagerFactory entityMangerFactory;
	private static EntityManager entityManager;
	
	
	public static void main(String[] args) {
		openConnection();
		BankAccount bankAccount = entityManager.find(BankAccount.class,1);
		if(bankAccount !=null) {
			System.out.println(bankAccount);
			BankAccountHolder bankAccountHolder = bankAccount.getBankAccountHolder();
			System.out.println(bankAccountHolder);
			
		}else
			System.out.println("Invalid BankAccount");
		closeConnection();
	}
private static void openConnection() {
	entityMangerFactory = Persistence.createEntityManagerFactory("hibernate");
	entityManager = entityMangerFactory.createEntityManager();
	
}
private static void closeConnection() {
	if(entityMangerFactory!=null)
		entityMangerFactory.close();
	if(entityManager!=null)
		entityManager.close();
		
	
}
}
