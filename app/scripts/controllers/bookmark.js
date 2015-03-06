'use strict';

app.controller('BookmarkController', ['$scope', '$routeParams', '$location', 'BookmarkService', 'AlertService',
    function($scope, $routeParams, $location, BookmarkService, AlertService) {

        $scope.bookmarks = [];

        $scope.findAll = function() {
            BookmarkService.findAll().then(
                    function(data) {
                        $scope.bookmarks = data;
                    },
                    function(error) {
                        var data = error[0];
                        var status = error[1];

                        if (status === 401) {
                            AlertService.addWithTimeout('warning', data.message);
                        }
                        else {
                            AlertService.addWithTimeout('danger', 'Não foi possível executar a operação');
                        }
                    }
            );
        };

        var id = $routeParams.id;
        var path = $location.$$url;

        if (path === '/bookmark') {
            $scope.findAll();
        }
        ;

        if (path === '/bookmark/edit') {
            $scope.bookmark = {};
            $scope.bookmark.perfis = [];
        }
        ;

        if (path === '/bookmark/edit/' + id) {
            BookmarkService.get(id).then(
                    function(data) {
                        $scope.bookmark = data;
                        $scope.findAuxiliar();
                    },
                    function(error) {
                        var data = error[0];
                        var status = error[1];

                        if (status === 401) {
                            AlertService.addWithTimeout('warning', data.message);
                        }
                        else {
                            AlertService.addWithTimeout('danger', 'Não foi possível executar a operação');
                        }
                    }

            );

        }
        ;

        $scope.new = function() {
            $location.path('bookmark/edit');
        };

        $scope.save = function() {

            $("[id$='-message']").text("");

            BookmarkService.save($scope.bookmark).then(
                    function(data) {
                        AlertService.addWithTimeout('success', 'Bookmark salva com sucesso');
                        $location.path('/bookmark');
                    },
                    function(error) {

                        var data = error[0];
                        var status = error[1];

                        if (status === 401) {
                            AlertService.addWithTimeout('danger', 'Não foi possível executar a operação');
                        }
                        else if (status === 412) {
                            $.each(data, function(i, violation) {
                                $("#" + violation.property + "-message").text(violation.message);
                            });
                        } else {
                            AlertService.addWithTimeout('danger', 'Não foi possível executar a operação');
                        }

                    }
            );
        };

        $scope.delete = function(id) {
            BookmarkService.delete(id).then(
                    function(data) {
                        AlertService.addWithTimeout('success', 'Bookmark removida com sucesso');
                        $location.path('/bookmark');
                        $scope.findAll();
                    },
                    function(error) {
                        var data = error[0];
                        var status = error[1];

                        if (status === 401) {
                            AlertService.addWithTimeout('warning', data.message);
                        }
                        else {
                            AlertService.addWithTimeout('danger', 'Não foi possível executar a operação');
                        }
                    }
            );
        };

        $scope.edit = function(id) {
            $location.path('/bookmark/edit/' + id);
        };

        $scope.toggleSelection = function toggleSelection(perfil) {
            var idx = $scope.bookmark.perfis.indexOf(perfil);

            if (idx > -1) {
                $scope.bookmark.perfis.splice(idx, 1);
            }
            else {
                $scope.bookmark.perfis.push(perfil);
            }
        };


    }]);