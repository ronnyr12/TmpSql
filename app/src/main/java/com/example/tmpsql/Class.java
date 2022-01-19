package com.example.tmpsql;

public class Class {
    private String className, teacherName;

    public Class(String className, String teacherName) {
        this.className = className;
        this.teacherName = teacherName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
