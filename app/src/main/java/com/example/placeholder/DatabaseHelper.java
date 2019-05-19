package com.example.placeholder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.placeholder.Database.History;
import com.example.placeholder.Database.User;
import com.example.placeholder.Database.Details;

public class DatabaseHelper extends SQLiteOpenHelper {
        //information of database
        private static final String DATABASE_NAME = "Placeholder.db";

        /*
        USERS TABLE
        Fields:
            UID         STRING
            Email       NOT NULL
            PRIMARY KEY (UID)
        */
        private static final String TABLE_NAME1 = "Users";
        private static final String COLUMN_UID = "UID";
        private static final String COLUMN_EMAIL = "UserEmail";


        /*
        PRODUCTS TABLE
        Fields:
            OrderID NOT NULL
            ItemName NOT NULL
            Price       NOT NULL
            UID
            FOREGIN KEY (OrderID)
         */
        private static final String TABLE_NAME2 = "OrderDetails";
        private static final String COLUMN_UID2 = "UID";
        private static final String COLUMN_ITEM2 = "ItemName";
        private static final String COLUMN_PRICE2 = "Price";
        private static final String COLUMN_ORDERID2 = "OrderID";


        //ORDERHISTORY TABLE
        private static final String TABLE_NAME3 = "OrderHistory";
        private static final String COLUMN_UID3 = "UID";
        private static final String COLUMN_ITEM3 = "ItemName";
        private static final String COLUMN_PRICE3 = "Price";
        private static final String COLUMN_ORDERID3 = "OrderID";



        //initialize the database
        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, 1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {

            //creates USER table
            String CREATE_TABLE1 = "CREATE TABLE " + TABLE_NAME1 + " (" + COLUMN_UID +
                    " VARCHAR PRIMARY KEY, " + COLUMN_EMAIL + " VARCHAR);";
            db.execSQL(CREATE_TABLE1);

            //creates ORDERDETAILS table
            String CREATE_TABLE2 = "CREATE TABLE " + TABLE_NAME2 + " (" + COLUMN_UID2 +
                    " VARCHAR NOT NULL, " + COLUMN_ITEM2 + " VARCHAR NOT NULL, " + COLUMN_PRICE2 + " DOUBLE," +
                    COLUMN_ORDERID2 + " NUMBER, PRIMARY KEY(UID, ItemName));";
            db.execSQL(CREATE_TABLE2);

            String CREATE_TABLE3 = "CREATE TABLE " + TABLE_NAME3 + " (" + COLUMN_UID3 +
                    " VARCHAR NOT NULL, " + COLUMN_ITEM3 + " VARCHAR NOT NULL, " + COLUMN_PRICE3 + " DOUBLE," +
                    COLUMN_ORDERID3 + "NUMBER, PRIMARY KEY(UID, ItemName));";
            db.execSQL(CREATE_TABLE3);

        }

