package com.springrest.springrest.entities;

import java.time.LocalDate;

public class Studnet {
	
	
	private String id;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private int age;
	private String gender;
	private String section;
	private int Marks1;
	private int Marks2;
	private int Marks3;
	private int totalMarks;
	private double averageMarks;
	private String result;
	
	public Studnet(String id, String firstName, String lastName, LocalDate dob, int age, String gender, String section,
			int mathMarks, int scienceMarks, int englishMarks, int totalMarks, double averageMarks, String result) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.age = age;
		this.gender = gender;
		this.section = section;
		this.Marks1 = Marks1;
		this.Marks2 = Marks2;
		this.Marks3 = Marks3;
		this.totalMarks = totalMarks;
		this.averageMarks = averageMarks;
		this.result = result;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public int getMarks1() {
		return Marks1;
	}
	public void setMarks1(int mathMarks) {
		this.Marks1 = mathMarks;
	}
	public int getMarks2() {
		return Marks2;
	}
	public void setMarks2(int scienceMarks) {
		this.Marks2 = scienceMarks;
	}
	public int getMarks3() {
		return Marks3;
	}
	public void setMarks3(int englishMarks) {
		this.Marks3 = englishMarks;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	public double getAverageMarks() {
		return averageMarks;
	}
	public void setAverageMarks(double averageMarks) {
		this.averageMarks = averageMarks;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Studnet() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Studnet [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", age="
				+ age + ", gender=" + gender + ", section=" + section + ", mathMarks=" + Marks1 + ", scienceMarks="
				+ Marks3 + ", englishMarks=" + Marks2 + ", totalMarks=" + totalMarks + ", averageMarks="
				+ averageMarks + ", result=" + result + "]";
	}
	

}
