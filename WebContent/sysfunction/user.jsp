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
		
		//进来就关闭添加用户的window页面
		$("#win").window('close');
		$('#dg').datagrid({
		    url:'/OASystem/userServlet/query',
		    fit:true,
		    striped:true,
		  
		    rownumbers:true,
		    singleSelect:true,
		    toolbar: '#tb',	
		    
		    pagination:true,
		    pageSize: 5,
		    pageList: [5, 10, 15, 20, 25],
		    
		    columns:[[
		        {checkbox:true,field:""},
		        {field:'id',title:'编号',width:100},
				{field:'loginName',title:'登录名',width:100,editor:'textbox'},
				{field:'realName',title:'真名',width:100,editor:'textbox'},
				{field:'sex',title:'性别',width:100, editor:'numberbox',formatter:function(value,row,index){
					if(row.sex == 0){
						return "男";
					}else if(row.sex == 1){
						return "女";
					}else{
						return "无";
					}
				}},
				{field:'roleId',title:'职位',width:100, editor:'numberbox',formatter:function(value,row,index){
					if(row.roleId == 1){
						return "普通用户";
					}else if(row.roleId == 2){
						return "人事专员";
					}else if(row.roleId == 3){
						return "系统管理员";
					}else if(row.roleId == 4){
						return "领导";
					}else{
						return "无";
					}
				}}
		    ]]
		});
	})
	
	 var index = -1;
	function goUpdate(){
		
		 var row = $("#dg").datagrid("getSelected");
		 if(row != null){
			 $("#dg").datagrid("endEdit",index);
			 index = $("#dg").datagrid("getRowIndex",row);
			 $("#dg").datagrid("beginEdit",index);
		 }else{
			 $.messager.alert("操作错误","请选中一行")
			 
		 }
	}
	
 	function saveUpdate(){
 
 		 var row = $("#dg").datagrid("getSelected");
 	 	 console.log(row)
 		 if(row != null){
 	 
 			 $("#dg").datagrid("endEdit",index);
 			 $.get("/OASystem/userServlet/update",
 			 {"id":row.id,
 			  "loginName":row.loginName,
 			  "password":row.password,
 			  "realName":row.realName,
				'sex':row.sex,
				'roleId':row.roleId
 			 },
 			function(msg){
 				$("#dg").datagrid("reload");
 			 }	 
 			 )
 			 
 		 }else{
 			$.messager.alert("操作错误","请选择你要保存的数据") 
 		 }
 	}
 	
 	
	 	function remove(){
	 
	 		var row = $("#dg").datagrid("getSelected");
	 		if(row != null){
				$.messager.confirm('确认框', '你确定要删除这条数据吗?', function(r){
					if (r){
						$.get("/OASystem/userServlet/delete",{"id":row.id},function(){
							$("#dg").datagrid("reload");
						})
					}
				});
	 		
	 		}else{
	 			$.messager.alert("操作错误","请勾选要删除的行信息")
	 		}
	 	}
	 	
	 	function add(){
	 		$("#win").window("open");
	 	}
	 	
	 	function submitForm(){
	 	 
	 		$("#ff").form('submit',
	 			{
	 			url:"/OASystem/userServlet/add ",
	 			success:function(data){
	 				$('#ff').form("clear");
	 				// 关闭窗口
			    	$("#win").window("close");
	 				$("#dg").datagrid("reload");
	 			}
	 		})
	 	}
	 	
	 	
	 	
	 	function clearForm(){
	 		$("#ff").form('clear');
	 	}
	
	</script>
	
<title>用户管理</title>
	
</head>
<body>
	<!-- 添加用户的弹出框 -->
	<div id="win" class="easyui-window" title="添加用户" style="width:450px;height:430px"
		    data-options="iconCls:'icon-save',modal:true,resizable:false">
		
		    	<div style="margin-top:30px; margin-left:60px;">
		    	   <form id="ff" method="post" >
		    		<div style="margin-bottom:35px">
						<input class="easyui-textbox" name="loginName" style="width:300px" data-options="label:'用户名:',required:true,missingMessage:'输入的值不能为空' ">
					</div>
					<div style="margin-bottom:35px">
						<input class="easyui-textbox" name="password" style="width:300px" data-options="label:'密码:',required:true,missingMessage:'输入的值不能为空'">
					</div>
					<div style="margin-bottom:35px">
						<input class="easyui-textbox" name="realName" style="width:300px" data-options="label:'真实名称',required:true,missingMessage:'输入的值不能为空'">
					</div>
					 
					<div style="margin-bottom:35px ">
					性别:   &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;  	 
					  男:<input type="radio"  name="sex"  value="0" checked="checked">
						    女: <input type="radio"  name="sex" value="1" >
					</div>
					 
					 <div style="margin-bottom:35px ">
					所属角色:   &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;   	 
					  <select name="roleId">
					  	<option>---请选择---</option>
					  	<option>1</option>
					  	<option>2</option>
					  	<option>3</option>
					  	<option>4</option>
					  </select>
					</div>
					<div style="text-align:center;padding:5px 0">
					<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">Submit</a>
					<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">Clear</a>
					</div>
					</form>
				</div>
	
	</div>
	<div id="tb">
		<a  href="javascript:void(0)" class="easyui-linkbutton"  onclick="add()"
		 data-options="iconCls:'icon-add',plain:true">添加</a>
		 
		 <a  href="javascript:void(0)" class="easyui-linkbutton" onclick="goUpdate()"
		 data-options="iconCls:'icon-edit',plain:true">修改</a>
		 
		<a   href="javascript:void(0)" class="easyui-linkbutton" onclick="saveUpdate()"
		 data-options="iconCls:'icon-save',plain:true">保存</a>
		 
		<a   href="javascript:void(0)" class="easyui-linkbutton" onclick="remove()"
		 data-options="iconCls:'icon-remove',plain:true">删除</a>
		    
	</div>
		
	<table id="dg"></table>
</body>
</html>
