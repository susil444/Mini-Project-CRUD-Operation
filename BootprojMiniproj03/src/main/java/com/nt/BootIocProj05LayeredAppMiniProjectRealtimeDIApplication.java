package com.nt;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.PayrollOperationsController;
import com.nt.model.Employee;


@SpringBootApplication
public class BootIocProj05LayeredAppMiniProjectRealtimeDIApplication {

  
	public static void main(String[] args) {
		System.out.println("BootIocProj05LayeredAppMiniProjectRealtimeDIApplication.main() (start)");
		//get IOC container
		try(ConfigurableApplicationContext ctx=
				 SpringApplication.run(BootIocProj05LayeredAppMiniProjectRealtimeDIApplication.class, args);
				Scanner sc=new Scanner(System.in);){
			  //get  Controller class obj ref
			PayrollOperationsController  controller=ctx.getBean("controller",PayrollOperationsController.class);
		
			   //==================  gather inputs  for employee registration ===============
			    System.out.println("Enter employee name::");
			    String name=sc.next();
			    System.out.println("Enter employee desg::");
			    String desg=sc.next();
			    System.out.println("Enter employee salary::");
			    float  salary=sc.nextFloat();
			    //create  Employee class obj having inputs
			    Employee  emp1=new Employee(  );
			     //invoke the b.method
			    try {
			    	String msg=controller.registerEmployeeDetails(emp1);
			    	System.out.println(msg);
			    }
			    catch(Exception e) {
			    	System.out.println("Internal Problem --try again");
			    }
			
			  //===================gather inputs for fetching the employee details =============
			   // read inputs from enduser
			   System.out.println("enter desg1::");
			   String desg1=sc.next();
			   System.out.println("enter desg2::");
			   String desg2=sc.next();
			   System.out.println("enter desg3::");
			   String desg3=sc.next();
			 	//invoke the b.method
			try {
				List<Employee> list=controller.getEmployeesByDesgs(desg1,desg2, desg3);
				System.out.println("Employees having "+desg1+"...."+desg2+"...."+desg3);
				list.forEach(emp->{
					System.out.println(emp);
				});
			}
			catch(Exception e) {
				System.out.println("Internal problem -- Try Again ::"+e.getMessage());
				//e.printStackTrace();
			}
			  
			 
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("BootIocProj05LayeredAppMiniProjectRealtimeDIApplication.main() (end)");
		
	}//main

}//class
