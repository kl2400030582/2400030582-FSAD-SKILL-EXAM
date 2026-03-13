
package com.klu.service;

import java.util.List;

import com.klu.model.Employee;

public interface EmployeeService {
  //store employee info into db
  Employee saveEmployee(Employee e);
  //retrieve all employees info from db
  List<Employee> getEmployees();
  //retrieve specific employee info from db based on id
  Employee getEmployee(Long id);
  //update specific employee info into db based on id and new emp data
  Employee updateEmployee(Long id,Employee e);
  //delete specific employee info from db based on id
  String deleteEmployee(Long id);
}