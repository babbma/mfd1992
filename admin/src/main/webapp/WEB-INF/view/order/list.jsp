<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单列表</title>
<%@include file="/WEB-INF/imp/meta.jsp"%>
<%@include file="/WEB-INF/imp/easyui.jsp"%>
<script type="text/javascript">
function saveGoodsCategory(){
	var params = $('#fm').serialize();
	var obj ={};
	var s = params.split('&');
	for(var i =0 ;i < s.length ;i ++){
		var vk = s[i].split('=');
		obj[vk[0]]= vk[1];
	}
 	$('#datagrid').datagrid('load',obj);
}	

</script>
</head>
<body class="easyui-layout" fit="true">
	<div region="center" border="false" style="overflow: hidden;">
		<!-- 订单信息 -->
		<table id="datagrid" title="订单列表" class="easyui-datagrid" fit="true"
			url="order/list" toolbar="#toolbar" pagination="true"
			fitColumns="true" singleSelect="true" rownumbers="true"
			idField="id" border="false" nowrap="false">
			<thead>
				<tr>
					<th field="order" width="100" data-options="formatter:function(value,row,index){return value.code;}">订单编号</th>
					<th field="product" width="100" data-options="formatter:function(value,row,index){return value.code;}">商品名称</th>
					<th field="product" width="100" data-options="formatter:function(value,row,index){return value.code;}">抛货单价</th>
					<th field="orderList" width="100" data-options="formatter:function(value,row,index){return value.code;}">订单数量</th>
					<th field="order" width="100" data-options="formatter:function(value,row,index){return value.code;}">订单时间</th>
					<th field="order" width="100" data-options="formatter:function(value,row,index){return value.code;}">总金额</th>
					<th field="order" width="100" data-options="formatter:function(value,row,index){return value.code;}">运费</th>
					<th field="store" width="100" data-options="formatter:function(value,row,index){return value.code;}">配送地区</th>
					<th field="dealer" width="100" data-options="formatter:function(value,row,index){return value.code;}">经销商</th>
					<th field="store" width="100" data-options="formatter:function(value,row,index){return value.code;}">门店</th>
					<th field="order" width="100" data-options="formatter:function(value,row,index){return value.code;}">状态</th>
				</tr>
			</thead>
		</table>

		<!-- 按钮 -->
		<div id="toolbar">
			<form action="order/list" id="fm">
				<div class="row">
					<label>开始时间：</label><input name="beginTime" type="text" class="easyui-datebox" ></input> 
					<label>结束时间：</label><input name="endTime" type="text" class="easyui-datebox" ></input> 
				</div>
				<div class="row">
					<label>订单状态：</label><select name="status" class="easyui-combobox">
						<option value="-1">==全部==</option>
						<option value="0">未付款</option>
						<option value="1">未发货</option>
						<option value="2">已发货</option>
						<option value="3">已确认（交易完成）</option>
						<option value="4">申请退款</option>
						<option value="5">已退款</option>
					</select>
				</div>
				<div class="row">
					<label>订单号：</label><input type="text" name="likeCode" class="easyui-textbox" data-options="prompt:'支持模糊查询'"/>
					<label>经销商名称：</label> <input type="text" name="likeDealer" class="easyui-textbox" data-options="prompt:'支持模糊查询'"/>
					<label>门店名称：</label> <input type="text" name="likeStore" class="easyui-textbox" data-options="prompt:'支持模糊查询'"/>
					<a href="javascript:void(0);" class="easyui-linkbutton" 
					iconCls="icon-search" plain="true" onclick="saveGoodsCategory();" >查询</a><a
						href="javascript:void(0);" class="easyui-linkbutton"
						iconCls="icon-reload" plain="true" onclick="javascript:$('#datagrid').datagrid('reload');">刷新列表</a>
				</div>
			</form>
			
		</div>
	</div>
</body>
</html>