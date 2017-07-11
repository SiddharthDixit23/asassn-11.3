package com.acadgild.siddharth.datastorageassn113;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity
{

    public EditText nameET,ageET;    //Creating references of EditTexts.
    public Button showData;       //Creating reference of Button.
    Context ctx = this;
    @Override
    //onCreate method.
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);   //Setting ContentView.

        nameET=(EditText)findViewById(R.id.name_et);
        ageET=(EditText)findViewById(R.id.age_et);
        showData=(Button) findViewById(R.id.show_btn);

        showData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                DatabaseOperations DB = new DatabaseOperations(ctx);
                String name = nameET.getText().toString();
                String age = ageET.getText().toString();
                DB.putInformation(DB,name,age);
                Toast.makeText(getBaseContext(),"Registration Success",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,ShowData.class));
            }
        });

    }

}