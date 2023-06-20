<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Registro</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="../../resources/plugins/fontawesome-free/css/all.min.css">
  <!-- icheck bootstrap -->
  <link rel="stylesheet" href="../../resources/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../../resources/dist/css/adminlte.min.css">
  <style type="text/css">
  .error-message {
  color: red;
  font-size: 14px;
  display: block;
  margin-top: 4px;
}
  </style>
  
</head>
<body class="hold-transition register-page">
<div class="register-box">
  <div class="card card-outline card-primary">
    <div class="card-header text-center">
      <a href="/" class="h1"><b>A</b>utomovil</a>
    </div>
    <div class="card-body">
      <p class="login-box-msg">Registrarse</p>

      <form:form action="/registro" method="post" modelAttribute="usuarios">
        <div class="input-group mb-3">
          <form:input type="text" class="form-control" placeholder="usuario" path="username" />
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-user"></span>
            </div>
          </div>
        </div>
        <form:errors path="username" cssClass="error-message"/>
        <div class="input-group mb-3">
          <form:input type="text" class="form-control" placeholder="Correo" path="mail" />
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-envelope"></span>
            </div>
          </div>
        </div>
          <form:errors path="mail" cssClass="error-message"/>
        <div class="input-group mb-3">
          <form:input type="password" class="form-control" placeholder="Contraseña" path="password" />
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
         <form:errors path="password" cssClass="error-message"/>
        <div class="input-group mb-3">
          <input type="password" class="form-control" placeholder="Repetir Contraseña">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-8">
          </div>
          <!-- /.col -->
          <div class="col-4">
            <button type="submit" class="btn btn-primary btn-block">Register</button>
          </div>
          <!-- /.col -->
        </div>
      </form:form>
      <a href="/" class="text-center">Ir a iniciar Sesión</a>
    </div>
    <!-- /.form-box -->
  </div><!-- /.card -->
</div>
<!-- /.register-box -->

<!-- jQuery -->
<script src="../../resources/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="../../resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="../../resources/dist/js/adminlte.min.js"></script>
</body>
</html>
