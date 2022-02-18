package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import ec.edu.uce.modelo.jpa.CitaMedica;
import ec.edu.uce.modelo.jpa.CitaSimple;

public interface ICitaService {

	void insertCitaSimpleService(CitaSimple citsi);
	
	void InsertarCitaMedicaService(CitaMedica cita);
	
	CitaMedica buscarCitaMedicaService(Integer id);
	
	void ActualizarCitaMedicaService(CitaMedica cita);
	
	void borrarCitaMedicaService(Integer id);
	
	CitaMedica buscarPorNumeroService(Integer num);
	
	public List<CitaMedica> ReporteCitasService(LocalDateTime fechaMin, BigDecimal bigDecimal);
}
