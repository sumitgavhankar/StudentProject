package com.capgemini.service;

import com.capgemini.model.Student;

public class StudentSchedular {
	
	private Student[] students = new Student[10];
	private int counterStudent;
	
	public String addStudent(int rollNumber,String name,String[] courseName)
	{
		students[counterStudent++]=new Student(rollNumber,name,courseName);
		
		return "Student added successfully";
	}
	
	public void showAllStudentDetails(Student[] student)
	{
			System.out.println("Student Details Are: ");
			for(int i=0; i< student.length; i++){
				if(student[i] !=null){
					System.out.println(student[i].getRollNumber() +"  "+ student[i].getName()+ " " +"\n");
					System.out.println("Opted courses:");
					for(int j=0; j< student[i].getCourseName().length;j++){
						System.out.println(student[i].getCourseName()[j] +"\n");
						
					}
				}
		}
		
	}

}
