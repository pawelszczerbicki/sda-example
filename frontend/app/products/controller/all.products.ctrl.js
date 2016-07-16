module.exports = function (Product) {
    var ctrl = this;

    this.pagination = {page: 0, size: 3};

    function getProducts() {
        ctrl.products = Product.query(ctrl.pagination);
    }

    getProducts();

    this.isFirstPage = function () {
        return this.pagination < 1;
    };

    this.nextPage = function () {
        this.pagination.page++;
        getProducts();
    };

    this.previousPage = function () {
        this.pagination.page--;
        getProducts();
    }
}