<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<div class="left-side-menu-container">
    <c:choose>
        <c:when test="${page_type=='main'}">
            <div class="main-font-nav left-side-menu-component selected">
                <a href="${pageContext.request.contextPath}/">
                    <span>Главная</span>
                </a>
            </div>
            <div class="main-font-nav left-side-menu-component">
                <a href="${pageContext.request.contextPath}/publications">
                    <span>Научные публикации</span>
                </a>
            </div>
            <div class="main-font-nav left-side-menu-component">
                <a href="${pageContext.request.contextPath}/defends">
                    <span>Защиты</span>
                </a>
            </div>
        </c:when>
        <c:when test="${page_type=='publications'}">
            <div class="main-font-nav left-side-menu-component">
                <a href="${pageContext.request.contextPath}/">
                    <span>Главная</span>
                </a>
            </div>
            <div class="main-font-nav left-side-menu-component selected">
                <a href="${pageContext.request.contextPath}/publications">
                    <span>Научные публикации</span>
                </a>
            </div>
            <div class="main-font-nav left-side-menu-component">
                <a href="${pageContext.request.contextPath}/defends">
                    <span>Защиты</span>
                </a>
            </div>
        </c:when>
        <c:when test="${page_type=='defends'}">
            <div class="main-font-nav left-side-menu-component">
                <a href="${pageContext.request.contextPath}/">
                    <span>Главная</span>
                </a>
            </div>
            <div class="main-font-nav left-side-menu-component">
                <a href="${pageContext.request.contextPath}/publications">
                    <span>Научные публикации</span>
                </a>
            </div>
            <div class="main-font-nav left-side-menu-component selected">
                <a href="${pageContext.request.contextPath}/defends">
                    <span>Защиты</span>
                </a>
            </div>
        </c:when>
    </c:choose>
</div>