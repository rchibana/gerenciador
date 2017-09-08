<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
</head>
	<body>
	
	<c:if test="${usuarioLogado != null}">
		Logado como ${usuarioLogado.email} <br/>
	</c:if>
	
	Bem vindo ao nosso gerenciador de empresas!<br/>
	<form action="executa" method="POST">
		<input type="hidden" name="tarefa" value="NovaEmpresa" />
		Nome: <input type="text" name="nome"/>
		<input type="submit" value="Enviar"/>
	</form>
	
	<form action="login" method="post">
		Email: <input type="text" name="email"/>
		Senha: <input type="password" name="senha" />
		<input type="submit" value="Login" />
	</form>
	
	<form action="executa" method="POST">
		<input type="hidden" name="tarefa" value="Logout">
		<input type="submit" value="Logout">
	</form>
	
	</body>
</html>