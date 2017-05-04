'use strict'
var app = angular.module("demo", ['ui.router']);

app.config(['$qProvider', function ($qProvider) {
    $qProvider.errorOnUnhandledRejections(false);
}]);

app.config(function($stateProvider, $urlRouterProvider) {
    var userState = {
        name: 'url_user',
        url: 'user',
        template:
            "<div>" +
                "<div class='navbar navbar-default'>" +
                    "<ul class='nav navbar-nav' style='display: flex; flex-wrap: nowrap;'>" +
                        "<li class='active'><a data-ui-sref='url_user.friend({id: dynamic})'>动态</a></li>" +
                        "<li><a data-ui-sref='url_user.friend({id: nearby})'>附近</a></li>" +
                        "<li><a data-ui-sref='url_user.friend({id: friends})'>好友</a></li>" +
                    "</ul>" +
                "</div>" +
                "<div data-ui-view=''></div>" +
            "</div>"
        //resolve:
        //component:
    };
    var friendState = {
        name: 'url_user.friend',
        url: 'user/friends',
        template:
            "<div>" +
                "<ul data-ng-init='i=0;'>" +
                    "<li style='display: flex; justify-content: space-between;'>" +
                        "<span>编号</span>" +
                        "<span>姓名</span>" +
                        "<span>密码</span>" +
                        "<span>删除好友</span>" +
                        "</li>" +
                    "<li style='display: flex; justify-content: space-between;' data-ng-repeat='friend in friends | filter: name'>" +
                        "<span>{{i + 1}}</span>" +
                        "<span>{{friend.name}}</span>" +
                        "<span>{{friend.password}}</span>" +
                        "<span><a data-ng-click=''>delete</a></span>" +
                    "</li>" +
                "</ul>" +
            "</div>",
        controller: function($scope, $http) {
            $http.get("user/loadFriends").then(function(response) {
                $scope.friends = response.data;
            });
        }
    };

    $stateProvider.state(userState);
    $stateProvider.state(friendState);
    $urlRouterProvider.otherwise('/');
});