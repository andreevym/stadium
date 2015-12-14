angular.module("userTableModule", [])
    .controller('userTableController', ['$http', function ($http, $scope, $log) {
        var userTable = this;
        userTable.users = [];

        $http.get('/allUsers').success(function (data) {
            userTable.users = data;
        }).error(function (data) {

        });

        userTable.addRow = function() {
            userTable.users = push({
                'id' : $scope.id,
                'fullName' : userTable.fullName,
                'lastName' : userTable.lastName,
                'description' : userTable.description
            });

            userTable.fullName = '';
            userTable.lastName = '';
            userTable.description = '';
         };

        userTable.deleteUserById = function (id) {
            var userArr = eval(userTable.users);

            var index = -1;
            for (var i = 0; i < userArr.length; i++) {
                if (userArr[i].id == id) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                alert("Не удалось найти строку с таким id:" + id);
            }
            userTable.users.splice(index, 1);
        };
    }]);