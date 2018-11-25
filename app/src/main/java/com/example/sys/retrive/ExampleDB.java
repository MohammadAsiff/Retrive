package com.example.sys.retrive;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExampleDB extends SQLiteOpenHelper {
    private static final String DATABASE="sample_db";
    private static final String TABLE_NAME="Student";
    public static final String NAME="USER_NAME";
    public static final String COLLEGE="COLLEGE";
    public static final String BRANCH="BRANCH";




    public ExampleDB(Context context) {
        super( context,DATABASE,null,1 );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL( "Create table "+TABLE_NAME +"("+NAME+" TEXT,"+COLLEGE+" TEXT,"
                                                +BRANCH+" TEXT"+")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
     sqLiteDatabase.execSQL( "DROP TABLE IF EXISTS"+TABLE_NAME );
     onCreate( sqLiteDatabase );
    }
    public  void insert(String s1,String s2,String s3){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues(  );
        contentValues.put( NAME,s1 );
        contentValues.put( COLLEGE,s2 );
        contentValues.put( BRANCH,s3 );
        sqLiteDatabase.insert( TABLE_NAME,null,contentValues );
    }

    public ArrayList<Map<String,String>> getDataFromDatabase() {
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        ArrayList<Map<String,String>> data=new ArrayList <>(  );
        Cursor cursor=sqLiteDatabase.rawQuery( "SELECT*FROM "+TABLE_NAME,null );
        if (cursor != null && cursor.moveToFirst()){

            while(!cursor.isAfterLast()){
                Map<String, String> map = new HashMap <>();
                map.put(NAME, cursor.getString(cursor.getColumnIndex(NAME)));
                map.put(COLLEGE, cursor.getString(cursor.getColumnIndex(COLLEGE)));
                map.put(BRANCH, cursor.getString(cursor.getColumnIndex(BRANCH)));
                data.add(map);
                cursor.moveToNext();
            }
        }
        return data;

    }
}
