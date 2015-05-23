<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<h1>Sprint List Page</h1>

<c:if test="${!empty message}">
    <div class="alert alert-success" role="alert">${message}</div>
</c:if>    

<sec:authorize access="hasAnyRole( 'ROLE_SCRUM_MASTER')">   
    <a href="${pageContext.request.contextPath}/sprint/add" class="btn btn-info"><i class="icon icon-white icon-plus-sign"></i> Create Sprint </a>
</sec:authorize>
 
<table class="table table-striped">
    <thead>
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>create Date</th> 
            <th>Release Backlog</th> 
            <th>Action</th>
        </tr>
    </thead>
    <c:forEach var="sprint" items="${sprintList}" >
        <tr>
            <td>
                ${sprint.id}

            </td>
            <td>
                ${sprint.sprintname} 

            </td>
            <td>
                ${sprint.createDate} 
            </td>
            <td>
                ${sprint.releaseBacklog.name}
            </td>

            <td>
                <sec:authorize access="hasAnyRole('ROLE_SCRUM_MASTER')">   
                <div class="btn-group">
                    <a href="${pageContext.request.contextPath}/sprint/edit/${sprint.id}" 
                       class="btn btn-info"><i class="icon icon-white icon-edit"></i> Edit</a>
                    <a href="${pageContext.request.contextPath}/sprint/delete/${sprint.id}"
                       class="btn btn-danger"><i class="icon icon-white icon-trash"></i> Delete</a>

                </div>
                </sec:authorize>
            </td>
        </tr>
    </c:forEach>
</table>

