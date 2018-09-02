package databasedemo.com.example.raj.ivy.databasedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import databasedemo.com.example.raj.ivy.dao.UserDao;
import databasedemo.com.example.raj.ivy.model.UserData;

public class DBAdapter extends UserData implements UserDao {

    DBHelper dbHelper;
    Context context;

    public DBAdapter(Context context) {
        this.context = context;
        dbHelper = new DBHelper(context);
    }


    @Override
    public void addUser(UserData userData) {

    }

    @Override
    public void updateUser(UserData userData) {

    }

    @Override
    public void deleteUser(UserData userData) {

    }

    @Override
    public void displayUser(UserData userData) {

    }

    public static class DBHelper extends SQLiteOpenHelper{

        private static final String DATABASE = "databasedemodb";
        private static final String TABLE = "users";
        private static final String USERNAME = "username";
        private static final String EMAIL = "email";
        private static final String PASSWORD = "password";
        private static final String CREATETABLE = "" +
                "create table users" +
                "(" +
                "username varchar (20) primary key," +
                "name varchar (40)" +
                "email varchar (50)" +
                "password varchar (20)";


        //Because the activity will run in the background.
        Context context;

        public DBHelper (Context context){
            super(context, DATABASE, null, 1);
            this.context = context;
        }

        /**
         * Called when the database is created for the first time. This is where the
         * creation of tables and the initial population of the tables should happen.
         *
         * @param db The database.
         */
        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL(CREATETABLE);

        }

        /**
         * Called when the database needs to be upgraded. The implementation
         * should use this method to drop tables, add tables, or do anything else it
         * needs to upgrade to the new schema version.
         * <p>
         * <p>
         * The SQLite ALTER TABLE documentation can be found
         * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
         * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
         * you can use ALTER TABLE to rename the old table, then create the new table and then
         * populate the new table with the contents of the old table.
         * </p><p>
         * This method executes within a transaction.  If an exception is thrown, all changes
         * will automatically be rolled back.
         * </p>
         *
         * @param db         The database.
         * @param oldVersion The old database version.
         * @param newVersion The new database version.
         */
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table users");
            db.execSQL(CREATETABLE);
        }
    }


}
