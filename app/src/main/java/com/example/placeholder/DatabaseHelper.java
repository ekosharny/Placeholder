package com.example.placeholder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

   public class DatabaseHelper extends SQLiteOpenHelper {
        //information of database
        private static final String DATABASE_NAME = "Placeholder.db";

        /*
        CUSTOMERS TABLE
        Fields:
            CustomerID
            Name        NOT NULL
            Email       NOT NULL
            Password    NOT NULL
            PRIMARY KEY (CustomerID)
        */
        private static final String TABLE_NAME1 = "Customers";
        private static final String COLUMN_CUSTOMERID = "CustomerID";
        private static final String COLUMN_NAME = "CustomerName";
        private static final String COLUMN_EMAIL = "CustomerEmail";
        private static final String COLUMN_PASSWORD = "CustomerPassword";

        /*
        ORDERS TABLE
        Fields:
            OrderID
            CustomerID  NOT NULL
            OrderDate   NOT NULL
            PRIMARY KEY (OrderID)
            FOREIGN KEY (CustomerID)
         */
        private static final String TABLE_NAME2 = "Orders";
        private static final String COLUMN_ORDERID = "OrderID";
        private static final String COLUMN_ORDERDATE = "OrderDate";

        /*
        PRODUCTS TABLE
        Fields:
            ProductCode NOT NULL
            ProductName NOT NULL
            ProductDesc          (A description of the product)
            Price       NOT NULL
            PRIMARY KEY (ProductID)
         */
        private static final String TABLE_NAME3 = "Products";
        private static final String COLUMN_PRODUCTCODE = "ProductCode";
        private static final String COLUMN_PRODUCTNAME = "ProductName";
        private static final String COLUMN_PRODUCTDESC = "ProductDesc";
        private static final String COLUMN_PRICE = "Price";

        /*
        ORDER DETAILS TABLE (contains product information for orders)
        Fields:
            OrderID     NOT NULL
            ProductCode NOT NULL
            Quantity    NOT NULL
            PRIMARY KEY (OrderID, ProductCode) <- Composite Primary Key
            FOREIGN KEY (OrderID) references Orders (OrderID)
            FOREIGN KEY (ProductCode) references Products (ProductCode)
         */
        private static final String TABLE_NAME4 = "\"Order Details\"";
        private static final String COLUMN_QUANTITY = "Quantity";


        //initialize the database
        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, 1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {

            //creates CUSTOMERS table
            String CREATE_TABLE1 = "CREATE TABLE " + TABLE_NAME1 + " (" + COLUMN_CUSTOMERID +
                    " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME + " TEXT, " + COLUMN_EMAIL + " VARCHAR, " +
                    COLUMN_PASSWORD + " VARCHAR);";
            db.execSQL(CREATE_TABLE1);

            //creates ORDERS table
            String CREATE_TABLE2 = "CREATE TABLE " + TABLE_NAME2 + " (" + COLUMN_ORDERID +
                    " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_CUSTOMERID + " INTEGER, " +
                    COLUMN_ORDERDATE + " TEXT," + " FOREIGN KEY (CustomerID) REFERENCES Orders (CustomerID));";
            db.execSQL(CREATE_TABLE2);

            //creates PRODUCTS table
            String CREATE_TABLE3 = "CREATE TABLE " + TABLE_NAME3 + " (" + COLUMN_PRODUCTCODE +
                    " INTEGER PRIMARY KEY, " + COLUMN_PRODUCTNAME + " VARCHAR, " + COLUMN_PRODUCTDESC +
                    " VARCHAR, " + COLUMN_PRICE + " INTEGER);";
            db.execSQL(CREATE_TABLE3);

            //creates ORDER DETAILS table
            String CREATE_TABLE4 = "CREATE TABLE " + TABLE_NAME4 + " (" + COLUMN_ORDERID + " INTEGER NOT NULL, "
                    + COLUMN_PRODUCTCODE + " INTEGER NOT NULL, " + COLUMN_PRODUCTNAME + " VARCHAR, " +
                    COLUMN_PRODUCTDESC + " VARCHAR, " + COLUMN_QUANTITY + " INTEGER, PRIMARY KEY (OrderID, ProductCode), " +
                    "FOREIGN KEY (OrderID) REFERENCES Orders, FOREIGN KEY (ProductCode) REFERENCES Products);";
            db.execSQL(CREATE_TABLE4);
        }

        //Called when the database needs to be upgraded.
        // The implementation should use this method to drop tables, add tables,
        // or do anything else it needs to upgrade to the new schema version
        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME3);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME4);
            onCreate(db);
        }


        //loads the entire table so you can display it
       //We use the rawQuery() method of a SQLiteDatabase object to implement SQL statement and display result via a Cursor object
        public String loadHandler() {

            String result = "";
            String query = "Select*FROM " + TABLE_NAME1;
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(query, null);
            while (cursor.moveToNext()) {
                int result_0 = cursor.getInt(0);
                String result_1 = cursor.getString(1);
                String result_2 = cursor.getString(2);
                String result_3 = cursor.getString(3);
                result += result_0 + " " + result_1 + " " + result_2 + " " + result_3 +
                        System.getProperty("line.separator");
            }
            cursor.close();
            db.close();
            return result;
        }

        //we must use the ContentValues object with the put() method that is used to assign data to ContentsValues object
        //and then use insert() method of SQLiteDatabase object to insert data to the database
       //parameter is new customer object
        public void addHandler(Customer customer) {

            ContentValues values = new ContentValues();
            values.put(COLUMN_NAME, customer.getName());
            values.put(COLUMN_EMAIL, customer.getEmail());
            values.put(COLUMN_PASSWORD, customer.getPassword());
            SQLiteDatabase db = this.getWritableDatabase();
            db.insert(TABLE_NAME1, null, values);
            db.close();
        }


        //finds information in the database by condition
       //parameter is the email/username
       //method returns the customer object linked to that email/username
       public Customer findHandler(String cEmail) {
           String query = "Select * FROM " + TABLE_NAME1 + " WHERE " + COLUMN_EMAIL + " = " + "'" + cEmail + "'";
           SQLiteDatabase db = this.getWritableDatabase();
           Cursor cursor = db.rawQuery(query, null);
           Customer customer = new Customer();
           if (cursor.moveToFirst()) {
               cursor.moveToFirst();
               customer.setName(cursor.getString(1));
               customer.setEmail(cursor.getString(2));
               customer.setPassword(cursor.getString(3));
               cursor.close();
           } else {
               customer = null;
           }
           db.close();
           return customer;
       }


       //deletes a record by condition
       //accepts a name and deletes the row/record affiliated with that name
       //We will save the result that is returned from the implementation of the rawQuery() method
       //of the SQLiteDatabase object into a Cursor object and find the matching result in this object.
       // In the final step, we use the delete() method of the SQLiteDatabase object to delete the record
        public boolean deleteHandler(String name) {

            boolean result = false;
            String query = "Select*FROM " + TABLE_NAME1 + " WHERE " + COLUMN_NAME + "= '" + name + "'";
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(query, null);
            Customer customer = new Customer();
            if (cursor.moveToFirst()) {
                customer.setName(cursor.getString(1));
                db.delete(TABLE_NAME1, COLUMN_NAME + "=?",
                        new String[] {
                    String.valueOf(customer.getName())
                });
                cursor.close();
                result = true;
            }
            db.close();
            return result;
        }

        //updates the information in a record
       //we can use the ContentValues object and the update() method of the SQLiteDatabase object
        public boolean updateHandler(int ID, String name, String email, String password) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues args = new ContentValues();
            args.put(COLUMN_CUSTOMERID, ID);
            args.put(COLUMN_NAME, name);
            args.put(COLUMN_EMAIL, email);
            args.put(COLUMN_PASSWORD, password);

            return db.update(TABLE_NAME1, args, COLUMN_CUSTOMERID + "=" + ID, null) > 0;
        }
    }

