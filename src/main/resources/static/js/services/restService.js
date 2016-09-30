var app = angular.module('MentorApp');
app.service('rest', function($http, $q) {

    var _sendRequest = function(method, data, url) {
        var deferred = $q.defer();
        $http({
            method: method,
            url: url,
            data: data
        }).then(function(response) {
            deferred.resolve(response.data);
        },
        function(response){
             deferred.reject(response);
        });
        return deferred.promise;
    }

    this.create = function (newItem, url) {
        return _sendRequest('POST', newItem, url);
    };

    this.get = function(url) {
        return _sendRequest('GET', null, url);
    };

    this.update = function(item, url) {
        return _sendRequest('PUT', item, url);
    }

    this.remove = function(item, url) {
        var deleteUrl = new Array(url, item.id).join("/");
        return _sendRequest('DELETE', null, deleteUrl);
    }
});