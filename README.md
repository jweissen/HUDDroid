# HUDDroid
HUDDroid is a Java Android port of the [AndHUD](https://github.com/Redth/AndHUD) C# Xamarin library: a Progress / HUD library for Android which allows you to easily add amazing HUDs to your app!

#How to Use
```Java
//Show a simple status message with an indeterminate spinner
HUDDroid.getInstance().build(this)
  .setMessage("Status Message")
  .setMaskType(MaskType.Clear)
  .show();

```
