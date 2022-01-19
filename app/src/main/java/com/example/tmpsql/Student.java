package com.example.tmpsql;

import android.graphics.Bitmap;

public class Student {
    private String firstName,lastName,numClass;
    private double avgGrade;
    Bitmap bitmap;

    public Student(String firstName,
                   String lastName,
                   String numClass,
                   double avgGrade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numClass = numClass;
        this.avgGrade = avgGrade;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumClass() {
        return numClass;
    }

    public void setNumClass(String numClass) {
        this.numClass = numClass;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    public android.graphics.Bitmap getBitmap() {
        return bitmap;
    }
}
