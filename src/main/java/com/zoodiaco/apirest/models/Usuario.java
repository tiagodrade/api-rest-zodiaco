package com.zoodiaco.apirest.models;
import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="tb_usuario", uniqueConstraints={@UniqueConstraint(columnNames={"nome"})})
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String nome;
	
	private int premium;
	
    public long codZodiaco;
    

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPremium() {
		return premium;
	}

	public void setPremium(int premium) {
		this.premium = premium;
	}

	public long getCod_zodiaco() {
		return codZodiaco;
	}

	public void setCod_zodiaco(long cod_zodiaco) {
		this.codZodiaco = cod_zodiaco;
	}



}






	
	
