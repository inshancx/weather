<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="weatherinfo">
<table class="results-data">
<c:forEach items="${results}" var="element"> 
  <tr>
    <td>${element.cityName} ${element.country}</td>
    <td>Humidity: ${element.humidity} g/m3</td>
    <td>Temperature: ${element.temp} &#8457</td>
    <td></td>
    <td></td>
  </tr>
</c:forEach> 
</table>
</div>