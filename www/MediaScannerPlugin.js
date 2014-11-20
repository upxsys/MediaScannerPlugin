//
//  MediaScannerPlugin.js
//  MediaScannerPlugin PhoneGap/Cordova plugin
//
//  Created by Peter Gao on 23/09/2013.
//  Copyright (c) 2012 Peter Gao. All rights reserved.
//  MIT Licensed
//

module.exports = {

    scanFile:function(fileURI) {
    	return cordova.exec(function() {}, function() {}, "MediaScannerPlugin", "scanFile", [fileURI]);
    }
};
