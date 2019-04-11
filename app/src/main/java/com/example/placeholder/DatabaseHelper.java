package com.example.placeholder;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

   public class DatabaseHelper extends SQLiteOpenHelper {
        //information of database
        private static final String DATABASE_NAME = "customers.db";
        public static final String TABLE_NAME = "Customers";
        public static final String COLUMN_ID = "CustomerID";
        public static final String COLUMN_NAME = "CustomerName";
       public static final String COLUMN_EMAIL = "CustomerEmail";
       public static final String COLUMN_PASSWORD = "CustomerPassword";
        //initialize the database
        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, 1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {

        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {}
        //public String loadHandler() {}
        //public void addHandler(Customer customer) {}
        //public Customer findHandler(String studentname) {}
        //public boolean deleteHandler(int ID) {}
        //public boolean updateHandler(int ID, String name) {}
    }

