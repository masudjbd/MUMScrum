<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<h1>Release Backlog List Page</h1>

<c:if test="${!empty message}">
    <div class="alert alert-success" role="alert">${message}</div>
</c:if> 

<sec:authorize access="hasAnyRole('ROLE_PRODUCT_OWNER')">   
    <a href="${pageContext.request.contextPath}/release-backlog/add" class="btn btn-info"><i class="icon icon-white icon-plus-sign"></i> Create Release Backlog </a>
</sec:authorize>

<table class="table table-striped">
    <thead>
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>create Date</th>   
            <th>Product Backlog</th> 
            <th>Action</th>
        </tr>
    </thead>
    <c:forEach var="rb" items="${rbList}" >
        <tr>
            <td>
                ${rb.id}

            </td>
            <td>
                ${rb.name} 

            </td>
            <td>
                ${rb.createDate} 
            </td>
            <td>
                ${rb.productBacklog.name} 
            </td>

            <td>
                <sec:authorize access="hasAnyRole('ROLE_PRODUCT_OWNER')">   
                    <div class="btn-group">
                        <a href="${pageContext.request.contextPath}/release-backlog/edit/${rb.id}" 
                           class="btn btn-info"><i class="icon icon-white icon-edit"></i> Edit</a>
                        <a href="${pageContext.request.contextPath}/release-backlog/delete/${rb.id}"
                           class="btn btn-danger"><i class="icon icon-white icon-trash"></i> Delete</a>

                    </div>
                </sec:authorize>
            </td>
        </tr>
    </c:forEach>
</table>

