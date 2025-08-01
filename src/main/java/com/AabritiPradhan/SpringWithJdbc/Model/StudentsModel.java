package com.AabritiPradhan.SpringWithJdbc.Model;

public class StudentsModel {

    private int S_ID;
    private String Name;
    private String Email;
    private int Marks;

    public StudentsModel() {
    }

    public StudentsModel(int s_ID, String name, String email, int marks) {
        S_ID = s_ID;
        Name = name;
        Email = email;
        Marks = marks;
    }

    public int getS_ID() {
        return S_ID;
    }

    public void setS_ID(int s_ID) {
        S_ID = s_ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getMarks() {
        return Marks;
    }

    public void setMarks(int marks) {
        Marks = marks;
    }
}
