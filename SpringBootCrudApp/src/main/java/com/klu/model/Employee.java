
package com.klu.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "emp")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String email;
  private double sal;
  public Employee() {
    // TODO Auto-generated constructor stub
  }
  
  public Employee(String name, String email, double sal) {
    super();
    this.name = name;
    this.email = email;
    this.sal = sal;
  }

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public double getSal() {
    return sal;
  }
  public void setSal(double sal) {
    this.sal = sal;
  }
  @Override
  public String toString() {
    return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", sal=" + sal + "]";
  }
}