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
            		<button type="button" class="btn btn-block btn-info" data-toggle="modal" data-target="#modal-lg" onclick="limpiarCampos()">Agregar</button>
            	</div>
            </div>
            <!-- /.card-header -->
            <div class="card-body">
              <table id="example1" class="table table-bordered table-striped">
                <thead>
                <tr>
                  <th>Tipo Carro</th>
                  <th>N Serie</th>
                  <th>Marca</th>
                  <th>SubMarca</th>
                  <th>Modelo</th>
                  <th>Color</th>
                  <th>Estado</th>
                  <th>Precio</th>
                  <th>Ubicacion</th>
                  <th>N Puertas</th>
                  <th>Opciones</th>
                </tr>
                </thead>
                <tbody>
               		<c:forEach items="${vehiculos.content}" var="vehiculo">
               			<tr>
               				<td>${vehiculo.tipoAutomovil.tipo}</td>
               				<td>${vehiculo.numeroSerie}</td>
               				<td>${vehiculo.marca.marca}</td>
               				<td>${vehiculo.subMarca.subMarca}</td>
               				<td>${vehiculo.modelo}</td>
               				<td>${vehiculo.color.color}</td>
               				<td>${vehiculo.estado.estado}</td>
               				<td>${vehiculo.precio}</td>
               				<td>${vehiculo.sucursal.sucursal}</td>
               				<td>${vehiculo.nPuertas}</td>
               				<td>
               					<button type="button" class="btn btn-block btn-outline-info" data-toggle="modal" data-target="#modal-lg" onclick=editar(${vehiculo.id})>Editar</button>
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
  <c:if test="${not vehiculos.first}">
    <li class="paginate_button page-item previous">
      <a href="${pageContext.request.contextPath}/vehiculo/?page=${vehiculos.number - 1}" aria-controls="example1"
        data-dt-idx="0" tabindex="0" class="page-link">Anterior</a>
    </li>
  </c:if>
  <c:choose>
    <c:when test="${empty vehiculos or vehiculos.totalPages == 0}">
      <!-- No hay registros disponibles -->
      <!-- Puedes mostrar un mensaje o tomar alguna otra acción adecuada -->
    </c:when>
    <c:when test="${vehiculos.totalPages <= 5}">
      <c:forEach begin="0" end="${vehiculos.totalPages - 1}" var="i">
        <c:choose>
          <c:when test="${i eq vehiculos.number}">
            <li class="paginate_button page-item active">
              <a href="#" aria-controls="example1" data-dt-idx="1" tabindex="0" class="page-link">${i + 1}</a>
            </li>
          </c:when>
          <c:otherwise>
            <li class="paginate_button page-item">
              <a href="${pageContext.request.contextPath}/vehiculo/?page=${i}" class="page-link">${i + 1}</a>
            </li>
          </c:otherwise>
        </c:choose>
      </c:forEach>
    </c:when>
    <c:otherwise>
      <c:set var="startPage" value="${Math.max(0, vehiculos.number - 2)}" />
      <c:set var="endPage" value="${Math.min(vehiculos.totalPages - 1, vehiculos.number + 2)}" />

      <c:if test="${startPage > 0}">
        <li class="paginate_button page-item">
          <a href="${pageContext.request.contextPath}/vehiculo/?page=${startPage - 1}" class="page-link">...</a>
        </li>
      </c:if>

      <c:forEach begin="${startPage}" end="${endPage}" var="i">
        <c:choose>
          <c:when test="${i eq vehiculos.number}">
            <li class="paginate_button page-item active">
              <a href="#" aria-controls="example1" data-dt-idx="1" tabindex="0" class="page-link">${i + 1}</a>
            </li>
          </c:when>
          <c:otherwise>
            <li class="paginate_button page-item">
              <a href="${pageContext.request.contextPath}/vehiculo/?page=${i}" class="page-link">${i + 1}</a>
            </li>
          </c:otherwise>
        </c:choose>
      </c:forEach>

      <c:if test="${endPage < vehiculos.totalPages - 1}">
        <li class="paginate_button page-item">
          <a href="${pageContext.request.contextPath}/vehiculo/?page=${endPage + 1}" class="page-link">...</a>
        </li>
      </c:if>
    </c:otherwise>
  </c:choose>
  <c:if test="${not vehiculos.last}">
    <li class="paginate_button page-item next">
      <a href="${pageContext.request.contextPath}/vehiculo/?page=${vehiculos.number + 1}" aria-controls="example1"
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
		<form action="/vehiculo/guardar" method="post" onsubmit="return validarFormulario()">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Vehiculo</h4>
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
								<label class="col-form-label" for="sucursal">Sucursal:</label> <select
									class="form-control select" style="width: 100%;"
									name="sucursal" id="sucursal">
									<option value="-1">-- SELECCIONAR --</option>
									<c:forEach items="${sucursales}" var="sucursal">
										<option value="${sucursal.id}">${sucursal.sucursal}</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<div class="form-group">
								<label class="col-form-label" for="estado">Estado:</label> <select
									class="form-control select2" style="width: 100%;"
									name="estado" id="estado">
									<option value="-1">-- SELECCIONAR --</option>
									<c:forEach items="${estados}" var="estado">
										<option value="${estado.id}">${estado.estado}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-4">
							<div class="form-group">
								<label class="col-form-label" for=tipoAutomovil>Tipo
									Vehiculo:</label> <select class="form-control select2"
									style="width: 100%;" name="tipoAutomovil" id="tipoAutomovil">
									<option value="-1">-- SELECCIONAR --</option>
									<c:forEach items="${tiposCarro}" var="tipo">
										<option value="${tipo.id}">${tipo.tipo}</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<div class="form-group">
								<label class="col-form-label" for="marca">Marca:</label> <select
									class="form-control select2" style="width: 100%;"
									name="marca" id="marca">
									<option value="-1">-- SELECCIONAR --</option>
									<c:forEach items="${marcas}" var="marca">
										<option value="${marca.id}">${marca.marca}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-4">
							<div class="form-group">
								<label class="col-form-label" for="subMarca">SubMarca:</label> <select
									class="form-control select2" style="width: 100%;"
									name="subMarca" id="subMarca"></select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<div class="form-group">
								<label class="col-form-label" for="numeroSerie">N Serie:</label>
								<input type="text" class="form-control "
									name="numeroSerie" id="numeroSerie">
							</div>
						</div>
						<div class="col-4">
							<div class="form-group">
								<label class="col-form-label" for="color">Color:</label> <select
									class="form-control select2" style="width: 100%;"
									name="color" id="color">
									<option value="-1">-- SELECCIONAR --</option>
									<c:forEach items="${colores}" var="color">
										<option value="${color.id}">${color.color}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-4">
							<div class="form-group">
								<label class="col-form-label" for="nPuertas">N Puertas:</label>
								<input type="text" class="form-control" name="nPuertas" id="nPuertas">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<div class="form-group">
								<label class="col-form-label" for="modelo">Modelo:</label> <input
									type="text" class="form-control" name="modelo" id="modelo">
							</div>
						</div>
						<div class="col-4">
							<div class="form-group">
								<label class="col-form-label" for="precio">Precio:</label> <input
									type="text" class="form-control" name="precio" id="precio">
							</div>
						</div>
						<div class="col-4">
							<div class="form-group">
								<label class="col-form-label" for="kilometraje">kilometraje:</label>
								<input type="text" class="form-control"
									name="kilometraje" id="kilometraje">
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-12">
							<div class="form-group">
								<label class="col-form-label" for="observaciones">Observaciones:</label>
								<textarea class="form-control" rows="4" name="observaciones" id="observaciones"></textarea>
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
	<script type="text/javascript">
	var mensaje = "<%= request.getAttribute("mensaje") %>";
    if (mensaje && mensaje != "null" && mensaje.trim().length > 0) {
		if(mensaje == 'agregado')
        	swal("Ingresado", "El vehículo se agregó al inventario", "success");
		else if(mensaje == 'editado')
			swal("Modificado", "El vehículo ha sido modificado", "success");
		else
			swal("Error", "No fue posible ingresar el vehículo", "error");		
    }
	</script>
	
	<script src="../../../resources/build/js/vehiculo.js"></script>
</div>
<!-- /.modal -->
  