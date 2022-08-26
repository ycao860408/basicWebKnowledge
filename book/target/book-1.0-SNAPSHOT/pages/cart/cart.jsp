<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%@ include file="/pages/commons/head.jsp"%>
	<script type="text/javascript">
		$(function () {
			$("#cleanCart").click(function () {
				return confirm("您确定要清空购物车么？");
			})

			$("a.deleteItem").click(function (){
				var name = $(this).parent().parent().find("td:first").text();
				return confirm("您真的要删除*" + name + "*吗？")
			})

			$("input.updateCount").change(function () {
				var name = $(this).parent().parent().find("td:first").text();
				var count = $(this).val();
				var id = $(this).attr("bookId")
				if (confirm("您确定要将【" + name + "】商品的数量修改为"+ count +"吗?")) {
					location.href="${basePath}cartServlet?action=updateCount&count="+count+"&id="+id;
				} else {
					this.value = this.defaultValue;
				}
			})
		})
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
			<%--<%@ include file="/pages/commons/login_success_menu.jsp"%>--%>
			<div>
				<c:if test="${empty sessionScope.user}" >
					<a href="pages/user/login.jsp">登录</a> |
					<a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
				</c:if>

				<c:if test="${not empty sessionScope.user}">
					<span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
					<a href="client/orderServlet?action=myPage">我的订单</a>
					<a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
				</c:if>
				<a href="index.jsp">返回</a>
			</div>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:if test="${not empty sessionScope.cart.items}">
				<c:forEach items="${sessionScope.cart.items}" var="entry">
					<tr>
						<td>${entry.value.name}</td>
						<td>
							<input type="text" name="count" value="${entry.value.count}" style="width: 80px" class="updateCount" bookId="${entry.value.id}"/>
						</td>
						<td>${entry.value.price}</td>
						<td>${entry.value.totalPrice}</td>
						<td><a href="cartServlet?action=deleteItem&id=${entry.value.id}" class="deleteItem">删除</a></td>
					</tr>
				</c:forEach>
			</c:if>

			<c:if test="${empty sessionScope.cart.items}">
				<tr>
					<td colspan="5"><a href="index.jsp">亲，当前购物车为空,赶快去浏览商品吧！</a></td>
				</tr>
			</c:if>

			
		</table>
		<c:if test="${not empty sessionScope.cart.items}">
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
				<span class="cart_span"><a href="cartServlet?action=clean" id="cleanCart">清空购物车</a></span>
				<span class="cart_span"><a href="client/orderServlet?action=createOrder">去结账</a></span>
			</div>
		</c:if>

	
	</div>
	
	<%@ include file="/pages/commons/footer.jsp"%>
</body>
</html>