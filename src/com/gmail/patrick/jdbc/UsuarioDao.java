package com.gmail.patrick.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.gmail.patrick.entidades.Usuario;

public class UsuarioDao {
	
	Connection c = Conexao.conectar();
//*************************************************************************************************	
	public void cadastra(Usuario usu){
		
		String sql="insert into usuario (nome,login,senha) values(?,?,?)";
		
		try {
			PreparedStatement p = c.prepareStatement(sql);
			p.setString(1, usu.getNome());
			p.setString(2, usu.getLogin());
			p.setString(3, usu.getSenha());
			
			p.execute();
			p.close();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "SQL invalido");
			
			e.printStackTrace();
		}
	}
//***************************************************************************************************
        
	
	 public void Alterar(Usuario usu){
		 
		 String sql ="update usuario set nome=?, login=?, senha=? where id=?";
		 
		 try{
			 PreparedStatement p = c.prepareStatement(sql);
			 p.setString(1, usu.getNome());
			 p.setString(2, usu.getLogin());
			 p.setString(3, usu.getSenha());
			 p.setInt(4, usu.getId());
			 
			 p.execute();
			 p.close();
			 
		 }catch(SQLException e){
			 JOptionPane.showMessageDialog(null,"SQL invalido");
		 }
		 
	 }
	 
//***********************************************************************************************
	 public void Salvar(Usuario usu){
		 
		 if(usu.getId()!= null && usu.getId()!=0){
			
			 Alterar(usu);
		 }else{
			 cadastra(usu);
		 }
	 }
//************************************************************************************************	 
	 public void Excluir(Usuario usu){
		 
		 String sql = "delete from usuario where id=?";
		 
		 try{
			 PreparedStatement p = c.prepareStatement(sql);
			 p.setInt(1, usu.getId());
			 
			 p.execute();
			 p.close();
			 
		 }catch(SQLException e){
			 JOptionPane.showMessageDialog(null,"SQL invalido");
			 
		 }
		 
	 }
	 
//*************************************************************************************************
	 
	 public List<Usuario> buscarTodos(){
		 String sql="select * from usuario ";
		 
		 List<Usuario> lista = new ArrayList<Usuario>();
		 try{
			 PreparedStatement p = c.prepareStatement(sql);
			 ResultSet resu = p.executeQuery();
			 
			 while(resu.next()){
				 
				 Usuario usu = new Usuario();
				 usu.setId(resu.getInt("id"));
				 usu.setNome(resu.getString("nome"));
				 usu.setLogin(resu.getString("login"));
				 usu.setSenha(resu.getString("senha"));
				 
				 lista.add(usu);
			 }
			 
		 }catch(SQLException erro){
			 JOptionPane.showMessageDialog(null, "sql invalido");
		 }
		 return lista;
	 }
//***********************************************************************************************
	 
	 public Usuario buscaPorId(Integer id){
		 
		 String sql = "select * from usuario where id=?";
		 Usuario usu = null;
		 try{
			 PreparedStatement p = c.prepareStatement(sql);
			 p.setInt(1, id);
			 
			 ResultSet resu =p.executeQuery();
			 
			 if(resu.next()){
				usu = new Usuario();
				usu.setId(resu.getInt("id"));
				usu.setNome(resu.getString("nome"));
				usu.setLogin(resu.getString("login"));
				usu.setSenha(resu.getString("senha"));
			 }
			 
		 }catch(SQLException e){
			 JOptionPane.showMessageDialog(null,"SQL invalido");
		 }
		 return usu;
	 }
	 
//***********************************************************************************************
	 
	 public List<Usuario> buscaPorNome(String nome){
		 String sql = "select * from usuario where nome like ?";
		 List<Usuario> lista = new ArrayList<Usuario>();
		 
		 try{
			 PreparedStatement p = c.prepareStatement(sql);
			 p.setString(1, "%"+nome+"%");
			 
			 ResultSet resp = p.executeQuery();
			 
			 while(resp.next()){
			
			 Usuario usu = new Usuario();
			 usu.setId(resp.getInt("id"));
			 usu.setNome(resp.getString("nome"));
			 usu.setLogin(resp.getString("login"));
			 usu.setSenha(resp.getString("senha"));
			 
			 lista.add(usu);
			 }
			 
			 
		 }catch(SQLException e){
			 JOptionPane.showMessageDialog(null, "SQL invalido"+ e.getMessage());
			 
		 }
		 return lista;
	 }
	 
//*********************************************************************************************
	 
	 public Usuario autenticar(Usuario usu){
		
		 String sql = "select * from usuario where login=? and senha=?";
		 Usuario usuR = null;
		 
		 try{
			 PreparedStatement p = c.prepareStatement(sql);
			 p.setString(1, usu.getLogin());
			 p.setString(2, usu.getSenha());
			 
			 ResultSet resp = p.executeQuery();
			 
			 if(resp.next()){
				 usuR = new Usuario();
				 usuR.setId(resp.getInt("id"));
				 usuR.setLogin(resp.getString("login"));
				 usuR.setNome(resp.getString("nome"));
				 usuR.setSenha(resp.getString("senha"));
				 
				 
			 }
		 }catch(SQLException e){
			 JOptionPane.showMessageDialog(null, "SQL invalido");
		 }
		 
		 return usuR;
	 }
}
