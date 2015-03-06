'use strict';

app.factory('BookmarkService', ['$http', '$q', function($http, $q) {
        var service = {};

        service.findAll = function() {
            var deferred = $q.defer();

            $http({
                url: 'api/bookmark',
                method: "GET",
                headers: {
                    'Content-Type': 'application/json;charset=utf8'
                }
            }).success(function(data) {
                deferred.resolve(data);
            }).error(function(data, status) {
                deferred.reject([data, status]);
            });
            return deferred.promise;
        };

        service.save = function(grupo) {
            var deferred = $q.defer();

            $http({
                url: 'api/bookmark',
                method: grupo.id ? "PUT" : "POST",
                data: grupo,
                headers: {
                    'Content-Type': 'application/json;charset=utf8'
                }
            }).success(function(data) {
                deferred.resolve(data);
            }).error(function(data, status) {
                deferred.reject([data, status]);
            });

            return deferred.promise;
        };

        service.delete = function(id) {
            var deferred = $q.defer();

            $http({
                url: 'api/bookmark/' + id,
                method: "DELETE"
            }).success(function(data) {
                deferred.resolve(data);
            }).error(function(data, status) {
                deferred.reject([data, status]);
            });

            return deferred.promise;
        };

        service.get = function(id) {

            var deferred = $q.defer();

            $http({
                url: 'api/bookmark/' + id,
                method: "GET"
            }).success(function(data) {
                deferred.resolve(data);
            }).error(function(data, status) {
                deferred.reject([data, status]);
            });

            return deferred.promise;
        };

        return service;
    }]);

