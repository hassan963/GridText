package com.example.hassanmashraful.gridtext.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hassanmashraful.gridtext.FragmentView.FragmentGridView;
import com.example.hassanmashraful.gridtext.FragmentView.FragmentListView;
import com.example.hassanmashraful.gridtext.R;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements FragmentGridView.onFoodItemListener {

    ListView listView;
    ArrayList<String> buttons;
    FragmentGridView fragment;
    Button sumFood;
    FragmentListView fragmentListView;
    Float sum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp_main_layout);


        if (getSupportFragmentManager().findFragmentById(R.id.containerList) == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.containerList, new FragmentListView()).commit();

        }

        if (getSupportFragmentManager().findFragmentById(R.id.containerGrid) == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.containerGrid, new FragmentGridView()).commit();
        }

       /* if (getSupportFragmentManager().findFragmentById(R.id.containerReceipt) == null){
            getSupportFragmentManager().beginTransaction().add(R.id.containerReceipt, new FragmentReceipt()).commit();
        }
*/
        fragment = (FragmentGridView) getSupportFragmentManager().findFragmentById(R.id.containerGrid);
        fragmentListView = (FragmentListView) getSupportFragmentManager().findFragmentById(R.id.containerList);

        listView = (ListView) findViewById(R.id.categoryList);
        sumFood = (Button) findViewById(R.id.sumFood);


        buttons = new ArrayList<>();
        buttons.add("Rice");
        buttons.add("Drinks");
        buttons.add("Buffo");
        ArrayAdapter<String> marrayAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.list_category, R.id.categoryBTN, buttons);
        listView.setAdapter(marrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //fragment.updateAdapter(position);
                //fragment.notifyDataChange();
                fragment.setRice(position);


            }
        });

        sumFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "MAIN ACTIVITY", Toast.LENGTH_SHORT).show();
                fragmentListView.showFOOD();
            }
        });




    }

  /* public void sumFood(View view){
        Toast.makeText(getApplicationContext(), "MAIN ACTIVITY", Toast.LENGTH_SHORT).show();
        fragmentListView.showFOOD();
    }*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setFoodItem(String name, String price) {
        //FragmentListView fragmentListView = (FragmentListView) getSupportFragmentManager().findFragmentById(R.id.containerList);
        //fragmentListView.updateInfo(name, price);
        //sum =  fragmentListView.getSum();
        //sumFood.setText(String.valueOf(sum));
    }


    // A method to find height of the status bar
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }


}
