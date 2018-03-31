package com.smartcook.smartcook.DBManager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Kennedy Agusi on 3/24/2018.
 */

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, DBSchema.DATABASE_NAME, null, DBSchema.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + DBSchema.ItemTable.NAME
                + "(itemid integer primary key autoincrement, "
                + DBSchema.ItemTable.Cols.DATE + ", "
                + DBSchema.ItemTable.Cols.FOODITEMS + ", "
                + DBSchema.ItemTable.Cols.RECIPE+ ", "
                + DBSchema.ItemTable.Cols.DIRECTIONS+ ", "
                + DBSchema.ItemTable.Cols.RECIPENAME + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}

