<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<title>日历</title>
<link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../easyui/demo/demo.css"> 
	<script type="text/javascript" src="../easyui/jquery.min.js"></script>
	<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js"></script>
	<title>日历</title>
</head>
<body>
 	<!-- 添加用户的弹出框 -->
	<div id="win" class="easyui-window" title="添加日程" style="width:450px;height:400px"
		    data-options="iconCls:'icon-save',modal:true,resizable:false">
		    	<div style="margin-top:30px; margin-left:60px;">

		    	   <form id="ff" method="post" >
		    		<div style="margin-bottom:35px">
						<input class="easyui-textbox" name="remark" style="width:300px" data-options="label:'备注',required:true,missingMessage:'输入的值不能为空' ">
					</div>
		    		<div style="margin-bottom:35px">
						<input class="easyui-datebox" name="time" style="width:300px" data-options="label:'时间',required:true,missingMessage:'输入的值不能为空' ">
					</div>
					<div style="text-align:center;padding:5px 0">
					<a id="submit"  href="javascript:void(0)" class="easyui-linkbutton"  style="width:80px">Submit</a>
					<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">Clear</a>
					</div>
					</form>
				</div>

	</div>

	
	<div id="cc" class="easyui-calendar" style="width:1000px;height:500px;" fit="true" data-options="formatter:formatDay"></div>
	
	

	<script  type="text/javascript">
	
		$(function(){
			
			$("#win").window("close");
			
		})
		
			var list=null;
			$.ajax({
				async:false,
		        type: "POST",
		        url: "/OASystem/scheduleServlet/find",
		        dataType: "json",
		        success: function(data){
		           list=data;
		        }
		    });
		
			//日历显示
			var string = null;
			function formatDay(date){
			    var datetime = date.getTime();
				var d = date.getDate();
                for(var i=0;i<list.length;i++){
                    var time = parseInt(list[i].time);
                   if(time==datetime){
                       string = '<br/>'+list[i].remark;
                       return '<div>' + d +string+ '</div>';
				   }
                }
				return d;
			}

			//日历点击事件
			$('#cc').calendar({
				onSelect: function(date){
					$("#win").window("open");
					console.log(date)
						$("#submit").click(function () {
                            $("#ff").form('submit',
                                {
                                    url:"/OASystem/scheduleServlet/add ",
                                    type:"get",
                                    data:{"date":date},
                                    datatype:"json",
                                    success:function(data){
                                
                                        $('#ff').form("clear");
                                        // 关闭窗口
                                        $("#win").window("close");
                                        $("#cc").datagrid("reload");
                                    }
                                })
                        });
			 	}
			});
	</script>
	 
 
</body>
</html>