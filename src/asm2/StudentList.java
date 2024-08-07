/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm2;
import java.util.Scanner;
/**
 *
 * @author Admin
 */
public class StudentList {
    private Node head;

    public StudentList() {
        this.head = null;
    }
   
    public void add (Student data){
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        
    }
    public boolean delete (int studentId){
        if(head == null){
            return  false;
        }
        if (head.student.getId()==studentId){
            head = head.next;
            return true;
        }
        Node current = head;
        while (current.next != null && current.next.student.getId() != studentId){
            current = current.next;
        }
        
        if (current.next == null){
            return false;
          
        }
        else{
            current.next = current.next.next;
            return true;
        }
    }
        public boolean update(int studentId, String newName, double newMark) {
        Node current = head;
        while (current != null) {
            if (current.student.getId() == studentId) {
                current.student.setName(newName);
                current.student.setMark(newMark);
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public Student search(int studentId) {
        Node current = head;
        while (current != null) {
            if (current.student.getId() == studentId) {
                return current.student;
            }
            current = current.next;
        }
        return null;
    }
     public void sort() {
        if (head == null || head.next == null) {
            return;
        }

        head = mergeSort(head);
    }
    private Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;

        middle.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);

        return sortedMerge(left, right);
    }

    private Node getMiddle(Node head) {
        if (head == null) {
            return head;
        }

        Node slow = head, fast = head.next;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }

    private Node sortedMerge(Node left, Node right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        Node result;
        if (left.student.getMark() <= right.student.getMark()) {
            result = left;
            result.next = sortedMerge(left.next, right);
        } else {
            result = right;
            result.next = sortedMerge(left, right.next);
        }
        return result;
    }
     public void bubblesort() {
        if (head == null) {
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                if (current.student.getMark() < current.next.student.getMark()) {
                    // Swap the data
                    Student temp = current.student;
                    current.student = current.next.student;
                    current.next.student = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

     public void display() {
        Node current = head;
        while (current != null) {
            System.out.println(current.student);
            current = current.next;
        }
    }
}
