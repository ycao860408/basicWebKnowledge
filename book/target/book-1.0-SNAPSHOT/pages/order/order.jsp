<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
	<%@ include file="/pages/commons/head.jsp"%>

<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
	<script type="text/javascript">
		$(function() {
			$("#goToPageNo").click(function(){
				var pageNo = $("#pn_input").val();
				if (pageNo < 1 || pageNo > ${requestScope.page.pageTotal}) {
					alert("您输入的页码非法，请更换输入！");
					return false;
				}
				location.href= "${basePath}${requestScope.page.url}&pageNo=" + pageNo;
			})
		})
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">我的订单</span>
		<%@ include file="/pages/commons/login_success_menu.jsp"%>

	</div>
	
	<div id="main">

		<c:if test="${requestScope.page.pageCount == 0}">
			<h1>您尚未拍下任何一單，歡迎您前往<a href="index.jsp" style="color: red">主页</a>购物</h1>
		</c:if>
		<c:if test="${requestScope.page.pageCount != 0}">
			<table>
				<tr>
					<td>日期</td>
					<td>金额</td>
					<td>状态</td>
					<td>详情</td>
					<td></td>
				</tr>
				<c:forEach items="${requestScope.page.items}" var="order">
					<tr>
						<td>${order.createTime}</td>
						<td>${order.price}</td>
						<td>${order.status}</td>
						<td><a href="#">查看详情</a></td>
						<td><a href="#">確認收貨</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<br/>
		<%@ include file="/pages/commons/pagNav.jsp"%>
	</div>

	<%@ include file="/pages/commons/footer.jsp"%>
</body>
</html>