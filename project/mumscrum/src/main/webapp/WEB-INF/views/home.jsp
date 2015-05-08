<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>MUMScrum Project</title>
            <link href="http://getbootstrap.com/2.3.2/assets/css/bootstrap.css" rel="stylesheet">

</head>
<body>
<h1>
    <spring:message code="mumscrum.welcome.message" />
</h1>
<a href="<c:url value="/j_spring_security_logout" />"
                   class="btn btn-danger   pull-right">logout</a>
                <div class="pull-right" style="padding-right: 50px">
                    <a  class="btn btn-default" href="<spring:url value="/"/>">Home</a>
                    
                </div>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
