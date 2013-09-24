MediaScannerPlugin
============

This plugin allows you to save the contents of an HTML canvas tag to the iOS Photo Library, or Android Gallery from your app.

Installation
------------

### For Cordova 3.0.x:

1. To add this plugin just type: `cordova plugin add https://github.com/peteygao/MediaScannerPlugin.git` or `phonegap local plugin add https://github.com/peteygao/MediaScannerPlugin.git`
2. To remove this plugin type: `cordova plugin remove org.sfl.MediaScannerPlugin` or `phonegap local plugin remove org.sfl.MediaScannerPlugin`


Usage:
------

Call the `window.mediaScannerPlugin(successCallback, failureCallback, filePath)` method using success and error callbacks and the filePath of the file to be scanned by the MediaScanner:

### Example
```javascript
function onDeviceReady()
{
	window.mediaScannerPlugin.scanFile(
        function(msg){
            console.log(msg);
        },
        function(err){
            console.log(err);
        },
        '/mnt/sdcard/Download/mediaFile.png'
    );
}
```

The function will return to the successCallback the path to the media file that was originally supplied. So in the above example, the returned message will simply be `'/mnt/sdcard/Download/mediaFile.png'`

## License

The MIT License

Copyright (c) 2013 Peter Gao (http://github.com/peteygao)

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
