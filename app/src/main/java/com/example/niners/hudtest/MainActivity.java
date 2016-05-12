package com.example.niners.hudtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        HUDDroid.show(this, "message", MaskType.Black);
        HUDDroid.showSuccess(this, "It worked!", MaskType.Black, DisplayTime.fromSeconds(2));
    }
}
