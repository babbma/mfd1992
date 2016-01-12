<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员列表</title>
<%@include file="/WEB-INF/imp/meta.jsp"%>
<%@include file="/WEB-INF/imp/easyui.jsp"%>
<script type="text/javascript">
var url;
var mesTitle;
function addGoodsCategory(){
	$('#dlg').dialog('open').dialog('setTitle','新增管理员');
	$('#fm').form('clear');
	url = "emp/save";
	mesTitle = '新增管理员成功';
}

function editGoodsCategory(){
 	var row = $('#datagrid').datagrid('getSelected');
 	if (row){
 		var id = row.id;
	 	$('#dlg').dialog('open').dialog('setTitle','编辑管理员');
	 	$('#fm').form('load',row);//这句话有问题，第一次加载时正确的，第二次就出错了，还保持第一次的数据
	 	url = "emp/edit?id="+id;
	 	mesTitle = '编辑管理员成功';
 	}else{
 		$.messager.alert('提示', '请选择要编辑管理员！', 'error');
 	}
}

function deleteGoodsCategory(){
 	var row = $('#datagrid').datagrid('getSelected');
 	if (row){
 		if(!confirm("确定要删除所选的数据吗？")){
			return;
		}
 		var id = row.id;
	 	//$('#dlg').dialog('open').dialog('setTitle','删除项目类别');
	 	$('#fm').form('load',row);//这句话有问题，第一次加载时正确的，第二次就出错了，还保持第一次的数据
	 	url = "emp/delete?id="+id;
	 	saveGoodsCategory();
	 	mesTitle = '删除管理员成功';
 	}else{
 		$.messager.alert('提示', '请选择要删除的管理员！', 'error');
 	}
}
	
function saveGoodsCategory(){
 	$('#fm').form('submit',{
	 	url: url,
	 	onSubmit: function(){
	 		return $(this).form('validate');
	 	},
		success: function(result){
			/* console.info(result); */
			var result = eval('('+result+')');
			if (result.success){
			 	$('#dlg').dialog('close'); 
			 	$('#datagrid').datagrid('reload'); 
			} else {
				 mesTitle = '新增管理员失败';
			}
			$.messager.show({ 
				 title: mesTitle,
				 msg: result.msg
			});
		}
 	});
}	

</script>
</head>
<body class="easyui-layout" fit="true">
	<div region="center" border="false" style="overflow: hidden;">
		<!-- 用户信息列表 -->
		<table id="datagrid" title="管理员列表" class="easyui-datagrid" fit="true"
			url="emp/list" toolbar="#toolbar" pagination="true"
			fitColumns="true" singleSelect="true" rownumbers="true"
			idField="id" border="false" nowrap="false">
			<thead>
				<tr>
					<th field="jobNumber" width="100">工作号</th>
					<th field="phone" width="200">手机号码</th>
					<th field="name" width="200">姓名</th>
					<th field="area" width="200" data-options="formatter:function(value,row,index){return value.length;}">管理区域数量</th>
				</tr>
			</thead>
		</table>

		<!-- 按钮 -->
		<div id="toolbar">
			<a href="javascript:void(0);" class="easyui-linkbutton" 
			iconCls="icon-add" plain="true" onclick="addGoodsCategory();" >新增</a>
			 <a href="javascript:void(0);" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true" onclick="editGoodsCategory();">修改</a> <a
				href="javascript:void(0);" class="easyui-linkbutton"
				iconCls="icon-remove" plain="true" onclick="deleteGoodsCategory();">删除</a><a
				href="javascript:void(0);" class="easyui-linkbutton"
				iconCls="icon-reload" plain="true" onclick="javascript:$('#datagrid').datagrid('reload');">刷新列表</a>
		</div>

		<!-- 对话框 -->
		<div id="dlg" class="easyui-dialog"
			style="width:458px;height:229px;padding:10px 20px" closed="true"
			buttons="#dlg-buttons">
			<form id="fm" method="post" novalidate>
				<div class="fitem">
					<label>手机号码:</label> <input name="phone" class="easyui-textbox" size="20" required="true">
				</div>
				<div class="fitem">
					<label>管理区域:</label> <input name="area" class="easyui-combobox" size="20"
					data-options="valueField:'id',textField:'name',url:'area/plist',multiple:true,required:true"
					>
				</div>
				<div class="fitem">
					<label>工&nbsp;&nbsp;号:</label> <input name="jobNumber" class="easyui-textbox" size="20">
				</div>
				<div class="fitem">
					<label>密&nbsp;&nbsp;码:</label> <input name="pwd" type="password" class="easyui-textbox" size="20">
				</div>
				<div class="fitem">
					<label>姓&nbsp;&nbsp;名:</label> <input name="name" class="easyui-textbox" size="20" >
				</div>
				
			</form>
		</div>

		<!-- 对话框按钮 -->
		<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton c6"
				iconCls="icon-ok" onclick="saveGoodsCategory()" style="width:90px">保存</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')"
				style="width:90px">取消</a>
		</div>
	</div>
</body>
</html>