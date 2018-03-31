package com.smartcook.smartcook.DBManager;

/**
 * Created by Kennedy Agusi on 3/24/2018.
 */

public class DBSchema {
    public static final int VERSION = 1;
    public static final String DATABASE_NAME = "smart_cook.db";

    public static final class ItemTable {
        public static final String NAME = "item";
        public static final class Cols {
            public static final String DATE = "date";
            public static final String FOODITEMS = "fooditems";
            public static final String RECIPENAME = "recipename";
            public static final String RECIPE = "recipe";
            public static final String DIRECTIONS = "directions";
        }
    }
}

