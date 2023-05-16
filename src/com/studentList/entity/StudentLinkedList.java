package com.studentList.entity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class StudentLinkedList {
    private LinkedList<Student> students;
    private LinkedList<Student> clonedStudents;

    public StudentLinkedList() {
        this.students = new LinkedList<>();
    }

    // Add a student to the system
    public void addStudent(Student student) {
        students.add(student);
    }

    public LinkedList<Student> cloneStudents(LinkedList<Student> st) {
        LinkedList<Student> clonedList = new LinkedList<>();

        for (Student student : st) {
            Student clonedStudent = new Student(student.getName(), student.getSubject(), student.getMarks());
            clonedList.add(clonedStudent);
        }
        return clonedList;
    }

    // Sort the students by marks using merge sort algorithm
    public void sortStudentsByMarks() throws IOException {
        clonedStudents = cloneStudents(students);
        clonedStudents = mergeSort(clonedStudents);
    }

    // Merge sort implementation
    private LinkedList<Student> mergeSort(LinkedList<Student> st) throws IOException {
        LinkedList<Student> list = cloneStudents(st);
        int size = list.size();
        if (size <= 1) {
            return list;
        }
        int middle = size / 2;

        LinkedList<Student> left = new LinkedList<>(list.subList(0, middle));
        LinkedList<Student> right = new LinkedList<>(list.subList(middle, size));

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    // Merge two sorted linked lists
    private LinkedList<Student> merge(LinkedList<Student> left, LinkedList<Student> right) throws IOException {
        LinkedList<Student> result = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("1.Ascending order \n 2.Descending Order");
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("Enter the choice of Number : ");
        int x = Integer.parseInt(br.readLine());
        switch (x) {

            case 1:
                while (!left.isEmpty() && !right.isEmpty()) {
                    if (left.getFirst().getMarks() <= right.getFirst().getMarks()) {
                        result.add(left.removeFirst());
                    } else {
                        result.add(right.removeFirst());
                    }
                }

                while (!left.isEmpty()) {
                    result.add(left.removeFirst());
                }

                while (!right.isEmpty()) {
                    result.add(right.removeFirst());
                }

                return result;

            case 2:
                while (!left.isEmpty() && !right.isEmpty()) {
                    if (left.getFirst().getMarks() >= right.getFirst().getMarks()) {
                        result.add(left.removeFirst());
                    } else {
                        result.add(right.removeFirst());
                    }
                }

                while (!left.isEmpty()) {
                    result.add(left.removeFirst());
                }

                while (!right.isEmpty()) {
                    result.add(right.removeFirst());
                }

                return result;

            default:
                throw new IllegalArgumentException("Invalid sort option: " + x);
        }
    }

    // Print the list of students
    public void printStudents() {
        System.out.println("Sorted list:");
        display(clonedStudents);
    }

    public void list() {
        System.out.println("Original list:");
        display(students);
    }

    private void display(LinkedList<Student> st) {
        for (Student student : st) {
            System.out.println(student);
        }
    }
}