package com.model;

import org.hibernate.Session;

import org.hibernate.Transaction;

public class TPCExample {
	public static void main(String[] args) {
		Transaction tx = null;
		try(Session session = HibernateUtil.getSesFactory().openSession()){
			tx=session.beginTransaction();
			Employee e1 = new Employee("Ramesh");
			RegEmployee e2 = new RegEmployee(5500,"sales","Suresh");
			Trainee e3 = new Trainee(200,"6 months","Umesh");
			session.persist(e1); session.persist(e2); session.persist(e3);
			tx.commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
