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
<h1>Danh sach nhan vien</h1>
<td><a href="/nhanvien/create" methods="get" class="btn btn-primary">Them nv</a></td>
<table border="1px">
    <thead>
    <tr>

        <td>Ma</td>
        <td>Ten</td>
        <td>TenDem</td>
        <td>Ho</td>
        <td>Gioitinh</td>
        <td>NgaySinh</td>
        <td>DiaChi</td>
        <td>Sdt</td>
        <td>MatKhau</td>
        <td>Tên CH</td>
        <td>Tên cv</td>
        <%--        <td>IdguiBc</td>--%>
        <td>TrangThai</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listnv.content}" var="nv">
        <tr>

            <td>${nv.ma}</td>
            <td>${nv.ten}</td>
            <td>${nv.tenDem}</td>
            <td>${nv.ho}</td>
            <td>${nv.gioitinh}</td>
            <td>${nv.ngaysinh}</td>
            <td>${nv.diaChi}</td>
            <td>${nv.sdt}</td>
            <td>${nv.matkhau}</td>
            <td>${nv.cuaHang.ten}</td>
            <td>${nv.chucVu.ten}</td>
            <td>${nv.trangthai==0?"Thực tập":"Lâu năm"}</td>
            <td>
                <a class="btn btn-primary" href="/nhanvien/delete/${nv.id}">Delete</a>
                <a class="btn btn-primary" href="/nhanvien/edit/${nv.id}">update</a>

            </td>
        </tr>
    </c:forEach>
    </tbody>

</table>
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <li class="page-item">
            <c:forEach begin="0" end="${listnv.totalPages-1}" varStatus="loop">
                <a class="page-link" href="/nhanvien/index?page=${loop.begin +loop.count -1}">
                        ${loop.begin + loop.count}
                </a>
            </c:forEach>
        </li>
    </ul>
</nav>
</body>
</html>