var app = angular.module('app', []);
app.factory('dataService', function ($http, $q) {
    return {
        getData: function () {
            var deferred = $q.defer();
            //$http({method: 'GET', url: 'http://localhost:8080/restful/getall/'}).
            $http({method: 'GET', url: getContextPath() + '/restful/getall/'}).
            success(function (data, status, headers, config) {
                deferred.resolve(data);
            })
            .error(function (data, status, headers, config) {
                deferred.reject(status);
            });
            return deferred.promise;
        }
    }
});

app.controller('squareController', function ($scope, $http, $interval, dataService) {
    $scope.grid = createSquare(40,40);
    $scope.flagStarting = false;

    $scope.uncovercell = function(cell) {
        cell.color = "==";
    };
    $scope.numberShipTypeA = 0;
    $scope.numberShipTypeD = 0;
    $scope.numberShipTypeP = 0;
    $scope.errorMessage = "";


    $interval( function(){ $scope.load(); }, 200);

    $scope.load = function () {
        var promiseObj = dataService.getData();
        promiseObj.then(function (value) {
            $scope.actualSquare = value;
            for(var i = 0; i < 40; i++) {
                for(var j = 0; j < 40; j++) {
                    $scope.grid[i][j].color = value[i*40 + j].color;
                }
            }
        });
    }

    $scope.startMoving = function () {
        numberShip = {
            numberShipTypeA: $scope.numberShipTypeA,
            numberShipTypeD: $scope.numberShipTypeD,
            numberShipTypeP: $scope.numberShipTypeP
        }
        if (!$scope.testNumberShip()) {
            var request = {
                method: 'POST',
                //url: 'http://localhost:8080/restful/start',
                url: getContextPath() + '/restful/start',
                headers: {'Content-Type': 'application/json; charset: UTF-8'},
                data: angular.toJson(numberShip)
            }
            $http(request).success(function (data) {
                    data = angular.toJson(numberShip);
                })
                .error(function (data, status, headers, config) {
                    //  Do some error handling here
                });
        }
    }

    $scope.testNumberShip = function () {
        var isError = false;

        if (($scope.numberShipTypeA == 0) && ($scope.numberShipTypeD == 0) && ($scope.numberShipTypeP == 0)) {
            $scope.errorMessage = "specify the value of the number of ships of at least one type, not more than 6";
            isError = true;
        }
        if ((isNaN(parseInt($scope.numberShipTypeA, 10))) || (isNaN(parseInt($scope.numberShipTypeD, 10))) || (isNaN(parseInt($scope.numberShipTypeP, 10)))) {
            $scope.errorMessage = "value must be a number";
            isError = true;
        }
        if (($scope.numberShipTypeA > 6) || ($scope.numberShipTypeD > 6) || ($scope.numberShipTypeP > 6)) {
            $scope.errorMessage = "value of the number of ships can not be more than 6";
            isError = true;
        }
        if (($scope.numberShipTypeA < 0) || ($scope.numberShipTypeD < 0) || ($scope.numberShipTypeP < 0)) {
            $scope.errorMessage = "value of the number of ships can not be less than 0";
            isError = true;
        }
        return isError;
    }

    $scope.stopMoving = function () {
        $scope.flagStarting = false;
        var request = {
            method: 'POST',
            //url: 'http://localhost:8080/restful/stop',
            url: getContextPath + '/restful/stop',
            headers: {'Content-Type': 'application/json; charset: UTF-8'},
            data: $scope.flagStarting
        }

        $http(request).success(function (data) {
            data = $scope.flagStarting;
        })
        .error(function (data, status, headers, config) {
            //  
        });
    }

    $scope.initialSquare = function () {
        var request = {
            method: 'POST',
            //url: 'http://localhost:8080/restful/clear',
            url: getContextPath() + '/restful/clear',
            headers: {'Content-Type': 'application/json; charset: UTF-8'},
            data: $scope.flagStarting
        }

        $http(request).success(function (data) {
                data = $scope.flagStarting;
            })
            .error(function (data, status, headers, config) {
                //  Do some error handling here
            });
    }

});

function createSquare(width, height) {
    var grid = [], row, x, y;
    for (y = 0; y < height; y++) {
        row = [];
        for (x = 0; x < width; x++) {
            row.push({
                color: ".."
            });
        }
        grid.push(row);
    }
    return grid;
}
function getContextPath() {
    return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
}
