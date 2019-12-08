<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<div class="right-side-content-conteiner" id="app">
    <c:choose>
        <c:when test="${page_type=='main'}">
            <articlesandfilters></articlesandfilters>
        </c:when>
        <c:when test="${page_type=='defends'}">
            <defends></defends>
        </c:when>
        <c:when test="${page_type=='publications'}">
            <publications></publications>
        </c:when>
    </c:choose>
</div>