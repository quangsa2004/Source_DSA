/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package asm2;
import java.util.Scanner;
/**
 *
 * @author Admin
 */
public class ASM2 {

    private StudentList students;

    public ASM2() {
        this.students = new StudentList();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Added student: " + student);
    }
    public boolean deleteStudent(int studentId){
        return students.delete(studentId);
    }
    public boolean updateStudent(int studentId, String newName, double newMark) {
        boolean updated = students.update(studentId, newName, newMark);
        if (updated) {
            Student updatedStudent = students.search(studentId);
            System.out.println("Updated student: " + updatedStudent);
        }
        return updated;
    }
     public Student searchStudent(int studentId) {
        return students.search(studentId);
    }
     public void mergesortStudentsByMark() {
        students.sort();
    }
     public void bubblesortStudentsByMark() {
        students.bubblesort();
    }
    public void displayStudents() {
        students.display();
    }
    public static void main(String[] args) {
        ASM2 manager = new ASM2();
        Scanner scanner = new Scanner(System.in);
         while (true) {
             System.out.println("Choose an option");
             System.out.println("1. Add Student");
             System.out.println("2. Delete Student");
             System.out.println("3. Update Student");
             System.out.println("4. Search Student");
             System.out.println("5. Merge Sort Student");
             System.out.println("6. Bubble Sort Student");
             System.out.println("7. Display Student");
             System.out.println("8. Exit");
              int choice = Integer.parseInt(scanner.nextLine());
              switch (choice){
                  case 1:
                      try {
                      System.out.println("Enter student ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    
                      System.out.println("Enter student name: ");
                    String name = scanner.nextLine();
                    
                      System.out.println("Enter Age of Student");
                     int age = Integer.parseInt(scanner.nextLine());
                     
                    System.out.println("Enter student mark: ");
                    double mark = Double.parseDouble(scanner.nextLine());

                    Student student = new Student(id, name,age, mark);
                    manager.addStudent(student);
                      }
                      catch (NumberFormatException e){
                          System.out.println("Invalid Input. Please Enter a valid number for student ID or mark");
                      }
                      catch (Exception e){
                          System.out.println("An error occured while add the student: "+e.getMessage());
                      }
                    break;
                  case 2:
                     try{ 
                      System.out.println("Enter student ID to delete");
                      int id = Integer.parseInt(scanner.nextLine());
                      if (manager.deleteStudent(id)) {
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                     } catch (NumberFormatException e){
                         System.out.println("Invalid Input. Please enter a valid number for student ID");
                     } catch (Exception e){
                         System.out.println("An error occured while deleting the student: "+ e.getMessage());
                     }
                    break;
                  case 3:
                      System.out.println("Enter student ID to update: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.println("Enter new student name: ");
                    String newName = scanner.nextLine();

                    System.out.println("Enter new student mark: ");
                    double newMark = Double.parseDouble(scanner.nextLine());

                    if (manager.updateStudent(id, newName, newMark)) {
                        System.out.println("Student updated successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                      break;
                  case 4:
                      System.out.println("Enter student ID to search: ");
                    id = Integer.parseInt(scanner.nextLine());
                    Student foundStudent = manager.searchStudent(id);
                    if (foundStudent != null) {
                        System.out.println("Student found: " + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                      
                  case 5:
                      manager.mergesortStudentsByMark();
                    System.out.println("Students merge-sorted by mark.");
                    break;
                      
                  case 6:
                      manager.bubblesortStudentsByMark();
                    System.out.println("Students bubble-sorted by mark.");
                      break;
                  case 7:
                      System.out.println("List of students:");
                      manager.displayStudents();
                      break;
                  case 8:
                      scanner.close();
                      return;
                  default:
                      System.out.println("Invalid Choice. Please Try Again");
              }
        }
        
       
    }
    
}
