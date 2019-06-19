<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆界面</title>
	<link id="easyuiTheme" rel="stylesheet" type="text/css" href="easyui/themes/black/easyui.css"> 
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="easyui/demo/demo.css">
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>

<style type="text/css">
 	      
</style>

</head>
<body style="background-color:#2a3036">

	
	<div align="center" style="margin-top: 140px;margin-left: 300px;">
	
		<div style="margin-right: 800px;">
			<div style="color: #fefefe;font-size:35px;font-weight: bolder">Thanks for using</div>
			<div style="color: #a79781;font-size:15px;padding-top: 4px;">OASystem  is a appropriate work platform for you,</div>
			<div style="color: #a79781;font-size: 15px;">you can work more efficiently using it, </div>
			<div style="color: #fefefe;font-size: 13px;margin-left: 100px; font-style: oblique;font-weight: bolder;padding-top: 4px;">developed by Ly、Ps、TcWong</div>
		</div>
		<!-- <div style="margin:20px 0;"></div> -->
		<div class="easyui-panel" title="登陆"
			style="width: 400; max-width: 400px; padding: 30px 60px;">
			<form id="ff" method="post">
				<div style="margin-bottom: 20px">
					<input class="easyui-textbox"  name="loginName" style="width: 100%"
						data-options="label:'用户:',required:true,missingMessage:'输入的值不能为空'">
				</div>
				<div style="margin-bottom: 20px">
					<input class="easyui-passwordbox" id="pass"  name="password" style="width: 100%"
						data-options="label:'密码:',required:true,missingMessage:'输入的值不能为空'">
				</div>
				
			</form>
			<div style="text-align: center; padding: 5px 0">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					onclick="submitForm()" style="width: 80px">登录</a> <a
					href="javascript:void(0)" class="easyui-linkbutton"
					onclick="clearForm()" style="width: 80px">取消登录</a>
			</div>
			<div id="viewer"></div>
		</div>
	</div>
	<script>
		
	
		
	
		function submitForm() {
			$('#ff').form('submit', {
				url : "userServlet/login",
				success : function(data) {
					if (data == 0) {
						location.href = "home.jsp";
					} else {
						$.messager.alert('登录失败', '账号或者密码错误:' + data)
					}
				}
			});
		}

		function clearForm() {
			$('#ff').form('clear');
		}
	
	
	
		$('#pass').passwordbox({
			inputEvents: $.extend({}, $.fn.passwordbox.defaults.inputEvents, {
				keypress: function(e){
					var char = String.fromCharCode(e.which);
					$('#viewer').html(char).fadeIn(200, function(){
						$(this).fadeOut();
					});
				}
			})
		})
	</script>
	<style>
		#viewer{
			position: relative;
			padding: 0 60px;
			top: -70px;
			font-size: 54px;
			line-height: 60px;
		}
	</style>
</body>
</html>
	