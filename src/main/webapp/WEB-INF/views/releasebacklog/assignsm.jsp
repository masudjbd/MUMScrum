<%-- 
    Document   : assignsm
    Created on : May 18, 2015, 11:44:59 AM
    Author     : HabibRahman
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h1>Assign Scrum Master to Release Backlog</h1>


    <div class="row">
        <div class="span5">

            <div class="control-group">
                <label class="control-label" for="name">Select Product Backlog</label>
                <div class="controls">
                    <select name="productBacklog" id="productBacklog">
                        <c:forEach items="${productbacklogs}" var="productbacklog">
                            <option value="${productbacklog.id}">${productbacklog.name}</option>  
                        </c:forEach>
                    </select> 
                </div>
            </div>
            
            <div class="control-group">
                <label class="control-label" for="name">Select Release Backlog</label>
                <div class="controls">
                    <select name="releaseBacklog" id="releaseBacklog">
                         <c:forEach items="${releasebacklogs}" var="releasebacklog">
                            <option value="${releasebacklog.id}">${releasebacklog.name}</option>  
                        </c:forEach>
                    </select> 
                </div>
            </div>
            
            <div class="control-group">
                <label class="control-label" for="name">Select Scrum Master</label>
                <div class="controls">
                    <select name="scrumMaster" id="scrumMaster">
                         <c:forEach items="${scrummasters}" var="scrumMaster">
                            <option value="${scrumMaster.id}">${scrumMaster.firstname} ${scrumMaster.lastname}</option>  
                        </c:forEach>
                    </select> 
                </div>
            </div>
            
            <div class="control-group">
                <div class="controls">
                    <button type="button" class="btn btn-info" onclick="assignSMToRelease()">Save </button>
                </div>
            </div>
        </div>
    </div>

