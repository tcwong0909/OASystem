<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link id="easyuiTheme" rel="stylesheet" type="text/css" href="easyui/themes/gray/easyui.css"> 
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="easyui/demo/demo.css">
	<link rel="stylesheet" type="text/css" href="easyui/demo/sidemenu/sidemenu_style.css">
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	
	<title>home页面</title>

	<style type="text/css">
		.topNav
	    {
	        position:absolute;right:8px;top:12px;        
	        font-size:12px;
	    }
	    .topNav a
	    {
	        text-decoration:none;        
	        font-weight:normal;
	        font-size:12px;
	        margin-left:3px;
	        margin-right:3px;
	        color:#333;        
	    }
	    .topNav a:hover
	    {
	        text-decoration:underline;        
	    }
	    
	    #tt a{
	    	text-decoration:none;
	    	color:#000;
	    }   
		</style>
</head>
<body class="easyui-layout" id="cc">
	<!-- 添加用户的弹出框 -->
	<div id="win" class="easyui-window" title="添加留言" style="width:450px;height:300px"
		    data-options="iconCls:'icon-save',modal:true,resizable:false">
		
		    	<div style="margin-top:30px; margin-left:60px;">
		    	   <form id="ff" method="post" >
		    		<div style="margin-top:35px">
						<input class="easyui-textbox" name="message" style="width:300px;height:100px "  data-options="label:'留言:',multiline:true",required:true,missingMessage:'输入的值不能为空' ">
					</div>
					 
					  
					<div style="text-align:center;padding:5px 0">
					<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">Submit</a>
					<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">Clear</a>
					</div>
					</form>
				</div>
	
	</div>
			
		

		<!-- 头部 -->
		<!-- 增加注释测试 -->
		<div data-options="region:'north'" border:true,split:true"
			style="height: 100px; background-color: #ebebeb;">
			
			<h1 style="margin-left: 220px; margin-top: 30px; color: #3c3c3c;font-family: inherit;letter-spacing: 7px;">OA在线管理系统</h1>
			<div class="topNav" style="border: 0px red solid; width: 400px; height: 80px; line-height:80px; float: right;">
				<a href="#">首页</a>  | 
				<a href="#"> 在线示例 </a>| 
				 <a href="#">Api手册</a> | 
				 <a href="#">开发教程</a> | 
				<a href="#"> 快速入门 </a>| 
				<a href="logout"> 注销登陆 </a>
			</div>
			
		</div>
		
		<!-- 左侧导航栏 -->
		<div data-options="region:'west',title:'导航栏'" style="width: 175px; background-color: #2e2e2e;" >
			
			<div id="sm" class="easyui-sidemenu" data-options="data:data,border:false"  width ="175px"></div>
			
			
		</div>
		
		<!-- 右侧内容栏 -->
		 <div data-options="region:'east',title:'信息栏',split:true" style="width:400px;">
		 <!-- 日历 -->
		 <div>当前时间</div>
		 <div class="easyui-calendar" style="width:400px;height:350px;" data-options="formatter:formatDay"></div>
		 <div>登录记录</div>
		 <table class="easyui-datagrid">
		    <thead>
				<tr>
					<th data-options="field:'code'">登录人</th>
					<th data-options="field:'name'">登录ip</th>
					<th data-options="field:'price'">登录时间</th>
				</tr>
		    </thead>
		    <tbody>
				<tr>
					<td>${loginName}</td><td>${ip}</td><td>${time}</td>
				</tr>
			</tbody>
			</table>
		 
		 </div>
		
		
		<!-- 中间标签页 -->
		<div data-options="region:'center',border:false"
			style="padding: 0px;">
			<div id="tabs" class="easyui-tabs" data-options="fit:true,border:false" style="background-color: #f1f1f1;">
				  <div title="首页" style="padding:20px;display:none;">
			    		<div style="font-size: 18px;letter-spacing: 4px;margin-top: 40px;">欢迎<font color="red";style: italic;letter-spacing: 0;>${loginName}</font>光临  </div>
			    		<h1>OA办公系统是一个全新的办公平台</h1>
			    		<p style="margin-left: 50px;font-size: 16px;letter-spacing: 1px;font-family: -webkit-pictograph;">在这里你可以更有效的处理工作内容。</p>
			    		<p style="margin-left: 50px;font-size: 16px;letter-spacing: 1px;font-family: -webkit-pictograph;">OA办公系统同时会根据你当前工作职责，为你分配合理的工作空间。</p>
			    		<p style="margin-left: 50px;font-size: 16px;letter-spacing: 1px;font-family: -webkit-pictograph;">在您使用过程中有什么问题，请<a href="javascript:void(0)" onclick="addMessages()"> 点击这里</a>进行留言</p>
			    		<p style="margin-left: 50px;font-size: 16px;letter-spacing: 1px;font-family: -webkit-pictograph;">我们将会根据你反馈的意见及建议，及时作出回复</p>
			     </div> 
			</div>
		</div>

	<script type="text/javascript">
	$(function(){	
		//进来就关闭window页面
		$("#win").window('close');
  
	})
	
		function addMessages(){
	 		$("#win").window("open");
	 	}
	 	
	 	function submitForm(){
	 	 
	 		$("#ff").form('submit',
	 			{
	 			url:"/OASystem/messageServlet/add ",
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
	
	
	
		//日程标签变量
		var list=null;
		//权限id
		var roleId = null;
		//拼接日程显示内容
		var string = null;
		//获取日程备注请求
		$.ajax({
			async:false,
	        type: "POST",
	        url: "/OASystem/scheduleServlet/find",
	        dataType: "json",
	        success: function(data){
	           list=data;
	           //获取权限
	           async1();
	        }
	    });
	
		//日历显示
	 
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
		
		function async1(){  
			//获取权限
				$.ajax({
					async:false,
			        type: "POST",
			        url: "/OASystem/loginLimit/login",
			        dataType: "json",
			        success: function(data){
			        	roleId=data.roleId;
			        	console.log("权限"+roleId)
			        }
			    });
		}
		
		//菜单
		if(roleId==4){
			//菜单4
			var data = [{
		        text: '我的桌面',
		        iconCls: 'fa fa-wpforms',
		       /*  state: 'open', */
		        children: [{
		            text: '待处理任务',
		            src:'desk/tobe.jsp'
		        },{
		            text: '通知公告',
		            src:'desk/anno.jsp'
		        },{
		            text: '我的便签',
		            src:"desk/label.jsp"
		        },{
		        	text:'日程管理',
		        	src:"desk/schedule.jsp"
		        },{
		        	text:'常用工具',
		        	src:"desk/tool.jsp"
		        },{
		        	text:'修改密码',
		        	src:"desk/updatePassword.jsp"
		        }]
		    },{
		        text: '通告管理',
		        iconCls: 'fa fa-at',
		        selected: true,
		        children: [{
		            text: '发布通告',
		            src:"undeveloped/undeveloped.jsp"
		        },{
		            text: '通告列表',
		            src:"inform/inform.jsp"
		        }]
		        },{
			        text: '文档管理',
			        iconCls: 'fa fa-wpforms',
			      state: 'close',
			        children: [{
			            text: '添加文档',
			            src:"undeveloped/undeveloped.jsp"
			        },{
			            text: '文档列表',
			            src:'undeveloped/undeveloped.jsp'
			        }]
			    },{
		        text: '行政管理',
		        iconCls: 'fa fa-table',
		        state: 'open',
		        children: [{
		            text: '会议室管理',
			            children: [{
			                text: '会议室列表',
			                src:"meetingRoom/meetingRoom.jsp"
			            },{
			                text: '会议室申请',
			                src:"meetingRoom/meetingroomapply.jsp"
			            }]
			        },{
		            text: '用车管理',
			            children: [{
			                text: '车辆列表',
			                src:"CarManage/car.jsp"
			            },{
			                text: '车辆申请',
			                src:"CarManage/carapply.jsp"
			            }]
			        },{
		            text: '用章管理',
			            children: [{
			                text: '用章列表',
			                src:"SealManage/seal.jsp"
			            },{
			                text: '用章申请',
			                src:"SealManage/sealapply.jsp"
			            }]
			        },{
		            text: '图书借阅申请',
			            children: [{
			                text: '图书列表',
			                src:"BookManage/books.jsp"
			            },{
			                text: '图书借阅申请',
			                src:"BookManage/booksApply.jsp"
			            }]
			        },{
		            text: '名片印刷申请',
			            children: [{
			                text: '名片列表',
			                src:"CardManage/card.jsp"
			            },{
			                text: '名片印刷申请',
			                src:"CardManage/cardApply.jsp"
			            }]
			        }]
		    	},{
			        text: '人事管理',
			        iconCls: 'fa fa-wpforms',
			       /*  state: 'open', */
			        children: [{
			            text: '请假申请',
			            src:"HRM/leave.jsp"
			        },{
			            text: '出差申请',
			            src:'HRM/trip.jsp'
			        },{
			            text: '收入证明申请',
			            src:'HRM/income.jsp'
			        }]
			    },{
			        text: '系统管理',
			        iconCls: 'fa fa-wpforms',
			       /*  state: 'open', */
			        children: [{
			            text: '组织结构管理',
			            src:"undeveloped/undeveloped.jsp"
			        },{
			            text: '角色管理',
			            src:'sysfunction/role.jsp'
			        },{
			            text: '权限管理',
			            src:'sysfunction/function.jsp'
			        },{
			            text: '用户管理',
			            src:'sysfunction/user.jsp'
			        },{
			            text: '用户留言',
			            src:'sysfunction/message.jsp'
			        },{
			            text: '操作日志',
			            src:'sysfunction/operationLog.jsp'
			        }]
			    }
		    ];
			
		}else if(roleId==3){
			//菜单3
			var data = [{
		        text: '我的桌面',
		        iconCls: 'fa fa-wpforms',
		        state: 'open',
		        children: [{
		            text: '待处理任务',
		            src:'desk/tobe.jsp'
		        },{
		            text: '通知公告',
		            src:'desk/anno.jsp'
		        },{
		            text: '我的便签',
		            src:"desk/label.jsp"
		        },{
		        	text:'日程管理',
		        	src:"desk/schedule.jsp"
		        },{
		        	text:'常用工具',
		        	src:"desk/tool.jsp"
		        },{
		        	text:'修改密码',
		        	src:"desk/updatePassword.jsp"
		        }]
		    },{
			        text: '文档管理',
			        iconCls: 'fa fa-wpforms',
			        state: 'close',
			        children: [{
			            text: '添加文档',
			            src:"undeveloped/undeveloped.jsp"
			        },{
			            text: '文档列表',
			            src:'undeveloped/undeveloped.jsp'
			        }]
			    },{
		        text: '行政管理',
		        iconCls: 'fa fa-table',
		        children: [{
		            text: '会议室管理',
			            children: [{
			                text: '会议室列表',
			                src:"meetingRoom/meetingRoom.jsp"
			            },{
			                text: '会议室申请',
			                src:"meetingRoom/meetingroomapply.jsp"
			            }]
			        },{
		            text: '用车管理',
			            children: [{
			                text: '车辆列表',
			                src:"CarManage/car.jsp"
			            },{
			                text: '车辆申请',
			                src:"CarManage/carapply.jsp"
			            }]
			        },{
		            text: '用章管理',
			            children: [{
			                text: '用章列表',
			                src:"SealManage/seal.jsp"
			            },{
			                text: '用章申请',
			                src:"SealManage/sealapply.jsp"
			            }]
			        },{
		            text: '图书借阅申请',
			            children: [{
			                text: '图书列表',
			                src:"BookManage/books.jsp"
			            },{
			                text: '图书借阅申请',
			                src:"BookManage/booksApply.jsp"
			            }]
			        },{
		            text: '名片印刷申请',
			            children: [{
			                text: '名片列表',
			                src:"CardManage/card.jsp"
			            },{
			                text: '名片印刷申请',
			                src:"CardManage/cardApply.jsp"
			            }]
			        }]
		    	},{
			        text: '人事管理',
			        iconCls: 'fa fa-wpforms',
			       /*  state: 'open', */
			        children: [{
			            text: '请假申请',
			            src:"HRM/leave.jsp"
			        },{
			            text: '出差申请',
			            src:'HRM/trip.jsp'
			        },{
			            text: '收入证明申请',
			            src:'HRM/income.jsp'
			        }]
			    },{
			        text: '系统管理',
			        iconCls: 'fa fa-wpforms',
			       /*  state: 'open', */
			        children: [{
			            text: '组织结构管理',
			            src:"undeveloped/undeveloped.jsp"
			        },{
			            text: '角色管理',
			            src:'sysfunction/role.jsp'
			        },{
			            text: '权限管理',
			            src:'sysfunction/function.jsp'
			        },{
			            text: '用户管理',
			            src:'sysfunction/user.jsp'
			        },{
			            text: '操作日志',
			            src:'sysfunction/operationLog.jsp'
			        }]
			    }
		    ];
			
		}else if(roleId==2){
			//菜单2
			var data = [{
		        text: '我的桌面',
		        iconCls: 'fa fa-wpforms',
		        state: 'open',
		        children: [{
		            text: '待处理任务',
		            src:'desk/tobe.jsp'
		        },{
		            text: '通知公告',
		            src:'desk/anno.jsp'
		        },{
		            text: '我的便签',
		            src:"desk/label.jsp"
		        },{
		        	text:'日程管理',
		        	src:"desk/schedule.jsp"
		        },{
		        	text:'常用工具',
		        	src:"desk/tool.jsp"
		        },{
		        	text:'修改密码',
		        	src:"desk/updatePassword.jsp"
		        }]
		    },{
		        text: '通告管理',
		        iconCls: 'fa fa-at',
		        selected: true,
		        children: [{
		            text: '发布通告',
		            src:"undeveloped/undeveloped.jsp"
		        },{
		            text: '通告列表',
		            src:"inform/inform.jsp"
		        }]
		        },{
		        text: '行政管理',
		        iconCls: 'fa fa-table',
		        children: [{
		            text: '会议室管理',
			            children: [{
			                text: '会议室列表',
			                src:"meetingRoom/meetingRoom.jsp"
			            },{
			                text: '会议室申请',
			                src:"meetingRoom/meetingroomapply.jsp"
			            }]
			        },{
		            text: '用车管理',
			            children: [{
			                text: '车辆列表',
			                src:"CarManage/car.jsp"
			            },{
			                text: '车辆申请',
			                src:"CarManage/carapply.jsp"
			            }]
			        },{
		            text: '用章管理',
			            children: [{
			                text: '用章列表',
			                src:"SealManage/seal.jsp"
			            },{
			                text: '用章申请',
			                src:"SealManage/sealapply.jsp"
			            }]
			        },{
		            text: '图书借阅申请',
			            children: [{
			                text: '图书列表',
			                src:"BookManage/books.jsp"
			            },{
			                text: '图书借阅申请',
			                src:"BookManage/booksApply.jsp"
			            }]
			        },{
		            text: '名片印刷申请',
			            children: [{
			                text: '名片列表',
			                src:"CardManage/card.jsp"
			            },{
			                text: '名片印刷申请',
			                src:"CardManage/cardApply.jsp"
			            }]
			        }]
		    	},{
			        text: '人事管理',
			        iconCls: 'fa fa-wpforms',
			        /* state: 'open', */
			        children: [{
			            text: '请假申请',
			            src:"HRM/leave.jsp"
			        },{
			            text: '出差申请',
			            src:'HRM/trip.jsp'
			        },{
			            text: '收入证明申请',
			            src:'HRM/income.jsp'
			        }]
			    }
		    ];
		}else if(roleId==1){
			//菜单1
			var data = [{
		        text: '我的桌面',
		        iconCls: 'fa fa-wpforms',
		        state: 'open',
		        children: [{
		            text: '待处理任务',
		            src:'desk/tobe.jsp'
		        },{
		            text: '通知公告',
		            src:'desk/anno.jsp'
		        },{
		            text: '我的便签',
		            src:"desk/label.jsp"
		        },{
		        	text:'日程管理',
		        	src:"desk/schedule.jsp"
		        },{
		        	text:'常用工具',
		        	src:"desk/tool.jsp"
		        },{
		        	text:'修改密码',
		        	src:"desk/updatePassword.jsp"
		        }]
		    },{
		        text: '行政管理',
		        iconCls: 'fa fa-table',
		        children: [{
		            text: '会议室管理',
			            children: [{
			                text: '会议室列表',
			                src:"meetingRoom/meetingRoom.jsp"
			            },{
			                text: '会议室申请',
			                src:"meetingRoom/meetingroomapply.jsp"
			            }]
			        },{
		            text: '用车管理',
			            children: [{
			                text: '车辆列表',
			                src:"CarManage/car.jsp"
			            },{
			                text: '车辆申请',
			                src:"CarManage/carapply.jsp"
			            }]
			        },{
		            text: '用章管理',
			            children: [{
			                text: '用章列表',
			                src:"SealManage/seal.jsp"
			            },{
			                text: '用章申请',
			                src:"SealManage/sealapply.jsp"
			            }]
			        },{
		            text: '图书借阅申请',
			            children: [{
			                text: '图书列表',
			                src:"BookManage/books.jsp"
			            },{
			                text: '图书借阅申请',
			                src:"BookManage/booksApply.jsp"
			            }]
			        },{
		            text: '名片印刷申请',
			            children: [{
			                text: '名片列表',
			                src:"CardManage/card.jsp"
			            },{
			                text: '名片印刷申请',
			                src:"CardManage/cardApply.jsp"
			            }]
			        }]
		    	},{
			        text: '人事管理',
			        iconCls: 'fa fa-wpforms',
			        /* state: 'open', */
			        children: [{
			            text: '请假申请',
			            src:"HRM/leave.jsp"
			        },{
			            text: '出差申请',
			            src:'HRM/trip.jsp'
			        },{
			            text: '收入证明申请',
			            src:'HRM/income.jsp'
			        }]
			    }
		    ];
		}
	
		
		//标签管理
		$('#sm').sidemenu({
			onSelect:function(item){
				span = item.text;
			 	src= item.src;
			 	$('#cc').layout('collapse','east');
              goTabs(span,src);
              
			}
			
		})
		function goTabs(span,src){
			 $('#tabs').tabs('close',span);
			    $('#tabs').tabs('add',{
			        title:span,
			        content:'<iframe src='+ src+ ' width="100%" height="100%" style="border: 0px;"></iframe>',
			        closable:true
			    });
			}
	</script>
</body>
</html>