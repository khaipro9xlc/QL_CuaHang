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
<%--<jsp:include page="../layout.jsp"></jsp:include>--%>
<h1>Danh sach ctsp</h1>
<td><a href="/chitietsp/create" methods="get" class="btn btn-primary">Them ctsp</a></td>

<table border="1px">
    <thead>
    <tr>
        <td>STT</td>
        <td>Tên SP</td>
        <td>Tên NSX</td>
        <td>Tên MS</td>
        <td>Tên DSP</td>
        <td>NĂM BH</td>
        <td>MÔ TẢ</td>
        <td>SỐ LƯỢNG TỒN</td>
        <td>GIÁ NHẬP</td>
        <td>GIÁ BÁN</td>
        <td>ACTION</td>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${lstctsp.content}" var="ctsp" varStatus="i">
        <tr>
            <td>${i.index +1}</td>
            <td>${ctsp.sp.ten}</td>
            <td>${ctsp.nsx.ten}</td>
            <td>${ctsp.ms.ten}</td>
            <td>${ctsp.dsp.ten}</td>
            <td>${ctsp.namBH}</td>
            <td>${ctsp.moTa}</td>
            <td>${ctsp.soLuongTon}</td>
            <td>${ctsp.giaNhap}</td>
            <td>${ctsp.giaBan}</td>

            <td>
                <a class="btn btn-primary" href="/chitietsp/delete/${ctsp.id}">Delete</a>
                <a class="btn btn-primary" href="/chitietsp/edit/${ctsp.id}">update</a>

            </td>
        </tr>
    </c:forEach>
    </tbody>

</table>
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <li class="page-item">
            <c:forEach begin="0" end="${lstctsp.totalPages-1}" varStatus="loop">
                <a class="page-link" href="/chitietsp/index?page=${loop.begin +loop.count -1}">
                        ${loop.begin + loop.count}
                </a>
            </c:forEach>
        </li>
    </ul>
</nav>
</body>
</html>