package com.hibernate.curd.client;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.hibernate.curd.common.HibernateUtility;
import com.hibernate.curd.model.EmpUserDetailsVo;

public class HibernateCurdClient {

	public static void main(String[] args) {

		
		Session session =HibernateUtility.getSessionFactory().openSession();
		
		session.beginTransaction();
		/*int j=0;
		for (int i = 0; i < 10; i++) {
			EmpUserDetailsVo empUserDto = new EmpUserDetailsVo();
			empUserDto.setEmpUserName("Tharapathi "+ ++j);
			session.save(empUserDto);
		}*/
		
		/*Query query = session.createQuery("from EmpUserDetailsVo");
		query.setFirstResult(5);
		  query.setMaxResults(4);
		List<EmpUserDetailsVo> listEmpUsers = query.list();
		
		
		System.out.println(listEmpUsers.size());
		session.getTransaction().commit();
		
		session.close();
		
		System.out.println();
		Iterator< EmpUserDetailsVo> itrlistEmpUsers = listEmpUsers.iterator();
		while(itrlistEmpUsers.hasNext()){
			EmpUserDetailsVo detailsVos =  itrlistEmpUsers.next();
			System.out.println(detailsVos.getEmpUserId() +"--------"+detailsVos.getEmpUserName());
		}
		System.out.println("Named Query Test............");
		session =HibernateUtility.getSessionFactory().openSession();
		session.beginTransaction();
		Query query1 = session.getNamedQuery("EmpUserDetailsVo.byId");
		query1.setInteger(0, 5);
		List<EmpUserDetailsVo> listEmpUsers1 = query1.list();
		
		System.out.println(listEmpUsers1.size());
		for (EmpUserDetailsVo empUserDetailsVo : listEmpUsers1) {
			System.out.println(empUserDetailsVo.getEmpUserId() +"--------"+empUserDetailsVo.getEmpUserName());
		}
		System.out.println();*/
		
		Criteria criteria = session.createCriteria(EmpUserDetailsVo.class).addOrder(Order.desc("empUserId"));
//		Criteria criteria = session.createCriteria(EmpUserDetailsVo.class);
//		criteria.add(Restrictions.eq("empUserName", "tharapathi 5"));
//		criteria.add(Restrictions.gt("empUserId", 5));
//		criteria.add(Restrictions.like("empUserName", "%tharapathi 4%"));
//		criteria.add(Restrictions.between("empUserId", 2, 6));
		
		List<EmpUserDetailsVo> criteriaList = criteria.list();
		for (EmpUserDetailsVo empUserDetailsVo : criteriaList) {
			System.out.println(empUserDetailsVo.getEmpUserId() +"--------"+empUserDetailsVo.getEmpUserName());
		}
		
		session.getTransaction().commit();
		session.close();
	}

}
