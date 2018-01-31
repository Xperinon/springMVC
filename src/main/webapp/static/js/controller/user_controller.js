'use strict';

angular.module('AngularJSApp').controller('userController', ['$scope', 'UserService', function($scope, UserService) {
    var self = this;

    self.user = { id: null, address: '', email: '' };
    self.users = [];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;

    fetchAllUsers();

    function fetchAllUsers() {
        UserService.fetchAllUsers().then(function(d) {
            self.users = d;
        }, function(errResponse) {
            console.error('error while fetching users');
        });

    }

    function createUser(user) {
        UserService.createUser(user).then(
            fetchAllUsers,
            function(errReponse) {
                console.error('error while creating user');
            }
        );
    }

    function updateUser(user, id) {
        UserService.updateUser(user, id).then(fetchAllUsers,
            function(errReponse) {
                console.error('<Error while updating user');
            });
    }

    function deleteUser(id) {
        UserService.deleteUser(id).then(fetchAllUsers,
            function(errReponse) {
                console.error('Error while deleting user');
            });
    }

    function submit() {
        if (self.user.id == null) {
            console.log('Saving new user ', self.user);
            createUser(self.user);
        } else {
            updateUser(self.user, self.user.id);
            console.log('Updating user ', self.user);
        }
        reset();
    }

    function edit(id) {
        console.log('edit with id', id);
        for (var i = 0; i < self.users.length; i++) {
            if (self.users[i].id === id) {
                self.user = angular.copy(self.users[i]);
                break;
            }
        }
    }

    function remove(id) {
        console.log('id to be deleted ', id);
        if (self.user.id === id) {
            reset();
        }
        deleteUser(id);
    }

    function reset() {
        self.user = { id: null, address: '', email: '' };
        $scope.appForm.$setPritstine();
    }
}]);