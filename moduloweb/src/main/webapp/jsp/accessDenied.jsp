<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>
	<title>Acesso Negado</title>

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
		    </div>
		</nav>
	</header>

	<div class="container">
			<div class="py-5">
                <div class="alert alert-warning">
                    <div class="text-center">
                        <div class="m-4 m-lg-5">
                            <h1 class="display-5 fw-bold">Você não tem permissão para acessar esta página</h1>
                        </div>
                    </div>
                </div>
			</div>
	</div>

	<script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>