<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<h1>Edit Employee</h1>

<form:form class="form-horizontal" commandName="employee" method="post">

    <div class="control-group">
        <label class="control-label" for="inputName">Name</label>
        <div class="controls">
            <form:input type="text" path="Name" id="inputName" placeholder="Name" />
            <form:errors path="Name" cssClass="error" />
        </div>
    </div>


    <div class="control-group">
        <label class="control-label" for="inputEmail">Email</label>
        <div class="controls">
            <form:input type="text" path="Email" id="inputEmail" placeholder="Email" />
            <form:errors path="Email" cssClass="error" />

        </div>
    </div>


    <div class="control-group">
        <label class="control-label" for="inputMobile">Mobile</label>
        <div class="controls">
            <form:input type="text" path="mobile" id="inputMobile" placeholder="Mobile" />
        </div>
    </div>



    <div class="control-group">
        <label class="control-label" for="inputAddress">Address</label>
        <div class="controls">
            <form:input type="text" path="address" id="inputAddress"
                        placeholder="Address" />
        </div>
    </div>


    <div class="control-group">
        <div class="controls">

            <button type="submit" class="btn btn-info">Save </button>
        </div>
    </div>
</form:form>
