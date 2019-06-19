<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>标签管理</title>
<link rel="stylesheet" type="text/css" href="../easyui/themes/gray/easyui.css">
	<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../easyui/demo/demo.css"> 
	<script type="text/javascript" src="../easyui/jquery.min.js"></script>
	<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js"></script>
	<title>我的便签</title>
	<script type="text/javascript">
		$(function(){
			//进来就关闭添加用户的window页面
			$("#win").window('close');
			
			$("#wind").window('close');
			
			
			$('#dg').datagrid({
				url:"/OASystem/labelServlet/query",
			    fit:true,
			    async:false,
			    striped:true,
			    pagination:true,
			    rownumbers:true,
			    singleSelect:true,
			    toolbar: '#tb',	
			    columns:[[
					        {checkbox:true,field:""},
					        {field:'id',title:'编号',width:100},
							{field:'name',title:'标签名',width:200},
							{field:'time',title:'时间',width:200,formatter: function(value,row,index){
								if (row.time){
									var time = new Date(parseInt(row.time));
									var month = time.getMonth()+1;
									var day = time.getDate();
									if(month<10){month="0"+month;}
									if(day<10){day="0"+day;}
									return   time.getFullYear()+"-"+month+"-"+day;
								} else {
									return "无";
								}
							}
							}
					    ]],
					    
					    onClickRow: function(rowIndex, rowData){
					    	document.getElementById("sp").innerText ="";
						 	$("#win").window("open");
						 	$("div #sp").append(rowData.content);
						 	 
						}
			
		
			});	
			$("div #sp").innerHTML = "";
		});
	 
		
		function submitForm(){
		 	 
	 		$("#ff").form('submit',
	 			{
	 			url:"/OASystem/labelServlet/add ",
	 			success:function(data){
	 				if(data==0+""){
	 					$.messager.alert("提示","添加成功")
		 				$('#ff').form("clear");
		 				 
		 				$("#dg").datagrid("reload");
	 					
	 				}
	 				  $("#wind").window('close');
				
	 				
	 			}
	 		})
	 	}
		
		
		
		function remove(){
			 
	 		var row = $("#dg").datagrid("getSelected");
	 		if(row != null){
				$.messager.confirm('确认框', '你确定要删除这条数据吗?', function(r){
					if (r){
						$.get("/OASystem/labelServlet/delete",{"id":row.id},function(){
							$("#dg").datagrid("reload");
						})
					}
				});
	 		
	 		}else{
	 			$.messager.alert("操作错误","请勾选要删除的行信息")
	 		}
	 	}
		
		
	  function add(){
		  $("#wind").window("open");
	  }
	
	</script>

</head>
<body>
	<div id="wind" class="easyui-window" title="添加标签" style="width:450px;height:430px"
		    data-options="iconCls:'icon-save',modal:true,resizable:false">
		 <div style="margin-top:40px;margin-left:40px;">
		 	 <form id="ff" method="post" >
			    		<div style="margin-bottom:35px">
							<input class="easyui-textbox" name="name" style="width:300px" data-options="label:'标签名',required:true,missingMessage:'输入的值不能为空' ">
						</div>
						<div style="margin-bottom:35px">
							<input class="easyui-datebox" name="time" style="width:300px" data-options="label:'时间:',required:true,missingMessage:'输入的值不能为空'">
						</div>
						<div style="margin-bottom:35px">
							<input class="easyui-textbox" name="content" style="width:300px" data-options="label:'标签内容',required:true,missingMessage:'输入的值不能为空'">
						</div>
						
						<div style="text-align:center;padding:5px 0">
						<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">Submit</a>
						<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">Clear</a>
						</div>
				</form>
			</div>	
	</div>
	
	<div id="win" class="easyui-window" title="标签内容" style="width:450px;height:230px"
		    data-options="iconCls:'icon-save',modal:true,resizable:false">
		<span id="sp"></span>
	</div>
	
	<div id="tb">
		<a  href="javascript:void(0)" class="easyui-linkbutton"  onclick="add()"
		 data-options="iconCls:'icon-add',plain:true">添加</a>
		
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="remove()"
		 data-options="iconCls:'icon-remove',plain:true">删除</a>
		 
	</div>
	<table id="dg"></table>
</body>
</html>