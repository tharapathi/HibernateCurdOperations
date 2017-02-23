package com.hibernate.curd.client;

import org.hibernate.classic.Session;

import com.hibernate.curd.common.HibernateUtility;
import com.hibernate.curd.model.EmpUserDetailsVo;

public class HibernateSecondLevelCache {

	public static void main(String[] args) {

		Session session = HibernateUtility.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		EmpUserDetailsVo empUser1 = (EmpUserDetailsVo) session.get(EmpUserDetailsVo.class, 4);
//		empUser1.setEmpUserName("tharapathi 4");
//		session.save(empUser1);
		
		session.getTransaction().commit();
		session.close();
		
		Session session2 = HibernateUtility.getSessionFactory().openSession();
		session2.beginTransaction();
		EmpUserDetailsVo empUser2 = (EmpUserDetailsVo) session2.get(EmpUserDetailsVo.class, 4);
		System.out.println(empUser2.getEmpUserName());
		session2.getTransaction().commit();
		session2.close();
		
		
	}

}
