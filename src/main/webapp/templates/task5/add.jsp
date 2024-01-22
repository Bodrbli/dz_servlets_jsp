<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../styles/style.css">
</head>
<body>
    <div class="container">
        <div class="modal">
            <form method="post", action="${pageContext.request.contextPath}/add">
                <%List<String> appearances = (List<String>) request.getAttribute("appearances");%>
                <%List<String> coverTypes = (List<String>) request.getAttribute("coverTypes");%>
                <input type="text" name="firma" placeholder="firma">
                <input type="text" name="notepadName" placeholder="notepadName">
                <input type="text" name="pageCount" placeholder="pageCount">
                <select class="requestInput" name="cover">
                    <%for (String cover : coverTypes) {%>
                    <option><%=cover%></option>
                    <%}%>
                </select>
                <input type="text" name="country" placeholder="country">
                <select class="requestInput" name="appearance">
                    <%for (String appearance : appearances) {%>
                    <option><%=appearance%></option>
                    <%}%>
                </select>
                <input type="submit" value="add" class="requestButton" onclick="handler()">
            </form>
            <span>
            </span>
        </div>
    </div>
<script src="../../scripts/submitButtonScript.js"></script>
</body>
</html>
