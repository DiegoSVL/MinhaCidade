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
				<a class="navbar-brand" href="/demandas">Minha Cidade</a>

				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-collapse" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse wrapper" id="navbar-collapse">
	                <ul class="navbar-nav mr-auto">
		                <li class="nav-item"><a class="nav-link" href="/">Home</a></li>
		             	<li class="nav-item active"><a class="nav-link" href="/demandas">Listar demandas</a></li>
		            </ul>
	    	    </div>
		    </div>
		</nav>
	</header>

	<div class="container">
			<h1 class="display-4">${demanda.descricao}</h1>

			<p class="lead">${demanda.descricao}</p>

			<hr class="my-4">

						<p><strong>Rua: </strong> ${demanda.endereco.logradouro}</p>
            			<p><strong>Número: </strong> ${demanda.endereco.numero}</p>
            			<p><strong>Bairro: </strong> ${demanda.endereco.bairro}</p>

			<hr class="my-4">

			<div>
				<a class="btn btn-primary" href="/demandas">Voltar</a>
				<a class="btn btn-primary" href="/excluirDemanda/${demanda.id}" onclick="return confirm('Você deseja excluir essa demanda?')")>Excluir</a>
			</div>
	</div>

	<script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>