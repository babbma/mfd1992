/**
 * 搜索
 * 
 * @author 陈猛
 */
function goodsSearch(callback,obj){
	$("#"+obj).dialog({
		title:"项目搜索",
		iconCls:"icon-search",
		maximizable:false,
		resizale:true,
		width:1000,
		height:400,
		closed:false,
		cache:false,
		href:"../goods/search",
		modal:true,
		buttons:[{
			text:"\u63d0\u4ea4",
			handler:function(){
				if($("#goodsSearchDatagrid").datagrid("getSelections")==""){
					alert("\u8bf7\u9009\u62e9\u5546\u54c1\uff01");
					return 0;
				}else{
					var selectedGoods="[";
					var rows=$("#goodsSearchDatagrid").datagrid("getSelections");
					for(var i=0;i<rows.length;i++){
						selectedGoods+="{'goodsId':'"+rows[i].id+"',";
						selectedGoods+="'goodsTitle':'"+rows[i].goodsTitle+"'},";
					}
					selectedGoods=selectedGoods.substring(0,selectedGoods.length-1);
					selectedGoods+="]";
					$("#goodsSearchDatagrid").datagrid("clearSelections");
					$("#"+obj).dialog("close");
					eval(callback+"("+selectedGoods+")");
				}
			}},{
				text:"\u53d6\u6d88",handler:function(){
					$("#"+obj).dialog("close");
				}
			}]
	});
}
function goodsCategorySearch(callback,obj){
	$("#"+obj).dialog({
		title:"项目类别搜索",
		iconCls:"icon-search",
		maximizable:false,
		resizale:true,
		width:1000,
		height:400,
		closed:false,
		cache:false,
		href:"../goodsCategory/search",
		modal:true,
		buttons:[{
			text:"\u63d0\u4ea4",
			handler:function(){
				if($("#goodsCategorySearchDatagrid").datagrid("getSelections")==""){
					alert("\u8bf7\u9009\u62e9\u5546\u54c1\uff01");
					return 0;
				}else{
					var selectedGoodsCategory="[";
					var rows=$("#goodsCategorySearchDatagrid").datagrid("getSelections");
					for(var i=0;i<rows.length;i++){
						selectedGoodsCategory+="{'id':'"+rows[i].id+"',";
						selectedGoodsCategory+="'categoryName':'"+rows[i].categoryName+"'},";
					}
					selectedGoodsCategory=selectedGoodsCategory.substring(0,selectedGoodsCategory.length-1);
					selectedGoodsCategory+="]";
					$("#goodsCategorySearchDatagrid").datagrid("clearSelections");
					$("#"+obj).dialog("close");
					eval(callback+"("+selectedGoodsCategory+")");
				}
			}},{
				text:"\u53d6\u6d88",handler:function(){
					$("#"+obj).dialog("close");
				}
			}]
	});
}
function repayTypeSearch(callback,obj){
	$("#"+obj).dialog({
		title:"项目搜索",
		iconCls:"icon-search",
		maximizable:false,
		resizale:true,
		width:1000,
		height:400,
		closed:false,
		cache:false,
		href:"../repayType/search",
		modal:true,
		buttons:[{
			text:"\u63d0\u4ea4",
			handler:function(){
				if($("#repayTypeSearchDatagrid").datagrid("getSelections")==""){
					alert("\u8bf7\u9009\u62e9\u5546\u54c1\uff01");
					return 0;
				}else{
					var selectedRepayType="[";
					var rows=$("#repayTypeSearchDatagrid").datagrid("getSelections");
					for(var i=0;i<rows.length;i++){
						selectedRepayType+="{'id':'"+rows[i].id+"',";
						selectedRepayType+="'typeName':'"+rows[i].typeName+"'},";
					}
					selectedRepayType=selectedRepayType.substring(0,selectedRepayType.length-1);
					selectedRepayType+="]";
					$("#repayTypeSearchDatagrid").datagrid("clearSelections");
					$("#"+obj).dialog("close");
					eval(callback+"("+selectedRepayType+")");
				}
			}},{
				text:"\u53d6\u6d88",handler:function(){
					$("#"+obj).dialog("close");
				}
			}]
	});
}
function pointsGoodsSearch(callback,obj){
	$("#"+obj).dialog({
		title:"积分商品搜索",
		iconCls:"icon-search",
		maximizable:false,
		resizale:true,
		width:1000,
		height:400,
		closed:false,
		cache:false,
		href:"../pointsGoods/search",
		modal:true,
		buttons:[{
			text:"\u63d0\u4ea4",
			handler:function(){
				if($("#pointsGoodsSearchDatagrid").datagrid("getSelections")==""){
					alert("\u8bf7\u9009\u62e9\u5546\u54c1\uff01");
					return 0;
				}else{
					var selectedGoods="[";
					var rows=$("#pointsGoodsSearchDatagrid").datagrid("getSelections");
					for(var i=0;i<rows.length;i++){
						selectedGoods+="{'pointsGoodsId':'"+rows[i].id+"',";
						selectedGoods+="'pointsGoodsTitle':'"+rows[i].proName+"'},";
					}
					selectedGoods=selectedGoods.substring(0,selectedGoods.length-1);
					selectedGoods+="]";
					$("#pointsGoodsSearchDatagrid").datagrid("clearSelections");
					$("#"+obj).dialog("close");
					eval(callback+"("+selectedGoods+")");
				}
			}},{
				text:"\u53d6\u6d88",handler:function(){
					$("#"+obj).dialog("close");
				}
			}]
	});
}
