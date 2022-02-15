package ec.edu.uce.service;

import ec.edu.uce.modelo.jpa.CitaMedica;
import ec.edu.uce.modelo.jpa.CitaSimple;

public interface ICitaService {

	void insertCitaSimpleService(CitaSimple citsi);
	
	void InsertarCitaMedicaService(CitaMedica cita);
	
	CitaMedica buscarCitaMedicaService(Integer id);
	
	void ActualizarCitaMedicaService(CitaMedica cita);
	
	void borrarCitaMedicaService(Integer id);
}
