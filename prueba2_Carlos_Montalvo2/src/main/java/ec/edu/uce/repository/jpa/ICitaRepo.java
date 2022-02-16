package ec.edu.uce.repository.jpa;

import ec.edu.uce.modelo.jpa.CitaMedica;
import ec.edu.uce.modelo.jpa.CitaSimple;
import ec.edu.uce.modelo.jpa.Doctor;

public interface ICitaRepo {

	void insertCitaSimple(CitaSimple citsi);
	
	void InsertarCitaMedica(CitaMedica cita);
	
	CitaMedica buscarCitaMedica(Integer id);
	
	void ActualizarCitaMedica(CitaMedica cita);
	
	void borrarCitaMedica(Integer id);
	
	CitaMedica buscarPorNumero(Integer num);
	
}
