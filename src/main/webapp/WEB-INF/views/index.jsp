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
    <link rel="stylesheet" type="text/css"
          href="http://localhost:8080/${pageContext.request.contextPath}resources/css/bootstrap-datetimepicker.min.css">

    <script src="http://localhost:8080/${pageContext.request.contextPath}resources/js/bootstrap.min.js"
            type="text/javascript"></script>
    <script src="http://localhost:8080/${pageContext.request.contextPath}resources/js/jquery-2.1.1.js"
            type="text/javascript"></script>
    <script src="http://localhost:8080/${pageContext.request.contextPath}resources/js/moment-with-locales.min.js"
            type="text/javascript"></script>
    <script src="http://localhost:8080/${pageContext.request.contextPath}resources/js/bootstrap-datetimepicker.min.js"
            type="text/javascript"></script>


</head>
<body>
<div class="container">
    <div ng-app="app" ng-controller="squareController">
        <br><br>
        <table class="square">
            <tr ng-repeat="row in square.rows">
                <td ng-repeat="cell in row.cells" ng-click="uncovercell(cell)">
                    <img ng-if="cell.color == '..'" src="http://localhost:8080/${pageContext.request.contextPath}resources/images/covered.png" />
                    <img ng-if="cell.color != '..'" src="http://localhost:8080/${pageContext.request.contextPath}resources/images/empty.png" />
                </td>
            </tr>
        </table>
        <br>
           <button type="button" class="btn btn-success" ng-click="load()">Get Square</button>
        <br>
        <h2>Пример извлечения данных JSON в Angular.js</h2 >
        <table class="table table-striped">
            <tr>
                <th>X</th>
                <th>Y</th>
                <th>color</th>
            </tr>
            <tr ng-repeat="mysquare in actualSquare">
                <td>{{mysquare.coordinateX}}</td>
                <td>{{mysquare.coordinateY}}</td>
                <td>{{mysquare.color}}</td>
            </tr>
        </table>

    </div>
</div>

<script src="http://localhost:8080/${pageContext.request.contextPath}resources/js/angular.min.js"
        type="text/javascript"></script>
<script src="http://localhost:8080/${pageContext.request.contextPath}resources/js/app.js"
        type="text/javascript"></script>

</body>
</html>