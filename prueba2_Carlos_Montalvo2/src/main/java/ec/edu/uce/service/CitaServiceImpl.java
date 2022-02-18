package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.CitaMedica;
import ec.edu.uce.modelo.jpa.CitaSimple;
import ec.edu.uce.repository.jpa.ICitaRepo;

@Service
public class CitaServiceImpl implements ICitaService{

	@Autowired
	private ICitaRepo citaRepo;

	@Override
	public void insertCitaSimpleService(CitaSimple citsi) {
		this.citaRepo.insertCitaSimple(citsi);
	}

	@Override
	public void InsertarCitaMedicaService(CitaMedica cita) {
		this.citaRepo.InsertarCitaMedica(cita);
	}

	@Override
	public CitaMedica buscarCitaMedicaService(Integer id) {
		return this.citaRepo.buscarCitaMedica(id);
	}

	@Override
	public void borrarCitaMedicaService(Integer id) {
		this.citaRepo.borrarCitaMedica(id);
	}

	@Override
	public CitaMedica buscarPorNumeroService(Integer num) {
		return this.citaRepo.buscarPorNumero(num);
	}

	@Override
	public void ActualizarCitaMedicaService(CitaMedica cita) {
		this.citaRepo.ActualizarCitaMedica(cita);
	}

	@Override
	public List<CitaMedica> ReporteCitasService(LocalDateTime fechaMin, BigDecimal bigDecimal) {
		// TODO Auto-generated method stub
		return this.citaRepo.ReporteCitas(fechaMin, bigDecimal);
	}
	
}
