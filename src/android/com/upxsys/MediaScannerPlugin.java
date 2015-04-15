package com.upxsys;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import android.util.Log;

/**
 * MediaScannerPlugin.java
 *
 * Forked from https://github.com/Ouzned/MediaScannerPlugin
 * Adapted for API 19 (KitKat) compatibility
 */
public class MediaScannerPlugin extends CordovaPlugin {
    private static final String ACTION = "scanFile";

    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    	
        if (action.equals(ACTION)) {
        	Context context=this.cordova.getActivity().getApplicationContext();
        	String paramFile = args.getString(0);
        	
        	Log.d("File scanned: ", paramFile);
        	
        	String[] filePaths = new String[0];
        	filePaths[0] = paramFile;
        	
        	MediaScannerConnection.scanFile(context, filePaths, null, new OnScanCompletedListener() {
				
				@Override
				public void onScanCompleted(String path, Uri uri) {
					if (uri == null)
						callbackContext.error("File " + path + " not found");
					else	
						callbackContext.success();
				}
			});

            return true;
        } else {
            Log.w(this.getClass().getSimpleName(), "Unknown action: "+action);
            return false;
        }
    }
}
