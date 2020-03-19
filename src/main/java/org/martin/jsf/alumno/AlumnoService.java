package org.martin.jsf.alumno;

import java.util.List;

import org.martin.jsf.profesor.Profesor;

public interface AlumnoService {
	public List<Alumno> getAll();
	public List<Profesor> getProfesores(long id);
}
