//Employee.java
package com.nt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Employee {
	private  Integer  eid;
	@NonNull
	private  String  ename;
	@NonNull
	private  String   desg;
	@NonNull
	private   Float salary;
	
	private Float grossSalary;
	private   Float  netSalary;
}