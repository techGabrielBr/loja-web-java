<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../components/include.jsp" %>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Editar Produto</title>
</head>
<body>
	<%@ include file="../components/nav.jsp" %>
	<div class="container-fluid">
		<div class="row g-0 w-100 min-vh-100 align-items-center justify-content-center px-4 pb-4"
			style="padding-top: 80px;">
			<div class="col-md-8 col-lg-6">
				<h3 class="mb-4 border-bottom pb-2">Formulário Edita Produto</h3>
				
				<form action="./produto?mode=EditaProduto" method="post" autocomplete="off">
					<input type="hidden" name="idProduto" value="${produto.id}">
					<div>
						<label for="name" class="form-label">Nome:</label>
						<input value="${produto.nome}" type="text" name="name" class="form-control" required maxlength="200">
					</div>
					<div class="mt-3">
						<label for="descricao" class="form-label">Descrição:</label>
						<textarea name="descricao" class="form-control" rows="3" required maxlength="200">${produto.descricao}</textarea>
					</div>
					<div class="mt-3">
						<label for="categoria" class="form-label">Categoria:</label>
						<select class="form-select selectCategoria" name="idCategoria" onchange="setSelectedOption(${produto.categoriaId})">
							<!-- LISTAGEM DE CATEGORIAS -->	
						</select> 
					</div>
					<button type="submit" class="btn btn-primary mt-3 float-end" 
						style="margin-left: 5px !important;">Enviar</button>
					<button type="reset" class="btn btn-danger mt-3 float-end">Limpar</button>
				</form>
			</div>
		</div>
	</div>
	<script src="js/selectCategoria.js"></script>
</body>
</html>