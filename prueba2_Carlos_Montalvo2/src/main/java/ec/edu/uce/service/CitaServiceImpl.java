package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.CitaSimple;
import ec.edu.uce.repository.jpa.ICitaMedicaRepo;

@Service
public class CitaServiceImpl implements ICitaService{

	@Autowired
	private ICitaMedicaRepo citaRepo;

	@Override
	public void insertCitaSimpleService(CitaSimple citsi) {
		this.citaRepo.insertCitaSimple(citsi);
	}
	
}
