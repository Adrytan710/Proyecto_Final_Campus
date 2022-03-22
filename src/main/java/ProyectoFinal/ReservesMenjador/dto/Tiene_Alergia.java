package ProyectoFinal.ReservesMenjador.dto;

import javax.persistence.*;

@Entity
@Table(name = "tienen")
public class Tiene_Alergia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "id_alergia")
	private Alergia alergia;
	
	public Tiene_Alergia() {
		
	}

	public Tiene_Alergia(int id, Usuario usuario, Alergia alergia) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.alergia = alergia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "Tiene_Alergia [id=" + id + ", usuario=" + usuario + ", alergia=" + alergia + "]";
	}
}
