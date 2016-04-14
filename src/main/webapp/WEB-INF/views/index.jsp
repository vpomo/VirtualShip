<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

    <link rel="stylesheet" type="text/css"
          href="http://localhost:8080/${pageContext.request.contextPath}resources/css/styles.css">
    <link rel="stylesheet" type="text/css"
          href="http://localhost:8080/${pageContext.request.contextPath}resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css"
          href="http://localhost:8080/${pageContext.request.contextPath}resources/css/bootstrap-theme.min.css">

    <script src="http://localhost:8080/${pageContext.request.contextPath}resources/js/angular.min.js"
            type="text/javascript"></script>
    <script src="http://localhost:8080/${pageContext.request.contextPath}resources/js/jquery-2.1.1.js"
            type="text/javascript"></script>
    <script src="http://localhost:8080/${pageContext.request.contextPath}resources/js/bootstrap.min.js"
            type="text/javascript"></script>


</head>
<body>
<div class="container">
    <div ng-app="app" ng-controller="squareController">
        <h2 class="h2 page-header">Monitoring virtual ships</h2>

            <div class="col-sm-7 col-md-7 col-lg-7">
                <div class="panel panel-info">
                    <div class="panel-heading">Square</div>
                    <div class="panel-body">
                        <br>
                        <table class="square">
                            <tr ng-repeat="row in grid track by $index">
                                <td ng-repeat="cell in row track by $index" ng-click="uncovercell(cell)">
                                    <img ng-if="cell.color == 'mark_a'" src="http://localhost:8080/${pageContext.request.contextPath}resources/images/ff0000.png" />
                                    <img ng-if="cell.color == 'mark_d'" src="http://localhost:8080/${pageContext.request.contextPath}resources/images/ffff00.png" />
                                    <img ng-if="cell.color == 'mark_p'" src="http://localhost:8080/${pageContext.request.contextPath}resources/images/00cc00.png" />
                                    <img ng-if="cell.color == 'mark_ad'" src="http://localhost:8080/${pageContext.request.contextPath}resources/images/ffcc33.png" />
                                    <img ng-if="cell.color == 'mark_ap'" src="http://localhost:8080/${pageContext.request.contextPath}resources/images/33cccc.png" />
                                    <img ng-if="cell.color == 'mark_dp'" src="http://localhost:8080/${pageContext.request.contextPath}resources/images/cccc33.png" />
                                    <img ng-if="cell.color == 'ship_a'" src="http://localhost:8080/${pageContext.request.contextPath}resources/images/ff0000-ship.png" />
                                    <img ng-if="cell.color == 'ship_d'" src="http://localhost:8080/${pageContext.request.contextPath}resources/images/ffff00-ship.png" />
                                    <img ng-if="cell.color == 'ship_p'" src="http://localhost:8080/${pageContext.request.contextPath}resources/images/00cc00-ship.png" />
                                    <img ng-if="cell.color == '##'" src="http://localhost:8080/${pageContext.request.contextPath}resources/images/empty.png" />
                                    <img ng-if="cell.color == '..'" src="http://localhost:8080/${pageContext.request.contextPath}resources/images/covered.png" />
                                </td>
                            </tr>
                        </table>

                    </div>
                </div>
            </div>
            <div class="col-sm-5 col-md-5 col-lg-5">
                <div class="panel panel-danger">
                    <div class="panel-heading">Control virtual ships</div>
                    <div class="panel-body">
                        <h1>Enter the initial data for the model</h1>

                        <p><label for="numberShipTypeA">Number of ships of type A: </label><input id="numberShipTypeA" ng-model="numberShipTypeA"/></p>
                        <p><label for="numberShipTypeD">Number of ships of type D: </label><input id="numberShipTypeD" ng-model="numberShipTypeD"/></p>
                        <p><label for="numberShipTypeP">Number of ships of type P: </label><input id="numberShipTypeP" ng-model="numberShipTypeP"/></p>

                        <br>
                        <button type="button" class="btn btn-success" ng-click="initialSquare()">Clear Square</button>
                        <br>
                        <br>
                        <button type="button" class="btn btn-primary" ng-click="startMoving()">Start</button>
                        <br>
                        <br>
                        <button type="button" class="btn btn-primary" ng-click="stopMoving()">Stop</button>
                        <br>
                    </div>
                </div>
            </div>
        </div>

        <!--
        <div class="row">
            <h2 class="h2 page-header">Extracting data from JSON</h2>
            <table class="table table-striped">
                <tr>
                    <th>coordinate X</th>
                    <th>coordinate Y</th>
                    <th>color</th>
                </tr>
                <tr ng-repeat="mysquare in actualSquare">
                    <td>{{mysquare.coordinateX}}</td>
                    <td>{{mysquare.coordinateY}}</td>
                    <td>{{mysquare.color}}</td>
                </tr>
            </table>
        </div>
        -->

    </div>
</div>

<script src="http://localhost:8080/${pageContext.request.contextPath}resources/js/app.js"
        type="text/javascript"></script>

</body>
</html>