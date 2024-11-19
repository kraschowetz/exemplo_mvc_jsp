package com.kraschowetz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kraschowetz.model.Produto;
import com.kraschowetz.utils.ConnectionFactory;

public class ProdutoDAO {
	Connection connection;
	
	public boolean insert(Produto produto) {
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "INSERT INTO produtos (marca, nome, descricao) values (?, ?, ?);";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, produto.getMarca());
			ps.setString(2, produto.getNome());
			ps.setString(3, produto.getDescricao());
			
			if(ps.executeUpdate() > 0) {
				return true;
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}

		return false;
	}
	
	public ArrayList<Produto> listar() {
		ArrayList<Produto> produtos = new ArrayList<>();
		String sql = "SELECT * FROM produtos;";
		
		try {
			Connection connection = ConnectionFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int idProduto = rs.getInt("id_produto");
				String marca = rs.getString("marca");
				String nome = rs.getString("nome");
				String descricao = rs.getString("descricao");
				
				Produto item = new Produto(idProduto, marca, nome, descricao);
				
				produtos.add(item);
			}
		}
		catch(SQLException ex) { 
			ex.printStackTrace();
		}
		
		return produtos;
		
	}
	
	// java não tem unsigned :(
	public Produto buscarPorID(int id) {
		Produto produto = null;
		String sql = "SELECT * FROM produtos WHERE id_produto = ?;";
		
		try {
			Connection connection = ConnectionFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int idProduto = rs.getInt("id_produto");
				String marca = rs.getString("marca");
				String nome = rs.getString("nome");
				String descricao = rs.getString("descricao");
				
				produto = new Produto(idProduto, marca, nome, descricao);
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return produto;
	}
	
	public boolean atualizar(Produto produto) {
		try {
			String sql = "UPDATE produtos SET nome=?, marca=?, descricao=? WHERE id_produto=?;";
			
			Connection connection = ConnectionFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, produto.getNome());
			ps.setString(2, produto.getMarca());
			ps.setString(3, produto.getDescricao());
			ps.setInt(4, produto.getIdProduto());
			
			if(ps.executeUpdate() > 0) {
				connection.close();
				return true;
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			if(connection != null) {
				try {
					connection.close();
				}
				catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
		
		return false;
	}
	
	public boolean excluir(int id) {
		try {
			String sql = "DELETE FROM produtos WHERE id_produto=?;";
			
			Connection connection = ConnectionFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			if(ps.executeUpdate() > 0) {
				connection.close();
				return true;
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			if(connection != null) {
				try {
					connection.close();
				}
				catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
		
		return false;
	}
}
