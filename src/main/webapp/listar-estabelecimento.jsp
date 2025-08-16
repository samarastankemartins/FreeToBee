<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Pesquisa Estabelecimentos</title>
	</head>
	<body>
		<div>
		<input type='search' id='pesquisa-estabelecimento' placeholder='Procure por estabelecimentos...'>
			<div>
				<c:forEach var="estabelecimento" items="${estabelecimento}">
				
					<h1><c:out value="${estabelecimento.nome}"/></h1>	
					<br>		
					<h4><c:out value="${estabelecimento.telefone}"/></h4>
					<br>
					<h4><c:out value="${estabelecimento.tipoEstabelecimento}" /></h4>
					
				</c:forEach>
			</div>
			<br>
		</div>
	</body>
</html>