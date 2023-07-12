<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: FPTSHOP
  Date: 4/3/2023
  Time: 11:36 PM
  To change this template use File | Settings | File Templates.
--%>
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
    <section>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">STT</th>
                <th scope="col">Ma</th>
                <th scope="col">Ngay Tao</th>
                <th scope="col">Tên Người Nhận</th>
                <th scope="col">Địa Chỉ</th>
                <th scope="col">Số DT</th>
                <th scope="col">Trang Thai</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${lstHoaDon}" var="hd" varStatus="i">
                <tr>
                    <td>${i.index + 1}</td>
                    <td>${hd.ma}</td>
                    <td>${hd.ngayTao}</td>
                    <td>${hd.tenNguoiNhan}</td>
                    <td>${hd.diaChi}</td>
                    <td>${hd.sdt}</td>
                    <td>${hd.getTrangThai()}</td>
                    <td>
                        <a href="/admin/tuchoi?id=${hd.id}" class="btn btn-danger">Tu Choi</a>
                        <a href="/admin/xacnhan?id=${hd.id}" class="btn btn-success">Xac Nhan</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>
</div>
</body>
</html>

