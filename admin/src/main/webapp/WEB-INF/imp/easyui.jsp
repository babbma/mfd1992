<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
<script type="text/javascript">
    var path = "${path}";
</script>

<!-- 引用Jquery的Js文件 -->
<script src="resource/js/jquery-easyui-1.4/jquery.min.js" type="text/javascript"></script>
<!-- 引用Easy UI的Js文件 -->
<script src="resource/js/jquery-easyui-1.4/jquery.easyui.min.js" type="text/javascript"></script>
<!-- 导入Easy UI的主题Css文件 -->
<link href="resource/js/jquery-easyui-1.4/themes/gray/easyui.css" rel="stylesheet" type="text/css" />
<!-- 导入Easy UI的图标Css文件 -->
<link href="resource/js/jquery-easyui-1.4/themes/icon.css" rel="stylesheet" type="text/css" />
<!-- 引用EasyUI的国际化文件,让它显示中文 -->
<script src="resource/js/jquery-easyui-1.4/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
<!-- 引入easyui扩展 -->
<script src="resource/js/jquery-easyui-1.4/extEasyUI.js" type="text/javascript"></script>
<!-- 扩展jQuery -->
<script src="resource/js/jquery-easyui-1.4/extJquery.js" type="text/javascript"></script>
<!-- 引入自己的js -->
<script src="resource/js/main.js" type="text/javascript"></script>
