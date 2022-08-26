<%@ page import="com.atguigu.pojo.Book" %>
<%@ page import="com.atguigu.pojo.Page" %><%--
  Created by IntelliJ IDEA.
  User: tiger
  Date: 2022/7/9
  Time: 0:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="page_nav">

  <c:if test="${requestScope.page.pageNo>1}">
    <a href="${requestScope.page.url}&pageNo=1">首页</a>
    <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo - 1}">上一页</a>
  </c:if>
  <%
    Page<Book> item = (Page<Book>) request.getAttribute("page");
    Integer curPage = item.getPageNo();
    //System.out.println(curPage);
    Integer pageTotal = item.getPageTotal();
    for (int i = (curPage - 1) / 5 * 5 + 1; i <= Math.min((curPage - 1) / 5 * 5 + 5, pageTotal); i++) {
      /*pageContext.setAttribute("i", i);*/
      //System.out.println(i);
      if (i == curPage) {
  %>
  【<%=i%>】
  <%
  } else {
  %>
  <a href="${requestScope.page.url}&pageNo=<%=i%>"><%=i%></a>
  <%
      }
    }
  %>
  <%--<a href="#">3</a>
  【${requestScope.page.pageNo}】
  <a href="#">5</a>--%>
  <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
    <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo + 1}">下一页</a>
    <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
  </c:if>
  共${requestScope.page.pageTotal}页，${requestScope.page.pageCount}条记录 到第<input value="${requestScope.page.pageNo}" name="pn" id="pn_input"/>页
  <input id="goToPageNo" type="button" value="确定">
</div>
