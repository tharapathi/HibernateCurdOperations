package com.hibernate.curd.client;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import com.hibernate.curd.common.HibernateUtility;
import com.hibernate.curd.model.EmpUserDetailsVo;

public class HibernateProjectionClient {

	public static void main(String[] args) {
		Session session =HibernateUtility.getSessionFactory().openSession();

		
		EmpUserDetailsVo emp = new EmpUserDetailsVo();
//		emp.setEmpUserId(6);
//		emp.setEmpUserName("tharapathi 6");
		Example example = Example.create(emp);
		session.beginTransaction();

/*       Criteria criteria = session.createCriteria(EmpUserDetailsVo.class)
    		             .setProjection(Projections.property("empUserName"));*/
		Criteria criteria = session.createCriteria(EmpUserDetailsVo.class).add(example);
		List<EmpUserDetailsVo> criteriaList = criteria.list();
		for (EmpUserDetailsVo empUserDetailsVo : criteriaList) {
			System.out.println(empUserDetailsVo.getEmpUserId() +"--------"+empUserDetailsVo.getEmpUserName());
		}
//		System.out.println(criteriaList);
		/*
		 * List<EmpUserDetailsVo> criteriaList = criteria.list();
		for (EmpUserDetailsVo empUserDetailsVo : criteriaList) {
			System.out.println(empUserDetailsVo.getEmpUserId() +"--------"+empUserDetailsVo.getEmpUserName());
		}
*/
		session.getTransaction().commit();
		session.close();
	}

}
