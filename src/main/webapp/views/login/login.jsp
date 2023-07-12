<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<c:if test="${ not empty errorMessage }">
    <div class="alert alert-danger">${ errorMessage }</div>
</c:if>

<form method="post" action="/ban-hang/login">
    <div class="mt-3">
        <label>Mã KH</label>
        <input type="text" name="ma" class="form-control"/>
    </div>
    <div class="mt-3">
        <label>Password</label>
        <input type="password" name="matKhau" class="form-control"/>
    </div>

    <div class="mt-3">
        <button class="btn btn-primary">Đăng nhập</button>
    </div>
</form>
