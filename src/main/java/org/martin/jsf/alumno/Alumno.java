package org.martin.jsf.alumno;
// Generated 12/03/2020 05:36:24 PM by Hibernate Tools 5.4.7.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.martin.jsf.materia.Materia;

@Entity
@Table(name="alumno")
public class Alumno implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private String nombre;
	private String sexo;
	private Integer edad;
	private Set<Materia> materias = new HashSet<>(0);

	public Alumno() {
	}

	public Alumno(long id) {
		this.id = id;
	}

	public Alumno(long id, String nombre, String sexo, Integer edad, Set<Materia> materias) {
		this.id = id;
		this.nombre = nombre;
		this.sexo = sexo;
		this.edad = edad;
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

	@Column(name = "sexo", nullable = false, length = 1)
	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Column(name = "edad", nullable = false)
	public Integer getEdad() {
		return this.edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(
        name = "curso", 
        joinColumns = { @JoinColumn(name = "alumno_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "materia_id") }
    )
	public Set<Materia> getMaterias() {
		return this.materias;
	}

	public void setMaterias(Set<Materia> materias) {
		this.materias = materias;
	}
}