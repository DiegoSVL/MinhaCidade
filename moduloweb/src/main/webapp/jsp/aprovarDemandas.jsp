<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>
	<title>Aprovar Demandas</title>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
	<link href="/css/custom.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-primario sticky-top">
			<div class="container">
				<a class="navbar-brand" href="/">Minha Cidade</a>

				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-collapse" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse wrapper" id="navbar-collapse">
	                <ul class="navbar-nav mr-auto">
		                <li class="nav-item"><a class="nav-link" href="/">Home</a></li>
		             	<li class="nav-item active"><a class="nav-link" href="/admin/aprovarDemandas">Aprovar problemas</a></li>
		             	<li class="nav-item"><a class="nav-link" href="/user/preencherDemanda">Finalizar problemas</a></li>
		             	<li class="nav-item">
		             	    <c:url var="logoutUrl" value="/logout" />
                            <form action="${logoutUrl}" id="logout" method="post">
                                <input type="hidden" name="${_csrf.parameterName}"
                                    value="${_csrf.token}" />
                            </form>
                            <a class="nav-link" href="#" onclick="document.getElementById('logout').submit();">Sair</a>
                        </li>
		            </ul>
	    	    </div>
		    </div>
		</nav>
	</header>

	<div class="container">
		<h1 class="display-6">Problemas aguardando aprovação</h1>

		<hr class="my-4">

		<table class="table table-hover table-sm">
			<thead class="thead-light">
				<tr>
					<th scope="col">Código</th>
					<th class="d-none d-sm-block" scope="col">Título</th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${demandas}" var="demanda">
					<tr>
						<td>${demanda.id}</td>

				        <td class="d-none d-md-block d-lg-none">
							<c:set var="titulo" value="${demanda.titulo}" />
							<c:choose>
								<c:when test="${fn:length(titulo) gt 50}">
									${fn:substring(titulo, 0, 48)}...
								</c:when>
								<c:otherwise>
									${titulo}
								</c:otherwise>
							</c:choose>
						</td>

						<td class="d-none d-lg-block d-xl-none">
							<c:set var="titulo" value="${demanda.titulo}" />
							<c:choose>
								<c:when test="${fn:length(titulo) gt 80}">
									${fn:substring(titulo, 0, 78)}...
								</c:when>
								<c:otherwise>
									${titulo}
								</c:otherwise>
							</c:choose>
						</td>

						<td class="d-none d-xl-block">
							<c:set var="titulo" value="${demanda.titulo}" />
							<c:choose>
								<c:when test="${fn:length(titulo) gt 110}">
									${fn:substring(titulo, 0, 107)}...
								</c:when>
								<c:otherwise>
									${titulo}
								</c:otherwise>
							</c:choose>
						</td>

						<td><a class="btn btn-outline-primary btn-sm" href="/user/detalharDemanda/${demanda.id}">Detalhar</a></td>
						<td><a class="btn btn-outline-primary btn-sm" href="/user/detalharDemanda/${demanda.id}">Aprovar</a></td>
						<td><a class="btn btn-outline-primary btn-sm" href="/user/excluirDemanda/${demanda.id}" onclick="return confirm('Você deseja excluir essa demanda?')">Cancelar</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<hr class="my-4">

		<div>
			<a class="btn btn-primary" href="/preencherDemanda">Criar demanda</a>
		</div>
	</div>

	<script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>