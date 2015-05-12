<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Edit Employee</title>
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

                    <h1>Edit Employee</h1>

                    <form:form class="form-horizontal" commandName="employee" method="post">

                        <div class="control-group">
                            <label class="control-label" for="inputName">Name</label>
                            <div class="controls">
                                <form:input type="text" path="name" id="inputName" placeholder="Name" />
                                <form:errors path="name" />
                            </div>
                        </div>


                        <div class="control-group">
                            <label class="control-label" for="inputEmail">Email</label>
                            <div class="controls">
                                <form:input type="text" path="email" id="inputEmail" placeholder="Email" />
                            </div>
                        </div>


                        <div class="control-group">
                            <label class="control-label" for="inputMobile">Mobile</label>
                            <div class="controls">
                                <form:input type="text" path="mobile" id="inputMobile" placeholder="Mobile" />
                            </div>
                        </div>



                        <div class="control-group">
                            <label class="control-label" for="inputAddress">Address</label>
                            <div class="controls">
                                <form:input type="text" path="address" id="inputAddress"
                                       placeholder="Address" />
                            </div>
                        </div>


                        <div class="control-group">
                            <div class="controls">

                                <button type="submit" class="btn btn-info">Save </button>
                            </div>
                        </div>
                    </form:form>

                </div>

            </div>
        </div>



    </body>
</html>
