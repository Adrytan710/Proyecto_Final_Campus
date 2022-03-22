package ProyectoFinal.ReservesMenjador.dto;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "roles")
public class Rol {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nombre;
	
	@OneToMany
	@JoinColumn(name = "id")
	private List<Usuario> usuarios;
	
	public Rol() {
		
	}

	public Rol(int id, String nombre, List<Usuario> usuarios) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.usuarios = usuarios;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Usuario")
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", nombre=" + nombre + ", usuarios=" + usuarios
				+ "]";
	}
	
	
}
