'use strict'

app.controller("appController", function($scope, $location, $state, $stateParams) {
    //$scope作用域，一个controller对应一个$scope
    //$location类似 window.location对象
    //$state服务
    //$stateParams服务，获取路由参数
    if (localStorage.user) {
        $scope.username = angular.fromJson(localStorage.user).username;
        //$scope.username = JSON.parse(localStorage.user).username;
        //$state.go("app.index");
    }
//    else {
//        $location.path("/login");
//    }

    $scope.logout = function() {
        delete localStorage.user;
        $location.path("/login");
    }
})

app.controller("loginController", function($scope, $http, $location) {
    //$http服务
    $scope.login = function() {
        if (!$scope.loginForm.phone.$dirty) {
            $scope.msg = '*手机号码不能为空';
        } else if (!$scope.loginForm.password.$dirty) {
            $scope.msg = '*密码不能为空';
        } else if ($scope.loginForm.phone.$invalid) {
            $scope.msg = '*手机号码格式有误';
        } else {
            var formData = {
                phone: $scope.loginForm.phone.$modelValue,
                password: $scope.loginForm.password.$modelValue
            }
            $http.post("user/login", formData).then(function(response) {
                if (response.data.errCode == '1') {
                    //localStorage.user = JSON.stringify(response.data.errBody);
                    localStorage.user = angular.toJson(response.data.errBody);
                    $location.path("/");
                } else {
                    $scope.msg = '*' + response.data.errMsg;
                }
            }, function(response) {
                $scope.msg = '*登录失败, 请重新登录';
            });
        }
    }
});

app.controller("musicController", function($scope) {
    
});

app.controller("registerController", function($scope, $interval, $http, $location) {
    $scope.description = "获取验证码";
    $scope.isDisable = false;
    $scope.getCode = function() {
        if (!$scope.registerForm.phone.$dirty) {
            $scope.msg = '*手机号码不能为空';
            return;
        } else if ($scope.registerForm.phone.$invalid) {
            $scope.msg = '*手机号码格式有误';
            return;
        } else {
        }
        var second = 59;
        if ($scope.timerHandler) {
            return;
        }
        $scope.timerHandler = $interval(function() {
            if (second <= 0) {
                $interval.cancel($scope.timerHandler);
                $scope.timerHandler = undefined;
                second = 59;
                $scope.description = "获取验证码";
                $scope.isDisable = false;
            } else {
                $scope.description = second + "s后重发";
                $scope.isDisable = true;
                second--;
            }
        }, 1000, 100);//1000ms, 限制次数100次
    }

    $scope.submitRegister = function() {
        if (!$scope.registerForm.phone.$dirty) {
            $scope.msg = '*手机号码不能为空';
        } else if (!$scope.registerForm.password.$dirty) {
            $scope.msg = '*密码不能为空';
        } else if ($scope.registerForm.phone.$invalid) {
            $scope.msg = '*手机号码格式有误';
        } else {
            var formData = {
                phone: $scope.registerForm.phone.$modelValue,
                password: $scope.registerForm.password.$modelValue
            }
            $http.post("user/register", formData).then(function(response) {
                if (response.data.errCode == '1') {
                    localStorage.user = JSON.stringify(response.data.errBody);
                    $location.path("/");
                } else {
                    $scope.msg = '*' + response.data.errMsg;
                }
            }, function(response) {
                $scope.msg = '*注册失败, 请重新注册';
            });
        }
    }
});

app.controller("friendController", ["$scope", "loadFriends", "deleteDataService", function($scope, loadFriends, deleteDataService) {
    $scope.friends = loadFriends;
    $scope.deleteFriend = function(id) {
        deleteDataService.deleteData("user/deleteFriend/" + id);
        //angular.element("#user" + id).remove();
  }
//    $scope.deleteFriend = function(id) {
//        return "<confirm-dialog></confirm-dialog>";
//    }
//    $scope.ok = function() {
//        deleteDataService.deleteData("user/deleteFriend/" + id);
//        angular.element("#user" + id).remove();
//    }
}]);

app.directive("deleteDom", function() {
    return {
        link: function($scope, $element, $attrs, $controller) {
            $element.on("click", function() {
                $element.parents("tr").remove();
            })
        }
    }
});

app.controller("dynamicController", ["$scope", "loadShares", "updateDataService", 'loadDataService', function($scope, loadShares, updateDataService, loadDataService) {
    $scope.shares = loadShares[0];
    $scope.pageCount = loadShares[1].pageCount;
    $scope.currentPage = loadShares[1].currentPage;
    $scope.pageSize = loadShares[1].pageSize;
    $scope.open = function(id) {
        var aud = document.getElementById("aud"+id);
        var img = document.getElementById("playpause"+id);
            if (aud.paused) {
                aud.play();
            } else {
                aud.pause();
            }
        aud.addEventListener("play", function (e) {
            img.src="image/pause.png";
        }, false);
        aud.addEventListener("pause", function (e) {
            img.src="image/play.png";
        }, false);
    };
    $scope.up = function(id) {
        var data = {id: id};
        updateDataService.updateData("user/upShare", data);
        var upCount = parseInt(angular.element("#up"+id).text());
        angular.element("#up"+id).text(upCount + 1);
    }

    $scope.selectPage = function(pageIndex) {
        loadDataService.getData("user/loadShares", page).then(function(response) {
            $scope.shares = response[0];
            $scope.pageCount = response[1].pageCount;
            $scope.currentPage = response[1].currentPage;
            $scope.pageSize = response[1].pageSize;
        }, function(response) {
            console.info(resoponse.data)
        });
    }
}]);

