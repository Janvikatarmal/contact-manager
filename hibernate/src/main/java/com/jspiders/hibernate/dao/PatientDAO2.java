package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.DNAReport;
import com.jspiders.hibernate.dto.Patient;

public class PatientDAO2 { 
	private static EntityManagerFactory entiyManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	
	public static void main(String[] args) {
		openConnection();
		Patient patient = entityManager.find(Patient.class, 1);
		if(patient !=null)
		{
			entityTransaction.begin();
			entityManager.remove(patient);
			entityTransaction.commit();
			DNAReport dnaReport = patient.getDnaReport();
			entityTransaction.begin();
			entityManager.remove(dnaReport);
			entityTransaction.commit();
		}
		else
			System.out.println("patient not found ");
		
		
	}
private static void openConnection() {
	entiyManagerFactory= Persistence.createEntityManagerFactory("hibernate");
	entityManager = entiyManagerFactory.createEntityManager();
	entityTransaction = entityManager.getTransaction();

}
private static void closeConnection() {
	if(entiyManagerFactory !=null)
		entityManager.close();
	if(entityManager !=null)
		entityManager.close();
	if (entityTransaction != null) {
		if (entityTransaction.isActive())
			entityTransaction.rollback();
	}
	
}
}

