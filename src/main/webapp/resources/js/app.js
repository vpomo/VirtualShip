var app = angular.module('app', []);
app.factory('dataService', function ($http, $q) {
    return {
        getData: function () {
            var deferred = $q.defer();
            $http({method: 'GET', url: 'http://localhost:8080/restful/getall/'}).
            success(function (data, status, headers, config) {
                deferred.resolve(data);
            }).
            error(function (data, status, headers, config) {
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

    $interval( function(){ $scope.load(); }, 1000);

    $scope.load = function () {
        var promiseObj = dataService.getData();
        promiseObj.then(function (value) {
            $scope.actualSquare = value;
            console.log($scope.grid[1][1].color);
            for(var i = 0; i < 40; i++) {
                for(var j = 0; j < 40; j++) {
                    $scope.grid[i][j].color = value[i*40 + j].color;
                }
            }
        });
    }

    $scope.startMoving = function () {
        $scope.clearSquare(40,40);
        $scope.numberShip = {
            numberShipTypeA: $scope.numberShipTypeA,
            numberShipTypeD: $scope.numberShipTypeD,
            numberShipTypeP: $scope.numberShipTypeP
        }

        var request = {
            method: 'POST',
            url: 'http://localhost:8080/restful/start',
            headers: {'Content-Type': 'application/json; charset: UTF-8'},
            data: angular.toJson($scope.numberShip)
        }
        console.log("$scope.numberShipTypeA=" + $scope.numberShipTypeA);
        $http(request).success(function (data) {
            console.log("$scope.numberShip=" + $scope.numberShip);
            data = angular.toJson($scope.numberShip);
        })
        .error(function (data, status, headers, config) {
                //  Do some error handling here
        });

    }

    $scope.stopMoving = function () {
        $scope.flagStarting = false;
        var request = {
            method: 'POST',
            url: 'http://localhost:8080/restful/stop',
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

    $scope.clearSquare = function (width, height) {
        for(var i = 0; i < height; i++) {
            for(var j = 0; j < width; j++) {
                $scope.grid[i][j].color = "..";
            }
        }
    }
    
    $scope.update = function () {
        $timeout(update, 1000);
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

