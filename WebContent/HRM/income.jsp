<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="../easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="../easyui/demo/demo.css">
<script type="text/javascript" src="../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="../easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript">
	$(function() {
		//进来就关闭添加用户的window页面
		$("#win").window('close');
		$('#dg').datagrid({
			url : '/OASystem/incomeSerclet/query',
			fit : true,
			striped : true,
			pagination : true,
			rownumbers : true,
			singleSelect : true,
			columns : [ [ {
				checkbox : true,
				field : ""
			}, {
				field : 'id',
				title : '编号',
				width : 100
			}, {
				field : 'name',
				title : '姓名',
				width : 100,
				editor : 'textbox'
			},{
				field : 'applyDay',
				title : '申请日期',
				width : 100,
				editor : 'datebox',
				formatter: function(value,row,index){
					if (row.applyDay){
						var time = new Date(parseInt(row.applyDay));
						var month = time.getMonth()+1;
						var day = time.getDate();
						if(month<10){month="0"+month;}
						if(day<10){day="0"+day;}
						return time.getFullYear()+"-"+month+"-"+day;
					} else {
						return "无";
					}
				}
			}, {
				field : 'dept',
				title : '所属部门',
				width : 100,
				editor : 'textbox'
			}, {
				field : 'job',
				title : '岗位',
				width : 100,
				editor : 'textbox'
			}, {
				field : 'applicationReason',
				title : '申请理由',
				width : 100,
				editor : 'textbox'
			}, {
				field : 'status',
				title : '审核状态',
				width : 100,
				editor : 'textbox',
				styler: function(value,row,index){
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
				}},{
				field : 'approver',
				title : '审核人',
				width : 100,
				editor : 'textbox'
			} ] ]
		});
		
	})

	var index = -1;
	function goUpdate() {

		var row = $("#dg").datagrid("getSelected");
		if (row != null) {
			$("#dg").datagrid("endEdit", index);
			index = $("#dg").datagrid("getRowIndex", row);
			$("#dg").datagrid("beginEdit", index);
		} else {
			$.messager.alert("操作错误", "请选中一行")

		}
	}

	function saveUpdate() {

		var row = $("#dg").datagrid("getSelected");
		console.log(row)
		if (row != null) {

			$("#dg").datagrid("endEdit", index);
			$.get("/OASystem/incomeSerclet/update", {
				"id" : row.id,
				"name" : row.name,
				"applyDay" : row.applyDay,
				"dept" : row.dept,
				'job' : row.job,
				'applicationReason' : row.applicationReason,
				'approver' : row.approver
			}, function(msg) {
				$("#dg").datagrid("reload");
			})

		} else {
			$.messager.alert("操作错误", "请选择你要保存的数据")
		}
	}

	function remove() {

		var row = $("#dg").datagrid("getSelected");
		if (row != null) {
			$.messager.confirm('确认框', '你确定要删除这条数据吗?', function(r) {
				if (r) {
					$.get("/OASystem/incomeSerclet/delete",{"id":row.id},function(){
						$("#dg").datagrid("reload");
					})
				}
			});

		} else {
			$.messager.alert("操作错误", "请勾选要删除的行信息")
		}
	}

	function add() {
		$("#win").window("open");
	}

	function submitForm() {

		$("#ff").form('submit', {
			url : "/OASystem/incomeSerclet/add ",
			success : function(data) {
				$('#ff').form("clear");
				// 关闭窗口
				$("#win").window("close");
				$("#dg").datagrid("reload");
			}
		})
	}

	function clearForm() {
		$("#ff").form('clear');
	}
	

</script>
<title>收入管理</title>
</head>
<body>
	<!-- 添加用户的弹出框 -->
	<div id="win" class="easyui-window" title="添加收入证明申请" style="width:450px;height:400px"
		    data-options="iconCls:'icon-save',modal:true,resizable:false">
		
		    	<div style="margin-top:30px; margin-left:60px;">
		    	   <form id="ff" method="post" >
		    		<div style="margin-bottom:35px">
						<input class="easyui-textbox" name="name" style="width:300px" data-options="label:'申请人姓名',required:true,missingMessage:'输入的值不能为空' ">
					</div>
					
					<div style="margin-bottom:35px">
						<input class="easyui-datebox" name="applyDay" style="width:300px" data-options="label:'申请日期',required:true,missingMessage:'输入的值不能为空' ">
					</div>
					
					
					<div style="margin-bottom:35px">
						<input class="easyui-textbox" name="dept" style="width:300px" data-options="label:'所属部门',required:true,missingMessage:'输入的值不能为空'">
					</div>
					
					<div style="margin-bottom:35px">
						<input class="easyui-textbox" name="job" style="width:300px" data-options="label:'岗位',required:true,missingMessage:'输入的值不能为空'">
					</div>
					 
					 <div style="margin:20px 0;">
	    				<input class="easyui-textbox" name="applicationReason" data-options="multiline:true,label:'申请原因'"  style="width:300px;height:100px">
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