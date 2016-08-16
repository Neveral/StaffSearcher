/**
 * Created by Neveral on 15.08.16.
 */

'use strict';

angular.module('myApp').factory('UserService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/employees?';

    var factory = {
        fetchAllUsers: fetchAllUsers
    };

    return factory;

    function fetchAllUsers(rest_uri) {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI+rest_uri)
            .then(
                function (response) {
                    console.log(response.data);
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.log(errResponse.data);
                    deferred.reject(errResponse.data);
                }
            );
        return deferred.promise;
    }

}]);
