//PayrollOperationsController.java
package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller("controller")
public class PayrollOperationsController {
	@Autowired
	private  IEmployeeMgmtService  empService;
	
	public    List<Employee>   getEmployeesByDesgs(String desg1,String desg2,String desg3 ) throws Exception{
		System.out.println("PayrollOperationsController.getEmployeesByDesgs()");
		 //use service
		List<Employee>  list=empService.fetchEmployeesByDesgs(desg1, desg2, desg3);
		return list;
	}
	
	public   String     registerEmployeeDetails(Employee emp)throws Exception {
		System.out.println("PayrollOperationsController.registerEmployeeDetails()");
		//use service
		String msg=empService.registerEmployee(emp);
		return msg;
	}

}
