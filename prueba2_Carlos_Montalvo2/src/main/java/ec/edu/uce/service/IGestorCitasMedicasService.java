package ec.edu.uce.service;

import ec.edu.uce.modelo.jpa.CitaSimple;
import ec.edu.uce.modelo.jpa.Doctor;
import ec.edu.uce.modelo.jpa.Paciente;

public interface IGestorCitasMedicasService {

	void ingresarDoctor (Doctor doc);
	
	void ingresarPaciente(Paciente pc);
	
	void ingresarCitaSimple(CitaSimple cisi);
	
}
