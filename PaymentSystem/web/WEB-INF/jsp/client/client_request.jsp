<%--
  Created by IntelliJ IDEA.
  User: sbkik
  Date: 17.03.2020
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<head>
    <title><fmt:message key="jsp.cards"/></title>
    <%@ include file="/WEB-INF/jspf/head.jspf" %>
</head>
<body>
<table id="main-container">

    <%@ include file="/WEB-INF/jspf/header.jspf" %>

    <tr>
        <td class="content">
            <%-- CONTENT --%>
            <br>
            <table id="cards_table">
                <thead>
                <tr>
                    <td>#</td>
                    <td><fmt:message key="jsp.Name"/></td>
                    <td><fmt:message key="jsp.number"/></td>
                    <td><fmt:message key="jsp.money"/></td>
                    <td><fmt:message key="jsp.activity"/></td>
                </tr>
                </thead>

                <c:set var="k" value="0"/>
                <c:forEach var="card" items="${cards}">
                    <c:set var="k" value="${k+1}"/>
                    <tr>
                        <td><c:out value="${k}"/></td>
                        <td>${card.name}</td>
                        <td>${card.number}</td>
                        <td>${card.money}</td>
                        <td>
                            <c:if test="${card.activityId == 0}"><fmt:message key="jsp.activity.active"/></c:if>
                            <c:if test="${card.activityId == 1}"><fmt:message key="jsp.activity.blocked"/></c:if>
                    </tr>
                </c:forEach>
            </table>


            <%-- CONTENT --%>
        </td>
    </tr>

    <%@ include file="/WEB-INF/jspf/footer.jspf" %>

</table>
</body>
</html>
