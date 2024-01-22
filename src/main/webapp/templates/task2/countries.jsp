<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>countries</title>
    <link rel="stylesheet" href="../../styles/style.css">
</head>
<body>
    <div class="container">
        <div class="modal">
            <%List<String> countries = (List<String>) request.getAttribute("countries");%>
            <table class="responseTable">
                <tr>
                    <th class="cell">COUNTRIES</th>
                </tr>
                <%for (String country : countries) {%>
                <tr>
                    <td class="cell"><%=country%></td>
                </tr>
                <%}%>
            </table>
        </div>
    </div>

</body>
</html>
