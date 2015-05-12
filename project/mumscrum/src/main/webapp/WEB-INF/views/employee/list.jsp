<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Employee List Page</title>
        <link href="${pageContext.request.contextPath}/resource/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="${pageContext.request.contextPath}/resource/css/mumscrum.css" rel="stylesheet" type="text/css"/>
        <script src="${pageContext.request.contextPath}/resource/js/jquery-1.9.1.min.js"></script>
    </head>
    <body>

        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="">
                        MUMScrum
                    </a>
                    <div class="nav-collapse collapse">

                        <ul class="nav pull-right">
                            <li class="dropdown">
                                <a href="" role="button" class="dropdown-toggle brand" data-toggle="dropdown"> 
                                    ${username}<i class="caret"></i>

                                </a>
                                <ul class="dropdown-menu">
                                    <li> <a  href=""><i class="icon icon-eye-open"></i> Profile</a> </li>
                                    <li><a href="<c:url value="/j_spring_security_logout" />" >
                                            <i class="icon icon-off"></i> 
                                            logout</a></li>
                                </ul>
                            </li>
                        </ul>

                        <ul class="nav">
                            <li class="active"><a href="">Home</a></li>
                            <li><a href="">Product Backlog</a></li>
                            <li><a href="">Release Backlog</a></li>
                            <li><a href="">Sprint</a></li>
                            <li><a href="">User Story</a></li>
                            <li><a href="">Burndown Chart</a></li>
                            <li><a href="employee/list">Employees</a></li>
                        </ul>
                    </div>
                    <!--/.nav-collapse -->
                </div>
            </div>
        </div>

        <div style="margin-top: 50px;" class="clearfix"></div>

        <div class="container-fluid">
            <div class="row-fluid">

                <div class="span3"  id="sidebar">
                    <h3>Navigation</h3>
                    <ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
                        <li class="active"><a href="">Home</a></li>
                        <li><a href="">Product Backlog</a></li>
                        <li><a href="">Release Backlog</a></li>
                        <li><a href="">Sprint</a></li>
                        <li><a href="">User Story</a></li>
                        <li><a href="">Burndown Chart</a></li>
                    </ul>
                </div>
                <div class="span9">
                    <h1>Employee List Page</h1>

                    <a href="${pageContext.request.contextPath}/employee/add" class="btn btn-info"><i class="icon icon-white icon-plus-sign"></i> Create Employee </a>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Mobile</th>
                                <th>Address</th>
                                <th></th>
                            </tr>
                        </thead>
                        <c:forEach var="employee" items="${employees}" >
                            <tr>
                                <td>
                                    ${employee.id}
                                </td>
                                <td>
                                    ${employee.name}
                                </td>
                                <td>
                                    ${employee.email}
                                </td>
                                <td>
                                    ${employee.mobile}
                                </td>
                                <td>
                                    ${employee.address}
                                </td>
                                <td>
                                    <div class="btn-group">
                                        <a href="${pageContext.request.contextPath}/employee/edit/${employee.id}" 
                                           class="btn btn-info"><i class="icon icon-white icon-edit"></i> Edit</a>
                                        <a href="${pageContext.request.contextPath}/employee/delete/${employee.id}"
                                           class="btn btn-danger"><i class="icon icon-white icon-trash"></i> Delete</a>

                                    </div>

                                </td>
                            </tr>
                        </c:forEach>
                    </table>

                </div>

            </div>
        </div>




    </body>
</html>
