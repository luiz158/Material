'use strict';

app.factory('AuthService', ['$http', 'Session', 'AppService', function($http, Session, AppService) {

        var authService = {};

        function makeFake() {
            var user = {
                "id": "1",
                "cpf": "admin",
                "name": "ADMIN",
                "email": "",
                "telephoneNumber": "",
                "setor": "DS/CETEC/CTCTA",
                "token": "1111-1111-1111-1111",
                "grupos": [{
                        "id": 1,
                        "nome": "ADMIN",
                        "descricao": "Grupo para os administradores do sistema.",
                        "perfis": ["ADMINISTRADOR"]
                    }]
            }

            AppService.removeToken();

            var roles = [];

            if (user.grupos) {
                for (var i = 0; i < user.grupos.length; i++) {
                    for (var j = 0; j < user.grupos[i].perfis.length; j++) {
                        if (roles.indexOf(user.grupos[i].perfis[j]) == -1) {
                            roles.push(user.grupos[i].perfis[j]);
                        }
                    }
                }
            }

            var token = user.token;
            Session.create(token, roles);

            AppService.setToken(token);

            return user;
        }

        authService.login = function(credentials) {

            AppService.removeToken();

            return $http
                    .post('api/auth', credentials)
                    .then(function(res) {

                        var roles = getRoles(res.data.grupos);

                        var token = res.data.token;
                        Session.create(token, roles);

                        AppService.setToken(token);

                        return res.data;
                    }
                    );

        };

        authService.getUserLogged = function() {

            return $http
                    .get('api/auth')
                    .then(function(res) {

                        AppService.removeToken();

                        var roles = getRoles(res.data.grupos);

                        var token = res.data.token;
                        Session.create(token, roles);

                        AppService.setToken(token);

                        return res.data;
                    }
                    );


        };

        function getRoles(grupos) {
            var roles = [];

            if (grupos) {
                for (var i = 0; i < grupos.length; i++) {
                    for (var j = 0; j < grupos[i].perfis.length; j++) {
                        if (roles.indexOf(grupos[i].perfis[j]) == -1) {
                            roles.push(grupos[i].perfis[j]);
                        }
                    }
                }
            }

            return roles;
        }

        authService.logout = function() {

            return $http
                    .delete('api/auth')
                    .then(function(response) {
                        console.log('AuthService Logout Success');
                        AppService.removeToken();
                    }
                    );
        };

        authService.isAuthenticated = function() {
            return !!Session.userId;
        };

        authService.isAuthorized = function(authorizedRoles) {

            if (!angular.isArray(authorizedRoles)) {
                authorizedRoles = [authorizedRoles];
            }

            var hasAuthorizedRole = false;

            if (Session.userRole !== undefined && Session.userRole !== null) {
                for (var i = 0; i < authorizedRoles.length; i++) {
                    for (var j = 0; j < Session.userRole.length; j++) {
                        if (authorizedRoles[i].indexOf(Session.userRole[j]) !== -1) {
                            hasAuthorizedRole = true;
                            break;
                        }
                    }
                }
            }

            return (authService.isAuthenticated() && hasAuthorizedRole);
        };

        return authService;
    }]);

