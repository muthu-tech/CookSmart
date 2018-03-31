package com.smartcook.smartcook.DBManager;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.smartcook.smartcook.Models.Items;

/**
 * Created by Kennedy Agusi on 3/24/2018.
 */

public class DBCursorWrapper extends CursorWrapper {
    Cursor cursor;
    public DBCursorWrapper(Cursor cursor) {
        super(cursor);
        this.cursor = cursor;
    }

    public Items getItems() {
        int eventid = cursor.getInt(cursor.getColumnIndex("itemid"));
        String date = cursor.getString(cursor.getColumnIndex(DBSchema.ItemTable.Cols.DATE));
        String foodItems = cursor.getString(cursor.getColumnIndex(DBSchema.ItemTable.Cols.FOODITEMS));
        String recipeName = cursor.getString(cursor.getColumnIndex(DBSchema.ItemTable.Cols.RECIPENAME));
        String recipe = cursor.getString(cursor.getColumnIndex(DBSchema.ItemTable.Cols.RECIPE));
        String direct = cursor.getString(cursor.getColumnIndex(DBSchema.ItemTable.Cols.DIRECTIONS));

        Items item = new Items(date, foodItems);
        item.setRecipeName(recipeName);
        item.setReceipeSuggestion(recipe);
        item.setDirections(direct);

        return item;

    }

}