package com.studentmanagement;

public class Student {
	int id;
	String name;
	int age;
	String course;
public  Student(int id,String name,int age,String course) {
	this.id=id;
	this.name=name;
	this.age=age;
	this.course=course;
}
public void displayStudentDetails(){
	System.out.println("Student id = "+id);
	System.out.println("Student name = "+name);
	System.out.println("Student age = "+age);
	System.out.println("Student course = "+course);
}
}
