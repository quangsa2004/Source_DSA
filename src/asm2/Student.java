/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm2;

/**
 *
 * @author Admin
 */
public class Student {
    private int id;
    private String name;
    private int age;
    private double mark;
    private String rank;

    public Student(int id, String name, int age, double mark) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mark = mark;
        this.rank = calculateRank(mark);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
        this.rank = calculateRank(mark);
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
    
    private String calculateRank(double mark) {
        if (mark >= 0 && mark < 5.0) {
            return "Fail";
        } else if (mark >= 5.0 && mark < 6.5) {
            return "Medium";
        } else if (mark >= 6.5 && mark < 7.5) {
            return "Good";
        } else if (mark >= 7.5 && mark < 9.0) {
            return "Very Good";
        } else if (mark >= 9.0 && mark <= 10.0) {
            return "Excellent";
        } else {
            return "Invalid mark"; 
        }
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", studentId=" + id +
                ", mark=" + mark +
                ", rank='" + rank + '\'' +
                '}';
    }
}
