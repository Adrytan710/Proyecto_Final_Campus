package ProyectoFinal.ReservesMenjador.dto;

import java.sql.Blob;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "platos")
public class Plato {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nombre;
	@Column
	private Blob foto; ///VERIFICAR SI DE ESTA MANERA SE TRABAJA
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	
	@OneToMany
	@JoinColumn(name = "id")
	private List<Peticion> peticions;
	
	public Plato() {
		
	}

	public Plato(int id, String nombre, Blob foto, Categoria categoria, List<Peticion> peticions) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.foto = foto;
		this.categoria = categoria;
		this.peticions = peticions;
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

	public Blob getFoto() {
		return foto;
	}

	public void setFoto(Blob foto) {
		this.foto = foto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Peticion")
	public List<Peticion> getPeticions() {
		return peticions;
	}

	public void setPeticions(List<Peticion> peticions) {
		this.peticions = peticions;
	}

	@Override
	public String toString() {
		return "Plato [id=" + id + ", nombre=" + nombre + ", foto=" + foto + ", categoria=" + categoria
				+ ", peticions=" + peticions + "]";
	}
	
}
