package org.martin.jsf.materia;
// Generated 12/03/2020 05:36:24 PM by Hibernate Tools 5.4.7.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.martin.jsf.alumno.Alumno;
import org.martin.jsf.profesor.Profesor;

@Entity
@Table(name = "materia")
public class Materia implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private Profesor profesor;
	private String nombre;
	private Set<Alumno> alumnos = new HashSet<>(0);

	public Materia() {
	}

	public Materia(long id, Profesor profesor) {
		this.id = id;
		this.profesor = profesor;
	}

	public Materia(long id, Profesor profesor, String nombre, Set<Alumno> alumnos) {
		this.id = id;
		this.profesor = profesor;
		this.nombre = nombre;
		this.alumnos = alumnos;
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

	@ManyToOne
	@JoinColumn(name = "profesor_id")
	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@ManyToMany(mappedBy = "materias",
			targetEntity = org.martin.jsf.alumno.Alumno.class)
	public Set<Alumno> getAlumnos() {
		return this.alumnos;
	}

	public void setAlumnos(Set<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

}