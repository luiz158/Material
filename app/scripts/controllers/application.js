'use strict';

app.controller('ApplicationController', ['$scope', '$rootScope', 'USER_ROLES', 'AuthService', function($scope, $rootScope, USER_ROLES, AuthService) {

        $rootScope.currentUser = null;
        $rootScope.userRoles = USER_ROLES;
        $rootScope.isAuthorized = AuthService.isAuthorized;

        $rootScope.setCurrentUser = function(user) {
            $rootScope.currentUser = user;
        };

        $scope.email = 'paulopinheiro777@gmail.com';
        $scope.options = {
            secure: true,
            size: 100,
            defaultImage: 'mm'
        };


    }]);