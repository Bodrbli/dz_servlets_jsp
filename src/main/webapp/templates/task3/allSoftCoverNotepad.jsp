<%@ page import="java.util.List" %>
<%@ page import="com.example.dz_servlets_jsp.model.Notepad" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>allHardCoverNotepad</title>
  <link rel="stylesheet" href="../../styles/style.css">
</head>
<body>
<div class="container">
  <div class="modal">
    <%List<String> headers = (List<String>) request.getAttribute("headers");%>
    <%List<Notepad> allSoftCoverNotepad = (List<Notepad>) request.getAttribute("allSoftCoverNotepad");%>

    <div class="tableDiv">
      <table class="responseTable">
        <tr>
          <%for (String field: headers) {%>
          <th class="cell"> <%=field%> </th>
          <%}%>
        </tr>

        <%for (Notepad notepad : allSoftCoverNotepad) {%>
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
  </div>
</div>
</body>
</html>
