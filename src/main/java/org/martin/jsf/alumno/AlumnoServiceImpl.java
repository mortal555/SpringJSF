package org.martin.jsf.alumno;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.martin.jsf.materia.Materia;
import org.martin.jsf.profesor.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoServiceImpl implements AlumnoService {
	
	private List<Alumno> alumnos;
	
	@Autowired
	AlumnoRepository alumnoRepository;

	@Override
	public List<Alumno> getAll() {
		alumnos = alumnoRepository.findAll();
		return alumnos;
	}

	@Override
	public List<Profesor> getProfesores(long id) {
		List<Profesor> profesores = new ArrayList<>();
		Optional<Alumno> alumnoBuscado = alumnoRepository.findById(id);
		
		if(alumnoBuscado.isPresent()) {
			Alumno alumnoEncontrado = alumnoBuscado.get();
			profesores = alumnoEncontrado.getMaterias().stream().map(Materia::getProfesor).collect(Collectors.toList());
		}

		return profesores;
	}
	
}
