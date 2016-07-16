module.exports = angular.module("SdaApp.Products",[])
    .config(function ($stateProvider) {
    $stateProvider.state("app.products", {
        url: '/products',
        templateUrl: "app/products/view/products.html",
        controller: "ProductsCtrl",
        controllerAs: "ctrl"
    })
        .state("app.addProducts", {
            url: '/products/add',
            templateUrl: "app/products/view/add.products.html",
            controller: "AddProductCtrl",
            controllerAs: "ctrl"
        })
        .state("app.editProducts", {
            url: '/products/:id',
            templateUrl: "app/products/view/edit.products.html",
            controller: "EditProductCtrl",
            controllerAs: "ctrl"
        });
})
    .controller("ProductsCtrl", require("./controller/all.products.ctrl"))
    .controller("AddProductCtrl", require("./controller/add.product.ctrl"))
    .controller("EditProductCtrl", require("./controller/edit.product.ctrl"))
    .factory("Product", require("./factory/products.factory"));