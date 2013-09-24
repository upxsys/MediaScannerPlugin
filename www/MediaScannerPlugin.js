//
//  MediaScannerPlugin.js
//  MediaScannerPlugin PhoneGap/Cordova plugin
//
//  Created by Peter Gao on 23/09/2013.
//  Copyright (c) 2012 Peter Gao. All rights reserved.
//  MIT Licensed
//

module.exports = {

    scanFile:function(successCallback, failureCallback, filePath) {
        // successCallback required
        if (typeof successCallback !== "function") {
            console.log("MediaScannerPlugin Error: successCallback is not a function");
        }
        else if (typeof failureCallback !== "function") {
            console.log("MediaScannerPlugin Error: failureCallback is not a function");
        } else if (typeof filePath !== "string") {
            console.log("MediaScannerPlugin Error: filePath is not a string");
        }
        else {
            return cordova.exec(successCallback, failureCallback, "MediaScannerPlugin", "scanFile", [{"filePath": filePath}]);
        }
    }
};
