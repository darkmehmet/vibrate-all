package com.darkmehmet.VibrateAll;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import android.content.Context;

import android.os.Build ;
import android.os.Bundle ;
import android.os.VibrationEffect ;
import android.os.Vibrator ;

public class VibrateAll extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ("vibrate".equals(action)) {
            show(args.getString(0), callbackContext);
            return true;
        }

        return false;
    }

    private void show(String duration, CallbackContext callbackContext) {
        if (duration == null || duration.length() == 0) {
            callbackContext.error("Duration not provided!");
        } else {

            Vibrator v = (Vibrator) cordova.getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            // Vibrate for 400 milliseconds
            // v.vibrate( Integer.parseInt(duration));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v.vibrate(VibrationEffect.createOneShot(
                    Integer.parseInt(duration),
                    VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                //deprecated in API 26 
                v.vibrate(Integer.parseInt(duration));
            }


            callbackContext.success(duration);
        // }
    }
}

}

