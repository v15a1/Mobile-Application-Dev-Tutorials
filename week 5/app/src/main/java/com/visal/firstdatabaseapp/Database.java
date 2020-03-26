package com.visal.firstdatabaseapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.util.ArrayList;

//http://www.codebind.com/android-tutorials-and-examples/android-sqlite-tutorial-example/
public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "employees.db";
    public static final String TABLE_NAME = "Employees";
    public static final String COL_1 = "EMPLOYEE_ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "ADDRESS";
    public static final String COL_4 = "AGE";
    public static final String COL_5 = "POSITION";

    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    //overriden methods
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

    //arraylist to check if name is available
    public ArrayList<String> getAllNames(){
        ArrayList<String> allPhrases = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select " + COL_2 + " from " + TABLE_NAME, null);
        while (cursor.moveToNext()){
            allPhrases.add(cursor.getString(cursor.getColumnIndex(COL_2)).toUpperCase());
        }
        return allPhrases;
    }

    //arraylist to check if name is available
    public ArrayList<Integer> getAllIDs(){
        ArrayList<Integer> allPhrases = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select " + COL_2 + " from " + TABLE_NAME, null);
        while (cursor.moveToNext()){
            allPhrases.add(cursor.getInt(cursor.getColumnIndex(COL_1)));
        }
        return allPhrases;
    }

    //method to update Name by ID
    public boolean updateData(int id,String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        db.update(TABLE_NAME, contentValues, "EMPLOYEE_ID = " + id, null);
        return true;
    }

    //method to delete a certain employee by ID
    public int deleteData (int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "EMPLOYEE_ID = " + id, null);
    }
}
