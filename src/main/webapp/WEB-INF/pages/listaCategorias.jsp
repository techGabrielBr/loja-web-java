<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../components/include.jsp" %>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Lista Categorias</title>
</head>
<body>
	<%@ include file="../components/nav.jsp" %>
	<div class="container-fluid">
		<div class="row g-0">
			<div class="col-12 px-4 pb-4" style="padding-top: 80px;">
				<h3 class="mb-4 border-bottom pb-2">Lista de Categorias</h3>
				
				<div>
					<form action="./categoria?mode=CriaCategoria" method="post" autocomplete="off" class="d-flex">
						<input type="text" class="form-control" style="margin-right: 7px !important" name="nome" required>
						<button type="submit" class="btn btn-success">Adicionar</button>
					</form>
				</div>
				
				<div class="table-responsive">
					<table class="table table-hover mt-4">
					  <thead>
					    <tr>
					      <th scope="col" class="col-1">Id</th>
					      <th scope="col" class="col-9">Nome</th>
					      <th scope="col" class="col-1">Remover</th>
					      <th scope="col" class="col-1">Editar</th>
					    </tr>
					  </thead>
					  <tbody>
					  	<c:forEach items="${categorias}" var="categoria">
						    <tr class="align-middle">
						      <td>
						      	${categoria.id}
						      </td>
						      <td>
						      	${categoria.nome}
						      </td>
						      <td>
						      	<a href="./categoria?id=${categoria.id}&mode=RemoveCategoria" class="btn btn-danger">Remover</a>
						      </td>
						      <td>
						      	<button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#editaCategoria"
						      		onclick="editCategoria('${categoria.nome}', '${categoria.id}')">Editar</button>
						      </td>
						    </tr>
					    </c:forEach>
					  </tbody>
					</table>
				</div>
			</div>
		</div>
		
		<div class="modal fade" id="editaCategoria" tabindex="-1" aria-labelledby="editaCategoriaModal" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="editaCategoriaLabel">Editar Categoria</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		      	<form action="./categoria?mode=EditaCategoria" method="POST" autocomplete="off">
		      		<label for="id" class="form-label">Id:</label>
		      		<input type="text" value="" name="id" id="id" class="form-control bg-light" readonly>
		      		
		      		<label for="nome" class="form-label mt-3">Nome:</label>
		      		<input type="text" value="" name="nome" id="nome" class="form-control">
		      			
			        <div class="float-end mt-3">
			        	<button type="button" class="btn btn-danger" data-bs-dismiss="modal">Fechar</button>
			        	<button type="submit" class="btn btn-success">Salvar</button>
			        </div>
		      	</form>
		      </div>
		    </div>
		  </div>
		</div>
	</div>
	
	<script src="js/listaCategorias.js"></script>
</body>
</html>