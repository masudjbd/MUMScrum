<%-- 
    Document   : list
    Created on : May 18, 2015, 4:19:04 AM
    Author     : Rhyhan
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h1>Employee Insurance List </h1>

<c:if test="${!empty message}">
    <div class="alert alert-success" role="alert">${message}</div>
</c:if>    

<a href="${pageContext.request.contextPath}/insurance/add" class="btn btn-info"><i class="icon icon-white icon-plus-sign"></i> Create Employee Insurance </a>
<table class="table table-striped">
    <thead>
        <tr>
            <th>Employee Name</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Insurance Type</th>
            <th>Company Name</th>
            <th>Pay Amount</th>
            <th>Action</th>
            <th></th>
        </tr>
    </thead>
    <c:forEach var="insurance" items="${insurance}" >
        <tr>

            <td>
                ${insurance.employee.firstname} ${insurance.employee.lastname} 
            </td>
            <td>
                ${insurance.startdate}
            </td>
            <td>
                ${insurance.enddate}
            </td>
            <td>
                ${insurance.insurancetype.typeName}
            </td>
            <td>
                ${insurance.insurancetype.companyName}
            </td>
            <td>
                ${insurance.payAmount}
            </td>
            <td>
               <div class="btn-group pull-left">
                    <button type="button" class="btn btn-info btn-xs dropdown-toggle" data-toggle="dropdown">
                        <i class="glyphicon glyphicon-fire"></i> Actions <span class="caret"></span>
                    </button>     
                    <ul class="dropdown-menu" role="menu">

                      
                        <li>
                            <a href="${pageContext.request.contextPath}/insurance/edit/${insurance.inId}" 
                               ><i class="icon icon-blue icon-edit"></i> Edit</a>
                        </li>
                        <li>                            
                            <a href="${pageContext.request.contextPath}/insurance/delete/${insurance.inId}"
                               ><i class="icon icon-red icon-trash"></i> Delete</a>
                        </li>
                    </ul>
                </div>
            </td>
        </tr>
    </c:forEach>
</table>

