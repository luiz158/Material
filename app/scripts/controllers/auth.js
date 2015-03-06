'use strict';

app.controller('AuthController', ['$scope', '$rootScope', 'AUTH_EVENTS', 'AuthService', 'AppService', 'AlertService',
    function($scope, $rootScope, AUTH_EVENTS, AuthService, AppService, AlertService) {

        //Check if user has token
        var token = AppService.getToken();

        if (token) {
            AuthService.getUserLogged().then(function(user) {
                $rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
                $rootScope.setCurrentUser(user);
            });
        }

        $scope.credentials = {
            username: 'admin',
            password: 'admin'
        };

        function error(data, status) {
            $("[id$='-message']").text("");

            switch (status) {
                case 412:
                case 422:
                    $.each(data, function(i, violation) {
                        $("#" + violation.property + "-message").text(violation.message);
                    });
                    break;
                case 401:
                    $("#message").html("Usuário ou senha inválidos.");
                    break;
            }
        }


        $scope.login = function(credentials) {
            AuthService.login(credentials).then(function(user) {
                $rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
                $rootScope.setCurrentUser(user);
            },
                    function(response) {
                        AlertService.addWithTimeout('danger', 'Não foi possível se comunicar com o servidor!');
                        $rootScope.$broadcast(AUTH_EVENTS.loginFailed);
                        $rootScope.setCurrentUser(null);
                        error(response.data, response.status);
                    });
        };

        $scope.logout = function() {
            AuthService.logout().then(function() {
                $rootScope.$broadcast(AUTH_EVENTS.logoutSuccess);
                $rootScope.setCurrentUser(null);
            });
        };

    }]);