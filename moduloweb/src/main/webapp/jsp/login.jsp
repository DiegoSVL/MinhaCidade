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
		    </div>
		</nav>
	</header>

    <div class="container">
        <div class="py-5">
            <div class="container px-lg-5">
                <div class="p-4 p-lg-5 bg-light rounded-3 text-center">
                      <form method="POST" action="login" class="form-signin">
                        <h2 class="form-heading">Log in</h2>

                        <div class="form-group ${error != null ? 'has-error' : ''}">
                            <span>${message}</span>
                            <div class="form-group col-md-6 offset-md-3">
                                <input name="username" type="text" class="form-control" placeholder="Usuário"
                                       autofocus="true"/>
                            </div>
                            <div class="form-group col-md-6 offset-md-3">
                                <input name="password" type="password" class="form-control" placeholder="Senha"/>
                            </div>
                            <span>${error}</span>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                            <div class="form-group col-md-6 offset-md-3">
                                <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
                            </div>
                        </div>
                      </form>
                </div>
            </div>
		</div>
	</div>

	<script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  </body>
</html>