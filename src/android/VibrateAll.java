package com.darkmehmet.vibrateAll;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import android.content.Context;

import android.os.Vibrator;

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
        // if (duration == null || duration.length() == 0) {
        //     callbackContext.error("Duration not provided!");
        // } else {

            Vibrator v = (Vibrator) cordova.getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            // Vibrate for 400 milliseconds
            v.vibrate(400);


            callbackContext.success(duration);
        // }
    }
}