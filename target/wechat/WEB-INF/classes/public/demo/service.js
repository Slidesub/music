'use strict'

app.service("loadDataService", ["$http", function($http) {
    return {
        getData: function(url, params) {
            return $http({
                method: "get",
                url: url,
                params: params
            }).then(function(response) {
                return response.data;
            }, function(response) {
                console.info(response.data)
            });
        }
    };
}]);

app.service("deleteDataService", ["$http", function($http) {
    return {
        deleteData: function(url) {
            $http.post(url).then(function(response) {
                console.info(response)
            }, function(response) {
                console.info(response)
            });
        }
    };
}]);

app.service("updateDataService", ["$http", function($http) {
    return {
        updateData: function(url, data) {
            $http.put(url, data).then(function(response) {
                console.info(response)
            }, function(response) {
                console.info(response)
            });
        }
    };
}]);

//app.config(function($provide) {
//    $provide.provider("loadDataService", function() {
//        this.$get = function(url, params) {
//            return {
//                getData: function(url, params) {
//	                return $http({
//	                    method: "get",
//	                    url: url,
//	                    params: params
//	                }).then(function(response) {
//	                    return response.data;
//	                }, function(response) {
//	                    console.info(response.data)
//	                });
//            	}
//            }
//         }
//    });
//})
//
////使用一个service， 但是这个service里面没有greet方法。
//app.decorator("updateDataService", function($delegate) {
//	$delegate.greet = function() {
//		return "GREET";
//	}
//})
