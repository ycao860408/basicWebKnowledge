<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
	<%@ include file="/pages/commons/head.jsp"%>
	<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
</style>
	<script type="text/javascript">
		$(function () {
			$("#codImg").click(function () {
				this.src = "${basePath}kaptcha.jpg?d="+Math.random();
			})
			$("#sub_btn").click(function () {
				var username = $("#username").val();
				var unpatt = /^\w{5,12}$/;

				if (!unpatt.test(username)) {
					$("span.errorMsg").text("用户名不合法！")
					return false;
				}
				var password = $("#password").val();

				var ppatt = /^\w{5,12}$/
				if (!ppatt.test(password)) {
					$("span.errorMsg").text("密码不合法！")
					return false;
				}
				var confirmPassword = $("#repwd").val();
				if(password != confirmPassword) {
					$("span.errorMsg").text("确认密码和密码不一致！")
					return false;
				}

				var email = $("#email").val();
				var epatt = /^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
				if (!epatt.test(email)) {
					$("span.errorMsg").text("邮箱格式不合法！")
					return false;
				}

				var code = $("#code").val();
				code = $.trim(code);
				if (code == null || code == "") {
					$("span.errorMsg").text("请输入验证码！")
					return false;
				}

				$("span.errorMsg").text("");
			})

			$("#username").blur(function () {
				// first check the validity of the name
				var username = $("#username").val();
				var unpatt = /^\w{5,12}$/;

				if (!unpatt.test(username)) {
					$("span.errorMsg").text("用户名不合法！")
					return false;
				}
				// use ajax teo check whether the name is existed or not
				$.getJSON(
						"${basePath}/userServlet",
						"action=ajaxExistUsername&username=" + this.value,
						function(data) {
							if (data.exists) {
								$("span.errorMsg").text("用戶名已存在！")
								return false;
							}
						}
				)
			})
		})
	</script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">
									${requestScope.msg}
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="regist"/>
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username" value="${requestScope.username}"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email" value="${requestScope.email}"/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 120px;" name="code" id="code"/>
									<img alt="" src="kaptcha.jpg" style="float: right; margin-right: 40px"; width="100px"; height="40px" id="codImg">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%@ include file="/pages/commons/footer.jsp"%>
</body>
</html>