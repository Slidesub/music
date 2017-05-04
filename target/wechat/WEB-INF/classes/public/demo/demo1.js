'use strict'
var app = angular.module("demo", ['ui.router']);
//app.run(function($rootScope) {
//	$rootScope.$on('$stateChangeStart', function(event) {
//	    if (!$rootScope.user || !$rootScope.user.token) {
//	        console.info('用户未登录');
//	    }
//	})
//});
//
//app.config("$routeProvider", function($routeProvider) {
//	$routeProvider
//    .when("/setting", {templateUrl: 'music/index'});
//});

app.controller("friendController", ["$scope", "loadFriends", "deleteDataService", function($scope, loadFriends, deleteDataService) {
    $scope.friends = loadFriends;
    $scope.deleteFriend = function(id) {
        deleteDataService.deleteData("user/deleteFriend/" + id);
        angular.element("#user" + id).remove();
    }
}]);

app.service("loadDataService", ["$http", function($http) {
    return {
        getData: function(url) {
            return $http.get(url).then(function(response) {
                return response.data;
            });
        }
    };
}]);

app.service("deleteDataService", ["$http", function($http) {
    return {
        deleteData: function(url) {
            $http.post(url);
        }
    };
}]);

app.config(['$qProvider', function ($qProvider) {
    $qProvider.errorOnUnhandledRejections(false);
}]);

app.config(function($stateProvider, $urlRouterProvider) {
	var registerState = {
		name: 'register',
		url: 'register',
		templateUrl: "music/register"
	}
    var indexState = {
        name: 'index',
        url: 'index',
        template: 
        	"<div>" +
        		"<div class='navbar navbar-default'>" +
            		"<ul class='nav navbar-nav' style='display: flex; flex-wrap: nowrap;'>" +
                		"<li data-ui-sref-active='active'><a data-ui-sref='index.music2({id: recommend})'>个性推荐</a></li>" +
                		"<li data-ui-sref-active='active'><a data-ui-sref='index.music2({id: songs})'>歌单</a></li>" +
                		"<li data-ui-sref-active='active'><a data-ui-sref='index.music2({id: anchor})'>主播电台</a></li>" +
                		"<li data-ui-sref-active='active'><a data-ui-sref='index.music2({id: ranking})'>排行榜</a></li>" +
                	"</ul>" +
                "</div>" +
                "<div data-ui-view=''></div>" +
            "</div>",
        controller: function($state) {
            //$state.go("url_user");
        } 
    };
    var musicState = {
        name: 'music',
        url: 'music',
        template:"<h1>MUSIC</h1>",
        controller: function($scope, $state) {
            
        }
    };
    var userState = {
        name: 'user',
        url: 'user',
        template:
            "<div>" +
                "<div class='navbar navbar-default'>" +
                    "<ul class='nav navbar-nav' style='display: flex; flex-wrap: nowrap;'>" +
                        "<li data-ui-sref-active='active'><a data-ui-sref='user.dynamic({id: dynamic})'>动态</a></li>" +
                        "<li data-ui-sref-active='active'><a data-ui-sref='user.nearby({id: nearby})'>附近</a></li>" +
                        "<li data-ui-sref-active='active'><a data-ui-sref='user.friends({id: friends})'>好友</a></li>" +
                    "</ul>" +
                "</div>" +
                "<div data-ui-view=''></div>" +
            "</div>"
    };
    var friendState = {
        name: 'user.friends',
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
                    "<li id='user{{friend.id}}' style='display: flex; justify-content: space-between;' data-ng-repeat='friend in friends | filter: name'>" +
                        "<span>{{i + 1}}</span>" +
                        "<span>{{friend.name}}</span>" +
                        "<span>{{friend.password}}</span>" +
                        "<span ><a data-ng-click='deleteFriend(friend.id)'>delete</a></span>" +
                    "</li>" +
                "</ul>" +
            "</div>",
        controller: "friendController", 
        resolve: {
            loadFriends: ["loadDataService", function(loadDataService) {
                return loadDataService.getData("user/loadFriends").then(function(result) {
                    return result;
                })
            }]
        }
    }

    //一级菜单
    $stateProvider.state(registerState);
    $stateProvider.state(indexState);
    $stateProvider.state(userState);
    $stateProvider.state(musicState);
    //$stateProvider.state(settingState);

    //二级菜单
    $stateProvider.state(friendState);
    //$urlRouterProvider.otherwise("/");
    $urlRouterProvider.when("/", "");  
});
