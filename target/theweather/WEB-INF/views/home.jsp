<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel = "stylesheet" type = "text/css" href = "./resources/style.css" />
		<script
		  src="https://code.jquery.com/jquery-3.4.1.min.js"
		  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
		  crossorigin="anonymous"></script>
         <script src="./resources/javascript/getWeather.js"></script>
		<style>

		</style>
        <title>Weather Service</title>
    </head>
    <body>
    <div class="container">
     <div class="main-content">
        <h1>Check your Weather</h1>
        <div>Enter City<spring:message code="app.lang.entercity" ></spring:message>
	        <input type="text" placeholder="City name - Use commas for multiple (e.g. houston,columbia)" id="cityname" value=""/>
	        <button id="submitButton">Submit</button>
        </div>
        <div class="error" id="errormessage"></div>
      </div>
      <div id="loadingModal" class="modal">
      <img src="./resources/images/hour_glass.gif"/>
	  <div>loading...</div>
	  </div>	
      <div class="results-content">
        <jsp:include page="weather_results.jsp" />
      </div>	
    </div>
    </body>
</html>
