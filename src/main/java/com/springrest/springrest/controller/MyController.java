package com.springrest.springrest.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Studnet;
import com.springrest.springrest.repository.StudentRepository;
import com.springrest.springrest.services.StudentServiceimpl;




@RestController
public class MyController {
	
	
	@Autowired
	private StudentServiceimpl studnetservice;
	
	
	@RequestMapping ("/studnet")
	public List<Studnet> getstudnet()
	{
		return studnetservice.getStudnet();
		
		
	}
	
	@RequestMapping (method = RequestMethod.POST, value="/studnet")
	public ResponseEntity<?> createStudent(@RequestBody Studnet studnet)
	{
        if (studnet.getId() != null) {
            return ResponseEntity.badRequest().body("Id should not be provided");
        }
        if (studnet.getFirstName() == null || studnet.getFirstName().length() < 3) {
            return ResponseEntity.badRequest().body("First name should be at least 3 characters");
        }
        if (studnet.getLastName() == null || studnet.getLastName().length() < 3) {
            return ResponseEntity.badRequest().body("Last name should be at least 3 characters");
        }
        if (studnet.getDob() == null) {
            return ResponseEntity.badRequest().body("DOB is mandatory");
        }
        LocalDate today = LocalDate.now();
        Period age = Period.between(studnet.getDob(), today);
        if (age.getYears() <= 15 || age.getYears() > 20) {
            return ResponseEntity.badRequest().body("Age should be greater than 15 and less than or equal to 20 years");
        }
        if (studnet.getMarks1() != null && (studnet.getMarks1() < 0 || studnet.getMarks1() > 100)) {
            return ResponseEntity.badRequest().body("Marks 1 should be between 0 and 100");
        }
        if (studnet.getMarks2() != null && (studnet.getMarks2() < 0 || studnet.getMarks2() > 100)) {
            return ResponseEntity.badRequest().body("Marks 2 should be between 0 and 100");
        }
        if (studnet.getMarks3() != null && (studnet.getMarks3() < 0 || studnet.getMarks3() > 100)) {
            return ResponseEntity.badRequest().body("Marks 3 should be between 0 and 100");
        }
        if (!Arrays.asList("A", "B", "C").contains(studnet.getSection())) {
            return ResponseEntity.badRequest().body("Invalid section");
        }
        if (!Arrays.asList("M", "F").contains(studnet.getGender())) {
            return ResponseEntity.badRequest().body("Invalid gender");
        }
        if ((studnet.getMarks1() == null || studnet.getMarks1() < 35) ||
            (studnet.getMarks2() == null || studnet.getMarks2() < 35) ||
            (studnet.getMarks3() == null || studnet.getMarks3() < 35)) {
            studnet.setResult("FAIL");
        } else {
            studnet.setResult("PASS");
        }
        if (studnet.getMarks1() == null) studnet.setMarks1(0);
        if (studnet.getMarks2() == null) studnet.setMarks2(0);
        if (studnet.getMarks3() == null) studnet.setMarks3(0);
        studnet.setTotal(studnet.getMarks1() + studnet.getMarks2() + studnet.getMarks3());
        studnet.setAverage(studnet.getTotal() / 3.0);

        Studnet savedstudnet = StudentRepository.save(studnet);
        return ResponseEntity.ok(savedstudnet);
		studnetservice.addstudnet(studnet);
	}
	
	@RequestMapping (method = RequestMethod.PUT, value="/studnet/{id}/marks")
	public ResponseEntity<String> updatestudnet(@PathVariable String id, @RequestParam(required = true) Double marks1,
	        @RequestParam(required = true) Double marks2,
	        @RequestParam(required = true) Double marks3 @RequestBody Studnet studnet)
	
		{
		 // Fetch the student from the database
            Optional<Student> optionalStudent = studentRepository.findById(id);
            
            // Check if the student exists
            if (optionalStudent.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            
            Student student = optionalStudent.get();
            
            // Validate the marks
            if (marks1 < 0 || marks1 > 100 || marks2 < 0 || marks2 > 100 || marks3 < 0 || marks3 > 100) {
                return ResponseEntity.badRequest().body("Marks should be between 0 and 100");
            }
            
            // Update the student's marks
            student.setMarks1(marks1);
            student.setMarks2(marks2);
            student.setMarks3(marks3);
            
            // Calculate the total, average and result
            double total = marks1 + marks2 + marks3;
            double average = total / 3;
            String result = "Pass";
            
            if (marks1 < 35 || marks2 < 35 || marks3 < 35) {
                result = "Fail";
            }
            
            student.setTotal(total);
            student.setAverage(average);
            student.setResult(result);
            
            // Save the updated student to the database
            StudentRepository.save(student);
            
            return ResponseEntity.ok("Marks updated successfully");
        
		
		
		studnetservice.updatestudnet(id, studnet);
	}


