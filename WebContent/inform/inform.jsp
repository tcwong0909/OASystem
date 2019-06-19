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
	    	$("#win").window('close');
	    	$('#dg').datagrid({
		        url:'/OASystem/informServlet/findAll',
		        fit:true,
		        striped:true,
		        pagination:true,
		        rownumbers:true,
		        singleSelect:true,
		    	rowStyler: function(index,row){
		    		if (row.unitcost>80){
		    			return 'background-color:#6293BB;color:#fff;'; // return inline style
		    			// the function can return predefined css class and inline style
		    			// return {class:'r1', style:{'color:#fff'}};	
		    		}
		    	},
		        columns:[[
		            {checkbox:true,field:''},
		    		{field:'id',title:'编号',width:100},
		    		{field:'title',title:'标题',width:100,editor:'textbox'},
		    		{field:'content',title:'内容',width:100,editor:'textbox'},
		    		{field:'startDay',title:'开始时间',width:100,editor:'datebox', formatter: function(value,row,index){
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
					}},
		    		{field:'endDay',title:'结束时间',width:100, editor:'datebox',formatter: function(value,row,index){
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
		    		{field:'type',title:'类型',width:100, editor:'numberbox',styler: function(value,row,index){
						if (row.type == 0){
							return 'color:red;';
						}
					},formatter:function(value,row,index){
						if(row.type == 0){
							return "紧急";
						}else if(row.type == 1){
							return "一般";
						}else{
							return "无";
						}
					}},
		    		{field:'publisher',title:'发布人',width:100,editor:'textbox'},
		    		{field:'publishDay',title:'发布时间',width:100,editor:'datebox',  formatter: function(value,row,index){
						if (row.publishDay){
							var time = new Date(parseInt(row.publishDay));
							var month = time.getMonth()+1;
							var day = time.getDate();
							if(month<10){month="0"+month;}
							if(day<10){day="0"+day;}
							return   time.getFullYear()+"-"+month+"-"+day;
						} else {
							return "无";
						}
					}},
		        ]]
		    });
	    	
	    	 $('#dg').datagrid({
	    		onDblClickRow:function(rowIndex, rowData){
	    			$("#dg").datagrid("beginEdit",rowIndex);
	    		}
	    	});
	    	
	    });
	    
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
		    	$.get("/OASystem/informServlet/edit"
		    				,{"id":row.id
		    					,"title":row.title
		    					,"content":row.content
		    					,"startDay":row.startDay
		    					,"endDay":row.endDay
		    					,"publishDay":row.publishDay
		    					,"type":row.type
		    					,"publisher":row.publisher}
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
	    
	    function remove(){
	   	 
	 		var row = $("#dg").datagrid("getSelected");
	 		if(row != null){
				$.messager.confirm('确认框', '你确定要删除这条数据吗?', function(r){
					if (r){
						$.get("/OASystem/informServlet/delete",{"id":row.id},function(){
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
	 			url:"/OASystem/informServlet/add ",
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
</head>
<body style="border: 0px;">

	<!-- 添加用户的弹出框 -->
	<div id="win" class="easyui-window" title="添加便签" style="width:450px;height:400px"
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
					 
					<div style="text-align:center;padding:5px 0">
					<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">Submit</a>
					<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">Clear</a>
					</div>
					</form>
				</div>
	
	</div>

	<div id="tb">
		<a href="javascript:void(0)"  class="easyui-linkbutton" onclick="add()"
		data-options="iconCls:'icon-add',plain:true">添加</a>
		
		<a href="javascript:void(0)"  class="easyui-linkbutton" onclick="goUpdate()" 
		data-options="iconCls:'icon-edit',plain:true">修改</a>
		
		<a href="javascript:void(0)"  class="easyui-linkbutton" onclick="saveUpdate()" 
		data-options="iconCls:'icon-save',plain:true">保存</a>
		
		<a href="javascript:void(0)"  class="easyui-linkbutton" onclick="remove()"
		data-options="iconCls:'icon-remove',plain:true">删除</a>
	</div>
	<table id="dg"></table>
</body>
</html>