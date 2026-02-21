//EmployeeMgmtServiceImpl.java
package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeDAO empDAO;

	@Override
	public List<Employee> fetchEmployeesByDesgs(String desg1, String desg2, String desg3)throws Exception {
		System.out.println("EmployeeMgmtServiceImpl.fetchEmployeesByDesgs()");
		 //convert given desgs into upercase letters  (b.logic)
		desg1=desg1.toUpperCase();
		desg2=desg2.toUpperCase();
		desg3=desg3.toUpperCase();
		
		// use DAO
		List<Employee> list=empDAO.showEmployeesByDesgs(desg1, desg2, desg3);
		//calculate grossSalary and netSalary (b.logic)
		list.forEach(emp->{
			emp.setGrossSalary(emp.getSalary()+emp.getSalary()*0.2f);
			emp.setNetSalary(emp.getGrossSalary()-emp.getGrossSalary()*0.1f);
		});
		return list;
	}

	@Override
	public String registerEmployee(Employee emp) throws Exception {
		System.out.println("EmployeeMgmtServiceImpl.registerEmployee()");
		//convert the given desg to upper case letters  (b.logic)
		  emp.setDesg(emp.getDesg().toUpperCase());
		//use DAO
		int count=empDAO.insertEmployee(emp);
		return count==0?"Employee registration failed":"Employee registered successfully";
	}

}
