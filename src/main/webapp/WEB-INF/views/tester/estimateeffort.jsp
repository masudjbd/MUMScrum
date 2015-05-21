<%-- 
    Document   : estimate development effort
    Created on : 19-May-2015, 14:01:43
    Author     : Masudur Rahman <masud.java@gmail.com>
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="mumscrum" tagdir="/WEB-INF/tags" %>



<h1>Estimate Testing Effort</h1>


<form:form class="form-horizontal" commandName="userStory" method="post">

    <div class="control-group">
        <label class="control-label" for="name">User Story</label>
        <div class="controls">
            <span class="label label-info"> ${userStory.name} </span>

             <input type="hidden" value="${userStory.id}" name="id" />

        </div>
    </div>

    <mumscrum:input label="Estimate Test. Time : hour(s)" name="testerEstimateTime" />    
 

    <div class="control-group">
        <div class="controls">
            <button type="submit" class="btn btn-info">Save </button>
        </div>
    </div>
    
</form:form>            