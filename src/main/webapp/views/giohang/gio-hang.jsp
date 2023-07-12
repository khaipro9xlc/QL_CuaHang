<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: FPTSHOP
  Date: 4/3/2023
  Time: 1:14 AM
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
<div class="container">
    <header>
        <ul class="nav justify-content-center">
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/home">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/giohang/cart">Gio hang <span>${sessionScope.slgh}</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/login">Login</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/login">Logout</a>
            </li>
        </ul>
    </header>

    <section>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">STT</th>
                <th scope="col">Ten SP</th>
                <th scope="col">Price</th>
                <th scope="col">So Luong</th>
                <th scope="col">Thanh Tiên</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${lstcard}" var="c" varStatus="i">
                <tr>
                    <td>${i.index + 1}</td>
                    <td>${c.tenSP}</td>
                    <td>${c.price}</td>
                    <td>
                        <a href="/ThemSp?id=${c.idSP}">+</a>
                            ${c.soLuong}
                        <a href="/xoasp?id=${c.idSP}">-</a>
                    </td>
                    <td>${c.price * c.soLuong}</td>

                </tr>
            </c:forEach>
            <tr>
                <td></td>
                <td>Tong Tien : ${tongtien}</td>
                <td><a href="/giohang/ban-hang/thanh-toan">Thanh Toan</a></td>
            </tr>
            </tbody>
        </table>
    </section>
</div>
</body>
</html>
