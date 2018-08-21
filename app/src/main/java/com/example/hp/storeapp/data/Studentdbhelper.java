package com.example.hp.storeapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.hp.storeapp.data.contract.StdEntry;

public class Studentdbhelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = Studentdbhelper.class.getSimpleName();
    private static final String DATABASE_NAME = "shelter.db";
    private static final int DATABASE_VERSION = 1;
    public Studentdbhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Create a String that contains the SQL statement to create the pets table

        String SQL_CREATE_PETS_TABLE =  "CREATE TABLE " +StdEntry.TABLE_NAME + " ("

                + StdEntry.STD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "

                + StdEntry.COLUMN_STD_NAME + " TEXT NOT NULL, "

                + StdEntry.COLUMN_STD_GENDER + " TEXT NOT NULL, "

                + StdEntry.COLUMN_STD_BRANCH + " TEXT NOT NULL );";



        // Execute the SQL statement

        sqLiteDatabase.execSQL(SQL_CREATE_PETS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
