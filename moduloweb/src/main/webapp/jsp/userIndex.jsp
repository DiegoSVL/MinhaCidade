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
		             	<li class="nav-item"><a class="nav-link" href="/user/demandas">Problemas Relatados</a></li>
		             	<li class="nav-item"><a class="nav-link" href="/user/preencherDemanda">Novo Problema</a></li>
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
			<div class="py-5">
                <div class="container px-lg-5">
                    <div class="p-4 p-lg-5 bg-light rounded-3 text-center">
                        <div class="m-4 m-lg-5">
                            <h1 class="display-5 fw-bold">Você pode fazer a diferença na sua cidade!</h1>
                            <p class="fs-4">Sua colaboração é fundamental para que possamos construir uma cidade mais segura, limpa e organizada.</p>
                            <a class="btn btn-primary btn-lg" href="/user/preencherDemanda">Reportar Problema</a>
                        </div>
                    </div>
                </div>
			</div>
	</div>

	<script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>