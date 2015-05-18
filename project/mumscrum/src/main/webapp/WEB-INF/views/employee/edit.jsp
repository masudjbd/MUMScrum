<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<h1>Edit Employee</h1>


<form:form class="form-horizontal" commandName="employee" method="post">

    <div class="control-group">
        <label class="control-label" for="inputEmpCode">Employee Code</label>
        <div class="controls">
            <form:input type="text" path="empcode" id="inputEmpCode" placeholder="Employee Code" />
            <form:errors path="empcode" cssClass="error" />
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="inputFName">First Name</label>
        <div class="controls">
            <form:input type="text" path="firstname" id="inputFName" placeholder="First Name" />
            <form:errors path="firstname" cssClass="error" />
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="inputLName">Last Name</label>
        <div class="controls">
            <form:input type="text" path="lastname" id="inputLName" placeholder="Last Name" />
            <form:errors path="lastname" cssClass="error" />
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="inputEmail">Email</label>
        <div class="controls">
            <form:input type="text" path="email" id="inputEmail" placeholder="Email" />
            <form:errors path="email" cssClass="error" />

        </div>
    </div>


    <div class="control-group">
        <label class="control-label" for="inputMobile">Mobile</label>
        <div class="controls">
            <form:input type="text" path="mobile" id="inputMobile" placeholder="Mobile" />
            <form:errors path="mobile" cssClass="error" />

        </div>
    </div>



    <div class="control-group">
        <label class="control-label" for="inputAddress">Address</label>
        <div class="controls">
            <form:input type="text" path="address" id="inputAddress"
                        placeholder="Address" />
            <form:errors path="address" cssClass="error" />

        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="inputdateOfJoin">DateOfJoin</label>
        <div class="controls">
            <form:input class="datepicker" type="text" path="dateOfJoin" id="inputdateOfJoin"
                        placeholder="Date of Join" />
            <form:errors path="dateOfJoin" cssClass="error" />

        </div>
    </div>


    <div class="control-group">
        <label class="control-label" for="inputbirthDate">Birth Date</label>
        <div class="controls">
            <form:input  class="datepicker" type="text" path="birthDate" id="inputbirthDate"
                        placeholder="Birth Date" />
            <form:errors path="birthDate" cssClass="error" />

        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="inputgender">Gender</label>
        <div class="controls">
            <form:select path="gender">
                <option value="M">Male</option>
                <option value="F">Female</option>
            </form:select>
            <form:errors path="gender" cssClass="error" />

        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="inputSalary">salary</label>
        <div class="controls">
            <form:input type="text" path="salary" id="inputSalary"
                        placeholder="0.00" />
            <form:errors path="salary" cssClass="error" />

        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="inputDepartment">Department</label>
        <div class="controls">
            <form:input type="text" path="department" id="inputDepartment"
                        placeholder="Department" />
            <form:errors path="department" cssClass="error" />

        </div>
    </div>


    <div class="control-group">
        <label class="control-label" for="inputDesignation">Designation</label>
        <div class="controls">
            <form:input type="text" path="designation" id="inputDesignation"
                        placeholder="designation" />
            <form:errors path="designation" cssClass="error" />

        </div>
    </div>


    <div class="control-group">
        <label class="control-label" for="inputssnNo">SSN No</label>
        <div class="controls">
            <form:input type="text" path="ssnNo" id="inputssnNo"
                        placeholder="SSN" />
            <form:errors path="ssnNo" cssClass="error" />

        </div>
    </div>

    <div class="control-group">
        <div class="controls">

            <button type="submit" class="btn btn-info">Save </button>
        </div>
    </div>
</form:form>

