<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: FPTSHOP
  Date: 4/7/2023
  Time: 1:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

</head>
<body>
<section>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">TenSp</th>
            <th scope="col">So Luong</th>
            <th scope="col">Don Gia</th>
            <th scope="col">Tong Tien</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listhdct}" var="hd" varStatus="i">
            <tr>
                <td>${i.index + 1}</td>
                <td>${hd.sp.ten}</td>
                <td>${hd.soLuong}</td>
                <td>${hd.donGia}</td>
                <td>${hd.soLuong * hd.donGia}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>
</body>
</html>
