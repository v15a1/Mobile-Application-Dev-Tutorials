package com.visal.firstdatabaseapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
/*
*
*
*
*
* http://www.codebind.com/android-tutorials-and-examples/android-sqlite-tutorial-example/
*
*
*
*
*/

public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "employees.db";
    public static final String TABLE_NAME = "Employees";
    public static final String COL_1 = "EMPLOYEE_ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "ADDRESS";
    public static final String COL_4 = "AGE";
    public static final String COL_5 = "POSITION";

    SQLiteDatabase employees;

    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (EMPLOYEE_ID INTEGER PRIMARY KEY ,NAME TEXT, ADDRESS TEXT, AGE INTEGER ,POSITION TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //method to insert data
    public boolean insertData(int emp_id, String name, String address, int age, String position){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, emp_id);
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, address);
        contentValues.put(COL_4, age);
        contentValues.put(COL_5, position);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    //method to retrieve data
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("select * from " + TABLE_NAME, null);
    }
}
