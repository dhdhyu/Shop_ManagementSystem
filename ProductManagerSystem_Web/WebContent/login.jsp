<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>商品管理系统-登录</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="author" content="SuggeElson" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<meta name="application-name" content="sprFlat admin template" />
<link rel='stylesheet' type='text/css'
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,700|Droid+Sans:400,700' />
<link href="assets/css/icons.css" rel="stylesheet" />
<link href="assets/css/sprflat-theme/jquery.ui.all.css" rel="stylesheet" />
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<link href="assets/css/plugins.css" rel="stylesheet" />
<link href="assets/css/main.css" rel="stylesheet" />
<link href="assets/css/custom.css" rel="stylesheet" />
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="assets/img/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="assets/img/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="assets/img/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/img/ico/apple-touch-icon-57-precomposed.png">
<link rel="icon" href="assets/img/ico/favicon.ico" type="image/png">
<meta name="msapplication-TileColor" content="#3399cc" />
</head>
<body class="login-page">
	<div id="login" class="animated bounceIn">
		<img id="logo" src="assets/img/logo.png" alt="sprFlat Logo">
		<div class="login-wrapper">
			<ul id="myTab" class="nav nav-tabs nav-justified bn">
				<li><a href="#log-in" data-toggle="tab">管理员登录</a></li>
			</ul>
			<div id="myTabContent" class="tab-content bn">
				<div class="tab-pane fade active in" id="log-in">
					<form class="form-horizontal mt10" action="login" id="login-form"
						role="form" method="post">
						<div class="form-group">
							<div class="col-lg-12">
								<input type="text" name="userName" id="userName"
									class="form-control left-icon" required placeholder="请输入管理员账户">
								<i class="ec-user s16 left-input-icon"></i>
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-12">
								<input type="password" name="userPwd" id="userPwd"
									class="form-control left-icon" required placeholder="请输入密码">
								<i class="ec-locked s16 left-input-icon"></i>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label" style="line-height:34px">&nbsp;&nbsp;人机验证</label>
							<div id="captcha1" class="col-sm-4">
								<p id="wait1">正在加载验证码......</p>
							</div>
							<br>
						</div>
						<div class="form-group">
						    <div class="col-xs-6 pull-right">
							    <p id="notice1" style="display: none; color: red">请先完成验证</p>
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-8">
								<label class="checkbox"> <input type="checkbox"
									name="remember" id="remember" value="option">记住用户名
								</label>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-4">
								<button class="btn btn-success pull-right" type="submit"
									id='isLogin'>登录</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="assets/plugins/core/pace/pace.min.js"></script>
	<script src="assets/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src='assets/js/MD5.js'></script>
	<script type="text/javascript" src='assets/js/cookie.js'></script>
	<script type="text/javascript" src='assets/js/gt.js'></script>
	<script>
		$(function() {
			var name = pCookie.get("name");
			if (name) {
				$('#userName').val(name);
			}
			var remember = pCookie.get("remember");
			if (remember) {
				$('#remember').attr('checked', remember);
			}
		});
		var handler1 = function(captchaObj) {
			$("#isLogin").click(function(e) {
				var result = captchaObj.getValidate();
				//在前端判断是否验证成功了
				if (!result) {
					$("#notice1").show();
					setTimeout(function() {
						$("#notice1").hide();
					}, 2000);
					e.preventDefault();
				} else {
					if ($('#remember').attr('checked')) {
						pCookie.set("name", $('#userName').val(), "30d");
						pCookie.set("remember", 'checked', "30d");
					} else {
						pCookie.del("name");
						pCookie.del("remember");
					}
					var privateKey = 'ByTruuess';
					var originPwd = $('#userPwd').val();
					$('#userPwd').val(hex_md5(originPwd + privateKey));
					return true;
				}
			});
			// 将验证码加到id为captcha的元素里，同时会有三个input的值用于表单提交
			captchaObj.appendTo("#captcha1");
			captchaObj.onReady(function() {
				$("#wait1").hide();
			});
			// 更多接口参考：http://www.geetest.com/install/sections/idx-client-sdk.html
		};
		$.ajax({
			url : "gt/register?t=" + (new Date()).getTime(), // 加随机数防止缓存
			type : "get",
			dataType : "json",
			success : function(data) {
				// 调用 initGeetest 初始化参数
				// 参数1：配置参数
				// 参数2：回调，回调的第一个参数验证码对象，之后可以使用它调用相应的接口
				initGeetest({
					gt : data.gt,
					challenge : data.challenge,
					new_captcha : data.new_captcha, // 用于宕机时表示是新验证码的宕机
					offline : !data.success, // 表示用户后台检测极验服务器是否宕机，一般不需要关注
					product : "popup", // 产品形式，包括：float，popup
					width : "100%"
				// 更多配置参数请参见：http://www.geetest.com/install/sections/idx-client-sdk.html#config
				}, handler1);
			}
		});
	</script>
	<script>
		window.jQuery
				|| document
						.write('<script src="assets/js/libs/jquery-2.1.1.min.js">\x3C/script>')
	</script>
	<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="assets/js/libs/jquery-ui-1.10.4.min.js">\x3C/script>')
	</script>
	<script src="assets/js/bootstrap/bootstrap.js"></script>
	<script src="assets/plugins/forms/icheck/jquery.icheck.js"></script>
	<script src="assets/plugins/forms/validation/jquery.validate.js"></script>
	<script src="assets/plugins/forms/validation/additional-methods.min.js"></script>
	<script src="assets/js/pages/login.js"></script>
</body>
</html>