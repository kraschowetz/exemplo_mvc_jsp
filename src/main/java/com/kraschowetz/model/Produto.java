package com.kraschowetz.model;

public class Produto {
	private int idProduto;
	private String marca = "João Kraschowetz";
	private String nome, descricao;

	public Produto() {
		super();
	} 
	
	public Produto(int idProduto, String marca, String nome, String descricao) {
		this.idProduto = idProduto;
		this.marca = marca;
		this.nome = nome;
		this.descricao = descricao;
	}

	// getters & setters :)

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}

