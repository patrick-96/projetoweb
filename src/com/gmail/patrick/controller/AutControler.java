package com.gmail.patrick.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gmail.patrick.entidades.Usuario;
import com.gmail.patrick.jdbc.UsuarioDao;

/**
 * Servlet implementation class AutControler
 */
@WebServlet(name= "Autenticador", urlPatterns = {"/autcontroler"})
public class AutControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutControler() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession(false);
		if(sessao!=null){
		      sessao.invalidate();
		}
		
		response.sendRedirect("login.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Usuario usu = new Usuario();
		usu.setLogin(login);
		usu.setSenha(senha);
		
		UsuarioDao ud= new UsuarioDao();
		Usuario usuario = ud.autenticar(usu);
		
		if(usuario != null){
			
			HttpSession sessao = request.getSession();
			sessao.setMaxInactiveInterval(5000);
			sessao.setAttribute("usuLogado", usuario);
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else{
			response.sendRedirect("login.html");
		}
	}

}
