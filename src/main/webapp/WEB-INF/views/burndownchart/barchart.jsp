<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<script type="text/javascript" src="https://www.google.com/jsapi?autoload={'modules':[{'name':'visualization','version':'1.1','packages':['bar']}]}"></script>
       
   

<h1>Burndown Chart</h1>
 

<div id="top_x_div" style="width:700px; height: 400px;"></div>


<script>
    google.setOnLoadCallback(drawStuff);

      function drawStuff() {
        var data = new google.visualization.arrayToDataTable([
          ['Opening Move', 'Percentage'],
          ["User Story A (e4)", 44],
          ["User Story B (d4)", 31],
          ["User Story B (Nf3)", 12],
          ["User Story C (c4)", 10],
          ['Other', 3]
        ]);

        var options = {
          title: '<<Burndown Chart>>',
          width: 700,
          legend: { position: 'none' },
          chart: { title: 'Burndown chart for selected product backlog',
                   subtitle: 'updates by percentage' },
          bars: 'vertical', // Required for Material Bar Charts.
          axes: {
            x: {
              0: { side: 'top', label: 'Percentage'} // Top x-axis.
            }
          },
          bar: { groupWidth: "50%" }
        };

        var chart = new google.charts.Bar(document.getElementById('top_x_div'));
        chart.draw(data, options);
      };
    
</script>