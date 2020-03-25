<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>

<c:if test="${requestScope.locale != null}">
    <fmt:setLocale value="${param.locale}" scope="session"/>
    <fmt:setBundle basename="resources"/>
    <c:set var="currentLocale" value="${param.locale}" scope="session"/>
</c:if>

<html>
<head>
    <title><fmt:message key='jsp.header.Settings'/></title>
    <%@ include file="/WEB-INF/jspf/head.jspf" %>
</head>


<body>
<table id="main-container">

    <%@ include file="/WEB-INF/jspf/header.jspf" %>

    <tr>
        <td class="content">
            <%-- CONTENT --%>

            <form id="settings_form" action="controller" method="post">
                <input type="hidden" name="command" value="updateSettings"/>

                <div>
                    <p><fmt:message key='jsp.header.language'/></p>
                    <select name="locale">
                        <option value="ru"><fmt:message key='jsp.Russian'/></option>
                        <option value="en"><fmt:message key='jsp.English'/></option>
                    </select>
<%--                    <c:forEach items="${applicationScope.locales}" var="locale">--%>
<%--                        <c:set var="selected" value="${locale.key == currentLocale ? 'selected' : '' }"/>--%>
<%--                        <option value="${locale.key}" ${selected}>${locale.value}</option>--%>
<%--                    </c:forEach>--%>
                </div>

                <div>
                    <p><fmt:message key='jsp.name'/> </p>
                    <input name="name">
                </div>

                <div>
                    <p><fmt:message key='jsp.lastName'/></p>
                    <input name="lastName">
                </div>

                <input type="submit" value="<fmt:message key='jsp.save'/>"><br/>
            </form>

            <%-- CONTENT --%>
        </td>
    </tr>

    <%@ include file="/WEB-INF/jspf/footer.jspf" %>

</table>
</body>
</html>