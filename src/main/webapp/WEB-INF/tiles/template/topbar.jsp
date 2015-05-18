<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container-fluid">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="${pageContext.request.contextPath}">
                MUMScrum
            </a>
            <div class="nav-collapse collapse">

                <ul class="nav pull-right">
                    <li class="dropdown">
                        <a href="" role="button" class="dropdown-toggle brand" data-toggle="dropdown"> 
                            ${username}<i class="caret"></i>

                        </a>
                        <ul class="dropdown-menu">
                            <li class="nav-header">Use MUMScrum as:</li>
                            <li><a href="">Product Owner</a></li>
                            <li><a href="">Scrum Master</a></li>
                            <li><a href="">Developer</a></li>
                            <li><a href="">Tester</a></li>
                            <li><a href="">System Admin</a></li> 
                            <li class="nav-header">Options:</li>
                            <li> <a  href=""><i class="icon icon-eye-open"></i> Profile</a> </li>
                            <li><a href="<c:url value="/j_spring_security_logout" />" >
                                    <i class="icon icon-off"></i> 
                                    logout</a></li>
                        </ul>
                    </li>
                </ul>

                <ul class="nav">
                    <li class="active"><a href="${pageContext.request.contextPath}">Home</a></li>

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
                        <li><a href="${pageContext.request.contextPath}/employee/list">Employees</a></li>
                        <li><a href="${pageContext.request.contextPath}/employee/assignrole">Assign Role</a></li>

                    </sec:authorize>

                </ul>
            </div>

        </div>
    </div>
</div>