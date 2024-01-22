<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MaxCountNotepadCountry</title>
    <link rel="stylesheet" href="../../styles/style.css">
</head>
<body>
<div class="container">
  <div class="modal">
    <%String maxCountNotepadCountry = (String) request.getAttribute("maxCountNotepadCountry");%>

    <table class="responseTable">
      <tr>
        <th class="cell">Max Count Notepad Country</th>
      </tr>

      <tr>
        <th><%=maxCountNotepadCountry%></th>
      </tr>

    </table>
  </div>
</div>
</body>
</html>
