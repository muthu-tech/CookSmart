package com.smartcook.smartcook.DBManager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.smartcook.smartcook.Models.Items;

import com.smartcook.smartcook.DBManager.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kennedy Agusi on 3/24/2018.
 */

public class ModelQueryManager {
    private static ModelQueryManager MODELMANAGER;

    private final Context mContext;
    private final SQLiteDatabase mDatabase;

    private ModelQueryManager(Context context){

        mContext = context.getApplicationContext();
        mDatabase = new DBHelper(mContext).getWritableDatabase();

    }
    public static ModelQueryManager get(Context context) {
        MODELMANAGER = new ModelQueryManager(context);
        return MODELMANAGER;
    }

    //Create item
    public void createItem(Items item)
    {
        ContentValues values = getAEventContentvalues(item);
        mDatabase.insert(DBSchema.ItemTable.NAME, null, values);
    }

    //Create an event Contentvalues
    private static ContentValues getAEventContentvalues(Items item) {

        ContentValues values = new ContentValues();
        values.put(DBSchema.ItemTable.Cols.DATE, item.getDatePurchased());
        values.put(DBSchema.ItemTable.Cols.FOODITEMS, item.getFoodItems());
        values.put(DBSchema.ItemTable.Cols.RECIPE, item.getReceipeSuggestion());
        values.put(DBSchema.ItemTable.Cols.RECIPENAME, item.getRecipeName());
        values.put(DBSchema.ItemTable.Cols.DIRECTIONS, item.getDirections());
        return values;
    }

    //Retrieve list of events for a specific date
    public List<Items> getItem(String[] itm){

        Log.d("ITEM", "ITEM :" +itm[0]);
        List<Items> items = new ArrayList<>();

        String myQuery = "";

        if(itm[0].contains("Fresh Mushrroms")){

            myQuery = 	"SELECT * FROM item WHERE fooditems LIKE '%mushr%'";
        }

        else if(itm[0].contains("Garlic")){
            Log.d("ITEM", "Hello");
            myQuery = 	"SELECT * FROM item WHERE fooditems LIKE '%Garlic%'";
        }

        else
            myQuery = 	"SELECT * FROM item WHERE instr(fooditems," +  "'"+ itm[0]+ "'" + ")> 0";

        Cursor cursor = mDatabase.rawQuery(myQuery, null);

        DBCursorWrapper wrapper = new DBCursorWrapper(cursor);

        try {
            wrapper.moveToFirst();
            while(wrapper.isAfterLast() == false) {
                Items item = wrapper.getItems();
                items.add(item);
                wrapper.moveToNext();
            }
        }
        finally {
            cursor.close();
            wrapper.close();
        }

        return items;

    }
}
