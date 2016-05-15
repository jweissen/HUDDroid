# HUDDroid
HUDDroid is a Java Android port of the [AndHUD](https://github.com/Redth/AndHUD) C# Xamarin library: a Progress / HUD library for Android which allows you to easily add amazing HUDs to your app!

#How to Use
```Java
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

//Show a success image with a message
HUDDroid.getInstance().buildSuccessWithStatus(this, "It Worked!")
  .setMaskType(MaskType.Black)
  .setTimeSpan(TimeSpan.fromSeconds(2))
  .show();


//Show an error image with a message
HUDDroid.getInstance().buildFailureWithStatus(this, "It no worked :()")
  .setMaskType(MaskType.Black)
  .setTimeSpan(TimeSpan.fromSeconds(2))
  .show();

//Show a toast, similar to Android native toasts, but styled
HUDDroid.getInstance().buildToast(this, "This is a non-centered Toast...")
    .setMaskType(MaskType.Clear)
    .setTimeSpan(TimeSpan.fromSeconds(2))
    .show();

//Show a custom image with text
HUDDroid.getInstance().buildImage(this, R.drawable.customImage)
    .setMessage("Custom")
    .show();

//Dismiss a HUD that will or will not be automatically timed out
HUDDroid.getInstance().dismissCurrent();
    
//Show a HUD and only close it when it's clicked
HUDDroid.getInstance().buildToast(this, "Click this toast to close it!")
  .setMaskType(MaskType.Clear)
  .setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      HUDDroid.getInstance().dismissCurrent();
    }
  }).show();

```
