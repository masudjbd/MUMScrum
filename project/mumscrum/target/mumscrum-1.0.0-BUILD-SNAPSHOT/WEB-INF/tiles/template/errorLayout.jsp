<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initialscale=1.0">
        <title><tiles:insertAttribute ignore="true" name="title" /></title>
        <link href="${pageContext.request.contextPath}/resource/bootstrap/css/bootstrap.css"
              rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/resource/css/mumscrum.css"
              rel="stylesheet" />
        <script src="${pageContext.request.contextPath}/resource/js/jquery-1.9.1.min.js"></script>
    </head>
    <body>

        <tiles:insertAttribute name="topbar" />

        <div style="margin-top: 50px;" class="clearfix"></div>

        <div class="container-fluid">
            <div class="row-fluid">

                <tiles:insertAttribute name="sidebar" />

                <div class="span9">
 
                    <tiles:insertAttribute name="content" />


                </div>

            </div>
        </div>
                    
                    
                    
        <!--/.fluid-container-->
        <script src="${pageContext.request.contextPath}/resource/bootstrap/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/resource/bootstrap/js/bootstrap-datepicker.js"></script>

        <script type="text/javascript" src="${pageContext.request.contextPath}/resource/bootstrap/js/bootstrap-datetimepicker.min.js"></script> 

        <script src="${pageContext.request.contextPath}/resource/assets/scripts.js"></script>



        <script src="${pageContext.request.contextPath}/resource/assets/DT_bootstrap.js"></script>
        <script>
            $(function() {


                //alert('working');
                //only timepicker.
                $('#datetimepicker3').datetimepicker({
                    pickDate: false
                });

                $('.datepicker').datepicker({
                    format: 'dd/mm/yyyy'
                });

                // Easy pie charts
                $('.chart').easyPieChart({animate: 1000});
            });
        </script>
    </body>
</html>