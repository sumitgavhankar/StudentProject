package com.capgemini.service;

import java.util.Scanner;

import com.capgemini.model.Student;

public class Admin {

	private static Scanner sc = new Scanner(System.in);
	private static StudentSchedular studSch = new StudentSchedular();
	private static Student[] studentArray = new Student[100];
	private static int i = 0;

	public static void main(String[] args) {
		showMenu();

	}

	private static void showMenu() {
		int choice;

		while (true) {
			System.out.println("1.add student");
			System.out.println("2.show all students");
			System.out.println("3.Generate report by Roll Number");
			System.out.println("4.Get courses registered by Name");
			System.out.println("5.exit");
			System.out.println("Enter your choice");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				acceptStudentDetails();
				break;
			case 2:
				showAllStudentDetails();
				break;
			case 3:
				generateReportByRollNumber();
				break;
			case 4:
				registeredCoursesByName();
				break;
			case 5:
				System.exit(0);
			}

		}

	}

	private static void registeredCoursesByName() {
		System.out.println("Enter Name for search:");
		String name = sc.next();
		boolean matchFound = false;
		for (int j = 0; j < studentArray.length; j++) {
			if (studentArray[j] != null) {
				String studentName = studentArray[j].getName();
				if (name.equalsIgnoreCase(studentName)) {
					System.out.println("Roll Number : " + studentArray[j].getRollNumber());
					System.out.println("Name : " + studentArray[j].getName());
					System.out.print("Courses : ");
					for (int k = 0; k < studentArray[j].getCourseName().length; k++) {
						System.out.print(studentArray[j].getCourseName()[k]);
						if (k != studentArray[j].getCourseName().length - 1) {
							System.out.print(",");
						}
					}
					System.out.println("\n");
					System.out.println("------------------");
					matchFound = true;
					break;
				}
			}
			if (studentArray[j] != null && !matchFound) {
				System.out.println("No Record Found");
				break;
			}
			if (studentArray[j] == null) {
				System.out.println("No Record Found");
				break;
			}
		}
	}

	private static void generateReportByRollNumber() {
		System.out.println("Enter roll number");
		int rollNumber = sc.nextInt();
		boolean matchFound = false;
		for (int j = 0; j < studentArray.length; j++) {
			if (studentArray[j] != null) {
				int rollNum = studentArray[j].getRollNumber();
				if (rollNumber == rollNum) {
					System.out.println("Roll Number : " + studentArray[j].getRollNumber());
					System.out.println("Name : " + studentArray[j].getName());
					System.out.print("Courses : ");
					for (int k = 0; k < studentArray[j].getCourseName().length; k++) {
						System.out.print(studentArray[j].getCourseName()[k]);
						if (k != studentArray[j].getCourseName().length - 1) {
							System.out.print(",");
						}
					}
					System.out.println("\n");
					System.out.println("--------------");
					matchFound = true;
					break;
				}
			}
			if (studentArray[j] != null && !matchFound) {
				System.out.println("No Record Found");
				break;
			}
			if (studentArray[j] == null) {
				System.out.println("No Record Found");
				break;
			}
		}
	}

	private static void acceptStudentDetails() {
		Student student = new Student();
		System.out.println("Enter roll number");
		int rollNumber = sc.nextInt();
		if(validateRollNumber(rollNumber))
			addStudentIfValidRoll(student, rollNumber);	
	}

	private static void addStudentIfValidRoll(Student student, int rollNumber) {
		System.out.println("Enter name");
		String name = sc.next();
		System.out.println("Enter comma seperated course names");
		String courseName = sc.next();
		String[] courses = courseName.split(",");
		student.setRollNumber(rollNumber);
		student.setName(name);
		student.setCourseName(courses);
		studentArray[i] = student;
		i++;
		System.out.println(studSch.addStudent(rollNumber, name, courses));
	}

	public static boolean validateRollNumber(int inputRollNumber) {
		boolean isvalid = true;

		for (int x = 0; x < studentArray.length-1; x++) {
			if(studentArray[x] != null)
				if (studentArray[x].getRollNumber() == inputRollNumber) {
					System.out.println("Provided roll number is already present in the system.");
					isvalid = false;
				} else
					isvalid = true;
				}
		return isvalid;
	}

	private static void showAllStudentDetails() {
		studSch.showAllStudentDetails(studentArray);
	}

}