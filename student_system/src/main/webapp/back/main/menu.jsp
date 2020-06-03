<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"/>
<script src="${pageContext.request.contextPath}/back/statics/js/jquery-1.8.3.min.js"></script>

<style>
    body,ul,li{
        background:#eee;
    }
    .list-group-item{
        background: #eee;
    }
</style>
<body>
<ul class="list-group text-center" style="margin-top: 70px;">

    <li class="list-group-item"><a href="${pageContext.request.contextPath}/student/findAll" target="content">学生管理</a>
    </li>


</ul>
</body>
