package com.example.sys.retrive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Map;

public class ListDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_list_data );
        ListView lv = findViewById( R.id.listView );
        ExampleDB db = new ExampleDB( this );
        ArrayList <Map <String, String>> arrayList = new ArrayList <>();
        arrayList = db.getDataFromDatabase();
        CustomAdapter adapter=new CustomAdapter( this,arrayList );
        lv.setAdapter( adapter );
    }
}