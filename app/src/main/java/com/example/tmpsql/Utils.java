package com.example.tmpsql;

import com.example.tmpsql.Student;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Utils {
    final static String DATABASE_NAME = "db_students";

    final static String TABLE_STUDENT = "tbl_student";
    final static String TABLE_STUDENT_COL_ID = "student_id";
    final static String TABLE_STUDENT_COL_FIRSTNAME = "firstName";
    final static String TABLE_STUDENT_COL_LASTNAME = "lastName";
    final static String TABLE_STUDENT_COL_NUMCLASS = "numClass";
    final static String TABLE_STUDENT_COL_AVGGRADE = "avgGrade";

    final static String TABLE_CLASS = "tbl_classes";
    final static String TABLE_CLASS_COL_NAME = "className";
    final static String TABLE_CLASS_COL_TEACHER_NAME = "teacherName";


    final static String TABLE_TEACHER = "tbl_teacher";
    final static String TABLE_TEACHER_COL_ID = "id";
    final static String TABLE_TEACHER_COL_FIRSTNAME = "firstName";
    final static String TABLE_TEACHER_COL_LASTNAME = "lastName";
    final static String TABLE_TEACHER_COL_SUBJECT = "subject";

    public static void createTables(SQLiteDatabase db) {
        db.execSQL("create table if not exists " + Utils.TABLE_STUDENT +
                " (" + TABLE_STUDENT_COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "" + Utils.TABLE_STUDENT_COL_FIRSTNAME + " TEXT," +
                "" + Utils.TABLE_STUDENT_COL_LASTNAME + " TEXT," +
                "" + Utils.TABLE_STUDENT_COL_NUMCLASS + " TEXT," +
                Utils.TABLE_STUDENT_COL_AVGGRADE + " real)");

        db.execSQL("create table if not exists "
                + TABLE_CLASS +
                "(" + TABLE_CLASS_COL_NAME + " TEXT, " +
                TABLE_CLASS_COL_TEACHER_NAME + " TEXT)");

        db.execSQL("create table if not exists "
                + TABLE_TEACHER +
                "(" + TABLE_TEACHER_COL_ID + " INTEGER, " +
                TABLE_TEACHER_COL_FIRSTNAME + " TEXT, " +
                TABLE_TEACHER_COL_LASTNAME + " TEXT, " +
                TABLE_TEACHER_COL_SUBJECT + " TEXT)");


    }

    public static void insert_student(String firstName, String lastName, String numClass,
                                      double avgGrade, SQLiteDatabase db) {
        db.execSQL("insert into "+TABLE_STUDENT+" values("+null+", " +
                "'" + firstName + "','" + lastName + "','" + numClass + "','" + avgGrade + "')");
    }

    public static ArrayList<Student> find_student_by_name(String firstName,
                                                          SQLiteDatabase db) {
        ArrayList<Student> sameNameStudentList = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from " + TABLE_STUDENT, null);

        while (cursor.moveToNext()) {
            if (firstName.equals(cursor.getString(1))) {
                sameNameStudentList.add(new Student(cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getDouble(3)));
            }
        }
        return sameNameStudentList;
    }

    public static ArrayList<Student> better_average(double avgGrade, SQLiteDatabase db) {
        ArrayList<Student> betterAverage = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from " + TABLE_STUDENT, null);
        while (cursor.moveToNext()) {
            if (avgGrade < (cursor.getDouble(4))) {
                betterAverage.add(new Student(cursor.getString(0), cursor.getString(1),
                        cursor.getString(2), cursor.getDouble(3)));
            }
        }
        return betterAverage;
    }

    public static void deleteStudent(int id, SQLiteDatabase db) {
        db.execSQL("delete from " + TABLE_STUDENT + " where " + TABLE_STUDENT_COL_ID +
                "=" + id);
    }

    public static void updateStudent(Student student, SQLiteDatabase db) {
        ContentValues contentValues = new ContentValues();
        Cursor cursor = db.rawQuery("select * from " + TABLE_STUDENT + " where " +
                TABLE_STUDENT_COL_FIRSTNAME + "=" + student.getFirstName() + " AND "
                + TABLE_STUDENT_COL_LASTNAME + "=" + student.getLastName() + " AND " +
                TABLE_STUDENT_COL_NUMCLASS + "=" + student.getNumClass() +
                " AND " + TABLE_STUDENT_COL_AVGGRADE + "=" +
                student.getAvgGrade(), null);
        while (cursor.moveToNext()) {
                contentValues.put(TABLE_STUDENT_COL_ID, cursor.getInt(0));
                contentValues.put(TABLE_STUDENT_COL_FIRSTNAME, student.getFirstName());
                contentValues.put(TABLE_STUDENT_COL_LASTNAME, student.getLastName());
                contentValues.put(TABLE_STUDENT_COL_NUMCLASS, student.getNumClass());
                contentValues.put(TABLE_STUDENT_COL_AVGGRADE, student.getAvgGrade());
                db.update(TABLE_STUDENT, contentValues, TABLE_STUDENT_COL_ID + "=" + cursor.getInt(0), null);
        }
    }

    public static ArrayList<Student> getStudentsBySubject(int subject, SQLiteDatabase db) {
        ArrayList<Student> students = new ArrayList<>();
        String q = "select " + TABLE_TEACHER_COL_FIRSTNAME + " from " + TABLE_TEACHER + " where " + TABLE_TEACHER_COL_SUBJECT + "=" + subject;
        Cursor cursor = db.rawQuery(q, null);
        while (cursor.moveToNext()) {
            String fName = cursor.getString(0);
            String q1 = "select " + TABLE_CLASS_COL_NAME + " from " + TABLE_CLASS + " where " + TABLE_CLASS_COL_TEACHER_NAME + "=" + fName;
            Cursor cursor1 = db.rawQuery(q1, null);
            while (cursor1.moveToNext()) {
                String className = cursor1.getString(0);
                String q2 = "select * from " + TABLE_STUDENT + " where " + TABLE_STUDENT_COL_NUMCLASS + "=" + className;
                Cursor cursor2 = db.rawQuery(q2, null);
                Student student = null;
                if (cursor2.getCount() > 0) {
                    while (cursor2.moveToNext()) {
                        student.setFirstName(cursor2.getString(1));
                        student.setLastName(cursor2.getString(2));
                        student.setNumClass(cursor2.getString(3));
                        student.setAvgGrade(cursor2.getInt(4));
                        students.add(student);
                    }
                }
            }

        }
        return students;
    }
}
