package org.martin.jsf.profesor;
// Generated 12/03/2020 05:36:24 PM by Hibernate Tools 5.4.7.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.martin.jsf.materia.Materia;

@Entity
@Table(name = "profesor")
public class Profesor implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private String nombre;
	private Long cedula;
	private Set<Materia> materias = new HashSet<>(0);

	public Profesor() {
	}

	public Profesor(long id) {
		this.id = id;
	}

	public Profesor(long id, String nombre, Long cedula, Set<Materia> materias) {
		this.id = id;
		this.nombre = nombre;
		this.cedula = cedula;
		this.materias = materias;
	}
	
	@Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "cedula", nullable = false)
	public Long getCedula() {
		return this.cedula;
	}

	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}

	@OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	public Set<Materia> getMaterias() {
		return this.materias;
	}

	public void setMaterias(Set<Materia> materias) {
		this.materias = materias;
	}

}