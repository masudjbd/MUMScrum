<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<h1>Generate Leave Type</h1>

<form:form class="form-horizontal" commandName="ltype" method="post">

    <div class="row">

        <div class="span5">
          
            <div class="control-group">
                <label class="control-label" for="inputtypename">Leave Type</label>
                <div class="controls">
                    <form:input type="text" path="typename" id="inputtypename" placeholder="Type of Leave" />
                    <form:errors path="typename" cssClass="error" />
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="inputdefaultvalue">Default Leave</label>
                <div class="controls">
                    <form:input type="text" path="defaultvalue" id="inputdefaultvalue" placeholder="Default Leave" />
                    <form:errors path="defaultvalue" cssClass="error" />

                </div>
            </div>

            <div class="control-group">
                <div class="controls">

                    <button type="submit" class="btn btn-info">Save </button>
                </div>
            </div>
                    
        </div>  

    </div>
</form:form>

