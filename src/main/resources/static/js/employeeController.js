/**
 * Created by Neveral on 15.08.16.
 */

'use strict';

angular.module('myApp').controller('UserController', ['$scope', 'UserService', function($scope, UserService) {
    var self = this;
    self.user = {id:null,firstName:'', middleName:'', lastName:'', position:'', birthday:''};

    self.users = [];
    self.error = null;

    self.submit = submit;

    var rest_uri = "";

    fetchAllUsers();

    function fetchAllUsers(){
        UserService.fetchAllUsers(rest_uri)
            .then(
                function(d) {
                    console.log(d);
                    self.users = d;
                    self.error = null;
                },
                function(errResponse){
                    console.log(errResponse.message);
                    self.error = errResponse;
                }
            );
    }

    function submit() {
        rest_uri = "";
        if(self.user.firstName!="") {
            rest_uri = rest_uri + "&firstName=" + self.user.firstName;
        }

        if(self.user.lastName!="") {
            rest_uri = rest_uri + "&lastName=" + self.user.lastName;
        }

        if(self.user.middleName!="") {
            rest_uri = rest_uri + "&middleName=" + self.user.middleName;
        }

        if(self.user.position!="") {
            rest_uri = rest_uri + "&position=" + self.user.position;
        }

        if(self.user.birthday!="") {
            rest_uri = rest_uri + "&birthday=" + self.user.birthday;
        }

        console.log('Search user with parameters:', rest_uri);
        fetchAllUsers(rest_uri);
    }

    $scope.reset = function(){
        self.user={id:null,firstName:'', middleName:'', lastName:'', position:'', birthday:''};
        self.error = null;
        $scope.myForm.$setPristine(); //reset Form
        rest_uri = "";
        fetchAllUsers();
    }


}]);
