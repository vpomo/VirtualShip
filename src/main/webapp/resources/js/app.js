var app = angular.module('app', [])
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

app.controller('squareController', function ($scope, $http, dataService) {
    $scope.square = createSquare();
    $scope.uncovercell = function(cell) {
        cell.isCovered = false;
    };

    $scope.load = function () {
        var promiseObj = dataService.getData();
        promiseObj.then(function (value) {
            $scope.actualSquare = value;
            console.log(value);
        });
        for(var i = 0; i < 30; i++) {
            for(var j = 0; j < 30; j++) {
                square.rows

                console.log("i=" + i + " j=" + j);
                console.log("i=" + i + " j=" + j + $value[i*30 + j*30].color);

                if (value[i*30 + j*30].color != "..") {
                    cell.isCovered = false;
                    cell.content = "full";
                    console.log("i=" + i + " j=" + j + value[i*30 + j*30].color);

                }
            }

            square.rows.push(row);
        }

    }

});




function createSquare() {
    var square = {};
    square.rows = [];
    
    for(var i = 0; i < 30; i++) {
        var row = {};
        row.cells = [];
        
        for(var j = 0; j < 30; j++) {
            var cell = {};
            cell.color = "..";
            row.cells.push(cell);
        }
        
        square.rows.push(row);
    }
   
    return square;
}

