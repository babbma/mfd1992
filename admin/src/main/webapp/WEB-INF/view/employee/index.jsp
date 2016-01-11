<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>后台管理系统</title>
<%@include file="/WEB-INF/imp/easyui.jsp"%>
<script type="text/javascript">
	$(function() {
		$('#mainMenu').tree({
			url : path+'/menu/getMenu',
			parentField : 'pid',
			onClick : function(node) {
				if (node.attributes.url) {
					var src = path + node.attributes.url;
					if (!$.startWith(node.attributes.url, '/')) {	//不是本项目的url，例如www.baidu.com
						src = node.attributes.url;
					}
					var tabs = $('#mainTabs');
					var opts = {
						title : node.text,
						closable : true,
						iconCls : node.iconCls,
						content : $.formatString('<iframe src="{0}" allowTransparency="true" style="border:0;width:100%;height:99%;" frameBorder="0"></iframe>', src),
						border : false,
						fit : true
					};
					if (tabs.tabs('exists', opts.title)) {
						tabs.tabs('select', opts.title);
					} else {
						tabs.tabs('add', opts);
					}
				}
			}
		});
	})
</script>

</head>
    <body class="easyui-layout">  
        <!-- 正上方panel -->  
        <div region="north" style="height:100px;padding:10px;background: #00a5a5;color: #fff;" >
        	<div style="line-height: 80px;font-size: 30px;letter-spacing: 3px;margin-left: 50px;float: left;text-align: center;">
        		后台管理系统
        	</div>
        	<div style="float:right;margin: 5px 50px 0 0;font-size:14px;color:#fff;">
        		欢迎您，${sessionScope.u.phone}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        		<a href="${path}/emp/logout" style="color: #fff;text-decoration: none;">退出</a>
        	</div>
        </div>  
        
		<!-- 左侧菜单 -->
        <div data-options="region:'west',href:''" title="导航" style="width: 200px; padding: 10px;">
			<ul id="mainMenu"></ul>
		</div>
		
        <!-- 正中间panel -->  
        <div region="center" title="功能区" >  
            <div class="easyui-tabs" id="mainTabs" fit="true" border="false">  
                <div title="欢迎页" style="padding:20px;overflow:hidden;">   
                    <div style="margin-top:20px;">  
                        <h3>你好，欢迎来到后台管理系统</h3>  
                    </div>  
                </div>  
            </div>  
        </div>  
        
        <!-- 正下方panel -->  
        <div region="south" style="height:50px;" align="center">  
            <label>作者：张春华
                	<br/>  
              	  时间：2016-01-07
            </label>  
        </div>  
    </body>
</html>
