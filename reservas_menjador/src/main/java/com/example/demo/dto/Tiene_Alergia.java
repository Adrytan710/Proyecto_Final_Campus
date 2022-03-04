package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tienen")
public class Tiene_Alergia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_usu_tiene;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "id_alergia")
	private Alergia alergia;
	
	public Tiene_Alergia() {
		
	}

	public Tiene_Alergia(int id_usu_tiene, Usuario usuario, Alergia alergia) {
		super();
		this.id_usu_tiene = id_usu_tiene;
		this.usuario = usuario;
		this.alergia = alergia;
	}

	public int getId_usu_tiene() {
		return id_usu_tiene;
	}

	public void setId_usu_tiene(int id_usu_tiene) {
		this.id_usu_tiene = id_usu_tiene;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Alergia getAlergia() {
		return alergia;
	}

	public void setAlergia(Alergia alergia) {
		this.alergia = alergia;
	}

	@Override
	public String toString() {
		return "Tiene_Alergia [id_usu_tiene=" + id_usu_tiene + ", usuario=" + usuario + ", alergia=" + alergia + "]";
	}
}
