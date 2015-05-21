<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h1>Add User Story</h1>

<form:form class="form-horizontal" commandName="userstory" method="post">
    <div class="row">
        <div class="span5">


            <div class="control-group">
                <label class="control-label" for="name">Select Product Backlog</label>
                <div class="controls">
                    <form:select class="form-control"  path="productBacklog.id">
                        <form:options itemLabel="name" itemValue="id" items="${productbacklogs}"></form:options>
                    </form:select>
                    <form:errors path="productBacklog" cssClass="error" />
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="userStoryName">User Story Name</label>
                <div class="controls">
                    <form:input type="text" path="name" id="name" placeholder="Name" />
                    <form:errors path="name" cssClass="error" />
                </div>
            </div>                
                
            <div class="control-group">
                <label class="control-label" for="description">Description</label>
                <div class="controls">
                    <form:textarea type="text" path="description" id="description" placeholder="description" />
                    <form:errors path="description" cssClass="error" />
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
        </div>
    </div>
</form:form>