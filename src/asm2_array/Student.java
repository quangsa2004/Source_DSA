/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm2_array;

/**
 *
 * @author Admin
 */
public class Student {
    private String name;
    private int studentId;
    private double mark;

    public Student(String name, int studentId, double mark) {
        this.name = name;
        this.studentId = studentId;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public int getStudentId() {
        return studentId;
    }

    public double getMark() {
        return mark;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", studentId=" + studentId + ", mark=" + mark + "]";
    }
}
