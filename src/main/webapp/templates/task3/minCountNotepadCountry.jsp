<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>MinCountNotepadCountry</title>
  <link rel="stylesheet" href="../../styles/style.css">
</head>
<body>
<div class="container">
  <div class="modal">
    <%String minCountNotepadCountry = (String) request.getAttribute("minCountNotepadCountry");%>

    <table class="responseTable">
      <tr>
        <th class="cell">Min Count Notepad Country</th>
      </tr>

      <tr>
        <th><%=minCountNotepadCountry%></th>
      </tr>

    </table>
  </div>
</div>
</body>
</html>
