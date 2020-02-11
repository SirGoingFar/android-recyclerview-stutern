package com.sirgoingfar.stutern.android_recyclerview_stutern.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.sirgoingfar.stutern.android_recyclerview_stutern.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupActionButtons();
    }

    private void setupActionButtons() {

        //Button: "Single Layout Item"
        findViewById(R.id.cv_option_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SingleLayoutItemActivity.class));
            }
        });


        //Button: "Multiple Layouts Item - Method 1"
        findViewById(R.id.cv_option_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MultipleLayoutItemMtd1Activity.class));
            }
        });

        //Button: "Multiple Layouts Item - Method 2"
        findViewById(R.id.cv_option_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MultipleLayoutItemMth2Activity.class));
            }
        });
    }
}
