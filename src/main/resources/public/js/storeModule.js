angular.module('storeModule', [])
    .controller('StoreController', ['$http', function ($http) {
        var store = this;
        store.isAuthenticated = false;
        $http.get('/isAuthenticated').success(function (data) {
            store.isAuthenticated = data;
        });
    }]).controller('AuthenticationController', ['$http', function ($http, $scope, $rootScope, $location) {

    /* TODO сделать выход из приложения через форму. */
    function logout() {
        $http.post('logout', {}).success(function () {
            $rootScope.isAuthenticated = false;
            $location.path("/");

        }).error(function (data) {
            $rootScope.isAuthenticated = false;

        });
    }
}]).controller('UserController', ['$http', function ($http) {
    var ldap = this;
    ldap.users = [];

    $http.get('/allUsers').success(function (data) {
        ldap.users = data;
    });
}]).controller('GroupController', ['$http', function ($http) {
    var gc = this;
    gc.groups = [];

    $http.get('/allGroups').success(function (data) {
        gc.groups = data;
    });
}]);