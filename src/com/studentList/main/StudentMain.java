package com.studentList.main;

import com.studentList.entity.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

import com.studentList.entity.StudentLinkedList;
import com.studentList.entity.*;


public class StudentMain {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        StudentLinkedList system = new StudentLinkedList();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            System.out.println("********************************************************************************************************************");
            System.out.println("1. Add Student \t\t\t\t\t\t\t2. Show Students ");
            System.out.println("3. Merge Sort \t\t\t\t\t\t\t4. Exit ");
            System.out.println("********************************************************************************************************************");
            System.out.println("Enter the choice of Number : ");

            int choice = Integer.parseInt(br.readLine());

            switch (choice) {

                case 1:
                    System.out.print("Enter student name: ");
                    String name = br.readLine();


                    System.out.print("Enter subject: ");
                    String subject = br.readLine();


                    System.out.print("Enter mark: ");
                    int marks = Integer.parseInt(br.readLine());

                    system.addStudent(new Student(name, subject, marks));
                    break;

                case 2:
                    system.list();
                    break;

                case 3:
                    system.sortStudentsByMarks();
                    system.printStudents();
                    break;


                case 4:
                    System.exit(0);
                    break;


                default:
                    System.out.println("Invalid option: " + choice);
                    System.exit(0);
            }

        }
    }
}