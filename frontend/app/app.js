var app = angular.module("SdaApp", ['ngResource', 'ui.router'])
    .config(function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise("/products");

        $stateProvider
            .state("app", {
                abstract: true,
                url: '',
                templateUrl: 'app/view/tabs.html'
            })
    });