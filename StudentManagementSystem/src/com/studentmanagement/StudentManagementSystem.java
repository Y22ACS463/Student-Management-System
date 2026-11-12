
package com.studentmanagement;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class StudentManagementSystem {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Exit");
            System.out.println("Enter your choice:");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    // ADD STUDENT

                    System.out.println("Enter number of students:");
                    int num = sc.nextInt();
                    for (int i = 1; i <= num; i++) {
                        System.out.println("Student " + i);
                        System.out.println("Enter Student ID:");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter Student name:");
                        String name = sc.nextLine();
                        System.out.println("Enter Student age:");
                        int age = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter Student course:");
                        String course = sc.nextLine();
                        Student s1 = new Student(id, name, age, course);
                        students.add(s1);
                    }
                    System.out.println("Students added successfully!");
                    break;
                case 2:
                    // DISPLAY STUDENTS
                    if (students.isEmpty()) {
                        System.out.println("No students available.");
                    } else {
                        for (Student s : students) {
                            s.displayStudentDetails();
                            System.out.println("======================");
                        }
                    }
                    break;
                case 3:
                    // SEARCH STUDENT
                    System.out.println("Enter student ID to search:");
                    int searchId = sc.nextInt();
                    boolean found = false;
                    for (Student s : students) {
                        if (s.id == searchId) {
                            found = true;
                            s.displayStudentDetails();
                        }
                    }

                    if (!found) {
                        System.out.println("Student ID not found.");
                    }
                    break;
                case 4:
                    // DELETE STUDENT
                    System.out.println("Enter student ID to delete:");
                    int deleteId = sc.nextInt();
                    boolean deleted = false;
                    Iterator<Student> it = students.iterator();
                    while (it.hasNext()) {
                        Student s = it.next();
                        if (s.id == deleteId) {
                            it.remove();
                            deleted = true;
                            break;
                        }
                    }
                    if (deleted) {
                        System.out.println("Student deleted successfully!");
                    } else {
                        System.out.println("Student ID not found!");
                    }
                    break;
                case 5:
                    // UPDATE STUDENT DETAILS
                    System.out.println("Enter student ID to update:");
                    int updateId = sc.nextInt();
                    Student studentToUpdate = null;
                    for (Student s : students) {
                        if (s.id == updateId) {
                            studentToUpdate = s;
                            break;
                        }
                    }
                    if (studentToUpdate == null) {
                        System.out.println("Student ID not found!");
                    } else {
                        int updateChoice;
                        do {
                            System.out.println("\n===== UPDATE STUDENT DETAILS =====");
                            System.out.println("1. Update Name");
                            System.out.println("2. Update Age");
                            System.out.println("3. Update Course");
                            System.out.println("4. Back to Main Menu");
                            System.out.println("Enter your choice:");
                            updateChoice = sc.nextInt();
                            sc.nextLine();
                            switch (updateChoice) {
                                case 1:
                                    System.out.println("Enter new student name:");
                                    studentToUpdate.name = sc.nextLine();
                                    System.out.println("Name updated successfully!");
                                    break;
                                case 2:
                                    System.out.println("Enter new student age:");
                                    studentToUpdate.age = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("Age updated successfully!");
                                    break;
                                case 3:
                                    System.out.println("Enter new student course:");
                                    studentToUpdate.course = sc.nextLine();
                                    System.out.println("Course updated successfully!");
                                    break;
                                case 4:
                                    System.out.println("Returning to main menu...");
                                    break;
                                default:
                                    System.out.println("Invalid choice!");
                            }
                        } while (updateChoice != 4);
                        System.out.println("\nUpdated Student Details:");
                        studentToUpdate.displayStudentDetails();
                    }
                    break;
                case 6:
                    System.out.println("Exiting Student Management System...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}
