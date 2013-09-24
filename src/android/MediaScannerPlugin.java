package org.sfl.MediaScannerPlugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;

/**
 * MediaScannerPlugin.java
 *
 * Inspirated by Joseph's "Saving Image to Android device’s Gallery – Phonegap Android" plugin
 * https://jbkflex.wordpress.com/2012/12/23/saving-image-to-android-devices-gallery-phonegap-android/
 *
 * @author Peter Gao <peter@spacefluxlabs.com>
 */
public class MediaScannerPlugin extends CordovaPlugin {
    public static final String ACTION = "scanFile";
    private static final String TAG = "MediaScannerPlugin";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Log.w(TAG, "Execute statement");

        if (action.equals(ACTION)) {
            JSONObject jsonObj = args.getJSONObject(0);
            String filePath = jsonObj.optString("filePath");

            if (filePath == null ) {
                callbackContext.error("A filepath was not provided.");
                Log.w(TAG, "A filepath was not provided!");
                return false;
            } else {
                Log.w(TAG, "filePath: " + filePath);
            }

            Log.w(TAG, "scanFile Action");
            // Update image gallery
            scanPhoto(filePath);

            Log.w(TAG, "scanFile Successful");
            callbackContext.success(filePath);

            return true;
        } else {
            Log.w(TAG, "Wrong action was provided: "+action);
            return false;
        }
    }

    /* Invoke the system's media scanner to add your photo to the Media Provider's database,
     * making it available in the Android Gallery application and to other apps. */
    private void scanPhoto(String filePath)
    {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        Uri contentUri = Uri.fromParts("file","//"+filePath,"");
        Log.i(TAG, "Parsed Uri: " + contentUri.toString());
        mediaScanIntent.setData(contentUri);
        cordova.getActivity().sendBroadcast(mediaScanIntent);
    }
}
