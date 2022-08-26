<%@ page import="com.atguigu.pojo.Book" %>
<%@ page import="com.atguigu.pojo.Page" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
	<%@ include file="/pages/commons/head.jsp"%>
	<script type="text/javascript">
		$(function() {
			$("a.deleteClass").click(function() {
				var name = $(this).parent().parent().find("td:first").text();
				return confirm("你确定要删除["+ name + "]吗?");
			})
			$("#goToPageNo").click(function(){
				var pageNo = $("#pn_input").val();
				if (pageNo < 1 || pageNo > ${requestScope.page.pageTotal}) {
					alert("您输入的页码非法，请更换输入！");
					return false;
				}
				location.href= "${basePath}${requestScope.page.url}manager/bookServlet?action=page&pageNo=" + pageNo;
			})
		})
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
		<%@ include file="/pages/commons/manager_menu.jsp"%>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>		
			<%--<tr>
				<td>时间简史</td>
				<td>20.00</td>
				<td>霍金</td>
				<td>200</td>
				<td>400</td>
				<td><a href="book_edit.jsp">修改</a></td>
				<td><a href="#">删除</a></td>
			</tr>	
			
			<tr>
				<td>时间简史</td>
				<td>20.00</td>
				<td>霍金</td>
				<td>200</td>
				<td>400</td>
				<td><a href="book_edit.jsp">修改</a></td>
				<td><a href="#">删除</a></td>
			</tr>	
			
			<tr>
				<td>时间简史</td>
				<td>20.00</td>
				<td>霍金</td>
				<td>200</td>
				<td>400</td>
				<td><a href="book_edit.jsp">修改</a></td>
				<td><a href="#">删除</a></td>
			</tr>	
			
			<tr>
				<td>时间简史</td>
				<td>20.00</td>
				<td>霍金</td>
				<td>200</td>
				<td>400</td>
				<td><a href="book_edit.jsp">修改</a></td>
				<td><a href="#">删除</a></td>
			</tr>	--%>
			<c:forEach items="${requestScope.page.items}" var="book">
				<tr>
					<td>${book.name}</td>
					<td>${book.price}</td>
					<td>${book.author}</td>
					<td>${book.sales}</td>
					<td>${book.stock}</td>
					<td><a href="manager/bookServlet?action=getBookById&id=${book.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
					<td><a href="manager/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}" class="deleteClass">删除</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp">添加图书</a></td>
			</tr>
		</table>
			<br/>
		<%@ include file="/pages/commons/pagNav.jsp"%>
	</div>

	<%@ include file="/pages/commons/footer.jsp"%>
</body>
</html>