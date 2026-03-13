
package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.dto.StudentRequestDTO;
import com.klu.dto.StudentResponseDTO;
import com.klu.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/stud")
public class StudentController {
  @Autowired
  private StudentService studentService;
  
  //add student
  @PostMapping("/addStudent")
  public ResponseEntity<StudentResponseDTO> addStudent(@Valid @RequestBody StudentRequestDTO reqDto){
    return new ResponseEntity<>(studentService.addStudent(reqDto),HttpStatus.CREATED);
  }
  
  //get all students
  @GetMapping("/getAllStudents")
  public ResponseEntity<List<StudentResponseDTO>> getAllStudents(){
    return ResponseEntity.ok(studentService.getAllStudents());
  }
  
  //get specific student
  @GetMapping("/getStudent/{id}")
  public ResponseEntity<StudentResponseDTO> getStudent(@PathVariable Long id){
    return ResponseEntity.ok(studentService.getStudentById(id));
  }
  
  //update student based on specific ID
  @PutMapping("/updateStudent/{id}")
  public ResponseEntity<StudentResponseDTO> updateStudent(@PathVariable Long id, @Valid @RequestBody StudentRequestDTO reqDto){
    //implement logic here
    return null;
  }
  
  //delete student by id
  @DeleteMapping("/deleteStudent/{id}")
  public ResponseEntity<String> deleteStudent(@PathVariable Long id){
    return ResponseEntity.ok(studentService.deleteStudent(id));
  }
}