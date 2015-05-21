<%-- 
    Document   : list
    Created on : May 18, 2015, 4:19:04 AM
    Author     : Rhyhan
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h1>Employee Leave List </h1>

<c:if test="${!empty message}">
    <div class="alert alert-success" role="alert">${message}</div>
</c:if>    

<a href="${pageContext.request.contextPath}/leave/add" class="btn btn-info"><i class="icon icon-white icon-plus-sign"></i> Create Employee Leave </a>
<table class="table table-striped">
    <thead>
        <tr>
            <th>Employee Name</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Leave Type</th>
            <th>Available Leave</th>
            <th>Action</th>
            <th></th>
        </tr>
    </thead>
    <c:forEach var="empvac" items="${empvac}" >
        <tr>

            <td>
                ${empvac.employee.firstname} ${empvac.employee.lastname} 
            </td>
            <td>
                ${empvac.startdate}
            </td>
            <td>
                ${empvac.enddate}
            </td>
            <td>
                ${empvac.leavetype.typename}
            </td>
            <td>
                ${empvac.availabeleave}
            </td>
            <td>
               <div class="btn-group pull-left">
                    <button type="button" class="btn btn-info btn-xs dropdown-toggle" data-toggle="dropdown">
                        <i class="glyphicon glyphicon-fire"></i> Actions <span class="caret"></span>
                    </button>     
                    <ul class="dropdown-menu" role="menu">

                       
                        <li>
                            <a  href="${pageContext.request.contextPath}/leave/edit/${empvac.leaveId}" 
                               ><i class="icon icon-blue icon-edit"></i> Edit</a>
                        </li>
                        <li>                            
                            <a href="${pageContext.request.contextPath}/leave/delete/${empvac.leaveId}"
                               ><i class="icon icon-red icon-trash"></i> Delete</a>
                        </li>
                    </ul>
                </div>
            </td>
        </tr>
    </c:forEach>
</table>

