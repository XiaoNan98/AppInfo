<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Stand
  Date: 2019-09-06
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>APP Manager</title>
</head>

<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <!-- left navigation -->
        <jsp:include page="nav/left_nav.jsp"/>
        <!-- /left navigation -->
        <!-- top navigation -->
        <jsp:include page="nav/top_nav.jsp"/>
        <!-- /top navigation -->

        <!-- 内容替换区域 -->
        <div class="right_col" role="main" id="content-area">
            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>APP 信息管理维护&nbsp;<i class="fa fa-user"></i><small>${userSession.devName}
                                -您可以通过搜索或者其它的筛选项对APP的信息进行修改、删除等管理操作O(∩_∩)O</small></h2>
                            <ul class="nav navbar-right panel_toolbox">
                                <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                                <li><a class="close-link"><i class="fa fa-close"></i></a></li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <br/>
                            <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left">
                                <ul>
                                    <li>
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12">软件名称</label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input type="text" name="softwareName" required="required"
                                                       class="form-control col-md-7 col-xs-12">
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12">APP状态</label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <select required="required" class="form-control col-md-7 col-xs-12">
                                                    <option value="0">--请选择--</option>
                                                    <c:forEach var="status" items="${list}">
                                                        <c:if test="${status.typeName == 'APP状态'}">
                                                            <option value="${status.valueId}">${status.valueName}</option>
                                                        </c:if>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12">所属平台</label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <select required="required" class="form-control col-md-7 col-xs-12">
                                                    <option value="0">--请选择--</option>
                                                    <c:forEach var="status" items="${list}">
                                                        <c:if test="${status.typeName == '所属平台'}">
                                                            <option value="${status.valueId}">${status.valueName}</option>
                                                        </c:if>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12">一级分类</label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <select required="required" class="form-control col-md-7 col-xs-12"
                                                        id="type1">
                                                    <option value="0">--请选择--</option>
                                                    <c:forEach var="category" items="${list2}">
                                                        <c:if test="${category.createdBy == 1}">
                                                            <option value="${category.id}">${category.categoryName}</option>
                                                        </c:if>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12">二级分类</label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <select required="required" class="form-control col-md-7 col-xs-12"
                                                        id="type2">

                                                </select>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12">三级分类</label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <select required="required" class="form-control col-md-7 col-xs-12"
                                                        id="type3">

                                                </select>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="form-group">
                                            <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                                <button type="submit" class="btn btn-primary"
                                                ">查询</button>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>Default Example <small>Users</small></h2>
                            <ul class="nav navbar-right panel_toolbox">
                                <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                </li>
                                <li><a class="close-link"><i class="fa fa-close"></i></a>
                                </li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <table id="datatable" class="table table-striped table-bordered">
                                <thead>
                                <tr>
                                    <th>软件名称</th>
                                    <th>APK名称</th>
                                    <th>软件大小(单位:M)</th>
                                    <th>所属平台</th>
                                    <th>所属分类(一级分类、二级分类、三级分类)</th>
                                    <th>状态</th>
                                    <th>下载次数</th>
                                    <th>最新版本号</th>
                                    <th>操作</th>
                                </tr>
                                </thead>

                                <tbody>
                                    <c:forEach var="appinfo" items="${list3}">
                                        <tr>
                                            <td>${appinfo.softwareName}</td>
                                            <td>${appinfo.apkName}</td>
                                            <td>${appinfo.softwareSize}</td>
                                            <td>${appinfo.valueName1}</td>
                                            <td>${appinfo.categoryName1}&gt;&gt;${appinfo.categoryName2}&gt;&gt;${appinfo.categoryName3}</td>
                                            <td>${appinfo.valueName2}</td>
                                            <td>${appinfo.downloads}</td>
                                            <td>${appinfo.versionId}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="statics/js/appinfolist.js"></script>
</html>
