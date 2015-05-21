<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<h1>User Story List Page</h1>

<c:if test="${!empty message}">
    <div class="alert alert-success" role="alert">${message}</div>
</c:if>    
    
<sec:authorize access="hasAnyRole( 'ROLE_PRODUCT_OWNER')">   
    <a href="${pageContext.request.contextPath}/user-story/add" class="btn btn-info"><i class="icon icon-white icon-plus-sign"></i> Create User Story </a>
</sec:authorize>

<table class="table table-striped">
    <thead>
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Description</th>
            <th>create Date</th>
            <th>Product Backlog</th>
            <th>Action</th>
        </tr>
    </thead>
    <c:forEach var="userstory" items="${storyList}" >
        <tr>
            <td>
                ${userstory.id}

            </td>
            <td>
                ${userstory.name} 

            </td>
            <td>
                ${userstory.description} 
            </td>
            <td>
                ${userstory.createDate} 
            </td>
            <td>
                ${userstory.productBacklog.name}
            </td>

            <td>
                <div class="btn-group">
                    <a href="${pageContext.request.contextPath}/user-story/edit/${userstory.id}" 
                       class="btn btn-info"><i class="icon icon-white icon-edit"></i> Edit</a>
                    <a href="${pageContext.request.contextPath}/user-story/delete/${userstory.id}"
                       class="btn btn-danger"><i class="icon icon-white icon-trash"></i> Delete</a>

                </div>

            </td>
        </tr>
    </c:forEach>
</table>

