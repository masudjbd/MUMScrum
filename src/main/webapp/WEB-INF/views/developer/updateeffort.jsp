<%-- 
    Document   : estimate development effort
    Created on : 19-May-2015, 14:01:43
    Author     : Masudur Rahman <masud.java@gmail.com>
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="mumscrum" tagdir="/WEB-INF/tags" %>



<h2>Update Development Effort</h2>


<form:form class="form-horizontal" commandName="userStory" method="post">
    <div class="span12">

        <div class="span5">

            <div class="control-group">
                <label class="control-label" for="name">User Story</label>
                <div class="controls">
                    <span class="label label-info"> ${userStory.name} </span>

                    <input type="hidden" id="usId" value="${userStory.id}" name="id" />

                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="Description">Description </label>
                <div class="controls">
                    <span class="label label-info"> ${userStory.description} </span>

 
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="developerRemainingTime">Updated Time : hour(s)</label>
                <div class="controls">
                    <input id="developerRemainingTime" type="text" 
                           name="developerRemainingTime" id="developerRemainingTime"
                           placeholder="0.00" />


                </div>
            </div>


            <div class="control-group">
                <label class="control-label" for="updatedDate">Updated Date</label>
                <div class="controls">
                    <input   class="datepicker" type="text" name="updatedDate" id="updatedDate"
                             placeholder="dd/mm/yyyy" />


                </div>
            </div>


            <div class="control-group">
                <div class="controls">
                    <button type="button" class="btn btn-update btn-info">Save </button>
                </div>
            </div>
        </div>

        <div class="span5">
            <fieldset>
                <legend>Update Development List: </legend>
                <table class="table table-striped">
                    <thead>

                        <tr>
                            <th>Development Time</th>
                            <th>Development Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${updateDevelopments}" var="ud">
                            <tr>
                                <td>${ud.developerRemainingTime}</td>
                                <td>${ud.updatedDate}</td>
                            </tr>

                        </c:forEach>
                    </tbody>
                </table>

                <a href="${pageContext.request.contextPath}/developer/list" class="btn btn-info">
                    <i class="icon icon-white icon-chevron-left"></i>
                    Back

                </a>
            </fieldset>

        </div>
    </div>  

</form:form>     


<script>
    $(function() {



        $('.btn-update').click(function() {
            var updatedDate = $("#updatedDate").val();
            var developerRemainingTime = $("#developerRemainingTime").val();
            var usId = $("#usId").val();

//            alert(usId);

            var postData = {usId: usId, developerRemainingTime: developerRemainingTime, updatedDate: updatedDate};


            $.ajax({
                type: "POST",
                url: "/mumscrum/developer/update-development-effort/" + usId,
                data: JSON.stringify(postData),
                contentType: 'application/json',
                success: function(data) {
                    alert("Successfully updated development time : hour(s) ");

                    $(location).attr('href', "/mumscrum/developer/update-development-effort/" + usId);

                }
            });


//                alert(parentTag);
        });


    });
</script>
