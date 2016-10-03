<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
</head>

<body ng-app="MentorApp">
    <div class="container" ng-controller="programCtrl">
        <c:import url="./partials/header.jsp"></c:import>
        <h5>Programs</h5>
        <ul class="collapsible" data-collapsible="accordion" watch>
            <li>
                <div class="collapsible-header teal white-text active">Add new mentorship program</div>
                <div class="collapsible-body">
                    <div class="container">
                        <ng-form name="newItemForm">
                            <div class="input-field">
                                <input type="text" ng-model="newItem.name" required>
                                <label>Name</label>
                            </div>
                            <div class="input-field">
                                <input type="text" ng-model="newItem.officeLocation" required>
                                <label>Office location</label>
                            </div>
                            <div>
                                <label for="startDate">Start date</label>
                                <input input-date
                                    type="text"
                                    name="startDate"
                                    ng-model="newItem.startDate"
                                    format="<spring:eval expression='@environment.getProperty("jamp.pattern.date").toLowerCase()' />" required/>
                            </div>
                            <div>
                                <label for="end">End date</label>
                                <input input-date
                                    type="text"
                                    name="endDate"
                                    ng-model="newItem.endDate"
                                    format="<spring:eval expression='@environment.getProperty("jamp.pattern.date").toLowerCase()' />" required/>
                            </div>
                            <div class="row">
                                <div class="col s4">
                                    <input type="submit" ng-click="createProgram()" value="Create" class="btn"/>
                                </div>
                                <div class="col s4">
                                    <p class="red-text">{{errorMessage}}</p>
                                </div>
                            </div>
                        </ng-form>
                    </div>
                </div>
            </li>
            <li ng-repeat="program in programs track by program.id">
                <div class="collapsible-header">
                    <span>{{program.name}}</span>
                    <div class="secondary-content">
                        <input type="checkbox" id="editMode{{$index}}" ng-model="editMode[$index]" />
                        <label for="editMode{{$index}}" class="edit-label">Edit</label>
                        <a class="btn-flat delete-button" ng-click="deleteProgram(program)"><i class="material-icons">delete</i></a>
                    </div>
                </div>
                <div class="collapsible-body">
                    <div class="container">
                        <ng-form name="editForm" ng-show="editMode[$index]">
                            <input type="hidden" value="{{program.id}}"/>
                            <div class="input-field">
                                <input type="text" ng-model="program.name" required>
                                <label>Name</label>
                            </div>
                            <div class="input-field">
                                <input type="text" ng-model="program.officeLocation" required>
                                <label>Office location</label>
                            </div>
                            <div>
                                <label for="startDate">Start date</label>
                                <input input-date
                                    type="text"
                                    name="startDate"
                                    ng-model="program.startDate"
                                    format="<spring:eval expression='@environment.getProperty("jamp.pattern.date").toLowerCase()' />" required/>
                            </div>
                            <div>
                                <label for="end">End date</label>
                                <input input-date
                                    type="text"
                                    name="endDate"
                                    ng-model="program.endDate"
                                    format="<spring:eval expression='@environment.getProperty("jamp.pattern.date").toLowerCase()' />" required/>
                            </div>
                            <div class="row">
                                <div class="col s4">
                                    <input type="submit" ng-click="updateProgram(editForm, program, $index)" value="Save changes" class="btn"/>
                                </div>
                                <div class="col s4">
                                    <p class="red-text">{{editErrorMessages[$index]}}</p>
                                </div>
                            </div>
                        </ng-form>
                        <ul class="collection" ng-hide="editMode[$index]">
                            <li class="collection-item">Location: <span class="teal-text text-lighten-2 class">{{program.officeLocation}}</span></li>
                            <li class="collection-item">Start date: <span class="teal-text text-lighten-2 class">{{program.startDate}}</span></li>
                            <li class="collection-item">End date: <span class="teal-text text-lighten-2 class">{{program.endDate}}</span></li>
                        </ul>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</body>

</html>