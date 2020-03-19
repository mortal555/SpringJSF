package org.martin.jsf.profesor;

import java.util.List;

public interface ProfesorService {
	public List<Profesor> getAll();
	public Integer numAlumnos(Long id);
}
