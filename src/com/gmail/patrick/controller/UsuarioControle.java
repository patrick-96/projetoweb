package com.gmail.patrick.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gmail.patrick.entidades.Usuario;
import com.gmail.patrick.jdbc.UsuarioDao;

@WebServlet("/usucontroler")
public class UsuarioControle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioControle() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("acao");

		UsuarioDao ud = new UsuarioDao();
//#############################################################################################
		
		if (acao != null && acao.equals("excluir")) {

			String id = request.getParameter("id");

			Usuario usu = new Usuario();
			usu.setId(Integer.parseInt(id));
			ud.Excluir(usu);
			
			response.sendRedirect("usucontroler?acao=list");
		}
//#############################################################################################

		if (acao != null && acao.equals("alterar")) {

			String id = request.getParameter("id");
			Usuario usu = ud.buscaPorId(Integer.parseInt(id));

			request.setAttribute("usuario", usu);

			RequestDispatcher saida = request.getRequestDispatcher("usuario.jsp");
			saida.forward(request, response);
			
			
		}
//#############################################################################################
		
		if (acao != null && acao.equals("cad")) {

			Usuario usu = new Usuario();
			usu.setId(0);
			usu.setNome("");
			usu.setLogin("");
			usu.setSenha("");

			request.setAttribute("usuario", usu);
			RequestDispatcher saida = request
					.getRequestDispatcher("usuario.jsp");
			saida.forward(request, response);

		}
//#############################################################################################

		if (acao != null && acao.equals("list")) {
			List<Usuario> lista = ud.buscarTodos();

			request.setAttribute("lista", lista);

			RequestDispatcher saida = request
					.getRequestDispatcher("listausu.jsp");
			saida.forward(request, response);

		}
	}
//#############################################################################################

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("txtid");
		String nome = request.getParameter("txtnome");
		String login = request.getParameter("txtlogin");
		String senha = request.getParameter("txtsenha");

		Usuario usu = new Usuario();

		if (id != "") {
			usu.setId(Integer.parseInt(id));
		}

		usu.setNome(nome);
		usu.setLogin(login);
		usu.setSenha(senha);

		UsuarioDao ud = new UsuarioDao();
		ud.Salvar(usu);

		PrintWriter saida = response.getWriter();
		saida.print("Salvo  com sucesso!");
	}

}
