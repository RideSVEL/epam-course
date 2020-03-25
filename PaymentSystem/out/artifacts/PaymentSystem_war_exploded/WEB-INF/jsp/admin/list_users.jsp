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
    <title><fmt:message key="jsp.header.users"/></title>
    <%@ include file="/WEB-INF/jspf/head.jspf" %>
</head>
<body>

<table id="main-container">

    <%@ include file="/WEB-INF/jspf/header.jspf" %>

    <tr>
        <td class="content">
            <%-- CONTENT --%>
            <br>
            <form id="requestUsers" action="controller" method="post">
                <input type="hidden" name="command" value="showRequests"/>
                <input type="submit" value="<fmt:message key="jsp.requests"/>"/>
            </form>
            <br>
            <form id="login_form" action="controller" method="get">
                <input type="hidden" name="command" value="searchUser"/>
                <fieldset>
                    <legend><fmt:message key="jsp.search_by_login"/></legend>
                    <input name="search"/><br/>
                </fieldset>
                <input type="submit" value="<fmt:message key="jsp.search"/>">
            </form>
            <br>
            <table id="users_table">
                <thead>
                <tr>
                    <td>#</td>
                    <td><fmt:message key="jsp.login"/></td>
                    <td><fmt:message key="jsp.name"/></td>
                    <td><fmt:message key="jsp.lastName"/></td>
                    <td><fmt:message key="jsp.activity"/></td>
                    <td class="content center"><fmt:message key="jsp.check"/></td>
                    <td class="content center"><fmt:message key="jsp.action"/></td>
                </tr>
                </thead>

                <c:set var="k" value="0"/>
                <c:forEach var="user" items="${users}">
                    <c:set var="k" value="${k+1}"/>
                    <tr>
                        <td><c:out value="${k}"/></td>
                        <td>${user.login}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>
                            <c:if test="${user.activityId == 0}"><fmt:message key="jsp.activity.active"/></c:if>
                            <c:if test="${user.activityId == 1}"><fmt:message key="jsp.activity.blocked"/></c:if>
                        <td class="content center">
                            <form id="listUsers" action="controller" method="post">
                                <input type="hidden" name="command" value="showCards"/>
                                <input type="hidden" name="user_id" value="${user.id}"/>
                                <input type="submit" value="<fmt:message key="jsp.cards"/>"/>
                            </form>
                        </td>
                        <td class="content center">
                            <c:if test="${user.activityId == 0}">
                                <form id="block_user" action="controller" method="post">
                                    <input type="hidden" name="command" value="blockUser"/>
                                    <input type="hidden" name="user_id" value="${user.id}"/>
                                    <input type="submit" value="<fmt:message key="jsp.block"/>"/>
                                </form>
                            </c:if>
                            <c:if test="${user.activityId == 1}">
                                <form id="unblock_user" action="controller" method="post">
                                    <input type="hidden" name="command" value="unblockUser"/>
                                    <input type="hidden" name="user_id" value="${user.id}"/>
                                    <input type="submit" value="<fmt:message key="jsp.unblock"/>"/>
                                </form>
                            </c:if>
                        </td>
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
