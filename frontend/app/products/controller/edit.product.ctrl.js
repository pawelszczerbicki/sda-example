app.controller("EditProductCtrl", function (Product, $stateParams, $state) {

    this.getOneProduct = function () {
        this.fetched = Product.get({id: $stateParams.id});
    };

    this.editProduct = function () {
        this.fetched.$save().then(function () {
            $state.go("app.products");
        });
    };
});