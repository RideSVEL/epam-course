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
            <form id="myRequests" action="controller" method="post">
                <input type="hidden" name="command" value="replenishBalance"/>
                <input type="submit" value="<fmt:message key="jsp.add.balance"/>"/>
            </form>
            <form id="send_payment" action="controller" method="post">
                <input type="hidden" name="command" value="sendPayment"/>
                <input type="submit" value="<fmt:message key="jsp.send.payment"/>"/>
            </form>
            <form id="send_payment" action="controller" method="post">
                <input type="hidden" name="command" value="commandCard"/>
                <input type="submit" value="<fmt:message key="jsp.create.card"/>"/>
            </form>
            <br>
            <c:if test="${count > 0}">
                <form id="myRequests" action="controller" method="post">
                    <input type="hidden" name="command" value="showClientRequest"/>
                    <input type="submit" value="<fmt:message key="jsp.my.requests"/> (${count})"/>
                </form>
            </c:if>
            <br>
            <form id="sorting_cards" action="controller" method="post">
                <input type="hidden" name="command" value="userShowCards"/>
                <select name="sorting">
                    <option value="name"><fmt:message key="jsp.sorting.name"/></option>
                    <option value="number"><fmt:message key="jsp.sorting.number"/></option>
                    <option value="money"><fmt:message key="jsp.sorting.money"/></option>
                </select>
                <select name="order">
                    <option value="ascending"><fmt:message key="jsp.sorting.ascending"/></option>
                    <option value="descending"><fmt:message key="jsp.sorting.descending"/></option>
                </select>
                <select name="filter">
                    <option value="all"><fmt:message key="jsp.sorting.all"/></option>
                    <option value="active"><fmt:message key="jsp.sorting.active"/></option>
                    <option value="block"><fmt:message key="jsp.sorting.block"/></option>
                </select>
                <input type="submit" value="<fmt:message key="jsp.sort"/>">
            </form>
            <br>
            <table id="cards_table">
                <thead>
                <tr>
                    <td>#</td>
                    <td><fmt:message key="jsp.Name"/></td>
                    <td><fmt:message key="jsp.number"/></td>
                    <td><fmt:message key="jsp.money"/></td>
                    <td><fmt:message key="jsp.activity"/></td>
                    <td class="content center"><fmt:message key="jsp.activity"/></td>
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
                                <c:if test="${card.activityId == 0}">
                                    <fmt:message key="jsp.activity.active"/>
                                </c:if>
                                <c:if test="${card.activityId == 1}">
                                    <fmt:message key="jsp.activity.blocked"/>
                                </c:if>
                        <td class="content center">
                            <c:if test="${card.requestId == 0}">
                                <c:if test="${card.activityId == 0}">
                                    <form id="block_card" action="controller" method="post">
                                        <input type="hidden" name="command" value="actionBlock"/>
                                        <input type="hidden" name="card_id" value="${card.id}"/>
                                        <input type="submit" value="<fmt:message key="jsp.block"/>"/>
                                    </form>
                                </c:if>
                                <c:if test="${card.activityId == 1}">
                                    <form id="block_card" action="controller" method="get">
                                        <input type="hidden" name="command" value="requestUserCardUnblock"/>
                                        <input type="hidden" name="card_id" value="${card.id}"/>
                                        <input type="submit" value="<fmt:message key="jsp.unblock.request"/>"/>
                                    </form>
                                </c:if>
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
