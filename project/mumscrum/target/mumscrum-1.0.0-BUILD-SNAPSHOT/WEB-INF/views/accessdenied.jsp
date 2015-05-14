<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<h3>You are not authorized to view this resource</h3>

<div class="alert alert-danger">
    Sorry ! you are not authorized to view this resources . 
    
   <br />
   
   Please contact to your administrator to get this access :(
   
   go back :-
   <a href="${pageContext.request.contextPath}/" class="btn btn-info">
       <i class="icon icon-white icon-home"></i> Home </a>

    
</div>