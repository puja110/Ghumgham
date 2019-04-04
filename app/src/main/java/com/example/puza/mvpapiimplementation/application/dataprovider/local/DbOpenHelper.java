package com.example.puza.mvpapiimplementation.application.dataprovider.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.puza.mvpapiimplementation.application.dataprovider.local.DbSetup.DB_NAME;
import static com.example.puza.mvpapiimplementation.application.dataprovider.local.DbSetup.DB_VERSION;

public class DbOpenHelper extends SQLiteOpenHelper {

    public DbOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.beginTransaction();
        try {
//            db.execSQL(DbSetup.MasterTable.CREATE_TABLE);

            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.beginTransaction();
        try {
            db.execSQL("DROP TABLE IF EXISTS " + DbSetup.MasterTable.TABLE_CMIS_MASTER);
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
        onCreate(db);
    }
}
