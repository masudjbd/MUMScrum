<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="span3"  id="sidebar">
    <h3>Navigation</h3>
    <ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
        <li class="active"><a href="${pageContext.request.contextPath}">Home</a></li>

        <sec:authorize access="hasRole('ROLE_PRODUCT_OWNER')">
            <li><a href="${pageContext.request.contextPath}/product-backlog/list">Product Backlog</a></li>
            </sec:authorize>

        <sec:authorize access="hasAnyRole('ROLE_PRODUCT_OWNER', 'ROLE_SCRUM_MASTER')">
            <li><a href="${pageContext.request.contextPath}/release-backlog/list">Release Backlog</a></li>
            </sec:authorize>

        <sec:authorize access="hasAnyRole('ROLE_PRODUCT_OWNER', 'ROLE_SCRUM_MASTER')">
            <li><a href="${pageContext.request.contextPath}/sprint/list">Sprint</a></li>
            </sec:authorize>

        <sec:authorize access="hasAnyRole('ROLE_PRODUCT_OWNER', 'ROLE_SCRUM_MASTER','ROLE_DEVELOPER','ROLE_TESTER')">
            <li><a href="${pageContext.request.contextPath}/user-story/list">User Story</a></li>
            </sec:authorize>

        <sec:authorize access="hasAnyRole('ROLE_PRODUCT_OWNER')">
            <li><a href="${pageContext.request.contextPath}/release-backlog/assign-scrummaster">Assign SM to Release</a></li>
            </sec:authorize>

        <sec:authorize access="hasAnyRole('ROLE_SCRUM_MASTER')">
            <li><a href="${pageContext.request.contextPath}/">Assign US to Developer</a></li>
            </sec:authorize>

        <sec:authorize access="hasAnyRole('ROLE_SCRUM_MASTER')">
            <li><a href="${pageContext.request.contextPath}/">Assign US to Tester</a></li>
            </sec:authorize>

        <sec:authorize access="hasRole('ROLE_DEVELOPER')">
            <li><a href="${pageContext.request.contextPath}/developer/list">Estimate Development Effort</a></li>
            <li><a href="${pageContext.request.contextPath}/developer/list">Update Development Effort</a></li>
            </sec:authorize>

        <sec:authorize access="hasRole('ROLE_TESTER')">
            <li><a href="${pageContext.request.contextPath}/tester/list">Estimate Testing Effort</a></li>
            <li><a href="${pageContext.request.contextPath}/tester/list">Update Testing Effort</a></li>
            </sec:authorize>      


        <li><a href="${pageContext.request.contextPath}/burndown-chart">Burndown Chart</a></li>

        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <li><a href="${pageContext.request.contextPath}/employee/list">Employees</a></li>
            </sec:authorize>



        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <li><a href="${pageContext.request.contextPath}/employee/assignrole">Assign Role</a></li>
            </sec:authorize>


        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <li><a href="${pageContext.request.contextPath}/leave/list">Vacation/leave</a></li>
            </sec:authorize>

        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <li><a href="${pageContext.request.contextPath}/insurance/list">Insurance Policy</a></li>
            </sec:authorize>

        <sec:authorize access="hasAnyRole( 'ROLE_SCRUM_MASTER','ROLE_DEVELOPER','ROLE_TESTER')">
            <li><a href="${pageContext.request.contextPath}">Create IMR</a></li>
            </sec:authorize>
        <li><a href="${pageContext.request.contextPath}">Update My Profile</a></li>
        <li><a href="${pageContext.request.contextPath}">View Organizational Chart</a></li>
        <li><a href="${pageContext.request.contextPath}">View My Vacation Days</a></li>
        <li><a href="${pageContext.request.contextPath}">Health Insurance</a></li>
        <li><a href="${pageContext.request.contextPath}">View My Paycheck</a></li>



    </ul>



</div>
