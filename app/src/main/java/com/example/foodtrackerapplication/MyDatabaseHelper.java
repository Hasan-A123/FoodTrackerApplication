package com.example.foodtrackerapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


    public class MyDatabaseHelper extends SQLiteOpenHelper {

        public static final String DATABASE_NAME = "foodTracker.db";
        public static final String TABLE_NAME = "tracker_table";
        public static final String COL_1 = "_id";
        public static final String COL_2 = "DAY";
        public static final String COL_3 = "MEAL";

        public static final String COL_4 = "FOOD";

        public static final String COL_5 = "DRINK";

        public static final String COL_6 = "SNACKS";


        public MyDatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, 1);
            //SQLiteDatabase db =this.getWritableDatabase();
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("create table " + TABLE_NAME + "(" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_2 + " TEXT, " + COL_3 + " TEXT, " + COL_4 + " TEXT, " + COL_5 + " TEXT, " + COL_6 + " TEXT)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        }

        public boolean insertData(String ID, String day, String meal, String food, String drink, String snacks) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(COL_2, day);
            contentValues.put(COL_3, meal);
            contentValues.put(COL_4, food);
            contentValues.put(COL_5, drink);
            contentValues.put(COL_6, snacks);

            long result = db.insert(TABLE_NAME, null, contentValues);
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }

        public Cursor getAllData() {
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
            return res;
        }

        public boolean updateData(String ID, String day, String meal, String food, String drink, String snacks) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(COL_1, ID);
            contentValues.put(COL_2, day);
            contentValues.put(COL_3, meal);
            contentValues.put(COL_4, food);
            contentValues.put(COL_5, drink);
            contentValues.put(COL_6, snacks);

            db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{ID});
            return true;
        }


        public Cursor getData(String id) {
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
            return res;}




        public Integer deleteData(String id) {
            SQLiteDatabase db = this.getWritableDatabase();
            return db.delete(TABLE_NAME, "ID = ?", new String[]{id});
        }

        public String[] getAllColumns() {
            return new String[]  {COL_1, COL_2, COL_3, COL_4, COL_5, COL_6};
        }
        public Cursor getData(long id) {
            Cursor c;
            SQLiteDatabase db = this.getReadableDatabase();
            String[] columns = {COL_1, COL_2, COL_3, COL_4, COL_5, COL_6};
            String where = COL_1 + "=" + id;
            c = db.query(
                    true,
                    TABLE_NAME,
                    columns,
                    where,
                    null,
                    null,
                    null,
                    null,
                    null);

            if (c != null) {
                c.moveToFirst();
            }
            return c;
        }
    }



