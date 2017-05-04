'use strict'

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
    					"<span><a data-ng-click='deleteFriendController'>delete</a></span>" +
    				"</li>" +
    			"</ul>" +
    		"</div>",
    	controller: function($scope, $http) {
    		$http.get("user/loadFriends").then(function(response) {
    	        $scope.friends = response.data;
    	    });
    	},
    	resolve: function ($scope, $http) {
    		var deleteFriendController = function($scope, $http) {
    			$http.post("user/deleteFriends?id="+ $scope.userId).then(function(response) {
    				if (response.suceess) {
    					alert('success');
    				}
    		    });
    		};
    	}
    };
//    var deleteFriendState = {
//    	name: 'friend.deleteFriend',
//        url: 'user/friends/delete_friend',
//        controller: function($scope, $stateParams) {
//        	$http.post("user/deleteFriends?id="+ $stateParams.userId).then(function(response) {
//        		if (response.suceess) {
//        			alert('success');
//        		}
//    	    });
//        }
//    };
    $stateProvider.state(userState);
    $stateProvider.state(friendState);
    //$stateProvider.state(deleteFriendState);

    $urlRouterProvider.otherwise('/');
});




















/*
app.component('indexComponent', {
    //template: '',
    //controller: '',
});


app.config(function($stateProvider, $urlRouterProvider) {
    $stateProvider
//    .state("index", {
//        url: 'index',
//        views: {
//            "demoView": {
//                templateUrl: "music/index"
//            }
//        }
//    })
    .state("music", {
        url: 'music',
        views: {
            "demoView": {
                templateUrl: "music/music"
            }
        }
    })
    .state("user", {
        url: 'user',
        views: {
            "demoView": {
                templateUrl: "music/user"
            }
        }
    })
    .state("setting", {
        url: 'setting',
        views: {
            "demoView": {
                templateUrl: "music/setting"
            }
        }
    })
    .state("index.music2", {
        url: '/{id}',
        views: {
            "indexView": {
                templateUrl: getTemplateUrl
            }
        }
    })
        .state("user.music2", {
        url: '/{id}',
        views: {
            "userView": {
                templateUrl: getTemplateUrl,
                controller: "userController"
            }
        }
    })

$stateProvider.state(indexState);
    $urlRouterProvider.otherwise('/');
    function getTemplateUrl($params) {
        return "music/" + $params.id;
    }
});
*/