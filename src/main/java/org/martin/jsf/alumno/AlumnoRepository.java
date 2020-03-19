package org.martin.jsf.alumno;

import java.util.List;

import org.martin.jsf.materia.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
	
	@Query("select e.materias from #{#entityName} e where e.id=?1")
	public List<Materia> materias(Long id);

}
