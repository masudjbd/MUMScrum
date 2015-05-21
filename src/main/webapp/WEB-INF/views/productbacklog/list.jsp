<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h1>Product Backlog List Page</h1>

<c:if test="${!empty message}">
    <div class="alert alert-success" role="alert">${message}</div>
</c:if>    

<a href="${pageContext.request.contextPath}/product-backlog/add" class="btn btn-info"><i class="icon icon-white icon-plus-sign"></i> Create Product Backlog </a>
<table class="table table-striped">
    <thead>
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>create Date</th>            
            <th></th>
        </tr>
    </thead>
    <c:forEach var="pb" items="${pbList}" >
        <tr>
            <td>
                ${pb.id}
               
            </td>
            <td>
               ${pb.name} 
               
            </td>
            <td>
                ${pb.createDate} 
            </td>
            
            <td>
                <div class="btn-group">
                    <a href="${pageContext.request.contextPath}/product-backlog/edit/${pb.id}" 
                       class="btn btn-info"><i class="icon icon-white icon-edit"></i> Edit</a>
                    <a href="${pageContext.request.contextPath}/product-backlog/delete/${pb.id}"
                       class="btn btn-danger"><i class="icon icon-white icon-trash"></i> Delete</a>

                </div>

            </td>
        </tr>
    </c:forEach>
</table>

