<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="mumscrum" tagdir="/WEB-INF/tags" %>



<h1>Add Employee</h1>

<form:form class="form-horizontal" commandName="employee" method="post">

 
    <div class="row">

        <div class="span5">

            <mumscrum:input label="Emloyee Code" name="empcode" />

            <mumscrum:input label="First Name" name="firstname" />

            <mumscrum:input label="Last Name" name="lastname" />

            <mumscrum:input label="Email" name="email" />

            <mumscrum:input label="Mobile" name="mobile" />


            <mumscrum:input label="Address" name="address" />
            <mumscrum:input label="SSN No" name="ssnNo" />





        </div>

        <div class="span5">

            <div class="control-group">
                <label class="control-label" for="inputdateOfJoin">DateOfJoin</label>
                <div class="controls">
                    <form:input readonly="readonly" class="datepicker" type="text" path="dateOfJoin" id="inputdateOfJoin"
                                placeholder="Date of Join" />
                    <form:errors path="dateOfJoin" cssClass="error" />

                </div>
            </div>


            <div class="control-group">
                <label class="control-label" for="inputbirthDate">Birth Date</label>
                <div class="controls">
                    <form:input readonly="readonly"  class="datepicker" type="text" path="birthDate" id="inputbirthDate"
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








        </div>  
        <div   class="span12">

            <fieldset>
                <legend>User Credential</legend>

                <div class="span5">

                    <div class="control-group">
                        <label class="control-label" for="username">Username</label>
                        <div class="controls">
                            <form:input type="text" path="username" id="username"
                                        placeholder="Username" />
                            <form:errors path="username" cssClass="error" />

                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="password">Password</label>
                        <div class="controls">
                            <form:input type="password" path="password" id="password"
                                        placeholder="password" />
                            <form:errors path="password" cssClass="error" />

                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">

                            <button type="submit" class="btn btn-info">Save </button>
                        </div>
                    </div>
                </div>
                <div class="span5">


                </div>

            </fieldset>  
        </div>
    </div>
</form:form>

