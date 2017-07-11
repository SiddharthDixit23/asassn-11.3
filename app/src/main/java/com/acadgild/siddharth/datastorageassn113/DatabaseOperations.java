package com.acadgild.siddharth.datastorageassn113;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by siddharth on 6/21/2017.
 */

public class DatabaseOperations extends SQLiteOpenHelper {

    public static final int database_version = 1;
    public String CREATE_QUERY = "CREATE TABLE "+ TableData.TableInfo.TABLE_NAME+"("+ TableData.TableInfo.USER_NAME+" TEXT,"+ TableData.TableInfo.USER_PASS+" TEXT);";

    public DatabaseOperations(Context context) {
        super(context, TableData.TableInfo.DATABASE_NAME, null, database_version);
        Log.d("Database Operations","Database Created Successfully");
    }

    @Override
    public void onCreate(SQLiteDatabase sdb) {
        sdb.execSQL(CREATE_QUERY);
        Log.d("Database Operations","Table Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    /** Put information into the database*/

    public void putInformation(DatabaseOperations dop,String name,String pass)
    {
        SQLiteDatabase SQ = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableData.TableInfo.USER_NAME,name);
        cv.put(TableData.TableInfo.USER_PASS,pass);
        long k = SQ.insert(TableData.TableInfo.TABLE_NAME,null,cv);
        Log.d("Database Operations","One raw data inserted");
    }

    /** Retreiving data from the database*/
    public Cursor getInformation(DatabaseOperations dop)
    {
        SQLiteDatabase SQ = dop.getReadableDatabase();
        String[] coloums = {TableData.TableInfo.USER_NAME, TableData.TableInfo.USER_PASS};
        Cursor CR = SQ.query(TableData.TableInfo.TABLE_NAME,coloums,null,null,null,null,null);
        return CR;
    }

    // get user password
    public Cursor getUserPass(DatabaseOperations DOP,String user)
    {
        SQLiteDatabase SQ = DOP.getReadableDatabase();
        String selection = TableData.TableInfo.USER_NAME+ " LIKE ?";
        String coloumns[] =     {TableData.TableInfo.USER_PASS};
        String args[] = {user};
        Cursor CR = SQ.query(TableData.TableInfo.TABLE_NAME,coloumns,selection,args,null,null,null);
        return  CR;
    }

    // delete function

    public void deleteUser(DatabaseOperations DOP,String user,String pass)
    {
        String selection = TableData.TableInfo.USER_NAME+" LIKE ? AND "+ TableData.TableInfo.USER_PASS + " LIKE ?";
        String args[] = {user,pass};
        SQLiteDatabase SQ = DOP.getWritableDatabase();
        SQ.delete(TableData.TableInfo.TABLE_NAME,selection,args);
    }

    //update database

    public void updateUserInfo(DatabaseOperations DOP,String username,String userpass,String newusername)
    {
        SQLiteDatabase SQ = DOP.getWritableDatabase();
        String selection = TableData.TableInfo.USER_NAME+" LIKE ? AND "+ TableData.TableInfo.USER_PASS+" LIKE ?";
        String args[] = {username,userpass};
        ContentValues values = new ContentValues();
        values.put(TableData.TableInfo.USER_NAME,newusername);
        SQ.update(TableData.TableInfo.TABLE_NAME,values,selection,args);
    }
}
