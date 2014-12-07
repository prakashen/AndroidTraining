package com.ncit.android.prakash.androidtraining.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PRAKASH on 9/8/2019.
 */
public class StudentsOperation {
    //database fields
    private DatabaseWrapper dbHelper;
    private String[] STUDENT_TABLE_COLUMNS = { DatabaseWrapper.STUDENT_ID, DatabaseWrapper.STUDENT_NAME };
    private SQLiteDatabase database;


    public StudentsOperation(Context context){
        dbHelper=new DatabaseWrapper(context);


    }
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Student addStudent(String name) {

        ContentValues values = new ContentValues();

        values.put(DatabaseWrapper.STUDENT_NAME, name);

        long studId = database.insert(DatabaseWrapper.STUDENTS, null, values);

        // now that the student is created return it ...
        Cursor cursor = database.query(DatabaseWrapper.STUDENTS,
                STUDENT_TABLE_COLUMNS, DatabaseWrapper.STUDENT_ID + " = "
                        + studId, null, null, null, null);

        cursor.moveToFirst();

        Student newComment = parseStudent(cursor);
        cursor.close();
        return newComment;
    }

    public void deleteStudent(Student comment) {
        long id = comment.getStudentId();
        System.out.println("Comment deleted with id: " + id);
        database.delete(DatabaseWrapper.STUDENTS, DatabaseWrapper.STUDENT_ID
                + " = " + id, null);
    }

    public List getAllStudents() {
        List students = new ArrayList();

        Cursor cursor = database.query(DatabaseWrapper.STUDENTS,
                STUDENT_TABLE_COLUMNS, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Student student = parseStudent(cursor);
            students.add(student);
            cursor.moveToNext();
        }

        cursor.close();
        return students;
    }

    private Student parseStudent(Cursor cursor) {
        Student student = new Student();
        student.setStudentId((cursor.getInt(0)));
        student.setStudentName(cursor.getString(1));
        return student;
    }

}
