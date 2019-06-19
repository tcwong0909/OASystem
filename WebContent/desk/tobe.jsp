<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
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
 	<title>待处理任务</title>
<script type="text/javascript">

$(function(){

	
	 $.ajax({
		url:"/OASystem/approveServlet/find",
		async:false,
		type:"get",
		dataType:"json",
		success:function(data){
			
			$.each(data,function(key,value){
				 
				//会议室申请
				if(key == "mtroomapply"){
				 
					$("#d1").append("<h1>会议室申请</h1>")
					$("#d1").append("<table id='"+key+"' border='1'  cellpadding='0' cellspacing='0'><tr>"
						+"<th>编号</th>"
						+"<th>开始时间</th>"
						+"<th>结束时间</th>"
						+"<th>预定人</th>"
						+"<th>用途类型</th>"
						+"<th>会议室编号</th>"
						+"<th>操作</th>"
						+"</tr></table>");	
					
					
					$.each(value,function(index){
						var date = new Date(value[index].startDay);
						var start = date.getFullYear()+"-"+date.getMonth()+"-"+date.getDate();
						
						var date = new Date(value[index].endDay);
						var end = date.getFullYear()+"-"+date.getMonth()+"-"+date.getDate();
						var type = null;
						if(value[index].type ==0){
							type="周议会";
						}else if(value[index].type ==1){
							type="面试";
						}else if(value[index].type ==2){
							type="考试";
						}
						
						var mtId =null;
						if(value[index].mtId ==1){
							mtId="A001";
						}else if(value[index].mtId ==2){
							mtId="A002";
						}else if(value[index].mtId ==3){
							mtId="A003";
						}else if(value[index].mtId ==4){
							mtId="A004";
						}
						$("#"+key).append("<tr>"
							+"<td>"+value[index].id+"</td>"+
							"<td>"+start+"</td>"+
							"<td>"+end+"</td>"+
							"<td>"+value[index].userName+"</td>"+
							"<td>"+type+"</td>"+
							"<td>"+mtId+"</td>"+
							"<td><input type='button' id='btn0' onclick='agreeM("+value[index].id+")' value='同意'/>"+
							"<input type='button' id='btn1' onclick='rejectM("+value[index].id+")' value='驳回'/></td>"+
							"</tr>");	
					})
					
					
					 
				}
				
			
				
				//请假申请
				if(key == "leaves"){
					$("#d2").append("<h1>请假申请</h1>")
					$("#d2").append("<table id='"+key+"' border='1'><tr>"
						+"<th>编号</th>"
						+"<th>请假人名称</th>"
						+"<th>所属部门</th>"
						+"<th>开始时间</th>"
						+"<th>结束时间</th>"
						+"<th>请假天数</th>"
						+"<th>请假类型</th>"
						+"<th>请假理由</th>"
						+"<th>操作</th>"
						+"</tr></table>");	
					 
					$.each(value,function(index){
						var date = new Date(value[index].startdate);
						var start = date.getFullYear()+"-"+date.getMonth()+"-"+date.getDate();
						
						var date = new Date(value[index].enddate);
						var end = date.getFullYear()+"-"+date.getMonth()+"-"+date.getDate();
						var type = null;
						if(value[index].type == 1){
							type="病假";
						}else if(value[index].type == 1){
							type="事假";
						}else if(value[index].type == 1){
							type="婚假";
						}else if(value[index].type == 1){
							type="丧假";
						}else if(value[index].type == 1){
							type="产假";
						}else if(value[index].type == 1){
							type="工伤假";
						}else if(value[index].type == 1){
							type="父亲假";
						}else if(value[index].type == 1){
							type="年假";
						}else {
							type="无";
						}
						
						$("#"+key).append("<tr>"
							+"<td>"+value[index].id+"</td>"+
							"<td>"+value[index].name+"</td>"+
							"<td>"+value[index].dept+"</td>"+
							"<td>"+start+"</td>"+
							"<td>"+end+"</td>"+
							"<td>"+value[index].leaveNumber+"</td>"+
							"<td>"+type+"</td>"+
							"<td>"+value[index].reason+"</td>"+
							"<td><input type='button' id='btn00' onclick='agreeL("+value[index].id+")' value='同意'/>"+
							"<input type='button' id='btn11' onclick='rejectL("+value[index].id+")' value='驳回'/></td>"+
							"</tr>");	
					})
					
					
				}
			 		
					
			})
			
		}
	})
	

})

	
	function agreeM(id){
	 
		 $.ajax({
			 url:"/OASystem/approveServlet/agree?type=mtr",
			 type:"get",
			 data:{"id":id,"status":1},
			 success:function(data){
				if(data==0+""){
					$.messager.alert("提示","同意了该申请")
				}else{
					$.messager.alert("提示","你已经处理了该申请")
				}
			}
		 })
	 }
	 
	 
	 function rejectM(id){
	 
		 $.ajax({
			 url:"/OASystem/approveServlet/reject?type=mtr",
			 type:"get",
			 data:{"id":id,"status":2},
			 success:function(data){ 
					if(data==0+""){
						$.messager.alert("提示","驳回了该申请")
					}else{
						$.messager.alert("提示","你已经处理了该申请")
					}
			}
		 })
	 }
	

		
		function agreeL(id){
	 
			 $.ajax({
				 url:"/OASystem/approveServlet/agree?type=lea",
				 type:"get",
				 data:{"id":id,"status":1},
				 success:function(data){
				 
					if(data==0+""){
						$.messager.alert("提示","同意了该申请")
					}else{
						$.messager.alert("提示","你已经处理了该申请")
					}
				}
			 })
		 }
		
		
	 	function rejectL(id){
	 	 
	 		 $.ajax({
				 url:"/OASystem/approveServlet/reject?type=lea",
				 type:"get",
				 data:{"id":id,"status":2},
				 success:function(data){
					 
					if(data==0+""){
						$.messager.alert("提示","驳回了该申请")
					}else{
						$.messager.alert("提示","你已经处理了该申请")
					}
				}
			 })
		 }
			 
</script>
</head>
<body>
	<div id="d1">
	 
	</div>
	<div id="d2">
	 
	</div>
	
</body>
</html>