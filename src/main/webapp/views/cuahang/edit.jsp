<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<div class="form-group" style="width: 350px">

    <form:form action="${action}" method="post" modelAttribute="cuaHang">

        <label>Ma</label>
        <form:input path="ma"/>
        <form:errors path="ma"/>
        <br>
        <label>Ten</label>
        <form:input path="ten"/>
        <form:errors path="ten"/>
        <br>
        <label>DiaChi</label>
        <form:input path="diachi"/>
        <form:errors path="diachi"/>
        <br>
        <label>ThanhPho</label>
        <form:input path="thanhpho"/>
        <form:errors path="thanhpho"/>
        <br>
        <label>QuocGia</label>
        <form:input path="quocgia"/>
        <form:errors path="quocgia"/>
        <br>
        <button type="submit">Sửa</button>
        <td><a href="/cuahang/index">Back to ship</a></td>
    </form:form>
</div>
</body>
</html>