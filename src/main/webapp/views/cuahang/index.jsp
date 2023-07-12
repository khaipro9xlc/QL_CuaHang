<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
            integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
            crossorigin="anonymous"></script>
</head>
<body>
<h1> Danh sach cua hang</h1>
<td>
    <a href="/cuahang/create" methods="get" class="btn btn-primary">Thêm cửa hàng</a>

</td>
<table border="2px">
    <thead>
    <tr>

        <td>Mã</td>
        <td>Tên</td>
        <td>Địa chỉ</td>
        <td>Thành phố</td>
        <td>Quốc gia</td>
        <td>action</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${lstds.content}" var="ch">
        <tr>

            <td>${ch.ma}</td>
            <td>${ch.ten}</td>
            <td>${ch.diachi}</td>
            <td>${ch.thanhpho}</td>
            <td>${ch.quocgia}</td>
            <td>
                <a class="btn btn-primary" href="/cuahang/delete/${ch.id}">Delete</a>
                <a class="btn btn-primary" href="/cuahang/edit/${ch.id}">Update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <li class="page-ỉtem">
            <c:forEach begin="0" end="${lstds.totalPages -1}" varStatus="loop">
                <a class="page-link" href="/cuahang/index?page=${loop.begin +loop.count -1}">
                        ${loop.begin + loop.count}
                </a>
            </c:forEach>
        </li>
    </ul>
</nav>
</body>
</html>