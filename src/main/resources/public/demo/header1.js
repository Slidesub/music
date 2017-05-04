'use strict'
var app = angular.module('header', [ngRouter]);

app.config(function($routeProvider) {
    $routeProvider
    .when("/index", {templateUrl: "demo/index"})
    .when("/music", {templateUrl: "demo/music"})
    .when("/user", {templateUrl: "demo/music"})
    .when("/setting", {templateUrl: "demo/music"})
    .otherwise({redirectTo: '/'})
});