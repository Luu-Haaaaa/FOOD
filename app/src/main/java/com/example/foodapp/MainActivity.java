package com.example.foodapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String mChooseDonut, mGetDonut;
    private String mChooseIcecream, mGetIcecream;
    private String mChooseFroyo, mGetFroyo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.cart_node);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("ViewCart", "Show Cart ok!");
                Intent show_cart = new Intent(MainActivity.this, YourCart.class);
                startActivity(show_cart);
            }
        });
    }

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

    public static final String EXTRA_MESSAGE = "com.example.foodapp.extra.MESSAGE";

    private Toast lastToast;
    public void displayToast(String message){
       Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG);
       if (lastToast != null)
           lastToast.cancel();
       toast.show();
       lastToast = toast;
    }

    public void FroYoOrder(View view) {
        Intent choose_froyo = new Intent(MainActivity.this, YourCart.class);
        mChooseFroyo = getString(R.string.froyo_order_message);
        mGetFroyo = getString(R.string.choose_froyo);
        choose_froyo.putExtra(EXTRA_MESSAGE, mGetFroyo);
        startActivity(choose_froyo);
        displayToast(mChooseFroyo);

    }

    public void IceCreamOrder(View view) {
        Intent choose_icecream = new Intent(MainActivity.this, YourCart.class);
        mChooseIcecream = getString(R.string.ice_cream_order_message);
        mGetIcecream = getString(R.string.choose_ice_cream);
        choose_icecream.putExtra(EXTRA_MESSAGE, mGetIcecream);
        startActivity(choose_icecream);
        displayToast(mChooseIcecream);
    }

    public void DonutOrder(View view) {
        Intent choose_donut = new Intent(MainActivity.this, YourCart.class);
        mChooseDonut = getString(R.string.donut_order_message);
        mGetDonut = getString(R.string.choose_donut);
        choose_donut.putExtra(EXTRA_MESSAGE,mGetDonut);
        startActivity(choose_donut);
        displayToast(mChooseDonut);
    }


}