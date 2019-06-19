<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="../easyui/themes/gray/easyui.css">
<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="../easyui/demo/demo.css">
<script type="text/javascript" src="../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js"></script>

	<script type="text/javascript">
	$(function() {
		$("#win").window("close");
		
		$('#dg').datagrid({
			url : '/OASystem/carapplyServlet/query',
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
				field : 'driver',
				title : '司机',
				width : 100,
				editor : 'textbox'
			}, {
				field : 'userName',
				title : '用车人',
				width : 100,
				editor : 'textbox'
			}, {
				field : 'companyer',
				title : '随行人员',
				width : 100,
				editor : 'textbox'
			},{
				field : 'dept',
				title : '用车部门',
				width : 100,
				editor : 'textbox'
			},{
				field : 'startDay',
				title : '开始日期',
				width : 100,
				editor : 'datebox',
				formatter: function(value,row,index){
					if (row.startDay){
						var time = new Date(parseInt(row.startDay));
						var month = time.getMonth()+1;
						var day = time.getDate();
						if(month<10){month="0"+month;}
						if(day<10){day="0"+day;}
						return   time.getFullYear()+"-"+month+"-"+day;
					} else {
						return "无";
					}
				}
			}, {
				field : 'endDay',
				title : '归还日期',
				width : 100,
				editor : 'datebox',
				formatter: function(value,row,index){
					if (row.endDay){
						var time = new Date(parseInt(row.endDay));
						var month = time.getMonth();
						var day = time.getDate();
						if(month<9){month="0"+month;}
						if(day<10){day="0"+day;}
						return   time.getFullYear()+"-"+month+"-"+day;
					} else {
						return "无";
					}
				}
			}, {
				field : 'destination',
				title : '目的地',
				width : 100,
				editor : 'textbox'
			}, {
				field : 'mileage',
				title : '申请里程',
				width : 100,
				editor : 'numberbox'
			}, {
				field : 'reason',
				title : '用车事由',
				width : 100,
				editor : 'textbox'
			}, {
				field : 'status',
				title : '审核状态',
				width : 100,
				editor : 'numberbox',styler: function(value,row,index){
					if (row.status == 1){
						return 'color:green;';
					}else if(row.status == 2){
						return 'color:red;';
					}
				},formatter:function(value,row,index){
					if(row.status == 0){
						return "未审批";
					}else if(row.status == 1){
						return "已审批";
					}else{
						return "驳回";
					}
				}}, {
				field : 'approver',
				title : '审核人',
				width : 100,
				editor : 'textbox'
			} ] ]
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
		    	$.get("/OASystem/carapplyServlet/update"
		    				,{"id":row.id
		    					,"driver":row.driver
		    					,"userName":row.userName
		    					,"carNumber":row.carNumber
		    					,"companyer":row.companyer
		    					,"dept":row.dept
		    					,"startDay":row.startDay
		    					,"endDay":row.endDay
		    					,"destination":row.destination
		    					,"mileage":row.mileage
		    					,"reason":row.reason
		    					,"status":row.status
		    					,"approver":row.approver}
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
					$.get("/OASystem/carapplyServlet/delete", {
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
			url : "/OASystem/carapplyServlet/add ",
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
<title>用车申请</title>
</head>
<body>
<!-- 添加用户的弹出框 -->
	<div id="win" class="easyui-window" title="添加用车申请" style="width:600px;height:600px"
		    data-options="iconCls:'icon-save',modal:true,resizable:false">
		
		    	<div style="margin-top:30px; margin-left:60px;">
		    	   <form id="ff" method="post" >
		    		<div style="margin-bottom:35px">
						<input class="easyui-textbox" name="userName" style="width:300px" data-options="label:'用车人',required:true,missingMessage:'输入的值不能为空' ">
					</div>
					<div style="margin-bottom:35px">
					    <input class="easyui-textbox" name="driver" style="width:300px" data-options="label:'司机',required:true,missingMessage:'输入的值不能为空' ">
					</div>
					<div style="margin-bottom:35px">
						<input class="easyui-textbox" name="companyer" style="width:300px" data-options="label:'随行人员',required:true,missingMessage:'输入的值不能为空'">
					</div>
					
					
					<div style="margin-bottom:35px">
						<input class="easyui-textbox" name="dept" style="width:300px" data-options="label:'用车部门',required:true,missingMessage:'输入的值不能为空'">
					</div>
					
					
					<div style="margin-bottom:35px">
						<input class="easyui-datebox" name="startDay" style="width:300px" data-options="label:'开始时间',required:true,missingMessage:'输入的值不能为空' ">
					</div>
					<div style="margin-bottom:35px">
						<input class="easyui-datebox" name="endDay" style="width:300px" data-options="label:'归还时间',required:true,missingMessage:'输入的值不能为空' ">
					</div>
					
					
					<div style="margin-bottom:35px">
						<input class="easyui-textbox" name="destination" style="width:200px" data-options="label:'目的地',required:true,missingMessage:'输入的值不能为空'">
						&nbsp;&nbsp;&nbsp;
						<input class="easyui-numberbox" name="mileage" style="width:200px" data-options="label:'申请里程',required:true,missingMessage:'输入的值不能为空'">
					</div>
					 <div style="margin-bottom:35px ">
					 <input class="easyui-textbox" data-options="label:'用车事由',multiline:true" name="reason" style="width:400px;height:100px" >
					 </div>
					<div style="text-align:center;padding:5px 0">
					<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">Submit</a>
					<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">Clear</a>
					</div>
					</form>
				</div>
	
	</div>
<div id="tb">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="add()"
			data-options="iconCls:'icon-add',plain:true">添加</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="goUpdate()" data-options="iconCls:'icon-edit',plain:true">修改</a>

		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="saveUpdate()" data-options="iconCls:'icon-save',plain:true">保存</a>

		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="remove()" data-options="iconCls:'icon-remove',plain:true">删除</a>

	</div>

	<table id="dg"></table>
</body>
</html>