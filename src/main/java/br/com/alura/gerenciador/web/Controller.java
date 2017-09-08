package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/executa")
public class Controller extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		final String tarefa = req.getParameter("tarefa");
		
		if(tarefa.isEmpty()) {
			throw new IllegalArgumentException("Precisa informar o nome da tarefa.");
		}
		
		final String nomeDaClasse = "br.com.alura.gerenciador.web." + tarefa;
		
		try {
			
			final Class type = Class.forName(nomeDaClasse);
			Tarefa instancia;instancia = (Tarefa) type.newInstance();
			final String pagina = instancia.executa(req, resp);
			RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
			dispatcher.forward(req, resp);
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new ServletException(e);
		}
		
	}

}
