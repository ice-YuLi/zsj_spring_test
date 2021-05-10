<%--<%@ page import="AccountDomian" %>
<%@ page import="java.lang.annotation.Documented" %>
<%@ page import="java.util.List" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/19 0019
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+ "://" + request.getServerName() + ":" + request.getServerPort() + path+"/";
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<hi>查询结果</hi>
<a><%=path%></a>
<a><%=basePath%></a>
<%-- jstl --%>
<%--<c:forEach items="${list}" var="account">--%>
<%--    ${account.name}--%>
<%--</c:forEach>--%>
<form action="<%=basePath%>login/sign" method="post">
    <p>First name: <input type="text" name="userName" /></p>
    <p>Last name: <input type="text" name="password" /></p>
    <input type="submit" value="Submit" />
</form>
<%--EL--%>
<%--<%
    List<AccountDomian> accountDomianList =(List<AccountDomian>)request.getAttribute("list");
    for (int i = 0 ; i < accountDomianList.size() ; i ++){
        AccountDomian item = accountDomianList.get(i);
        System.out.print(item.getId());
    }
%>
<%= accountDomianList %>--%>
</body>
</html>
