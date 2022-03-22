package ProyectoFinal.ReservesMenjador.dto;

import javax.persistence.*;

@Entity
@Table(name = "producen")
public class Produce_Alergia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_plato")
	private Plato plato;
	
	@ManyToOne
	@JoinColumn(name = "id_alergia")
	private Alergia alergia;
	
	public Produce_Alergia() {
		
	}

	public Produce_Alergia(int id, Plato plato, Alergia alergia) {
		super();
		this.id = id;
		this.plato = plato;
		this.alergia = alergia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}

	public Alergia getAlergia() {
		return alergia;
	}

	public void setAlergia(Alergia alergia) {
		this.alergia = alergia;
	}

	@Override
	public String toString() {
		return "Produce_Alergia [id=" + id + ", plato=" + plato + ", alergia=" + alergia + "]";
	}
	
	
}
