<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>MaxCountNotepadFirma</title>
  <link rel="stylesheet" href="../../styles/style.css">
</head>
<body>
<div class="container">
  <div class="modal">
    <%String maxCountNotepadFirma = (String) request.getAttribute("maxCountNotepadFirma");%>

    <table class="responseTable">
      <tr>
        <th class="cell">Max Count Notepad Country</th>
      </tr>

      <tr>
        <th><%=maxCountNotepadFirma%></th>
      </tr>

    </table>
  </div>
</div>
</body>
</html>
