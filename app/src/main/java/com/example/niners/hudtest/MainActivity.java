package com.example.niners.hudtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ////Show a simple status message with an indeterminate spinner
        HUDDroid.getInstance().build(this)
                .setMessage("Status Message")
                .setMaskType(MaskType.Clear)
                .show();

//AndHUD.Shared.Show(myActivity, "Status Message", MaskType.Clear);
//
////Show a progress with a filling circle representing the progress amount
//        AndHUD.Shared.ShowProgress(myActivity, "Loading… 60%", 60);
//
////Show a success image with a message
//        AndHUD.Shared.ShowSuccess(myActivity, "It Worked!", MaskType.Clear, TimeSpan.FromSeconds(2));
//
////Show an error image with a message
//        AndHUD.Shared.ShowError(myActivity, "It no worked :()", MaskType.Black, TimeSpan.FromSeconds(2));
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
