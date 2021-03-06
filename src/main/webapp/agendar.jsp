<!DOCTYPE html>
<%@page import="bancodados.cadastro.ConsultasMedicas"%>
<%@page import="bancodados.cadastro.*"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin - Bootstrap Admin Template</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/sb-admin.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="css/plugins/morris.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.jsp">AG.CONSULTA</a>
			</div>
			<!-- Top Menu Items -->
			<ul class="nav navbar-right top-nav">
				
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="fa fa-user"></i> Paulo
						Henrique<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#"><i class="fa fa-fw fa-user"></i> Perfil</a></li>
						<li><a href="#"><i class="fa fa-fw fa-envelope"></i>
								Caixa de Entrada</a></li>
						<li><a href="#"><i class="fa fa-fw fa-gear"></i>
								Configura��es</a></li>
						<li class="divider"></li>
						<li><a href="#"><i class="fa fa-fw fa-power-off"></i>
								Sair</a></li>
					</ul></li>
			</ul>
			<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav">
					<li><a href="index.jsp"><i class="fa fa-fw fa-dashboard"></i>
							Dashboard</a></li>
					<li><a href="agendarconsulta"><i
							class="fa fa-fw fa-bar-chart-o"></i> Agendar Consultas</a></li>
					<li><a href="consultas"><i class="fa fa-fw fa-table"></i>
							Listar Consultas</a></li>
					
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</nav>

		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Agendar</h1>
						<ol class="breadcrumb">
							<li><i class="fa fa-dashboard"></i> <a href="index.html">Dashboard</a>
							</li>
							<li class="active"><i class="fa fa-bar-chart-o"></i> Agendar
							</li>
						</ol>
					</div>
				</div>
				<!-- /.row -->



				<div class="row">
					<div class="col-lg-10">

						<form role="form">
							<div class="form-group">
								<label>ID Cadastro:</label> 
							<input class="form-control" name="id" value="${param.id}">
								<p class="help-block">Digite o nome completo do paciente</p>
							</div>

							<div class="form-group">
								<label>Nome do Paciente</label> 
								<input class="form-control" name="nomePaciente" value="${param.nomePaciente}">
								<p class="help-block">Digite o nome completo do paciente</p>
							</div>

							<div class="form-group">
								<label>Telefone:</label> 
								<input class="form-control"	placeholder="(DDD) 0000-0000" name="telefone" value="${param.telefone}">
								<p class="help-block">Digite o telefone no formato acima</p>
							</div>
							
							<div class="form-group">
								<label>Data:</label> 
								<input class="form-control" placeholder="00/00/2016"  name="data" value="${param.data}">
							</div>

							<div class="form-group">
								<label>Hor�rio</label> 
								<input class="form-control" placeholder="00:00" name="horario" value="${param.horario}">
							</div>
							

							<div class="form-group">
								<label>Observa��o</label>
								<!-- <textarea class="form-control" rows="3" name="observacao" value="${param.observacao}"></textarea> -->
								<input class="form-control" placeholder="Exemplo: Conv�nio" name="observacao" value="${param.observacao}">
							</div>

							<input type="submit" class="btn btn-lg btn-success" name="acao" value="Incluir">
							<input type="submit" class="btn btn-lg btn-primary" name="acao" value="Alterar">
							<input type="submit" class="btn btn-lg btn-danger" name="acao" value="Excluir">
							<input type="button" class="btn btn-lg btn-warning" onclick="location.href='?'" value="Limpar">

						</form>
						
						

					</div>

				</div>
				<!-- /.row -->
				
	
			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Morris Charts JavaScript -->
	<script src="js/plugins/morris/raphael.min.js"></script>
	<script src="js/plugins/morris/morris.min.js"></script>
	<script src="js/plugins/morris/morris-data.js"></script>

	<!-- Flot Charts JavaScript -->
	<!--[if lte IE 8]><script src="js/excanvas.min.js"></script><![endif]-->
	<script src="js/plugins/flot/jquery.flot.js"></script>
	<script src="js/plugins/flot/jquery.flot.tooltip.min.js"></script>
	<script src="js/plugins/flot/jquery.flot.resize.js"></script>
	<script src="js/plugins/flot/jquery.flot.pie.js"></script>
	<script src="js/plugins/flot/flot-data.js"></script>

</body>

</html>
