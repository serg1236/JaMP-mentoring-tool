var app = angular.module('MentorApp');
app.controller('userCtrl', ['$scope','$http', 'rest', function($scope, $http, rest) {

    var URL = '/persons';
    $scope.editMode = [];
    $scope.editErrorMessages = [];
    $scope.levels = ['L1', 'L2', 'L3', 'L4', 'L5'];
    $scope.createUser = function() {
        if($scope.newItemForm.$valid) {
            rest.create($scope.newItem, URL).then(function(data) {
                $scope.users.push(data);
                $scope.newItem = {};
                $scope.newItemForm.$setPristine();
            }, function (response) {
                $scope.errorMessage = 'Server error. Cannot handle request.';
            });
        } else {
            $scope.errorMessage = 'Invalid data. Check your inputs';
        }

    };

    var getUsers = function() {
        rest.get(URL).then(function(data) {
            $scope.users = data;
        }, function(response) {
            Materialize.toast('Cannot get user list', 4000);
        })
    };

    var getSkills = function() {
        rest.get("/persons/skills").then(function(data) {
            $scope.primarySkills = data;
        }, function (response) {
            Materialize.toast('Cannot get user list', 4000);
        });
    }

    $scope.updateUser = function(editForm, item, index) {
        $scope.editErrorMessages[index] = '';
        if(editForm.$valid) {
            rest.update(item, URL).then(function(data) {
                item = data;
                editForm.$setPristine();
                Materialize.toast('Updated successfully!', 4000);
            }, function (response) {
                 $scope.editErrorMessages[index] = 'Server error. Cannot handle request.';
            });
        } else {
            $scope.editErrorMessages[index] = 'Invalid data. Check your inputs';
        }
    };

    $scope.deleteUser = function(item) {
        rest.remove(item, URL).then(function(response) {
            $scope.users.splice($scope.users.indexOf(item), 1);
        }, function(response) {
            Materialize.toast('Cannot delete user', 4000);
        });
    }

    getUsers();
    getSkills();

}]);