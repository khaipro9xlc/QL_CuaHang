<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: FPTSHOP
  Date: 4/3/2023
  Time: 3:06 PM
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
    <div class="row">
        <label> Hoa Don Mua Hang</label>
        <label></label>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">STT</th>
                <th scope="col">Ten SP</th>
                <th scope="col">Price</th>
                <th scope="col">So Luong</th>
                <th scope="col">Thanh Tiên</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${lstCart}" var="c" varStatus="i">
                <tr>
                    <td>${i.index + 1}</td>
                    <td>${c.tenSP}</td>
                    <td>${c.price}</td>
                    <td>${c.soLuong}</td>
                    <td>${c.price * c.soLuong}</td>

                </tr>
            </c:forEach>
            <tr>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td>Tong Tien : ${tongTien}</td>
                <td></td>
            </tr>
            </tbody>
        </table>
        <form action="/giohang/ban-hang/xac-nhan" method="post">
            <form class="row g-3">
                <div class="col-md-4">
                    <label class="form-label">Tên Người Nhận</label>
                    <input type="text" class="form-control" name="tenNguoiNhan">
                </div>
                <div class="col-md-4">
                    <label class="form-label">Địa Chỉ</label>
                    <input type="text" class="form-control" name="diaChi">
                </div>
                <div class="col-md-4">
                    <label class="form-label">Sdt</label>
                    <input type="text" class="form-control" name="sdt">
                </div>
                <div class="col-md-4">
                    <label class="form-label">Tien Thanh Toan</label>
                    <input type="text" class="form-control" name="tienThanhToan">
                </div>
                <div class="col-12">
                    <button class="btn btn-primary" type="submit">Thanh Toan</button>
                </div>
            </form>
        </form>
    </div>
</div>
</body>
</html>
