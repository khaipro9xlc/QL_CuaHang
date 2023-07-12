<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<div class="container">
    <form:form action="/chitietsp/post" method="post" modelAttribute="chitietSp">

        <label>Tên Sản Phẩm </label>
        <form:select path="sp">
            <c:forEach items="${lstsp}" var="sp">
                <form:option value="${sp.id}">${sp.ten}</form:option>
            </c:forEach>
        </form:select>
        <br>
        <label>Tên NSX </label>
        <form:select path="nsx">
            <c:forEach items="${lstnsx}" var="nsx">
                <form:option value="${nsx.id}">${nsx.ten}</form:option>
            </c:forEach>
        </form:select>
        <br>
        <label>Tên Màu sắc </label>
        <form:select path="mauSac">
            <c:forEach items="${lstms}" var="ms">
                <form:option value="${ms.id}">${ms.ten}</form:option>
            </c:forEach>
        </form:select>
        <br>
        <label>Tên Dòng Sản Phẩm </label>
        <form:select path="dongSP">
            <c:forEach items="${lstdsp}" var="dsp">
                <form:option value="${dsp.id}">${dsp.ten}</form:option>
            </c:forEach>
        </form:select>
        <br>
        <label>Năm bảo hành</label>
        <form:input path="namBH"/>
        <form:errors path="namBH"/>
        <br>
        <label>Mô tả</label>
        <form:input path="mota"/>
        <form:errors path="mota"/>
        <br>
        <label>Số lượng tồn</label>
        <form:input path="soLuongTon"/>
        <form:errors path="soLuongTon"/>
        <br>
        <label>Gía nhập</label>
        <form:input path="giaNhap"/>
        <form:errors path="giaNhap"/>
        <br>
        <label>Gía Bán</label>
        <form:input path="giaBan"/>
        <form:errors path="giaBan"/>
        <br>
        <td>
            <button type="submit">Them</button>
            <a href="/chitietsp/index" class="btn btn-primary">Back to ship</a>
        </td>
    </form:form>


</div>
</body>
</html>