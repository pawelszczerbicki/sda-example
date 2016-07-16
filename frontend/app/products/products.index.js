app.config(function ($stateProvider) {
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
}) ;