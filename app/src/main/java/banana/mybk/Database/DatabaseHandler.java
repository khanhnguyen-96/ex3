package banana.mybk.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "BKManager";
    public static final int DATABASE_VERSION = 4;
    public static final String TABLE_NAME = "subjects";

    public static final String KEY_CODE = "code";
    public static final String KEY_NAME = "name";
    public static final String KEY_CREDIT = "credit";
    public static final String KEY_CREDIT_FEE = "credit_fee";
    public static final String KEY_FEE = "fee";
    public static final String KEY_GROUP = "'group'";
    public static final String KEY_DATE = "date";
    public static final String KEY_LESSON = "lesson";
    public static final String KEY_ROOM = "room";
    public static final String KEY_WEEK = "week";
    public static final String KEY_DAY = "day";
    public static final String KEY_TIME = "time";
    public static final String KEY_EXAM_ROOM = "examRoom";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_Subjects_table = "create table "
                + TABLE_NAME + "( "  + KEY_CODE + ", " + KEY_NAME + ", " + KEY_CREDIT + ", " + KEY_CREDIT_FEE + ", " + KEY_FEE +
                ", " + KEY_GROUP + ", " + KEY_DATE + ", " + KEY_LESSON + ", " + KEY_ROOM + ", " + KEY_WEEK +
                ", " + KEY_DAY + ", " + KEY_TIME + ", " + KEY_EXAM_ROOM + ");";
        db.execSQL(create_Subjects_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_Subjects_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(drop_Subjects_table);

        onCreate(db);
    }
}