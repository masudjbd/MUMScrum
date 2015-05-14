<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="span3"  id="sidebar">
    <h3>Navigation</h3>
    <ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
        <li class="active"><a href="">Home</a></li>

        <sec:authorize access="hasRole('ROLE_PRODUCT_OWNER')">
            <li><a href="">Product Backlog</a></li>
            </sec:authorize>

        <sec:authorize access="hasAnyRole('ROLE_PRODUCT_OWNER', 'ROLE_SCRUM_MASTER')">
            <li><a href="">Release Backlog</a></li>
            </sec:authorize>

        <sec:authorize access="hasAnyRole('ROLE_PRODUCT_OWNER', 'ROLE_SCRUM_MASTER')">
            <li><a href="">Sprint</a></li>
            </sec:authorize>

        <sec:authorize access="hasAnyRole('ROLE_PRODUCT_OWNER', 'ROLE_SCRUM_MASTER','ROLE_DEVELOPER','ROLE_TESTER')">
            <li><a href="">User Story</a></li>
            </sec:authorize>


        <li><a href="">Burndown Chart</a></li>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
            <li><a href="employee/list">Employees</a></li>
            </sec:authorize>
    </ul>



</div>
