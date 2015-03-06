'use strict';

app.factory('AppService', ['$window', function($window) {

        var tokenKey = "Token";

        var service = {};

        service.getToken = function() {
            var token = $window.localStorage.getItem(tokenKey);
            if (token && token !== undefined && token != null) {
                return token;
            }
            return null;
        };

        service.setToken = function(token) {
            $window.localStorage.setItem(tokenKey, token);
        };

        service.removeToken = function() {
            $window.localStorage.removeItem(tokenKey);
        };

        return service;
    }]);

app.service('Session', function() {

    this.create = function(userId, userRole) {
        this.userId = userId;
        this.userRole = userRole;
    };

    this.destroy = function() {
        this.userId = null;
        this.userRole = null;
    };

    return this;
});