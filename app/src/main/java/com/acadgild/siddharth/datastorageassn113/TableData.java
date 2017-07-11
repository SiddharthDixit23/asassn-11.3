package com.acadgild.siddharth.datastorageassn113;

import android.provider.BaseColumns;

/**
 * Created by siddharth on 6/20/2017.
 */

public class TableData {

    public TableData()
    {

    }

    public static abstract class TableInfo implements BaseColumns
    {
        /** KEYSSSS  */
        public static final String USER_NAME = "user_name";
        public static final String USER_PASS = "user_pass";
        public static final String DATABASE_NAME = "user_info";
        public static final String TABLE_NAME = "reg_info";
    }
}
