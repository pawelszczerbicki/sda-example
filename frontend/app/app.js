require("angular");
require("angular-resource");
require("angular-ui-router");
require("./products/controller/add.product.ctrl");
require("./products/controller/all.products.ctrl");
require("./products/controller/edit.product.ctrl");
require("./products/products.index");
var app = angular.module("SdaApp", [
    'ngResource',
    'ui.router',
    'SdaApp.Products'

])
    .config(function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise("/products");

        $stateProvider
            .state("app", {
                abstract: true,
                url: '',
                templateUrl: 'app/view/tabs.html'
            })
    });