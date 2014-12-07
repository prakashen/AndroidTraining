package com.ncit.android.prakash.androidtraining.Database;

/**
 * Created by PRAKASH on 9/8/2019.
 */
public class Student {
    private int studentId;
    private String studentName;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return studentName;
    }
}
