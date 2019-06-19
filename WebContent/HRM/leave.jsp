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
			url : '/OASystem/leaveServlet/query',
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
			}, {
				field : 'dept',
				title : '所属部门',
				width : 100,
				editor : 'textbox'
			}, {
				field : 'startdate',
				title : '开始日期',
				width : 100,
				editor : 'datebox',
				formatter: function(value,row,index){
					if (row.startdate){
						var time = new Date(parseInt(row.startdate));
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
				field : 'enddate',
				title : '结束日期',
				width : 100,
				editor : 'datebox',
				formatter: function(value,row,index){
					if (row.enddate){
						var time = new Date(parseInt(row.enddate));
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
				field : 'leaveNumber',
				title : '请假天数',
				width : 100,
				editor : 'numberbox'
			}, {
				field : 'type',
				title : '请假类型',
				width : 100,
				editor : 'numberbox',formatter:function(value,row,index){
					if(row.type == 1){
						return "病假";
					}else if(row.type == 2){
						return "事假";
					}else if(row.type == 3){
						return "婚假";
					}else if(row.type == 4){
						return "丧假";
					}else if(row.type == 5){
						return "产假";
					}else if(row.type == 6){
						return "工伤假";
					}else if(row.type == 7){
						return "父亲假";
					}else if(row.type == 8){
						return "年假";
					}else{
						return "无信息";
					}
				}
			}, {
				field : 'reason',
				title : '请假理由',
				width : 100,
				editor : 'textbox'
			}, {
				field : 'approver',
				title : '审核人',
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
				}
			}  ] ]
		});
		
	})

	  var index = -1;
	    // 进入编辑状态
	    function goUpdate(){
	    	// 获取选中的行 getSelected
	    	var row = $("#dg").datagrid("getSelected");
	    	if(row != null){
	    		// 将index对应的行关闭编辑状态
	    		$("#dg").datagrid("endEdit",index);
	    		// 获取row对应的index
		    	index = $("#dg").datagrid("getRowIndex",row);
		    	// 进入编辑状态
		    	$("#dg").datagrid("beginEdit",index);
	    	}else{
	    		$.messager.alert('操作错误','请勾选要修改的行记录');
	    	}
	    	
	    }
	    // 保存修改的数据
	    function saveUpdate(){
	    	// 获取选中的行 getSelected
	    	var row = $("#dg").datagrid("getSelected");
	    	if(row != null){
	    		// 获取row对应的index
		    	index = $("#dg").datagrid("getRowIndex",row);
		    	// 结束编辑状态
		    	$("#dg").datagrid("endEdit",index);
		    	// 将修改的数据提交到服务器修改数据库中的数据
		    	console.log(row);
		    	$.get("/OASystem/leaveServlet/update"
		    				,{"id":row.id
		    					,"name":row.name
		    					,"dept":row.dept
		    					,"startdate":row.startdate
		    					,"enddate":row.enddate
		    					,"leaveNumber":row.leaveNumber
		    					,"type":row.type
		    					,"approver":row.approver
		    					,"reason":row.reason}
				    		,function(msg){
				    			//alert(msg);
				    			// 刷新页面
				    			$("#dg").datagrid("reload");
				    		}
				    	);
	    	}else{
	    		$.messager.alert('操作错误','请勾选要修改的行记录');
	    	}
	    }
	function remove() {

		var row = $("#dg").datagrid("getSelected");
		if (row != null) {
			$.messager.confirm('确认框', '你确定要删除这条数据吗?', function(r) {
				if (r) {
					$.get("/OASystem/leaveServlet/delete", {
						"id" : row.id
					}, function() {
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
			url : "/OASystem/leaveServlet/add ",
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
<title>请假管理</title>
</head>
<body>
	<!-- 添加用户的弹出框 -->
	<div id="win" class="easyui-window" title="添加请假申请" style="width:450px;height:400px"
		    data-options="iconCls:'icon-save',modal:true,resizable:false">
		
		    	<div style="margin-top:30px; margin-left:60px;">
		    	   <form id="ff" method="post" >
		    		<div style="margin-bottom:35px">
						<input class="easyui-textbox" name="name" style="width:300px" data-options="label:'请假人姓名',required:true,missingMessage:'输入的值不能为空' ">
					</div>
					<div style="margin-bottom:35px">
						<input class="easyui-textbox" name="dept" style="width:300px" data-options="label:'部门',required:true,missingMessage:'输入的值不能为空'">
					</div>
					<div style="margin-bottom:35px">
						<input class="easyui-datebox" name="startdate" style="width:300px" data-options="label:'开始时间',required:true,missingMessage:'输入的值不能为空' ">
					</div>
					<div style="margin-bottom:35px">
						<input class="easyui-datebox" name="enddate" style="width:300px" data-options="label:'结束时间',required:true,missingMessage:'输入的值不能为空' ">
					</div>
					
					<div style="margin-bottom:35px">
						<input class="easyui-numberbox" name="leaveNumber" style="width:300px" data-options="label:'请假天数',required:true,missingMessage:'输入的值不能为空'">
					</div>
					
					<div style="margin-bottom:35px">
					请假类型&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 <select name="type">
					 	<option>--请选择--</option>
					 	<option>1</option>
					 	<option>2</option>
					 	<option>3</option>
					 	<option>4</option>
					 	<option>5</option>
					 	<option>6</option>
					 	<option>7</option>
					 	<option>8</option>
					 </select>
					 </div>
					 <div style="margin:20px 0;">
	    				<input class="easyui-textbox" name="reason" data-options="multiline:true,label:'请假原因'"  style="width:300px;height:100px">
					
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