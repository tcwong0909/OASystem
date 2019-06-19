<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../easyui/themes/gray/easyui.css">
	<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../easyui/demo/demo.css"> 
	<script type="text/javascript" src="../easyui/jquery.min.js"></script>
	<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js"></script>
	<title>通知公告</title>
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
							return  time.getFullYear()+"-"+month+"-"+day;
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
							return  time.getFullYear()+"-"+month+"-"+day;
						} else {
							return "无";
						}
					}},
		    		{field:'publishDay',title:'发布时间',width:100,editor:'datebox',  formatter: function(value,row,index){
						if (row.publishDay){
							var time = new Date(parseInt(row.publishDay));
							var month = time.getMonth()+1;
							var day = time.getDate();
							if(month<10){month="0"+month;}
							if(day<10){day="0"+day;}
							return  time.getFullYear()+"-"+month+"-"+day;
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
		    		{field:'publisher',title:'发布人',width:100,editor:'textbox'}
		        ]]
		    });
	    	
	    	 $('#dg').datagrid({
	    		onDblClickRow:function(rowIndex, rowData){
	    			$("#dg").datagrid("beginEdit",rowIndex);
	    		}
	    	});
	    	
	    });
	     
	</script>
</head>
<body style="border: 0px;">
  
	<table id="dg"></table>
</body>
</html>