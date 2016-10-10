var app = angular.module('MentorApp');
app.controller('programCtrl', ['$scope','$http', 'rest', function($scope, $http, rest) {

    var URL = '/programs';
    $scope.editMode = [];
    $scope.editErrorMessages = [];
    $scope.createProgram = function() {
        if($scope.newItemForm.$valid) {
            rest.create($scope.newItem, URL).then(function(data) {
                $scope.programs.push(data);
                $scope.newItem = {};
                $scope.newItemForm.$setPristine();
            }, function (response) {
                $scope.errorMessage = 'Server error. Cannot handle request.';
            });
        } else {
            $scope.errorMessage = 'Invalid data. Check your inputs';
        }

    };

    var getPrograms = function() {
        rest.get(URL).then(function(data) {
            $scope.programs = data;
        }, function(response) {
            Materialize.toast('Cannot get program list', 4000);
        })
    };

    $scope.updateProgram = function(editForm, item, index) {
        $scope.editErrorMessages[index] = '';
        if(editForm.$valid) {
            rest.update(item, URL).then(function(data) {
                $scope.programs[$scope.programs.indexOf(item)] = data;
                editForm.$setPristine();
                Materialize.toast('Updated successfully!', 4000);
            }, function (response) {
                 $scope.editErrorMessages[index] = 'Server error. Cannot handle request.';
            });
        } else {
             $scope.editErrorMessages[index] = 'Invalid data. Check your inputs';
        }
    };

    $scope.deleteProgram = function(item) {
        rest.remove(item, URL).then(function(response) {
            $scope.programs.splice($scope.programs.indexOf(item), 1);
        }, function(response) {
            Materialize.toast('Cannot delete program', 4000);
        });
    }

    getPrograms();

}]);