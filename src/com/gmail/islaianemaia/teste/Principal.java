package com.gmail.islaianemaia.teste;

import java.util.List;

import javax.swing.JOptionPane;

import com.gmail.islaianemaia.entidades.Usuario;
import com.gmail.islaianemaia.jdbc.UsuarioDao;

public class Principal {

	public static void main(String[] args) {
		
		//testeCadastrar();
		//testeAlterar();
		//testeExcluir();
		//testeBuscaTodos();
		//testeBuscaPorId();
		//testeBuscarPorNome();
		testeAutenticar();

	}

	private static void testeCadastrar() {
		Usuario usuario = new Usuario();
		
	   String nome = JOptionPane.showInputDialog("Digite o seu nome");
	   usuario.setNome(nome);
	   String login = JOptionPane.showInputDialog("Digite o seu login");
	   usuario.setLogin(login);
	   String senha = JOptionPane.showInputDialog("digite a sua senha");
	   usuario.setSenha(senha);
	   
	   UsuarioDao ud = new UsuarioDao();
	   ud.cadastra(usuario);
	}
	
	private static void testeAlterar(){
		
		Usuario usu = new Usuario();
		
		Integer id = Integer.parseInt(JOptionPane.showInputDialog("Digte o id que deseja Alterar"));
		usu.setId(id);
		String nome = JOptionPane.showInputDialog("Digite o novo nome");
		usu.setNome(nome);
		String login = JOptionPane.showInputDialog("Digite o novo login");
		usu.setLogin(login);
		String senha = JOptionPane.showInputDialog("Digite a nova senha");
		usu.setSenha(senha);
		
		UsuarioDao ud = new UsuarioDao();
		ud.Alterar(usu);
		
	}
	
	private static void testeExcluir(){
		
		Usuario usu = new Usuario();
		
		Integer id = Integer.parseInt(JOptionPane.showInputDialog("Digite o  id que deseja excluir"));
		usu.setId(id);
		
		UsuarioDao ud = new UsuarioDao();
		ud.Excluir(usu);
	}
	
	private static void testeBuscaTodos(){
		String menssagen = "";
		
		UsuarioDao ud = new UsuarioDao();
		List<Usuario> listaR = ud.buscarTodos();
		
		for(Usuario u:listaR){
			
			menssagen = menssagen +"\n" + u.getId()+" "+ u.getNome()+" "+ u.getLogin()+" "+ u.getSenha();
			
		}
		
		JOptionPane.showMessageDialog(null, menssagen);
	}
	
	private static void testeBuscaPorId(){
		
		Integer id = Integer.parseInt(JOptionPane.showInputDialog("Digite o  id que deseja "));
		
		UsuarioDao ud = new UsuarioDao();
		
		Usuario usuB = ud.buscaPorId(id);
		
		if(usuB != null){
		JOptionPane.showMessageDialog(null, usuB.getId()+" "+ usuB.getNome()+
				                      "  "+usuB.getLogin()+"  "+usuB.getSenha());
		}else{
			JOptionPane.showMessageDialog(null, "Usuario não existe");
		}
	}
	
	private static void testeBuscarPorNome(){
		String texto ="";
		
		String nome = JOptionPane.showInputDialog("Digite o nome que deseja buscar");
		
		UsuarioDao ud = new UsuarioDao();
		List<Usuario> listB = ud.buscaPorNome(nome);
		
		for(Usuario u: listB){
			texto += "\n"+u.getId()+" "+u.getNome()+"  "+u.getLogin()+" "+u.getSenha();
		}
		
		JOptionPane.showMessageDialog(null, texto);
	}
	
	private static void testeAutenticar(){
		
		Usuario  usu = new Usuario();
		
		String login = JOptionPane.showInputDialog("Digite o seu login");
		usu.setLogin(login);
		String senha = JOptionPane.showInputDialog("Digite a sua senha");
		usu.setSenha(senha);
		
		UsuarioDao ud = new UsuarioDao();
		Usuario usuB = ud.autenticar(usu);
		
		JOptionPane.showMessageDialog(null, usuB.getId()+"  "+usuB.getNome()+"  "+usuB.getLogin()+
				                "  "+ usuB.getSenha()); 
		
		
		
	}

}
