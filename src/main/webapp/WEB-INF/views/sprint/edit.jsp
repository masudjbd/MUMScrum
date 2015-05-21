<%-- 
    Document   : edit
    Created on : May 17, 2015, 5:42:52 AM
    Author     : HabibRahman
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<h1>Edit Sprint</h1>


<form:form class="form-horizontal" commandName="sprint" method="post">

    <div class="control-group">
        <label class="control-label" for="name">Sprint Name</label>
        <div class="controls">
            <form:input type="text" path="sprintname" id="sprintName" placeholder="Name" />
            <form:errors path="sprintname" cssClass="error" />
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="createDate">Create Date</label>
        <div class="controls">
            <form:input type="text" path="createDate" id="createDate" placeholder="Create Date" class="datepicker"/>
            <form:errors path="createDate" cssClass="error" />
        </div>
    </div>
        <div class="control-group">
        <div class="controls">

            <button type="submit" class="btn btn-info">Save </button>
        </div>
    </div>
</form:form>