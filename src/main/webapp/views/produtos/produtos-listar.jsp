<%@
	page language="java"
	contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"
%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
	<meta charset="UTF-8">
	<title>Lista de Produtos</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>

<body>
	<jsp:include page="../../includes/menu.jsp"></jsp:include>
	
	<h1>lista de produtos</h1>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Marca</th>
				<th>Nome</th>
				<th>Descricao</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="produto" items="${lista}">
				<tr>
					<td>${produto.idProduto}</td>
					<td>${produto.marca}</td>
					<td>${produto.nome}</td>
					<td>${produto.descricao}</td>
					<td>
						<a href="editar?id_produto=${produto.idProduto}">Editar</a>
						<a href="excluir?id_produto=${produto.idProduto}">Excluir</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<br>
	
	<a href="cadastro">novo produto</a>

	<jsp:include page="../../includes/footer.jsp"></jsp:include>
</body>

</html>