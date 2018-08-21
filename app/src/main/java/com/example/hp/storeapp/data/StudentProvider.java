package com.example.hp.storeapp.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class StudentProvider extends ContentProvider {
    public static final String LOG_TAG = StudentProvider.class.getSimpleName();
    private static final int STD = 100;
    private static final int STD_ID = 101;
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        sUriMatcher.addURI(contract.CONTENT_AUTHORITY, contract.PATH_STD, STD);
        sUriMatcher.addURI(contract.CONTENT_AUTHORITY, contract.PATH_STD + "/#", STD_ID);

    }
    private Studentdbhelper stdhelper;
    @Override
    public boolean onCreate() {
        stdhelper = new Studentdbhelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,

                        String sortOrder) {
        SQLiteDatabase database = stdhelper.getReadableDatabase();
        Cursor cursor;
        int match = sUriMatcher.match(uri);
        switch (match) {
            case STD:
                cursor = database.query(contract.StdEntry.TABLE_NAME, projection, selection, selectionArgs,

                        null, null, sortOrder);

                break;
            case STD_ID:
                selection = contract.StdEntry._ID + "=?";

                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };



                // This will perform a query on the pets table where the _id equals 3 to return a

                // Cursor containing that row of the table.

                cursor = database.query(contract.StdEntry.TABLE_NAME, projection, selection, selectionArgs,

                        null, null, sortOrder);

                break;
            default:

                throw new IllegalArgumentException("Cannot query unknown URI " + uri);


        }
        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
