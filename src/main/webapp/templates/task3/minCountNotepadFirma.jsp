<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>MinCountNotepadFirma</title>
  <link rel="stylesheet" href="../../styles/style.css">
</head>
<body>
<div class="container">
  <div class="modal">
    <%String minCountNotepadFirma = (String) request.getAttribute("minCountNotepadFirma");%>

    <table class="responseTable">
      <tr>
        <th class="cell">Min Count Notepad Firma</th>
      </tr>

      <tr>
        <th><%=minCountNotepadFirma%></th>
      </tr>

    </table>
  </div>
</div>
</body>
</html>
