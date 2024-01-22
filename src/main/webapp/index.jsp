<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>home</title>
</head>
<body>
    <div>
        <div>
            <h3>task2</h3>
            <a href="${pageContext.request.contextPath}/all">полная таблица</a> <br>
            <a href="${pageContext.request.contextPath}/countries">страны производители</a> <br>
            <a href="${pageContext.request.contextPath}/countryNotepads">страны и количество их блокнотов</a> <br>
            <a href="/firmNotepads">фирмы и количетсво их блокнотов</a>
            <h3>task3</h3>
            <a href="${pageContext.request.contextPath}/maxCountNotepadCountry">страна с наибольшим количеством блокнотов</a> <br>
            <a href="${pageContext.request.contextPath}/minCountNotepadCountry">страна с наименьшим количеством блокнотов</a> <br>
            <a href="${pageContext.request.contextPath}/maxCountNotepadFirma">фирма с наибольшим количеством блокнотов</a> <br>
            <a href="${pageContext.request.contextPath}/minCountNotepadFirma">фирма с наименьшим количеством блокнотов</a> <br>
            <a href="${pageContext.request.contextPath}/allHardCoverNotepad">все блокноты с жестким типом обложки</a> <br>
            <a href="${pageContext.request.contextPath}/allSoftCoverNotepad">все блокноты с мягким типом обложки</a> <br>
            <h3>task4</h3>
            <a href="${pageContext.request.contextPath}/countryTypeFilter">фильтр по стране производителю</a> <br>
            <a href="${pageContext.request.contextPath}/pageTypeFilter">фильтр по типу страницы</a> <br>
            <a href="${pageContext.request.contextPath}/countPageFilter">фильтр по количеству страниц</a> <br>
            <h3>task5</h3>
            <a href="${pageContext.request.contextPath}/add">добавление блокнота</a>
        </div>
    </div>
</body>
</html>