<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<h1>Add Leave</h1>

<form:form class="form-horizontal" commandName="empvac" method="post">

    <div class="row">

        <div class="span5">

            <div class="control-group">
                <label class="control-label" for="inputEmployeeId">Employee Name</label>
                <div class="controls">

                    <form:select id="userSelect" name="userId" path="employee.id">
                        <c:forEach var="employee" items="${employees}">
                            <form:option value="${employee.id}"><c:out value="${employee.firstname} ${employee.lastname}"/></form:option>
                        </c:forEach>
                    </form:select>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="inputStatDate">Start Date</label>
                <div class="controls">
                    <form:input type="text" class="datepicker" path="startdate" id="inputStartDate" placeholder="Start Date" />
                    <form:errors path="startdate" cssClass="error" />
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="endDate">End Date</label>
                <div class="controls">
                    <form:input type="text" class="datepicker" path="enddate" id="endDate" placeholder="End Date" />
                    <form:errors path="enddate" cssClass="error" />
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="inputleaveId">Leave Type</label>
                <div class="controls">

                    <form:select class="form-control"  path="leavetype.id">
                        <form:options itemLabel="typename" itemValue="id" items="${leavetypes}"></form:options>
                    </form:select>

                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="inputtotalLeave">Total Leave</label>
                <div class="controls">
                    <form:input type="text" path="availabeleave" id="inputtotalLeave"
                                placeholder="0" />
                    <form:errors path="availabeleave" cssClass="error" />
                </div>
            </div>


            <div class="control-group">
                <div class="controls">

                    <button type="submit" class="btn btn-info">Generate </button>
                </div>
            </div>
        </div>

    </div>  

</div>
</form:form>

