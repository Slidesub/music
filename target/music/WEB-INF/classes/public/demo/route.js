'use strict'

//1. 如果模板过大，可以引入外部的模板文件
//2. 使用directive自定义指令
//3. 使用component

app.config(['$qProvider', function ($qProvider) {
    $qProvider.errorOnUnhandledRejections(false);
}]);

app.config(function($stateProvider, $urlRouterProvider) {
    var loginState = {
        name: "login",
        url: "/login",
        template:
            "<nav class='navbar navbar-default'>" +
                "<div class='container-fluid'>" +
                    "<div class='navbar-header'>" +
                        "<button type='button' class='navbar-toggle collapsed' data-toggle='collapse' data-target='#login' aria-expanded='false'>" +
                            "<span class='sr-only'>Toggle navigation</span>" +
                            "<span class='icon-bar'></span>" +
                            "<span class='icon-bar'></span>" +
                            "<span class='icon-bar'></span>" +
                        "</button>" +
                        "<a class='navbar-brand' href=''>DEMO</a>" +
                    "</div>" +
                    "<div class='collapse navbar-collapse' id='login'>" +
                        "<p class='navbar-text navbar-right'><a data-ui-sref='register' class='navbar-link'>注册</a></p>" +
                    "</div>" +
                "</div>" +
            "</nav>" +
            "<form class='' name='loginForm' role='form' data-ng-submit='login()' data-ng-controller='loginController' novalidate='novalidate'>" +
                "<div style='text-align: center; margin-top: 50px; margin-bottom: 30px;'><h4>用户登录</h4></div>" +
                "<div style='height: 20px;' class='form-group row'>" +
                    "<div style='color: red;' class='col-sm-6 col-md-4 col-sm-offset-3 col-md-offset-4' >" +
                        "{{msg}}" +
                    "</div>" +
                "</div>" +
                "<div class='form-group text-center row'>" +
                    "<div class='col-sm-6 col-md-4 col-sm-offset-3 col-md-offset-4'>" +
                        "<input class='form-control' data-ng-minlength='11' data-ng-maxlength='11' data-ng-model='phone' name='phone' type='text' placeholder='手机号码' required='required' />" +
                    "</div>" +
                "</div>" +
                "<div class='form-group row'>" +
                    "<div class='col-sm-6 col-md-4 col-sm-offset-3 col-md-offset-4'>" +
                        "<input class='form-control' name='password' data-ng-model='password' type='password' placeholder='密码' />"+
                    "</div>" +
                "</div>" +
                "<div class='form-group text-center row'>" +
                    "<div class='col-sm-6 col-md-4 col-sm-offset-3 col-md-offset-4'>" +
                        "<button class='form-control btn btn-primary' type='submit'>登录</button>" +
                    "</div>" +
                "</div>" +
            "</form>",
        controller: "loginController"
    };

    var registerState = {
            name: "register",
            url: "/register",
            template:
                "<nav class='navbar navbar-default'>" +
                "<div class='container-fluid'>" +
                    "<div class='navbar-header'>" +
                        "<button type='button' class='navbar-toggle collapsed' data-toggle='collapse' data-target='#register' aria-expanded='false'>" +
                            "<span class='sr-only'>Toggle navigation</span>" +
                            "<span class='icon-bar'></span>" +
                            "<span class='icon-bar'></span>" +
                            "<span class='icon-bar'></span>" +
                        "</button>" +
                        "<a class='navbar-brand' href=''>DEMO</a>" +
                    "</div>" +
                    "<div class='collapse navbar-collapse' id='register'>" +
                        "<p class='navbar-text navbar-right'><a data-ui-sref='login' class='navbar-link'>登录</a></p>" +
                    "</div>" +
                "</div>" +
            "</nav>" +
            "<form name='registerForm' class='form-inline' role='form' data-ng-submit='submitRegister()' data-ng-controller='registerController' novalidate='novalidate'>" +
                "<div style='text-align: center; margin-top: 50px; margin-bottom: 30px;'><h4>用户注册</h4></div>" +
                "<div class='control-group'>" +
                "<div style='height: 20px;' class='row'>" +
                    "<div style='color: red;' class='col-sm-6 col-md-4 col-sm-offset-3 col-md-offset-4' >" +
                        "{{msg}}" +
                    "</div>" +
                "</div>" +
                "</div>" +
                "<div class='control-group text-center'>" +
                    "<div class='col-sm-6 col-md-4 input-group'>" +
                        "<div class='input-group-addon'>+86</div>" +
                        "<input class='form-control' data-ng-model='phone' name='phone' type='text' placeholder='手机号码' required='required' />" +
                    "</div>" +
                "</div>" +
                "<div style='margin-top: 15px;' class='control-group text-center'>" +
                    "<div class='col-sm-6 col-md-4 input-group'>" +
                        "<input style='border-radius: 4px;' class='form-control' data-ng-model='password' name='password' type='password' placeholder='设置密码' required='required' />" +
                    "</div>" +
                "</div>" +
                "<div style='margin-top: 15px;' class='control-group text-center'>" +
                    "<div class='col-sm-6 col-md-4 input-group'>" +
                        "<input class='form-control' name='code' data-ng-model='code' type='text' placeholder='短信验证码' />"+
                        "<div class='input-group-addon btn btn-default'><div class='' data-ng-bind='description' data-ng-disabled='isDisable' data-ng-click='getCode()'></div></div>" +
                    "</div>" +
                "</div>" +
                "<div style='margin-top: 15px; padding-left: 0px;' class='control-group text-center'>" +
                    "<div class='col-sm-6 col-md-4 input-group'>" +
                        "<button style='border-radius: 4px;' class='form-control btn btn-primary' type='submit'>注册</button>" +
                    "</div>" +
                "</div>" +
            "</form>",
            controller: "registerController"
        };

    var appState = {
        name: 'app',
        url: '/',
        template:
        "<nav class='navbar navbar-default'>" +
            "<div class='container-fluid'>" +
                "<div class='navbar-header'>" +
                    "<button type='button' class='navbar-toggle collapsed' data-toggle='collapse' data-target='#demo' aria-expanded='false'>" +
                        "<span class='sr-only'>Toggle navigation</span>" +
                        "<span class='icon-bar'></span>" +
                        "<span class='icon-bar'></span>" +
                        "<span class='icon-bar'></span>" +
                    "</button>" +
                    "<a class='navbar-brand' href=''>DEMO</a>" +
                "</div>" +
                "<div class='collapse navbar-collapse' id='demo'>" +
                    "<ul class='nav navbar-nav'>" +
                        "<li data-ui-sref-active='active'><a ui-sref-opts='{reload: true}' data-ui-sref='app.index'>首页</a></li>" +
                        "<li data-ui-sref-active='active'><a ui-sref-opts='{reload: true}' data-ui-sref='app.music'>我的音乐</a></li>" +
                        "<li data-ui-sref-active='active'><a ui-sref-opts='{reload: true}' data-ui-sref='app.user'>用户</a></li>" +
                        "<li data-ui-sref-active='active'><a ui-sref-opts='{reload: true}' data-ui-sref='app.setting'>设置</a></li>" +
                    "</ul>" +
                    "<div class='navbar-text navbar-right dropdown'>" +
                        "<span>{{username}}</span>" +
                        "<a href='' data-ng-click='logout()'>|登出</a>" +
                    "</div>" +
                "</div>" +
            "</div>" +
        "</nav>" +
        "<div data-ui-view=''></div>",
        controller: "appController"
    };

    var musicState = {
        name: "app.music",
        url: "music",
        template:
            "<div>" +
                "<div>" +
                    "<ul class='nav nav-tabs' style='display: flex; flex-wrap: nowrap;'>" +
                        "<li role='presentation' data-ui-sref-active='active'><a data-ui-sref='app.music.recommend({id: recommend})'>我喜欢</a></li>" +
                        "<li role='presentation' data-ui-sref-active='active'><a data-ui-sref='app.music.sheet({id: songs})'>我创建的歌单</a></li>" +
                        "<li role='presentation' data-ui-sref-active='active'><a data-ui-sref='app.music.anchor({id: anchor})'>关注</a></li>" +
                    "</ul>" +
                "</div>" +
                "<div data-ui-view=''></div>" +
            "</div>",
        controller: function($state, $location) {
        	if (localStorage.user) {
        	    $state.go("app.music.recommend");
        	    //$state.go("app.music.recommend.userMusic");
        	} else {
        		$state.go("app.music.login");
        	}
        }
    };

    var indexState = {
       name: "app.index",
       url: "index",
//       template: 
//           "<div class='row'>" +
//               "<div class='col-sm-12 col-md-4 col-md-offset-1 text-center'>" +
//                   "<img src='/image/disc.png'></img>" +
//               "</div>" +
//               "<div class='col-sm-12 col-md-6 text-center'>" +
//                   "<div style='padding-top: 10px; padding-bottom: 10px;'>歌名</div>" +
//                   "<div style='padding-left: 32px;text-overflow: ellipsis;white-space: nowrap;overflow: hidden;'>" +
//                   "暂无歌词" +
//                   "</div>" +
//               "</div>" +
//           "</div>" +
//           "<div class='navbar navbar-fixed-bottom'>" +
//               "<div class='col-sm-12 col-md-12'>" +
//                   "<player music-src='{{src}}'></palyer>" +
////                   "<audio id='' class='media-object' style='margin: 0 auto;' controls='controls'>" +
////                       "<source data-ng-src='' type='audio/mp3' />" +
////                  "</audio>" +
//               "</div>" +
//           "</div>",
       templateUrl: "index",
       controller: function($state) {
           
       }
    };

    // '我的音乐'下提示登录
    var musicLoginState = {
        name: "app.music.login",
        url: "/login",
        template:
            "<div class='row' style='color: white;'>" +
                "<div class='col-md-12' style='margin-top: 150px;'><h1 style='text-align: center;'>私人音乐空间</h1><div>" +
                "<div class='col-md-12' style='margin-top: 30px; text-align: center;'>请先<a data-ui-sref='login'>登陆</a></div>" +
            "</div>"
    };
    
    // '我喜欢'
    var recommendState = {
        name: "app.music.recommend",
        url: "/recommend",
        template:
            "<div style='color: white;'>" +
                "<div class='row' style='margin-top: 20px;'>" +
                    "<div class='col-md-2 col-sm-2 col-xs-2'>" +
                        "<a data-ui-sref='app.music.recommend.userMusic'>歌曲{{musicCount}}</a>" +
                    "</div>" +
                    "<div class='col-md-2 col-sm-2 col-xs-2'>" +
                        "<div data-ui-sref-active='active'><a data-ui-sref='app.music.recommend.userSheet'>歌单{{sheetCount}}</a></div>" +
                    "</div>" +
                "</div>" +
                "<div data-ui-view></div>" +
            "</div>",
        controller: ['$scope', '$state', 'loadUserMusic', function($scope, $state, loadUserMusic) {
            if (localStorage.user) {
            	$scope.sheetCount = 0;
                $scope.userMusics = loadUserMusic[0];
                $scope.musicCount = loadUserMusic[1].count;
                $scope.pageCount = loadUserMusic[1].pageCount;
                $scope.currentPage = loadUserMusic[1].currentPage;
                $scope.pageSize = loadUserMusic[1].pageSize;
                //$scope.userSheets = loadUserSheet;
                $state.go("app.music.recommend.userMusic");
            } else {
                $state.go("app.music.login");
            }
        }],
	    resolve: {
	        loadUserMusic: ["loadDataService", "pageSize", function(loadDataService, pageSize) {
	            var page = {
		                currentPage: 1,
		                pageSize: pageSize,
		                userId: angular.fromJson(localStorage.user).id
		            }
		            return loadDataService.getData("music/listUserMusic", page).then(function(result) {
		                return result;
		            });
		        }],
//	        loadUserSheet: ["loadDataService", "pageSize", function(loadDataService, pageSize) {
//	            var page = {
//		                currentPage: 1,
//		                pageSize: pageSize,
//		                userId: angular.fromJson(localStorage.user).id
//		            }
//		            return loadDataService.getData("music/listUserSheet", page).then(function(result) {
//		                return result;
//		            });
//		        }],
	    }
    };

    var userMusicState = {
    	name: "app.music.recommend.userMusic",
    	url: "/userMusic",
    	template:
    		"<div style='color: white;'>" +
	    		"<div class='row' style='margin-top: 20px;'>" +
	    			"<div class='col-md-12'>播放全部</div>" +
	    		"</div>" +
	    		"<div class='row' style='margin-top: 50px;'>" +
	                "<div class='col-md-12'>" +
	                    "<div>" +
	                        "<li data-ng-repeat='userMusic in userMusics' style='display: flex; justify-content: flex-start;'>" +
	                            "<span>" +
	                                "<img id='playpause{{userMusic.id}}' data-ng-src='music/play.png' data-ng-click='open(userMusic.id)'></img>" +
	                                "<audio id='aud{{userMusic.id}}' class='media-object'>" +
                                        "<source data-ng-src='{{userMusic.music.src}}' type='audio/mp3' />" +
                                    "</audio>" +
	                                "<span style='margin-left: 30px;'>{{userMusic.music.name}}</span>" +
	                            "</span>" +
	                            "<span style='margin-left: 150px;'>{{userMusic.music.singer}}</span>" +
	                            "<span style='margin-left: 150px;'>{{userMusic.music.time}}</span>" +
	                        "</li>" +
	                    "</div>" +
	                "</div>" +
                "</div>" +
            "</div>" +
            "<pagenation page='{{pageCount}}'></pagenation>",
        controller: ["$scope", "loadDataService", function($scope, loadDataService) {
            $scope.userMusics = $scope.$parent.userMusics;
            $scope.pageCount = $scope.$parent.pageCount;
            $scope.currentPage = $scope.$parent.currentPage;
            $scope.pageSize = $scope.$parent.pageSize;

            $scope.selectPage = function(page) {
                page.userId = angular.fromJson(localStorage.user).id;
                loadDataService.getData("music/listUserMusic", page).then(function(response) {
                    $scope.userMusics = response[0];
                    $scope.pageCount = response[1].pageCount;
                    $scope.currentPage = response[1].currentPage;
                    $scope.pageSize = response[1].pageSize;
                }, function(response) {
                    console.info(resoponse.data)
                });
            }

            $scope.open = function(id) {
                var aud = document.getElementById("aud"+id);
                var img = document.getElementById("playpause"+id);
                    if (aud.paused) {
                        aud.play();
                    } else {
                        aud.pause();
                    }
                aud.addEventListener("play", function (e) {
                    img.src="music/pause.png";
                }, false);
                aud.addEventListener("pause", function (e) {
                    img.src="music/play.png";
                }, false);
            };
        }]
    };

    var userSheetState = {
        	name: "app.music.recommend.sheets",
        	url: "/sheets",
        	template:
        		"<div style='color: white;'>" +
    	    		"<div class='row'>" +
    	    			"<div>播放全部</div>" +
    	    		"</div>" +
    	    		"<div class='row'>" +
                    "<div class='col-md-12'>" +
                        "<ul>" +
                            "<li data-ng-repeat='sheet in userSheets' style='display: flex; justify-content: space-around;'>" +
                                "<span>" +
                                    "<img data-ng-src='' alt='img'></img>" +
                                    "<span>{{sheet.name}}</span>" +
                                "</span>" +
                                "<span>{{sheet.singer}}</span>" +
                                "<span>{{sheet.time}}</span>" +
                            "</li>" +
                        "</ul>" +
                    "</div>" +
                "</div>" +
        		"</div>",
        	controller: function() {
        		
        	}
        };

    // '我创建的歌单'
    var sheetState = {
        name: "app.music.sheet",
        url: "/song",
        template:
            "<div style='color: white'>" +
                "<div class='row' style='color: white; margin-top: 20px;'>" +
                    "<div class='col-md-1'>" +
                        "<div class='btn btn-default' data-ng-click='creatSheet()'>新建歌单</div>" +
                    "</div>" +
                "</div>" +
                "<div class='row' style='color: white; margin-top: 10px;'>" +
                    "<div class='col-md-1'>歌单</div>" +
                "</div>" +
                "<div class='row'>" +
                    "<div class='col-md-12'>" +
                        "<ul>" +
                            "<li data-ng-repeat='sheet in sheets' style='display: flex; justify-content: space-around;'>" +
                                "<span>" +
                                    "<img data-ng-src='{{sheet.src}}' alt='img'></img>" +
                                    "<a href='' data-ui-sref='app.music.sheetMusic({id: sheet.id})'> {{sheet.name}} </a>" +
                                "</span>" +
                                "<span>{{sheet.description}}</span>" +
                                "<span>{{sheet.count}}</span>" +
                                "<span>{{sheet.user.name}}</span>" +
                            "</li>" +
                        "</ul>" +
                    "</div>" +
                "</div>" +
                "<div ng-show='dialog' class='panel panel-default' style='color: black; z-index: 100; position: fixed; top: 60%; left: 50%; transform: translateX(-50%) translateY(-50%);'>" +
                "<div class='panel-heading text-center'>新建歌单</div>" +
                    "<div class='panel-body'>" +
                    	"<div><input type='text' placeholder='名称' data-ng-model='name'></input></div>" +
                    	"<div style='margin-top: 10px;'><input type='text' placeholder='描述' data-ng-model='name'></input></div>" +
//                    	"<input type='file'></input>" +
                    	"<div style='margin-top: 10px;'><input type='submit'></input></div>" +
                    "</div>" +
				"</div>" +
            "</div>" +
            "<pagenation page='{{pageCount}}'></pagenation>",
        controller: ["$scope", "$state", "loadSheet", "loadDataService", function($scope, $state, loadSheet, loadDataService) {
        	if (!localStorage.user) {
        		$state.go("app.music.login");
        	} else {
        		$scope.sheets = loadSheet[0];
                $scope.pageCount = loadSheet[1].pageCount;
                $scope.currentPage = loadSheet[1].currentPage;
                $scope.pageSize = loadSheet[1].pageSize;

                $scope.selectPage = function(page) {
                    page.userId = angular.fromJson(localStorage.user).id;
                    loadDataService.getData("music/loadSheet", page).then(function(response) {
                        $scope.userMusics = response[0];
                        $scope.pageCount = response[1].pageCount;
                        $scope.currentPage = response[1].currentPage;
                        $scope.pageSize = response[1].pageSize;
                    }, function(response) {
                        console.info(resoponse.data)
                    });
                }

                $scope.dialog = false;
                $scope.creatSheet = function() {
                	$scope.dialog = !$scope.dialog
                }
        	}
        }],
        resolve: {
        	loadSheet : ["loadDataService", "pageSize", function(loadDataService, pageSize) {
        		if (localStorage.user) {
        			var page = {
                        currentPage: 1,
                        pageSize: pageSize,
                        userId: angular.fromJson(localStorage.user).id
                    }
        			return loadDataService.getData("music/loadSheet", page).then(function(result) {
                        return result;
                    });
        		}
        	}]
        }
    };
    
    var sheetMusicState = {
    	    name: "app.music.sheetMusic",
    	    url: "/sheetMusic/:id",
    	    template:
    	        "<div style='color: white;'>" +
    	            "<div style='margin-top: 20px' class='row'>" +
    	                "<div class='col-md-2'>img</div>" +
    	                "<div class='col-md-10'>" +
    	                    "<div>名称</div>" +
    	                    "<div>创建人</div>" +
    	                    "<div>收藏</div>" +
    	                "</div>" +
    	            "</div>" +
    	            "<div class='row'>" +
    	                "<div class='col-md-2'>歌曲 10</div>" +
    	            "</div>" +
    	            "<div class='row'>" +
    	                "<div class='col-md-1'>图片</div>" +
    	                "<div class='col-md-2'>歌曲名称</div>" +
    	                "<div class='col-md-2'>歌手</div>" +
    	                "<div class='col-md-2'>时长</div>" +
    	            "</div>" +
    	        "</div>",
    	    controller: ['$scope', '$state', '$stateParams', function($scope, $state, $stateParams) {
    	        console.info($stateParams.id);
    	    }],
    	    resolve: {
    	        loadSheetMusic : ['$stateParams', "loadDataService", "pageSize", function($stateParams, loadDataService, pageSize) {
    	            var page = {
    	                currentPage: 1,
    	                pageSize: pageSize,
    	                userId: $stateParams.id
    	            }
    	            return loadDataService.getData("music/loadSheetMusic", page).then(function(result) {
    	                return result;
    	            });
    	        }]
    	    }
    	};

    
    var newSheetState = {
        name: "app.music.newSheet",
        url: "/newSheet",
        template: "<h1></h1>",
        controller: ""
    };

    // '关注'
    var anchorState = {
        name: "app.music.anchor",
        url: "/anchor",
        template: "<h1>ANCHOR</h1>",
        controller: function($state, $location) {
            if (localStorage.user) {
                $state.go("app.music.anchor");
            } else {
                $state.go("app.music.login");
            }
        }
    };

    // '动态'
    var rankingState = {
        name: "app.music.ranking",
        url: "/ranking",
        template: "<h1>RANKING</h1>"
    };

    var userState = {
        name: "app.user",
        url: "user",
        template: 
            "<div>" +
                "<ul class='nav nav-tabs' style='display: flex; flex-wrap: nowrap;'>" +
                    "<li role='presentation' data-ui-sref-active='active'><a href='' data-ui-sref='app.user.dynamic({id: friend})'>动态</a></li>" +
                    "<li role='presentation' data-ui-sref-active='active'><a href='' data-ui-sref='app.user.friend({id: friend})'>好友</a></li>" +
                "</ul>" +
                "<div data-ui-view=''></div>" +
            "</div>",
         controller: function($state) {
             $state.go("app.user.dynamic");
         }
    };

    // '好友'
    var friendState = {
        name: 'app.user.friend',
        url: '/friend',
        template:
            "<div style='margin-top: 5px;'>" +
            "<table class='table table-striped'>" +
                "<thead>" +
                    "<th>编号</th>" +
                    "<th>姓名</th>" +
                    "<th>删除好友</th>" +
                "</thead>" +
                "<tbody>" +
                "<tr id='user{{friend.id}}' data-ng-repeat='friend in friends | filter: name'>" +
                    "<td>{{$index + 1}}</td>" +
                    "<td>{{friend.name}}</td>" +
                    "<td ><button delete-dom class='btn' data-ng-click='deleteFriend(friend.id)'>delete</button></td>" +
                "</tr>" +
                "</tbody>" +
            "</table>" +
        "</div>",
        controller: "friendController", 
        resolve: {
            loadFriends: ["loadDataService", function(loadDataService) {
                return loadDataService.getData("user/loadFriends").then(function(result) {
                    return result;
                });
            }]
        }
    };
    var dynamicState = {
        name: "app.user.dynamic",
        url: "/dynamic",
        template:
            "<div class='row'>" +
            "<ul class='nav'>" +
                "<li data-ng-repeat='share in shares'>" +
                    "<div class='col-xs-12 col-sm-6 col-md-6'>" +
                        "<div style='padding: 5px 5px 5px 5px; margin-top: 5px;' class='border'>" +
                            "<div>" +
                                "<img style='width:32px;' class='img-circle' data-ng-src='{{share.user.avatar}}' alt=''></img>" +
                                "<span><a href=''>{{share.user.name}}</a>分享：</span>" +
                                "<span class='caret pull-right'></span>" +
                            "</div>" +
                            "<div style='padding-left: 32px;text-overflow: ellipsis;white-space: nowrap;overflow: hidden;'>" +
                            "{{share.description}}" +
                            "</div>" +
                            "<div class='media'>" +
                                "<div class='media-left'>" +
                                    "<img id='playpause{{share.id}}' style='width: 16px;' src='image/play.png' data-ng-click='open(share.id)'></img>" +
                                    "<audio id='aud{{share.id}}' class='media-object'>" +
                                        "<source data-ng-src='{{share.music.src}}' type='audio/mp3' />" +
                                    "</audio>" +
                                "</div>" +
                                "<div class='media-body'>" +
                                    "{{share.music.name}}" +
                                "</div>" +
                            "</div>" +
                            "<div class='text-right'>" +
                                "<span style='margin-right: 5px;'><a href='' data-ng-click='up(share.id)'>" +
                                "<span id='up{{share.id}}' class='badge'>{{share.up}}</span>点赞</a></span>" +
                                "<span style='margin-right: 5px;'><a href=''>评论</a></span>" +
                                "<span style='margin-right: 5px;'><a href=''>分享</a></span>" +
                            "</div>" +
                        "</div>" +
                    "</div>" +
                "</li>" +
            "</ul>" +
            "</div>"
            + "<pagenation page='{{pageCount}}'></pagenation>",
        controller: "dynamicController",
        resolve: {
            loadShares: ["loadDataService", "pageSize", function(loadDataService, pageSize) {
                var page = {
                    currentPage: 1,
                    pageSize: pageSize,
                }
                return loadDataService.getData("user/loadShares", page).then(function(result) {
                    return result;
                });
            }]
        }
    };

    var settingState = {
        name: "app.setting",
        url: "setting",
        template: 
            "<div>" +
                "<form class='form-horizontal' name='userForm' role='form' data-ng-submit='update()' novalidate='novalidate'>" +
                "<div style='text-align: center; margin-top: 50px; margin-bottom: 30px;'><h4>个人信息</h4></div>" +
                "<div style='height: 20px;' class='form-group row'>" +
                    "<div style='color: red;' class='col-sm-6 col-md-4 col-sm-offset-3 col-md-offset-4' >" +
                        "{{msg}}" +
                    "</div>" +
                "</div>" +
                "<div class='form-group row'>" +
                    "<label class='col-sm-2 col-md-4 control-label'>手机号</label>" +
                    "<div class='col-sm-10 col-md-4'>" +
                       "<input class='form-control' data-ng-minlength='11' data-ng-maxlength='11' data-ng-model='phone' name='phone' type='text' readonly='readonly' required='required' />" +
                    "</div>" +
                "</div>" +
                "<div class='form-group row'>" +
                    "<label class='col-sm-2 col-md-4 control-label'>昵称</label>" +
                    "<div class='col-sm-10 col-md-4 '>" +
                        "<input class='form-control' data-ng-minlength='11' data-ng-maxlength='11' data-ng-model='nickname' name='nickname' type='text' required='required' />" +
                    "</div>" +
                "</div>" +
                "<div class='form-group row'>" +
                    "<label class='col-sm-2 col-md-4 control-label'>学校</label>" +
                    "<div class='col-sm-10 col-md-4' >" +
                        "<input class='form-control' name='school' data-ng-model='school' type='text'/>"+
                    "</div>" +
                "</div>" +
                "<div class='form-group text-center row'>" +
                    "<div class='col-sm-6 col-md-4 col-sm-offset-3 col-md-offset-4'>" +
                        "<button class='form-control btn btn-primary' type='submit'>更新</button>" +
                    "</div>" +
                "</div>" +
            "</form>" +
            "</div>"
    };

    $stateProvider
    .state(appState)
    .state(loginState)
    .state(registerState)

    .state(indexState)

    .state(musicState)
    .state(recommendState)
    .state(sheetState)
    .state(anchorState)
    .state(rankingState)
    .state(userMusicState)
    .state(userSheetState)
    .state(sheetMusicState)
    .state(musicLoginState)

    .state(userState)
    .state(friendState)
    .state(dynamicState)

    .state(settingState)

    $urlRouterProvider.otherwise("/"); 
});