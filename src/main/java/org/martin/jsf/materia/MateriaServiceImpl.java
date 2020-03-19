package org.martin.jsf.materia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MateriaServiceImpl implements MateriaService {
	
	@Autowired
	MateriaRepository materiaRepository;

	@Override
	public Integer numAlumnosPorProfesor(Long idProfesor) {
		return materiaRepository.alumnosPorProfesor(idProfesor).size();
	}

}
