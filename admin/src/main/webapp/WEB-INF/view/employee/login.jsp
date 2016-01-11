<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	<%-- <%@ include file="/WEB-INF/imp/bootstrap.jsp" %> --%>
	<script type="text/javascript">
	$(function(){
		$('#from_login').validate({
			rules:{
				'phone':{
					required:true,
					maxlength:11,
					minlength:5
					},
				'pwd':{
					required:true,
					maxlength:10,
					minlength:5
				}
			}
		});
	});
	</script>
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
			
			<form class="form-signin" action="emp/login" method="post" id="from_login">
				<h2 class="form-signin-heading">后台系统登录</h2>
				<input name="phone" type="text" class="input-block-level" placeholder="手机号码或者用户名">
				<input name="pwd" type="password" class="input-block-level" placeholder="密码">
				<label class="checkbox">
					<input type="checkbox" value="remember-me"> 记住用户
				</label>
				<button class="btn btn-large btn-primary" type="submit">登录</button>
			</form>
			<c:if test="${msg!=null }">
				<p>错误信息,${msg }</p>
			</c:if>
		</div>
</body>
</html>