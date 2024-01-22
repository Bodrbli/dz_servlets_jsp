<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>countryNotepads</title>
    <link rel="stylesheet" href="../../styles/style.css">
</head>
<body>
  <div class="container">
    <div class="modal">
      <%Map<String, Integer> countryNotepads = (Map<String, Integer>) request.getAttribute("countryNotepads");%>

      <table class="responseTable">
        <tr>
          <th class="cell">COUNTRY</th>
          <th class="cell">COUNT</th>
        </tr>
        <%for(String country : countryNotepads.keySet()) {%>
        <tr>
          <th><%=country%></th>
          <th><%=countryNotepads.get(country)%></th>
        </tr>
        <%}%>
      </table>
    </div>
  </div>
</body>
</html>
