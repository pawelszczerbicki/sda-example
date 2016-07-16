module.exports = function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("/products");

    $stateProvider
        .state("app", {
            abstract: true,
            url: '',
            templateUrl: 'app/view/tabs.html'
        })
}