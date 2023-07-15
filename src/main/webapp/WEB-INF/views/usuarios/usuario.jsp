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
            </div>
            <!-- /.card-header -->
            <div class="card-body">
              <table id="example1" class="table table-bordered table-striped">
                <thead>
                <tr>
                  <th>Usuario</th>
                  <th>mail</th>
                  <th>estatus</th>
                  <th>Opciones</th>
                </tr>
                </thead>
                <tbody>
               		<c:forEach items="${usuarios.content}" var="usuario">
               			<tr>
               				<td>${usuario.username}</td>
               				<td>${usuario.mail}</td>
               				<td>${usuario.enabled}</td>
               				<td>
               					<button type="button" class="btn btn-block btn-outline-info" data-toggle="modal" data-target="#modal-lg" onclick="editar('${usuario.username}')")>Editar</button>
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
  <c:if test="${not usuarios.first}">
    <li class="paginate_button page-item previous">
      <a href="${pageContext.request.contextPath}/usuarios/?page=${usuarios.number - 1}" aria-controls="example1"
        data-dt-idx="0" tabindex="0" class="page-link">Anterior</a>
    </li>
  </c:if>
  <c:choose>
    <c:when test="${empty usuarios or usuarios.totalPages == 0}">
      <!-- No hay registros disponibles -->
      <!-- Puedes mostrar un mensaje o tomar alguna otra acción adecuada -->
    </c:when>
    <c:when test="${usuarios.totalPages <= 5}">
      <c:forEach begin="0" end="${usuarios.totalPages - 1}" var="i">
        <c:choose>
          <c:when test="${i eq usuarios.number}">
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
      <c:set var="startPage" value="${Math.max(0, usuarios.number - 2)}" />
      <c:set var="endPage" value="${Math.min(usuarios.totalPages - 1, usuarios.number + 2)}" />

      <c:if test="${startPage > 0}">
        <li class="paginate_button page-item">
          <a href="${pageContext.request.contextPath}/vehiculo/?page=${startPage - 1}" class="page-link">...</a>
        </li>
      </c:if>

      <c:forEach begin="${startPage}" end="${endPage}" var="i">
        <c:choose>
          <c:when test="${i eq usuarios.number}">
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

      <c:if test="${endPage < usuarios.totalPages - 1}">
        <li class="paginate_button page-item">
          <a href="${pageContext.request.contextPath}/vehiculo/?page=${endPage + 1}" class="page-link">...</a>
        </li>
      </c:if>
    </c:otherwise>
  </c:choose>
  <c:if test="${not usuarios.last}">
    <li class="paginate_button page-item next">
      <a href="${pageContext.request.contextPath}/vehiculo/?page=${usuarios.number + 1}" aria-controls="example1"
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
		<form action="/usuarios/guardar" method="post">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Usuario</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
				<input type="hidden" class="form-control" name="id" id="idUsuario">
					<div class="row">
						<div class="col-4">
							<div class="form-group">
								<input type="hidden"
									class="form-control" style="width: 100%;" name="username" id="username"/>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<div class="form-group">
								<label class="col-form-label" for="password">Contraseña:</label> <input type="text"
									class="form-control" style="width: 100%;"
									name="password" id="password"/>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<div class="form-group">
								<label class="col-form-label" for="mail">Correo:</label> <input type="text"
									class="form-control" style="width: 100%;"
									name="mail" id="mail"/>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<div class="form-group">
								<label class="col-form-label" for="enabled">Estatus:</label> <select
									class="form-control select2" style="width: 100%;"
									name="enabled" id="enabled">
									<option value="-1">-- SELECCIONAR --</option>
									<option value="1">ACTIVO</option>
									<option value="0">DESACTIVADO</option>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<div class="form-group">
								<label class="form-label">ADMIN:</label>
								<input type="checkbox"
									name="roles" value="ADMIN" id="rol1">
							</div>
							<div class="form-group">
								<label class="col-form-label">VENTAS:</label>
								<input type="checkbox" 
									name="roles" value="VENTAS" id="rol2">
							</div>
							<div class="form-group">
								<label class="col-form-label">RH:</label>
								<input type="checkbox"
									name="roles" value="RH" id="rol3">
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
	    <script type="text/javascript">
	var mensaje = "<%= request.getAttribute("mensaje") %>";
    if (mensaje && mensaje != "null" && mensaje.trim().length > 0) {
    	if (mensaje.startsWith("Se modifico")) 
        	swal("Usuario Modificado", mensaje, "success");
		else
			swal("Error", mensaje, "error");		
    }
	</script>
	<!-- /.modal-dialog -->
	<script src="../../../resources/build/js/usuario.js"></script>
</div>
<!-- /.modal -->
  