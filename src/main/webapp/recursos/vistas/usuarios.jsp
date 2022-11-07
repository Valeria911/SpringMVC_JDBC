<%--
  Created by IntelliJ IDEA.
  User: v.gutierrez
  Date: 13-10-22
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="x" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <title>Usuarios</title>
</head>
<body>
<div class="container">
    <%@include file="menu.jsp" %>
    <table class="table">
        <thead class="table-info">
        <tr>
            <th>ID</th>
            <th>Nombre Completo</th>
            <th>Fecha de Nacimiento</th>
            <th>Rut</th>
            <th>Tipo</th>
            <th>Opción</th>
            <th>Opción</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="usuarios" items="${usuarios}">
            <tr>
                <td>${usuarios.idUsuario}</td>
                <td>${usuarios.nombreCompleto}</td>
                <td>${usuarios.fechaNacimiento}</td>
                <td>${usuarios.run}</td>
                <td>${usuarios.tipo}</td>
                <td>
                    <spring:url value="/usuario/actualizar/${usuarios.idUsuario}" var="actualizarURL" />
                    <a class="btn btn-info" href="${actualizarURL}" role="button">Editar</a>
                </td>
                <td>
                    <spring:url value="/usuario/eliminar/${usuarios.idUsuario}" var="eliminarURL"/>
                    <a class="btn btn-info" href="${eliminarURL}" role="button">Eliminar</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <spring:url value="/usuario/agregar" var="crearURL"/>
    <a class="btn btn-info" href="${crearURL}" role="button">Agregar Usuario</a>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
        crossorigin="anonymous"></script>
</body>
</html>
