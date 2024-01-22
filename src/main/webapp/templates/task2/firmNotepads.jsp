<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>firmNotepads</title>
    <link rel="stylesheet" href="../../styles/style.css">
</head>
<body>
<div class="container">
    <div class="modal">
        <%Map<String, Integer> firmNotepads = (Map<String, Integer>) request.getAttribute("firmNotepads");%>

        <table class="responseTable">
            <tr>
                <th class="cell">FIRMA</th>
                <th class="cell">COUNT</th>
            </tr>
            <%for(String firma : firmNotepads.keySet()) {%>
            <tr>
                <th><%=firma%></th>
                <th><%=firmNotepads.get(firma)%></th>
            </tr>
            <%}%>
        </table>
    </div>
</div>
</body>
</html>
