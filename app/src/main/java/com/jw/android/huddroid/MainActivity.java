package com.jw.android.huddroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Show a simple status message with an indeterminate spinner
        //AndHUD.Shared.Show(myActivity, "Status Message", MaskType.Clear);
/**
        HUDDroid.getInstance().build(this)
                .setMessage("Status Message")
                .setMaskType(MaskType.Clear)
                .show();

        //Show a progress with a filling circle representing the progress amount
        //AndHUD.Shared.ShowProgress(myActivity, "Loading… 60%", 60);
        HUDDroid.getInstance().build(this, 60)
                .setMessage("Loading... 60%")
                .show();


        //Show a success image with a message
        //AndHUD.Shared.ShowSuccess(myActivity, "It Worked!", MaskType.Clear, TimeSpan.FromSeconds(2));
        HUDDroid.getInstance().buildSuccess(this)
                .setMessage("It Worked!")
                .setMaskType(MaskType.Clear)
                .setTimeSpan(TimeSpan.fromSeconds(2))
                .show();
*/

        //Show an error image with a message
        //AndHUD.Shared.ShowError(myActivity, "It no worked :()", MaskType.Black, TimeSpan.FromSeconds(2));
        HUDDroid.getInstance().buildFailureWithStatus(this, "It no worked :()")
                .setMaskType(MaskType.Black)
                .setTimeSpan(TimeSpan.fromSeconds(2))
                .show();

//
////Show a toast, similar to Android native toasts, but styled as AndHUD
//        AndHUD.Shared.ShowToast(myActivity, "This is a non-centered Toast…", MaskType.Clear, TimeSpan.FromSeconds(2));
//
////Show a custom image with text
//        AndHUD.Shared.ShowImage(myActivity, Resource.Drawable.MyCustomImage, "Custom");
//
////Dismiss a HUD that will or will not be automatically timed out
//        AndHUD.Shared.Dismiss(myActivity);
//
////Show a HUD and only close it when it's clicked
//        AndHUD.Shared.ShowToast(this, "Click this toast to close it!", MaskType.Clear, null, true, () => AndHUD.Shared.Dismiss(this));


    }
}
