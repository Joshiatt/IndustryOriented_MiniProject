package com.example.databasesample;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

	public DBHandler(Context context) {
		super(context, "college", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table if not exists student(name varchar(10))");
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	public void addinfo(String name) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL("insert into student values('" + name + "')");
	}

	public ArrayList<String> getinfo() {
		// TODO Auto-generated method stub
		ArrayList<String> al = new ArrayList<String>();
		SQLiteDatabase db = getReadableDatabase();
		Cursor c = db.rawQuery("select * from student", null);
		c.moveToFirst();
		if(c != null){
			do {
				int a = c.getColumnIndex("name");
				String data = c.getString(a);
				al.add(data);
			}while(c.moveToNext());
			
		}
		return al;
	}

	
}
