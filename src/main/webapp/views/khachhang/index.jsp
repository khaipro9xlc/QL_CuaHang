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
<h1>Danh sach khach hang</h1>

<td>
    <a class="btn btn-primary" href="/khachhang/create" methods="get">Them KH</a>
</td>
<table border="1">
    <thead>
    <tr>

        <td>ma</td>
        <td>ten</td>
        <td>tendem</td>
        <td>ho</td>
        <td>ngaysinh</td>
        <td>sdt</td>
        <td>diachi</td>
        <td>thanhpho</td>
        <td>quocgia</td>
        <td>matkhau</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listkh}" var="kh">
        <tr>

            <td>${kh.ma}</td>
            <td>${kh.ten}</td>
            <td>${kh.tenDem}</td>
            <td>${kh.ho}</td>
            <td>${kh.ngaySinh}</td>
            <td>${kh.sdt}</td>
            <td>${kh.diaChi}</td>
            <td>${kh.thanhPho}</td>
            <td>${kh.quocGia}</td>
            <td>${kh.matKhau}</td>
            <td>
                <a class="btn btn-primary" href="/khachhang/delete/${kh.id}">Delete</a>
                <a class="btn btn-primary" href="/khachhang/edit/${kh.id}">Update</a>

            </td>
        </tr>

    </c:forEach>
    </tbody>
</table>
</body>
</html>