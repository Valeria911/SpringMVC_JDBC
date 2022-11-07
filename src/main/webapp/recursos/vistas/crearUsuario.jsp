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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <title>Registro Usuarios</title>
</head>
<body>
<div class="container">
    <%@include file="menu.jsp" %>
    <spring:url value="/usuario/guardar" var="guardarURL" htmlEscape="true"/>
    <form:form modelAttribute="usuarioForm" method="post" action="${guardarURL}" cssClass="form">
        <form:hidden path="idUsuario"/>
    <div class="form-group">
        <div class="form-row">
            <div class="col-md-6 mb-3">
                <label for="nombreCompleto">Nombre completo:</label>
                <form:input path="nombreCompleto" cssClass="form-control" id="nombreCompleto"/>
            </div>
            <div class="col-md-6 mb-3">
                <label for="fechaNacimiento">Fecha de nacimiento:</label>
                <form:input path="fechaNacimiento" cssClass="form-control" id="fechaNacimiento"/>
            </div>
        </div>
        <div class="form-row">
            <div class="col-md-6 mb-3">
                <label for="run">Rut:</label>
                <form:input path="run" cssClass="form-control" id="run"/>
            </div>
            <div class="col-md-3 mb-3">
                <label for="tipo">Tipo</label>
                <form:select path="tipo" cssClass="custom-select" id="tipo">
                    <option selected disabled value="">Seleccione...</option>
                    <option>Cliente</option>
                    <option>Administrativo</option>
                    <option>Profesional</option>
                </form:select>
            </div>
        </div>
        <div class="form-group">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="invalidCheck2" required>
                <label class="form-check-label" for="invalidCheck2">
                    Acepto términos y condiciones
                </label>
            </div>
        </div>
        <button type="submit" class="btn btn-info">Registrar</button>
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
