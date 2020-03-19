package org.martin.jsf.profesor;

import java.util.List;

import org.martin.jsf.materia.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorServiceImpl implements ProfesorService {
	
	@Autowired
	ProfesorRepository profesorRepository;
	
	@Autowired
	MateriaService materiaService;

	@Override
	public List<Profesor> getAll() {
		return profesorRepository.findAll();
	}

	@Override
	public Integer numAlumnos(Long id) {
		return materiaService.numAlumnosPorProfesor(id);
	}
}
