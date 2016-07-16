app.controller("AddProductCtrl", function (Product, $state) {

    this.product = new Product();
    this.addProduct = function () {
        this.product.$save().then(function () {
            $state.go("app.products");
        });
    };
});