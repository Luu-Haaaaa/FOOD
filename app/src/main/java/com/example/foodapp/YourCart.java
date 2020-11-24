package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class YourCart extends AppCompatActivity {
    private TextView view_item_order, view_ice_cream;
    private ImageButton add, remove;
    private int count = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_cart);
        //
        view_item_order = findViewById(R.id.donut_cart);
        Intent intent_view_item_order = getIntent();
        String mess_order = intent_view_item_order.getStringExtra(MainActivity.EXTRA_MESSAGE);
        view_item_order.setText(mess_order);
        //
        view_ice_cream = findViewById(R.id.ice_cream_cart);


        //
        add = findViewById(R.id.add_button_2);
        this.add.setOnClickListener(new ImageButton.OnClickListener(){
            @Override
            public void onClick(View v){
                count++;
                TextView number = (TextView) findViewById(R.id.number_item2);
                number.setText(String.valueOf(count));
            }
        });

        remove = findViewById(R.id.remove_button_2);
        this.remove.setOnClickListener(new ImageButton.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(count>1){
                    count--;
                    TextView number = (TextView) findViewById(R.id.number_item2);
                   number.setText(String.valueOf(count));
                }
            }

        });
    }



    public void onSaveInstanceState(Bundle view_item_order){
        super.onSaveInstanceState(view_item_order);
    }


    public void BackOnCart(View view) {
        YourCart.this.finish();
    }

    public void nextToOrder(View view) {
        Log.d("nextToOder", "View Order OK!!");
        Intent next_to_oder = new Intent(this, OrderActivity.class);
        startActivity(next_to_oder);
    }

}