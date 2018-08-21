package com.example.hp.storeapp.data;

import android.net.Uri;
import android.provider.BaseColumns;

public class contract {
    private contract(){}
    public static final String CONTENT_AUTHORITY ="com.example.hp.storeapp";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_STD = "students";
    public static final class StdEntry implements BaseColumns{

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_STD);
        public final static String TABLE_NAME = "students";
        public final static String STD_ID = BaseColumns._ID;
        public final static String COLUMN_STD_NAME = "Name";
        public final static String COLUMN_STD_GENDER = "Gender";
        public final static String COLUMN_STD_BRANCH = "Branch";
        public static final int GENDER_UNKNOWN = 0;

        public static final int GENDER_MALE = 1;

        public static final int GENDER_FEMALE = 2;


    }
}
