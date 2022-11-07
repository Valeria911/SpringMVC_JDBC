<%--
  Created by IntelliJ IDEA.
  User: v.gutierrez
  Date: 06-10-22
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <title>Registro Capacitaciones</title>
</head>
<body>
<div class="container">
    <%@include file="menu.jsp" %>
    <spring:url value="/capacitacion/guardar" var="capaURL" htmlEscape="true"/>
    <form:form modelAttribute="capacitacionForm" method="post" action="${capaURL}" cssClass="form">
        <form:hidden path="idCapacitacion"/>
    <div class="form-group">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="rutCliente">Rut Cliente</label>
                <form:input path="rutCliente" cssClass="form-control" id="rutCliente"/>
            </div>
            <div class="form-group col-md-6">
                <label for="dia">Día de la capacitación</label>
                <form:input path="dia" cssClass="form-control" id="dia"/>
            </div>
        </div>
        <div class="form-group">
            <label for="lugar">Dirección</label>
            <form:input path="lugar" cssClass="form-control" id="lugar"/>
        </div>
        <div class="form-row">
            <div class="form-group col-md-4">
                <label for="hora">Hora</label>
                <form:input path="hora" id="hora" cssClass="form-control"/>
            </div>
            <div class="form-group col-md-4">
                <label for="duracion">Duracion</label>
                <form:input path="duracion" cssClass="form-control" id="duracion"/>
            </div>
            <div class="form-group col-md-4">
                <label for="asistentes">Nº asistentes</label>
                <form:input path="cantidadAsistentes" cssClass="form-control" id="asistentes"/>
            </div>
        </div>
        <div class="form-group">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" id="gridCheck">
                <label class="form-check-label" for="gridCheck">
                    Acepto términos y condiciones
                </label>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Registrar Capacitación</button>
        </form:form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
            crossorigin="anonymous"></script>
</body>
</html>
