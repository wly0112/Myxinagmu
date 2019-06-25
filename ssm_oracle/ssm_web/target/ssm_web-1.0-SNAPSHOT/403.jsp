<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/24 0024
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>权限不足</title>

    <style>
        h2{
            color: #ff0000;
        }
    </style>
</head>
<body>



   <h2> <a href="${pageContext.request.contextPath}/login.jsp">权限不足,请点击‘切换账号’</a>
   </h2>
              <img src="${pageContext.request.contextPath}/img/photo2.png" width="100%">

</body>
</html>
