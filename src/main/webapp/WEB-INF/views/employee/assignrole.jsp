<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<h3>Assign role to Employee</h3>

<div class="accordion" id="accordion2">
    <c:forEach items="${employees}" var="employee" varStatus="loop">
        <div class=""></div>

        <div class="accordion-group">
            <div class="accordion-heading">
                <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapse${loop.index}">
                   ${employee.id})  ${employee.firstname} ${employee.lastname}  
                </a>
            </div>
            <div id="collapse${loop.index}" class="accordion-body collapse">
                <div class="accordion-inner parent${loop.index}" data-employee="${employee.id}" >
                    Roles:  <br />
                    <c:forEach items="${roles}" var="role" >
                        <input type="checkbox" name="role" class="roleList" value="${role.roleId}" /> ${role.roleName} <br />
                    </c:forEach>
                    <button type="button"  class="btn assignRole btn-info">Assign</button>    
                </div>
            </div>
        </div>
    </c:forEach>



    <script>
        $(function() {


            $('.assignRole').click(function() {
                var roleVals = $(this).parent().find(".roleList").val();
                var empId = $(this).parent().attr("data-employee");
                var stringArray = new Array();
//                    stringArray[0] = "item1";
//                    stringArray[1] = "item2";
//                    stringArray[2] = "item3";
//
//                $.ajax({
//                    type: "POST",
//                    url: "/mumscrum/employee/assignrole",
//                    data: JSON.stringify(postData),
//                    success: function(data) {
//                        alert(data);
//                    },
//                    contentType: "application/json; charset=utf-8",
//                    async: false, //Cross-domain requests and dataType: "jsonp" requests do not support synchronous operation
//                    cache: false, //This will force requested pages not to be cached by the browser          
//                    processData: false, //To avoid making query String instead of JSON
//                });






                $(this).parent().find(".roleList:checked").each(function(index) {
                    stringArray[index] = $(this).val();
                    // alert($(this).val());
                });

                var postData = {id: empId, roles: stringArray};


                $.ajax({
                    type: "POST",
                    url: "/mumscrum/employee/assignrole",
                    data: JSON.stringify(postData),
                    contentType: 'application/json',
                    success: function(data) {
                        alert("Successfully assigned role(s) ");
                    }
                });


//                alert(parentTag);
            });


        });
    </script>

</div>