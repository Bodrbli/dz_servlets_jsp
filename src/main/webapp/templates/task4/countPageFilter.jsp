<%@ page import="java.util.List" %>
<%@ page import="com.example.dz_servlets_jsp.model.Notepad" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>CountPageFilter</title>
  <link rel="stylesheet" href="../../styles/style.css">
</head>
<body>
<div class="container">
  <div class="modal">
    <form class="requestForm" method="get" action="${pageContext.request.contextPath}/countPageFilter">
      <%List<String> page_count = (List<String>) request.getAttribute("page_count");%>
      <%List<String> headers = (List<String>) request.getAttribute("headers");%>
      <%List<Notepad> filtered = (List<Notepad>) request.getAttribute("filtered");%>
      <select class="requestInput" name="page_count">
        <%for (String count : page_count) {%>
        <option><%=count%></option>
        <%}%>
      </select>
      <input type="submit" class="requestButton" value="filter">
    </form>

    <%if (filtered != null) {%>
    <div class="tableDiv">
      <table class="responseTable">
        <tr>
          <%for (String field: headers) {%>
          <th class="cell"> <%=field%> </th>
          <%}%>
        </tr>

        <%for (Notepad notepad : filtered) {%>
        <tr>
          <td class="cell"><%=notepad.getId()%></td>
          <td class="cell"><%=notepad.getFirma()%></td>
          <td class="cell"><%=notepad.getNotepadName()%></td>
          <td class="cell"><%=notepad.getPagesCount()%></td>
          <td class="cell"><%=notepad.getCoverType()%></td>
          <td class="cell"><%=notepad.getCountry()%></td>
          <td class="cell"><%=notepad.getAppearance()%></td>
        </tr>
        <%}%>
      </table>
    </div>
    <%}%>
  </div>
</div>
</body>
</html>
