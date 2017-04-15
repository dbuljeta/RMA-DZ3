package com.example.daniel.dz3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by daniel on 13.4.2017..
 */

public class TaskDBHelper extends SQLiteOpenHelper {


    private static TaskDBHelper taskDBHelper = null;

    private TaskDBHelper(Context context) {
        super(context.getApplicationContext(), Schema.DATABASE_NAME, null, Schema.SCHEMA_VERSION);
    }

    static final String CREATE_TABLE_TODO = "CREATE TABLE " + Schema.TABLE_TODO + " (" + Schema.TITLE + " TEXT," + Schema.DESCRIPTION + " TEXT," + Schema.PRIORITY + " TEXT);";
    static final String DROP_TABLE_TODO = "DROP TABLE IF EXISTS " + Schema.TABLE_TODO;
    static final String SELECT_ALL_TASKS = "SELECT " + Schema.TITLE + "," + Schema.DESCRIPTION + "," + Schema.PRIORITY + " FROM " + Schema.TABLE_TODO;

    public static synchronized TaskDBHelper getInstance(Context context) {
        if (taskDBHelper == null) {
            taskDBHelper = new TaskDBHelper(context);
        }
        return taskDBHelper;
    }

    public void Delete(Task task) {
        getWritableDatabase().execSQL("DELETE FROM " + Schema.TABLE_TODO + " WHERE " + Schema.TITLE + "='" + task.getNaslov() + "' AND " + Schema.DESCRIPTION + " ='" + task.getOpisZadatka() + "' AND " + Schema.PRIORITY + " = '" + task.getPrioritet() + "'");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_TODO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_TODO);
        this.onCreate(db);
    }

    public void insertTask(Task task) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Schema.TITLE, task.getNaslov());
        contentValues.put(Schema.DESCRIPTION, task.getOpisZadatka());
        contentValues.put(Schema.PRIORITY, task.getPrioritet());
        SQLiteDatabase writableDatabase = this.getWritableDatabase();
        writableDatabase.insert(Schema.TABLE_TODO, Schema.TITLE, contentValues);
        writableDatabase.close();
    }

    public ArrayList<Task> getAllTasks() {
        final SQLiteDatabase writableDatabase = this.getWritableDatabase();
        Cursor taskCursor = writableDatabase.rawQuery(SELECT_ALL_TASKS, null);
        ArrayList<Task> tasks = new ArrayList<>();
        if (taskCursor.moveToFirst()) {
            do {
                String title = taskCursor.getString(0);
                String description = taskCursor.getString(1);
                String priority = taskCursor.getString(2);
                tasks.add(new Task(title, description, priority));
            } while (taskCursor.moveToNext());
        }
        taskCursor.close();
        writableDatabase.close();
        return tasks;
    }

    public static class Schema {
        private static final int SCHEMA_VERSION = 1;
        private static final String DATABASE_NAME = "Task.db";
        static final String TABLE_TODO = "Tasks";
        static final String TITLE = "Task_name";
        static final String DESCRIPTION = "Task_description";
        static final String PRIORITY = "Task_priority";
    }
}
