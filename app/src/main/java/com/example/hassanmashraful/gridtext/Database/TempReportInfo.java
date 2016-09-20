package com.example.hassanmashraful.gridtext.Database;

/**
 * Created by Hassan M.Ashraful on 9/7/2016.
 */
public class TempReportInfo {

    public static abstract class NewTempInfo{

        public static final String Product_ID = "product_id";
        public static final String Product_NAME = "product_name";
        public static final String Product_QUANTITY = "product_quantity";
        public static final String Product_PRICE = "product_price";
        public static final String Product_TOTAL = "product_total";
        public static final String TEMPR_INFO_TABEL_NAME = "temp_table_info";

    }


    public static abstract class ReceiptInfo {
        public static final String Receipt_ID = "r_id";
        public static final String Pro_ID = "p_id";
        public static final String Receipt_Date = "r_date";
        public static final String Receipt_Month = "r_month";
        public static final String Receipt_Year = "r_year";
        public static final String Receipt_Time = "r_time";
        public static final String Pro_Total = "receipt_total";
        public static final String RECEIPT_INFO_TABLE_NAME = "receipt_table_info";
    }
}
