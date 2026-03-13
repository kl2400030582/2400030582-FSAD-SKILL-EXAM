
package com.klu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.exception.ResourceNotFoundException;
import com.klu.model.Employee;
import com.klu.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
  
  @Autowired
  private EmployeeRepo employeeRepo;

  @Override
  public Employee saveEmployee(Employee e) {
    // TODO Auto-generated method stub
    return employeeRepo.save(e);
  }

  @Override
  public List<Employee> getEmployees() {
    // TODO Auto-generated method stub
    return employeeRepo.findAll();
  }

  @Override
  public Employee getEmployee(Long id) {
    // TODO Auto-generated method stub
//    Optional<Employee> opt = employeeRepo.findById(id);
//    if(opt.isPresent())
//      return opt.get();
//    return null;
             //or
    return employeeRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Employee Not Found with ID:" + id));
  }

  @Override
  public Employee updateEmployee(Long id, Employee e) {
    // TODO Auto-generated method stub
    Employee exist = employeeRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Employee Not Found with ID:" + id));
    exist.setName(e.getName());
    exist.setEmail(e.getEmail());
    exist.setSal(e.getSal());
    employeeRepo.save(exist);
    
    return exist;
  }

  @Override
  public String deleteEmployee(Long id) {
    // TODO Auto-generated method stub
    employeeRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Employee Not Found with ID:" + id));
    employeeRepo.deleteById(id);
    return "Employee Deleted Successfully";
  }

}