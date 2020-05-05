<%--
  Created by IntelliJ IDEA.
  User: Jiu
  Date: 2020/2/18
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜单管理</title>
</head>
<!--如果使用frameset 的包含页面 主页面不能有body-->
<frameset cols="250,*" border="1">
    <frame src="${ctx}/sys/toMenuLeft.action" name="left">
    <frame src="${ctx}/sys/toMenuRight.action"name="right">
</frameset>
</html>
