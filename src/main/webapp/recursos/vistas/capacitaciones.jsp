<%--
  Created by IntelliJ IDEA.
  User: v.gutierrez
  Date: 15-10-22
  Time: 00:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="x" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <title>Nuestras Capacitaciones</title>
</head>
<body>
<div class="container">
    <%@include file="menu.jsp" %>
    <table class="table">
        <thead class="table-info">
        <tr>
            <th>ID</th>
            <th>Rut Cliente</th>
            <th>Día</th>
            <th>Hora</th>
            <th>Lugar</th>
            <th>Duracion</th>
            <th>Cantidad de asistentes</th>
            <th>Opción</th>
            <th>Opción</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="capacitaciones" items="${capacitaciones}">
            <tr>
                <td>${capacitaciones.idCapacitacion}</td>
                <td>${capacitaciones.rutCliente}</td>
                <td>${capacitaciones.dia}</td>
                <td>${capacitaciones.hora}</td>
                <td>${capacitaciones.lugar}</td>
                <td>${capacitaciones.duracion}</td>
                <td>${capacitaciones.cantidadAsistentes}</td>
                <td>
                    <spring:url value="/capacitacion/actualizar/${capacitaciones.idCapacitacion}" var="editarURL" />
                    <a class="btn btn-info" href="${editarURL}" role="button">Editar</a>
                </td>
                <td>
                    <spring:url value="/capacitacion/eliminar/${capacitaciones.idCapacitacion}" var="borrarURL"/>
                    <a class="btn btn-info" href="${borrarURL}" role="button">Eliminar</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <spring:url value="/capacitacion/agregar" var="agregarURL"/>
    <a class="btn btn-info" href="${agregarURL}" role="button">Agregar Capacitación</a>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"
        integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+"
        crossorigin="anonymous"></script>
</body>
</html>
