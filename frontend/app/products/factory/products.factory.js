module.exports = function ($resource) {
    return $resource("http://localhost:8080/products/:id", {}, {});
}