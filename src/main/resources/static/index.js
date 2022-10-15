angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                $scope.ProductsList = response.data;
            });
    };
/*

    $scope.addProduct = function (ID,title,cost) {
        $http.get(contextPath + '/products/addProduct', $scope.newProduct)
            .then(function (response) {
                $scope.ProductsList = response.data;
            });
    }
//доделать добавление по логике удаления через js
*/


    $scope.deleteProduct = function (productId) {
        $http.get(contextPath + '/products/delete/' + productId)
            .then(function (response) {
                $scope.loadProducts();
            });
    }

    $scope.loadProducts();
});