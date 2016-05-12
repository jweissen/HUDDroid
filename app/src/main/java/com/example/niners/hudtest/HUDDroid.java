package com.example.niners.hudtest;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
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


public class HUDDroid extends Dialog {

    private DisplayTime length;

    public HUDDroid(Context context) {
        super(context);
    }

    public HUDDroid(Context context, int theme) {
        super(context, theme);
    }


    public void onWindowFocusChanged(boolean hasFocus){
        ImageView imageView = (ImageView) findViewById(R.id.spinnerImageView);
        AnimationDrawable spinner = (AnimationDrawable) imageView.getBackground();
        if (spinner != null) {
            spinner.start();
        }
    }

    public void setMessage(CharSequence message) {
        if(message != null && message.length() > 0) {
            findViewById(R.id.message).setVisibility(View.VISIBLE);
            TextView txt = (TextView)findViewById(R.id.message);
            txt.setText(message);
            txt.invalidate();
        }
    }

    //Show a simple status message with an indeterminate spinner
    //AndHUD.Shared.Show(myActivity, "Status Message", MaskType.Clear);
    public static HUDDroid show(Context activityContext, String message, MaskType maskType) {
        HUDDroid dialog = buildBasicHUD(activityContext)
                .setMessage(message)
                .setMaskType(maskType);

        dialog.show();
        return dialog;
    }

    ////Show an error image with a message
    // AndHUD.Shared.ShowError(myActivity, "It no worked :()", MaskType.Black, TimeSpan.FromSeconds(2));
    public static HUDDroid showError(Context activityContext, String message, MaskType maskType, DisplayTime length) {
        HUDDroid dialog = buildBasicHUD(activityContext)
                .setMaskType(maskType)
                .setMessage(message)
                .setDisplayTime(length)
                .setIcon(IconType.Failure);
        dialog.show();
        return dialog;
    }


    //    AndHUD.Shared.ShowSuccess(myActivity, "It Worked!", MaskType.Clear, TimeSpan.FromSeconds(2));
    public static HUDDroid showSuccess(Context activityContext, String message, MaskType maskType, DisplayTime length) {
        HUDDroid dialog = buildBasicHUD(activityContext)
                .setMaskType(maskType)
                .setMessage(message)
                .setDisplayTime(length)
                .setIcon(IconType.Success);
        dialog.show();
        return dialog;
    }


    public static HUDDroid show(Context context, CharSequence message, boolean indeterminate, boolean cancelable,
                                OnCancelListener cancelListener) {
        HUDDroid dialog = new HUDDroid(context,R.style.ProgressHUD);
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


    /** overrides **/
    @Override
    public void show() {
        super.show();
        if (length != null) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    HUDDroid.this.dismiss();
                }
            }, length.millis);
        }
    }

    /** internal builder methods **/

    private static HUDDroid buildBasicHUD(Context activityContext) {
        HUDDroid dialog = new HUDDroid(activityContext, R.style.ProgressHUD);
        dialog.setTitle("");
        dialog.setContentView(R.layout.progress_hud);

        dialog.getWindow().getAttributes().gravity=Gravity.CENTER;
        return dialog;
    }

    private HUDDroid setMessage(String message) {
        if(message == null || message.length() == 0) {
            this.findViewById(R.id.message).setVisibility(View.GONE);
        } else {
            TextView txt = (TextView)findViewById(R.id.message);
            txt.setText(message);
        }

        return this;
    }

    private HUDDroid setMaskType(MaskType maskType) {

        float dimAmount = 0.0f;

        if (maskType == MaskType.Black) {
            dimAmount = 0.7f;
        }

        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.dimAmount= dimAmount;
        getWindow().setAttributes(lp);

        return this;
    }

    private HUDDroid setDisplayTime(DisplayTime time) {
        length = time;
        return this;
    }

    private HUDDroid setIcon(IconType type) {
        ImageView icon = (ImageView) findViewById(R.id.spinnerImageView);

        switch (type) {
            case Success:
                icon.setImageResource(R.drawable.ic_successstatus);
                break;
            case Failure:
                icon.setImageResource(R.drawable.ic_errorstatus);
                break;
            case Progress_Indeterminant:
                icon.setImageResource(R.drawable.progress_hud_bg);

        }

        return this;
    }

}