<%-- 
    Document   : inputField
    Created on : 19-May-2015, 10:37:57
    Author     : Masudur Rahman <masud.java@gmail.com>
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ attribute name="name" required="true" rtexprvalue="true"
              description="Name of corresponding property in bean object" %>
<%@ attribute name="label" required="true" rtexprvalue="true"
              description="Label appears in red color if input is considered as invalid after submission" %>

<spring:bind path="${name}">
    <c:set var="cssGroup" value="control-group ${status.error ? 'error' : '' }"/>
    <div class="${cssGroup}">
        <label class="control-label">${label}</label>

        <div class="controls">
            <form:input path="${name}"/>
             ${status.errorMessage}  
        </div>
    </div>
</spring:bind>