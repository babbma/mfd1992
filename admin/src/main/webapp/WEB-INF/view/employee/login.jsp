<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<title>后台管理系统</title>
<%@include file="/WEB-INF/imp/meta.jsp"%>
<%@include file="/WEB-INF/imp/easyui.jsp"%>

<link rel="stylesheet" type="text/css" href="${path}/resource/css/styles.css">

</head>
<body>
	<div class="wrapper">
		<div class="container">
			<h1>后台管理系统</h1>
			<form class="form" action="${path}/emp/login" method="post">
				<input type="text" placeholder="请输入用户名" id="phone" name="phone" required="required">
				<input type="password" placeholder="请输入密码" id="pwd" name="pwd" required="required">
				<button type="submit" id="login-button">登录</button>
			</form>
			<c:if test="${message!=null}">
				${message}
			</c:if>
		</div>
		
		<ul class="bg-bubbles">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
		
	</div>
<!-- <script type="text/javascript" src="${path}/js/jquery-2.1.1.min.js"></script> -->
<script type="text/javascript">
$('#login-button').click(function(event){
	//event.preventDefault();
	$('form').fadeOut(500);
	$('.wrapper').addClass('form-success');
});
</script>
</body>
</html>