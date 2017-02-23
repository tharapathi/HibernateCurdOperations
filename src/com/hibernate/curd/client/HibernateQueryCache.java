package com.hibernate.curd.client;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.classic.Session;

import com.hibernate.curd.common.HibernateUtility;

public class HibernateQueryCache {

	public static void main(String[] args) {

		Session session = HibernateUtility.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		Query query = session.createQuery("from EmpUserDetailsVo user").setCacheable(true);
		
		List listQuery = query.list();
		session.getTransaction().commit();
		session.close();
		
		Session session2 = HibernateUtility.getSessionFactory().openSession();
		session2.beginTransaction();
		Query query2 = session2.createQuery("from EmpUserDetailsVo user").setCacheable(true);
		
		List listQuery2 = query2.list();
		
		System.out.println(listQuery2);
		session2.getTransaction().commit();
		session2.close();
		
		
	}

}
