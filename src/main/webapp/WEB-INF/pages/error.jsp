<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
</head>

<body ng-app="MentorApp">
    <div class="container" ng-controller="programCtrl">
        <c:import url="./partials/header.jsp"></c:import>
        <h5>Error ${code}</h5>
        <p>${errorMessage}</p>
    </div>
</body>
</html>
