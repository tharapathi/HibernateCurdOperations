package com.hibernate.curd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NamedQuery;

@Entity
//@Cachable
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
@NamedQuery(name ="EmpUserDetailsVo.byId", query = "from EmpUserDetailsVo where empUserId = ?")
@org.hibernate.annotations.Entity(selectBeforeUpdate = true)
@Table(name="EMP_USER_DETAILS")
public class EmpUserDetailsVo {
	
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int empUserId;
	private String empUserName;
	
	
	public EmpUserDetailsVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EmpUserDetailsVo(int empUserId, String empUserName) {
		super();
		this.empUserId = empUserId;
		this.empUserName = empUserName;
	}
	public int getEmpUserId() {
		return empUserId;
	}
	public void setEmpUserId(int empUserId) {
		this.empUserId = empUserId;
	}
	public String getEmpUserName() {
		return empUserName;
	}
	public void setEmpUserName(String empUserName) {
		this.empUserName = empUserName;
	}
	
	

}
