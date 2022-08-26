<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JAKARIN
  Date: 12/2/2021
  Time: 4:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="cotainer">
    <p class="h2">63130500009 :Jakarn Chaibubpa</p>
    <div class="row">
        <c:forEach items="${customers}" var="customer" varStatus="vs">
            <div class="col-2 p-1 m-2 border border-secondary">
                <div>009-${vs.count}</div>
                <div>CustomerNumber: ${customer.id}</div>
                <div>Name:${customer.customerName}</div>
                <div>role:${customer.role}</div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>