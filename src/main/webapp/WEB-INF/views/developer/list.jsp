<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h1>User Story - List</h1>

<c:if test="${!empty message}">
    <div class="alert alert-success" role="alert">${message}</div>
</c:if>    

<table class="table table-striped">
    <thead>
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Estimated Development Time</th>
            <th>create Date</th>
            <th>Product Backlog</th>
            <th>Action</th>
        </tr>
    </thead>
    <c:forEach var="userstory" items="${userstories}" >
        <tr>
            <td>
                ${userstory.id}

            </td>
            <td>
                ${userstory.name} 

            </td>
            <td align="center">

                <c:choose>
                    <c:when test="${userstory.developerEstimateTime > 0}"> 
                        <span class="badge badge-success"> ${userstory.developerEstimateTime} </span> 
                        <span class="badge badge-info">hour(s)</span>
                    </c:when>

                    <c:otherwise>
                        <span class="badge"> ${userstory.developerEstimateTime} </span>  
                        <span class="badge badge-info">hour(s)</span>

                    </c:otherwise>
                </c:choose>


            </td>
            <td>
                ${userstory.createDate} 
            </td>
            <td>
                ${userstory.productBacklog.name}
            </td>

            <td>
                <div class="btn-group">
                    <a href="${pageContext.request.contextPath}/developer/estimate-development-effort/${userstory.id}" 
                       class="btn btn-info"><i class="icon icon-white icon-edit"></i> Estimate Dev. Effort</a>

                    <a href="${pageContext.request.contextPath}/developer/update-development-effort/${userstory.id}" 
                       class="btn btn-primary"><i class="icon icon-white icon-edit"></i> Update Dev. Effort</a>
                </div>

            </td>
        </tr>
    </c:forEach>
</table>

