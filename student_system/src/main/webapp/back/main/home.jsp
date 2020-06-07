<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"/>

<div class="jumbotron">
    <div class="container">
        <h1>欢迎使用该学生管理系统!</h1>
        <p>creator: 陈晨 钟京华 刘衍伦 曾渝 郭晏桐</p>
            <p><a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/back/login.jsp"
                  target="_top" role="button">点击登录</a></p>
        <p>陈晨:  用springboot将前后端联合</p>
        <div class="progress">
            <div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuenow="20"
                 aria-valuemin="0" aria-valuemax="100" style="width: 100%">
                <span class="sr-only">20% Complete (success)</span>
            </div>
        </div>
        <p>钟京华: 使用mybatis，数据操作功能设计——查找&删除</p>
        <div class="progress">
            <div class="progress-bar progress-bar-info progress-bar-striped" role="progressbar" aria-valuenow="20"
                 aria-valuemin="20" aria-valuemax="100" style="width: 95%">
                <span class="sr-only">20% Complete</span>
            </div>
        </div>
        <p>刘衍伦: 使用mybatis，数据操作功能设计——增加&修改</p>
        <div class="progress">
            <div class="progress-bar progress-bar-warning progress-bar-striped" role="progressbar" aria-valuenow="20"
                 aria-valuemin="0" aria-valuemax="100" style="width: 95%">
                <span class="sr-only">20% Complete (warning)</span>
            </div>
        </div>
        <p>曾渝:  设计数据库&表，设计DAO，用户规划权限</p>
        <div class="progress">
            <div class="progress-bar progress-bar-danger progress-bar-striped" role="progressbar" aria-valuenow="20"
                 aria-valuemin="0" aria-valuemax="100" style="width: 95%">
                <span class="sr-only">20% Complete (danger)</span>
            </div>
        </div>
        <p>郭晏桐: jsp页面编写，接受后端传入的数据进行展示</p>
        <div class="progress">
            <div class="progress-bar progress-bar-primary progress-bar-striped" role="progressbar" aria-valuenow="20"
                 aria-valuemin="0" aria-valuemax="100" style="width: 95%">
                <span class="sr-only">20% Complete (danger)</span>
            </div>
        </div>
    </div>
</div>