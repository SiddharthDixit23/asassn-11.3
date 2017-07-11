package com.acadgild.siddharth.datastorageassn113;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created by siddharth on 7/12/2017.
 */

public class ShowData extends Activity{
TextView tvname,tvdate;
    Context CTX=this;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data);

        tvname = (TextView) findViewById(R.id.nametext);
        tvdate = (TextView) findViewById(R.id.agetext);

        DatabaseOperations DOP = new DatabaseOperations(CTX);
        Cursor CR= DOP.getInformation(DOP);
        CR.moveToFirst();
        String NAME = "";
        do
        {
            if(CR.getString(0)!=null && CR.getString(1)!=null)
            {
                tvname.setText(CR.getString(0));
                tvdate.setText(CR.getString(1));
            }
        }while(CR.moveToNext());
    }
}
