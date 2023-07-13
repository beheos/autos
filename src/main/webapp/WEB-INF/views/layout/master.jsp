<!DOCTYPE html>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication property="principal.username" var="username" />
<html lang="es">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Consesionaria</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="../../../resources/plugins/fontawesome-free/css/all.min.css">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="../../../resources/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../../../resources/dist/css/adminlte.min.css">
  
  <style type="text/css">
  	.activeH:{
  		background-color:rgba(255,255,255,.9);
  		color:#343a40;
  	}
  	
  </style>
  
</head>
<!--<body class="hold-transition dark-mode sidebar-mini layout-fixed layout-navbar-fixed layout-footer-fixed">-->
<body class="hold-transition sidebar-mini layout-fixed layout-navbar-fixed layout-footer-fixed">
<div class="wrapper">

  <!-- Preloader -->
  <div class="preloader flex-column justify-content-center align-items-center">
    <img class="animation__wobble" src="../../../resources/dist/img/AdminLTELogo.png" alt="AdminLTELogo" height="60" width="60">
  </div>

  <!-- Navbar -->
  <nav class="main-header navbar navbar-expand navbar-dark">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
      </li>
    </ul>

    <!-- Right navbar links -->
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link"
					data-widget="fullscreen" href="#" role="button"> <i
						class="fas fa-expand-arrows-alt"></i>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="/logout"
					role="button"> <i class="nav-icon fas fa-door-closed"></i>
						Salir
				</a></li>
			</ul>
		</nav>
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="/home/" class="brand-link">
      <img src="../../../resources/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
      <span class="brand-text font-weight-light">utomoviles</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          <img src="../../../resources/dist/img/avatar4.png" class="img-circle elevation-2" alt="User Image">
        </div>
        <div class="info">
          <a href="#" class="d-block">${username}</a>
        </div>
      </div>

      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <li class="nav-item">
            <a href="#" class="nav-link active">
              <i class="nav-icon fas fa-car"></i>
              <p>
                Ventas
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item-hijo">
                <a href="./index.html" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Cotización</p>
                </a>
              </li>
              <li class="nav-item-hijo">
                <a href="./index2.html" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Nueva Venta</p>
                </a>
            </li>
			<li class="nav-item-hijo">
				<a href="./index2.html" class="nav-link">
				<i class="far fa-circle nav-icon"></i>
					<p>Ventas</p></a>
			</li>
			<li class="nav-item-hijo">
				<a href="./index2.html" class="nav-link">
				<i class="far fa-circle nav-icon"></i>
					<p>Reportes</p></a>
			</li>
			</ul>
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-table"></i>
              <p>
                Inventario
                <i class="right fas fa-angle-left"></i>
                <i class="fa-thin "></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
               <li class="nav-item-hijo">
                <a href="/vehiculo/" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Vehiculos</p>
                </a>
              </li>
               <li class="nav-item-hijo">
                <a href="/vehiculo/cargamasiva" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Carga Masiva</p>
                </a>
              </li>
            </ul>
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-user"></i>
              <p>
                Empleados
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
               <li class="nav-item-hijo">
                <a href="/empleados/" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Empleados</p>
                </a>
              </li>
              <li class="nav-item-hijo">
                <a href="/usuarios/" class="nav-link active">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Usuarios</p>
                </a>
              </li>
            </ul>
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-chart-pie"></i>
              <p>
                Graficas
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
               <li class="nav-item-hijo">
                <a href="./index.html" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Ventas</p>
                </a>
              </li>
              <li class="nav-item-hijo">
                <a href="./index2.html" class="nav-link active">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Empleado</p>
                </a>
              </li>
            </ul>
          </li>
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->

  <!-- Main Footer -->
  <footer class="main-footer">
    <strong>Copyright &copy; 2014-2021 <a href="#">beheos</a>.</strong>
    <div class="float-right d-none d-sm-inline-block">
      <b>Version</b> 3.1.0
    </div>
  </footer>
</div>
<!-- ./wrapper -->

<!-- REQUIRED SCRIPTS -->
<!-- jQuery -->
<script src="../../../resources/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="../../../resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- overlayScrollbars -->
<script src="../../../resources/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<script src="../../../resources/dist/js/adminlte.js"></script>


<!-- PAGE PLUGINS -->
<!-- jQuery Mapael -->
<script src="../../../resources/plugins/jquery-mousewheel/jquery.mousewheel.js"></script>
<script src="../../../resources/plugins/raphael/raphael.min.js"></script>
<script src="../../../resources/plugins/jquery-mapael/jquery.mapael.min.js"></script>
<script src="../../../resources/plugins/jquery-mapael/maps/usa_states.min.js"></script>
<!-- ChartJS -->
<script src="../../../resources/plugins/chart.js/Chart.min.js"></script>

<!-- AdminLTE for demo purposes -->
<script src="../../../resources/dist/js/demo.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="../../../resources/dist/js/pages/dashboard2.js"></script>
<!-- Menu -->
<script src="../../../resources/build/js/menu.js"></script>
</body>
</html>
