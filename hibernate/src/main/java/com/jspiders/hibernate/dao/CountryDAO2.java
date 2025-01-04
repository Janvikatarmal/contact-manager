package com.jspiders.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.Country;
import com.jspiders.hibernate.dto.State;

public class CountryDAO2 {
private static EntityManagerFactory entityManagerFactory;
private static EntityManager entityManager;
private static EntityTransaction entityTransaction;


public static void main(String[] args) {
	openConnection();
	State state = entityManager.find(State.class, 2);
	if (state != null) {
		entityTransaction.begin();
		entityManager.remove(state);
		entityTransaction.commit();
	} else
		System.out.println("State not found");
	closeConnection();
	
	
}
private static void openConnection() {
	entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
	entityManager = entityManagerFactory.createEntityManager();
	entityTransaction = entityManager.getTransaction();
	
}
private static void closeConnection() {
	if(entityManager!=null)
		entityManagerFactory.close();
	if(entityManager!=null)
		entityManager.close();
	if(entityTransaction!=null)
		if(entityTransaction.isActive())
			entityTransaction.rollback();
	
}
}
