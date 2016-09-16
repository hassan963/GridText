package com.example.hassanmashraful.gridtext.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Hassan M.Ashraful on 9/7/2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String POS_INFO_DB_NAME = "POSDB.DB";
    private static final int POS_INFO_DB_VERSION = 1;

    private static final String TEMP_INFO_CREATE_QUERY = "CREATE TABLE "+ TempReportInfo.NewTempInfo.TEMPR_INFO_TABEL_NAME +"("+ TempReportInfo.NewTempInfo.Product_NAME+" TEXT NOT NULL,"+ TempReportInfo.NewTempInfo.Product_PRICE +" REAL NOT NULL,"+ TempReportInfo.NewTempInfo.Product_QUANTITY +" INTEGER NOT NULL,"+ TempReportInfo.NewTempInfo.Product_TOTAL +" REAL NOT NULL);";




    public DataBaseHelper(Context context) {
        super(context, POS_INFO_DB_NAME, null, POS_INFO_DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TEMP_INFO_CREATE_QUERY);
        Log.e("DB :::: ::: ::", "CREATED :::");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TempReportInfo.NewTempInfo.TEMPR_INFO_TABEL_NAME);
        onCreate(db);

    }


    public void addTempTableInfo(SQLiteDatabase db, String p_name, float p_price, int p_quantity, float p_total){

        ContentValues contentValues = new ContentValues();
        contentValues.put(TempReportInfo.NewTempInfo.Product_NAME, p_name);
        contentValues.put(TempReportInfo.NewTempInfo.Product_PRICE, p_price);
        contentValues.put(TempReportInfo.NewTempInfo.Product_QUANTITY, p_quantity);
        contentValues.put(TempReportInfo.NewTempInfo.Product_TOTAL, p_total);

        db.insert(TempReportInfo.NewTempInfo.TEMPR_INFO_TABEL_NAME, null, contentValues);


    }


}
