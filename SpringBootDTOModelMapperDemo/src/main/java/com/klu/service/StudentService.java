package com.klu.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.dto.StudentRequestDTO;
import com.klu.dto.StudentResponseDTO;
import com.klu.model.Student;
import com.klu.repo.StudentRepo;

@Service
public class StudentService {
  @Autowired
  private StudentRepo studentRepo;
  @Autowired
  private ModelMapper modelMapper;
  
  //create student
  public StudentResponseDTO addStudent(StudentRequestDTO reqDto) {
    //convert request dto into entity
    Student entity = modelMapper.map(reqDto, Student.class);
    //assign default password in the entity because client won't send it.
    entity.setPassword("klu@123");
    
    //now we need to save entity into DB
    Student saved = studentRepo.save(entity);
    
    //convert saved entity into response dto using mapper
    return modelMapper.map(saved, StudentResponseDTO.class);
  }
  
  //get all students
  public List<StudentResponseDTO> getAllStudents(){
    List<Student> students = studentRepo.findAll();
    return students.stream().map(student -> modelMapper.map(student, StudentResponseDTO.class))
                        .collect(Collectors.toList());
  }
  
  
  //get specific student based on ID
  public StudentResponseDTO getStudentById(Long id) {
    Student s = studentRepo.findById(id).orElseThrow();
    return modelMapper.map(s, StudentResponseDTO.class);
  }
  //update specific student based on ID
  public StudentResponseDTO updateStudent(Long id, StudentRequestDTO reqDto) {
    //implement logic here
    return null;
  }
  
  //delete specific student based on ID
  public String deleteStudent(Long id) {
    studentRepo.findById(id).orElseThrow();
    studentRepo.deleteById(id);
    return "Student Deleted Successfully";
  }
}