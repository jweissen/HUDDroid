package com.example.niners.hudtest;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

////Show a simple status message with an indeterminate spinner
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


public class ProgressHUD extends Dialog {
    public ProgressHUD(Context context) {
        super(context);
    }

    public ProgressHUD(Context context, int theme) {
        super(context, theme);
    }


    public void onWindowFocusChanged(boolean hasFocus){
        ImageView imageView = (ImageView) findViewById(R.id.spinnerImageView);
        AnimationDrawable spinner = (AnimationDrawable) imageView.getBackground();
        spinner.start();
    }

    public void setMessage(CharSequence message) {
        if(message != null && message.length() > 0) {
            findViewById(R.id.message).setVisibility(View.VISIBLE);
            TextView txt = (TextView)findViewById(R.id.message);
            txt.setText(message);
            txt.invalidate();
        }
    }

    public static ProgressHUD show(Context context, CharSequence message, boolean indeterminate, boolean cancelable,
                                   OnCancelListener cancelListener) {
        ProgressHUD dialog = new ProgressHUD(context,R.style.ProgressHUD);
        dialog.setTitle("");
        dialog.setContentView(R.layout.progress_hud);
        if(message == null || message.length() == 0) {
            dialog.findViewById(R.id.message).setVisibility(View.GONE);
        } else {
            TextView txt = (TextView)dialog.findViewById(R.id.message);
            txt.setText(message);
        }
        dialog.setCancelable(cancelable);
        dialog.setOnCancelListener(cancelListener);
        dialog.getWindow().getAttributes().gravity=Gravity.CENTER;
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.dimAmount=0.2f;
        dialog.getWindow().setAttributes(lp);
        //dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
        dialog.show();
        return dialog;
    }
}