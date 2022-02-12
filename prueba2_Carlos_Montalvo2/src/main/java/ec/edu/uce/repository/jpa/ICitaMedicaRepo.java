package ec.edu.uce.repository.jpa;

import ec.edu.uce.modelo.jpa.CitaMedica;
import ec.edu.uce.modelo.jpa.CitaSimple;
import ec.edu.uce.modelo.jpa.Doctor;

public interface ICitaMedicaRepo {

	void insertCitaSimple(CitaSimple citsi);
	
	void ActualizarCita(CitaMedica cita);
	
}
