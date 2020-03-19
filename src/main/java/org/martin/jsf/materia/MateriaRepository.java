package org.martin.jsf.materia;

import java.util.List;

import org.martin.jsf.alumno.Alumno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {

	@Query("select m.alumnos from #{#entityName} m where m.profesor.id = ?1 ")
	public List<Alumno> alumnosPorProfesor(Long profesorId);
}
