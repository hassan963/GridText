package com.example.hassanmashraful.gridtext.Task;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.hassanmashraful.gridtext.Database.DataBaseHelper;

/**
 * Created by Hassan M.Ashraful on 9/8/2016.
 */
public class BackgroundTask extends AsyncTask<String, Void, String> {

    Context context;

    public BackgroundTask(Context context){
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {

        String method = params[0];
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);
        if (method.equals("add_temp")){

            int p_id = Integer.parseInt(params[1]);
            String p_name = params[2];
            Float p_price = Float.parseFloat(params[3]);
            int p_quantity = Integer.parseInt(params[4]);
            Float p_total = p_price * p_quantity;
            SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
            dataBaseHelper.addTempTableInfo(db, p_id, p_name, p_price, p_quantity);

            return p_name+" :::: "+p_total;

        }


        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
    }
}
