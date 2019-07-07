'use strict';

var catApp = angular.module('catApp', [
	'ngRoute',
	'catApp.home',
	'catApp.voteForCat'
]);

catApp.config(function($routeProvider) {

    $routeProvider.
        when('/cats', {
            templateUrl: './app/pages/home/home.template.html',
            controller: 'HomeController',
            controllerAs: 'vm'
        }).
        when('/voteForCat', {
            templateUrl: './app/pages/voteForCat/voteForCat.template.html',
            controller: 'VoteForCatController',
            controllerAs: 'vm'
        });
});