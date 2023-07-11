<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <jsp:include page="../layout/master.jsp" />
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">Inventario</h1>
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
            		<button type="button" class="btn btn-block btn-info" data-toggle="modal" data-target="#modal-lg" onclick="limpiarCampos()">Agregar</button>
            	</div>
            </div>
            <!-- /.card-header -->
            <div class="card-body">
              <table id="example1" class="table table-bordered table-striped">
                <thead>
                <tr>
                  <th>Numero de Empleado</th>
                  <th>Nombre</th>
                  <th>Sucursal</th>
                  <th>Opciones</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${empleados.content}" var="empleado">
                	 <tr>
                	    <td>${empleado.idEmpleado}</td>
                  		<td>${empleado.nombre} ${empleado.paterno} ${empleado.materno}</td>
                  		<td>${empleado.sucursal.sucursal}</td>
                  		<td>
               				<button type="button" class="btn btn-block btn-outline-info" data-toggle="modal" data-target="#modal-lg" onclick=editar(${empleado.id})>Editar</button>
               				<button type="button" class="btn btn-block btn-outline-danger"onclick=eliminar(${empleado.id})>Eliminar</button>
               			</td>
               		 </tr>
                </c:forEach>
                </tbody>
              </table>
            </div>
            
                        <!-- Paginado -->
			<div class="row">
				<div class="col-sm-12 col-md-5">
					<div class="dataTables_info" id="example1_info" role="status"
						aria-live="polite"></div>
				</div>
				<div class="col-sm-12 col-md-7">
					<div class="dataTables_paginate paging_simple_numbers"
						id="example1_paginate">
						
<ul class="pagination">
  <c:if test="${not empleados.first}">
    <li class="paginate_button page-item previous">
      <a href="${pageContext.request.contextPath}/empleados/?page=${empleados.number - 1}" aria-controls="example1"
        data-dt-idx="0" tabindex="0" class="page-link">Anterior</a>
    </li>
  </c:if>
  <c:choose>
    <c:when test="${empty empleados or empleados.totalPages == 0}">
      <!-- No hay registros disponibles -->
      <!-- Puedes mostrar un mensaje o tomar alguna otra acción adecuada -->
    </c:when>
    <c:when test="${empleados.totalPages <= 5}">
      <c:forEach begin="0" end="${empleados.totalPages - 1}" var="i">
        <c:choose>
          <c:when test="${i eq empleados.number}">
            <li class="paginate_button page-item active">
              <a href="#" aria-controls="example1" data-dt-idx="1" tabindex="0" class="page-link">${i + 1}</a>
            </li>
          </c:when>
          <c:otherwise>
            <li class="paginate_button page-item">
              <a href="${pageContext.request.contextPath}/empleados/?page=${i}" class="page-link">${i + 1}</a>
            </li>
          </c:otherwise>
        </c:choose>
      </c:forEach>
    </c:when>
    <c:otherwise>
      <c:set var="startPage" value="${Math.max(0, empleados.number - 2)}" />
      <c:set var="endPage" value="${Math.min(empleados.totalPages - 1, empleados.number + 2)}" />

      <c:if test="${startPage > 0}">
        <li class="paginate_button page-item">
          <a href="${pageContext.request.contextPath}/empleados/?page=${startPage - 1}" class="page-link">...</a>
        </li>
      </c:if>

      <c:forEach begin="${startPage}" end="${endPage}" var="i">
        <c:choose>
          <c:when test="${i eq empleados.number}">
            <li class="paginate_button page-item active">
              <a href="#" aria-controls="example1" data-dt-idx="1" tabindex="0" class="page-link">${i + 1}</a>
            </li>
          </c:when>
          <c:otherwise>
            <li class="paginate_button page-item">
              <a href="${pageContext.request.contextPath}/empleados/?page=${i}" class="page-link">${i + 1}</a>
            </li>
          </c:otherwise>
        </c:choose>
      </c:forEach>

      <c:if test="${endPage < empleados.totalPages - 1}">
        <li class="paginate_button page-item">
          <a href="${pageContext.request.contextPath}/empleados/?page=${endPage + 1}" class="page-link">...</a>
        </li>
      </c:if>
    </c:otherwise>
  </c:choose>
  <c:if test="${not empleados.last}">
    <li class="paginate_button page-item next">
      <a href="${pageContext.request.contextPath}/empleados/?page=${empleados.number + 1}" aria-controls="example1"
        data-dt-idx="2" tabindex="0" class="page-link">Siguiente</a>
    </li>
  </c:if>
</ul>

					
					</div>
				</div>
			</div>
            
            <!-- /.card-body -->
          </div>
          <!-- /.card -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  
  <div class="modal fade" id="modal-lg">
	<div class="modal-dialog modal-xl">
		<form action="/empleados/guardar" method="post" onsubmit="return validarFormulario()">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Empleado</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
				<input type="hidden" class="form-control" name="id" id="identificador">
					<div class="row">
						<div class="col-4">
							<div class="form-group">
								<label class="col-form-label" for="nombre">Nombre:</label>
								<input type="text" class="form-control "name="nombre" id="nombre">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<div class="form-group">
								<label class="col-form-label" for="paterno">Ap Paterno:</label>
								<input type="text" class="form-control "name="paterno" id="paterno">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<div class="form-group">
								<label class="col-form-label" for="materno">Ap Materno:</label>
								<input type="text" class="form-control "name="materno" id="materno">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<div class="form-group">
								<label class="col-form-label" for="edad">Edad:</label>
								<input type="text" class="form-control "name="edad" id="edad">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<div class="form-group">
								<label class="col-form-label" for="sucursal">sucursal:</label> <select
									class="form-control select2" style="width: 100%;"
									name="sucursal" id="sucursal">
									<option value="-1">-- SELECCIONAR --</option>
									<c:forEach items="${sucursales}" var="sucursal">
										<option value="${sucursal.id}">${sucursal.sucursal}</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<div class="modal-footer justify-content-between">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
						<input type="submit" class="btn btn-info" value="Guardar">
					</div>
				</div>
			</div>
		</form>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
	<script src="../../../resources/build/js/empleado.js"></script>
</div>
<!-- /.modal -->
  
  