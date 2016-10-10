<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
</head>

<body ng-app="MentorApp">
    <div class="container" ng-controller="userCtrl">
        <c:import url="./partials/header.jsp"></c:import>
        <h5>Users</h5>
        <ul class="collapsible" data-collapsible="accordion" watch>
            <li>
                <div class="collapsible-header teal white-text active">Add new user</div>
                <div class="collapsible-body">
                    <div class="container">
                        <ng-form name="newItemForm">
                            <div class="input-field">
                                <input type="text" ng-model="newItem.name" required>
                                <label>Name</label>
                            </div>
                            <div class="input-field">
                                <input type="email" ng-model="newItem.email" required>
                                <label>Email</label>
                            </div>
                            <div>
                                <label for="birthDate">Birth date</label>
                                <input input-date
                                    type="text"
                                    name="birthDate"
                                    ng-model="newItem.birthDate"
                                    format="<spring:eval expression='@environment.getProperty("jamp.pattern.date").toLowerCase()' />" required/>
                            </div>
                            <label for="level">Level</label>
                            <div input-field>
                                <select class="" ng-model="newItem.level" name="level" material-select watch required>
                                    <option ng-repeat="level in levels">{{level}}</option>
                                </select>
                            </div>
                            <label for="primarySkill">Primary skill</label>
                            <div input-field>
                                <select class="" ng-model="newItem.primarySkill" name="primarySkill" material-select watch required>
                                    <option ng-repeat="skill in primarySkills">{{skill}}</option>
                                </select>
                            </div>
                            <div class="row">
                                <div class="col s4">
                                    <input type="submit" ng-click="createUser()" value="Create" class="btn"/>
                                </div>
                                <div class="col s4">
                                    <p class="red-text">{{errorMessage}}</p>
                                </div>
                            </div>
                        </ng-form>
                    </div>
                </div>
            </li>
            <li ng-repeat="user in users track by user.id">
                <div class="collapsible-header">
                    <span>{{user.name}} ({{user.email}})</span>
                    <div class="secondary-content">
                        <input type="checkbox" id="editMode{{$index}}" ng-model="editMode[$index]" />
                        <label for="editMode{{$index}}" class="edit-label">Edit</label>
                        <a class="btn-flat delete-button" ng-click="deleteUser(user)"><i class="material-icons">delete</i></a>
                    </div>
                </div>
                <div class="collapsible-body">
                    <div class="container">
                        <ng-form name="editForm" ng-show="editMode[$index]">
                            <input type="hidden" value="{{user.id}}"/>
                            <div class="input-field">
                                <input type="text" ng-model="user.name" required>
                                <label>Name</label>
                            </div>
                            <div class="input-field">
                                <input type="email" ng-model="user.email" required>
                                <label>Email</label>
                            </div>
                            <div>
                                <label for="birthDate">Birth date</label>
                                <input input-date
                                    type="text"
                                    name="startDate"
                                    ng-model="user.birthDate"
                                    format="<spring:eval expression='@environment.getProperty("jamp.pattern.date").toLowerCase()' />" required/>
                            </div>
                            <label for="level">Level</label>
                            <div input-field>
                                <select class="" ng-model="user.level" name="level" material-select watch required>
                                    <option ng-repeat="level in levels">{{level}}</option>
                                </select>
                            </div>
                            <label for="primarySkill">Primary skill</label>
                            <div input-field>
                                <select class="" ng-model="user.primarySkill" name="primarySkill" material-select watch required>
                                    <option ng-repeat="skill in primarySkills">{{skill}}</option>
                                </select>
                            </div>

                            <div class="row">
                                <div class="col s4">
                                    <input type="submit" ng-click="updateUser(editForm, user, $index)" value="Save changes" class="btn"/>
                                </div>
                                <div class="col s4">
                                    <p class="red-text">{{editErrorMessages[$index]}}</p>
                                </div>
                            </div>
                        </ng-form>
                        <ul class="collection" ng-hide="editMode[$index]">
                            <li class="collection-item">Birth date: <span class="teal-text text-lighten-2 class">{{user.birthDate}}</span></li>
                            <li class="collection-item">Level: <span class="teal-text text-lighten-2 class">{{user.level}}</span></li>
                            <li class="collection-item">Primary skill: <span class="teal-text text-lighten-2 class">{{user.primarySkill}}</span></li>
                            <li class="collection-item">Created by: <span class="teal-text text-lighten-2 class">{{user.createdBy}}</span> at <span class="teal-text text-lighten-2 class">{{user.created}}</span></li>
                            <li class="collection-item" ng-show="user.lastModified">Last modified by: <span class="teal-text text-lighten-2 class">{{user.lastModifiedBy}}</span> at <span class="teal-text text-lighten-2 class">{{user.lastModified}}</span></li>
                        </ul>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</body>

</html>