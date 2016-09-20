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
    private static final int POS_INFO_DB_VERSION = 4;

    private static final String TEMP_INFO_CREATE_QUERY = "CREATE TABLE " + TempReportInfo.NewTempInfo.TEMPR_INFO_TABEL_NAME + "(" + TempReportInfo.NewTempInfo.Product_ID + " INTEGER NOT NULL," + TempReportInfo.NewTempInfo.Product_NAME + " TEXT NOT NULL," + TempReportInfo.NewTempInfo.Product_PRICE + " REAL NOT NULL," + TempReportInfo.NewTempInfo.Product_QUANTITY + " INTEGER NOT NULL);";

    private static final String RECEIPT_INFO_CREATE_QUERY = "CREATE TABLE " + TempReportInfo.ReceiptInfo.RECEIPT_INFO_TABLE_NAME + "(" + TempReportInfo.ReceiptInfo.Receipt_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + TempReportInfo.ReceiptInfo.Pro_ID + " INTEGER NOT NULL," + TempReportInfo.ReceiptInfo.Receipt_Date + " TEXT NOT NULL," + TempReportInfo.ReceiptInfo.Receipt_Month + " TEXT NOT NULL," + TempReportInfo.ReceiptInfo.Receipt_Year + " TEXT NOT NULL," + TempReportInfo.ReceiptInfo.Receipt_Time + " TEXT NOT NULL," + TempReportInfo.ReceiptInfo.Pro_Total + " REAL NOT NULL);";



    public DataBaseHelper(Context context) {
        super(context, POS_INFO_DB_NAME, null, POS_INFO_DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TEMP_INFO_CREATE_QUERY);
        db.execSQL(RECEIPT_INFO_CREATE_QUERY);
        Log.e("DB :::: ::: ::", "CREATED :::");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TempReportInfo.NewTempInfo.TEMPR_INFO_TABEL_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TempReportInfo.ReceiptInfo.RECEIPT_INFO_TABLE_NAME);
        onCreate(db);

    }


    public void addTempTableInfo(SQLiteDatabase db, int p_key, String p_name, float p_price, int p_quantity) {

        ContentValues contentValues = new ContentValues();

        contentValues.put(TempReportInfo.NewTempInfo.Product_ID, p_key);
        contentValues.put(TempReportInfo.NewTempInfo.Product_NAME, p_name);
        contentValues.put(TempReportInfo.NewTempInfo.Product_PRICE, p_price);
        contentValues.put(TempReportInfo.NewTempInfo.Product_QUANTITY, p_quantity);

        db.insert(TempReportInfo.NewTempInfo.TEMPR_INFO_TABEL_NAME, null, contentValues);
        //db.close();

    }


    public void addReceiptTableInfo(SQLiteDatabase db, int p_key, String date, String month, String year, String time, Float p_total) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(TempReportInfo.ReceiptInfo.Pro_ID, p_key);
        contentValues.put(TempReportInfo.ReceiptInfo.Receipt_Date, date);
        contentValues.put(TempReportInfo.ReceiptInfo.Receipt_Month, month);
        contentValues.put(TempReportInfo.ReceiptInfo.Receipt_Year, year);
        contentValues.put(TempReportInfo.ReceiptInfo.Receipt_Time, time);
        contentValues.put(TempReportInfo.ReceiptInfo.Pro_Total, p_total);

        db.insert(TempReportInfo.ReceiptInfo.RECEIPT_INFO_TABLE_NAME, null, contentValues);
        //db.close();

    }


}