        //Called when the database needs to be upgraded.
        // The implementation should use this method to drop tables, add tables,
        // or do anything else it needs to upgrade to the new schema version
        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME3);
            onCreate(db);
        }


        //USERS TABLE
        //loads the entire table so you can display it
       //We use the rawQuery() method of a SQLiteDatabase object to implement SQL statement and display result via a Cursor object
        public String loadUsers() {

            String result = "";
            String query = "Select*FROM " + TABLE_NAME1;
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(query, null);
            while (cursor.moveToNext()) {
                String result_0 = cursor.getString(0);
                String result_1 = cursor.getString(1);
                result += result_0 + " " + result_1 + " " + System.getProperty("line.separator");
            }
            cursor.close();
            db.close();
            return result;
        }

       //ORDERS DETAILS TABLE
       public String loadDetails() {

           String result = "";
           String query = "Select*FROM " + TABLE_NAME2;
           SQLiteDatabase db = this.getWritableDatabase();
           Cursor cursor = db.rawQuery(query, null);
           while (cursor.moveToNext()) {
               String result_0 = cursor.getString(0);
               String result_1 = cursor.getString(1);
               double result_2 = cursor.getDouble(2);
               int result_4=cursor.getInt(4);
               result += result_0 + "         " + result_1 + "  $" + result_2 + System.getProperty("line.separator");
           }
           cursor.close();
           db.close();
           return result;
       }

       public String loadItems(){
        String result = "";
        String query = "Select*FROM " + TABLE_NAME2;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            String result_0 = cursor.getString(0);
            String result_1 = cursor.getString(1);
            double result_2 = cursor.getDouble(2);
            int result_4 = cursor.getInt(4);
            result += "  " + result_1 + System.getProperty("line.separator");
        }
        cursor.close();
        db.close();
        return result;
    }


    public String loadPrices(){
        String result = "";
        String query = "Select*FROM " + TABLE_NAME2;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            String result_0 = cursor.getString(0);
            String result_1 = cursor.getString(1);
            double result_2 = cursor.getDouble(2);
            int result_4 = cursor.getInt(4);
            result += "$ " + result_2 +"0" + System.getProperty("line.separator");
        }
        cursor.close();
        db.close();
        return result;
    }

    public String loadHistory() {

        String result = "";
        String query = "Select*FROM " + TABLE_NAME3;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            String result_0 = cursor.getString(0);
            String result_1 = cursor.getString(1);
            double result_2 = cursor.getDouble(2);
            int result_4=cursor.getInt(4);
            result += result_0 + "         " + result_1 + "  $" + result_2 + System.getProperty("line.separator");
        }
        cursor.close();
        db.close();
        return result;
    }

    public String loadOrderes(){
        String result = "";
        String query = "Select*FROM " + TABLE_NAME3;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            String result_0 = cursor.getString(0);
            String result_1 = cursor.getString(1);
            double result_2 = cursor.getDouble(2);
            int result_4 = cursor.getInt(4);
            result += "  " + result_1 + System.getProperty("line.separator");
        }
        cursor.close();
        db.close();
        return result;
    }



       //ADD VALUES TO USER TABLE
        //we must use the ContentValues object with the put() method that is used to assign data to ContentsValues object
        //and then use insert() method of SQLiteDatabase object to insert data to the database
       //parameter is new customer object
        public void addUser(User user) {

            ContentValues values = new ContentValues();
            values.put(COLUMN_UID, user.getuID());
            values.put(COLUMN_EMAIL, user.getEmail());
            SQLiteDatabase db = this.getWritableDatabase();
            db.insert(TABLE_NAME1, null, values);
            db.close();
        }


       //ADD VALUES TO ORDERDETAILS TABLE
       public void addDetails(Details details) {

           ContentValues values = new ContentValues();
           values.put(COLUMN_UID2, details.getUID());
           values.put(COLUMN_ITEM2, details.getItemName());
           values.put(COLUMN_PRICE2, details.getPrice());
           values.put(COLUMN_ORDERID2, details.getOrderID());
           SQLiteDatabase db = this.getWritableDatabase();
           db.insert(TABLE_NAME2, null, values);
           db.close();
       }

        public void addHistory(History history) {

            ContentValues values = new ContentValues();
            values.put(COLUMN_UID3, history.getUID());
            values.put(COLUMN_ITEM3, history.getItemName());
            values.put(COLUMN_PRICE3, history.getPrice());
            values.put(COLUMN_ORDERID3, history.getOrderID());
            SQLiteDatabase db = this.getWritableDatabase();
            db.insert(TABLE_NAME3, null, values);
            db.close();
        }


        //finds information in the database by condition
       //parameter is the email/username
       //method returns the customer object linked to that email/username

    //FIND USER
       public User findUser(String email) {
           String query = "Select * FROM " + TABLE_NAME1 + " WHERE " + COLUMN_EMAIL + " = " + "'" + email + "'";
           SQLiteDatabase db = this.getWritableDatabase();
           Cursor cursor = db.rawQuery(query, null);
           User user = new User();
           if (cursor.moveToFirst()) {
               cursor.moveToFirst();
               user.setuID(cursor.getString(0));
               user.setEmail(cursor.getString(1));
               cursor.close();
           } else {
               user = null;
           }
           db.close();
           return user;
       }


        //FIND DETAILS
        public Details findDetails(int orderid) {
            String query = "Select * FROM " + TABLE_NAME3 + " WHERE " + COLUMN_ORDERID2 + " = " + "'" + orderid + "'";
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(query, null);
            Details details = new Details();
            if (cursor.moveToFirst()) {
                cursor.moveToFirst();
                details.setOrderID(cursor.getInt(0));
                details.setItemName(cursor.getString(1));
                details.setPrice(cursor.getDouble(2));
                cursor.close();
            } else {
                details = null;
            }
            db.close();
            return details;
        }


       //deletes a record by condition
       //accepts a name and deletes the row/record affiliated with that name
       //We will save the result that is returned from the implementation of the rawQuery() method
       //of the SQLiteDatabase object into a Cursor object and find the matching result in this object.
       // In the final step, we use the delete() method of the SQLiteDatabase object to delete the record
        public boolean deleteUser(String email) {

            boolean result = false;
            String query = "Select*FROM " + TABLE_NAME1 + " WHERE " + COLUMN_EMAIL + "= '" + email + "'";
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(query, null);
            User user = new User();
            if (cursor.moveToFirst()) {
                user.setEmail(cursor.getString(1));
                db.delete(TABLE_NAME1, COLUMN_EMAIL + "=?",
                        new String[] {
                    String.valueOf(user.getEmail())
                });
                cursor.close();
                result = true;
            }
            db.close();
            return result;
        }


        public boolean deleteDetails(int orderid) {

            boolean result = false;
            String query = "Select*FROM " + TABLE_NAME2 + " WHERE " + COLUMN_ORDERID2 + "= '" + orderid + "'";
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(query, null);
            Details details = new Details();
            if (cursor.moveToFirst()) {
                details.setOrderID(cursor.getInt(4));
                db.delete(TABLE_NAME2, COLUMN_ORDERID2 + "=?",
                    new String[] {
                            String.valueOf(details.getOrderID())
                    });
                cursor.close();
                result = true;
            }
            db.close();
            return result;
        }


        //updates the information in a record
       //we can use the ContentValues object and the update() method of the SQLiteDatabase object
        public boolean updateUser(String uid, String email) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues args = new ContentValues();
            args.put(COLUMN_UID, uid);
            args.put(COLUMN_EMAIL, email);

            return db.update(TABLE_NAME1, args, COLUMN_UID + "='" + uid + "'", null) > 0;
        }

        public boolean updateDetails(int orderID, String item, double price) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues args = new ContentValues();
            args.put(COLUMN_ORDERID2, orderID);
            args.put(COLUMN_ITEM2, item);
            args.put(COLUMN_PRICE2, price);

            return db.update(TABLE_NAME3, args, COLUMN_ORDERID2 + "='" + orderID + "'", null) > 0;
        }
    }

