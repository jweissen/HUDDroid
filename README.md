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

//Show an error image with a message
HUDDroid.getInstance().buildFailureWithStatus(this, "It no worked :()")
  .setMaskType(MaskType.Black)
  .setTimeSpan(TimeSpan.fromSeconds(2))
  .show();


```
