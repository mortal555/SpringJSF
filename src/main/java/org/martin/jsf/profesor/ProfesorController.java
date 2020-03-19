package org.martin.jsf.profesor;


import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "session")
@Component(value = "profesorController")
public class ProfesorController {
	
	@Autowired
	ProfesorService profesorService;
	
	List<Profesor> profesores;
	Profesor selectedProfesor;
	Integer numAlumnos = 0 ;
	
	@PostConstruct
	public void init() {
		numAlumnos = new Integer(0);
	}
	
//	public String loadTodoPage() {
//        checkPermission();
//        return "/todo.xhtml";
//    }
// 
//    private void checkPermission() {
//        // Details omitted
//    }
    
    public List<Profesor> getProfesores() {
    	return profesorService.getAll();
    }
    
    public String irAlumnos() {
    	return "alumno.xhtml";
    }
    
    public Profesor getSelectedProfesor() {
        return selectedProfesor;
    }
 
    public void setSelectedProfesor(Profesor selectedProfesor) {
        this.selectedProfesor = selectedProfesor;
    }
    public void onRowSelect(SelectEvent event) {
    	setSelectedProfesor((Profesor) event.getObject());
    }

	public Integer getNumAlumnos() {
		if(selectedProfesor == null)
			return new Integer(0);
		return profesorService.numAlumnos(selectedProfesor.getId());
	}

	public void setNumAlumnos(Integer numAlumnos) {
		this.numAlumnos = numAlumnos;
	}
}