app.component("pagenation", {
    template:
        "<nav class='row text-center' aria-label='Page navigation'>" +
        "<ul class='pagination'>" +
         "<li>" +
            "<a href='' data-ng-click='prev(currentPage)' aria-label='Previous'>" +
              "<span aria-hidden='true'>&laquo;</span>" +
            "</a>" +
          "</li>" +
          "<li data-ng-repeat='index in indexs' data-ng-class='{active: isAvtivePage(index)}'>" +
              "<a href='' data-ng-click='selectPage(index)'>{{index}}</a>" +
          "</li>" +
          "<li>" +
            "<a href='' data-ng-click='next(currentPage)' aria-label='Next'>" +
              "<span aria-hidden='true'>&raquo;</span>" +
            "</a>" +
          "</li>" +
        "</ul>" +
      "</nav>",
    controller: "pagenationController",
    bindings: {
        page: "@",
        selectPage: '&'
    }
});

app.controller("pagenationController", ["$scope", function($scope) {

    $scope.currentPage = $scope.$parent.currentPage;
    $scope.pageSize = $scope.$parent.pageSize;
    $scope.pageCount = $scope.$parent.pageCount;

    if ($scope.pageCount > 5) {
        $scope.indexs = [1, 2, 3, 4, 5, '...', $scope.pageCount];
    } else {
        $scope.indexs = [];
        for (var i = 1; i <= $scope.pageCount; i++) {
            $scope.indexs.push(i.toString());
        }
    }

    $scope.isAvtivePage = function(index) {
        if (index == $scope.currentPage) {
            return true;
        }
        return false;
    }
    $scope.next = function(index) {
        index = parseInt(index);
        if (index + 1 > $scope.pageCount) {
            $scope.currentPage = $scope.pageCount;
        } else {
            $scope.currentPage = index + 1;
        }
        $scope.selectPage($scope.currentPage);
    }

    $scope.prev = function(index) {
        index = parseInt(index);
        if (index < 2) {
            $scope.currentPage = 1;
        } else {
            $scope.currentPage = index - 1;
        }
        $scope.selectPage($scope.currentPage);
    }

    $scope.selectPage = function(index) {
        $scope.currentPage = index;
        if (index > $scope.pageCount) {
            $scope.currentPage = $scope.pageCount
        }
        var page = {
            currentPage: index,
            pageSize: $scope.$parent.pageSize,
        };
        $scope.$parent.selectPage(page);
    }
}]);

app.component("confirmDialog", {
    template:
        "<div class=''>" +
            "<div></div>" +
            "<div>确定？</div>" +
            "<div>" +
                "<button data-ng-click='ok($ctrl.url)' class='btn btn-primary'>确定</button>" +
                "<button data-ng-click='cancel($ctrl.url)' class='btn'>取消</button>" +
            "</div>" +
        "</div>",
    controller: function($scope) {
        $scope.ok = function(url) {
            console.info(url);
            $scope.$parent.ok();
        };
        $scope.cancel = function(url) {
            console.info(url);
        }
    },
    bindings: {
        url: "@"
    }
});
app.directive("dialog", function() {
	return {
		 restrict: "AECM",
		 template: 
			 "<div ng-hide='myDialog'>" +
			 	"<input type='text' placeholder='名称'></input>" +
			 	"<input type='file'></input>" +
			 	"<input type='submit'></input>" +
			 "</div>",

		 bindings: {
	        
	    },
		 controller: function() {
			 
		 }
	};
});
app.directive("player", function() {
    return {
        restrict: "AECM",
        template: "<div id='jpdiv'></div>",
        controller: function($scope, loadDataService) {
            var data = {"id": "1"};
            if ($scope.music) {
                data.id = $scope.music.id;
            }
            $scope.music = loadDataService.loadMusic(data);
            $scope.loadMusic = function(data) {
                return loadDataService.getData("user/loadShares", data).then(function(result) {
                    return result;
                });
            }
        },
        scope: {
            musicSrc: "@musicSrc"
        },
        link: function(scope, elem, attrs) {
        	$("#jpdiv").jPlayer({
        		ready: function (event) {
        			$(this).jPlayer("setMedia", {
        				mp3:"{{musicSrc}}" //mp3的播放地址
        			});
        		},
        		timeupdate: function(event) {
        			if(event.jPlayer.status.currentTime==0){
        				time = "";
        			}else {
        				time = event.jPlayer.status.currentTime;
        			}
        		},
        		play: function(event) {
        			//点击开始方法调用lrc。start歌词方法 返回时间time
        			$.lrc.start($('#lrc_content').val(), function() {
        				return time;
        			});
        		},
        		ended:function(event){
                    $("#lrc_list").removeAttr("style").html("<li>歌曲播放完毕！</li>");
                },
        		//swfPath: "/js",  		//存放jplayer.swf的决定路径
        		solution:"html, flash", //支持的页面
        		supplied: "mp3",		//支持的音频的格式
        		wmode: "window"
        	});
        }
    };
});