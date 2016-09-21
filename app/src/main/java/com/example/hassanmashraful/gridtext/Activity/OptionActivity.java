package com.example.hassanmashraful.gridtext.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.hassanmashraful.gridtext.R;

/**
 * Created by Hassan M.Ashraful on 9/21/2016.
 */
public class OptionActivity extends AppCompatActivity {

    Button posBTN, adminBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_option);

        posBTN = (Button) findViewById(R.id.posBTN);
        adminBTN = (Button) findViewById(R.id.adminBTN);
    }


    public void posBTN(View view) {
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }


    public void adminBTN(View view) {
        Intent intent = new Intent(getApplicationContext(), ChartActivity.class);
        startActivity(intent);
    }
}
