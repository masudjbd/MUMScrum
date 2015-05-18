<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h1>Employee List Page</h1>

<c:if test="${!empty message}">
    <div class="alert alert-success" role="alert">${message}</div>
</c:if>    

<a href="${pageContext.request.contextPath}/employee/add" class="btn btn-info"><i class="icon icon-white icon-plus-sign"></i> Create Employee </a>
<table class="table table-striped">
    <thead>
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Email</th>
            <th>Mobile</th>
            <th>Address</th>
            <th></th>
        </tr>
    </thead>
    <c:forEach var="employee" items="${employees}" >
        <tr>
            <td>
                ${employee.id}
            </td>
            <td>
                ${employee.firstname}  ${employee.lastname}
            </td>
            <td>
                ${employee.email}
            </td>
            <td>
                ${employee.mobile}
            </td>
            <td>
                ${employee.address}
            </td>
            <td>
                <div class="btn-group">
                    <a href="${pageContext.request.contextPath}/employee/edit/${employee.id}" 
                       class="btn btn-info"><i class="icon icon-white icon-edit"></i> Edit</a>
                    <a href="${pageContext.request.contextPath}/employee/delete/${employee.id}"
                       class="btn btn-danger"><i class="icon icon-white icon-trash"></i> Delete</a>

                </div>

            </td>
        </tr>
    </c:forEach>
</table>

