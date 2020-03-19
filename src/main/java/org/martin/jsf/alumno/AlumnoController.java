package org.martin.jsf.alumno;


import java.util.ArrayList;
import java.util.List;

import org.martin.jsf.profesor.Profesor;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "session")
@Component(value = "alumnoController")
public class AlumnoController {
	
	@Autowired
	private AlumnoService alumnoService;
	
	public List<Alumno> alumnos;
	
	public Alumno selectedAlumno = new Alumno();
	
	public List<Profesor> profesores = new ArrayList<>();
    
    public List<Alumno> getAlumnos() {
    	return alumnoService.getAll();
    }

	public Alumno getSelectedAlumno() {
		return selectedAlumno;
	}

	public void setSelectedAlumno(Alumno selectedAlumno) {
		this.selectedAlumno = selectedAlumno;
	}

	public List<Profesor> getProfesores() {
		return alumnoService.getProfesores(selectedAlumno.getId());
	}

	public void setProfesores(List<Profesor> profesores) {
		if(selectedAlumno.getId() == 0)
		this.profesores = alumnoService.getProfesores(selectedAlumno.getId());
	}
    
	 public void onRowSelect(SelectEvent event) {
		 Alumno a = (Alumno) event.getObject();
		 setSelectedAlumno(a);
	 }
}
