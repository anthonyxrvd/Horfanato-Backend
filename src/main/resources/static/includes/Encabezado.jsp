	
	<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<spring:url value="/resources" var="urlPublic" />
	
	<nav class="navbar navbar-dark bg-dark">
		<a style="color: white" class="navbar-toggler"><span
			class="navbar-toggler-icon"></span>Home</a>
		<div class="dropdown">
			<a style="color: white" href="#" class="nav-link dropdown-toggle"
				data-toggle="dropdown">Cerrar Sesion</a>
			<div class="dropdown-menu text-center">
				<a><img height="60" width="60"src="${urlPublic}/images/login.png"></a><br>
				<a> ${nombre}</a>
				<div class="dropdown-divider"></div>
				<a href="acceso" class="dropdown-item">Salir</a>
			</div>
		</div>
	</nav>