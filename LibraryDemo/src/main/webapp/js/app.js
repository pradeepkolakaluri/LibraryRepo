angular
    .module('myApp', ['ngResource'])
    .service('LibraService', function ($log, $resource) {
        return {
            getAll: function () {
                var userResource = $resource('users', {}, {
                    query: {method: 'GET', params: {}, isArray: true}
                });
                return userResource.query();
            }
        }
    })
    .controller('UsersController', function ($scope, $log, UsersService) {
        $scope.users = UsersService.getAll();
    });