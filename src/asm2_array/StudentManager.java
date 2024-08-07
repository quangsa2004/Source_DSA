/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm2_array;
import java.util.Scanner;
/**
 *
 * @author Admin
 */
public class StudentManager {
    private Student[] students;
    private int studentCount;

    public StudentManager(int capacity) {
        students = new Student[capacity];
        studentCount = 0;
    }

    public boolean addStudent(Student student) {
        if (studentCount < students.length) {
            students[studentCount++] = student;
            return true;
        } else {
            return false;
        }
    }
    public boolean updateStudent(int studentId, String newName, double newMark) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId() == studentId) {
                students[i].setName(newName);
                students[i].setMark(newMark);
                return true;
            }
        }
        return false; // Student not found
    }
    public boolean removeStudent(int studentId) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId() == studentId) {
                // Shift elements to the left to fill the gap
                for (int j = i; j < studentCount - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[--studentCount] = null; 
                return true;
            }
        }
        return false; // Student not found
    }
    public Student searchStudent(int studentId) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId() == studentId) {
                return students[i];
            }
        }
        return null; // Student not found
    }
    public void sortStudentsByMark() {
        for (int i = 0; i < studentCount - 1; i++) {
            for (int j = 0; j < studentCount - i - 1; j++) {
                if (students[j].getMark() > students[j + 1].getMark()) {
                    // Swap students[j] and students[j + 1]
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }
    public void displayStudents() {
        for (int i = 0; i < studentCount; i++) {
            System.out.println(students[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the capacity of the student array: ");
        int capacity = Integer.parseInt(scanner.nextLine());

        StudentManager manager = new StudentManager(capacity);

        while (true) {
            System.out.println("Choose an option: ");
            System.out.println("1. Add student");
            System.out.println("2. Update student's information");
            System.out.println("3. Delete a student");
            System.out.println("4. Search a student");
            System.out.println("5. Sort students");
            System.out.println("6. Display students");
            System.out.println("7. Exit");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Enter student name: ");
                    String name = scanner.nextLine();

                    System.out.println("Enter student ID: ");
                    int studentId = Integer.parseInt(scanner.nextLine());

                    System.out.println("Enter student mark: ");
                    double mark = Double.parseDouble(scanner.nextLine());

                    Student student = new Student(name, studentId, mark);
                    if (manager.addStudent(student)) {
                        System.out.println("Student added successfully.");
                    } else {
                        System.out.println("Student array is full.");
                    }
                    break;
                case 2:
                    System.out.println("Enter student ID to update: ");
                    studentId = Integer.parseInt(scanner.nextLine());

                    System.out.println("Enter new student name: ");
                    String newName = scanner.nextLine();

                    System.out.println("Enter new student mark: ");
                    double newMark = Double.parseDouble(scanner.nextLine());

                    if (manager.updateStudent(studentId, newName, newMark)) {
                        System.out.println("Student updated successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;   
                case 3:
                    System.out.println("Enter student ID to remove: ");
                    studentId = Integer.parseInt(scanner.nextLine());

                    if (manager.removeStudent(studentId)) {
                        System.out.println("Student removed successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                 case 4:
                    System.out.println("Enter student ID to search: ");
                    studentId = Integer.parseInt(scanner.nextLine());
                    Student foundStudent = manager.searchStudent(studentId);
                    if (foundStudent != null) {
                        System.out.println("Student found: " + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    manager.sortStudentsByMark();
                    System.out.println("Students sorted by mark.");
                    break;
                case 6:
                    System.out.println("List of students:");
                    manager.displayStudents();
                    break;

                case 7:
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
