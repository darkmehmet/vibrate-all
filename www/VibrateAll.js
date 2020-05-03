var exec = cordova.require('cordova/exec');

var PLUGIN_NAME = "VibrateAll"

var VibrateAll = {
    vibrate: function(duration, onSuccess, onError) {
        var errorCallback = function(obj) {
            onError(obj);
        };

        var successCallback = function(obj) {
            onSuccess(obj);
        };

        exec(successCallback, errorCallback, PLUGIN_NAME, 'vibrate', [duration]);
    }

}

if (typeof module != 'undefined' && module.exports) {
    module.exports = VibrateAll;
}
