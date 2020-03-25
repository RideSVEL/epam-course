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
            <h2><fmt:message key="jsp.users_request_for_unblock"/></h2>
            <br>
            <table id="cards_table">
                <thead>
                <tr>
                    <td>#</td>
                    <td><fmt:message key="jsp.idUser"/></td>
                    <td><fmt:message key="jsp.Name"/></td>
                    <td><fmt:message key="jsp.number"/></td>
                    <td><fmt:message key="jsp.money"/></td>
                    <td><fmt:message key="jsp.activity"/></td>
                    <td class="content center"><fmt:message key="jsp.unblock"/></td>
                    <td class="content center"><fmt:message key="jsp.reject"/></td>
                </tr>
                </thead>

                <c:set var="k" value="0"/>
                <c:forEach var="card" items="${cards}">
                    <c:if test="${card.activityId == 1}">
                        <c:set var="k" value="${k+1}"/>
                        <tr>
                        <td><c:out value="${k}"/></td>
                        <td>${card.userId}</td>
                        <td>${card.name}</td>
                        <td>${card.number}</td>
                        <td>${card.money}</td>
                        <td>
                            <c:if test="${card.activityId == 1}">Blocked</c:if>
                        <td class="content center">
                            <form id="block_user" action="controller" method="post">
                                <input type="hidden" name="command" value="acceptRequest"/>
                                <input type="hidden" name="card_id" value="${card.id}"/>
                                <input type="submit" value="<fmt:message key="jsp.accept"/>"/>
                            </form>
                        </td>
                        <td class="content center">
                            <form id="unblock_user" action="controller" method="post">
                                <input type="hidden" name="command" value="rejectRequest"/>
                                <input type="hidden" name="card_id" value="${card.id}"/>
                                <input type="submit" value="<fmt:message key="jsp.reject"/>"/>
                            </form>
                        </td>
                    </c:if>
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
