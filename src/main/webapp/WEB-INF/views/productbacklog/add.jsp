<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h1>Add Product Backlog</h1>

<form:form class="form-horizontal" commandName="productbacklog" method="post">
    <div class="row">
        <div class="span5">
            <div class="control-group">
                <label class="control-label" for="name">Name</label>
                <div class="controls">
                    <form:input type="text" path="name" id="name" placeholder="Name" />
                    <form:errors path="name" cssClass="error" />
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