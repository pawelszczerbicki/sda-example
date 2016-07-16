module.exports = function (Product, $state) {
    this.product = new Product();
    this.addProduct = function () {
        this.product.$save().then(function () {
                $state.go("app.products");
            },
            function (err) {

            });
    };
};