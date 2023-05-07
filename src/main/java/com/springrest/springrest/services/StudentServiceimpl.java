package com.springrest.springrest.services;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Studnet;
import com.springrest.springrest.repository.StudentRepository;

@Service
public class StudentServiceimpl  {
	
	@Autowired	
	public StudentRepository studentRepo;
	
	
		public List<Studnet> getStudnet()
	{
			List<Studnet> students = new ArrayList<>();
			studentRepo.findAll().forEach(students::add); 
			return students;
	}


		public void addStudent(Studnet studnet) {
			studentRepo.save(studnet);
			
		}


		public void updateStudent(String id, Studnet studnet) {
			studentRepo.save(studnet);
			
		}
		
		
		
	}

