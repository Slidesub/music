//var app = angular.module("app", ["ngRoute"]);
//app.config(["$routeProvider", function($routeProvider) {
//    $routeProvider
//    .when("/login", {
//    	template:
//    		"<div class='col-md-12' style='text-align: center; margin-top: 50px; margin-bottom: 50px;'>用户登录" +
//            "</div>" +
//    		"<form name='registerForm' class='form-inline' role='form' data-ng-submit='submitRegister()' data-ng-controller='loginController' novalidate='novalidate'>" +
//    			"<div class='control-group'>" +
//    				"<label class='col-md-offset-3 col-md-1 control-label'>手机号码</label>" +
//    				"<div class='col-md-3 input-group'>" +
//    					"<div class='input-group-addon'>086-</div>" +
//    					"<input class='form-control' data-ng-model='phone' name='phone' type='text' placeholder='手机号码' />" +
//    				"</div>" +
//    				"<span data-ng-show='registerForm.phone.$error.required'>手机号码不能为空</span>" +
//    			"</div>" +
//    			"<div style='margin-top: 10px;' class='control-group'>" +
//    				"<label class='col-md-offset-3 col-md-1 control-label'>验证码</label>" +
//    				"<div class='col-md-3 input-group'>" +
//    					"<input class='form-control' name='code' data-ng-model='code' type='text' placeholder='短信验证码' />"+
//        				"<div class='input-group-addon btn btn-default' data-ng-bind='description' data-ng-disabled='!isDisable' data-ng-click='getCode()'></div>" +
//    				"</div>" +
//    				"<span data-ng-show='registerForm.code.$error.required'>验证码不能为空</span>" +
//    			"</div>" +
//    			"<div style='margin-top: 20px;' class='control-group col-md-offset-4 col-md-2'>" +
//    				"<button class='btn btn-primary col-md-12' type='submit'>登录</button>" +
//    			"</div>" +
//    		"</form>"
//    })
//    .when("/", {
//        templateUrl: "index",
//        controller: 'indexController',
//    })
//    .otherwise({redirectTo:'/login'});
//}]);
var app = angular.module("app", ["ui.router"]);
app.config(function($stateProvider, $urlRouterProvider) {
	var loginState = {
		name: "login",
		url: "/login",
		template:
    		"<div class='col-md-12' style='text-align: center; margin-top: 50px; margin-bottom: 50px;'>用户登录" +
            "</div>" +
    		"<form name='registerForm' class='form-inline' role='form' data-ng-submit='submitRegister()' data-ng-controller='loginController' novalidate='novalidate'>" +
    			"<div class='control-group'>" +
    				"<label class='col-md-offset-3 col-md-1 control-label'>手机号码</label>" +
    				"<div class='col-md-3 input-group'>" +
    					"<div class='input-group-addon'>086-</div>" +
    					"<input class='form-control' data-ng-model='phone' name='phone' type='text' placeholder='手机号码' />" +
    				"</div>" +
    				"<span data-ng-show='registerForm.phone.$error.required'>手机号码不能为空</span>" +
    			"</div>" +
    			"<div style='margin-top: 10px;' class='control-group'>" +
    				"<label class='col-md-offset-3 col-md-1 control-label'>验证码</label>" +
    				"<div class='col-md-3 input-group'>" +
    					"<input class='form-control' name='code' data-ng-model='code' type='text' placeholder='短信验证码' />"+
        				"<div class='input-group-addon btn btn-default' data-ng-bind='description' data-ng-disabled='!isDisable' data-ng-click='getCode()'></div>" +
    				"</div>" +
    				"<span data-ng-show='registerForm.code.$error.required'>验证码不能为空</span>" +
    			"</div>" +
    			"<div style='margin-top: 20px;' class='control-group col-md-offset-4 col-md-2'>" +
    				"<button class='btn btn-primary col-md-12' type='submit'>登录</button>" +
    			"</div>" +
    		"</form>"
		
	};
	var indexState = {
	        name: 'index',
	        url: '/',
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
	            $state.go("login");
	        } 
	    };
    $stateProvider
    .state(loginState)
    .state(indexState)
    $urlRouterProvider.otherwise("login"); 
});

app.controller("indexController", function($scope, $location) {
	if (!localStorage.cookie) {
		$location.path("/login");
	}
	$scope.logout = function() {
		delete localStorage.cookie;
		$location.path("/login");
	}
})

app.controller("loginController", function($scope, $interval, $http, $location) {
	$scope.description = "获取验证码";
	$scope.isDisable = true;
	$scope.getCode = function() {
        var second = 59;
        var timerHandler;
        if (timerHandler) {
            $scope.description = "获取验证码";
            $scope.isDisable = true;
            return;
        }
        timerHandler = $interval(function() {
            if (second <= 0) {
                $interval.cancel(timerHandler);
                second = 59;
                $scope.description = "获取验证码";
                $scope.isDisable = true;
            } else {
                $scope.description = second + "s后重发";
                $scope.isDisable = false;
                second--;
            }
        }, 1000, 100);
		//send
    }
	$scope.submitRegister = function() {
		if ($scope.registerForm.code && $scope.registerForm.phone) {
			$http.post("user/register", {formData: $scope.registerForm}).then(function(response) {
				localStorage.user = "admin";
				localStorage.cookie = "username";
				$location.path("/");
			}, function(response) {
				
			});
		}
	}
});