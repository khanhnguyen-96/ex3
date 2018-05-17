package banana.mybk.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ScheduleDataSource {
    private SQLiteDatabase database;
    private DatabaseHandler dbHandler;

    public ScheduleDataSource(Context context) {
        dbHandler = new DatabaseHandler(context);
    }

    public void open() throws SQLException {
        database = dbHandler.getWritableDatabase();
    }

    public void close() {
        dbHandler.close();
    }

    public void createSubject(String code, String name, long credit, long credit_fee, long fee, String group, long date, String lesson,
                              String room, String week, String day, String time, String examRoom) {
        database = this.dbHandler.getWritableDatabase();
        String sql =
                "INSERT INTO " + DatabaseHandler.TABLE_NAME + " (code, name, credit, credit_fee, fee, 'group', date, lesson, room, week, day, time, examRoom) VALUES" + "( " + code + ", " + name + ", " + credit + ", " + credit_fee +  ", " +
                        fee +  ", " + group +  ", " + date +  ", " + lesson +  ", " + room +  ", " + week + ", " + day + ", " + time + ", " + examRoom + " );" ;
        database.execSQL(sql);
        database.close();
    }

    public List<Subject> getAllSubject() {
        List<Subject> schedule = new ArrayList<>();
        database = this.dbHandler.getReadableDatabase();
        String query = "SELECT * FROM " + DatabaseHandler.TABLE_NAME;
        SQLiteDatabase db = this.dbHandler.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            Subject Subject = new Subject(cursor.getString(0), cursor.getString(1), cursor.getLong(2), cursor.getLong(3),
                    cursor.getLong(4), cursor.getString(5), cursor.getLong(6), cursor.getString(7), cursor.getString(8), cursor.getString(9)
            , cursor.getString(10), cursor.getString(11), cursor.getString(12));
            schedule.add(Subject);
            cursor.moveToNext();
        }
        cursor.close();
        return schedule;
    }

    public void deleteSubject(String code) {
        database = dbHandler.getWritableDatabase();
        database.delete(DatabaseHandler.TABLE_NAME, DatabaseHandler.KEY_CODE + " = ?", new String[] { String.valueOf(code) });
        database.close();
    }
}
