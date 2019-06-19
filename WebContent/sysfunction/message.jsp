<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


	<link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../easyui/demo/demo.css"> 
	<script type="text/javascript" src="../easyui/jquery.min.js"></script>
	<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function(){
		$('#dg').datagrid({
		    url:'/OASystem/messageServlet/query ',
		    fit:true,
		    striped:true,
		  
		    rownumbers:true,
		    singleSelect:true,
		    //toolbar: '#tb',	
		    
		    pagination:true,
		    pageSize: 5,
		    pageList: [5, 10, 15, 20, 25],
		    
		    columns:[[
		        {checkbox:true,field:""},
		        {field:'id',title:'编号',width:100},
				{field:'user',title:'留言用户',width:100,editor:'textbox'},
				{field:'message',title:'留言',width:100,editor:'textbox'}
			 
		    ]]
		});

	})
		
	 	function remove(){
	 
	 		var row = $("#dg").datagrid("getSelected");
	 		if(row != null){
				$.messager.confirm('确认框', '你确定要删除这条数据吗?', function(r){
					if (r){
						$.get("/OASystem/messageServlet/delete",{"id":row.id},function(){
							$("#dg").datagrid("reload");
						})
					}
				});
	 		
	 		}else{
	 			$.messager.alert("操作错误","请勾选要删除的行信息")
	 		}
	 	}
	 	
	
</script>
</head>
<body>
		<div id="tb">
		 
		<a   href="javascript:void(0)" class="easyui-linkbutton" onclick="remove()"
		 data-options="iconCls:'icon-remove',plain:true">删除</a>
		    
		</div>
		
	
		<table id="dg"></table>
</body>
</html>