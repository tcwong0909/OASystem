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
		    url:'/OASystem/mtroomapplyServlet/find',
		    fit:true,
		    striped:true,
		    pagination:true,
		    rownumbers:true,
		    singleSelect:true,    
		    columns:[[
		        {checkbox:true,field:""},
		       /*  {field:'id',title:'申请表编号',width:100}, */
				{field:'startDay',title:'预定开始时间',width:100,editor:'datebox',formatter: function(value,row,index){
					if (row.startDay){
						var time = new Date(parseInt(row.startDay));
						var month = time.getMonth()+1;
						var day = time.getDate();
						if(month<10){month="0"+month;}
						if(day<10){day="0"+day;}
						return time.getFullYear()+"-"+month+"-"+day;
					} else {
						return "无";
					}
				}},
				{field:'endDay',title:'预定结束时间',width:100,editor:'datebox',formatter: function(value,row,index){
					if (row.endDay){
						var time = new Date(parseInt(row.endDay));
						var month = time.getMonth()+1;
						var day = time.getDate();
						if(month<10){month="0"+month;}
						if(day<10){day="0"+day;}
						return   time.getFullYear()+"-"+month+"-"+day;
					} else {
						return "无";
					}
				}},
				{field:'userName',title:'预订人',width:100,editor:'textbox'},
				{field:'type',title:'用途类型',width:100,editor:'numberbox'},
				{field:'mtId',title:'会议室id',width:100,editor:'textbox'},
				{field:'approver',title:'审批人',width:100,editor:'textbox'},
				{field:'status',title:'审批状态',width:100,styler: function(value,row,index){
					if (row.status == 2){
						return 'color:red;';
					}else if(row.status == 1){
						return 'color:green;';
					}
				},formatter:function(value,row,index){
					if(row.status == 0){
						return "未审批";
					}else if(row.status == 1){
						return "已审批";
					}else{
						return "驳回";
					}
				}},
		    ]]
		});
	})
	
	/* 编辑  */
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
	
	/* 保存 */
 	function saveUpdate(){
 		 var row = $("#dg").datagrid("getSelected");
 		 if(row != null){
 			index = $("#dg").datagrid("getRowIndex",row);
 			 $("#dg").datagrid("endEdit",index);
 			 console.log(row)
 			 $.get("/OASystem/mtroomapplyServlet/edit",
 			 {"id":row.id,
 			  "startDay":row.startDay,
 			  "endDay":row.endDay,
 			  "userName":row.userName,
 			  "type":row.type,
 			  "mtId":row.mtId,
 			  "approver":row.approver
 			 },
 			function(msg){
 				$("#dg").datagrid("reload");
 			 }	 
 			 )
 			 
 		 }else{
 			$.messager.alert("操作错误","请选择你要保存的数据") 
 		 }
 	}
 	
 	
	/* 删除 */
	 	function remove(){
	 
	 		var row = $("#dg").datagrid("getSelected");
	 		if(row != null){
				$.messager.confirm('确认框', '你确定要删除这条数据吗?', function(r){
					if (r){
						$.get("/OASystem/mtroomapplyServlet/remove",{"id":row.id},function(){
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
	 			url:"/OASystem/mtroomapplyServlet/add ",
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
	<div id="win" class="easyui-window" title="添加会议室申请" style="width:450px;height:400px"
		    data-options="iconCls:'icon-save',modal:true,resizable:false">
		
		    	<div style="margin-top:30px; margin-left:60px;">
		    	   <form id="ff" method="post" >
		    		<div style="margin-bottom:35px">
						<input class="easyui-datebox" name="startdate" style="width:300px" data-options="label:'开始时间',required:true,missingMessage:'输入的值不能为空' ">
					</div>
					<div style="margin-bottom:35px">
						<input class="easyui-datebox" name="enddate" style="width:300px" data-options="label:'结束时间:',required:true,missingMessage:'输入的值不能为空' ">
					</div>
					<div style="margin-bottom:35px">
					  用途类型&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 <select name="type">	
					 	<option>--请选择--</option>
					 	<option>0</option>
					 	<option>1</option>
					 	<option>2</option>
					 </select>
					 </div>
					
					<div style="margin-bottom:35px">
					会议室类型&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 <select name="roomtype">
					 	<option>--请选择--</option>
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
		<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="add()"
		 data-options="iconCls:'icon-add',plain:true">添加</a>
		 
		 <a href="javascript:void(0)" class="easyui-linkbutton" onclick="goUpdate()"
		 data-options="iconCls:'icon-edit',plain:true">修改</a>
		 
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="saveUpdate()"
		 data-options="iconCls:'icon-save',plain:true">保存</a>
		 
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="remove()"
		 data-options="iconCls:'icon-remove',plain:true">删除</a>
		  
	</div>
		
	<table id="dg"></table>
</body>
</html>
