<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../easyui/themes/gray/easyui.css">
	<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../easyui/demo/demo.css">
	<script type="text/javascript" src="../easyui/jquery.min.js"></script>
	<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js"></script>
	<title>工具</title>
	<script type="text/javascript">
			$(function(){
				$("#win").window("close");

				
				$.ajax({
					url:"/OASystem/webaddressServlet/query",
					async:false,
					dataType:"json",
					success:function(data){
						if(data.length==undefined){
							$.messager.alert("提示","你还没有添加过网址,快去添加吧!");
						}else{
							for(var i = 0; i <= data.length;i++){ 
								
								 $("#tab").append("<tr>"+
										 "<th height='50px'><a href='"+data[i].webaddress+"'>"+data[i].name+"</a></th>"+
										 "<th height='50px'><a href='"+data[i].webaddress+"'>"+data[i].webaddress+"</a></th>"+
										 "<th height='50px'><a href='javascript:void(0)' onclick='deleteById("+data[i].id+")'>删除</a></th>"+
										 "</tr>");
							 }  
							

						}
				  		
					}
				})
			
			})	
			
			function deleteById(id){
				 $.ajax({
					type:"get",
					url:"/OASystem/webaddressServlet/delete",
				 	data:{"id":id},
					success:function(data){
				 		if(data==0+""){
				 			
				 			$.messager.alert("提示","删除成功");
				 		}else{
				 			$.messager.alert("提示","删除失败..  未知错误  ");
				 		}
					}
				})  
				//$.get("/OASystem/webaddressServlet/delete",id);
				
			}

			
			function submitForm(){
	 	 
	 		$("#ff").form('submit',
	 			{
	 			url:"/OASystem/webaddressServlet/add ",
	 			type:"get",
	 			success:function(data){
	 				if(data==0+""){
			 			$.messager.alert("提示","添加成功");
			 		}else{
			 			$.messager.alert("提示","添加失败..  未知错误  ");
			 		}
			    	$("#win").window("close");			
	 				
	 			}
	 		})
	 	}
	 	
		
			function add(){
	 		$("#win").window("open");
	 	}
			
	</script>
<style scoped="scoped">
		.textbox{
			height:30px;
			width:200px;
			margin:0;
			padding:0 2px;
			box-sizing:content-box;
		}
	</style>
<title></title>
</head>
<body style="margin: 0; padding: 0;">
	<!-- 添加用户的弹出框 -->
	<div id="win" class="easyui-window" title="添加网址" style="width:450px;height:330px"
		    data-options="iconCls:'icon-save',modal:true,resizable:false">
		
		    	<div style="margin-top:30px; margin-left:60px;">
		    	   <form id="ff" method="post" >
		    		<div style="margin-bottom:35px">
						<input class="easyui-textbox" name="name" style="width:300px" data-options="label:'网址名:',required:true,missingMessage:'输入的值不能为空' ">
					</div>
					<div style="margin-bottom:35px">
						网址地址 :&nbsp;&nbsp;&nbsp;&nbsp;<input name="webaddress" class="easyui-validatebox textbox" data-options="required:true,validType:'url',novalidate:true">
					</div>
					 
					<div style="text-align:center;padding:5px 0">
					<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">Submit</a>
					<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">Clear</a>
					</div>
					</form>
				</div>
	
	</div>

	

	<div id="zd" style="margin:0;">
		<table id="tab" border="1"  cellpadding="0" cellspacing="0">
			<tr>
				<th width="100px" height="50px">网址</th>
				<th width="180px" height="50px">网址地址</th>
				<th width="100px" height="50px">操作</th>
			</tr>
		</table>
	</div>
	<br/>
	<div id="tb">
		<a  href="javascript:void(0)" class="easyui-linkbutton"  onclick="add()"
		 data-options="iconCls:'icon-add',plain:true">添加</a>
	</div>
</body>
</html>