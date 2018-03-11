package com.poonam.rest_sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Date;

public class Database_Handler extends SQLiteOpenHelper {


    SQLiteDatabase db;
    Context context;
    public static final String DATABASE_NAME="student.db";
    public static final String TABLE_NAME="student_table";
    public static final String COL_1="ID";
    public static final String COL_2="DISH";
    public static final String COL_3="PRICE";
    public static final String COL_4="TABLE_NO";

    public Database_Handler(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
        db = this.getWritableDatabase();

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql ="create table bmi(Record integer primary key autoincrement,date date,dish string,price string,table_no string)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void addRecord(Date date , String dish , String price , String table_no)
    {
        ContentValues values = new ContentValues();
        values.put("date" , String.valueOf(date));
        values.put("dish" , dish);
        values.put("price" , price);
        values.put("table_no" , table_no);

        long rid = db.insert("bmi",null,values);
        if(rid<0)
        {
            Toast.makeText(context,"insert issue",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(context,"insert success",Toast.LENGTH_LONG).show();
        }
    }//end of addRecord

    public  String getHistory()
    {
        Cursor cursor=db.query("bmi",null,null,null,null,null,null);
        StringBuffer sb=new StringBuffer();
        cursor.moveToFirst();
        if(cursor.getCount()>0)
        {
            do {
                String record=cursor.getString(0);
                String date=cursor.getString(1);
                String dish=cursor.getString(2);
                String price=cursor.getString(3);
                String table_no=cursor.getString(4);
                sb.append("Record: "+record+"\n"+ "Date: "+date+"\n"+"DISH NAME: "+dish+"\n"+"FOOD PRICE: "+price+"\n"+"TABLE_NO: "+table_no+"\n--------------------"+"\n");

            }while (cursor.moveToNext());
        }
        else
        {
            sb.append("No History to show");
        }
        return  sb.toString();
    }//end of getHistory

}
