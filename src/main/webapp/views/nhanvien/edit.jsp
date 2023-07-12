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
    <form:form action="${action}" method="post" modelAttribute="nhanVien">

        <%--        <label>Id</label>--%>
        <%--        <form:input path="id"/>--%>
        <%--        <form:errors path="id"/>--%>
        <%--        <br>--%>
        <label>Ma</label>
        <form:input path="ma"/>
        <form:errors path="ma"/>
        <br>
        <label>Tên</label>
        <form:input path="ten"/>
        <form:errors path="ten"/>
        <br>
        <label>Tên Đệm</label>
        <form:input path="tendem"/>
        <form:errors path="tendem"/>
        <br>
        <label>Họ</label>
        <form:input path="ho"/>
        <form:errors path="ho"/>
        <br>
        <label>Gioi tính</label>
        <form:input path="gioitinh"/>
        <form:errors path="gioitinh"/>
        <br>
        <label>Ngày sinh</label>
        <form:input path="ngaysinh"/>
        <form:errors path="ngaysinh"/>
        <br>
        <label>Địa chỉ</label>
        <form:input path="diachi"/>
        <form:errors path="diachi"/>
        <br>
        <label>SDT</label>
        <form:input path="sdt"/>
        <form:errors path="sdt"/>
        <br>
        <label>Mật khẩu</label>
        <form:input path="matkhau"/>
        <form:errors path="matkhau"/>
        <br>
        <label>Tên Ch</label>
        <form:select path="cuaHang">
            <c:forEach items="${lstch}" var="ch">
                <form:option value="${ch.id}">${ch.ten}</form:option>
            </c:forEach>
        </form:select>
        <br>
        <label>Tên Cv</label>
        <form:select path="chucVu">
            <c:forEach items="${lstcv}" var="cv">
                <form:option value="${cv.id}">${cv.ten}</form:option>
            </c:forEach>
        </form:select>
        <br>
        <%--        <label>IDGUIBC</label>--%>
        <%--        <form:input path="idguibc"/>--%>
        <%--        <form:errors path="idguibc"/>--%>
        <%--        <br>--%>
        <label>Trạng thái</label>
        <form:input path="trangthai"/>
        <form:errors path="trangthai"/>
        <br>
        <td>
            <button type="submit">Sua</button>
            <a href="/nhanvien/index" class="btn btn-primary">Back to ship</a>
        </td>
    </form:form>


</div>
</body>
</html>