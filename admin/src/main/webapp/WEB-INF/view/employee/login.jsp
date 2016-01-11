<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>欢迎使用后台管理系统</title>
	<script type="text/javascript" src="resource/js/jquery-1.11.0.min.js"></script>
	<%@ include file="/WEB-INF/imp/validate.jsp" %>
	<%@ include file="/WEB-INF/imp/bootstrap.jsp" %>
</head>
<body>

		<div class="container">
			<!-- <s:if test="hasActionMessages()">
				<div class="row-fluid">
					<div class="span12">
						<div class="alert alert-info">
							 <button type="button" class="close" data-dismiss="alert">×</button>
							<h4>
								提示!
							</h4> <strong>提示!</strong> <s:property value="actionMessages"/>
						</div>
					</div>
				</div>
			</s:if>
			<s:if test="hasActionErrors()">
				<div class="row-fluid">
					<div class="span12">
						<div class="alert alert-error">
							 <button type="button" class="close" data-dismiss="alert">×</button>
							<h4>
								提示!
							</h4> <strong>警告!</strong> <s:property value="actionErrors"/>
						</div>
					</div>
				</div>
			</s:if> -->
			
			<form class="form-signin" action="emp/login" method="post">
				<h2 class="form-signin-heading">后台系统登录</h2>
				<input name="master.uname" type="text" class="input-block-level" placeholder="用户名">
				<input name="master.pwd" type="password" class="input-block-level" placeholder="密码">
				<label class="checkbox">
					<input type="checkbox" value="remember-me"> 记住用户
				</label>
				<button class="btn btn-large btn-primary" type="submit">登录</button>
			</form>

		</div>
</body>
</html>