<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../easyui/demo/demo.css"> 
	<script type="text/javascript" src="../easyui/jquery.min.js"></script>
	<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js"></script>
 
	
	<script type="text/javascript">
	$(function(){
		 
		$('#dg').datagrid({
		    url:'/OASystem/logServlet/query',
		    fit:true,
		    striped:true,
		    pagination:true,
		    rownumbers:true,
		    singleSelect:true,
		    toolbar: '#tb',	
		    pageSize: 5,
		    pageList: [5, 10, 15, 20, 25],
		    columns:[[
		        {checkbox:true,field:""},
		        {field:'id',title:'编号',width:100},
				{field:'operator',title:'操作者',width:100,editor:'textbox'},
				{field:'operation',title:'操作事件',width:300,editor:'textbox'},
				{field:'remark',title:'备注',width:100, editor:'numberbox'},
				{field:'time',title:'操作时间',width:300, editor:'numberbox',formatter: function(value,row,index){
					if (row.time){
						var time = new Date(parseInt(row.time));
						var month = time.getMonth()+1;
						var day = time.getDate();
						if(month<10){month="0"+month;}
						if(day<10){day="0"+day;}
						return time.getFullYear()+"-"+month+"-"+day;
					} else {
						return "无";
					}
				}}
		    ]]
		});
	})
 
 	 
	</script>
	
<title>操作日志</title>
	
</head>
<body>
	 
	<table id="dg"></table>
</body>
</html>