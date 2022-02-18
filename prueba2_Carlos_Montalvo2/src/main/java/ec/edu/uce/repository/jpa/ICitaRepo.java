package ec.edu.uce.repository.jpa;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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
	
	public List<CitaMedica> ReporteCitas(LocalDateTime fechaMin, BigDecimal bigDecimal);
	
}
