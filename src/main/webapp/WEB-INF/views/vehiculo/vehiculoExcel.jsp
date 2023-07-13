  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <jsp:include page="../layout/master.jsp" />
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-2">Inventario</h1>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->
    <!-- Main content -->
    <section class="content">
        <div class="card">
            <div class="card-header">
            	<div class="col-sm-2">
            		<h4>Carga Masiva Vehiculo</h4>
            	</div>
            </div>
            <!-- /.card-header -->
            <div class="card-body">
            	<form action="/vehiculo/subirCargaMasiva" enctype="multipart/form-data" method="post" onsubmit="return validarArchivo()">
						<div class="input-group">
  						<input type="file" id="file" name="file" accept=".xls,.xlsx">
  						<input type="submit" value="Subir" class="btn btn-info">
                    </div>
               </form>
			<!-- /.card-body -->
          </div>
          <!-- /.card -->
          </div>
    </section>
    <!-- /.content -->
    <script src="../../../resources/build/js/vehiculoExcel.js"></script>
    <!-- bs-custom-file-input -->
<script src="../../../resources/plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>
  </div>
  <!-- /.content-wrapper -->
  