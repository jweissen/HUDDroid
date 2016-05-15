package com.example.niners.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jw.android.huddroid.HUDDroid;
import com.jw.android.huddroid.MaskType;
import com.jw.android.huddroid.TimeSpan;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Show a simple status message with an indeterminate spinner
        HUDDroid.getInstance().build(this)
             .setMessage("Status Message")
             .setMaskType(MaskType.Clear)
             .show();

 //Show a progress with a filling circle representing the progress amount
 HUDDroid.getInstance().build(this, 60)
 .setMessage("Loading... 60%")
 .show();


 //Show a success image with a message
 HUDDroid.getInstance().buildSuccess(this)
 .setMessage("It Worked!")
 .setMaskType(MaskType.Clear)
 .setTimeSpan(TimeSpan.fromSeconds(2))
 .show();


        //Show an error image with a message
        HUDDroid.getInstance().buildFailureWithStatus(this, "It no worked :()")
                .setMaskType(MaskType.Black)
                .setTimeSpan(TimeSpan.fromSeconds(2))
                .show();
 */


//Show a toast, similar to Android native toasts, but styled as AndHUD
HUDDroid.getInstance().buildToast(this, "This is a non-centered Toast...")
    .setMaskType(MaskType.Clear)
    .setTimeSpan(TimeSpan.fromSeconds(2));

////Show a custom image with text
        HUDDroid.getInstance().buildImage(this, R.drawable.customImage)
                .setMessage("Custom");


//Dismiss a HUD that will or will not be automatically timed out
HUDDroid.getInstance().dismissCurrent();

//
//Show a HUD and only close it when it's clicked
HUDDroid.getInstance().buildToast(this, "Click this toast to close it!")
        .setMaskType(MaskType.Clear)
        .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HUDDroid.getInstance().dismissCurrent();
            }
        }).show();

    }
}
