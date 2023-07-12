<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: FPTSHOP
  Date: 3/19/2023
  Time: 5:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="<c:url value='/src/main/webapp/views/Button.js' />"></script>
    <link rel="stylesheet" href="Button.css">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-link" href="/cuahang/index">Cửa hàng</a>
                <a class="nav-link" href="/khachhang/index">Khách Hàng</a>
                <a class="nav-link" href="/nhanvien/index">Nhân Viên</a>
                <a class="nav-link" href="/chucvu/index">Chức Vụ</a>
                <a class="nav-link" href="/nsx/index">NSX</a>
                <a class="nav-link" href="/dongsp/index">Dòng sp</a>
                <a class="nav-link" href="/sanpham/index">Sản phẩm</a>
                <a class="nav-link" href="/mausac/index">Màu sắc</a>
                <a class="nav-link" href="/chitietsp/index">Chi tiet san pham</a>
                <a class="nav-link" href="/login">Login</a>
            </div>
        </div>
    </div>
</nav>

<div class="row mt-3" style="min-height: 600px;">
    <div class="bg-warning col-3" style="text-align: center">
        <button class="btn">button
        </button>

    </div>
    <div class="bg-light col-9">

    </div>
</div>

<div class="row mt-3 bg-dark ms-0">Footer</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"></script>

</body>
</html>

</body>
</html>
