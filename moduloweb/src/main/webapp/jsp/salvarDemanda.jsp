<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>
	<title>Detalhar Demanda</title>

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
		             	<li class="nav-item"><a class="nav-link" href="/user/demandas">Listar problemas</a></li>
		             	<li class="nav-item active"><a class="nav-link" href="/user/preencherDemanda">Inserir Novo Problema</a></li>
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
        <form:form method="post" modelAttribute="salvarDemandaForm">
            <h1 class="display-6">Relatar Problema:</h1>

            <hr class="my-4">

            <div class="form-group">
                <label for="titulo"><strong>Título:</strong></label>
                <input class="form-control" name="titulo">${titulo}</input>
                <label for="descricao"><strong>Descricao:</strong></label>
                <textarea class="form-control" name="descricao">${descricao}</textarea>
                <label for="bairro"><strong>Bairro:</strong></label>
                <input class="form-control" name="bairro">${bairro}</input>
                <label for="logradouro"><strong>Logradouro:</strong></label>
                <input class="form-control" name="logradouro">${logradouro}</input>
                <label for="numero"><strong>Número:</strong></label>
                <input class="form-control" name="numero">${numero}</input>
            </div>

            <hr class="my-4">

            <div>

                <button class="btn btn-primary" formaction="/user/salvarDemanda">Salvar</button>

                <a class="btn btn-danger" data-toggle="collapse" href="/" role="button" aria-expanded="false" aria-controls="collapse">
                    <span class="d-block d-sm-none">Cancelar</span><span class="d-none d-sm-block">cancelar</span>
                </a>
            </div>
        </form:form>
	</div>

	<script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>