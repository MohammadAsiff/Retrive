package com.example.sys.retrive;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AuthActivity extends AppCompatActivity {
   public static final String NAME="Name";
   public static final String COLLEGE="College";
   public static final String BRANCH="Branch";

    EditText et1,et2,et3;
    Button bt1,bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_auth );
      et1=findViewById( R.id.e1 );
      et2=findViewById( R.id.e2 );
      et3=findViewById( R.id.e3 );
      bt1=findViewById( R.id.b1 );
      bt2=findViewById( R.id.b2 );
      bt1.setOnClickListener( new View.OnClickListener() {
          @Override
          public void onClick(View view) {
               boolean isValid=true;
               String s1=et1.getText().toString().trim();
               String s2=et2.getText().toString().trim();
               final String s3=et3.getText().toString().trim();
               if (s1.isEmpty()){
                   isValid=false;
                   et1.setError( "ENTER NAME" );
               }
                  if (s2.isEmpty()){
                   isValid=false;
                   et2.setError( "ENTER COLLEGE" );
               }
                  if (s3.isEmpty()){
                   isValid=false;
                   et3.setError( "ENTER BRANCH" );
               }
              if (isValid)
              {
                  SharedPreferences preferences=getSharedPreferences( "prefs",MODE_PRIVATE );
                  SharedPreferences.Editor editor=preferences.edit();
                  editor.putString( NAME,s1 );
                  editor.putString( COLLEGE,s2 );
                  editor.putString( BRANCH,s3 );
                  editor.apply();
                 ExampleDB db=new  ExampleDB(AuthActivity.this);
                 db.insert(s1,s2,s3);
              }

           bt2.setOnClickListener( new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   startActivity( new Intent(  AuthActivity.this,ListDataActivity.class ));
               }
           } );


          }
      } );





    }
}
