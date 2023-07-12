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
            <c:if test="${sessionScope.kh == null}">
                <li class="nav-item">
                    <a class="nav-link" href="/login">Login</a>
                </li>
            </c:if>
            <c:if test="${sessionScope.kh != null}">
                <li class="nav-item">
                    <a class="nav-link" href="/login">Logout</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/giohang/ban-hang/lich-su/mua-hang">${sessionScope.kh.ten}</a>
                </li>
            </c:if>
        </ul>
    </header>

    <section>
        <c:forEach items="${lstCTSP}" var="sp">
            <div class="card" style="width: 18rem;">
                <img src="..." class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">${sp.sp.ten}</h5>
                    <p class="card-text">${sp.giaBan}</p>
                    <a href="/add-to-cart?id=${sp.id}" class="btn btn-primary">Add to Cart</a>
                </div>
            </div>
        </c:forEach>
    </section>
</div>
</body>
</html>
