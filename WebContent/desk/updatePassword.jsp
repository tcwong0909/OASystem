<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../easyui/themes/gray/easyui.css">
	<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../easyui/demo/demo.css">
	<script type="text/javascript" src="../easyui/jquery.min.js"></script>
	<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js"></script>
	<title>修改密码</title>
	<script type="text/javascript">
	function submitForm(){
	 	 
 		$("#ff").form('submit',
 			{
 			url:"/OASystem/updatePassword/update",
 			success:function(data){
 				if(data == 0+""){
 					$('#ff').form("clear");			 
 	 				$("#dg").datagrid("reload");
 	 				$.messager.alert("提示框","修改成功");
 				}else if(data == 1+""){
 					$.messager.alert("提示框","密码输入错误");
 					$("#dg").datagrid("reload");
 				}else if(data == 2+""){
 					$.messager.alert("提示框","新密码确认失败,请检查两次密码是否输入正确");
 					$("#dg").datagrid("reload");
 				}
 			
 			}
 		})
 	}
 	
 	function clearForm(){
 		$("#ff").form('clear');
 	}
	</script>
<title>修改密码</title>
</head>
<body>
		<div style="margin-top:30px; margin-left:60px;" border="0" class="easyui-panel" >
		    	   <form id="ff" method="post" >
				    		<div style="margin-bottom:35px">
								<input class="easyui-passwordbox" id="pass1" name="oldpassword" style="width:300px" data-options="label:'旧密码',required:true,missingMessage:'输入的值不能为空' ">
								${msg}
							</div>
							<div style="margin-bottom:35px">
								<input class="easyui-passwordbox"  id="pass2" name="password1" style="width:300px" data-options="label:'新密码:',required:true,missingMessage:'输入的值不能为空'">
							</div>
						
							<div style="margin-bottom:35px">
								<input class="easyui-passwordbox" id="pass3" name="password2" style="width:300px" data-options="label:'确认密码',required:true,missingMessage:'输入的值不能为空'">
								${sys}
							</div>
						 
						<div style="margin-left:150px;padding:5px 0">
						<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">提交</a>
						<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">重置</a>
						</div>
					</form>
		</div>
		<div id="viewer"></div>
		<script type="text/javascript">
		$('#pass1').passwordbox({
			inputEvents: $.extend({}, $.fn.passwordbox.defaults.inputEvents, {
				keypress: function(e){
					var char = String.fromCharCode(e.which);
					$('#viewer').html(char).fadeIn(200, function(){
						$(this).fadeOut();
					});
				}
			})
		})
		$('#pass2').passwordbox({
			inputEvents: $.extend({}, $.fn.passwordbox.defaults.inputEvents, {
				keypress: function(e){
					var char = String.fromCharCode(e.which);
					$('#viewer').html(char).fadeIn(200, function(){
						$(this).fadeOut();
					});
				}
			})
		})
		$('#pass3').passwordbox({
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