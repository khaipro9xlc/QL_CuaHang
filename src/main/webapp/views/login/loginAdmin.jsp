<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: FPTSHOP
  Date: 4/3/2023
  Time: 1:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<c:if test="${ not empty errorMessage }">
    <div class="alert alert-danger">${ errorMessage }</div>
</c:if>

<form action="/login/admin" method="post">
    <div class="mt-3">
        <label>Mã NV</label>
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
