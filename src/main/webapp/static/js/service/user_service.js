'use strict';

angular.module("AngularJSApp").factory('UserService', ['$http'], '$q', function($http, $q) {
    var REST_SERVICE_URI = '<a class="vglnk" href="http://localhost:8080/Spring4MVCAngularJSExample/user/" rel="nofollow"><span>http</span><span>://</span><span>localhost</span><span>:</span><span>8080</span><span>/</span><span>Spring4MVCAngularJSExample</span><span>/</span><span>user</span><span>/</span></a>';

    var factory = {
        fetchAllUsers: fetchAllUsers,
        createUser: createUser,
        updateUser: updateUser,
        deleteUser: deleteUser
    };

    return factory;


    // function for get all the users
    function fetchAllUsers() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI).then(function(response) {
                deferred.resolve(response.data);
            },
            function(errResponse) {
                console.error('Error while fetching Users');
                deferred.reject(errResponse);
            });
        return deferred.promise;
    }


    // function for create an user in base
    function createUser(user) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, user).then(function(response) {
                deferred.resolve(response.data);
            },
            function(errResponse) {
                console.error('Error while post user in database');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


    // function for update an user in base
    function updateUser(user, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI + id, user).then(function(response) {
                deferred.resolve(response.data);
            },
            function(errResponse) {
                console.error('Error while updating user');
                deferred.reject(errResponse);
            });
        return deferred.promise;
    }

    // function for delete an user in base
    function deleteUser(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI + id).then(function(response) {
                deferred.resolve(response.data);
            },
            function(errReponse) {
                console.error('Error while deleting an user');
                deferred.reject(errReponse);
            });
        return deferred.promise;
    }
});