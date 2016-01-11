/**
 * 判断开始字符是否是XX
 * 
 * @author 陈猛
 */
$.startWith = function(source, str) {
	var reg = new RegExp("^" + str);
	return reg.test(source);
};

$.extend($.fn.validatebox.defaults.rules,{
	selectValueRequired:{
		validator:function(value,param){
			if(value=="" || value.indexOf("请选择")>=0){
				return false;
			}else{
				return true;
			}
		},message:"该下拉框为必选项"
	},mobile:{
		validator:function(value){
			var reg=/^1[3|4|5|8|9]d{9}$/;
			return reg.test(value);
		},message:"输入手机号码格式不准确"
	},equalTo:{
		validator:function(value,param){
			return $(param[0]).val() == value;
		},message:"字段不匹配"
	}
});

function myformatter(date){
	var y=date.getFullYear();
	var m=date.getMonth()+1;
	var d=date.getDate();
	return y+"-"+(m<10?("0"+m):m)+"-"+(d<10?("0"+d):d);
}

function myparser(s){
	if(!s)
		return new Date();
	var ss=(s.split("-"));
	var y=parseInt(ss[0],10);
	var m=parseInt(ss[1],10);
	var d=parseInt(ss[2],10);
	if(!isNaN(y) && !isNaN(m) && !isNaN(d)){
		return new Date(y,m-1,d);
	}else{
		return new Date();
	}
}




